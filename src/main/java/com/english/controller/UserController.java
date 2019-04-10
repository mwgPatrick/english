package com.english.controller;

import com.english.entity.UserEntity;
import com.english.mapper.UserMapper;
import com.english.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Mwg
 * @Date 2019/4/9 11:00
 * @Version 1.0
 * @Description TODO
 */
@Slf4j
@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @RequestMapping("/user/getById")
    public UserEntity getById(@RequestParam(value = "id", required = true) int id){
        return userMapper.getUserById(id);
    }

    @RequestMapping("/user/login")
    public String login(@RequestParam(value = "code", required = true) String code){
        return userService.login(code);
    }
}
