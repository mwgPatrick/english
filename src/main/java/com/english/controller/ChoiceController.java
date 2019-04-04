package com.english.controller;

import com.english.entity.ChoiceEntity;
import com.english.mapper.ChoiceMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Mwg
 * @Date 2019/4/3 10:35
 * @Version 1.0
 * @Description TODO
 */
@Slf4j
@RestController
public class ChoiceController {
    @Autowired
    private ChoiceMapper choiceMapper;

    /**
     * TODO
     * @Author Mwg
     * @Date 2019/4/3 10:56
     * @Param [id]
     * @Return com.english.entity.ChoiceEntity
     */
    @RequestMapping("/choice/getById")
    public ChoiceEntity getDetailById(@RequestParam(value = "id",required = true) int id){
        return choiceMapper.getDetailById(id);
    }
    
    /**
     * TODO
     * @Author Mwg
     * @Date 2019/4/3 10:58
     * @Param [id]
     * @Return com.english.entity.ChoiceEntity
     */
    @RequestMapping("/choice/getQuestionById")
    public ChoiceEntity getQuestionById(@RequestParam(value = "id",required = true) int id){
        return choiceMapper.getQuestionById(id);
    }
    
    /**
     * @Author Mwg
     * @Date 2019/4/4 11:35
     * @Description TODO
     * @Param [id]
     * @Return java.lang.String
     */
    @RequestMapping("/choice/getAnswerById")
    public String getAnswerById(@RequestParam(value = "id",required = true) int id){
        return choiceMapper.getAnswerById(id);
    }
    
    /**
     * @Author Mwg
     * @Date 2019/4/4 11:35
     * @Description TODO
     * @Param [id]
     * @Return java.lang.String
     */
    @RequestMapping("/choice/getRemarkById")
    public String getRemarkById(@RequestParam(value = "id",required = true) int id){
        return choiceMapper.getRemarkById(id);
    }
}
