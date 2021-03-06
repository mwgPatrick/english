package com.english.controller;

import com.english.entity.WordEntity;
import com.english.mapper.LogMapper;
import com.english.mapper.WordMapper;
import com.english.service.TranslateService;
import com.english.service.WordService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO
 * @author Mwg
 * @date 2019/3/6 16:22
 * @version 1.0
 */
@Slf4j
@RestController
public class WordController {

    @Autowired
    private WordMapper WordMapper;

    @Autowired
    private WordService WordService;

    @Autowired
    private LogMapper logMapper;

    /**
     * TODO
     * @author Mwg
     * @date 2019/3/8 13:49
     * @param word word in English
     * @return Java.lang.String
     */
    @RequestMapping("/word/getByWord")
    public String getByWord(@RequestParam(value = "userId") int userId,
                            @RequestParam(value = "word") String word) throws IOException{
        log.info("Word: " + word);
        logMapper.insertLog(userId,60,word,"0","0");
        return TranslateService.getTranslateResult(word);
    }

    /**
     * TODO
     * @author Mwg
     * @date 2019/4/28 18:32
     * @param word
     * @return com.english.entity.WordEntity
     */
    @RequestMapping("/word/getWordByDB")
    public WordEntity getWordByDB(@RequestParam(value = "word", required = true) String word){
        log.info("Word: " + word);
        return WordMapper.getByWord(word);

    }

    /**
     * TODO
     * @author Mwg
     * @date 2019/3/8 13:49
     * @param translation chinese
     * @return com.english.entity.WordEntity
     */
    @RequestMapping("/word/getByTranslation")
    public List<WordEntity> getByTranslation(@RequestParam(value = "translation",required = true) String translation){
        log.info("Translation: " + translation);
        return WordMapper.getByTranslation("%" + translation + "%");
    }

    /**
     * TODO
     * @author Mwg
     * @date 2019/3/8 13:52
     * @param id word-id
     * @return com.english.entity.WordEntity
     */
    @RequestMapping("/word/getById")
    public WordEntity getById(@RequestParam(value = "id",required = true) int id){
        log.info("Id :" + id);
        return WordMapper.getById(id);
    }

    /**
     * Get five random words.
     * @author Mwg
     * @date 2019/3/8 14:16
     * @param ()  no param
     * @return com.english.entity.WordEntity
     */
    @RequestMapping("/word/getRandomWord")
    public List<WordEntity> getRandomWord(){
        List<WordEntity> result = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            int id = WordService.getRandomId();
            result.add(WordMapper.getById(id));
        }
        return result;
    }


}
