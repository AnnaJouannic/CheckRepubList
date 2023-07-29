package model;

public abstract class Compte {
	
	protected Integer id;
	protected String nom;
	protected String prenom;
	protected String login;
	protected String password;
	protected boolean isAdmin;
	
	
	
		public Compte(Integer id, String nom, String prenom, String login, String password, boolean isAdmin) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.isAdmin = isAdmin;
	}
	

		public Compte(String nom, String prenom, String login, String password, boolean isAdmin) {
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.isAdmin = isAdmin;
	}


	public Integer getId() {
		return id;
	}



	public String getNom() {
		return nom;
	}



	public String getPrenom() {
		return prenom;
	}



	public String getLogin() {
		return login;
	}



	public String getPassword() {
		return password;
	}



	public boolean isAdmin() {
		return isAdmin;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}


	@Override
	public String toString() {
		return "Compte [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", login=" + login + ", password="
				+ password + ", isAdmin=" + isAdmin + "]";
	}
	
	
}
