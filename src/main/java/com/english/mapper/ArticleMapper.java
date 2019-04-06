package com.english.mapper;

import com.english.entity.ArticleEntity;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @Author Mwg
 * @Date 2019/4/5 21:04
 * @Version 1.0
 * @Description TODO
 */
@Component
public interface ArticleMapper {

    /**
     * @Author Mwg
     * @Date 2019/4/5 21:23
     * @Description TODO
     * @Param [id]
     * @Return com.english.entity.ArticleEntity
     */
    @Select("SELECT article,word_count FROM articles WHERE id = #{id};")
    @Results({
            @Result(property = "article", column = "article"),
            @Result(property = "wordCount", column = "word_count")
    })
    ArticleEntity getArticleById(int id);

    /**
     * @Author Mwg
     * @Date 2019/4/5 21:24
     * @Description TODO
     * @Param [id]
     * @Return com.english.entity.ArticleEntity
     */
    @Select("SELECT chinese FROM articles WHERE id = #{id};")
    @Results({
            @Result(property = "chinese", column = "chinese")
    })
    ArticleEntity getChineseById(int id);

    /**
     * @Author Mwg
     * @Date 2019/4/5 21:29
     * @Description TODO
     * @Param [difficult]
     * @Return int
     */
    @Select("SELECT COUNT(*) as count FROM articles WHERE difficult = #{difficult};")
    int getDifficultArticleCount(int difficult);

    /**
     * @Author Mwg
     * @Date 2019/4/5 21:29
     * @Description TODO
     * @Param []
     * @Return int
     */
    @Select("SELECT COUNT(*) as count FROM articles;")
    int getAllArticleCount();

}
