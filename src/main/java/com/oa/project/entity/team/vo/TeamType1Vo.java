package com.oa.project.entity.team.vo;

import java.io.Serializable;
import java.util.List;

import com.oa.project.entity.team.Teamtype2;

public class TeamType1Vo implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 8979769788411205654L;

	private Integer teamType1Id;

    private String teamType1Name;
    
    private List<Teamtype2>list;

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
		this.teamType1Name = teamType1Name;
	}

	public List<Teamtype2> getList() {
		return list;
	}

	public void setList(List<Teamtype2> list) {
		this.list = list;
	}
    
}
