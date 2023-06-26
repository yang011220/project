package com.oa.project.entity.team;

import java.io.Serializable;
import java.util.Date;

public class Team implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -3059568169876808901L;

	private Integer teamId;

    private String teamName;

    private Date createTime;

    private String creator;

    private Date updateTime;

    private String updator;

    private Integer scaleId;

    private Integer teamType2Id;

    private Integer userId;

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName == null ? null : teamName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdator() {
        return updator;
    }

    public void setUpdator(String updator) {
        this.updator = updator == null ? null : updator.trim();
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}