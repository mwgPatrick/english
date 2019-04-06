package com.english.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author Mwg
 * @Date 2019/4/5 21:01
 * @Version 1.0
 * @Description TODO
 */
@Slf4j
@Data
public class ArticleEntity {
    private int id;
    private String article;
    private String chinese;
    private int wordCount;
    private int difficult;
}
