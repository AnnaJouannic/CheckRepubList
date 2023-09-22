package checkrepublist.group.api.request;

import checkrepublist.group.model.MaterielRef;
import checkrepublist.group.model.TypeClimat;
import checkrepublist.group.model.TypeDeplacement;
import checkrepublist.group.model.TypeLogement;
import jakarta.validation.constraints.NotBlank;

public class CritereRequest {

	
	private MaterielRef materielref;
	
	private TypeLogement logement;
	
	private TypeDeplacement deplacement;

	private TypeClimat climat;

	public MaterielRef getMaterielref() {
		return materielref;
	}

	public void setMaterielRef(MaterielRef materielref) {
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
