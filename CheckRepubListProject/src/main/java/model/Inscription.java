package model;

public class Inscription {
	
	private Integer id;
	private Voyageur voyageur;

		public Inscription(Integer id, Voyageur voyageur) {
		this.id = id;
		this.voyageur=voyageur;
	}

	public Integer getId() {
		return id;
	}

	public Voyageur getVoyageur() {
		return voyageur;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setVoyageur(Voyageur voyageur) {
		this.voyageur = voyageur;
	}

		@Override
	public String toString() {
		return "Inscription [id=" + id + ", voyageur=" + voyageur + "]";
	}

	
	
	
}
