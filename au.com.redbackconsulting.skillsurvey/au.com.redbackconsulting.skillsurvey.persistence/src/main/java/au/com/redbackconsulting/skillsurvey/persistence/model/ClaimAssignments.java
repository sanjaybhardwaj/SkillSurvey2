package au.com.redbackconsulting.skillsurvey.persistence.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;




@Entity
@Table(name = "CLAIMASSIGNMENT", uniqueConstraints = { @UniqueConstraint(columnNames = { "CLAIMID" }) })
@NamedQueries({ @NamedQuery(name = DBQueries.GET_CLAIMASSIGNMENT, query = "select u from ClaimAssignments u where u.Claimid= :Claimid")})

public class ClaimAssignments implements Serializable,IDBEntity {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CLAIMID")
	private long  Claimid;

	@Basic
	@Column(name = "ROLEID")
	private String RoleId;

	public long getClaimid() {
		return Claimid;
	}

	public void setClaimid(long claimid) {
		Claimid = claimid;
	}

	public String getRoleId() {
		return RoleId;
	}

	public void setRoleId(String roleId) {
		RoleId = roleId;
	}

	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

}
