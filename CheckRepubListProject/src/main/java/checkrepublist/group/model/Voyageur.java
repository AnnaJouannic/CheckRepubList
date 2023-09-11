package checkrepublist.group.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "voyageur")
public class Voyageur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 25)
	private String nom;
	@Column(length = 25)
	private String prenom;
	private Integer age;
	@Column(length = 10)
	private boolean animal;
	@Column(length = 10)
	private boolean accessibilite;
	
	@ManyToMany
	@JoinTable(name="inscription",joinColumns = @JoinColumn(name="voyageur"),inverseJoinColumns = @JoinColumn(name="voyage"))
	private List<Voyage> voyages=new ArrayList();
	
	

	public Voyageur() {}

	public Voyageur(Integer id, String nom, String prenom, Integer age, boolean animal, boolean accessibilite) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.animal = animal;
		this.accessibilite = accessibilite;
	}

	public Voyageur(String nom, String prenom, Integer age, boolean animal, boolean accessibilite) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.animal = animal;
		this.accessibilite = accessibilite;
	}

	public Integer getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public Integer getAge() {
		return age;
	}

	public boolean isAnimal() {
		return animal;
	}

	public boolean isAccessibilite() {
		return accessibilite;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setAnimal(boolean animal) {
		this.animal = animal;
	}

	public void setAccessibilite(boolean accessibilite) {
		this.accessibilite = accessibilite;
	}

	@Override
	public String toString() {
		return "Voyageur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", animal=" + animal
				+ ", accessibilite=" + accessibilite + "]";
	}

}
