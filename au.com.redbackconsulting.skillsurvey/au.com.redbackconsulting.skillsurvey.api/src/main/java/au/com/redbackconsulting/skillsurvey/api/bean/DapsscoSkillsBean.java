package au.com.redbackconsulting.skillsurvey.api.bean;

import au.com.redbackconsulting.skillsurvey.persistence.model.DapsscoSkills;

import com.google.gson.annotations.Expose;

public class DapsscoSkillsBean {
	
	
	@Expose
	private Long dapssco_Id;
	
	
	@Expose
	private Long uoc_GroupId;

	public Long getDapssco_Id() {
		return dapssco_Id;
	}

	public void setDapssco_Id(Long dapssco_Id) {
		this.dapssco_Id = dapssco_Id;
	}

	public Long getUoc_GroupId() {
		return uoc_GroupId;
	}

	public void setUoc_GroupId(Long uoc_GroupId) {
		this.uoc_GroupId = uoc_GroupId;
	}

	public static DapsscoSkillsBean get(DapsscoSkills entity) {
	DapsscoSkillsBean bean = new DapsscoSkillsBean();
	bean.setDapssco_Id(entity.getDapssco_Id());
	bean.setUoc_GroupId(entity.getUoc_GroupId());
		return bean;
	}
	
	

}
