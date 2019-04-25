package com.english.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.english.mapper.WordMapper;
import org.springframework.stereotype.Component;

/**
 * TODO
 * @author Mwg
 * @date 2019/3/6 16:42
 * @version 1.0
 */
@Component
public class WordService {
    @Autowired
    private WordMapper WordMapper;

    /**
     * TODO
     * @author Mwg
     * @date 2019/4/25 21:55
     * @param () no param
     * @return int
     */
    public  int getRandomId(){
        int randomId = WordMapper.getCount();
        return CommonService.getRandom(randomId);
    }


}
