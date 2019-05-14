package com.english.mapper;

import com.english.entity.ChoiceEntity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * TODO
 *
 * @author Mwg
 * @version 1.0
 * @date 2019/5/5 19:13
 */
@Component
public interface LogMapper {

    @Insert("insert into log(user_id,type,remark,remark_two,remark_three) value(#{userId},#{type},#{remark},#{remarkTwo},#{remarkThree})")
    void insertLog(@Param("userId") int userId,
                   @Param("type") int type,
                   @Param("remark") String remark,
                   @Param("remarkTwo") String remarkTwo,
                   @Param("remarkThree") String remarkThree);

    @Select("SELECT COUNT(distinct remark) as countArticle FROM  log where user_id = #{userId} and type = 11 and time like #{month};")
    int getCountArticle(@Param("userId") int userId, @Param("month") String month);

    @Select("select IFNULL(sum(remark_two),0) as sumReadWord from log where user_id = #{userId} and type = 11 and time like #{month};")
    int getSumReadWord(@Param("userId") int userId, @Param("month") String month);

    @Select("select IFNULL(avg(remark_three),0) as avgReadTime from log where user_id = #{userId} and type = 11 and time like #{month};")
    int getAvgReadTime(@Param("userId") int userId, @Param("month") String month);

    @Select("select IFNULL(sum(remark_three),0) as sumReadTime from log where user_id = #{userId} and type = 11 and time like #{month};")
    int getsumReadTime(@Param("userId") int userId, @Param("month") String month);

    @Select("select count(remark) as countQuestion from log where user_id = #{userId} and type like '2%' and time like #{month};")
    int getCountQusetion(@Param("userId") int userId, @Param("month") String month);

    @Select("select count(remark) as countRight from log where user_id = #{userId} and type = 21 and time like #{month};")
    int getCountRight(@Param("userId") int userId, @Param("month") String month);

    @Select("select count(remark) as countError from log where user_id = #{userId} and type = 20 and time like #{month};")
    int getCountError(@Param("userId") int userId, @Param("month") String month);

    @Select("select count(distinct remark) as wordSearch from log where user_id = #{userId} and type = 60 and time like #{month};")
    int getWordSearch(@Param("userId") int userId, @Param("month") String month);

    @Select("select sum(count) as error_twice from  view_test where count = 2 and user_id = #{userId} and time like #{month};")
    int getErrorTwice(@Param("userId") int userId, @Param("month") String month);

    @Select("select sum(count) as error_once from  view_test where count = 1 and user_id = #{userId} and time like #{month};")
    int getErrorOnce(@Param("userId") int userId, @Param("month") String month);

    @Select("select sum(count) as error_much from  view_test where count >= 3 and user_id = #{userId} and time like #{month};")
    int getErrorMuch(@Param("userId") int userId, @Param("month") String month);

    @Select("select question,mark_a,mark_b,mark_c,mark_d,answer from choice where id in" +
            " (select remark as id from view_test where count >= 3 and user_id = #{userId} and time like #{month}) limit #{start},1")
    @Results({
            @Result(property = "question", column = "question"),
            @Result(property = "markA", column = "mark_a"),
            @Result(property = "markB", column = "mark_b"),
            @Result(property = "markC", column = "mark_c"),
            @Result(property = "markD", column = "mark_d"),
            @Result(property = "correctMark", column = "answer")
    })
    ChoiceEntity getErrorList(@Param("userId") int userId, @Param("month") String month, @Param("start") int start);
}
