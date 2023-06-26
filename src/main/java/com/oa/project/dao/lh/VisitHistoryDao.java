package com.oa.project.dao.lh;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import com.oa.project.entity.lh.Emp;
import com.oa.project.entity.lh.VisitHistory;


@MapperScan
public interface VisitHistoryDao {

	@ResultMap("com.oa.project.dao.lh.VisitHistoryDao.VisitHistoryResultMap")
	@Select("select vh_id,emp_id,cus_id,visit_time,visit_record,visit_reason,visit_place from visit_history where emp_id = #{empId} order by visit_time desc")
	List<VisitHistory> findAll(Emp emp);
	
	@ResultMap("com.oa.project.dao.lh.VisitHistoryDao.VisitHistoryResultMap")
	@Select("select vh_id,emp_id,cus_id,visit_time,visit_record,visit_reason,visit_place from visit_history where emp_id = #{empId} order by visit_time desc limit #{num},20")
	List<VisitHistory> findAllLimit(Emp emp,int num);

	//xml
	int save(VisitHistory visitHistory);
	
	//xml
	int update(VisitHistory visitHistory);
	
	@Delete("delete from visit_history where vh_id =#{vhId}")
	int delete(int vhId);
	
	@ResultMap("com.oa.project.dao.lh.VisitHistoryDao.VisitHistoryResultMap")
	@Select("select vh_id,emp_id,cus_id,visit_time,visit_record,visit_reason,visit_place from visit_history where vh_id=#{vhId}")
	VisitHistory findById(int vhId);
	
	
	//按时间查历史记录：比如传入今天的时间查看今天的拜访记录
	@ResultMap("com.oa.project.dao.lh.VisitHistoryDao.VisitHistoryResultMap")
	@Select("select vh_id,emp_id,cus_id,visit_time,visit_record,visit_reason,visit_place from visit_history where visit_time like CONCAT(#{visitTime},'%')")
	List<VisitHistory> findByVisitTime(VisitHistory visitHistory);
}
