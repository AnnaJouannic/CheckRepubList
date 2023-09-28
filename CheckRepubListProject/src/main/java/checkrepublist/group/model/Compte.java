package checkrepublist.group.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonView;

import checkrepublist.group.api.Views;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;

@Entity
@Table(name = "compte")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_compte")
public abstract class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	protected Integer id;
	@Column(length = 25)
	@JsonView(Views.Common.class)
	protected String nom;
	@Column(length = 25)
	@JsonView(Views.Common.class)
	protected String prenom;
	@Column(length = 25)
	@JsonView(Views.Common.class)
	protected String login;
	@Column(length = 130)
	protected String password;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "compte_roles", joinColumns = @JoinColumn(name = "utilisateur_id"))
	@Column(name = "role", nullable = false)
	@Enumerated(EnumType.STRING)
	@JsonView(Views.Admin.class)
	protected Set<Roles> roles = new HashSet<>();
	
	public Compte() {}
	
	public Compte(Integer id, String nom, String prenom, String login, String password) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;

	}

	public Compte(String nom, String prenom, String login, String password) {
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
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

	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}


	

	

}
