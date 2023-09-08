
package checkrepublist.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Utilisateur extends Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String mail;
	private String tel;
	

	public Utilisateur() {}

	public Utilisateur(Integer id, String nom, String prenom, String login, String password, boolean isAdmin,
			String mail, String tel) {
		super(id, nom, prenom, login, password, isAdmin);
		this.mail = mail;
		this.tel = tel;
	}

	public Utilisateur(String nom, String prenom, String login, String password, boolean isAdmin, String mail,
			String tel) {
		super(nom, prenom, login, password, isAdmin);
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

	@Override
	public String toString() {
		return "Utilisateur [mail=" + mail + ", tel=" + tel + "]";
	}

}
