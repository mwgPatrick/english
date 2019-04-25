package com.english.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;

/**
 * TODO
 * @author Mwg
 * @date 2019/4/8 18:41
 * @version 1.0
 */
@Slf4j
@Data
public class TipsEntity {
    private int id;
    private String tip;
}
