package checkrepublist.group.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "critere")
public class Critere {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name="libelleMateriel")
	private MaterielRef libelleMateriel;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('Hotel','Gite','ChambreDHote','Location', 'AirBnB', 'MobilHome', 'Van', 'CampingCar', 'Tente', 'Voiture', Autre)")
	private TypeLogement logement;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('Marche','Velo','Voiture','Van', 'Campingcar', 'Bateau', 'Train', 'Avion', 'Moto', 'Autre')")
	private TypeDeplacement deplacement;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('Froid','Chaud','Tempere','Tropical', 'Desertique', 'Autre')")
	private TypeClimat climat;
	
	@OneToMany(mappedBy="critere")
	private List<ActiviteRef> activites = new ArrayList<>();
	

	public Critere() {
	}
	
	public Critere(Integer id, MaterielRef libelleMateriel, TypeLogement logement, TypeDeplacement deplacement,
			TypeClimat climat) {
		this.id = id;
		this.libelleMateriel = libelleMateriel;
		this.logement = logement;
		this.deplacement = deplacement;
		this.climat = climat;
	}

	public Critere(MaterielRef libelleMateriel, TypeLogement logement, TypeDeplacement deplacement, TypeClimat climat) {
		this.libelleMateriel = libelleMateriel;
		this.logement = logement;
		this.deplacement = deplacement;
		this.climat = climat;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public MaterielRef getLibelleMateriel() {
		return libelleMateriel;
	}

	public void setLibelleMateriel(MaterielRef libelleMateriel) {
		this.libelleMateriel = libelleMateriel;
	}

	public TypeLogement getLogement() {
		return logement;
	}

	public void setLogement(TypeLogement logement) {
		this.logement = logement;
	}

	public TypeDeplacement getDeplacement() {
		return deplacement;
	}

	public void setDeplacement(TypeDeplacement deplacement) {
		this.deplacement = deplacement;
	}

	public TypeClimat getClimat() {
		return climat;
	}

	public void setClimat(TypeClimat climat) {
		this.climat = climat;
	}

	public List<ActiviteRef> getActivites() {
		return activites;
	}

	public void setActivites(List<ActiviteRef> activites) {
		this.activites = activites;
	}
	

}
