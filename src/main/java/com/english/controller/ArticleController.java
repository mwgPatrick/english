package com.english.controller;

import com.english.entity.ArticleEntity;
import com.english.mapper.ArticleMapper;
import com.english.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * TODO
 * @author Mwg
 * @date 2019/4/5 21:12
 * @version 1.0
 */
@Slf4j
@RestController
public class ArticleController {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private UserService userService;

    /**
     * TODO
     * @author Mwg
     * @date 2019/4/25 21:39
     * @param id
     * @return java.util.LinkedList<java.util.HashMap>
     */
    @RequestMapping("/article/getArticleById")
    public ArticleEntity getArticleById(@RequestParam(value = "id",required = true) int id){
        ArticleEntity articleEntity = articleMapper.getArticleById(id);
        articleEntity.setCreateTime(articleEntity.getCreateTime().replace(".0", ""));
        return articleEntity;
    }

    /**
     * TODO
     * @author Mwg
     * @date 2019/4/29 14:21 
     * @param id
     * @return java.lang.String
     */
    @RequestMapping("/article/getTitleById")
    public String getTitleById(@RequestParam(value = "id", required = true) int id,
                               @RequestParam(value = "userId", required = true) int userId){
        log.info("getTitleById: ArticleId = " + id + ";");
        userService.updateWordCount(userId);
        userService.updateArticleId(id, userId);
        return articleMapper.getTitleById(id).getTitle();
    }

    /**
     * TODO
     * @author Mwg
     * @date 2019/4/29 15:00
     * @param start,end
     * @return java.util.List<com.english.entity.ArticleEntity>
     */
    @RequestMapping("/article/getRangeTitle")
    public List<ArticleEntity> getRangeTitle(@RequestParam(value = "start", required = true) int start,
                                                      @RequestParam(value = "end", required = true) int end){
        List<ArticleEntity> result = articleMapper.getRangeArticle(start, end);
        for(int i = 0; i < end - start; i++){
            result.get(i).setCreateTime(result.get(i).getCreateTime().replace(".0", ""));
        }
        log.info(result.toString());
        return result;

    }


}
