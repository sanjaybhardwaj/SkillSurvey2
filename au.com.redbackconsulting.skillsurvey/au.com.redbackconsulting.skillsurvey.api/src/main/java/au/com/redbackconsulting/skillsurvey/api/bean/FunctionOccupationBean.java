package au.com.redbackconsulting.skillsurvey.api.bean;

import au.com.redbackconsulting.skillsurvey.persistence.model.FunctionOccupations;

import com.google.gson.annotations.Expose;

public class FunctionOccupationBean {
	
	@Expose
	private Long functionId;
	
	@Expose
	private Long occupationid;

	public Long getFunctionId() {
		return functionId;
	}

	public void setFunctionId(Long functionId) {
		this.functionId = functionId;
	}

	public Long getOccupationid() {
		return occupationid;
	}

	public void setOccupationid(Long occupationid) {
		this.occupationid = occupationid;
	}

	public static FunctionOccupationBean get(FunctionOccupations entity) {
		FunctionOccupationBean bean = new FunctionOccupationBean();
		bean.setFunctionId(entity.getFunctionId());
		bean.setOccupationid(entity.getOccupationid());
		return bean;
	}
	
	

}
