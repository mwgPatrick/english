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

    /**
     * Select user information by user id.
     * @author Mwg
     * @date 2019/5/1 14:55
     * @param Id
     * @return com.english.entity.UserEntity
     */
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

    /**
     * Select user information by user's open id.
     * @author Mwg
     * @date 2019/5/1 14:56
     * @param openId
     * @return com.english.entity.UserEntity
     */
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

    /**
     * TODO
     * @author Mwg
     * @date 2019/5/1 14:50
     * @param openId
     * @return int
     */
    @Select("SELECT COUNT(*) FROM user WHERE open_id = #{openId}")
    int countUserByOpenId(String openId);

    /**
     * TODO
     * @author Mwg
     * @date 2019/5/1 14:50
     * @param [userSex, userName, openId, userCity, userProvince]
     * @return void
     */
    @Insert("INSERT INTO user(user_sex, user_name, open_id, user_city, user_province) " +
            "VALUES (#{userSex}, #{userName}, #{openId}, #{userCity}, #{userProvince});")
    void insertUser(@Param("userSex") String userSex,
                    @Param("userName") String userName,
                    @Param("openId") String openId,
                    @Param("userCity") String userCity,
                    @Param("userProvince") String userProvince);

    /**
     * Update last_login_time in database.
     * @author Mwg
     * @date 2019/5/1 14:50
     * @param lastLoginTime
     * @return void
     */
    @Update("UPDATE user SET last_login_time = #{lastLoginTime} WHERE user_id = #{userId}")
    void updateLastTime(@Param("lastLoginTime") String lastLoginTime, @Param("userId") int userId);

    /**
     * Update read_word_count in database.
     * @author Mwg
     * @date 2019/5/1 14:54
     * @param userId
     * @return void
     */
    @Update("UPDATE user SET read_article_count = read_article_count + 1 where user_id = #{userId}")
    void updateArticleCountById(@Param("userId") int userId);

    /**
     * TODO
     * @author Mwg
     * @date 2019/5/3 12:54
     * @param articleId,userId
     * @return void
     */
    @Update("UPDATE user SET read_article_id = #{articleId} where user_id = #{userId}")
    void updateArticleIdByUser(@Param("articleId") String articleId,@Param("userId") int userId);

    /**
     * TODO
     * @author Mwg
     * @date 2019/5/3 12:57
     * @param userId
     * @return java.lang.String
     */
    @Select("SELECT read_article_id FROM user WHERE user_id = #{userId}")
    String getReadArticleId(@Param("userId") int userId);

    @Select("SELECT read_word_count FROM user WHERE user_id = #{userId}")
    int getWordCount(@Param("userId") int userId);

    @Update("UPDATE user SET read_word_count = #{wordCount} WHERE user_id = #{userId}")
    void updateWordCount(@Param("wordCount") int wordCount, @Param("userId") int userId);
}
