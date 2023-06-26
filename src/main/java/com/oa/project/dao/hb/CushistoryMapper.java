package com.oa.project.dao.hb;

import com.oa.project.entity.hb.Cushistory;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

public interface CushistoryMapper {
    @Delete({
        "delete from cus_history",
        "where history_id = #{historyId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer historyId);

    int insertSelective(Cushistory record);
    
    @Select({
        "select",
        "history_id, create_time, emp_id, cus_id, context,team_id",
        "from cus_history"
    })
    @ResultMap("com.oa.project.dao.hb.CushistoryMapper.ResultMapWithBLOBs")
    List<Cushistory> findAll();
    
    @Select({
        "select",
        "history_id, create_time, emp_id, cus_id, context,team_id",
        "from cus_history limit #{num},20"
    })
    @ResultMap("com.oa.project.dao.hb.CushistoryMapper.ResultMapWithBLOBs")
    List<Cushistory> findAllLimit(int num);

    @Select({
        "select",
        "history_id, create_time, emp_id, cus_id, context,team_id",
        "from cus_history",
        "where history_id = #{historyId,jdbcType=INTEGER}"
    })
    @ResultMap("com.oa.project.dao.hb.CushistoryMapper.ResultMapWithBLOBs")
    Cushistory selectByPrimaryKey(Integer historyId);
    
    @Select({
        "select",
        "history_id, create_time, emp_id, cus_id, context,team_id",
        "from cus_history",
        "where team_id = #{teamId,jdbcType=INTEGER}"
    })
    @ResultMap("com.oa.project.dao.hb.CushistoryMapper.ResultMapWithBLOBs")
    List<Cushistory> selectByteamId(Integer teamId);
    
    @Select({
        "select",
        "history_id, create_time, emp_id, cus_id, context,team_id",
        "from cus_history",
        "where team_id = #{teamId,jdbcType=INTEGER} limit #{num},20"
    })
    @ResultMap("com.oa.project.dao.hb.CushistoryMapper.ResultMapWithBLOBs")
    List<Cushistory> selectByteamIdLimit(@Param("teamId")int teamId,@Param("num")int num);
    
    @Select({
        "select",
        "history_id, create_time, emp_id, cus_id, context,team_id",
        "from cus_history",
        "where emp_id = #{empId,jdbcType=INTEGER}"
    })
    @ResultMap("com.oa.project.dao.hb.CushistoryMapper.ResultMapWithBLOBs")
    List<Cushistory> selectByempId(Integer empId);
    
    @Select({
        "select",
        "history_id, create_time, emp_id, cus_id, context,team_id",
        "from cus_history",
        "where emp_id = #{empId,jdbcType=INTEGER} limit #{num},20"
    })
    @ResultMap("com.oa.project.dao.hb.CushistoryMapper.ResultMapWithBLOBs")
    List<Cushistory> selectByempIdLimit(@Param("empId")int empId,@Param("num")int num);

    int updateByPrimaryKeySelective(Cushistory record);

}