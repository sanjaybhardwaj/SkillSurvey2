package au.com.redbackconsulting.skillsurvey.persistence.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the individual database table.
 * 
 */
@Entity
@NamedQuery(name="Individual.findAll", query="SELECT i FROM Individual i")
public class Individual implements Serializable,IDBEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idindividual;

	private String gender;

	private String login;

	private String name;

	private String password;

	//bi-directional many-to-one association to Department
	@ManyToOne
	@JoinColumn(name="department_id")
	private Department department;

	//bi-directional many-to-one association to Function
	@ManyToOne
	@JoinColumn(name="function_id")
	private Function function;

	//bi-directional many-to-many association to Individual
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="supervisons"
		, joinColumns={
			@JoinColumn(name="supervisedid")
			}
		, inverseJoinColumns={
			@JoinColumn(name="supervisorid")
			}
		)
	private List<Individual> individuals1;

	//bi-directional many-to-many association to Individual
	@ManyToMany(mappedBy="individuals1", fetch=FetchType.EAGER)
	private List<Individual> individuals2;

	//bi-directional many-to-one association to Level
	@ManyToOne
	@JoinColumn(name="level_id")
	private Level level;

	//bi-directional many-to-one association to Occupation
	@ManyToOne
	@JoinColumn(name="occuption_id")
	private Occupation occupation;

	//bi-directional many-to-one association to RoleAssignment
	@OneToMany(mappedBy="individual", fetch=FetchType.EAGER)
	private List<RoleAssignment> roleAssignments;

	//bi-directional many-to-one association to Survey
	@OneToMany(mappedBy="individual", fetch=FetchType.EAGER)
	private List<Survey> surveys;

	public Individual() {
	}

	public int getIdindividual() {
		return this.idindividual;
	}

	public void setIdindividual(int idindividual) {
		this.idindividual = idindividual;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Function getFunction() {
		return this.function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

	public List<Individual> getIndividuals1() {
		return this.individuals1;
	}

	public void setIndividuals1(List<Individual> individuals1) {
		this.individuals1 = individuals1;
	}

	public List<Individual> getIndividuals2() {
		return this.individuals2;
	}

	public void setIndividuals2(List<Individual> individuals2) {
		this.individuals2 = individuals2;
	}

	public Level getLevel() {
		return this.level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public Occupation getOccupation() {
		return this.occupation;
	}

	public void setOccupation(Occupation occupation) {
		this.occupation = occupation;
	}

	public List<RoleAssignment> getRoleAssignments() {
		return this.roleAssignments;
	}

	public void setRoleAssignments(List<RoleAssignment> roleAssignments) {
		this.roleAssignments = roleAssignments;
	}

	public RoleAssignment addRoleAssignment(RoleAssignment roleAssignment) {
		getRoleAssignments().add(roleAssignment);
		roleAssignment.setIndividual(this);

		return roleAssignment;
	}

	public RoleAssignment removeRoleAssignment(RoleAssignment roleAssignment) {
		getRoleAssignments().remove(roleAssignment);
		roleAssignment.setIndividual(null);

		return roleAssignment;
	}

	public List<Survey> getSurveys() {
		return this.surveys;
	}

	public void setSurveys(List<Survey> surveys) {
		this.surveys = surveys;
	}

	public Survey addSurvey(Survey survey) {
		getSurveys().add(survey);
		survey.setIndividual(this);

		return survey;
	}

	public Survey removeSurvey(Survey survey) {
		getSurveys().remove(survey);
		survey.setIndividual(null);

		return survey;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

}