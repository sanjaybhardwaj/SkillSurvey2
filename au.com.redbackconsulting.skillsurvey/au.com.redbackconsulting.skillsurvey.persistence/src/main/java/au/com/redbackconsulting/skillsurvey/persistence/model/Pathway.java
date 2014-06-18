package au.com.redbackconsulting.skillsurvey.persistence.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the pathway database table.
 * 
 */
@Entity
@NamedQuery(name="Pathway.findAll", query="SELECT p FROM Pathway p")
public class Pathway implements Serializable,IDBEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idpathway;

	private String description;

	private String name;
//
//	//bi-directional many-to-one association to Survey
	@OneToMany(mappedBy="pathway", fetch=FetchType.EAGER)
	private List<Survey> surveys;

	//bi-directional many-to-one association to UocGroup
	@OneToMany(mappedBy="pathway", fetch=FetchType.EAGER)
	private List<UocGroup> uocGroups;

	public Pathway() {
	}

	public int getIdpathway() {
		return this.idpathway;
	}

	public void setIdpathway(int idpathway) {
		this.idpathway = idpathway;
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

	public List<Survey> getSurveys() {
		return this.surveys;
	}

	public void setSurveys(List<Survey> surveys) {
		this.surveys = surveys;
	}

	public Survey addSurvey(Survey survey) {
		getSurveys().add(survey);
		survey.setPathway(this);

		return survey;
	}

	public Survey removeSurvey(Survey survey) {
		getSurveys().remove(survey);
		survey.setPathway(null);

		return survey;
	}

	public List<UocGroup> getUocGroups() {
		return this.uocGroups;
	}

	public void setUocGroups(List<UocGroup> uocGroups) {
		this.uocGroups = uocGroups;
	}
//
	public UocGroup addUocGroup(UocGroup uocGroup) {
		getUocGroups().add(uocGroup);
		uocGroup.setPathway(this);

		return uocGroup;
	}

	public UocGroup removeUocGroup(UocGroup uocGroup) {
		getUocGroups().remove(uocGroup);
		uocGroup.setPathway(null);

		return uocGroup;
	}

}