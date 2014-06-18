package au.com.redbackconsulting.skillsurvey.persistence.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the dapssco database table.
 * 
 */
@Entity
@NamedQuery(name="Dapssco.findAll", query="SELECT d FROM Dapssco d")
public class Dapssco implements Serializable, IDBEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int iddepssco;

	@Column(name="level_id")
	private long levelId;

	//bi-directional many-to-one association to Occupation
	@ManyToOne
	@JoinColumn(name="occup_id")
	private Occupation occupation;

	//bi-directional many-to-many association to UocGroup
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="dapssco_skills"
		, joinColumns={
			@JoinColumn(name="dapssco_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="uoc_group_id")
			}
		)
	private List<UocGroup> uocGroups;

	//bi-directional many-to-many association to Level
	@ManyToMany(mappedBy="dapsscos", fetch=FetchType.EAGER)
	private List<Level> levels;

	//bi-directional many-to-one association to Survey
	@OneToMany(mappedBy="dapssco", fetch=FetchType.EAGER)
	private List<Survey> surveys;

	public Dapssco() {
	}

	public int getIddepssco() {
		return this.iddepssco;
	}

	public void setIddepssco(int iddepssco) {
		this.iddepssco = iddepssco;
	}

	public long getLevelId() {
		return this.levelId;
	}

	public void setLevelId(long levelId) {
		this.levelId = levelId;
	}

	public Occupation getOccupation() {
		return this.occupation;
	}

	public void setOccupation(Occupation occupation) {
		this.occupation = occupation;
	}

	public List<UocGroup> getUocGroups() {
		return this.uocGroups;
	}

	public void setUocGroups(List<UocGroup> uocGroups) {
		this.uocGroups = uocGroups;
	}

	public List<Level> getLevels() {
		return this.levels;
	}

	public void setLevels(List<Level> levels) {
		this.levels = levels;
	}

	public List<Survey> getSurveys() {
		return this.surveys;
	}

	public void setSurveys(List<Survey> surveys) {
		this.surveys = surveys;
	}

	public Survey addSurvey(Survey survey) {
		getSurveys().add(survey);
		survey.setDapssco(this);

		return survey;
	}

	public Survey removeSurvey(Survey survey) {
		getSurveys().remove(survey);
		survey.setDapssco(null);

		return survey;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

}