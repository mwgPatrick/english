package com.english.mapper;

import com.english.entity.TipsEntity;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * TODO
 * @author Mwg
 * @date 2019/4/8 18:42
 * @version 1.0
 */
@Component
public interface TipsMapper {

    /**
     * TODO
     * @author Mwg
     * @date 2019/4/8 11:01
     * @param id Tip id
     * @return com.english.entity.TipsEntity
     */
    @Select("SELECT * FROM tips WHERE id = #{id};")
    TipsEntity getById(int id);

    @Select("SELECT COUNT(*) FROM tips")
    int getTipsCount();
}
