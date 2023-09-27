export class MaterielRef{
    id: number;
    libelleMateriel: string;
    categorie: string;
    
    constructor( 
        id?: number,
        libelleMateriel?: string,
        categorie?: string,
        
        )
        {
            this.id = id
            this.libelleMateriel = libelleMateriel
            this.categorie = categorie
            
    }
}

export class Critere{
    id: number;
    materielRef: MaterielRef;
    logement: string;
    deplacement: string;
    climat: string;
    constructor(
        id?: number,
       materielRef?: MaterielRef,
        logement?: string,
        deplacement?: string,
        climat?: string,
    ){
        this.id = id
        this.materielRef = materielRef
        this.logement = logement
        this.deplacement = deplacement,
        this.climat = climat
    }
}

export enum Categorie{
    Vetement = 'Vetement', 
    Numerique = 'Numerique', 
    Outils = 'Outils', 
    Toilette = 'Toilette', 
    Animaux = 'Animaux', 
    Pharmacie = 'Pharmacie', 
    Administratif = 'Administratif',
}


export class Utilisateur {
    id: number;
    nom: string;
    prenom: string;
    login: string;
    password: string;
     mail: string;
    tel: string;
   
    roles: Array<string> = new Array<string>;

    constructor(
        id?: number,
        nom?: string,
        prenom?: string,
        login?: string,
        password?: string,
        mail?: string,
        tel?: string,
        ...roles: string[]
    ) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
        this.mail = mail;
        this.tel = tel;
        this.roles= roles;
    }
}

 export enum TypeLogement {
    Hotel='Hotel',
    Gite='Gite',
    ChambreDhote='ChambreDhote',
    Location='Location',
    AirBnB='AirBnB',
    AubergeDeJeunesse='AubergeDeJeunesse',
    MobilHome='MobilHome',
    Van='Van',
    CampingCar='CampingCar',
    Tente='Tente',
    Voiture='Voiture',
    Autre='Autre'
 }

 export enum TypeDeplacement {
    Marche='Marche',
    Velo='Velo',
    Voiture='Voiture',
    Van= 'Van',
    Campingcar='Campingcar',
    Bateau='Bateau',
    Train='Train',
    Avion='Avion',
    Moto='Moto',
    Autre='Autre',

}

export enum TypeClimat {
  Chaud = 'Chaud',
  Froid = 'Froid',
  Tempere = 'Tempéré',
  Tropical = 'Tropical',
  Desertique = 'Désertique',
  Autre = 'Autre'
}
 
export class Voyage {
    id: number;
    dateDebutVoyage: string;
    dateFinVoyage: string;
    libelle: string;
    pays: string;
    logement: string;
    deplacement: string;
    climat: string;
    voyageur: Voyageur;
    materielRef: MaterielRef;
    


    constructor(
        id?: number,
       dateDebutVoyage?: string,
       dateFinVoyage?: string,
       libelle?: string,
       pays?: string,
       logement?: string,
       deplacement?: string,
       climat?: string,
       voyageur?: Voyageur,
      materielRef?: MaterielRef,
    ) {
        this.id=id;
        this.dateDebutVoyage = dateDebutVoyage;
        this.dateFinVoyage = dateFinVoyage;
        this.libelle = libelle;
        this.pays = pays;
        this.logement = logement;
        this.deplacement = deplacement;
        this.climat=climat;
        this.voyageur=voyageur;
        this.materielRef= materielRef;
    }
}
    
export class Voyageur{
    id: number;
    nom: string;
    prenom: string;
    naissance: string;
    accessibilite: boolean;
    voyage: Array<Voyage> = new Array<Voyage>();

    constructor(
        id?: number,
        nom?: string,
        prenom?: string,
        naissance?: string,
        accessibilite?: boolean,
        ...voyage: Voyage[]
       
    ) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.naissance = naissance;
        this.accessibilite= accessibilite;
        this.voyage= voyage;
    }
}