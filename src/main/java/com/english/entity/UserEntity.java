package com.english.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author Mwg
 * @Date 2019/4/9 11:06
 * @Version 1.0
 * @Description TODO
 */
@Slf4j
@Data
public class UserEntity {
    private int userId;
    private int questionCount;
    private String completeQuestionId;
    private int readWordCount;
    private int readArticleCount;
    private String readArticleId;
    private String lastLoginTime;
    private int currentGrade;
    private String userSex;
    private String userName;
    private String userAge;

}
