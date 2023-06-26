package com.oa.project.entity.team;

import java.io.Serializable;

public class Teamtype2 implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 6236936186031721980L;

	private Integer teamType2Id;

    private String teamType2Name;

    private Integer teamType1Id;

    public Integer getTeamType2Id() {
        return teamType2Id;
    }

    public void setTeamType2Id(Integer teamType2Id) {
        this.teamType2Id = teamType2Id;
    }

    public String getTeamType2Name() {
        return teamType2Name;
    }

    public void setTeamType2Name(String teamType2Name) {
        this.teamType2Name = teamType2Name == null ? null : teamType2Name.trim();
    }

    public Integer getTeamType1Id() {
        return teamType1Id;
    }

    public void setTeamType1Id(Integer teamType1Id) {
        this.teamType1Id = teamType1Id;
    }
}