package com.english.mapper;

import com.english.entity.ArticleEntity;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * TODO
 * @author Mwg
 * @date 2019/4/5 21:04
 * @version 1.0
 */
@Component
public interface ArticleMapper {

    /**
     * TODO
     * @author Mwg
     * @date 2019/4/5 21:23
     * @param id article id.
     * @return com.english.entity.ArticleEntity
     */
    @Select("SELECT article,word_count FROM articles WHERE id = #{id};")
    @Results({
            @Result(property = "article", column = "article"),
            @Result(property = "wordCount", column = "word_count")
    })
    ArticleEntity getArticleById(int id);

    /**
     * TODO
     * @author Mwg
     * @date 2019/4/5 21:24
     * @param id article id.
     * @return com.english.entity.ArticleEntity
     */
    @Select("SELECT chinese FROM articles WHERE id = #{id};")
    @Results({
            @Result(property = "chinese", column = "chinese")
    })
    ArticleEntity getChineseById(int id);

    /**
     * TODO
     * @author Mwg
     * @date 2019/4/5 21:29
     * @param difficult difficult grade.
     * @return int
     */
    @Select("SELECT COUNT(*) as count FROM articles WHERE difficult = #{difficult};")
    int getDifficultArticleCount(int difficult);

    /**
     * TODO
     * @author Mwg
     * @date 2019/4/5 21:29
     * @param () no param
     * @return int
     */
    @Select("SELECT COUNT(*) as count FROM articles;")
    int getAllArticleCount();

}
