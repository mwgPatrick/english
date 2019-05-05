package com.english.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
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
    void insertLog(@Param("userId") int userId, @Param("type") int type,
                   @Param("remark") String remark, @Param("remarkTwo") String remarkTwo,
                   @Param("remarkThree") String remarkThree);



}
