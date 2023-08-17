package model;

public class Logement {

	private Integer id;
	private String libelle;
	
		public Logement(Integer id, String libelle) {
			this.id = id;
			this.libelle = libelle;
		}

		public Logement(String libelle) {
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
		return "Logement [id=" + id + ", libelle=" + libelle + "]";
	}
	
	
}