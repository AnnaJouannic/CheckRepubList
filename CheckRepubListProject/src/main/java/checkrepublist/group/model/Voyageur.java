package checkrepublist.group.model;

import java.time.LocalDate;
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
	private LocalDate naissance;
	@Column(length = 10)
	private boolean animal;
	@Column(length = 10)
	private boolean accessibilite;
	
	@ManyToMany
	@JoinTable(name="inscription",joinColumns = @JoinColumn(name="voyageur"),inverseJoinColumns = @JoinColumn(name="voyage"))
	private List<Voyage> voyages=new ArrayList();
	
	

	public Voyageur() {}

	public Voyageur(Integer id, String nom, String prenom, LocalDate naissance, boolean animal, boolean accessibilite) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.naissance = naissance;
		this.animal = animal;
		this.accessibilite = accessibilite;
	}

	public Voyageur(String nom, String prenom, LocalDate naissance, boolean animal, boolean accessibilite) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.naissance= naissance;
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

	public LocalDate getNaissance() {
		return naissance;
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

	public void setNaissance(LocalDate naissance) {
		this.naissance = naissance;
	}

	public void setAnimal(boolean animal) {
		this.animal = animal;
	}

	public void setAccessibilite(boolean accessibilite) {
		this.accessibilite = accessibilite;
	}

	public List<Voyage> getVoyages() {
		return voyages;
	}

	public void setVoyages(List<Voyage> voyages) {
		this.voyages = voyages;
	}

	@Override
	public String toString() {
		return "Voyageur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", naissance=" + naissance + ", animal=" + animal
				+ ", accessibilite=" + accessibilite + "]";
	}

}
