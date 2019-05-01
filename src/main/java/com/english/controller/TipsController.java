package com.english.controller;

import com.english.entity.TipsEntity;
import com.english.mapper.TipsMapper;
import com.english.service.CommonService;
import com.english.service.TranslateService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
        log.info("getById: id = " + id);
        return tipsMapper.getById(id);
    }

    /**
     * TODO
     * @author Mwg
     * @date 2019/5/1 15:22
     * @param () no param
     * @return com.english.entity.TipsEntity
     */
    @RequestMapping("/tips/getRandomTip")
    public TipsEntity getRandomTip(){
        log.info("getRandomTip");
        return tipsMapper.getById(CommonService.getRandom(tipsMapper.getTipsCount()));
    }
}
