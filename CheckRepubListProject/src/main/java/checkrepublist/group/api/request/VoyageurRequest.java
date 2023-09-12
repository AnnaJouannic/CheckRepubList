package checkrepublist.group.api.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;

public class VoyageurRequest {
	
	@NotBlank
	private String nom;
	
	@NotBlank
	private String prenom;
	
	@NotBlank
	private LocalDate naissance;
	
	@NotBlank
	private boolean animal;
	
	@NotBlank
	private boolean accessibilite;

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

	
}
