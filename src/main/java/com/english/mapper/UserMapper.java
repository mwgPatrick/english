package com.english.mapper;

import com.english.entity.UserEntity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

/**
 * TODO
 * @author Mwg
 * @date 2019/4/9 11:08
 * @version 1.0
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
            @Result(property = "lastLoginTime", column = "last_login_time"),
            @Result(property = "currentGrade", column = "current_grade"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "userSex", column = "user_sex"),
            @Result(property = "openId", column = "open_id"),
            @Result(property = "userCity", column = "user_city"),
            @Result(property = "userProvince", column = "user_province")
    })
    UserEntity getUserById(int Id);

    @Select("SELECT * FROM user WHERE open_id = #{openId}")
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "questionCount", column = "question_count"),
            @Result(property = "completeQuestionId", column = "complete_question"),
            @Result(property = "readWordCount", column = "read_word_count"),
            @Result(property = "readArticleCount", column = "read_article_count"),
            @Result(property = "readArticleId", column = "read_article_id"),
            @Result(property = "lastLoginTime", column = "last_login_time"),
            @Result(property = "currentGrade", column = "current_grade"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "userSex", column = "user_sex"),
            @Result(property = "openId", column = "open_id"),
            @Result(property = "userCity", column = "user_city"),
            @Result(property = "userProvince", column = "user_province")
    })
    UserEntity getUserByOpenId(String openId);

    @Select("SELECT COUNT(*) FROM user WHERE open_id = #{openId}")
    int countUserByOpenId(String openId);

    @Insert("INSERT INTO user(user_sex, user_name, open_id, user_city, user_province) " +
            "VALUES (#{userSex}, #{userName}, #{openId}, #{userCity}, #{userProvince});")
    void insertUser(@Param("userSex") String userSex,
                    @Param("userName") String userName,
                    @Param("openId") String openId,
                    @Param("userCity") String userCity,
                    @Param("userProvince") String userProvince);

    @Update("UPDATE user SET last_login_time = #{lastLoginTime}")
    void updateLastTime(@Param("lastLoginTime") String lastLoginTime);
}
