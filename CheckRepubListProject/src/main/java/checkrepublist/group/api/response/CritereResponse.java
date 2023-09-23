package checkrepublist.group.api.response;

import checkrepublist.group.model.Categorie;
import checkrepublist.group.model.TypeClimat;
import checkrepublist.group.model.TypeDeplacement;
import checkrepublist.group.model.TypeLogement;


public class CritereResponse {
	
	private Integer id;
	
	
	private String libelleMaterielref;
	
	private Categorie categorie;
	
	private TypeLogement logement;
	
	private TypeDeplacement deplacement;

	private TypeClimat climat;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelleMaterielref() {
		return libelleMaterielref;
	}

	public void setLibelleMaterielref(String libelleMaterielref) {
		this.libelleMaterielref = libelleMaterielref;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
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
	
	

}
