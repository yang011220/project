package com.oa.project.dao.hb;

import com.oa.project.entity.hb.Cusstate;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

public interface CusstateMapper {
    @Delete({
        "delete from cus_state",
        "where state_id = #{stateId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer stateId);

    int insertSelective(Cusstate record);
    
    @Select({
        "select",
        "state_id, state_name",
        "from cus_state"
    })
    @ResultMap("com.oa.project.dao.hb.CusstateMapper.BaseResultMap")
    List<Cusstate> findAll();

    @Select({
        "select",
        "state_id, state_name",
        "from cus_state",
        "where state_id = #{stateId,jdbcType=INTEGER}"
    })
    @ResultMap("com.oa.project.dao.hb.CusstateMapper.BaseResultMap")
    Cusstate selectByPrimaryKey(Integer stateId);

    int updateByPrimaryKeySelective(Cusstate record);

}