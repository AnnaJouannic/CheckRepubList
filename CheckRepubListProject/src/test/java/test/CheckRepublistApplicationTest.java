package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import checkrepublist.group.dao.IDAOActiviteRef;
import checkrepublist.group.dao.IDAOCompte;
import checkrepublist.group.dao.IDAOCritere;
import checkrepublist.group.dao.IDAOMaterielRef;
import checkrepublist.group.dao.IDAOVoyage;
import checkrepublist.group.dao.IDAOVoyageur;
import checkrepublist.group.model.ActiviteRef;
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
		
	Voyage voyage1 = new Voyage(LocalDate.parse("2023-09-11"), LocalDate.parse("2023-09-25"), "Vacances fin d'été !!", "Japon", TypeLogement.Hotel, TypeDeplacement.Avion, TypeClimat.Tempere );
	voyage1 = voyageRepo.save(voyage1);
	
	Voyage voyage2 = new Voyage(LocalDate.parse("2023-07-09"), LocalDate.parse("2023-07-21"), "Vacances d'été !!", "Espagne", TypeLogement.Van, TypeDeplacement.Van, TypeClimat.Chaud );
	voyage2 = voyageRepo.save(voyage2);
	
	Voyage voyage3 = new Voyage(LocalDate.parse("2023-05-23"),LocalDate.parse("2023-06-02"), "Vacances de printemps !!", "Italie", TypeLogement.AirBnB, TypeDeplacement.Moto, TypeClimat.Chaud );
	voyage3 = voyageRepo.save(voyage3);
	
	 List<Voyage> Voyage1 = new ArrayList();
     Collections.addAll(Voyage1, voyage1);
     
     List<Voyage> Voyage2 = new ArrayList();
     Voyage2.add(voyage2);
     Voyage2.add(voyage3);
     Collections.addAll(Voyage2, voyage2,voyage3);
     
	Voyageur p1 = new Voyageur("Even","Manon",LocalDate.parse("1998-05-23"), true, false);
	p1.setVoyages(Voyage1);
	p1 = voyageurRepo.save(p1);
	
	Voyageur p2 = new Voyageur("Andraos","Rawad",LocalDate.parse("1997-03-09"), false, false);
	p2.setVoyages(Voyage1);
	p2 = voyageurRepo.save(p2);
	
	Voyageur p3 = new Voyageur("Portet","Anais",LocalDate.parse("1994-11-13"), true, false);
	p3.setVoyages(Voyage2);
	p3 = voyageurRepo.save(p3);
	
	List<Voyageur> utilisateur1 = new ArrayList();
	Collections.addAll(utilisateur1, p1);
	
	List<Voyageur> utilisateur2 = new ArrayList();
	Collections.addAll(utilisateur2, p2,p3);
	
	Utilisateur c1 = new Utilisateur("Even","Manon", "Manondu56", "12345", false, "manoneven@gmail.com", "0650265588");
	c1.setVoyageurs(utilisateur1);
	c1.setVoyages(Voyage1);
	c1 = compteRepo.save(c1);
	
	Utilisateur c2 = new Utilisateur("Andraos","Rawad", "Rads", "12345", true, "rawadandraos@gmail.com", "0778050623");
	c2.setVoyageurs(utilisateur2);
	c2.setVoyages(Voyage1);
	c2.setVoyages(Voyage2);
	c2 = compteRepo.save(c2);
	
	//Activite:
	ActiviteRef a1= new ActiviteRef("piscine");
	ActiviteRef a2= new ActiviteRef("plage");
	ActiviteRef a3= new ActiviteRef("lac");
	
	a1 = activiteRefRepo.save(a1);
	a2 = activiteRefRepo.save(a2);
	a3 = activiteRefRepo.save(a3);
	
	List<ActiviteRef> aquatique = new ArrayList();
	Collections.addAll(aquatique, a1,a2,a3);
	
	//Catégorie Vêtement
	MaterielRef v1 = new MaterielRef("Maillot de bain", Categorie.Vetement);
	v1 = materielRefRepo.save(v1);
	Critere cri1 = new Critere (v1);
	Critere cri2 = new Critere (v1);
	Critere cri3 = new Critere (v1);
	
	cri1.setClimat(TypeClimat.Chaud);
	cri2.setClimat(TypeClimat.Tropical);
	cri3.setActivites(aquatique);
	
	cri1 = critereRepo.save(cri1);
	cri2 = critereRepo.save(cri2);
	cri3 = critereRepo.save(cri3);

	
	MaterielRef v2 = new MaterielRef("T-shirt",Categorie.Vetement);
	v2 = materielRefRepo.save(v2);
	Critere cri4 = new Critere (v2);
	cri4 = critereRepo.save(cri4);
	
	
	MaterielRef v3 = new MaterielRef("Pull",Categorie.Vetement);
	v3 = materielRefRepo.save(v3);
	
	Critere cri5 = new Critere (v3);
	Critere cri6= new Critere (v3);
	
	cri5.setClimat(TypeClimat.Froid);
	cri6.setClimat(TypeClimat.Tempere);
	
	cri5 = critereRepo.save(cri5);
	cri6 = critereRepo.save(cri6);
	
	MaterielRef v4 = new MaterielRef("Pantalon",Categorie.Vetement);
	v4 = materielRefRepo.save(v4);
	Critere cri7 = new Critere (v4);
	cri7 = critereRepo.save(cri7);

	
	MaterielRef v5 = new MaterielRef("Short",Categorie.Vetement);
	v5 = materielRefRepo.save(v5);
	Critere cri8 = new Critere (v5);
	Critere cri9 = new Critere (v5);
	
	cri8.setClimat(TypeClimat.Chaud);
	cri9.setClimat(TypeClimat.Tropical);

	cri8 = critereRepo.save(cri8);
	cri9 = critereRepo.save(cri9);
	
	MaterielRef v6 = new MaterielRef("Robe",Categorie.Vetement); 
	v6 = materielRefRepo.save(v6);
	Critere cri10 = new Critere (v6);
	cri10 = critereRepo.save(cri10);
	
	MaterielRef v7 = new MaterielRef("Jupe",Categorie.Vetement);
	v7 = materielRefRepo.save(v7);
	Critere cri11 = new Critere (v7);
	Critere cri12 = new Critere (v7);
	
	cri11.setClimat(TypeClimat.Chaud);
	cri12.setClimat(TypeClimat.Tropical);

	cri11 = critereRepo.save(cri11);
	cri12 = critereRepo.save(cri12);
	
	MaterielRef v8 = new MaterielRef("Pyjama",Categorie.Vetement);
	v8 = materielRefRepo.save(v8);
	
	Critere cri13 = new Critere (v8);
	cri13 = critereRepo.save(cri13);
	
	MaterielRef v9 = new MaterielRef("Sous-vêtement",Categorie.Vetement);
	v9 = materielRefRepo.save(v9);
	
	Critere cri14 = new Critere (v9);
	cri14 = critereRepo.save(cri14);
	
	MaterielRef v10 = new MaterielRef("Basket",Categorie.Vetement);
	v10 = materielRefRepo.save(v10);
	
	Critere cri15 = new Critere (v10);
	cri15 = critereRepo.save(cri15);
	
	MaterielRef v11 = new MaterielRef("Sandales",Categorie.Vetement);
	v11 = materielRefRepo.save(v11);
	Critere cri16 = new Critere (v11);
	Critere cri17 = new Critere (v11);
	Critere cri18 = new Critere (v11);
	
	cri16.setClimat(TypeClimat.Chaud);
	cri17.setClimat(TypeClimat.Tropical);
	cri18.setClimat(TypeClimat.Desertique);
	
	cri16 = critereRepo.save(cri16);
	cri17 = critereRepo.save(cri17);
	cri18 = critereRepo.save(cri18);
	
	MaterielRef v12 = new MaterielRef("Chaussure de rando",Categorie.Vetement);
	v12 = materielRefRepo.save(v12);
	Critere cri19 = new Critere (v12);
	
	cri19.setDeplacement(TypeDeplacement.Marche);
	
	cri19 = critereRepo.save(cri19);
	
	MaterielRef v13 = new MaterielRef("Bottes",Categorie.Vetement);
	v13 = materielRefRepo.save(v13);
	Critere cri20 = new Critere (v13);
	
	cri20.setClimat(TypeClimat.Froid);
	
	cri20 = critereRepo.save(cri20);
	
	
	}

}
