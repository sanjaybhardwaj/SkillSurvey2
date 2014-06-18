package au.com.redbackconsulting.skillsurvey.api.bean;

import au.com.redbackconsulting.skillsurvey.persistence.model.SurveryAnswer;

import com.google.gson.annotations.Expose;

public class SurveyAnswerBean {
	@Expose
	private Long uoc_QuestionId;
	@Expose
	private Long surveyId;
	@Expose
	private String value;
	@Expose
	private String answeredAt;

	public Long getUoc_QuestionId() {
		return uoc_QuestionId;
	}

	public void setUoc_QuestionId(Long uoc_QuestionId) {
		this.uoc_QuestionId = uoc_QuestionId;
	}

	public Long getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Long surveyId) {
		this.surveyId = surveyId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getAnsweredAt() {
		return answeredAt;
	}

	public void setAnsweredAt(String answeredAt) {
		this.answeredAt = answeredAt;
	}

	public static SurveyAnswerBean get(SurveryAnswer entity) {
		SurveyAnswerBean bean = new SurveyAnswerBean();
		bean.setAnsweredAt(entity.getAnsweredAt());
		//bean.setSurveyId((entity.getSurvey().getIdsurvey());
		bean.setUoc_QuestionId(entity.getUocQuestion().getIduocquestion());
		bean.setValue(entity.getValue());
		return bean;
	}
	
	

}
