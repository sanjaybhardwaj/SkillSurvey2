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
@Table(name = "UOCGROUPMEMBERS", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) })
@NamedQueries({ @NamedQuery(name = DBQueries.GET_UOCGROUP_MEMBERS, query = "select o from UocGroupMembers o where o.uoc_GroupId = :uoc_GroupId")})

public class UocGroupMembers implements Serializable,IDBEntity {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Id
@Column(name="UPC_GROUPID")
private Long uoc_GroupId;
	
@Basic
@Column(name="UOC_ID")
private Long uoc_Id;

	public Long getUoc_GroupId() {
		return uoc_GroupId;
	}

	public void setUoc_GroupId(Long uoc_GroupId) {
		this.uoc_GroupId = uoc_GroupId;
	}

	public Long getUoc_Id() {
		return uoc_Id;
	}

	public void setUoc_Id(Long uoc_Id) {
		this.uoc_Id = uoc_Id;
	}

	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}



}
