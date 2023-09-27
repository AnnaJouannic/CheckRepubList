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
	
	private String login;
	
	private String mail;
	
	private String tel;

	private String role;
	
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	public void setVoyageurs(List<Integer> voyageurs) {
		this.idVoyageurs = voyageurs;
	}

	public static UtilisateurResponse convert(Utilisateur utilisateur) {
		UtilisateurResponse response = new UtilisateurResponse();

		BeanUtils.copyProperties(utilisateur, response);

		response.setRole(String.join(",", utilisateur.getRole().stream().map(Roles::name).collect(Collectors.toSet())));
		
		//response.setIdVoyages(utilisateur.getVoyages().stream().map(VoyageResponse::convert).collect(Collectors.toList()));

		//response.setIdVoyageurs(utilisateur.getVoyageurs().stream().map(VoyageurResponse::convertVoyageur).collect(Collectors.toList()));
		
		return response;
	}
}


