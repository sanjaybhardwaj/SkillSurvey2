package au.com.redbackconsulting.skillsurvey.persistence.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the survery_answer database table.
 * 
 */
@Embeddable
public class SurveryAnswerPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="uoc_question_id", insertable=false, updatable=false)
	private int uocQuestionId;

	@Column(name="survey_id", insertable=false, updatable=false)
	private int surveyId;

	public SurveryAnswerPK() {
	}
	public int getUocQuestionId() {
		return this.uocQuestionId;
	}
	public void setUocQuestionId(int uocQuestionId) {
		this.uocQuestionId = uocQuestionId;
	}
	public int getSurveyId() {
		return this.surveyId;
	}
	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SurveryAnswerPK)) {
			return false;
		}
		SurveryAnswerPK castOther = (SurveryAnswerPK)other;
		return 
			(this.uocQuestionId == castOther.uocQuestionId)
			&& (this.surveyId == castOther.surveyId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.uocQuestionId;
		hash = hash * prime + this.surveyId;
		
		return hash;
	}
}