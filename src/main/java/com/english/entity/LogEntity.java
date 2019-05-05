package com.english.entity;

import lombok.Data;

/**
 * TODO
 *
 * @author Mwg
 * @version 1.0
 * @date 2019/5/5 19:11
 */
@Data
public class LogEntity {
    private int id;
    private int userId;
    private String time;
    private String type;
    private String remark;
    private String remarkTwo;
    private String remarkThree;
}
