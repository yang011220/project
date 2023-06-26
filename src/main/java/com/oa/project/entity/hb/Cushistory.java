package com.oa.project.entity.hb;

import java.io.Serializable;
import java.util.Date;

import com.oa.project.entity.lh.Emp;
import com.oa.project.entity.team.Team;

public class Cushistory implements Serializable{
    
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -8819640595534725221L;

	private Integer historyId;

    private Date createTime;

    private Emp emp;

    private Customer customer;

    private String context;
    
    private Team team;

    

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Integer getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Integer historyId) {
        this.historyId = historyId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }
}