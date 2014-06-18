package au.com.redbackconsulting.skillsurvey.api.bean;

import au.com.redbackconsulting.skillsurvey.persistence.model.Individual;

import com.google.gson.annotations.Expose;

public class IndividualBean {

	@Expose
	private Long id;

	@Expose
	private String name;

	@Expose
	private String gender;

	@Expose
	private String loginPassword;

	@Expose
	private Long departmentId;

	@Expose
	private Long functionId;

	@Expose
	private Long occupationId;

	@Expose
	private Long levelId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long getFunctionId() {
		return functionId;
	}

	public void setFunctionId(Long functionId) {
		this.functionId = functionId;
	}

	public Long getOccupationId() {
		return occupationId;
	}

	public void setOccupationId(Long occupationId) {
		this.occupationId = occupationId;
	}

	public Long getLevelId() {
		return levelId;
	}

	public void setLevelId(Long levelId) {
		this.levelId = levelId;
	}

	public static IndividualBean get(Individual entity) {
		IndividualBean bean = new IndividualBean();
		bean.setDepartmentId(entity.getDepartment().getIddepartment());
		bean.setFunctionId(entity.getFunction().getIdfunction());
		bean.setGender(entity.getGender());
		//TODO
		//bean.setId(entity.getIdindividual());
		bean.setLevelId(entity.getLevel().getIdlevel());
		//bean.setLoginPassword(loginPassword);
		bean.setName(entity.getName());
		bean.setOccupationId(entity.getOccupation().getIdoccupation());
		return bean;
	}

	
}
