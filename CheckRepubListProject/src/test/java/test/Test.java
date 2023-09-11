package test;

import java.time.LocalDate;
import org.springframework.boot.test.context.SpringBootTest;
import checkrepublist.group.model.Categorie;
import checkrepublist.group.model.MaterielRef;
import checkrepublist.group.model.TypeClimat;
import checkrepublist.group.model.TypeDeplacement;
import checkrepublist.group.model.TypeLogement;
import checkrepublist.group.model.Utilisateur;
import checkrepublist.group.model.Voyage;
import checkrepublist.group.model.Voyageur;



public class Test {

	public static void main(String[] args) {
		
	Voyage voyage1 = new Voyage(LocalDate.parse("2023-09-11"), 14, "Vacances fin d'été !!", "Japon", TypeLogement.Hotel, TypeDeplacement.Avion, TypeClimat.Tempere );
	Voyage voyage2 = new Voyage(LocalDate.parse("2023-07-09"), 07, "Vacances d'été !!", "Espagne", TypeLogement.Van, TypeDeplacement.Van, TypeClimat.Chaud );
	Voyage voyage3 = new Voyage(LocalDate.parse("2023-05-23"), 10, "Vacances de printemps !!", "Italie", TypeLogement.AirBnB, TypeDeplacement.Moto, TypeClimat.Chaud );
	
	//attacher un voyageur à aux voyages dans son constructeur
	//Attacherl'utilisateur aux voyageurs comme pour escape game 
	
	Voyageur p1 = new Voyageur("Even","Manon",25, true, false);
	Voyageur p2 = new Voyageur("Andraos","Rawad",26, false, false);
	Voyageur p3 = new Voyageur("Portet","Anais",25, true, false);
	
	Utilisateur c1 = new Utilisateur("Even","Manon", "Manondu56", "12345", false, "manoneven@gmail.com", "0650265588");
	Utilisateur c2 = new Utilisateur("Andraos","Rawad", "Rads", "12345", true, "rawadandraos@gmail.com", "0778050623");
	
	
	//Catégorie Vêtement
	MaterielRef v1 = new MaterielRef("Maillot de bain",Categorie.Vetement);
	//Critere cr1 = new Critere ("Maillot de bain",TypeLogement.Hotel);
	//Pas sure qu'on puisse mettre l'enum en null faire des constructeurs spé pour chaque possibilité? Ajouter activité dans le constructeur
	
	MaterielRef v2 = new MaterielRef("T-shirt",Categorie.Vetement);
	
	MaterielRef v3 = new MaterielRef("Pull",Categorie.Vetement);
	
	MaterielRef v4 = new MaterielRef("Pantalon",Categorie.Vetement);
	
	MaterielRef v5 = new MaterielRef("Short",Categorie.Vetement);
	
	MaterielRef v6 = new MaterielRef("Robe",Categorie.Vetement); //trouver une solution pour avoir des vetements en fct du genre?
	
	MaterielRef v7 = new MaterielRef("Jupe",Categorie.Vetement);
	
	MaterielRef v8 = new MaterielRef("Pyjama",Categorie.Vetement);
	
	MaterielRef v9 = new MaterielRef("Sous-vêtement",Categorie.Vetement);//peut être trop general (détailler?)
	
	MaterielRef v10 = new MaterielRef("Basket",Categorie.Vetement);
	
	MaterielRef v11 = new MaterielRef("Sandales",Categorie.Vetement);
	
	MaterielRef v12 = new MaterielRef("Chaussure de rando",Categorie.Vetement);
	
	MaterielRef v13 = new MaterielRef("Bottes",Categorie.Vetement);
	
	//Catégorie Toilette
	MaterielRef t1 = new MaterielRef("Brosse à dent",Categorie.Toilette);
	
	MaterielRef t2 = new MaterielRef("Dentifrice",Categorie.Toilette);
	
	MaterielRef t3 = new MaterielRef("Shampooing",Categorie.Toilette);
	
	MaterielRef t4 = new MaterielRef("Gel Douche",Categorie.Toilette);
	
	MaterielRef t5 = new MaterielRef("Crème de jour/nuit",Categorie.Toilette);
	
	//Catégorie Pharmacie
	MaterielRef ph1 = new MaterielRef("Pansements",Categorie.Pharmacie);
	
	MaterielRef ph2 = new MaterielRef("Desinfectant",Categorie.Pharmacie);
	
	MaterielRef ph3 = new MaterielRef("Prescription médicale",Categorie.Pharmacie);
	
	//Catégorie Numérique
	MaterielRef n1 = new MaterielRef("Téléphone",Categorie.Numerique);
	
	MaterielRef n2 = new MaterielRef("Tablette",Categorie.Numerique);
	
	MaterielRef n3 = new MaterielRef("Ordinateur",Categorie.Numerique);
	
	MaterielRef n4 = new MaterielRef("Chargeur",Categorie.Numerique);
	
	MaterielRef n5 = new MaterielRef("Ecouteurs",Categorie.Numerique);
	
	//Catégorie Administratif
	MaterielRef a1 = new MaterielRef("Carte Identité/Passeport",Categorie.Administratif);
	
	MaterielRef a2 = new MaterielRef("Permis de conduire",Categorie.Administratif);
	
	//Catégorie Animaux
	MaterielRef ani1 = new MaterielRef("Harnais",Categorie.Animaux);
	
	MaterielRef ani2 = new MaterielRef("Laisse",Categorie.Animaux);
	
	MaterielRef ani3 = new MaterielRef("Jouet",Categorie.Animaux);
	
	//Catégorie Outils
	
	MaterielRef o1 = new MaterielRef("Tente",Categorie.Outils);

	MaterielRef o2 = new MaterielRef("Sac de couchage",Categorie.Outils);
	
	MaterielRef o3 = new MaterielRef("Couteaux",Categorie.Outils);
	
	MaterielRef o4 = new MaterielRef("Réchaud",Categorie.Outils);
	}

	

}
