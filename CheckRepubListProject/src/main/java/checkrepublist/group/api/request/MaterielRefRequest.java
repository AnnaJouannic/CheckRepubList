package checkrepublist.group.api.request;

import checkrepublist.group.model.Categorie;
import jakarta.validation.constraints.NotBlank;

public class MaterielRefRequest {

	@NotBlank
	private String libelleMateriel;
	
	
	private Categorie categorie;
	
	
	public String getLibelleMateriel() {
		return libelleMateriel;
	}

	public void setLibelleMateriel(String libelleMateriel) {
		this.libelleMateriel = libelleMateriel;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	

	
	
	
}
