package com.english.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author Mwg
 * @Date 2019/3/6 16:01
 * @Description TODO
 * @Version 1.0
 */
@Slf4j
@Data
public class WordEntity {
    private int id;
    private String word;
    private String translation;
}
