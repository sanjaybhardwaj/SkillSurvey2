package au.com.redbackconsulting.skillsurvey.api.bean;

import au.com.redbackconsulting.skillsurvey.persistence.model.Supervisons;

import com.google.gson.annotations.Expose;

public class SupervisonsBean {
	@Expose
	private Long supervisorId;
	@Expose
	private Long supervisedId;
  
	public Long getSupervisorId() {
		return supervisorId;
	}

	public void setSupervisorId(Long supervisorId) {
		this.supervisorId = supervisorId;
	}

	public Long getSupervisedId() {
		return supervisedId;
	}

	public void setSupervisedId(Long supervisedId) {
		this.supervisedId = supervisedId;
	}

	public static SupervisonsBean get(Supervisons entity) {
		SupervisonsBean bean = new SupervisonsBean();
		bean.setSupervisorId(Long.valueOf(entity.getSupervisorId()));
		bean.setSupervisedId(Long.valueOf(entity.getSupervisedId()));
		return bean;
	}

	
}
