package com.english.entity;

import lombok.Data;

/**
 * 用户实体类
 * @author Mwg
 * @date 2019/4/9 11:06
 * @version 1.0
 */
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
    private String openId;
    private String userCity;
    private String userProvince;
    private String contactNumber;
    private String contactQq;
    private String contactEmail;

}
