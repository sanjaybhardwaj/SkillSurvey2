package au.com.redbackconsulting.skillsurvey.persistence.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the uoc database table.
 * 
 */
@Entity
@NamedQuery(name="Uoc.findAll", query="SELECT u FROM Uoc u")
public class Uoc implements Serializable,IDBEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long iduoc;

	private String description;

	private String name;

	private String type;

//	//bi-directional many-to-many association to UocGroup
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="uoc_group_members"
		, joinColumns={
			@JoinColumn(name="uoc_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="uoc_group_id")
			}
		)
	private List<UocGroup> uocGroups;

	//bi-directional many-to-one association to UocQuestion
	@OneToMany(mappedBy="uoc", fetch=FetchType.EAGER)
	private List<UocQuestion> uocQuestions;

	public Uoc() {
	}

	public long getIduoc() {
		return this.iduoc;
	}

	public void setIduoc(long iduoc) {
		this.iduoc = iduoc;
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<UocGroup> getUocGroups() {
		return this.uocGroups;
	}

	public void setUocGroups(List<UocGroup> uocGroups) {
		this.uocGroups = uocGroups;
	}

	public List<UocQuestion> getUocQuestions() {
		return this.uocQuestions;
	}

	public void setUocQuestions(List<UocQuestion> uocQuestions) {
		this.uocQuestions = uocQuestions;
	}

	public UocQuestion addUocQuestion(UocQuestion uocQuestion) {
		getUocQuestions().add(uocQuestion);
		uocQuestion.setUoc(this);

		return uocQuestion;
	}

	public UocQuestion removeUocQuestion(UocQuestion uocQuestion) {
		getUocQuestions().remove(uocQuestion);
		uocQuestion.setUoc(null);

		return uocQuestion;
	}

	@Override
	public Long getId() {
		
		return iduoc;
	}

}