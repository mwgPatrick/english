package com.english.mapper;

import com.english.entity.WordEntity;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * TODO
 * @author Mwg
 * @date 2019/3/6 16:04
 * @version 1.0
 */
@Component
public interface WordMapper {
    /**
     * TODO
     * @author Mwg
     * @date 2019/3/8 14:05
     * @param word English
     * @return com.english.entity.WordEntity
     */
    @Select("SELECT * FROM enwords WHERE word = #{word};")
    @Results({
            @Result(property = "word", column = "word"),
            @Result(property = "translation",column = "translation"),
            @Result(property = "id", column = "id")
    })
    WordEntity getByWord(String word);

    /**
     * TODO
     * @author Mwg
     * @date 2019/3/8 14:06
     * @param translation Chinese
     * @return com.english.entity.WordEntity
     */
    @Select("SELECT * FROM enwords WHERE translation like '%#{translation}%';")
    @Results({
            @Result(property = "word", column = "word"),
            @Result(property = "translation",column = "translation"),
            @Result(property = "id", column = "id")
    })
    List<WordEntity> getByTranslation(String translation);

    /**
     * TODO
     * @author Mwg
     * @date 2019/3/25 18:47
     * @param id Primary key
     * @return com.english.entity.WordEntity
     */
    @Select("SELECT * FROM enwords WHERE id = #{id};")
    @Results({
            @Result(property = "word", column = "word"),
            @Result(property = "translation", column = "translation"),
            @Result(property = "id", column = "id")
    })
    WordEntity getById(int id);

    /**
     * TODO
     * @author Mwg
     * @date 2019/3/25 18:47
     * @param () no param
     * @return int
     */
    @Select("SELECT COUNT(*) AS count FROM enwords;")
    @Results({
            @Result(column = "count")
    })
    int getCount();
}
