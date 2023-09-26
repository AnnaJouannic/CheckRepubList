package checkrepublist.group.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

import checkrepublist.group.api.Views;
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
	@JsonView(Views.Common.class)
	private Integer id;

	
	@ManyToOne
	@JoinColumn(name="materielref_id")
	@JsonIgnoreProperties("criteres")
	@JsonView(Views.Critere.class)
	private MaterielRef materielref;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('Hotel','Gite','ChambreDHote','Location', 'AirBnB', 'MobilHome', 'Van', 'CampingCar', 'Tente', 'Voiture', Autre, 'Tous')")
	@JsonView(Views.Common.class)
	private TypeLogement logement;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('Marche','Velo','Voiture','Van', 'Campingcar', 'Bateau', 'Train', 'Avion', 'Moto', 'Autre', 'Tous')")
	@JsonView(Views.Common.class)
	private TypeDeplacement deplacement;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('Froid','Chaud','Tempere','Tropical', 'Desertique', 'Autre', 'Tous')")
	@JsonView(Views.Common.class)
	private TypeClimat climat;
	
	@JsonIgnore
	@OneToMany(mappedBy="critere")
	@JsonView(Views.Critere.class)
	private List<ActiviteRef> activites = new ArrayList<>();
	

	public Critere() {
	}
	
	public Critere(MaterielRef materielref) {
		this.materielref = materielref;
	}
	
	
	
	public Critere(TypeLogement logement, TypeDeplacement deplacement, TypeClimat climat) {
		super();
		this.logement = logement;
		this.deplacement = deplacement;
		this.climat = climat;
	}

	public Critere(Integer id, MaterielRef materielref, TypeLogement logement, TypeDeplacement deplacement,
			TypeClimat climat) {
		this.id = id;
		this.materielref = materielref;
		this.logement = logement;
		this.deplacement = deplacement;
		this.climat = climat;
	}

	public Critere(MaterielRef materielref, TypeLogement logement, TypeDeplacement deplacement, TypeClimat climat) {
		this.materielref = materielref;
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

	public MaterielRef getMaterielref() {
		return materielref;
	}

	public void setMaterielref(MaterielRef materielref) {
		this.materielref = materielref;
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
