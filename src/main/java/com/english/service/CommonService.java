package com.english.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

/**
 * TODO
 * @author Mwg
 * @date 2019/3/6 16:42
 * @version 1.0
 */
@Slf4j
public class CommonService {

    /**
     * TODO
     * @author Mwg
     * @date 2019/4/25 21:53
     * @param n range.
     * @return int
     */
    public static int getRandom(int n){
        Random rand = new Random();
        log.info("Range:" + n + "Random:" + rand);
        return rand.nextInt(n)+1;
    }

    /**
     * TODO
     * @author Mwg
     * @date 2019/4/25 21:54
     * @param url,params request url,request param
     * @return java.lang.String
     */
    public static String sendPostRequest(String url, MultiValueMap<String, String> params){
        RestTemplate client = new RestTemplate();
        //新建Http头，add方法可以添加参数
        HttpHeaders headers = new HttpHeaders();
        //设置请求发送方式
        HttpMethod method = HttpMethod.POST;
        // 以表单的方式提交
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        //将请求头部和参数合成一个请求
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
        //执行HTTP请求，将返回的结构使用String 类格式化（可设置为对应返回值格式的类）
        ResponseEntity<String> response = client.exchange(url, method, requestEntity,String .class);

        return response.getBody();
    }


    /**
     * TODO
     * @author Mwg
     * @date 2019/4/25 21:54
     * @param url,params,headers request url,request params,request headers
     * @return java.lang.String
     */
    public static String sendGetRequest(String url, MultiValueMap<String, String> params,HttpHeaders headers){
        RestTemplate client = new RestTemplate();

        HttpMethod method = HttpMethod.GET;
        // 以表单的方式提交
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        //将请求头部和参数合成一个请求
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
        //执行HTTP请求，将返回的结构使用String 类格式化
        ResponseEntity<String> response = client.exchange(url, method, requestEntity, String.class);

        return response.getBody();
    }

}
