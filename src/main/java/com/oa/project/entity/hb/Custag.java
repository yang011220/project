package com.oa.project.entity.hb;

import java.io.Serializable;

public class Custag implements Serializable{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -2112823000920509196L;

	private Integer tagId;

    private String tagName;
    
    private Tagtype tagtype;

	public Tagtype getTagtype() {
		return tagtype;
	}

	public void setTagtype(Tagtype tagtype) {
		this.tagtype = tagtype;
	}

	public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName == null ? null : tagName.trim();
    }
}