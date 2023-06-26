package com.oa.project.entity.hb;

import java.io.Serializable;

public class Cusstate implements Serializable{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -8650587662611462195L;

	private Integer stateId;

    private String stateName;

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName == null ? null : stateName.trim();
    }
}