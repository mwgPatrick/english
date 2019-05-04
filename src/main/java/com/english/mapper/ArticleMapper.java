package com.english.mapper;

import com.english.entity.ArticleEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import java.util.List;

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
    @Select("SELECT id,title,create_time,article,word_count,author FROM articles WHERE id = #{id};")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "article", column = "article"),
            @Result(property = "wordCount", column = "word_count"),
            @Result(property = "author", column = "author")
    })
    ArticleEntity getArticleById(int id);

    /**
     * TODO
     * @author Mwg
     * @date 2019/4/5 21:24
     * @param id article id.
     * @return com.english.entity.ArticleEntity
     */
    @Select("SELECT title FROM articles WHERE id = #{id};")
    @Results({
            @Result(property = "title", column = "title")
    })
    ArticleEntity getTitleById(int id);

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

    /**
     * TODO
     * @author Mwg
     * @date 2019/4/29 14:43
     * @param start,end
     * @return java.util.List<com.english.entity.ArticleEntity>
     */
    @Select("SELECT id, title, create_time, author from articles limit #{start}, #{end}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "article", column = "article"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "author", column = "author")
    })
    List<ArticleEntity> getRangeArticle(@Param("start")int start, @Param("end")int end);

}
