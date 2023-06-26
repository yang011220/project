package com.oa.project.entity.hb;

import java.io.Serializable;
import java.util.Date;

import com.oa.project.entity.lh.Emp;
import com.oa.project.entity.team.Team;

/**
 * @author hb
 * 合同
 */
public class Contract implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -3061576436891833164L;

	private Integer contractId;

    private String picPath;

    private Emp emp;

    private Customer customer;

    private String contractName;

    private double money;

    private Date contractTime;

    private String contractPlace;
    
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

	public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath == null ? null : picPath.trim();
    }


    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName == null ? null : contractName.trim();
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Date getContractTime() {
        return contractTime;
    }

    public void setContractTime(Date contractTime) {
        this.contractTime = contractTime;
    }

    public String getContractPlace() {
        return contractPlace;
    }

    public void setContractPlace(String contractPlace) {
        this.contractPlace = contractPlace == null ? null : contractPlace.trim();
    }
}