package au.com.redbackconsulting.skillsurvey.api.bean;

import au.com.redbackconsulting.skillsurvey.persistence.model.UocGroup;

import com.google.gson.annotations.Expose;

public class UocGroupBean {
	@Expose
	private Long id;
	@Expose
	private String notes;
	@Expose
	private Long needId;
	@Expose
	private Long pathwayId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Long getNeedId() {
		return needId;
	}

	public void setNeedId(Long needId) {
		this.needId = needId;
	}

	public Long getPathwayId() {
		return pathwayId;
	}

	public void setPathwayId(Long pathwayId) {
		this.pathwayId = pathwayId;
	}

	public static UocGroupBean get(UocGroup entity) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
