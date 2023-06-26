package com.oa.project.entity.lh;

import java.io.Serializable;
import java.util.List;

import com.oa.project.entity.lt.Role;
import com.oa.project.entity.lt.User;
import com.oa.project.entity.team.Dept;
import com.oa.project.entity.team.Team;

public class Emp implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -8024465223908605445L;

	private int empId;
	
	private String empName;
	
	private Dept dept;
	
	private Role role;
 	
	private String empJob;
	
	private User user;
	
	private Team team;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}


	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getEmpJob() {
		return empJob;
	}

	public void setEmpJob(String empJob) {
		this.empJob = empJob;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", empName=" + empName + ", dept=" + dept + ", role=" + role + ", empJob="
				+ empJob + ",  user=" + user + ", team=" + team + "]";
	}

	
	
	
}
