package com.english.controller;

import com.english.entity.WordEntity;
import com.english.mapper.WordMapper;
import com.english.service.WordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Mwg
 * @Date 2019/3/6 16:22
 * @Description TODO
 * @Version 1.0
 */
@Slf4j
@RestController
public class WordController {
    @Autowired
    private WordMapper WordMapper;
    
    @Autowired
    private WordService WordService;
    /**
     * @Author Mwg
     * @Date 2019/3/8 13:49
     * @Description TODO
     * @Param [word]
     * @Return com.english.entity.WordEntity
     */
    @RequestMapping("/word/getByWord")
    public WordEntity getByWord(@RequestParam(value = "word", required = true) String word){
        return WordMapper.getByWord(word);
    }

    /**
     * @Author Mwg
     * @Date 2019/3/8 13:49
     * @Description TODO
     * @Param [translation]
     * @Return com.english.entity.WordEntity
     */
    @RequestMapping("/word/getByTranslation")
    public List<WordEntity> getByTranslation(@RequestParam(value = "translation",required = true) String translation){
        return WordMapper.getByTranslation("%" + translation + "%");
    }

    /**
     * @Author Mwg
     * @Date 2019/3/8 13:52
     * @Description TODO
     * @Param [id]
     * @Return com.english.entity.WordEntity
     */
    @RequestMapping("/word/getById")
    public WordEntity getById(@RequestParam(value = "id",required = true) int id){
        return WordMapper.getById(id);
    }

    /**
     * @Author Mwg
     * @Date 2019/3/8 14:16
     * @Description TODO
     * @Param []
     * @Return com.english.entity.WordEntity
     */
    @RequestMapping("/word/getRandomWord")
    public WordEntity getRandomWord(){
        int id = WordService.getRandomId();
        return WordMapper.getById(id);
    }
}
