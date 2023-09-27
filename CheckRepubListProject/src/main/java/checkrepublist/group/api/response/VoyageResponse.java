package checkrepublist.group.api.response;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import checkrepublist.group.model.Voyage;

public class VoyageResponse {
	private Integer id;
	
	private LocalDate dateDebutVoyage;
	
	private LocalDate dateFinVoyage;
	
	private String libelle;
	
	private String pays;
	
	private String logement;
	
	private String deplacement;
	
	private String climat;
	
	//private List<ActiviteRef> activites= new ArrayList<>();
	
	private List<Integer> idMateriels=new ArrayList<>();
	
	private List<Integer> idVoyageurs=new ArrayList<>();
	
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDateDebutVoyage() {
		return dateDebutVoyage;
	}

	public void setDateDebutVoyage(LocalDate dateDebutVoyage) {
		this.dateDebutVoyage = dateDebutVoyage;
	}

	public LocalDate getDateFinVoyage() {
		return dateFinVoyage;
	}

	public void setDateFinVoyage(LocalDate dateFinVoyage) {
		this.dateFinVoyage = dateFinVoyage;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
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

	/*public List<ActiviteRef> getActivites() {
		return activites;
	}

	public void setActivites(List<ActiviteRef> activites) {
		this.activites = activites;
	}*/
	public List<Integer> getIdMateriels() {
		return idMateriels;
	}

	public void setMateriels(List<Integer> idMateriels) {
		this.idMateriels = idMateriels;
	}

	public List<Integer> getIdVoyageurs() {
		return idVoyageurs;
	}

	public void setVoyageurs(List<Integer> idVoyageurs) {
		this.idVoyageurs = idVoyageurs;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}
	
	public static VoyageResponse convert(Voyage voyage) {
		VoyageResponse response = new VoyageResponse();

		BeanUtils.copyProperties(voyage, response);

		response.setLogement(String.valueOf(voyage.getLogement()));
		response.setDeplacement(String.valueOf(voyage.getDeplacement()));
		response.setClimat(String.valueOf(voyage.getClimat()));
		
		//response.setMateriels(String.join(",", voyage.getMateriels().stream().map(voyage).collect(Collectors.toList())));
		//response.setMateriels(List.of(voyage.getMateriels().stream().map(m_-> new MaterielRef(m.getLibelleMaterielRef(), m.getCategorie()).collect(Collectors.toList()))));
		//response.setMateriels(voyage.getMateriels().stream().map(MaterielRefResponse::convertVoyage).collect(Collectors.toList()));
		
		//response.setVoyageurs(voyage.getVoyageurs().stream().map(VoyageurResponse::convertVoyageur).collect(Collectors.toList()));
		
		return response;
	}
	
	public static VoyageResponse convertVoyageur(Voyage voyage) {
		VoyageResponse response = new VoyageResponse();

		BeanUtils.copyProperties(voyage, response);

		response.setLogement(String.valueOf(voyage.getLogement()));
		response.setDeplacement(String.valueOf(voyage.getDeplacement()));
		response.setClimat(String.valueOf(voyage.getClimat()));
		
		//response.setMateriels(String.join(",", voyage.getMateriels().stream().map(voyage).collect(Collectors.toList())));
		//response.setMateriels(List.of(voyage.getMateriels().stream().map(m_-> new MaterielRef(m.getLibelleMaterielRef(), m.getCategorie()).collect(Collectors.toList()))));
		//response.setMateriels(voyage.getMateriels().stream().map(MaterielRefResponse::convertVoyage).collect(Collectors.toList()));
		
		
		return response;
	}
	
}
	
	
	
	

