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
import checkrepublist.group.model.MaterielRef;
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

