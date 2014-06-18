package au.com.redbackconsulting.skillsurvey.persistence.model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the survery_answer database table.
 * 
 */
@Entity
@Table(name="survery_answer")
@NamedQuery(name="SurveryAnswer.findAll", query="SELECT s FROM SurveryAnswer s")
public class SurveryAnswer implements Serializable,IDBEntity {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SurveryAnswerPK idpk;

	@Column(name="answered_at")
	private String answeredAt;

	private String value;

	//bi-directional many-to-one association to Survey
	@ManyToOne
	@JoinColumn(name="survey_id")
	private Survey survey;

	//bi-directional many-to-one association to UocQuestion
	@ManyToOne
	@JoinColumn(name="uoc_question_id")
	private UocQuestion uocQuestion;

	public SurveryAnswer() {
	}

	public SurveryAnswerPK getIdpk() {
		return this.idpk;
	}

	public void setId(SurveryAnswerPK idpk) {
		this.idpk = idpk;
	}

	public String getAnsweredAt() {
		return this.answeredAt;
	}

	public void setAnsweredAt(String answeredAt) {
		this.answeredAt = answeredAt;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Survey getSurvey() {
		return this.survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public UocQuestion getUocQuestion() {
		return this.uocQuestion;
	}

	public void setUocQuestion(UocQuestion uocQuestion) {
		this.uocQuestion = uocQuestion;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

}