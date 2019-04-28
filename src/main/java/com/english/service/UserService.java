package com.english.service;



import com.alibaba.fastjson.JSONObject;
import com.english.controller.ChoiceController;
import com.english.entity.UserEntity;
import com.english.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@Component
public class UserService {
    private static Logger logger = LoggerFactory.getLogger(UserService.class);

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
        System.out.println();
        System.out.println(requestResult);
        // 返回结果解析测试
        JSONObject jsonObject = JSON.parseObject(requestResult);
        // 获取到openId
        String openId = jsonObject.getString("openid");
        System.out.println(openId);

        return openId;
    }


}
