package com.english.service;

import java.util.Random;

/**
 * @Author Mwg
 * @Date 2019/3/6 16:42
 * @Description TODO
 * @Version 1.0
 */
public class CommonService {

    public static int getRandom(int n){
        Random rand = new Random();
        return rand.nextInt(n)+1;
    }
}
