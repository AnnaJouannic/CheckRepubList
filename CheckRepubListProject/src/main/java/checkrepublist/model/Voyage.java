package checkrepublist.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	@Column(length = 25)
	private Logement logement;
	@Column(length = 25)
	private Activite activite;
	@Column(length = 25, nullable = false)
	private ModeDeplacement deplacement;
	@Column(length = 25, nullable = false)
	private Climat climat;

	public Voyage(Integer id, LocalDate dateVoyage, int duree, String libelle, String pays, Logement logement,
			Activite activite, ModeDeplacement deplacement, Climat climat) {
		this.id = id;
		this.dateVoyage = dateVoyage;
		this.duree = duree;
		this.libelle = libelle;
		this.pays = pays;
		this.logement = logement;
		this.activite = activite;
		this.deplacement = deplacement;
		this.climat = climat;
	}

	public Voyage(LocalDate dateVoyage, int duree, String libelle, String pays, Logement logement, Activite activite,
			ModeDeplacement deplacement, Climat climat) {
		this.dateVoyage = dateVoyage;
		this.duree = duree;
		this.libelle = libelle;
		this.pays = pays;
		this.logement = logement;
		this.activite = activite;
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

	public Logement getLogement() {
		return logement;
	}

	public Activite getActivite() {
		return activite;
	}

	public ModeDeplacement getDeplacement() {
		return deplacement;
	}

	public Climat getClimat() {
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

	public void setLogement(Logement logement) {
		this.logement = logement;
	}

	public void setActivite(Activite activite) {
		this.activite = activite;
	}

	public void setDeplacement(ModeDeplacement deplacement) {
		this.deplacement = deplacement;
	}

	public void setClimat(Climat climat) {
		this.climat = climat;
	}

	@Override
	public String toString() {
		return "Voyage [id=" + id + ", dateVoyage=" + dateVoyage + ", duree=" + duree + ", libelle=" + libelle
				+ ", pays=" + pays + ", logement=" + logement + ", activite=" + activite + ", deplacement="
				+ deplacement + ", climat=" + climat + "]";
	}

}
