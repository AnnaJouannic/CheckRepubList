package checkrepublist.group.api.response;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import checkrepublist.group.model.Voyageur;

public class VoyageurResponse {

	private Integer id;
	
	private String nom;
	
	private String prenom;
	
	private LocalDate naissance;
	
	private boolean animal;
	
	private boolean accessibilite;
	
	private List<VoyageResponse> voyages;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getNaissance() {
		return naissance;
	}

	public void setNaissance(LocalDate naissance) {
		this.naissance = naissance;
	}

	public boolean isAnimal() {
		return animal;
	}

	public void setAnimal(boolean animal) {
		this.animal = animal;
	}

	public boolean isAccessibilite() {
		return accessibilite;
	}

	public void setAccessibilite(boolean accessibilite) {
		this.accessibilite = accessibilite;
	}

	
	
	public List<VoyageResponse> getVoyages() {
		return voyages;
	}

	public void setVoyages(List<VoyageResponse> voyages) {
		this.voyages = voyages;
	}

	public static VoyageurResponse convertVoyageur (Voyageur voyageur) {
		VoyageurResponse response = new VoyageurResponse();
		
		BeanUtils.copyProperties(voyageur, response);
		
		response.setVoyages(voyageur.getVoyages().stream().map(VoyageResponse::convertVoyageur).collect(Collectors.toList()));
				
		return response;
		
	}
	
}
