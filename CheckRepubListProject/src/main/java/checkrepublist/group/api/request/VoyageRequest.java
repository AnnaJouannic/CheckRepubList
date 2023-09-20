package checkrepublist.group.api.request;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import checkrepublist.group.model.ActiviteRef;
import checkrepublist.group.model.TypeClimat;
import checkrepublist.group.model.TypeDeplacement;
import checkrepublist.group.model.TypeLogement;
import jakarta.validation.constraints.NotBlank;

public class VoyageRequest {
	
	@NotBlank
	private LocalDate dateDebutVoyage;
	
	@NotBlank
	private LocalDate dateFinVoyage;
	
	@NotBlank
	private String libelle;
	
	@NotBlank
	private TypeLogement logement;
	
	@NotBlank
	private TypeDeplacement deplacement;
	
	@NotBlank
	private TypeClimat climat;
	
	//private List<ActiviteRef> activites= new ArrayList<>();

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

	/*public List<ActiviteRef> getActivites() {
		return activites;
	}

	public void setActivites(List<ActiviteRef> activites) {
		this.activites = activites;
	}*/

	
}
