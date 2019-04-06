package com.english.controller;

import com.english.entity.ArticleEntity;
import com.english.mapper.ArticleMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.LinkedList;

/**
 * @Author Mwg
 * @Date 2019/4/5 21:12
 * @Version 1.0
 * @Description TODO
 */
@Slf4j
@RestController
public class ArticleController {
    @Autowired
    private ArticleMapper articleMapper;

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
