package com.english.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * TODO
 * @author Mwg
 * @date 2019/4/3 10:34
 * @version 1.0
 */
@Data
public class ChoiceEntity {
    private int id;
    private String question;
    private String markA;
    private String markB;
    private String markC;
    private String markD;
    private String correctMark;
    private String remark;
    private int grade;
    private int difficult;
    private String createTime;
}
