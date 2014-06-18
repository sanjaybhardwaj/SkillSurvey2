package au.com.redbackconsulting.skillsurvey.persistence.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the uoc_group database table.
 * 
 */
@Entity
@Table(name="uoc_group")
@NamedQuery(name="UocGroup.findAll", query="SELECT u FROM UocGroup u")
public class UocGroup implements Serializable,IDBEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int iduocgroup;

	private String notes;

	//bi-directional many-to-many association to Dapssco
	@ManyToMany(mappedBy="uocGroups", fetch=FetchType.EAGER)
	private List<Dapssco> dapsscos;

	//bi-directional many-to-many association to Uoc
	@ManyToMany(mappedBy="uocGroups", fetch=FetchType.EAGER)
	private List<Uoc> uocs;

	//bi-directional many-to-one association to Need
	@ManyToOne
	@JoinColumn(name="need_id")
	private Need need;

	//bi-directional many-to-one association to Pathway
	@ManyToOne
	@JoinColumn(name="pathway_id")
	private Pathway pathway;

	public UocGroup() {
	}

	public int getIduocgroup() {
		return this.iduocgroup;
	}

	public void setIduocgroup(int iduocgroup) {
		this.iduocgroup = iduocgroup;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public List<Dapssco> getDapsscos() {
		return this.dapsscos;
	}

	public void setDapsscos(List<Dapssco> dapsscos) {
		this.dapsscos = dapsscos;
	}

	public List<Uoc> getUocs() {
		return this.uocs;
	}

	public void setUocs(List<Uoc> uocs) {
		this.uocs = uocs;
	}

	public Need getNeed() {
		return this.need;
	}

	public void setNeed(Need need) {
		this.need = need;
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