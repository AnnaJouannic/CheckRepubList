package checkrepublist.group.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "voyage")
public class Voyage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDate dateVoyage;
	private int duree;
	@Column(length = 25)
	private String libelle;
	@Column(length = 25)
	private String pays;
	
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('Hotel','Gite','ChambreDHote','Location', 'AirBnB', 'MobilHome', 'Van', 'CampingCar', 'Tente', 'Voiture', Autre)")
	private TypeLogement logement;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('Marche','Velo','Voiture','Van', 'Campingcar', 'Bateau', 'Train', 'Avion', 'Moto', 'Autre')")
	private TypeDeplacement deplacement;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('Froid','Chaud','Tempere','Tropical', 'Desertique', 'Autre')")
	private TypeClimat climat;
	
	@OneToMany
	@Column(length = 25)
	private List<ActiviteRef> activites = new ArrayList<>();
	

	public Voyage(Integer id, LocalDate dateVoyage, int duree, String libelle, String pays, TypeLogement logement, TypeDeplacement deplacement, TypeClimat climat) {
		this.id = id;
		this.dateVoyage = dateVoyage;
		this.duree = duree;
		this.libelle = libelle;
		this.pays = pays;
		this.logement = logement;
		this.deplacement = deplacement;
		this.climat = climat;
	}

	public Voyage(LocalDate dateVoyage, int duree, String libelle, String pays, TypeLogement logement,
			TypeDeplacement deplacement, TypeClimat climat) {
		this.dateVoyage = dateVoyage;
		this.duree = duree;
		this.libelle = libelle;
		this.pays = pays;
		this.logement = logement;
		this.deplacement = deplacement;
		this.climat = climat;
	}

	public Integer getId() {
		return id;
	}

	public LocalDate getDateVoyage() {
		return dateVoyage;
	}

	public int getDuree() {
		return duree;
	}

	public String getLibelle() {
		return libelle;
	}

	public String getPays() {
		return pays;
	}

	public TypeLogement getLogement() {
		return logement;
	}

	public List<ActiviteRef> getActivite() {
		return activites;
	}

	public TypeDeplacement getDeplacement() {
		return deplacement;
	}

	public TypeClimat getClimat() {
		return climat;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDateVoyage(LocalDate dateVoyage) {
		this.dateVoyage = dateVoyage;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public void setLogement(TypeLogement logement) {
		this.logement = logement;
	}

	public void setActivite(List<ActiviteRef> activites) {
		this.activites = activites;
	}

	public void setDeplacement(TypeDeplacement deplacement) {
		this.deplacement = deplacement;
	}

	public void setClimat(TypeClimat climat) {
		this.climat = climat;
	}

	@Override
	public String toString() {
		return "Voyage [id=" + id + ", dateVoyage=" + dateVoyage + ", duree=" + duree + ", libelle=" + libelle
				+ ", pays=" + pays + ", logement=" + logement + ", activite=" + activites + ", deplacement="
				+ deplacement + ", climat=" + climat + "]";
	}

}
