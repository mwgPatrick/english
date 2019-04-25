package com.english.controller;

import com.english.entity.WordEntity;
import com.english.mapper.WordMapper;
import com.english.service.WordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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
    /**
     * TODO
     * @author Mwg
     * @date 2019/3/8 13:49
     * @param word word in English
     * @return com.english.entity.WordEntity
     */
    @RequestMapping("/word/getByWord")
    public WordEntity getByWord(@RequestParam(value = "word", required = true) String word){
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
        return WordMapper.getById(id);
    }

    /**
     * TODO
     * @author Mwg
     * @date 2019/3/8 14:16
     * @param ()  no param
     * @return com.english.entity.WordEntity
     */
    @RequestMapping("/word/getRandomWord")
    public WordEntity getRandomWord(){
        int id = WordService.getRandomId();
        return WordMapper.getById(id);
    }


}
