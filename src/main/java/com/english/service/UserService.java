package com.english.service;


import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;

/**
 * @Author Mwg
 * @Date 2019/4/10 10:21
 * @Version 1.0
 * @Description TODO
 */
@Component
public class UserService {
    public String login(String code){
        String appId = "wx9b2466c9cf8cfaa7";
        String appSecret = "079f42c5f18ac825ac5ee9efc52d57ef";
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appId + "&secret="
                + appSecret + "&js_code=" + code + "&grant_type=authorization_code";
        MultiValueMap<String,String> multiValueMap = new LinkedMultiValueMap<String, String>();
        HttpHeaders httpHeaders = new HttpHeaders();
        String requestResult = CommonService.sendGetRequest(url, multiValueMap, httpHeaders);
        System.out.println();
        System.out.println(requestResult);
        return requestResult;
    }
}
