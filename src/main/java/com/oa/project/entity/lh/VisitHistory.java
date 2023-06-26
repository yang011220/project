package com.oa.project.entity.lh;

import java.io.Serializable;
import java.sql.Date;

import com.oa.project.entity.hb.Customer;

public class VisitHistory implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2952069538171039168L;

	private int vhId;
	
	private Emp emp;
	
	private Customer cust;
	
	private Date visitTime;
	
	private String visitRecord;
	
	private String visitReason;
	
	private String visitPlace;

	public int getVhId() {
		return vhId;
	}

	public void setVhId(int vhId) {
		this.vhId = vhId;
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

	public Date getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}

	public String getVisitRecord() {
		return visitRecord;
	}

	public void setVisitRecord(String visitRecord) {
		this.visitRecord = visitRecord;
	}

	public String getVisitReason() {
		return visitReason;
	}

	public void setVisitReason(String visitReason) {
		this.visitReason = visitReason;
	}

	public String getVisitPlace() {
		return visitPlace;
	}

	public void setVisitPlace(String visitPlace) {
		this.visitPlace = visitPlace;
	}

	@Override
	public String toString() {
		return "VisitHistory [vhId=" + vhId + ", emp=" + emp + ", cust=" + cust + ", visitTime=" + visitTime
				+ ", visitRecord=" + visitRecord + ", visitReason=" + visitReason + ", visitPlace=" + visitPlace + "]";
	}

	
	
	

}
