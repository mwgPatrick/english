package com.english.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.english.entity.ChoiceEntity;
import com.english.mapper.ChoiceMapper;
import com.english.mapper.UserMapper;
import com.english.service.CommonService;
import com.english.service.TranslateService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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

    @Autowired
    private UserMapper userMapper;

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
    public String getAnswerById(@RequestParam(value = "id",required = true) int id,
                                @RequestParam(value = "select",required = true) int select,
                                @RequestParam(value = "userId") int userId){
        log.info("ChoiceId: " + id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("answer",choiceMapper.getAnswerById(id));
        jsonObject.put("remark", choiceMapper.getRemarkById(id));
        userMapper.updateQuestionCount(userId);
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
}
