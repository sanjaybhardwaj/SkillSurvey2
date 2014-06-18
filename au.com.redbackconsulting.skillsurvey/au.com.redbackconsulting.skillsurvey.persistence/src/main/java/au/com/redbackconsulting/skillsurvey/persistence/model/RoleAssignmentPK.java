package au.com.redbackconsulting.skillsurvey.persistence.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the role_assignment database table.
 * 
 */
@Embeddable
public class RoleAssignmentPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="individual_id", insertable=false, updatable=false)
	private int individualId;

	@Column(name="role_id")
	private int roleId;

	public RoleAssignmentPK() {
	}
	public int getIndividualId() {
		return this.individualId;
	}
	public void setIndividualId(int individualId) {
		this.individualId = individualId;
	}
	public int getRoleId() {
		return this.roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RoleAssignmentPK)) {
			return false;
		}
		RoleAssignmentPK castOther = (RoleAssignmentPK)other;
		return 
			(this.individualId == castOther.individualId)
			&& (this.roleId == castOther.roleId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.individualId;
		hash = hash * prime + this.roleId;
		
		return hash;
	}
}