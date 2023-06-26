package com.oa.project.entity.hb;

import java.io.Serializable;

import com.oa.project.entity.lh.Emp;

public class Customer implements Serializable{
    

	/**
	 * 
	 */
	private static final long serialVersionUID = 8074722154345311711L;

	private Integer cusId;

    private String cusName;

    private Custype custype;

    private Custag custag;

    private Cusstate cusstate;

    private String tel;
    
    private Emp emp;
    
    private Integer teamId;
    
    private Integer cusAge;
    
    private String cusLocation;
    
    private String cusCompany;
    
    private String cusPosition;

	public Integer getCusId() {
		return cusId;
	}

	public void setCusId(Integer cusId) {
		this.cusId = cusId;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public Custype getCustype() {
		return custype;
	}

	public void setCustype(Custype custype) {
		this.custype = custype;
	}

	public Custag getCustag() {
		return custag;
	}

	public void setCustag(Custag custag) {
		this.custag = custag;
	}

	public Cusstate getCusstate() {
		return cusstate;
	}

	public void setCusstate(Cusstate cusstate) {
		this.cusstate = cusstate;
	}

	public Integer getCusAge() {
		return cusAge;
	}

	public void setCusAge(Integer cusAge) {
		this.cusAge = cusAge;
	}

	public String getCusLocation() {
		return cusLocation;
	}

	public void setCusLocation(String cusLocation) {
		this.cusLocation = cusLocation;
	}

	public String getCusCompany() {
		return cusCompany;
	}

	public void setCusCompany(String cusCompany) {
		this.cusCompany = cusCompany;
	}

	public String getCusPosition() {
		return cusPosition;
	}

	public void setCusPosition(String cusPosition) {
		this.cusPosition = cusPosition;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

    
}