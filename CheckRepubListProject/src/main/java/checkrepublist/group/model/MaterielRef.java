package checkrepublist.group.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "materielref")

public class MaterielRef {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String libelleMateriel;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('Vetement','Numerique', 'Outils', 'Toilette', 'Animaux', 'Pharmacie', 'Administratif')")
	private Categorie categorie;
	
	

	@OneToMany
	@JoinTable(
            name="materiel_critere",
            joinColumns = @JoinColumn(name="materiel"),
            inverseJoinColumns = @JoinColumn(name="critere")
            )
	List<Critere> criteres = new ArrayList<>();
	
	public MaterielRef() {}


	public MaterielRef(Integer id, String libelleMateriel, Categorie categorie) {
		this.id = id;
		this.libelleMateriel = libelleMateriel;
		this.categorie = categorie;
	}


	public MaterielRef(String libelleMateriel, Categorie categorie) {
		this.libelleMateriel = libelleMateriel;
		this.categorie = categorie;
	}

	public Integer getId() {
		return id;
	}

	public String getLibelle() {
		return libelleMateriel;
	}



	public void setId(Integer id) {
		this.id = id;
	}

	public void setLibelle(String libelleMateriel) {
		this.libelleMateriel = libelleMateriel;
	}


	public List<Critere> getCriteres() {
		return criteres;
	}


	public void setCriteres(List<Critere> criteres) {
		this.criteres = criteres;
	}

	


}
