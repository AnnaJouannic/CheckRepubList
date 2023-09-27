package checkrepublist.group.api.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;

public class VoyageRequest {

	private LocalDate dateDebutVoyage;

	private LocalDate dateFinVoyage;

	@NotBlank
	private String libelle;

	private String pays;

	private String logement;

	private String deplacement;

	private String climat;

	private Integer idVoyageur;

	// private List<ActiviteRef> activites= new ArrayList<>();

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

	public String getLogement() {
		return logement;
	}

	public void setLogement(String logement) {
		this.logement = logement;
	}

	public String getDeplacement() {
		return deplacement;
	}

	public void setDeplacement(String deplacement) {
		this.deplacement = deplacement;
	}

	public String getClimat() {
		return climat;
	}

	public void setClimat(String climat) {
		this.climat = climat;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public Integer getIdVoyageur() {
		return idVoyageur;
	}

	public void setIdVoyageur(Integer idVoyageur) {
		this.idVoyageur = idVoyageur;
	}

	/*
	 * public List<ActiviteRef> getActivites() { return activites; }
	 * 
	 * public void setActivites(List<ActiviteRef> activites) { this.activites =
	 * activites; }
	 */

}
