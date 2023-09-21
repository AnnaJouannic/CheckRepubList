export class MaterielRef{

    id: number;
    libelleMateriel: string;
    categorie: Categorie;
    critere: Critere;


    constructor( 
        id?: number,
        libelleMateriel?: string,
        categorie?: Categorie,
        critere?: Critere,
        )
        {
            this.id = id
            this.libelleMateriel = libelleMateriel
            this.categorie = categorie
            this.critere = critere
        
    }
}

export class Critere{
    id: number;
    materielRef: MaterielRef;
    logement: TypeLogement;
    deplacement: TypeDeplacement;
    climat: TypeClimat;

    constructor(
        id?: number,
       //materieleRef?: MaterielRef,
        logement?: TypeLogement,
        deplacement?: TypeDeplacement,
        climat?: TypeClimat,
    ){
        this.id = id
        //this.materielRef = materieleRef
        this.logement = logement
        this.deplacement = deplacement,
        this.climat = climat
    }
}

export enum Categorie{
    Vetement, Numerique, Outils, Toilette, Animaux, Pharmacie, Administratif
}


export class Utilisateur {
    id: number;
    nom: string;
    prenom: string;
    login: string;
    password: string;
    tel: string;
    mail: string;
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
        this.roles = roles;
    }
}

 export enum TypeLogement {
    Hotel, Gite, ChambreDHote,Location, AirBnB, AubergeDeJeunesse, 
	MobilHome, Van, CampingCar, Tente, Voiture, Autre
 }

 export enum TypeDeplacement {
    Marche, Velo, Voiture, Van, Campingcar, 
	Bateau, Train, Avion, Moto, Autre 
}

export enum TypeClimat {
    Froid, Chaud, Tempere, Tropical, Desertique, Autre
}
 
export class Voyage {
    id: number;
    dateDebutVoyage: string;
    dateFinVoyage: string;
    libelle: string;
    pays: string;
    logement: TypeLogement;
    deplacement: TypeDeplacement;
    climat: TypeClimat;


    constructor(
        id: number,
       dateDebutVoyage: string,
       dateFinVoyage: string,
       libelle: string,
       pays: string,
       logement: TypeLogement,
       deplacement: TypeDeplacement,
       climat: TypeClimat,
    ) {
        this.id=id;
        this.dateDebutVoyage = dateDebutVoyage;
        this.dateFinVoyage = dateFinVoyage;
        this.libelle = libelle;
        this.pays = pays;
        this.logement = logement;
        this.deplacement = deplacement;
        this.climat=climat;
    }
}