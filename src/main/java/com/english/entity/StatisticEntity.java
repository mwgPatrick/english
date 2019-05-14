package com.english.entity;

import lombok.Data;

/**
 * TODO
 *
 * @author Mwg
 * @version 1.0
 * @date 2019/5/5 20:57
 */
@Data
public class StatisticEntity {
    private int userId;
    private int countArticle;
    private int sumReadWord;
    private int avgReadTime;
    private int sumReadTime;
    private int countQues;
    private int countRight;
    private int countError;
    private String rightRate;
    private int wordSearch;
    private int errorOnce;
    private int errorTwice;
    private int errorMuch;
}
