package checkrepublist.group.api.request;

import jakarta.validation.constraints.NotBlank;

public class ActiviteRefRequest {
	
	@NotBlank
	private String libelle;
	

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
}
