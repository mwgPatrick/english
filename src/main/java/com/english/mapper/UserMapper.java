package com.english.mapper;

import com.english.entity.UserEntity;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @Author Mwg
 * @Date 2019/4/9 11:08
 * @Version 1.0
 * @Description TODO
 */
@Component
public interface UserMapper {
    @Select("SELECT * FROM user WHERE user_id = #{id}")
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "questionCount", column = "question_count"),
            @Result(property = "completeQuestionId", column = "complete_question"),
            @Result(property = "readWordCount", column = "read_word_count"),
            @Result(property = "readArticleCount", column = "read_article_count"),
            @Result(property = "readArticleId", column = "read_article_id"),
            @Result(property = "lastLoinTime", column = "last_login_time"),
            @Result(property = "currentGrade", column = "current_grade"),
            @Result(property = "userSex", column = "user_sex"),
            @Result(property = "userAge", column = "user_age")
    })
    UserEntity getUserById(int id);
}
