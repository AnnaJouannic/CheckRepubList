package checkrepublist.group.api.response;

import org.springframework.beans.BeanUtils;

import checkrepublist.group.model.Critere;


public class CritereResponse {
	
	private Integer id;
	
	private String logement;
	
	private String deplacement;

	private String climat;
	
	private Integer idMaterielref;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdMaterielref() {
		return idMaterielref;
	}

	public void setIdMaterielref(Integer idMaterielref) {
		this.idMaterielref = idMaterielref;
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
	
	public static CritereResponse convert (Critere critere) {
		CritereResponse response = new CritereResponse();
		
		BeanUtils.copyProperties(critere, response);
		
		response.setLogement(String.valueOf(critere.getLogement()));
		response.setDeplacement(String.valueOf(critere.getDeplacement()));
		response.setClimat(String.valueOf(critere.getClimat()));
		response.setIdMaterielref(Integer.valueOf(critere.getMaterielref().getId()));
		return response;
		
		
	}
	
	public static CritereResponse convertBis (Critere critere) {
CritereResponse response = new CritereResponse();
		
		BeanUtils.copyProperties(critere, response);
		
		response.setLogement(String.valueOf(critere.getLogement()));
		response.setDeplacement(String.valueOf(critere.getDeplacement()));
		response.setClimat(String.valueOf(critere.getClimat()));
		
		return response;
	}
	

}
