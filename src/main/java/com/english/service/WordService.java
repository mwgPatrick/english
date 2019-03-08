package com.english.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.english.mapper.WordMapper;
import org.springframework.stereotype.Component;

/**
 * @Author Mwg
 * @Date 2019/3/6 16:42
 * @Description TODO
 * @Version 1.0
 */
@Component
public class WordService {
    @Autowired
    private WordMapper WordMapper;

    public  int getRandomId(){
        int randomId = WordMapper.getCount();
        return CommonService.getRandom(randomId);
    }


}
