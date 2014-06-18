package au.com.redbackconsulting.skillsurvey.persistence.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the occupation database table.
 * 
 */
@Entity
@NamedQuery(name="Occupation.findAll", query="SELECT o FROM Occupation o")
public class Occupation implements Serializable, IDBEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idoccupation;

	private String description;

	private String name;

//	//bi-directional many-to-one association to Dapssco
	@OneToMany(mappedBy="occupation", fetch=FetchType.EAGER)
	private List<Dapssco> dapsscos;
//
//	//bi-directional many-to-one association to Individual
	@OneToMany(mappedBy="occupation", fetch=FetchType.EAGER)
	private List<Individual> individuals;

	//bi-directional many-to-many association to Function
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="function_occupations"
		, joinColumns={
			@JoinColumn(name="occupation_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="function_id")
			}
		)
	private List<Function> functions;

	public Occupation() {
	}

	public long getIdoccupation() {
		return this.idoccupation;
	}

	public void setIdoccupation(long idoccupation) {
		this.idoccupation = idoccupation;
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

	public List<Dapssco> getDapsscos() {
		return this.dapsscos;
	}

	public void setDapsscos(List<Dapssco> dapsscos) {
		this.dapsscos = dapsscos;
	}

	public Dapssco addDapssco(Dapssco dapssco) {
		getDapsscos().add(dapssco);
		dapssco.setOccupation(this);

		return dapssco;
	}

	public Dapssco removeDapssco(Dapssco dapssco) {
		getDapsscos().remove(dapssco);
		dapssco.setOccupation(null);

		return dapssco;
	}

	public List<Individual> getIndividuals() {
		return this.individuals;
	}

	public void setIndividuals(List<Individual> individuals) {
		this.individuals = individuals;
	}

	public Individual addIndividual(Individual individual) {
		getIndividuals().add(individual);
		individual.setOccupation(this);

		return individual;
	}

	public Individual removeIndividual(Individual individual) {
		getIndividuals().remove(individual);
		individual.setOccupation(null);

		return individual;
	}

	public List<Function> getFunctions() {
		return this.functions;
	}

	public void setFunctions(List<Function> functions) {
		this.functions = functions;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return idoccupation;
	}

}