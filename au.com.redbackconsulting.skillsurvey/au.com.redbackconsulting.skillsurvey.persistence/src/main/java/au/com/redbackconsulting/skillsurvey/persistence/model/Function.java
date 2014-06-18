package au.com.redbackconsulting.skillsurvey.persistence.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;



/**
 * The persistent class for the function database table.
 * 
 */
@Entity
@NamedQuery(name="Function.findAll", query="SELECT f FROM Function f")
public class Function implements Serializable, IDBEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idfunction;

	private String description;

	private String name;

	//bi-directional many-to-one association to Individual
	@OneToMany(mappedBy="function", fetch=FetchType.EAGER)
	private List<Individual> individuals;

	//bi-directional many-to-many association to Occupation
	@ManyToMany(mappedBy="functions", fetch=FetchType.EAGER)
	private List<Occupation> occupations;

	public Function() {
	}

	public long getIdfunction() {
		return this.idfunction;
	}

	public void setIdfunction(int idfunction) {
		this.idfunction = idfunction;
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

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return idfunction;
	}

	public List<Individual> getIndividuals() {
		return this.individuals;
	}

	public void setIndividuals(List<Individual> individuals) {
		this.individuals = individuals;
	}

	public Individual addIndividual(Individual individual) {
		getIndividuals().add(individual);
		individual.setFunction(this);

		return individual;
	}

	public Individual removeIndividual(Individual individual) {
		getIndividuals().remove(individual);
		individual.setFunction(null);

		return individual;
	}

	public List<Occupation> getOccupations() {
		return this.occupations;
	}

	public void setOccupations(List<Occupation> occupations) {
		this.occupations = occupations;
	}

}