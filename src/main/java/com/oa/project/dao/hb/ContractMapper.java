package com.oa.project.dao.hb;

import com.oa.project.entity.hb.Contract;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface ContractMapper {
    @Delete({
        "delete from contract",
        "where contract_id = #{contractId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer contractId);

    @Insert({
        "insert into contract (contract_id, pic_path, ",
        "emp_id, cus_id, contract_name, ",
        "money, contract_time, ",
        "contract_place,team_id)",
        "values (#{contractId,jdbcType=INTEGER}, #{picPath,jdbcType=VARCHAR}, ",
        "#{empId,jdbcType=INTEGER}, #{cusId,jdbcType=INTEGER}, #{contractName,jdbcType=VARCHAR}, ",
        "#{money,jdbcType=REAL}, #{contractTime,jdbcType=TIMESTAMP}, ",
        "#{contractPlace,jdbcType=VARCHAR},#{teamId,jdbcType=INTEGER})"
    })
    int insert(Contract record);

    int insertSelective(Contract record);
    
    @Select({
        "select",
        "contract_id, pic_path, emp_id, cus_id, contract_name, money, contract_time, ",
        "contract_place,team_id",
        "from contract"
    })
    @ResultMap("com.oa.project.dao.hb.ContractMapper.BaseResultMap")
    List<Contract> selectAll();
    
    @Select({
        "select",
        "contract_id, pic_path, emp_id, cus_id, contract_name, money, contract_time, ",
        "contract_place,team_id",
        "from contract limit #{num},20"
    })
    @ResultMap("com.oa.project.dao.hb.ContractMapper.BaseResultMap")
    List<Contract> selectAllLimit(int num);
    
    @Select({
        "select",
        "contract_id, pic_path, emp_id, cus_id, contract_name, money, contract_time, ",
        "contract_place,team_id",
        "from contract",
        "where team_id = #{teamId,jdbcType=INTEGER}"
    })
    @ResultMap("com.oa.project.dao.hb.ContractMapper.BaseResultMap")
    List<Contract> selectByteamId(Integer teamId);
    
    @Select({
        "select",
        "contract_id, pic_path, emp_id, cus_id, contract_name, money, contract_time, ",
        "contract_place,team_id",
        "from contract",
        "where team_id = #{teamId,jdbcType=INTEGER} limit #{num},20"
    })
    @ResultMap("com.oa.project.dao.hb.ContractMapper.BaseResultMap")
    List<Contract> selectByteamIdLimit(@Param("teamId")int teamId,@Param("num")int num);

    @Select({
        "select",
        "contract_id, pic_path, emp_id, cus_id, contract_name, money, contract_time, ",
        "contract_place,team_id",
        "from contract",
        "where contract_id = #{contractId,jdbcType=INTEGER}"
    })
    @ResultMap("com.oa.project.dao.hb.ContractMapper.BaseResultMap")
    Contract selectByPrimaryKey(Integer contractId);
    
    @Select({
        "select",
        "contract_id, pic_path, emp_id, cus_id, contract_name, money, contract_time, ",
        "contract_place,team_id",
        "from contract",
        "where emp_id = #{empId,jdbcType=INTEGER}"
    })
    @ResultMap("com.oa.project.dao.hb.ContractMapper.BaseResultMap")
    List<Contract> selectByempId(Integer empId);
    
    @Select({
        "select",
        "contract_id, pic_path, emp_id, cus_id, contract_name, money, contract_time, ",
        "contract_place,team_id",
        "from contract",
        "where emp_id = #{empId,jdbcType=INTEGER} limit #{num},20"
    })
    @ResultMap("com.oa.project.dao.hb.ContractMapper.BaseResultMap")
    List<Contract> selectByempIdLimit(@Param("empId")int empId,@Param("num")int num);

    int updateByPrimaryKeySelective(Contract record);

    @Update({
        "update contract",
        "set pic_path = #{picPath,jdbcType=VARCHAR},",
          "emp_id = #{empId,jdbcType=INTEGER},",
          "cus_id = #{cusId,jdbcType=INTEGER},",
          "contract_name = #{contractName,jdbcType=VARCHAR},",
          "money = #{money,jdbcType=REAL},",
          "contract_time = #{contractTime,jdbcType=TIMESTAMP},",
          "contract_place = #{contractPlace,jdbcType=VARCHAR}",
          "team_id = #{teamId,jdbcType=INTEGER}",
        "where contract_id = #{contractId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Contract record);
}