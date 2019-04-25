package com.english.controller;

import com.english.entity.ChoiceEntity;
import com.english.mapper.ChoiceMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mwg
 * @date 2019/4/3 10:35
 * @version 1.0
 * @description TODO
 */
@Slf4j
@RestController
public class ChoiceController {
    @Autowired
    private ChoiceMapper choiceMapper;

    /**
     * TODO
     * @author Mwg
     * @date 2019/4/3 10:56
     * @param id id
     * @return com.english.entity.ChoiceEntity
     */
    @RequestMapping("/choice/getById")
    public ChoiceEntity getDetailById(@RequestParam(value = "id",required = true) int id){
        return choiceMapper.getDetailById(id);
    }
    
    /**
     * TODO
     * @author Mwg
     * @date 2019/4/3 10:58
     * @param id id
     * @return com.english.entity.ChoiceEntity
     */
    @RequestMapping("/choice/getQuestionById")
    public ChoiceEntity getQuestionById(@RequestParam(value = "id",required = true) int id){
        return choiceMapper.getQuestionById(id);
    }

    /**
     * TODO
     * @author Mwg
     * @date 2019/4/4 11:35
     * @param id id
     * @return java.lang.String
     */
    @RequestMapping("/choice/getAnswerById")
    public String getAnswerById(@RequestParam(value = "id",required = true) int id){
        return choiceMapper.getAnswerById(id);
    }

    /**
     * TODO
     * @author Mwg
     * @date 2019/4/4 11:35
     * @param id id
     * @return java.lang.String
     */
    @RequestMapping("/choice/getRemarkById")
    public String getRemarkById(@RequestParam(value = "id",required = true) int id){
        return choiceMapper.getRemarkById(id);
    }
}
