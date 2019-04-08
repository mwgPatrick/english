package com.english.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;

/**
 * @Author Mwg
 * @Date 2019/4/8 18:41
 * @Version 1.0
 * @Description TODO
 */
@Slf4j
@Data
public class TipsEntity {
    private int id;
    private String tip;
}
