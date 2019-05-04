package com.english.mapper;

import com.english.entity.ChoiceEntity;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * TODO
 * @author Mwg
 * @date 2019/4/3 10:34
 * @version 1.0
 */
@Component
public interface ChoiceMapper {
    /**
     * TODO
     * @author Mwg
     * @date 2019/4/25 21:51
     * @param id Choice id
     * @return com.english.entity.ChoiceEntity
     */
    @Select("SELECT * FROM choice WHERE id >= #{id} limit 1;")
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
            @Result(property = "difficult", column = "difficult"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "author", column = "author")
    })
    ChoiceEntity getDetailById(int id);

    /**
     * TODO
     * @author Mwg
     * @date 2019/4/25 21:51
     * @param id Choice id
     * @return com.english.entity.ChoiceEntity
     */
    @Select("SELECT id,question,mark_A,mark_B,mark_C,mark_D,grade,difficult,create_time,author " +
            "FROM choice WHERE id >= #{id} limit 1;")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "question", column = "question"),
            @Result(property = "markA", column = "mark_A"),
            @Result(property = "markB", column = "mark_B"),
            @Result(property = "markC", column = "mark_C"),
            @Result(property = "markD", column = "mark_D"),
            @Result(property = "grade", column = "grade"),
            @Result(property = "difficult", column = "difficult"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "author", column = "author")
    })
    ChoiceEntity getQuestionById(int id);

    /**
     * TODO
     * @author Mwg
     * @date 2019/4/25 21:51
     * @param id Choice id
     * @return java.lang.string
     */
    @Select("SELECT answer FROM choice WHERE id = #{id}")
    @Results({
            @Result(property = "answer", column = "answer")
    })
    String getAnswerById(int id);

    /**
     * 获取问题解析、备注等内容。
     * @author Mwg
     * @date 2019/5/4 15:36
     * @param id
     * @return java.lang.String
     */
    @Select("SELECT remark FROM choice WHERE id = #{id}")
    @Results({
            @Result(property = "remark", column = "remark")
    })
    String getRemarkById(int id);

    /**
     * TODO
     * @author Mwg
     * @date 2019/5/4 15:37
     * @param () no param
     * @return int
     */
    @Select("SELECT COUNT(*) as count FROM choice;")
    @Results({
            @Result(column = "count")
    })
    int getCountChoice();


}
