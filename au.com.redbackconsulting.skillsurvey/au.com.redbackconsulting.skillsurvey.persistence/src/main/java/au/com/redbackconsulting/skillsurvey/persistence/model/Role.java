package au.com.redbackconsulting.skillsurvey.persistence.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable, IDBEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idrole;

	private String description;

	private String name;

//	//bi-directional many-to-many association to Claim
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="claima_assignment"
		, joinColumns={
			@JoinColumn(name="role_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="claim_id")
			}
		)
	private List<Claim> claims;

	public Role() {
	}

	public long getIdrole() {
		return this.idrole;
	}

	public void setIdrole(long idrole) {
		this.idrole = idrole;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Claim> getClaims() {
		return this.claims;
	}
//
	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}

}