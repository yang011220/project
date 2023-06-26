package com.oa.project.dao.team;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.annotation.MapperScan;

import com.oa.project.entity.team.Scale;
@MapperScan
public interface ScaleMapper {
    @Delete({
        "delete from scale",
        "where scale_id = #{scaleId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer scaleId);

    @Insert({
        "insert into scale (scale_id, scale_name)",
        "values (#{scaleId,jdbcType=INTEGER}, #{scaleName,jdbcType=VARCHAR})"
    })
    int insert(Scale record);

    @InsertProvider(type=ScaleSqlProvider.class, method="insertSelective")
    int insertSelective(Scale record);

    @Select({
        "select",
        "scale_id, scale_name",
        "from scale",
        "where scale_id = #{scaleId,jdbcType=INTEGER}"
    })
    @Results(id="ScaleMapper",value={
        @Result(column="scale_id", property="scaleId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="scale_name", property="scaleName", jdbcType=JdbcType.VARCHAR)
    })
    Scale selectByPrimaryKey(Integer scaleId);

    @UpdateProvider(type=ScaleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Scale record);

    @Update({
        "update scale",
        "set scale_name = #{scaleName,jdbcType=VARCHAR}",
        "where scale_id = #{scaleId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Scale record);
    @Select({
        "select",
        "scale_id, scale_name",
        "from scale"
    })
    @ResultMap("ScaleMapper")
    List<Scale> selectAll();
}