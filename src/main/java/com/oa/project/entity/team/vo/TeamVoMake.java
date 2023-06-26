package com.oa.project.entity.team.vo;
import java.io.Serializable;
import java.util.List;
import com.oa.project.entity.team.vo.TeamType1Vo;
import com.oa.project.entity.team.Scale;

public class TeamVoMake implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -3041127023097978062L;
	private List<TeamType1Vo>type1Volist;
    private List<Scale> scaleList;
	
	public List<TeamType1Vo> getType1Volist() {
		return type1Volist;
	}
	public void setType1Volist(List<TeamType1Vo> type1Volist) {
		this.type1Volist = type1Volist;
	}
	public List<Scale> getScaleList() {
		return scaleList;
	}
	public void setScaleList(List<Scale> scaleList) {
		this.scaleList = scaleList;
	}

   
	
	
	
}