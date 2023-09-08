package checkrepublist.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "materiel")
public class Materiel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 25)
	private String libelle;
	@Column(length = 25)
	private double qteMateriel;

	public Materiel() {}

	public Materiel(Integer id, String libelle, double qteMateriel) {
		this.id = id;
		this.libelle = libelle;
		this.qteMateriel = qteMateriel;
	}

	public Materiel(String libelle, double qteMateriel) {
		this.libelle = libelle;
		this.qteMateriel = qteMateriel;
	}

	public Integer getId() {
		return id;
	}

	public String getLibelle() {
		return libelle;
	}

	public double getQteMateriel() {
		return qteMateriel;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public void setQteMateriel(double qteMateriel) {
		this.qteMateriel = qteMateriel;
	}

	@Override
	public String toString() {
		return "Materiel [id=" + id + ", libelle=" + libelle + ", qteMateriel=" + qteMateriel + "]";
	}

}
