package com.english.mapper;

import com.english.entity.UserEntity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

/**
 * UserMapper
 * @author Mwg
 * @date 2019/4/9 11:08
 * @version 1.0
 */
@Component
public interface UserMapper {

    /**
     * 根据用户id查询用户信息。
     * @author Mwg
     * @date 2019/5/1 14:55
     * @param id 用户在数据库中id
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
            @Result(property = "userProvince", column = "user_province"),
            @Result(property = "contactNumber", column = "contact_number"),
            @Result(property = "contactQq", column = "contact_qq"),
            @Result(property = "contactEmail", column = "contact_email")
    })
    UserEntity getUserById(int id);

    /**
     * 根据用户的OpenId查询用户信息。
     * @author Mwg
     * @date 2019/5/1 14:56
     * @param openId 用户在微信平台的唯一标识openid
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
            @Result(property = "userProvince", column = "user_province"),
            @Result(property = "contactNumber", column = "contact_number"),
            @Result(property = "contactQq", column = "contact_qq"),
            @Result(property = "contactEmail", column = "contact_email")
    })
    UserEntity getUserByOpenId(String openId);

    /**
     * 根据用户OpenId查询用户是否注册过（数量为1则存在，数量为0不存在）。
     * @author Mwg
     * @date 2019/5/1 14:50
     * @param openId 用户在微信平台的唯一标识openid
     * @return int
     */
    @Select("SELECT COUNT(*) FROM user WHERE open_id = #{openId}")
    int countUserByOpenId(String openId);

    /**
     * 使用用户性别，用户昵称，用户的OpenId，用户所在城市，用户所在省份新注册一个用户。
     * @author Mwg
     * @date 2019/5/1 14:50
     * @param userSex 用户性别
     * @param userName 用户昵称
     * @param openId 用户的OpenId
     * @param userCity 用户所在城市
     * @param userProvince 用户所在省份
     */
    @Insert("INSERT INTO user(user_sex, user_name, open_id, user_city, user_province) " +
            "VALUES (#{userSex}, #{userName}, #{openId}, #{userCity}, #{userProvince});")
    void insertUser(@Param("userSex") String userSex,
                    @Param("userName") String userName,
                    @Param("openId") String openId,
                    @Param("userCity") String userCity,
                    @Param("userProvince") String userProvince);

    /**
     * 根据用户id更新数据库中用户表的上次登录时间。
     * @author Mwg
     * @date 2019/5/1 14:50
     * @param lastLoginTime 用户的本次登录时间
     * @param userId 用户Id
     */
    @Update("UPDATE user SET last_login_time = #{lastLoginTime} WHERE user_id = #{userId}")
    void updateLastTime(@Param("lastLoginTime") String lastLoginTime, @Param("userId") int userId);

    /**
     * 根据用户id使该用户的已读文章数加一。
     * @author Mwg
     * @date 2019/5/1 14:54
     * @param userId 用户id
     */
    @Update("UPDATE user SET read_article_count = read_article_count + 1 where user_id = #{userId}")
    void updateArticleCountById(@Param("userId") int userId);

    /**
     * 根据用户id更新用户已读文章的编号。
     * @author Mwg
     * @date 2019/5/3 12:54
     * @param articleId 文章id
     * @param userId 用户id
     */
    @Update("UPDATE user SET read_article_id = #{articleId} where user_id = #{userId}")
    void updateArticleIdByUser(@Param("articleId") String articleId,@Param("userId") int userId);

    /**
     * 根据用户id查询用户已阅读的文章编号。
     * @author Mwg
     * @date 2019/5/3 12:57
     * @param userId 用户id
     * @return java.lang.String
     */
    @Select("SELECT read_article_id FROM user WHERE user_id = #{userId}")
    String getReadArticleId(@Param("userId") int userId);

    /**
     * 根据用户id查询用户已读的单词数量。
     * @author Mwg
     * @date 2019/5/8 12:21
     * @param userId 用户id
     * @return int
     */
    @Select("SELECT read_word_count FROM user WHERE user_id = #{userId}")
    int getWordCount(@Param("userId") int userId);

    /**
     * 根据用户id更新用户的已读单词数
     * @author Mwg
     * @date 2019/5/8 12:25
     * @param wordCount 已读单词数
     * @param userId 用户id
     */
    @Update("UPDATE user SET read_word_count = #{wordCount} WHERE user_id = #{userId}")
    void updateWordCount(@Param("wordCount") int wordCount, @Param("userId") int userId);

    /**
     * 根据用户id更新用户已做题数
     * @author Mwg
     * @date 2019/5/8 12:28
     * @param userId 用户id
     */
    @Update("UPDATE user SET question_count = question_count + 1 where user_id = #{userId}")
    void updateQuestionCount(@Param("userId") int userId);

    /**
     * 更新用户信息
     * @author Mwg
     * @date 2019/5/8 12:22
     * @param userName 用户昵称
     * @param userSex 用户性别
     * @param currentGrade 用户所属难度等级
     * @param contactNumber 用户联系电话
     * @param contactQq 用户联系qq
     * @param contactEmail 用户联系邮箱
     * @param userId 用户id
     */
    @Update("UPDATE user SET user_name = #{userName},user_sex = #{userSex}, current_grade = #{currentGrade}," +
            " contact_number = #{contactNumber}, contact_qq = #{contactQq}, contact_email = #{contactEmail} where user_id = #{userId}")
    void updateUserInfo(@Param("userName") String userName, @Param("userSex") String userSex,
                        @Param("currentGrade") String currentGrade, @Param("contactNumber") String contactNumber,
                        @Param("contactQq") String contactQq, @Param("contactEmail") String contactEmail,
                        @Param("userId") int userId);
}
