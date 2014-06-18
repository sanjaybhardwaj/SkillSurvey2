package au.com.redbackconsulting.skillsurvey.api.bean;

import au.com.redbackconsulting.skillsurvey.persistence.model.DapsscoLevel;

import com.google.gson.annotations.Expose;

public class DapsscoLevelsBean {
	

	@Expose
	private Long iddapsscolevel;
	
	public Long getIddapsscolevel() {
		return iddapsscolevel;
	}

	public void setIddapsscolevel(Long iddapsscolevel) {
		this.iddapsscolevel = iddapsscolevel;
	}

	@Expose
	private Long dapssco_id;
	
	
	@Expose
	private Long levelId;

	public Long getDapssco_id() {
		return dapssco_id;
	}

	public void setDapssco_id(Long dapssco_id) {
		this.dapssco_id = dapssco_id;
	}

	public Long getLevelId() {
		return levelId;
	}

	public void setLevelId(Long levelId) {
		this.levelId = levelId;
	}

	public static DapsscoLevelsBean get(DapsscoLevel entity) {
		DapsscoLevelsBean bean = new DapsscoLevelsBean();
		bean.setIddapsscolevel(entity.getId());
		bean.setDapssco_id(entity.getDapssco_id());
		bean.setLevelId(entity.getLevelId());
		
		return bean;
	}

	
	

}
