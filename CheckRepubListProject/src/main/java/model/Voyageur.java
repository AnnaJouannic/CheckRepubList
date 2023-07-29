package model;

public class Voyageur {
	
	private Integer id;
	private String nom;
	private String prenom;
	private Integer age;
	private boolean animal;
	private boolean accessibilite;
	
	
		public Voyageur(Integer id, String nom, String prenom, Integer age, boolean animal, boolean accessibilite) {
			this.id = id;
			this.nom = nom;
			this.prenom = prenom;
			this.age = age;
			this.animal = animal;
			this.accessibilite = accessibilite;
		}
	
	
		public Voyageur(String nom, String prenom, Integer age, boolean animal, boolean accessibilite) {
			super();
			this.nom = nom;
			this.prenom = prenom;
			this.age = age;
			this.animal = animal;
			this.accessibilite = accessibilite;
		}


		public Integer getId() {
			return id;
		}


		public String getNom() {
			return nom;
		}


		public String getPrenom() {
			return prenom;
		}


		public Integer getAge() {
			return age;
		}


		public boolean isAnimal() {
			return animal;
		}


		public boolean isAccessibilite() {
			return accessibilite;
		}


		public void setId(Integer id) {
			this.id = id;
		}


		public void setNom(String nom) {
			this.nom = nom;
		}


		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}


		public void setAge(Integer age) {
			this.age = age;
		}


		public void setAnimal(boolean animal) {
			this.animal = animal;
		}


		public void setAccessibilite(boolean accessibilite) {
			this.accessibilite = accessibilite;
		}


		@Override
		public String toString() {
			return "Voyageur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", animal=" + animal
					+ ", accessibilite=" + accessibilite + "]";
		}
		
	
	
	
}
