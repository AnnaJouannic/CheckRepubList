package test;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import checkrepublist.group.dao.IDAOActiviteRef;
import checkrepublist.group.dao.IDAOCompte;
import checkrepublist.group.dao.IDAOCritere;
import checkrepublist.group.dao.IDAOMaterielRef;
import checkrepublist.group.dao.IDAOVoyage;
import checkrepublist.group.dao.IDAOVoyageur;
import checkrepublist.group.model.Categorie;
import checkrepublist.group.model.Critere;
import checkrepublist.group.model.MaterielRef;
import checkrepublist.group.model.TypeClimat;
import checkrepublist.group.model.TypeDeplacement;
import checkrepublist.group.model.TypeLogement;
import checkrepublist.group.model.Utilisateur;
import checkrepublist.group.model.Voyage;
import checkrepublist.group.model.Voyageur;


@SpringBootTest
public class CheckRepublistApplicationTest {

	@Autowired
	private IDAOActiviteRef activiteRefRepo;
	
	@Autowired
	private IDAOCompte compteRepo;
	
	@Autowired
	private  IDAOCritere critereRepo;
	
	@Autowired
	private  IDAOMaterielRef materielRefRepo;
	
	@Autowired
	private IDAOVoyage voyageRepo;
	
	@Autowired
	private IDAOVoyageur voyageurRepo;
	
	
	
	@Test
	void contextLoads() {
		
	Voyage voyage1 = new Voyage(LocalDate.parse("2023-09-11"), 14, "Vacances fin d'été !!", "Japon", TypeLogement.Hotel, TypeDeplacement.Avion, TypeClimat.Tempere );
	voyage1 = voyageRepo.save(voyage1);
	
	Voyage voyage2 = new Voyage(LocalDate.parse("2023-07-09"), 07, "Vacances d'été !!", "Espagne", TypeLogement.Van, TypeDeplacement.Van, TypeClimat.Chaud );
	Voyage voyage3 = new Voyage(LocalDate.parse("2023-05-23"), 10, "Vacances de printemps !!", "Italie", TypeLogement.AirBnB, TypeDeplacement.Moto, TypeClimat.Chaud );
	
	//attacher un voyageur à aux voyages dans son constructeur// liste
	//Attacherl'utilisateur aux voyageurs comme pour escape game// liste
	
	Voyageur p1 = new Voyageur("Even","Manon",25, true, false);
	Voyageur p2 = new Voyageur("Andraos","Rawad",26, false, false);
	Voyageur p3 = new Voyageur("Portet","Anais",29, true, false);
	
	Utilisateur c1 = new Utilisateur("Even","Manon", "Manondu56", "12345", false, "manoneven@gmail.com", "0650265588");
	Utilisateur c2 = new Utilisateur("Andraos","Rawad", "Rads", "12345", true, "rawadandraos@gmail.com", "0778050623");
	
	
	//Catégorie Vêtement
	MaterielRef v1 = new MaterielRef("Maillot de bain",Categorie.Vetement);
	Critere cr1 = new Critere (v1);
	cr1.setClimat(TypeClimat.Chaud);
	
	//Pas sure qu'on puisse mettre l'enum en null faire des constructeurs spé pour chaque possibilité?
	
	MaterielRef v2 = new MaterielRef("T-shirt",Categorie.Vetement);
	
	MaterielRef v3 = new MaterielRef("Pull",Categorie.Vetement);
	
	MaterielRef v4 = new MaterielRef("Pantalon",Categorie.Vetement);
	
	MaterielRef v5 = new MaterielRef("Short",Categorie.Vetement);
	
	MaterielRef v6 = new MaterielRef("Robe",Categorie.Vetement); 
	
	MaterielRef v7 = new MaterielRef("Jupe",Categorie.Vetement);
	
	MaterielRef v8 = new MaterielRef("Pyjama",Categorie.Vetement);
	
	MaterielRef v9 = new MaterielRef("Sous-vêtement",Categorie.Vetement);
	
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
	
	}

}
