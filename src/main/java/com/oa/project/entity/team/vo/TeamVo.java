package com.oa.project.entity.team.vo;

import java.io.Serializable;
import java.util.Date;

public class TeamVo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -3059568169876808901L;

	
    private String teamName;


    private String teamType1Id;

    private Integer scaleId;

    private Integer teamType2Id;

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamType1Id() {
		return teamType1Id;
	}

	public void setTeamType1Id(String teamType1Id) {
		this.teamType1Id = teamType1Id;
	}

	public Integer getScaleId() {
		return scaleId;
	}

	public void setScaleId(Integer scaleId) {
		this.scaleId = scaleId;
	}

	public Integer getTeamType2Id() {
		return teamType2Id;
	}

	public void setTeamType2Id(Integer teamType2Id) {
		this.teamType2Id = teamType2Id;
	}
}