package checkrepublist.group.api.request;

import jakarta.validation.constraints.NotBlank;

public class MaterielRefRequest {

	private String libelleMateriel;
	
	
	private String categorie;
	
	
	public String getLibelleMateriel() {
		return libelleMateriel;
	}

	public void setLibelleMateriel(String libelleMateriel) {
		this.libelleMateriel = libelleMateriel;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}	
	
}
