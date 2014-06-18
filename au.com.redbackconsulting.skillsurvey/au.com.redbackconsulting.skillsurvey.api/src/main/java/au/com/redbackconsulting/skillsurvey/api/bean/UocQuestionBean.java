package au.com.redbackconsulting.skillsurvey.api.bean;

import au.com.redbackconsulting.skillsurvey.persistence.model.UocQuestion;

import com.google.gson.annotations.Expose;

public class UocQuestionBean {
@Expose	
private Long id;
@Expose
private Long uoc_Id;
@Expose
private Long questionId;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Long getUoc_Id() {
	return uoc_Id;
}

public void setUoc_Id(Long uoc_Id) {
	this.uoc_Id = uoc_Id;
}

public Long getQuestionId() {
	return questionId;
}

public void setQuestionId(Long questionId) {
	this.questionId = questionId;
}

public static UocQuestionBean get(UocQuestion entity) {
	UocQuestionBean bean = new UocQuestionBean();
	bean.setId(entity.getIduocquestion());
	bean.setQuestionId(entity.getQuestion().getIdquestion());
	bean.setUoc_Id(entity.getUoc().getIduoc());
	return bean;
}



}
