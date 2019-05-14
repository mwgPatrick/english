package com.english.controller;

import com.alibaba.fastjson.JSONObject;
import com.english.entity.ChoiceEntity;
import com.english.mapper.ChoiceMapper;
import com.english.mapper.LogMapper;
import com.english.mapper.UserMapper;
import com.english.service.CommonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * TODO
 * @author Mwg
 * @date 2019/4/3 10:35
 * @version 1.0
 */
@Slf4j
@RestController
public class ChoiceController {

    @Autowired
    private ChoiceMapper choiceMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private LogMapper logMapper;

    /**
     * TODO
     * @author Mwg
     * @date 2019/4/3 10:56
     * @param id id
     * @return com.english.entity.ChoiceEntity
     */
    @RequestMapping("/choice/getById")
    public ChoiceEntity getDetailById(@RequestParam(value = "id",required = true) int id){
        log.info("ChoiceId: id = " + id);
        ChoiceEntity result =  choiceMapper.getDetailById(id);
        result.setCreateTime(result.getCreateTime().replace(".0",""));
        return result;
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
        log.info("ChoiceId: id = " + id);
        ChoiceEntity result =  choiceMapper.getQuestionById(id);
        result.setCreateTime(result.getCreateTime().replace(".0",""));
        return result;
    }

    /**
     * TODO
     * @author Mwg
     * @date 2019/4/4 11:35
     * @param id id
     * @return java.lang.String
     */
    @RequestMapping("/choice/getAnswerById")
    public String getAnswerById(@RequestParam(value = "id") int id,
                                @RequestParam(value = "select") int select,
                                @RequestParam(value = "userId") int userId){
        log.info("ChoiceId: " + id);
        JSONObject jsonObject = new JSONObject();
        String answer = choiceMapper.getAnswerById(id);
        String remark = choiceMapper.getRemarkById(id);
        jsonObject.put("answer", answer);
        jsonObject.put("remark", remark);
        userMapper.updateQuestionCount(userId);
        int type = 20;
        if(answer.equals(Integer.toString(select))){
            type = 21;
        }
        logMapper.insertLog(userId,type,Integer.toString(id),"0","0");
        return jsonObject.toString();
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

    /**
     * TODO
     * @author Mwg
     * @date 2019/5/4 15:30
     * @param () no param
     * @return com.english.entity.ChoiceEntity
     */
    @RequestMapping("/choice/getRandomChoice")
    public ChoiceEntity getRandomChoice(){
        int randomId = CommonService.getRandom(choiceMapper.getCountChoice());
        log.info("GetRandomChoice: RandomId = " + randomId);
        ChoiceEntity result = choiceMapper.getQuestionById(randomId);
        result.setCreateTime(result.getCreateTime().replace(".0",""));
        return result;
    }

    @RequestMapping("/choice/getErrorList")
    public ChoiceEntity getErrorList(@RequestParam(value = "userId") int userId,
                                           @RequestParam(value = "start") int start){
        return logMapper.getErrorList(userId,CommonService.getMonth(),start);
    }
}
