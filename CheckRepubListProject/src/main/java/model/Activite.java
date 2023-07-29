package model;

public class Activite {
	
	private Integer id;
	private String libelle;
	
		public Activite(Integer id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}

		public Activite(String libelle) {
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
