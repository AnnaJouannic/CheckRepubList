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