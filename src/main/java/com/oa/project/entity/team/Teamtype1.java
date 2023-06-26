package com.oa.project.entity.team;

import java.io.Serializable;
import java.util.List;

public class Teamtype1 implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -2031867030522353463L;

	private Integer teamType1Id;

    private String teamType1Name;
    
//    private List<Teamtype2> type2List;

    public Integer getTeamType1Id() {
        return teamType1Id;
    }

    public void setTeamType1Id(Integer teamType1Id) {
        this.teamType1Id = teamType1Id;
    }

    public String getTeamType1Name() {
        return teamType1Name;
    }

    public void setTeamType1Name(String teamType1Name) {
        this.teamType1Name = teamType1Name == null ? null : teamType1Name.trim();
    }
}