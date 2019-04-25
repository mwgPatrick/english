package com.english.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * TODO
 * @author Mwg
 * @date 2019/4/5 21:01
 * @version 1.0
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
