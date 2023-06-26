package com.oa.project.entity.team;

import java.io.Serializable;

public class Dept implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4299124390012037764L;

	private Integer deptId;

    private String deptName;

    private Integer leveldeptId;
    private Integer teamId;

    public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public Integer getLeveldeptId() {
        return leveldeptId;
    }

    public void setLeveldeptId(Integer leveldeptId) {
        this.leveldeptId = leveldeptId;
    }
}