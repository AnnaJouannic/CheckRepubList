package checkrepublist.group.api.response;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import checkrepublist.group.model.Categorie;
import checkrepublist.group.model.Critere;
import checkrepublist.group.model.MaterielRef;

public class MaterielRefResponse {

	
	private Integer id;
	
	private String libelleMateriel;
	
	private String categorie;
	
	private List<CritereResponse> criteres=new ArrayList<>();
	

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

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public List<CritereResponse> getCriteres() {
		return criteres;
	}

	public void setCriteres(List<CritereResponse> criteres) {
		this.criteres = criteres;
	}
	
	public static MaterielRefResponse convertVoyage (MaterielRef materielRef) {
		MaterielRefResponse response = new MaterielRefResponse();
		
		BeanUtils.copyProperties(materielRef, response);
		
		response.setCategorie(String.valueOf(materielRef.getCategorie()));
		
		return response;
		
	}
	
	public static MaterielRefResponse convertCritere (MaterielRef materielRef) {
		MaterielRefResponse response = new MaterielRefResponse();
		
		BeanUtils.copyProperties(materielRef, response);
		
		response.setCategorie(String.valueOf(materielRef.getCategorie()));
		response.setCriteres(materielRef.getCriteres().stream().map(CritereResponse::convertBis).collect(Collectors.toList()));
		
		return response;
		
	}
	
	

	
	
}
