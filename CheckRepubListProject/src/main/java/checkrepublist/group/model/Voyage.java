package checkrepublist.group.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

import checkrepublist.group.api.Views;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "voyage")
public class Voyage{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	private Integer id;
	
	@JsonView(Views.Common.class)
	private LocalDate dateDebutVoyage;
	
	@JsonView(Views.Common.class)
	private LocalDate dateFinVoyage;
	
	
	@Column(length = 25)
	@JsonView(Views.Common.class)
	private String libelle;
	
	@Column(length = 25)
	@JsonView(Views.Common.class)
	private String pays;
	
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('Hotel','Gite','ChambreDHote','Location', 'AirBnB', 'MobilHome', 'Van', 'CampingCar', 'Tente', 'Voiture', 'Autre', 'Tous')")
	@JsonView(Views.Common.class)
	private TypeLogement logement;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('Marche','Velo','Voiture','Van', 'Campingcar', 'Bateau', 'Train', 'Avion', 'Moto', 'Autre', 'Tous')")
	@JsonView(Views.Common.class)
	private TypeDeplacement deplacement;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('Froid','Chaud','Tempere','Tropical', 'Desertique', 'Autre', 'Tous')")
	@JsonView(Views.Common.class)
	private TypeClimat climat;
	
	@JsonIgnore
	@OneToMany
	@JoinTable(name="activite_voyage",
	joinColumns= @JoinColumn (name="voyage"),
	inverseJoinColumns = @JoinColumn(name="activite"))
	private List<ActiviteRef> activites = new ArrayList<>();
	
	@ManyToMany
	@JsonIgnoreProperties("voyages")
	@JsonView(Views.Common.class)
	private List <Voyageur> voyageurs;
	
	
	@ManyToMany 
	@JoinTable(name="voyagematerielref",joinColumns = @JoinColumn(name="voyage"),inverseJoinColumns = @JoinColumn(name="materielref"))
	@JsonIgnoreProperties("voyages")
	private List<MaterielRef> materiels;
	

	public Voyage() {
	}
	
	public Voyage(Integer id, LocalDate dateDebutVoyage, LocalDate dateFinVoyage, String libelle, String pays, TypeLogement logement, TypeDeplacement deplacement, TypeClimat climat) {
		this.id = id;
		this.dateDebutVoyage = dateDebutVoyage;
		this.dateFinVoyage = dateFinVoyage;
		this.libelle = libelle;
		this.pays = pays;
		this.logement = logement;
		this.deplacement = deplacement;
		this.climat = climat;
	}

	public Voyage(LocalDate dateDebutVoyage, LocalDate dateFinVoyage, String libelle, String pays, TypeLogement logement,
			TypeDeplacement deplacement, TypeClimat climat) {
		this.dateDebutVoyage = dateDebutVoyage;
		this.dateFinVoyage = dateFinVoyage;
		this.libelle = libelle;
		this.pays = pays;
		this.logement = logement;
		this.deplacement = deplacement;
		this.climat = climat;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDateDebutVoyage() {
		return dateDebutVoyage;
	}

	public void setDateDebutVoyage(LocalDate dateDebutVoyage) {
		this.dateDebutVoyage = dateDebutVoyage;
	}

	public LocalDate getDateFinVoyage() {
		return dateFinVoyage;
	}

	public void setDateFinVoyage(LocalDate dateFinVoyage) {
		this.dateFinVoyage = dateFinVoyage;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public TypeLogement getLogement() {
		return logement;
	}

	public void setLogement(TypeLogement logement) {
		this.logement = logement;
	}

	public TypeDeplacement getDeplacement() {
		return deplacement;
	}

	public void setDeplacement(TypeDeplacement deplacement) {
		this.deplacement = deplacement;
	}

	public TypeClimat getClimat() {
		return climat;
	}

	public void setClimat(TypeClimat climat) {
		this.climat = climat;
	}

	public List<ActiviteRef> getActivites() {
		return activites;
	}

	public void setActivites(List<ActiviteRef> activites) {
		this.activites = activites;
	}

	public List<Voyageur> getVoyageurs() {
		return voyageurs;
	}

	public void setVoyageurs(List<Voyageur> voyageurs) {
		this.voyageurs = voyageurs;
	}

	public List<MaterielRef> getMateriels() {
		return materiels;
	}

	public void setMateriels(List<MaterielRef> materiels) {
		this.materiels = materiels;
	}
	

	
	

}
