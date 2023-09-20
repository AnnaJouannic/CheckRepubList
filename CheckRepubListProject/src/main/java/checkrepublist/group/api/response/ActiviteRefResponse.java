package checkrepublist.group.api.response;

import jakarta.validation.constraints.NotBlank;

public class ActiviteRefResponse {
	
	@NotBlank
	private String libelle;
	

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
}
