package checkrepublist.group;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import checkrepublist.group.dao.IDAOCritere;
import checkrepublist.group.dao.IDAOMaterielRef;
import checkrepublist.group.dao.IDAOUtilisateur;
import checkrepublist.group.dao.IDAOVoyage;
import checkrepublist.group.dao.IDAOVoyageur;
import checkrepublist.group.model.Categorie;
import checkrepublist.group.model.Critere;
import checkrepublist.group.model.MaterielRef;
import checkrepublist.group.model.Roles;
import checkrepublist.group.model.TypeClimat;
import checkrepublist.group.model.TypeDeplacement;
import checkrepublist.group.model.TypeLogement;
import checkrepublist.group.model.Utilisateur;
import checkrepublist.group.model.Voyage;
import checkrepublist.group.model.Voyageur;



@SpringBootTest
class CheckRepublistApplicationTest {

	/*@Autowired
	private IDAOActiviteRef activiteRefRepo;*/
	
	@Autowired
	private IDAOUtilisateur utilisateurRepo;
	
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
		/*ActiviteRef a1= new ActiviteRef("piscine");
		ActiviteRef a2= new ActiviteRef("plage");
		ActiviteRef a3= new ActiviteRef("lac");
		
		a1 = activiteRefRepo.save(a1);
		a2 = activiteRefRepo.save(a2);
		a3 = activiteRefRepo.save(a3);
		
		List<ActiviteRef> aquatique = new ArrayList();
		Collections.addAll(aquatique, a1,a2,a3);*/
		

	

		//Catégorie Vêtement
		MaterielRef v1 = new MaterielRef("Maillot de bain", Categorie.Vetement);
		v1 = materielRefRepo.save(v1);
		Critere crchaud1 = new Critere ();
		crchaud1.setClimat(TypeClimat.Chaud);
		crchaud1.setMaterielref(v1);
		crchaud1 = critereRepo.save(crchaud1);
		Critere crtropical1 = new Critere ();
		crtropical1.setClimat(TypeClimat.Tropical);
		crtropical1.setMaterielref(v1);
		crtropical1 = critereRepo.save(crtropical1);

		
		MaterielRef v2 = new MaterielRef("T-shirt",Categorie.Vetement);
		v2 = materielRefRepo.save(v2);
		Critere crtous1 = new Critere (TypeLogement.Tous, TypeDeplacement.Tous, TypeClimat.Tous);
		crtous1.setMaterielref(v2);
		crtous1 = critereRepo.save(crtous1);
		
		
		MaterielRef v3 = new MaterielRef("Pull",Categorie.Vetement);
		v3 = materielRefRepo.save(v3);
		Critere crfroid1 = new Critere ();
		crfroid1.setClimat(TypeClimat.Froid);
		crfroid1.setMaterielref(v3);
		crfroid1 = critereRepo.save(crfroid1);
		Critere crtempere1 = new Critere ();
		crtempere1.setClimat(TypeClimat.Tempere);
		crtempere1.setMaterielref(v3);
		crtempere1 = critereRepo.save(crtempere1);
		
		
		MaterielRef v4 = new MaterielRef("Pantalon",Categorie.Vetement);
		v4 = materielRefRepo.save(v4);
		Critere crtous2 = new Critere (TypeLogement.Tous, TypeDeplacement.Tous, TypeClimat.Tous);
		crtous2.setMaterielref(v4);
		crtous2 = critereRepo.save(crtous2);
		
		MaterielRef v5 = new MaterielRef("Short",Categorie.Vetement);
		v5 = materielRefRepo.save(v5);
		Critere crchaud2 = new Critere ();
		crchaud2.setClimat(TypeClimat.Chaud);
		crchaud2.setMaterielref(v5);
		crchaud2 = critereRepo.save(crchaud2);
		Critere crtropical2 = new Critere ();
		crtropical2.setClimat(TypeClimat.Tropical);
		crtropical2.setMaterielref(v5);
		crtropical2 = critereRepo.save(crtropical2);

		MaterielRef v6 = new MaterielRef("Robe",Categorie.Vetement); 
		v6 = materielRefRepo.save(v6);
		Critere crtous34 = new Critere (TypeLogement.Tous, TypeDeplacement.Tous, TypeClimat.Tous);
		crtous34.setMaterielref(v6);
		crtous34 = critereRepo.save(crtous34);
		
		
		MaterielRef v7 = new MaterielRef("Jupe",Categorie.Vetement);
		v7 = materielRefRepo.save(v7);
		Critere crchaud3 = new Critere ();
		crchaud3.setClimat(TypeClimat.Chaud);
		crchaud3.setMaterielref(v1);
		crchaud3 = critereRepo.save(crchaud3);
		Critere crtropical3 = new Critere ();
		crtropical3.setClimat(TypeClimat.Tropical);
		crtropical3.setMaterielref(v7);
		crtropical3 = critereRepo.save(crtropical3);
		
		
		MaterielRef v8 = new MaterielRef("Pyjama",Categorie.Vetement);
		v8 = materielRefRepo.save(v8);
		Critere crtous3 = new Critere (TypeLogement.Tous, TypeDeplacement.Tous, TypeClimat.Tous);
		crtous3.setMaterielref(v8);
		crtous3 = critereRepo.save(crtous3);
		
		
		MaterielRef v9 = new MaterielRef("Sous-vêtement",Categorie.Vetement);
		v9 = materielRefRepo.save(v9);
		Critere crtous4 = new Critere (TypeLogement.Tous, TypeDeplacement.Tous, TypeClimat.Tous);
		crtous4.setMaterielref(v9);
		crtous4 = critereRepo.save(crtous4);
		
		MaterielRef v10 = new MaterielRef("Basket",Categorie.Vetement);
		v10 = materielRefRepo.save(v10);
		Critere crtous5 = new Critere (TypeLogement.Tous, TypeDeplacement.Tous, TypeClimat.Tous);
		crtous5.setMaterielref(v10);
		crtous5 = critereRepo.save(crtous5);

		
		MaterielRef v11 = new MaterielRef("Sandales",Categorie.Vetement);
		v11 = materielRefRepo.save(v11);
		Critere crchaud4 = new Critere ();
		crchaud4.setClimat(TypeClimat.Chaud);
		crchaud4.setMaterielref(v11);
		crchaud4 = critereRepo.save(crchaud4);
		Critere crtropical4 = new Critere ();
		crtropical4.setClimat(TypeClimat.Tropical);
		crtropical4.setMaterielref(v11);
		crtropical4 = critereRepo.save(crtropical4);
		Critere crdesertique1 = new Critere ();
		crdesertique1.setClimat(TypeClimat.Desertique);
		crdesertique1.setMaterielref(v11);
		crdesertique1 = critereRepo.save(crdesertique1);
		
		
		MaterielRef v12 = new MaterielRef("Chaussure de rando",Categorie.Vetement);
		v12 = materielRefRepo.save(v12);
		Critere crmarche1 = new Critere ();
		crmarche1.setDeplacement(TypeDeplacement.Marche);
		crmarche1.setMaterielref(v12);
		crmarche1 = critereRepo.save(crmarche1);
		
		
		MaterielRef v13 = new MaterielRef("Bottes",Categorie.Vetement);
		v13 = materielRefRepo.save(v13);
		Critere crfroid2 = new Critere ();
		crfroid2.setClimat(TypeClimat.Froid);
		crfroid2.setMaterielref(v13);
		crfroid2 = critereRepo.save(crfroid2);


		//Catégorie Pharmacie
		MaterielRef ph1 = new MaterielRef("Pansements",Categorie.Pharmacie);
		ph1=materielRefRepo.save(ph1);
		Critere crtous6 = new Critere (TypeLogement.Tous, TypeDeplacement.Tous, TypeClimat.Tous);
		crtous6.setMaterielref(ph1);
		crtous6 = critereRepo.save(crtous6);
		
		MaterielRef ph2 = new MaterielRef("Desinfectant",Categorie.Pharmacie);
		ph2=materielRefRepo.save(ph2);
		Critere crtous7 = new Critere (TypeLogement.Tous, TypeDeplacement.Tous, TypeClimat.Tous);
		crtous7.setMaterielref(ph2);
		crtous7 = critereRepo.save(crtous7);
		
		MaterielRef ph3 = new MaterielRef("Prescription médicale",Categorie.Pharmacie);
		ph3=materielRefRepo.save(ph3);
		Critere crtous8 = new Critere (TypeLogement.Tous, TypeDeplacement.Tous, TypeClimat.Tous);
		crtous8.setMaterielref(ph3);
		crtous8 = critereRepo.save(crtous8);
		
		MaterielRef ph4 = new MaterielRef("Compresse",Categorie.Pharmacie);
		ph4=materielRefRepo.save(ph4);
		Critere crtous9 = new Critere (TypeLogement.Tous, TypeDeplacement.Tous, TypeClimat.Tous);
		crtous9.setMaterielref(ph4);
		crtous9 = critereRepo.save(crtous9);
		
		MaterielRef ph5 = new MaterielRef("Anti-douleurs (Paracétamol)",Categorie.Pharmacie);
		ph3=materielRefRepo.save(ph5);
		Critere crtous10 = new Critere (TypeLogement.Tous, TypeDeplacement.Tous, TypeClimat.Tous);
		crtous10.setMaterielref(ph5);
		crtous10 = critereRepo.save(crtous10);
		
		MaterielRef ph6 = new MaterielRef("Biafine",Categorie.Pharmacie);
		ph6=materielRefRepo.save(ph6);
		Critere crchaud5 = new Critere ();
		crchaud5.setClimat(TypeClimat.Chaud);
		crchaud5.setMaterielref(ph6);
		crchaud5 = critereRepo.save(crchaud5);
		Critere crtropical5 = new Critere ();
		crtropical5.setClimat(TypeClimat.Tropical);
		crtropical5.setMaterielref(ph6);
		crtropical5 = critereRepo.save(crtropical5);
		Critere crtempere2 = new Critere ();
		crtempere2.setClimat(TypeClimat.Tempere);
		crtempere2.setMaterielref(ph6);
		crtempere2 = critereRepo.save(crtempere2);
		Critere crdesertique2 = new Critere ();
		crdesertique2.setClimat(TypeClimat.Desertique);
		crdesertique2.setMaterielref(ph6);
		crdesertique2 = critereRepo.save(crdesertique2);
		
		
		
		//Catégorie Numérique
		MaterielRef n1 = new MaterielRef("Téléphone",Categorie.Numerique);
		n1=materielRefRepo.save(n1);
		Critere crtous11 = new Critere (TypeLogement.Tous, TypeDeplacement.Tous, TypeClimat.Tous);
		crtous11.setMaterielref(n1);
		crtous11 = critereRepo.save(crtous11);
		
		MaterielRef n2 = new MaterielRef("Tablette",Categorie.Numerique);
		n2=materielRefRepo.save(n2);
		Critere crtous12 = new Critere (TypeLogement.Tous, TypeDeplacement.Tous, TypeClimat.Tous);
		crtous12.setMaterielref(n2);
		crtous12 = critereRepo.save(crtous12);
		
		MaterielRef n3 = new MaterielRef("Ordinateur",Categorie.Numerique);
		n3=materielRefRepo.save(n3);
		Critere crtous13 = new Critere (TypeLogement.Tous, TypeDeplacement.Tous, TypeClimat.Tous);
		crtous13.setMaterielref(n3);
		crtous13 = critereRepo.save(crtous13);
		
		MaterielRef n4 = new MaterielRef("Chargeur",Categorie.Numerique);
		n4=materielRefRepo.save(n4);
		Critere crtous14 = new Critere (TypeLogement.Tous, TypeDeplacement.Tous, TypeClimat.Tous);
		crtous14.setMaterielref(n4);
		crtous14 = critereRepo.save(crtous14);
		
		MaterielRef n5 = new MaterielRef("Ecouteurs",Categorie.Numerique);
		n5=materielRefRepo.save(n5);
		Critere crtous15 = new Critere (TypeLogement.Tous, TypeDeplacement.Tous, TypeClimat.Tous);
		crtous15.setMaterielref(n5);
		crtous15 = critereRepo.save(crtous15);
		
		//Catégorie Administratif
		MaterielRef adm1 = new MaterielRef("Carte Identité/Passeport",Categorie.Administratif);
		adm1=materielRefRepo.save(adm1);
		Critere crtous16 = new Critere (TypeLogement.Tous, TypeDeplacement.Tous, TypeClimat.Tous);
		crtous16.setMaterielref(adm1);
		crtous16 = critereRepo.save(crtous16);
		
		MaterielRef adm2 = new MaterielRef("Permis de conduire",Categorie.Administratif);
		adm2=materielRefRepo.save(adm2);
		Critere crtous17 = new Critere (TypeLogement.Tous, TypeDeplacement.Tous, TypeClimat.Tous);
		crtous17.setMaterielref(adm2);
		crtous17 = critereRepo.save(crtous17);
		
		//Catégorie Animaux
		MaterielRef ani1 = new MaterielRef("Harnais",Categorie.Animaux);
		ani1=materielRefRepo.save(ani1);
		Critere crtous19 = new Critere (TypeLogement.Tous, TypeDeplacement.Tous, TypeClimat.Tous);
		crtous19.setMaterielref(ani1);
		crtous19 = critereRepo.save(crtous19);
		
		MaterielRef ani2 = new MaterielRef("Laisse",Categorie.Animaux);
		ani2=materielRefRepo.save(ani2);
		Critere crtous20 = new Critere (TypeLogement.Tous, TypeDeplacement.Tous, TypeClimat.Tous);
		crtous20.setMaterielref(ani2);
		crtous20 = critereRepo.save(crtous20);
		
		MaterielRef ani3 = new MaterielRef("Jouet",Categorie.Animaux);
		ani3=materielRefRepo.save(ani3);
		Critere crtous21 = new Critere (TypeLogement.Tous, TypeDeplacement.Tous, TypeClimat.Tous);
		crtous21.setMaterielref(ani3);
		crtous21 = critereRepo.save(crtous21);
		
		//Catégorie Outils
		
		 MaterielRef o1 = new MaterielRef("Tente",Categorie.Outils);
		    o1=materielRefRepo.save(o1);
		    Critere crtente1 = new Critere ();
			crtente1.setLogement(TypeLogement.Tente);
			crtente1.setMaterielref(o1);
			crtente1= critereRepo.save(crtente1);
		   
		 
		    
		    MaterielRef o2 = new MaterielRef("Sac de couchage",Categorie.Outils);
		    o2=materielRefRepo.save(o2);
		    Critere crtente2 = new Critere ();
				crtente2.setLogement(TypeLogement.Tente);
				crtente2.setMaterielref(o2);
				crtente2= critereRepo.save(crtente2);
		    Critere crvanl1 = new Critere ();
				crvanl1.setLogement(TypeLogement.Van);
				crvanl1.setMaterielref(o2);
				crvanl1= critereRepo.save(crvanl1);
			Critere crccl1 = new Critere ();
				crccl1.setLogement(TypeLogement.CampingCar);
				crccl1.setMaterielref(o2);
				crccl1= critereRepo.save(crccl1);
			Critere crvoiturel1 = new Critere ();
				crvoiturel1.setLogement(TypeLogement.Voiture);
				crvoiturel1.setMaterielref(o2);
				crvoiturel1= critereRepo.save(crvoiturel1);
				
		    
		    
		    MaterielRef o3 = new MaterielRef("Couteaux",Categorie.Outils);
		    o3=materielRefRepo.save(o3);
		    Critere crvanl2 = new Critere ();
				crvanl2.setLogement(TypeLogement.Van);
				crvanl2.setMaterielref(o3);
				crvanl2= critereRepo.save(crvanl2);
			Critere crtente3 = new Critere ();
				crtente3.setLogement(TypeLogement.Tente);
				crtente3.setMaterielref(o3);
				crtente3= critereRepo.save(crtente3);
			Critere crvelo1 = new Critere ();
				crvelo1.setDeplacement(TypeDeplacement.Velo);
			    crvelo1.setMaterielref(o3);
			    crvelo1 = critereRepo.save(crvelo1);
			Critere crccl2 = new Critere ();
				crccl2.setLogement(TypeLogement.CampingCar);
				crccl2.setMaterielref(o3);
				crccl2= critereRepo.save(crccl2);

		    
		    
		    MaterielRef o4 = new MaterielRef("Réchaud",Categorie.Outils);
		    o4=materielRefRepo.save(o4);
		    Critere crtente4 = new Critere ();
				crtente4.setLogement(TypeLogement.Tente);
				crtente4.setMaterielref(o2);
				crtente4= critereRepo.save(crtente4);
		    Critere crvanl3 = new Critere ();
				crvanl3.setLogement(TypeLogement.Van);
				crvanl3.setMaterielref(o4);
				crvanl3= critereRepo.save(crvanl3);
			Critere crccl3 = new Critere ();
				crccl3.setLogement(TypeLogement.CampingCar);
				crccl3.setMaterielref(o4);
				crccl3= critereRepo.save(crccl3);
			Critere crvoiturel2 = new Critere ();
				crvoiturel2.setLogement(TypeLogement.Voiture);
				crvoiturel2.setMaterielref(o4);
				crvoiturel2= critereRepo.save(crvoiturel2);
		
		//Catégorie Toilette
		MaterielRef t1 = new MaterielRef("Brosse à dent",Categorie.Toilette);
		t1=materielRefRepo.save(t1);
		Critere crtous22 = new Critere (TypeLogement.Tous, TypeDeplacement.Tous, TypeClimat.Tous);
		crtous22.setMaterielref(t1);
		crtous22 = critereRepo.save(crtous22);
		
		MaterielRef t2 = new MaterielRef("Dentifrice",Categorie.Toilette);
		t2=materielRefRepo.save(t2);
		Critere crtous23 = new Critere (TypeLogement.Tous, TypeDeplacement.Tous, TypeClimat.Tous);
		crtous23.setMaterielref(t2);
		crtous23 = critereRepo.save(crtous23);
		
		MaterielRef t3 = new MaterielRef("Shampooing",Categorie.Toilette);
		t3=materielRefRepo.save(t3);
		Critere crtous24 = new Critere (TypeLogement.Tous, TypeDeplacement.Tous, TypeClimat.Tous);
		crtous24.setMaterielref(t3);
		crtous24 = critereRepo.save(crtous24);
		
		MaterielRef t4 = new MaterielRef("Gel Douche",Categorie.Toilette);
		t4=materielRefRepo.save(t4);
		Critere crtous25 = new Critere (TypeLogement.Tous, TypeDeplacement.Tous, TypeClimat.Tous);
		crtous25.setMaterielref(t4);
		crtous25 = critereRepo.save(crtous25);
		
		MaterielRef t5 = new MaterielRef("Crème de jour/nuit",Categorie.Toilette);
		t5=materielRefRepo.save(t5);
		Critere crtous26 = new Critere (TypeLogement.Tous, TypeDeplacement.Tous, TypeClimat.Tous);
		crtous26.setMaterielref(t5);
		crtous26 = critereRepo.save(crtous26);
		
		MaterielRef t6 = new MaterielRef("Bain de bouche",Categorie.Toilette);
		t6=materielRefRepo.save(t6);
		Critere crtous27 = new Critere (TypeLogement.Tous, TypeDeplacement.Tous, TypeClimat.Tous);
		crtous27.setMaterielref(t6);
		crtous27 = critereRepo.save(crtous27);
		
		MaterielRef t7 = new MaterielRef("Boules quiès",Categorie.Toilette);
		t7=materielRefRepo.save(t7);
		Critere crtous28 = new Critere (TypeLogement.Tous, TypeDeplacement.Tous, TypeClimat.Tous);
		crtous28.setMaterielref(t7);
		crtous28 = critereRepo.save(crtous28);
		
		MaterielRef t8 = new MaterielRef("Brosse à cheveux/Peigne",Categorie.Toilette);
		t8=materielRefRepo.save(t8);
		Critere crtous29 = new Critere (TypeLogement.Tous, TypeDeplacement.Tous, TypeClimat.Tous);
		crtous29.setMaterielref(t8);
		crtous29 = critereRepo.save(crtous29);
		
		MaterielRef t9 = new MaterielRef("Savon",Categorie.Toilette);
		t9=materielRefRepo.save(t9);
		Critere crtous30 = new Critere (TypeLogement.Tous, TypeDeplacement.Tous, TypeClimat.Tous);
		crtous30.setMaterielref(t9);
		crtous30 = critereRepo.save(crtous30);
		
		MaterielRef t10 = new MaterielRef("Déodorant",Categorie.Toilette);
		t10=materielRefRepo.save(t10);
		Critere crtous31 = new Critere (TypeLogement.Tous, TypeDeplacement.Tous, TypeClimat.Tous);
		crtous31.setMaterielref(t10);
		crtous31 = critereRepo.save(crtous31);
		
		MaterielRef t11 = new MaterielRef("Parfum",Categorie.Toilette);
		t11=materielRefRepo.save(t11);
		Critere crtous32 = new Critere (TypeLogement.Tous, TypeDeplacement.Tous, TypeClimat.Tous);
		crtous32.setMaterielref(t11);
		crtous32 = critereRepo.save(crtous32);
		
		MaterielRef t12 = new MaterielRef("Crème solaire",Categorie.Toilette);
		t11=materielRefRepo.save(t12);
		Critere crtous33 = new Critere (TypeLogement.Tous, TypeDeplacement.Tous, TypeClimat.Tous);
		crtous33.setMaterielref(t12);
		crtous33 = critereRepo.save(crtous33);
		
		
	    MaterielRef v14 = new MaterielRef ("Lunette de Soleil", Categorie.Vetement);
	    v14=materielRefRepo.save(v14);
	    Critere crchaud6 = new Critere ();
	    crchaud6.setMaterielref(v14);
	    crchaud6 = critereRepo.save(crchaud6);
	   
	    	
		List<MaterielRef> listevoyage = new ArrayList <>();
		  Collections.addAll(listevoyage, v2, v6, v8);
		  
		  
		  Voyageur p1 = new Voyageur("Even","Manon",LocalDate.parse("1998-05-23"), true, false);
		  p1 = voyageurRepo.save(p1);

		  Voyageur p2 = new Voyageur("Andraos","Rawad",LocalDate.parse("1997-03-09"), false, false);
		  p2 = voyageurRepo.save(p2);

		  Voyageur p3 = new Voyageur("Portet","Anais",LocalDate.parse("1994-11-13"), true, false);
		  p3 = voyageurRepo.save(p3);
			
			List<Voyageur> utilisateur1 = new ArrayList<>();
			Collections.addAll(utilisateur1, p1);
			
			List<Voyageur> utilisateur2 = new ArrayList<>();
			Collections.addAll(utilisateur2, p2,p3);
	
	Voyage voyage1 = new Voyage(LocalDate.parse("2023-09-11"), LocalDate.parse("2023-09-25"), "Vacances fin d'été !!", "Japon", TypeLogement.Hotel, TypeDeplacement.Avion, TypeClimat.Tempere );
	//voyage1.setActivite(aquatique);
	voyage1.setMateriels(listevoyage);
	voyage1.setVoyageurs(utilisateur1);
	voyage1 = voyageRepo.save(voyage1);
	
	Voyage voyage2 = new Voyage(LocalDate.parse("2023-07-09"), LocalDate.parse("2023-07-21"), "Vacances d'été !!", "Espagne", TypeLogement.Van, TypeDeplacement.Van, TypeClimat.Chaud );
	voyage2.setVoyageurs(utilisateur2);
	voyage2.setVoyageurs(utilisateur2);
	voyage2 = voyageRepo.save(voyage2);
	
	
	Voyage voyage3 = new Voyage(LocalDate.parse("2023-05-23"),LocalDate.parse("2023-06-02"), "Vacances de printemps !!", "Italie", TypeLogement.AirBnB, TypeDeplacement.Moto, TypeClimat.Chaud );
	voyage3 = voyageRepo.save(voyage3);
	
	 List<Voyage> Voyage1 = new ArrayList<>();
     Collections.addAll(Voyage1, voyage1);
     
     List<Voyage> Voyage2 = new ArrayList<>();
     Collections.addAll(Voyage2, voyage2,voyage3);
     
	
	
	Utilisateur c1 = new Utilisateur("Even","Manon", "Manondu56", "12345", "manoneven@gmail.com", "0650265588");
	Set<Roles> rolec1 = new HashSet<>();
	rolec1.add(Roles.User);
	c1.setRoles(rolec1);
	c1.setVoyageurs(utilisateur1);
	c1.setVoyages(Voyage1);
	c1 = utilisateurRepo.save(c1);
	
	Utilisateur c2 = new Utilisateur("Andraos","Rawad", "Rads", "12345", "rawadandraos@gmail.com", "0778050623");
	Set<Roles> rolec2 = new HashSet<>();
	rolec2.add(Roles.User);
	rolec2.add(Roles.Admin);
	c1.setRoles(rolec2);
	c2.setVoyageurs(utilisateur2);
	c2.setVoyages(Voyage1);
	c2.setVoyages(Voyage2);
	
	c2 = utilisateurRepo.save(c2);
	


	

	
	



	
	
	
	}

}
