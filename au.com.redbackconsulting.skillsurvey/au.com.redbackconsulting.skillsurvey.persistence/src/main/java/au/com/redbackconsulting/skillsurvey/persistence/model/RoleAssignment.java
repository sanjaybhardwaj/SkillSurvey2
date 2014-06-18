package au.com.redbackconsulting.skillsurvey.persistence.model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the role_assignment database table.
 * 
 */
@Entity
@Table(name="role_assignment")
@NamedQuery(name="RoleAssignment.findAll", query="SELECT r FROM RoleAssignment r")
public class RoleAssignment implements Serializable,IDBEntity {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RoleAssignmentPK idpk;

	//bi-directional many-to-one association to Individual
	@ManyToOne
	@JoinColumn(name="individual_id")
	private Individual individual;

	public RoleAssignment() {
	}

	public RoleAssignmentPK getIdpk() {
		return this.idpk;
	}

	public void setId(RoleAssignmentPK idpk) {
		this.idpk = idpk;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public Individual getIndividual() {
		return this.individual;
	}

	public void setIndividual(Individual individual) {
		this.individual = individual;
	}

}