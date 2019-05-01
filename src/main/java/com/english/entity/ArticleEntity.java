package com.english.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * TODO
 * @author Mwg
 * @date 2019/4/5 21:01
 * @version 1.0
 */
@Data
public class ArticleEntity {
    private int id;
    private String article;
    private String title;
    private int wordCount;
    private int difficult;
    private String createTime;
    private String author;
}
