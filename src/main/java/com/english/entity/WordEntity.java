package com.english.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * TODO
 * @author Mwg
 * @date 2019/3/6 16:01
 * @version 1.0
 */
@Data
public class WordEntity {
    private int id;
    private String word;
    private String translation;
}
