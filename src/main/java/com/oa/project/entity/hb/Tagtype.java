package com.oa.project.entity.hb;

import java.io.Serializable;

public class Tagtype implements Serializable{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 6267039470584053960L;

	private Integer tagtypeId;

    private String tagtypeName;

    public Integer getTagtypeId() {
        return tagtypeId;
    }

    public void setTagtypeId(Integer tagtypeId) {
        this.tagtypeId = tagtypeId;
    }

    public String getTagtypeName() {
        return tagtypeName;
    }

    public void setTagtypeName(String tagtypeName) {
        this.tagtypeName = tagtypeName == null ? null : tagtypeName.trim();
    }
}