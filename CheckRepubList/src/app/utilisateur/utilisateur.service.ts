import { Injectable } from '@angular/core';
import { Utilisateur } from '../model';

@Injectable({
  providedIn: 'root'
})
export class UtilisateurService {

  utilisateurs: Array<Utilisateur> = new Array<Utilisateur>();

  constructor() {
    this.utilisateurs.push(new Utilisateur(3, "manon@gamil.com", "manon", "123456", "EVEN", "Manon", 7712489581, false));
    this.utilisateurs.push(new Utilisateur(5, "tidiane@gamil.com", "Tidiane", "123456", "DIALLO", "Tidiane", 7712489581, false));
    this.utilisateurs.push(new Utilisateur(13, "rawad@gamil.com", "rawad", "123456", "ANDRAOS", "Rawad", 7712489581, false));
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

   inscription(login: string, password: string, mail: string, tel: number) {
    let utilisateur: Utilisateur = new Utilisateur();
    //utilisateur.roles.push("USER");

    this.save(utilisateur);
   }

   connexion(login: string, password: string):Utilisateur {
    return this.utilisateurs.find(u => u.login == login  && u.password == password);
   }

}
