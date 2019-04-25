package com.english.controller;

import com.english.entity.TipsEntity;
import com.english.mapper.TipsMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mwg
 * @date 2019/4/8 18:44
 * @version 1.0
 * @description TODO
 */
@Slf4j
@RestController
public class TipsController {
    @Autowired
    TipsMapper tipsMapper;

    /**
     * TODO
     * @author Mwg
     * @date 2019/4/25 21:42
     * @param id tips-id
     * @return com.english.entity.TipsEntity
     */
    @RequestMapping("/tips/getById")
    public TipsEntity getById(@RequestParam(value = "id", required = true) int id){
        return tipsMapper.getById(id);
    }
}
