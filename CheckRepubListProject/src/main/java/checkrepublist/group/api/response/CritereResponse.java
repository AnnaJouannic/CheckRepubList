package checkrepublist.group.api.response;

import checkrepublist.group.model.MaterielRef;
import checkrepublist.group.model.TypeClimat;
import checkrepublist.group.model.TypeDeplacement;
import checkrepublist.group.model.TypeLogement;


public class CritereResponse {
	
	private Integer id;
	
	
	private MaterielRef materielref;
	
	private TypeLogement logement;
	
	private TypeDeplacement deplacement;

	private TypeClimat climat;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public MaterielRef getMaterielref() {
		return materielref;
	}

	public void setMaterielref(MaterielRef materielref) {
		this.materielref = materielref;
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
