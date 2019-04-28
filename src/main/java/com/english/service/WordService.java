package com.english.service;

import com.english.controller.ChoiceController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static Logger logger = LoggerFactory.getLogger(WordService.class);

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
