
package checkrepublist.group.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import checkrepublist.group.api.Views;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="utilisateur")
@DiscriminatorValue("utilisateur")
public class Utilisateur extends Compte {


	@JsonView(Views.Common.class)
	private String mail;

	@JsonView(Views.Common.class)
	private String tel;
	
	
	@OneToMany
	@JoinTable(name="mes_voyageurs",
	joinColumns= @JoinColumn (name="utilisateur"),
	inverseJoinColumns = @JoinColumn(name="voyageur"))
	@JsonView(Views.Utilisateur.class)
	private List<Voyageur> voyageurs=new ArrayList<>();
	
	@OneToMany
	@JoinTable(name="mes_voyages",
	joinColumns= @JoinColumn (name="utilisateur"),
	inverseJoinColumns = @JoinColumn(name="voyages"))
	@JsonView(Views.Utilisateur.class)
	private List <Voyage> voyages = new ArrayList<>();
	

	public Utilisateur() {}

	public Utilisateur(Integer id, String nom, String prenom, String login, String password,
			String mail, String tel) {
		super(id, nom, prenom, login, password);
		this.mail = mail;
		this.tel = tel;
	}

	public Utilisateur(String nom, String prenom, String login, String password, String mail,
			String tel) {
		super(nom, prenom, login, password);
		this.mail = mail;
		this.tel = tel;
	}

	public String getMail() {
		return mail;
	}

	public String getTel() {
		return tel;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	
	public List<Voyageur> getVoyageurs() {
		return voyageurs;
	}

	public List<Voyage> getVoyages() {
		return voyages;
	}

	public void setVoyageurs(List<Voyageur> voyageurs) {
		this.voyageurs = voyageurs;
	}

	public void setVoyages(List<Voyage> voyages) {
		this.voyages = voyages;
	}

	@Override
	public String toString() {
		return "Utilisateur [mail=" + mail + ", tel=" + tel + "]";
	}

}
