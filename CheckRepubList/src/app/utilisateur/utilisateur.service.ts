import { Injectable } from '@angular/core';
import { Utilisateur } from '../model';

@Injectable({
  providedIn: 'root'
})
export class UtilisateurService {

  utilisateurs: Array<Utilisateur> = new Array<Utilisateur>();

  constructor() {
    this.utilisateurs.push(new Utilisateur(3, "Even","Manon", "Manondu56", "Manon12?",  "manoneven@gmail.com", "0650265588","user"));
    this.utilisateurs.push(new Utilisateur(5, "DIALLO","Tidiane","Tidiane","123456", "tidiane@gamil.com",  "7712489581", "user" ));
    this.utilisateurs.push(new Utilisateur(13, "Andraos","Rawad", "Rads", "12345","rawadandraos@gmail.com", "0778050623" , "ADMIN"));
   }


   findAll() : Array<Utilisateur> {
    return this.utilisateurs;
   }

   findById(id: number): Utilisateur {
    return this.utilisateurs.find(u => u.id == id);
   }

   save(utilisateur: Utilisateur): void {
    if(utilisateur.id) {
      let pos = this.utilisateurs.findIndex(u => u.id == utilisateur.id);
      this.utilisateurs[pos] = utilisateur;
    } else {
      let max = 0;
      this.utilisateurs.forEach(u => {
        if(u.id > max) {
          max = u.id;
        }
      });

      utilisateur.id = ++max;

      this.utilisateurs.push(utilisateur);
    }
   }

   deleteById(id: number) {
    let pos = this.utilisateurs.findIndex(u => u.id == id);

    this.utilisateurs.splice(pos, 1);
   }

   inscription(nom: string,prenom: string,login: string,password: string,tel: string,mail: string) {
    let utilisateur: Utilisateur = new Utilisateur(null, nom, prenom,login,password,tel,mail);
    utilisateur.roles.push("user");

    this.save(utilisateur);
   }

   connexion(login: string, password: string):Utilisateur {
    return this.utilisateurs.find(u => u.login == login  && u.password == password);
   }

}
