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

export class Utilisateur {
    id: number;
    nom: string;
    prenom: string;
    login: string;
    password: string;
    tel: number;
    mail: string;
    disabled: boolean

    constructor(
        id?: number,
        nom?: string,
        prenom?: string,
        login?: string,
        password?: string,
        mail?: string,
        tel?: number,
        disabled?: boolean,
    ) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
        this.disabled = disabled;
        this.mail = mail;
        this.tel = tel;
    }
}