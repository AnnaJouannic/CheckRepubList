package checkrepublist.group.api.request;

public class CritereRequest {

	
	private MaterielRefRequest materielref;
	
	private String logement;
	
	private String deplacement;

	private String climat;

	public MaterielRefRequest getMaterielref() {
		return materielref;
	}

	public void setMaterielRef(MaterielRefRequest materielref) {
		this.materielref = materielref;
	}

	public String getLogement() {
		return logement;
	}

	public void setLogement(String logement) {
		this.logement = logement;
	}

	public String getDeplacement() {
		return deplacement;
	}

	public void setDeplacement(String deplacement) {
		this.deplacement = deplacement;
	}

	public String getClimat() {
		return climat;
	}

	public void setClimat(String climat) {
		this.climat = climat;
	}
	
	
}
