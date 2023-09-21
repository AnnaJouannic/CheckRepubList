package checkrepublist.group.api.response;

import java.util.List;

import checkrepublist.group.model.Categorie;
import checkrepublist.group.model.Critere;

public class MaterielRefResponse {

	
	private Integer id;
	
	private String libelleMateriel;
	
	private Categorie categorie;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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
