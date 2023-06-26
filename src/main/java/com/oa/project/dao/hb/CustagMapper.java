package com.oa.project.dao.hb;

import com.oa.project.entity.hb.Custag;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

public interface CustagMapper {
    @Delete({
        "delete from cus_tag",
        "where tag_id = #{tagId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer tagId);

    int insertSelective(Custag record);
    
    @Select({
        "select",
        "tag_id, tag_name,tagtype_id",
        "from cus_tag"
    })
    @ResultMap("com.oa.project.dao.hb.CustagMapper.BaseResultMap2")
    List<Custag> findAll();

    @Select({
        "select",
        "tag_id, tag_name,tagtype_id",
        "from cus_tag",
        "where tag_id = #{tagId,jdbcType=INTEGER}"
    })
    @ResultMap("com.oa.project.dao.hb.CustagMapper.BaseResultMap2")
    Custag selectByPrimaryKey(Integer tagId);

    int updateByPrimaryKeySelective(Custag record);
}