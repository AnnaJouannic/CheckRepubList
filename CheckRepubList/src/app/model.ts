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


 export class Type {
    static typeLogements: Array<any> = new Array<any>();
    static typeDeplacements: Array<any> = new Array<any>();
    static typeClimats: Array<any> = new Array<any>();
    static typeCategories: Array<any> = new Array<any>();

    static {
        Type.typeDeplacements.push({"code": "Marche", "label":"Marche"});
        Type.typeDeplacements.push({"code": "Velo", "label":"Vélo"});
        Type.typeDeplacements.push({"code": "Voiture", "label":"Voiture"});
        Type.typeDeplacements.push({"code": "Van", "label":"Van"});
        Type.typeDeplacements.push({"code": "Campingcar", "label":"Camping-Car"});
        Type.typeDeplacements.push({"code": "Train", "label":"Train"});
        Type.typeDeplacements.push({"code": "Avion", "label":"Avion"});
        Type.typeDeplacements.push({"code": "Bateau", "label":"Bâteau"});
        Type.typeDeplacements.push({"code": "Autre", "label":"Autre"});

        Type.typeLogements.push({"code": "Hotel", "label":"Hôtel"});
        Type.typeLogements.push({"code": "Gite", "label":"Gîte"});
        Type.typeLogements.push({"code": "ChambreDhote", "label":"Chambre D'hôte"});
        Type.typeLogements.push({"code": "Location", "label":"Location"});
        Type.typeLogements.push({"code": "AirBnB", "label":"AirBnB"});
        Type.typeLogements.push({"code": "AubergeDeJeunesse", "label":"Auberge De Jeunesse"});
        Type.typeLogements.push({"code": "MobilHome", "label":"Mobil Home"});
        Type.typeLogements.push({"code": "Van", "label":"Van"});
        Type.typeLogements.push({"code": "CampingCar", "label":"Camping-Car"});
        Type.typeLogements.push({"code": "Tente", "label":"Tente"});
        Type.typeLogements.push({"code": "Voiture", "label":"Voiture"});
        Type.typeLogements.push({"code": "Autre", "label":"Autre"});

        Type.typeClimats.push({"code": "Chaud", "label":"Chaud"});
        Type.typeClimats.push({"code": "Froid", "label":"Froid"});
        Type.typeClimats.push({"code": "Tempere", "label":"Tempéré"});
        Type.typeClimats.push({"code": "Tropical", "label":"Tropical"});
        Type.typeClimats.push({"code": "Desertique", "label":"Desertique"});
        Type.typeClimats.push({"code": "Autre", "label":"Autre"});

        Type.typeCategories.push({"code": "Vetement", "label":"Vêtement"});
        Type.typeCategories.push({"code": "Numerique", "label":"Numérique"});
        Type.typeCategories.push({"code": "Outils", "label":"Outils"});
        Type.typeCategories.push({"code": "Toilette", "label":"Toilette"});
        Type.typeCategories.push({"code": "Animaux", "label":"Animaux"});
        Type.typeCategories.push({"code": "Pharmacie", "label":"Pharmacie"});
        Type.typeCategories.push({"code": "Administratif", "label":"Administratif"});
    }

   
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
