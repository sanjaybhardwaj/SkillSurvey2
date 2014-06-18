package au.com.redbackconsulting.skillsurvey.persistence.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the level database table.
 * 
 */
@Entity
@NamedQuery(name="Level.findAll", query="SELECT l FROM Level l")
public class Level implements Serializable, IDBEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long idlevel;

	private String code;

	private String description;

	//bi-directional many-to-one association to Individual
	@OneToMany(mappedBy="level", fetch=FetchType.EAGER)
	private List<Individual> individuals;

	//bi-directional many-to-many association to Dapssco
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="dapssco_levels"
		, joinColumns={
			@JoinColumn(name="level_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="dapssco_id")
			}
		)
	private List<Dapssco> dapsscos;

	public Level() {
	}

	public long getIdlevel() {
		return this.idlevel;
	}

	public void setIdlevel(long idlevel) {
		this.idlevel = idlevel;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Individual> getIndividuals() {
		return this.individuals;
	}

	public void setIndividuals(List<Individual> individuals) {
		this.individuals = individuals;
	}

	public Individual addIndividual(Individual individual) {
		getIndividuals().add(individual);
		individual.setLevel(this);

		return individual;
	}

	public Individual removeIndividual(Individual individual) {
		getIndividuals().remove(individual);
		individual.setLevel(null);

		return individual;
	}

	public List<Dapssco> getDapsscos() {
		return this.dapsscos;
	}

	public void setDapsscos(List<Dapssco> dapsscos) {
		this.dapsscos = dapsscos;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub

		return Long.valueOf(idlevel);
	}

}