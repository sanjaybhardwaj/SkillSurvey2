package au.com.redbackconsulting.skillsurvey.api.bean;

import au.com.redbackconsulting.skillsurvey.persistence.model.ClaimAssignments;

import com.google.gson.annotations.Expose;

public class ClaimAssignmentsBean {
	

	@Expose
	private Long id;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Expose
	private Long claimId;
	
	
	
	@Expose
	private Long roleId;

	public Long getClaimId() {
		return claimId;
	}

	public void setClaimId(Long claimId) {
		this.claimId = claimId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public static ClaimAssignmentsBean get(ClaimAssignments entity) {
		ClaimAssignmentsBean bean = new ClaimAssignmentsBean();
		
		bean.setClaimId(entity.getClaimid());
		bean.setRoleId(Long.valueOf(entity.getRoleId()));
		bean.setId(entity.getId());
		return null;
	}
	
	

}
