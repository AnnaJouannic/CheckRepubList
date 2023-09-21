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