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
@Table(name = "SUPERVISONS", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) })
@NamedQueries({ @NamedQuery(name = DBQueries.GET_SUPERVISONS, query = "select o from Supervisons o where o.supervisorId = :supervisorId")})

public class Supervisons implements Serializable,IDBEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@Column(name="SUPERVISORID")
private Long supervisorId;
	
	
	@Basic
	@Column(name="SUPERVISEDID")
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


	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
