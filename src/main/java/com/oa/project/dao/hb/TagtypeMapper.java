package com.oa.project.dao.hb;

import com.oa.project.entity.hb.Tagtype;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

public interface TagtypeMapper {
    @Delete({
        "delete from tagtype",
        "where tagtype_id = #{tagtypeId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer tagtypeId);

    int insertSelective(Tagtype record);
    
    @Select({
        "select",
        "tagtype_id, tagtype_name",
        "from tagtype"
    })
    @ResultMap("com.oa.project.dao.hb.TagtypeMapper.BaseResultMap")
    List<Tagtype> findAll();


    @Select({
        "select",
        "tagtype_id, tagtype_name",
        "from tagtype",
        "where tagtype_id = #{tagtypeId,jdbcType=INTEGER}"
    })
    @ResultMap("com.oa.project.dao.hb.TagtypeMapper.BaseResultMap")
    Tagtype selectByPrimaryKey(Integer tagtypeId);

    int updateByPrimaryKeySelective(Tagtype record);
}