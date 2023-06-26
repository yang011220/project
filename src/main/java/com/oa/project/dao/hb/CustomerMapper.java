package com.oa.project.dao.hb;

import com.oa.project.entity.hb.Customer;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

public interface CustomerMapper {
    @Delete({
        "delete from customer",
        "where cus_id = #{cusId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer cusId);


    int insertSelective(Customer record);

    @Select({
        "select",
        "cus_id, cus_name, cus_type_id, tag_id, state_id, tel,emp_id,team_id,cus_age,cus_location,cus_company,cus_position",
        "from customer",
        "where cus_id = #{cusId,jdbcType=INTEGER}"
    })
    @ResultMap("com.oa.project.dao.hb.CustomerMapper.BaseResultMap2")
    Customer selectByPrimaryKey(Integer cusId);
    
    @Select({"select",
            "cus_id, cus_name, cus_type_id, tag_id, state_id,tel,emp_id,team_id,cus_age,cus_location,cus_company,cus_position",
            "from customer"})
    @ResultMap("com.oa.project.dao.hb.CustomerMapper.BaseResultMap2")
    List<Customer> findAll();
    
    @Select({"select",
        "cus_id, cus_name, cus_type_id, tag_id, state_id,tel,emp_id,team_id,cus_age,cus_location,cus_company,cus_position",
        "from customer limit #{num},20"})
	@ResultMap("com.oa.project.dao.hb.CustomerMapper.BaseResultMap2")
	List<Customer> findAllLimit(int num);
    
    @Select({
        "select",
        "cus_id, cus_name, cus_type_id, tag_id, state_id, tel,emp_id,team_id,cus_age,cus_location,cus_company,cus_position",
        "from customer",
        "where team_id = #{teamId,jdbcType=INTEGER}"
    })
    @ResultMap("com.oa.project.dao.hb.CustomerMapper.BaseResultMap2")
    List<Customer> selectByteamId(Integer teamId);
    
    @Select({
        "select",
        "cus_id, cus_name, cus_type_id, tag_id, state_id, tel,emp_id,team_id,cus_age,cus_location,cus_company,cus_position",
        "from customer",
        "where team_id = #{teamId,jdbcType=INTEGER} limit #{num},20"
    })
    @ResultMap("com.oa.project.dao.hb.CustomerMapper.BaseResultMap2")
    List<Customer> selectByteamIdLimit(@Param("teamId")int teamId,@Param("num")int num);
    
    @Select({"select",
        "cus_id, cus_name, cus_type_id, tag_id, state_id, tel,emp_id,team_id,cus_age,cus_location,cus_company,cus_position",
        "from customer",
        "where emp_id = #{empId,jdbcType=INTEGER}"})
	@ResultMap("com.oa.project.dao.hb.CustomerMapper.BaseResultMap2")
	List<Customer> findByempId(Integer empId);
    
    @Select({"select",
        "cus_id, cus_name, cus_type_id, tag_id, state_id, tel,emp_id,team_id,cus_age,cus_location,cus_company,cus_position",
        "from customer",
        "where emp_id = #{empId,jdbcType=INTEGER} limit #{num},20"})
	@ResultMap("com.oa.project.dao.hb.CustomerMapper.BaseResultMap2")
	List<Customer> findByempIdLimit(@Param("empId")int empId,@Param("num")int num);

    int updateByPrimaryKeySelective(Customer record);

}