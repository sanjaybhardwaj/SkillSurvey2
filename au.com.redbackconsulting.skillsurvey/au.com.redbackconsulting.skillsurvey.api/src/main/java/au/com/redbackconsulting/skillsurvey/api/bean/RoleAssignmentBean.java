package au.com.redbackconsulting.skillsurvey.api.bean;

import au.com.redbackconsulting.skillsurvey.persistence.model.RoleAssignment;

import com.google.gson.annotations.Expose;

public class RoleAssignmentBean {
	@Expose
	private Long individualId;
	@Expose
	private Long roleId;

	public Long getIndividualId() {
		return individualId;
	}

	public void setIndividualId(Long individualId) {
		this.individualId = individualId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public static RoleAssignmentBean get(RoleAssignment entity) {
	RoleAssignmentBean bean = new RoleAssignmentBean();
//TODO	bean.setIndividualId(entity.getIndividual().getIdindividual());
//	bean.setRoleId(entity.get);
		return bean;
	}

}
