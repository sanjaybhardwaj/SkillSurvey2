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
@Table(name = "DAPSSCOLEVEL", uniqueConstraints = { @UniqueConstraint(columnNames = { "DEPSSCO_ID" }) })
@NamedQueries({ @NamedQuery(name = DBQueries.GET_DAPSSCOLEVEL, query = "select o from DapsscoLevel o where o.dapssco_id = :dapssco_id")})


public class DapsscoLevel implements Serializable,IDBEntity {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


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


	@Id
	@Column(name = "DEPSSCO_ID")
private Long dapssco_id;
	
	
	@Basic
	@Column(name = "LEVELID")	
private Long levelId;


	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}





}
