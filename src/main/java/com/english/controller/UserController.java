package com.english.controller;

import com.english.entity.UserEntity;
import com.english.mapper.UserMapper;
import com.english.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TODO
 * @author Mwg
 * @date 2019/4/9 11:00
 * @version 1.0
 */
@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    /**
     * TODO
     * @author Mwg
     * @date 2019/4/25 21:43
     * @param id user-id
     * @return com.english.entity.UserEntity
     */
    @RequestMapping("/user/getById")
    public UserEntity getById(@RequestParam(value = "id", required = true) int id){
        log.info("userId:" + id);
        return userMapper.getUserById(id);
    }

    /**
     * TODO
     * @author Mwg
     * @date 2019/4/25 21:43
     * @param code,userName,userSex,userCity,userProvince user-code,userName,userSex,userCity,userProvince
     * @return com.english.entity.UserEntity
     */
    @RequestMapping("/user/login")
    public UserEntity login(@RequestParam(value = "code", required = true) String code,
                     @RequestParam(value = "userName", required = true) String userName,
                     @RequestParam(value = "userSex", required = true) String userSex,
                     @RequestParam(value = "userCity", required = true) String userCity,
                     @RequestParam(value = "userProvince", required = true) String userProvince
                            ){
        log.info("code = [" + code + "], userName = [" + userName + "], userSex = ["
                + userSex + "], userCity = [" + userCity + "], userProvince = [" + userProvince + "]");
        String openId = userService.getOpenId(code);
        int countOpenId = userMapper.countUserByOpenId(openId);
        if(countOpenId == 0){
            userMapper.insertUser(userSex, userName, openId, userCity, userProvince);
        }
        UserEntity result =  userMapper.getUserByOpenId(openId);
        // 设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        userMapper.updateLastTime(df.format(new Date()),result.getUserId());
        log.info("Result: " + result.toString());
        result.setOpenId(Integer.toString(countOpenId));
        return result;
    }
}
