package com.english.mapper;

import com.english.entity.WordEntity;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author Mwg
 * @Date 2019/3/6 16:04
 * @Description TODO
 * @Version 1.0
 */
@Component
public interface WordMapper {
    /**
     * @Author Mwg
     * @Date 2019/3/8 14:05
     * @Description TODO
     * @Param [word]
     * @Return com.english.entity.WordEntity
     */
    @Select("SELECT * FROM enwords WHERE word = #{word};")
    @Results({
            @Result(property = "word", column = "word"),
            @Result(property = "translation",column = "translation"),
            @Result(property = "id", column = "id")
    })
    WordEntity getByWord(String word);

    /**
     * @Author Mwg
     * @Date 2019/3/8 14:06
     * @Description TODO
     * @Param [translation]
     * @Return com.english.entity.WordEntity
     */
    @Select("SELECT * FROM enwords WHERE translation like '%#{translation}%';")
    @Results({
            @Result(property = "word", column = "word"),
            @Result(property = "translation",column = "translation"),
            @Result(property = "id", column = "id")
    })
    List<WordEntity> getByTranslation(String translation);

    /**
     * @Author Mwg
     * @Date 2019/3/8 14:06
     * @Description TODO
     * @Param [id]
     * @Return com.english.entity.WordEntity
     */
    @Select("SELECT * FROM enwords WHERE id = #{id};")
    @Results({
            @Result(property = "word", column = "word"),
            @Result(property = "translation", column = "translation"),
            @Result(property = "id", column = "id")
    })
    WordEntity getById(int id);

    /**
     * @Author Mwg
     * @Date 2019/3/8 14:10
     * @Description TODO
     * @Param []
     * @Return int
     */
    @Select("SELECT COUNT(*) AS count FROM enwords;")
    @Results({
            @Result(column = "count")
    })
    int getCount();
}
