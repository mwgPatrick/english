package com.english.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

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

    @Select("SELECT COUNT(distinct remark) as countArticle FROM  log where id = #{userId} and type = 11 and time like #{month};")
    int getCountArticle(@Param("userId") int userId, @Param("month") String month);

    @Select("select sum(remark2) as sumReadWord from log where id = #{userId} and type = 11 and time like '#{month}';")
    int getSumReadWord(@Param("userId") int userId, @Param("month") String month);

    @Select("select avg(remark3) as avgReadTime from log where id = #{userId} and type = 11 and time like #{month};")
    int getAvgReadTime(@Param("userId") int userId, @Param("month") String month);

    @Select("select sum(remark3) as sumReadTime from log where id = #{userId} and type = 11 and time like #{month};")
    int getsumReadTime(@Param("userId") int userId, @Param("month") String month);

    @Select("select count(distinct remark) as countQuestion from log where id = #{userId} and type like '2%' and time like #{month};")
    int getCountQusetion(@Param("userId") int userId, @Param("month") String month);

    @Select("select count(distinct remark) as countRight from log where id = #{userId} and type = 21 and time like #{month};")
    int getCountRight(@Param("userId") int userId, @Param("month") String month);

    @Select("select count(distinct remark) as countError from log where id = #{userId} and type = 20 and time like #{month};")
    int getCountError(@Param("userId") int userId, @Param("month") String month);

    @Select("select count(distinct remark) as wordSearch from log where id = #{userId} and type = 60 and time like #{month};")
    int getWordSearch(@Param("userId") int userId, @Param("month") String month);
}
