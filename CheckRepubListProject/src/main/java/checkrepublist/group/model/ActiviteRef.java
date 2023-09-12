package checkrepublist.group.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "activite")
public class ActiviteRef {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column (length = 25)
	private String libelle;
	
	@ManyToOne
	@JoinColumn(name="critere")
	private Critere critere;
	
	public ActiviteRef() {}

	public ActiviteRef(Integer id, String libelle) {
		this.id = id;
		this.libelle = libelle;
		
	}

	public ActiviteRef(Integer id, String libelle, Critere critere) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.critere = critere;
	}
	
	public ActiviteRef(String libelle, Critere critere) {
		super();
		this.libelle = libelle;
		this.critere = critere;
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

	
	
	public Critere getCritere() {
		return critere;
	}

	public void setCritere(Critere critere) {
		this.critere = critere;
	}

	@Override
	public String toString() {
		return "Activite [id=" + id + ", libelle=" + libelle + "]";
	}

}
