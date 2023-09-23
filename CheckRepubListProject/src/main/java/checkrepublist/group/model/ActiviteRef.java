package checkrepublist.group.model;

import com.fasterxml.jackson.annotation.JsonView;

import checkrepublist.group.api.Views;
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
	@JsonView(Views.Activite.class)
	private Integer id;
	@Column (length = 25)
	@JsonView(Views.Activite.class)
	private String libelleActivite;
	
	@ManyToOne
	@JoinColumn(name="critere")
	@JsonView(Views.ActiviteDetail.class)
	private Critere critere;
	
	public ActiviteRef() {}

	public ActiviteRef(Integer id, String libelleActivite) {
		this.id = id;
		this.libelleActivite = libelleActivite;
		
	}

	public ActiviteRef(Integer id, String libelleActivite, Critere critere) {
		super();
		this.id = id;
		this.libelleActivite = libelleActivite;
		this.critere = critere;
	}
	
	public ActiviteRef(String libelleActivite, Critere critere) {
		super();
		this.libelleActivite = libelleActivite;
		this.critere = critere;
	}

	public ActiviteRef(String libelleActivite) {
		this.libelleActivite = libelleActivite;
	}

	public Integer getId() {
		return id;
	}

	public String getLibelleActivite() {
		return libelleActivite;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setLibelleActivite(String libelleActivite) {
		this.libelleActivite = libelleActivite;
	}

	
	
	public Critere getCritere() {
		return critere;
	}

	public void setCritere(Critere critere) {
		this.critere = critere;
	}

	@Override
	public String toString() {
		return "Activite [id=" + id + ", libelleActivite=" + libelleActivite + "]";
	}

}
