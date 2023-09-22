package checkrepublist.group.api.response;

import checkrepublist.group.model.Categorie;

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
