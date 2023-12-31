package checkrepublist.group.api.response;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import checkrepublist.group.model.MaterielRef;

public class MaterielRefResponse {

	
	private Integer id;
	
	private String libelleMateriel;
	
	private String categorie;
	
	//private List<Integer> idCriteres=new ArrayList<>();
	

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

	/*public List<Integer> getIdCriteres() {
		return idCriteres;
	}

	public void setIdCriteres(List<Integer> idCriteres) {
		this.idCriteres = idCriteres;
	}*/
	

	public static MaterielRefResponse convertCritere (MaterielRef materielRef) {
		MaterielRefResponse response = new MaterielRefResponse();
		
		BeanUtils.copyProperties(materielRef, response);
		
		response.setCategorie(String.valueOf(materielRef.getCategorie()));
		
		//response.setIdCriteres(materielRef.getCriteres().stream().map(CritereResponse::convert).collect(Collectors.toList()));
		

		return response;
		}

		public static MaterielRefResponse convertVoyage (MaterielRef materielRef) {
			MaterielRefResponse response = new MaterielRefResponse();
			
			BeanUtils.copyProperties(materielRef, response);
			
			response.setCategorie(String.valueOf(materielRef.getCategorie()));
			
			//response.setIdCriteres(materielRef.getCriteres().stream().map(CritereResponse::convert).collect(Collectors.toList()));
			

			return response;
	}
	
	

	
	
}
