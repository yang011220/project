package com.oa.project.entity.lh;

import java.io.Serializable;
import java.sql.Date;

import com.oa.project.entity.hb.Customer;

public class VisitPlan implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2405282401662472329L;

	private int visitId;
	
	private Emp emp;
	
	private Customer cust;
	
	private String plan;
	
	private Date visitTime;
	
	private String reason;

	public int getVisitId() {
		return visitId;
	}

	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public Date getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "VisitPlan [visitId=" + visitId + ", emp=" + emp + ", cust=" + cust + ", plan=" + plan + ", visitTime="
				+ visitTime + ", reason=" + reason + "]";
	}

	
	
	

}
