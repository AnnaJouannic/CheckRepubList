package checkrepublist.model;

import java.beans.Transient;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "inscription")
public class Inscription {
	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private Integer id;
	
	private Voyageur voyageur;

	
	public Inscription() {}
	
	public Inscription(Integer id, Voyageur voyageur) {
		this.id = id;
		this.voyageur = voyageur;
	}

	public Integer getId() {
		return id;
	}

	public Voyageur getVoyageur() {
		return voyageur;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setVoyageur(Voyageur voyageur) {
		this.voyageur = voyageur;
	}

	@Override
	public String toString() {
		return "Inscription [id=" + id + ", voyageur=" + voyageur + "]";
	}

}
