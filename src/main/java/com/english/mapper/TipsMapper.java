package com.english.mapper;

import com.english.entity.TipsEntity;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @Author Mwg
 * @Date 2019/4/8 18:42
 * @Version 1.0
 * @Description TODO
 */
@Component
public interface TipsMapper {

    /**
     * @Author Mwg
     * @Date 2019/4/8 11:01
     * @Description TODO
     * @Param [id]
     * @Return com.english.entity.TipsEntity
     */
    @Select("SELECT * FROM tips WHERE id = #{id};")
    TipsEntity getById(int id);

}
