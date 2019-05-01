package com.english.service;

import com.english.controller.ChoiceController;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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
        log.info("WordCount: " + randomId);
        return CommonService.getRandom(randomId);
    }


}
