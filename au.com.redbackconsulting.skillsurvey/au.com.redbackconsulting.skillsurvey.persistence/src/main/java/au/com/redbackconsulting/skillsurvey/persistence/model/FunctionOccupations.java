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
@Table(name = "FUNCTIONOCCUPTIONS", uniqueConstraints = { @UniqueConstraint(columnNames = { "FUNCTIONID" }) })
@NamedQueries({ @NamedQuery(name = DBQueries.GET_FUNCTIONOCCUPTIONS, query = "select o from FunctionOccupations o where o.functionId = :functionId ")})

public class FunctionOccupations implements Serializable,IDBEntity {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@Column(name="FUNCTIONID")
private Long functionId;
	
	
	@Basic
	@Column(name="OCCUPTIONID")
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


	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

}
