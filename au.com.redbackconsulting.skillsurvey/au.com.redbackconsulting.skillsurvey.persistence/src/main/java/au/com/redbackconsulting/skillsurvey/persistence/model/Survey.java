package au.com.redbackconsulting.skillsurvey.persistence.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the survey database table.
 * 
 */
@Entity
@NamedQuery(name="Survey.findAll", query="SELECT s FROM Survey s")
public class Survey implements Serializable,IDBEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idsurvey;

	@Temporal(TemporalType.DATE)
	@Column(name="completed_at")
	private Date completedAt;

	@Temporal(TemporalType.DATE)
	@Column(name="started_at")
	private Date startedAt;

//	//bi-directional many-to-one association to SurveryAnswer
	@OneToMany(mappedBy="survey", fetch=FetchType.EAGER)
	private List<SurveryAnswer> surveryAnswers;

	//bi-directional many-to-one association to Dapssco
	@ManyToOne
	@JoinColumn(name="dapsscoid")
	private Dapssco dapssco;

	//bi-directional many-to-one association to Individual
	@ManyToOne
	@JoinColumn(name="individualid")
	private Individual individual;

	//bi-directional many-to-one association to Pathway
	@ManyToOne
	@JoinColumn(name="pathwayid")
	private Pathway pathway;

	public Survey() {
	}

	public int getIdsurvey() {
		return this.idsurvey;
	}

	public void setIdsurvey(int idsurvey) {
		this.idsurvey = idsurvey;
	}

	public Date getCompletedAt() {
		return this.completedAt;
	}

	public void setCompletedAt(Date completedAt) {
		this.completedAt = completedAt;
	}

	public Date getStartedAt() {
		return this.startedAt;
	}

	public void setStartedAt(Date startedAt) {
		this.startedAt = startedAt;
	}

	public List<SurveryAnswer> getSurveryAnswers() {
		return this.surveryAnswers;
	}

	public void setSurveryAnswers(List<SurveryAnswer> surveryAnswers) {
		this.surveryAnswers = surveryAnswers;
	}

	public SurveryAnswer addSurveryAnswer(SurveryAnswer surveryAnswer) {
		getSurveryAnswers().add(surveryAnswer);
		surveryAnswer.setSurvey(this);

		return surveryAnswer;
	}

	public SurveryAnswer removeSurveryAnswer(SurveryAnswer surveryAnswer) {
		getSurveryAnswers().remove(surveryAnswer);
		surveryAnswer.setSurvey(null);

		return surveryAnswer;
	}

	public Dapssco getDapssco() {
		return this.dapssco;
	}

	public void setDapssco(Dapssco dapssco) {
		this.dapssco = dapssco;
	}

	public Individual getIndividual() {
		return this.individual;
	}

	public void setIndividual(Individual individual) {
		this.individual = individual;
	}

	public Pathway getPathway() {
		return this.pathway;
	}

	public void setPathway(Pathway pathway) {
		this.pathway = pathway;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

}