package checkrepublist.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "activite")
public class ActiviteRef {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column (length = 25)
	private String libelle;
	
	public ActiviteRef() {}

	public ActiviteRef(Integer id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}

	public ActiviteRef(String libelle) {
		this.libelle = libelle;
	}

	public Integer getId() {
		return id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Activite [id=" + id + ", libelle=" + libelle + "]";
	}

}
