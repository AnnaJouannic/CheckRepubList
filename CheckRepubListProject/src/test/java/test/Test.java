package test;

import java.time.LocalDate;

import checkrepublist.group.model.Categorie;
import checkrepublist.group.model.Critere;
import checkrepublist.group.model.MaterielRef;
import checkrepublist.group.model.TypeClimat;
import checkrepublist.group.model.TypeDeplacement;
import checkrepublist.group.model.TypeLogement;
import checkrepublist.group.model.Utilisateur;
import checkrepublist.group.model.Voyage;
import checkrepublist.group.model.Voyageur;

public class Test {

	public static void main(String[] args) {
		
	Voyage v1 = new Voyage(LocalDate.parse("2023-09-11"), 14, "Vacances fin d'été !!", "Japon", TypeLogement.Hotel, TypeDeplacement.Avion, TypeClimat.Tempere );
	Voyage v2 = new Voyage(LocalDate.parse("2023-07-09"), 07, "Vacances d'été !!", "Espagne", TypeLogement.Van, TypeDeplacement.Van, TypeClimat.Chaud );
	Voyage v3 = new Voyage(LocalDate.parse("2023-05-23"), 10, "Vacances de printemps !!", "Italie", TypeLogement.AirBnB, TypeDeplacement.Moto, TypeClimat.Chaud );
	
	//attacher un voyageur à aux voyages 
	//Attacher les voyageurs à l'utilisateur comme pour escape game 
	
	Voyageur p1 = new Voyageur("Even","Manon",25, true, false);
	Voyageur p2 = new Voyageur("Andraos","Rawad",26, false, false);
	Voyageur p3 = new Voyageur("Portet","Anais",25, true, false);
	
	Utilisateur c1 = new Utilisateur("Even","Manon", "Manondu56", "12345", false, "manoneven@gmail.com", "0650265588");
	Utilisateur c2 = new Utilisateur("Andraos","Rawad", "Rads", "12345", true, "rawadandraos@gmail.com", "0778050623");
	
	MaterielRef m1 = new MaterielRef("Maillot de bain",Categorie.Vetement);
	//Critere cr1 = new Critere ("Maillot de bain", TypeLogement.Hotel,);
	
	MaterielRef m2 = new MaterielRef("T-shirt",Categorie.Vetement);
	
	MaterielRef m3 = new MaterielRef("Pull",Categorie.Vetement);
	
	MaterielRef m4 = new MaterielRef("Pantalon",Categorie.Vetement);
	
	MaterielRef m5 = new MaterielRef("Short",Categorie.Vetement);
	
	MaterielRef m6 = new MaterielRef("Robe",Categorie.Vetement); //trouver une solution pour avoir des vetements en fct du genre?
	
	
	}

}
