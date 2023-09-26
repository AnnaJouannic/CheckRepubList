package checkrepublist.group.api.response;

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

	private String roles;
	
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

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public static UtilisateurResponse convert(Utilisateur utilisateur) {
		UtilisateurResponse response = new UtilisateurResponse();

		// Permer de recopier les infos communes de utilisateur vers response
		BeanUtils.copyProperties(utilisateur, response);

		response.setRoles(String.join(",", utilisateur.getRoles().stream().map(Roles::name).collect(Collectors.toSet())));

		return response;
	}
}


