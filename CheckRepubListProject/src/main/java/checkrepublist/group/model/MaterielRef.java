package checkrepublist.group.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import checkrepublist.group.api.Views;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "materielref")
public class MaterielRef{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	private Integer id;
	
	@JsonView(Views.Common.class)
	private String libelleMateriel;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('Vetement','Numerique', 'Outils', 'Toilette', 'Animaux', 'Pharmacie', 'Administratif')")
	@JsonView(Views.Common.class)
	private Categorie categorie;
	

	@OneToMany(mappedBy = "materielref")
	@JsonView(Views.MaterielRef.class)
	private List<Critere> criteres = new ArrayList<>();
	
	
	@ManyToMany(mappedBy="materiels")
	@JsonView(Views.MaterielRef.class)
	private List<Voyage> voyages;
	
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


	public void setId(Integer id) {
		this.id = id;
	}


	public String getLibelleMateriel() {
		return libelleMateriel;
	}


	public void setLibelleMateriel(String libelleMateriel) {
		this.libelleMateriel = libelleMateriel;
	}


	public Categorie getCategorie() {
		return categorie;
	}


	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}


	public List<Critere> getCriteres() {
		return criteres;
	}


	public void setCriteres(List<Critere> criteres) {
		this.criteres = criteres;
	}


	public List<Voyage> getVoyages() {
		return voyages;
	}


	public void setVoyages(List<Voyage> voyages) {
		this.voyages = voyages;
	}


	


}
