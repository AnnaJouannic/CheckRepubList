package test;

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
@SpringBootTest
public class CheckRepublistApplicationTest2 {

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
		MaterielRef a1 = new MaterielRef("Carte Identité/Passeport",Categorie.Administratif);
		a1=materielRefRepo.save(a1);
		Critere cr10=new Critere(a1);
		cr10=critereRepo.save(cr10);
		
		MaterielRef a2 = new MaterielRef("Permis de conduire",Categorie.Administratif);
		a2=materielRefRepo.save(a2);
		Critere cr11=new Critere(a2);
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

