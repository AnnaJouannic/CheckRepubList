package checkrepublist.group.api.response;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import checkrepublist.group.model.MaterielRef;
import checkrepublist.group.model.TypeClimat;
import checkrepublist.group.model.TypeDeplacement;
import checkrepublist.group.model.TypeLogement;
import checkrepublist.group.model.Voyageur;

public class VoyageResponse {
	private Integer id;
	
	private LocalDate dateDebutVoyage;
	
	private LocalDate dateFinVoyage;
	
	private String libelle;
	
	private String pays;
	
	private TypeLogement logement;
	
	private TypeDeplacement deplacement;
	
	private TypeClimat climat;
	
	//private List<ActiviteRef> activites= new ArrayList<>();
	
	private List<MaterielRef> materiels=new ArrayList<>();
	
	private List<Voyageur> voyageurs=new ArrayList<>();

	
	
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
	public List<MaterielRef> getMateriels() {
		return materiels;
	}

	public void setMateriels(List<MaterielRef> materiels) {
		this.materiels = materiels;
	}

	public List<Voyageur> getVoyageurs() {
		return voyageurs;
	}

	public void setVoyageurs(List<Voyageur> voyageurs) {
		this.voyageurs = voyageurs;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}
	
	
	
	
}
