package checkrepublist.group;

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
class CheckRepublistApplicationTest {

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
		
		//Activite:
		ActiviteRef a1= new ActiviteRef("piscine");
		ActiviteRef a2= new ActiviteRef("plage");
		ActiviteRef a3= new ActiviteRef("lac");
		
		a1 = activiteRefRepo.save(a1);
		a2 = activiteRefRepo.save(a2);
		a3 = activiteRefRepo.save(a3);
		
		List<ActiviteRef> aquatique = new ArrayList();
		Collections.addAll(aquatique, a1,a2,a3);
		
	Voyage voyage1 = new Voyage(LocalDate.parse("2023-09-11"), LocalDate.parse("2023-09-25"), "Vacances fin d'été !!", "Japon", TypeLogement.Hotel, TypeDeplacement.Avion, TypeClimat.Tempere );
	voyage1.setActivite(aquatique);
	voyage1 = voyageRepo.save(voyage1);
	
	
	Voyage voyage2 = new Voyage(LocalDate.parse("2023-07-09"), LocalDate.parse("2023-07-21"), "Vacances d'été !!", "Espagne", TypeLogement.Van, TypeDeplacement.Van, TypeClimat.Chaud );
	voyage2 = voyageRepo.save(voyage2);
	
	Voyage voyage3 = new Voyage(LocalDate.parse("2023-05-23"),LocalDate.parse("2023-06-02"), "Vacances de printemps !!", "Italie", TypeLogement.AirBnB, TypeDeplacement.Moto, TypeClimat.Chaud );
	voyage3 = voyageRepo.save(voyage3);
	
	 List<Voyage> Voyage1 = new ArrayList();
     Collections.addAll(Voyage1, voyage1);
     
     List<Voyage> Voyage2 = new ArrayList();
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
	

	//Catégorie Pharmacie
	MaterielRef ph1 = new MaterielRef("Pansements",Categorie.Pharmacie);
	ph1=materielRefRepo.save(ph1);
	Critere cr2=new Critere(ph1);
	cr2=critereRepo.save(cr2);
	
	
	MaterielRef ph2 = new MaterielRef("Desinfectant",Categorie.Pharmacie);
	ph2=materielRefRepo.save(ph2);
	Critere cr3=new Critere(ph2);
	cr3=critereRepo.save(cr3);
	
	MaterielRef ph3 = new MaterielRef("Prescription médicale",Categorie.Pharmacie);
	ph3=materielRefRepo.save(ph3);
	Critere cr4=new Critere(ph3);
	cr4=critereRepo.save(cr4);
	
	MaterielRef ph4 = new MaterielRef("Compresse",Categorie.Pharmacie);
	ph4=materielRefRepo.save(ph4);
	Critere crt5=new Critere(ph4);
	crt5=critereRepo.save(crt5);
	
	MaterielRef ph5 = new MaterielRef("Anti-douleurs (Paracétamol)",Categorie.Pharmacie);
	ph3=materielRefRepo.save(ph5);
	Critere crt6=new Critere(ph5);
	crt6=critereRepo.save(crt6);
	
	MaterielRef ph6 = new MaterielRef("Biafine",Categorie.Pharmacie);
	ph6=materielRefRepo.save(ph6);
	Critere crt7=new Critere(ph6);
	crt7=critereRepo.save(crt7);
	crt7.setClimat(TypeClimat.Chaud);
	Critere crt8=new Critere(ph6);
	crt8=critereRepo.save(crt8);
	crt8.setClimat(TypeClimat.Tropical);
	Critere crt9=new Critere(ph6);
	crt9=critereRepo.save(crt9);
	crt9.setClimat(TypeClimat.Tempere);
	Critere crt10=new Critere(ph6);
	crt10=critereRepo.save(crt10);
	crt10.setClimat(TypeClimat.Desertique);
	
	
	//Catégorie Numérique
	MaterielRef n1 = new MaterielRef("Téléphone",Categorie.Numerique);
	n1=materielRefRepo.save(n1);
	Critere crit1=new Critere(n1);
	crit1=critereRepo.save(crit1);
	
	MaterielRef n2 = new MaterielRef("Tablette",Categorie.Numerique);
	n2=materielRefRepo.save(n2);
	Critere crit2=new Critere(n2);
	crit2=critereRepo.save(crit2);
	
	MaterielRef n3 = new MaterielRef("Ordinateur",Categorie.Numerique);
	n3=materielRefRepo.save(n3);
	Critere crit3=new Critere(n3);
	crit3=critereRepo.save(crit3);
	
	MaterielRef n4 = new MaterielRef("Chargeur",Categorie.Numerique);
	n4=materielRefRepo.save(n4);
	Critere crit4=new Critere(n4);
	crit4=critereRepo.save(crit4);
	
	MaterielRef n5 = new MaterielRef("Ecouteurs",Categorie.Numerique);
	n5=materielRefRepo.save(n5);
	Critere crit5=new Critere(n5);
	crit5=critereRepo.save(crit5);
	
	//Catégorie Administratif
	MaterielRef adm1 = new MaterielRef("Carte Identité/Passeport",Categorie.Administratif);
	adm1=materielRefRepo.save(adm1);
	Critere cr10=new Critere(adm1);
	cr10=critereRepo.save(cr10);
	
	MaterielRef adm2 = new MaterielRef("Permis de conduire",Categorie.Administratif);
	adm2=materielRefRepo.save(adm2);
	Critere cr11=new Critere(adm2);
	cr11=critereRepo.save(cr11);
	
	//Catégorie Animaux
	MaterielRef ani1 = new MaterielRef("Harnais",Categorie.Animaux);
	ani1=materielRefRepo.save(ani1);
	Critere cr12=new Critere(ani1);
	cr12=critereRepo.save(cr12);
	
	MaterielRef ani2 = new MaterielRef("Laisse",Categorie.Animaux);
	ani2=materielRefRepo.save(ani2);
	Critere cr13=new Critere(ani2);
	cr13=critereRepo.save(cr13);
	
	MaterielRef ani3 = new MaterielRef("Jouet",Categorie.Animaux);
	ani3=materielRefRepo.save(ani3);
	Critere cr14=new Critere(ani3);
	cr14=critereRepo.save(cr14);
	
	//Catégorie Outils
	
	MaterielRef o1 = new MaterielRef("Tente",Categorie.Outils);
	o1=materielRefRepo.save(o1);
	Critere cr15=new Critere(o1);
	cr15=critereRepo.save(cr15);
	cr15.setLogement(TypeLogement.Tente);
	cr15.setDeplacement(TypeDeplacement.Marche);
	
	MaterielRef o2 = new MaterielRef("Sac de couchage",Categorie.Outils);
	o2=materielRefRepo.save(o2);
	Critere cr16=new Critere(o2);
	cr16=critereRepo.save(cr16);
	cr16.setLogement(TypeLogement.Tente);
	cr16.setLogement(TypeLogement.Van);
	cr16.setLogement(TypeLogement.CampingCar);
	cr16.setLogement(TypeLogement.Voiture);
	
	MaterielRef o3 = new MaterielRef("Couteaux",Categorie.Outils);
	o3=materielRefRepo.save(o3);
	Critere cr17=new Critere(o3);
	cr17=critereRepo.save(cr17);
	cr17.setLogement(TypeLogement.Tente);
	cr17.setDeplacement(TypeDeplacement.Velo);
	cr17.setLogement(TypeLogement.Van);
	cr17.setLogement(TypeLogement.CampingCar);
	
	
	MaterielRef o4 = new MaterielRef("Réchaud",Categorie.Outils);
	o4=materielRefRepo.save(o4);
	Critere cr18=new Critere(o4);
	cr18=critereRepo.save(cr18);
	cr18.setLogement(TypeLogement.Tente);
	cr18.setLogement(TypeLogement.Van);
	cr18.setLogement(TypeLogement.CampingCar);
	cr18.setLogement(TypeLogement.Voiture);
	
	
	//Catégorie Toilette
	MaterielRef t1 = new MaterielRef("Brosse à dent",Categorie.Toilette);
	t1=materielRefRepo.save(t1);
	Critere cr19=new Critere(t1);
	cr19=critereRepo.save(cr19);
	
	MaterielRef t2 = new MaterielRef("Dentifrice",Categorie.Toilette);
	t2=materielRefRepo.save(t2);
	Critere cr20=new Critere(t2);
	cr20=critereRepo.save(cr20);
	
	MaterielRef t3 = new MaterielRef("Shampooing",Categorie.Toilette);
	t3=materielRefRepo.save(t3);
	Critere cr21=new Critere(t3);
	cr21=critereRepo.save(cr21);
	
	MaterielRef t4 = new MaterielRef("Gel Douche",Categorie.Toilette);
	t4=materielRefRepo.save(t4);
	Critere cr22=new Critere(t4);
	cr22=critereRepo.save(cr22);
	
	MaterielRef t5 = new MaterielRef("Crème de jour/nuit",Categorie.Toilette);
	t5=materielRefRepo.save(t5);
	Critere cr23=new Critere(t5);
	cr23=critereRepo.save(cr23);
	
	MaterielRef t6 = new MaterielRef("Bain de bouche",Categorie.Toilette);
	t6=materielRefRepo.save(t6);
	Critere cr24=new Critere(t6);
	cr24=critereRepo.save(cr24);
	
	MaterielRef t7 = new MaterielRef("Boules quiès",Categorie.Toilette);
	t7=materielRefRepo.save(t7);
	Critere cr25=new Critere(t7);
	cr25=critereRepo.save(cr25);
	
	MaterielRef t8 = new MaterielRef("Brosse à cheveux/Peigne",Categorie.Toilette);
	t8=materielRefRepo.save(t8);
	Critere cr26=new Critere(t8);
	cr26=critereRepo.save(cr26);
	
	MaterielRef t9 = new MaterielRef("Savon",Categorie.Toilette);
	t9=materielRefRepo.save(t9);
	Critere cr27=new Critere(t9);
	cr27=critereRepo.save(cr27);
	
	MaterielRef t10 = new MaterielRef("Déodorant",Categorie.Toilette);
	t10=materielRefRepo.save(t10);
	Critere cr28=new Critere(t10);
	cr28=critereRepo.save(cr28);
	
	MaterielRef t11 = new MaterielRef("Parfum",Categorie.Toilette);
	t11=materielRefRepo.save(t11);
	Critere cr29=new Critere(t11);
	cr29=critereRepo.save(cr29);
	
	MaterielRef t12 = new MaterielRef("Crème solaire",Categorie.Toilette);
	t11=materielRefRepo.save(t12);
	Critere cr30=new Critere(t12);
	cr30=critereRepo.save(cr30);
	
	
	
	
	
	
	
	
	}

}
