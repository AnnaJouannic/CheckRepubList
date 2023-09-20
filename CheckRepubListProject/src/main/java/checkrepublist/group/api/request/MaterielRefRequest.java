package checkrepublist.group.api.request;

import java.util.ArrayList;
import java.util.List;

import checkrepublist.group.model.Categorie;
import checkrepublist.group.model.Critere;
import jakarta.validation.constraints.NotBlank;

public class MaterielRefRequest {

	@NotBlank
	private String libelleMateriel;
	
	@NotBlank
	private Categorie categorie;
	
	List<Critere> criteres;

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

	public List<Critere> getCriteres() {
		return criteres;
	}

	public void setCriteres(List<Critere> criteres) {
		this.criteres = criteres;
	}
	
	
	
}
