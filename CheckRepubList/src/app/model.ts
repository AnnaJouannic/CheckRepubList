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
    dateDebutVoyage: Date;
    dateFinVoyage: Date;
    libelle: string;
    login: string;
    password: string;
    pays: string;
    logement: TypeLogement;
    deplacement: TypeDeplacement;
    climat: TypeClimat;

    constructor(
       dateDebutVoyage: Date,
       dateFinVoyage: Date,
       libelle: string,
       login: string,
       password: string,
       pays: string,
       logement: TypeLogement,
       deplacement: TypeDeplacement,
       climat: TypeClimat,
    ) {
        this.dateDebutVoyage = dateDebutVoyage;
        this.dateFinVoyage = dateFinVoyage;
        this.libelle = libelle;
        this.login = login;
        this.password = password;
        this.pays = pays;
        this.logement = logement;
        this.deplacement = deplacement;
        this.climat=climat;
    }
}