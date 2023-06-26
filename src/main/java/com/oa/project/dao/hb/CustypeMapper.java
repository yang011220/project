package com.oa.project.dao.hb;

import com.oa.project.entity.hb.Custype;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

public interface CustypeMapper {
    @Delete({
        "delete from cus_type",
        "where cus_type_id = #{cusTypeId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer cusTypeId);

    int insertSelective(Custype record);
    
    @Select({
        "select",
        "cus_type_id, cus_type",
        "from cus_type"
    })
    @ResultMap("com.oa.project.dao.hb.CustypeMapper.BaseResultMap")
    List<Custype> findAll();


    @Select({
        "select",
        "cus_type_id, cus_type",
        "from cus_type",
        "where cus_type_id = #{cusTypeId,jdbcType=INTEGER}"
    })
    @ResultMap("com.oa.project.dao.hb.CustypeMapper.BaseResultMap")
    Custype selectByPrimaryKey(Integer cusTypeId);

    int updateByPrimaryKeySelective(Custype record);
}