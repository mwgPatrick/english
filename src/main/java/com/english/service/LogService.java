package com.english.service;

import com.english.mapper.LogMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author Mwg
 * @version 1.0
 * @date 2019/5/5 21:05
 */
@Slf4j
@Component
public class LogService {

    @Autowired
    private LogMapper logMapper;

    public void insertLog(int userId,int type,String remark,String remarkTwo,String remarkThree){
        logMapper.insertLog(userId,type,remark,remarkTwo,remarkThree);
    }
}
