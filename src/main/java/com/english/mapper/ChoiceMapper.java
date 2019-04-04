package com.english.mapper;

import com.english.entity.ChoiceEntity;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @Author Mwg
 * @Date 2019/4/3 10:34
 * @Version 1.0
 * @Description TODO
 */
@Component
public interface ChoiceMapper {
    @Select("SELECT * FROM choice WHERE id = #{id};")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "question", column = "question"),
            @Result(property = "markA", column = "mark_A"),
            @Result(property = "markB", column = "mark_B"),
            @Result(property = "markC", column = "mark_C"),
            @Result(property = "markD", column = "mark_D"),
            @Result(property = "correctMark", column = "answer"),
            @Result(property = "remark", column = "remark"),
            @Result(property = "grade", column = "grade"),
            @Result(property = "difficult", column = "difficult")
    })
    ChoiceEntity getDetailById(int id);

    @Select("SELECT question,mark_A,mark_B,mark_C,mark_D,grade,difficult " +
            "FROM choice WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "question", column = "question"),
            @Result(property = "markA", column = "mark_A"),
            @Result(property = "markB", column = "mark_B"),
            @Result(property = "markC", column = "mark_C"),
            @Result(property = "markD", column = "mark_D"),
            @Result(property = "grade", column = "grade"),
            @Result(property = "difficult", column = "difficult")
    })
    ChoiceEntity getQuestionById(int id);

    @Select("SELECT answer FROM choice WHERE id = #{id}")
    @Results({
            @Result(property = "answer", column = "answer")
    })
    String getAnswerById(int id);

    @Select("SELECT remark FROM choice WHERE id = #{id}")
    @Results({
            @Result(property = "remark", column = "remark")
    })
    String getRemarkById(int id);


}
