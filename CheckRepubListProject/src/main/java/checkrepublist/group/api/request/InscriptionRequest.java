package checkrepublist.group.api.request;

import jakarta.validation.constraints.NotBlank;

public class InscriptionRequest {
	@NotBlank
	private String nom;
	
	@NotBlank
	private String prenom;
	
	@NotBlank
	private String login;
	
	@NotBlank
	private String password;
	
	@NotBlank
	private String passwordVerif;
	
	@NotBlank
	private String mail;
	
	@NotBlank
	private String tel;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getPasswordVerif() {
		return passwordVerif;
	}

	public void setPasswordVerif(String passwordVerif) {
		this.passwordVerif = passwordVerif;
	}
	

}
