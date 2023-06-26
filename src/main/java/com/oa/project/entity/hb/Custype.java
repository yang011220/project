package com.oa.project.entity.hb;

import java.io.Serializable;

public class Custype implements Serializable{
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1317975126263265246L;

	private Integer cusTypeId;

    private String cusType;

    public Integer getCusTypeId() {
        return cusTypeId;
    }

    public void setCusTypeId(Integer cusTypeId) {
        this.cusTypeId = cusTypeId;
    }

    public String getCusType() {
        return cusType;
    }

    public void setCusType(String cusType) {
        this.cusType = cusType == null ? null : cusType.trim();
    }
    
}