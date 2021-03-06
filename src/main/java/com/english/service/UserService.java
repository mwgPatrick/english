package com.english.service;



import com.alibaba.fastjson.JSONObject;
import com.english.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import com.alibaba.fastjson.JSON;

/**
 * TODO
 * @author Mwg
 * @date 2019/4/10 10:21
 * @version 1.0
 */
@Slf4j
@Component
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 验证用户是否注册过，如果注册过，直接读取用户信息，否则在数据库中新建用户信息。
     * @author Mwg
     * @date 2019/4/25 14:51
     * @param code user-code
     * @return java.lang.String
     */
    public String getOpenId(String code){
        String appId = "wx9b2466c9cf8cfaa7";
        String appSecret = "079f42c5f18ac825ac5ee9efc52d57ef";
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appId + "&secret="
                + appSecret + "&js_code=" + code + "&grant_type=authorization_code";
        MultiValueMap<String,String> multiValueMap = new LinkedMultiValueMap<>();
        HttpHeaders httpHeaders = new HttpHeaders();
        String requestResult = CommonService.sendGetRequest(url, multiValueMap, httpHeaders);
        // 返回结果解析测试
        JSONObject jsonObject = JSON.parseObject(requestResult);
        // 获取到openId
        String openId = jsonObject.getString("openid");
        log.info(requestResult);
        log.info(openId);
        return openId;
    }

    /**
     * TODO
     * @author Mwg
     * @date 2019/5/1 15:07
     * @param userId
     * @return void
     */
    public void updateWordCount(int wordCount, int articleId,int userId){
        log.info("UpdateWordCount: WordCount:" + wordCount + "; ArticleId = " +articleId + ";UserId = " + userId);
        String readArticle = userMapper.getReadArticleId(userId);
        int readWord = userMapper.getWordCount(userId);
        if("".equals(readArticle)||readArticle==null){
            readWord = readWord + wordCount;
            readArticle = Integer.toString(articleId);
            userMapper.updateArticleCountById(userId);
        }
        else {
            if(!readArticle.contains(Integer.toString(articleId))){
                readArticle = readArticle + "," + articleId;
                readWord = readWord + wordCount;
                userMapper.updateArticleCountById(userId);
            }
        }
        userMapper.updateWordCount(readWord, userId);
        userMapper.updateArticleIdByUser(readArticle, userId);
    }






}
