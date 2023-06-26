package com.oa.project.entity.team;

import java.io.Serializable;
import java.util.Date;

public class Sign implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -9027138950517287067L;

	private Integer signId;

    private Integer empId;

    private String signPlace;

    private Date signTime;

    private Integer signState;

    

    public Integer getSignId() {
        return signId;
    }

    public void setSignId(Integer signId) {
        this.signId = signId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getSignPlace() {
        return signPlace;
    }

    public void setSignPlace(String signPlace) {
        this.signPlace = signPlace == null ? null : signPlace.trim();
    }

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    public Integer getSignState() {
        return signState;
    }

    public void setSignState(Integer signState) {
        this.signState = signState;
    }

   
}