package checkrepublist.group.api.response;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import checkrepublist.group.model.Roles;
import checkrepublist.group.model.Utilisateur;



public class UtilisateurResponse {
	
	private Integer id;
	
	private String nom;
	
	private String prenom;
	
	private String username;
	
	private String mail;
	
	private String tel;

	private String roles;
	
	private List<Integer> idVoyages;

    private List<Integer> idVoyageurs;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}
	
	

	public List<Integer> getIdVoyages() {
		return idVoyages;
	}

	public void setIdVoyages(List<Integer> idVoyages) {
		this.idVoyages = idVoyages;
	}

	public List<Integer> getIdVoyageurs() {
		return idVoyageurs;
	}

	public void setIdVoyageurs(List<Integer> idVoyageurs) {
		this.idVoyageurs = idVoyageurs;
	}

	public static UtilisateurResponse convert(Utilisateur utilisateur) {
		UtilisateurResponse response = new UtilisateurResponse();

		BeanUtils.copyProperties(utilisateur, response);

		response.setRoles(String.join(",", utilisateur.getRoles().stream().map(Roles::name).collect(Collectors.toSet())));
		
		//response.setIdVoyages(utilisateur.getVoyages().stream().map(VoyageResponse::convert).collect(Collectors.toList()));

		//response.setIdVoyageurs(utilisateur.getVoyageurs().stream().map(VoyageurResponse::convertVoyageur).collect(Collectors.toList()));
		
		return response;
	}
}


