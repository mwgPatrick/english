package com.english.controller;

import com.english.entity.ArticleEntity;
import com.english.mapper.ArticleMapper;
import com.english.service.TranslateService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author Mwg
 * @date 2019/4/5 21:12
 * @version 1.0
 * @description TODO
 */
@Slf4j
@RestController
public class ArticleController {
    private static Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private ArticleMapper articleMapper;

    /**
     * TODO
     * @author Mwg
     * @date 2019/4/25 21:39
     * @param [id]
     * @return java.util.LinkedList<java.util.HashMap>
     */
    @RequestMapping("/article/getArticleById")
    public LinkedList<HashMap> getArticleById(@RequestParam(value = "id",required = true) int id){
        ArticleEntity currentEntity = articleMapper.getArticleById(id);
        LinkedList<HashMap> result = new LinkedList<>();
        HashMap hm = new HashMap(2);
        hm.put("article",currentEntity.getArticle());
        hm.put("wordCount",currentEntity.getWordCount());
        result.add(hm);
        return result;
    }

    @RequestMapping("/article/getChineseById")
    public String getChineseById(@RequestParam(value = "id", required = true) int id){
        return articleMapper.getChineseById(id).getChinese();
    }
}
