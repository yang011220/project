package com.oa.project.entity.team;

import java.io.Serializable;

public class Scale implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -3659650306139113645L;

	private Integer scaleId;

    private String scaleName;

    public Integer getScaleId() {
        return scaleId;
    }

    public void setScaleId(Integer scaleId) {
        this.scaleId = scaleId;
    }

    public String getScaleName() {
        return scaleName;
    }

    public void setScaleName(String scaleName) {
        this.scaleName = scaleName == null ? null : scaleName.trim();
    }
}