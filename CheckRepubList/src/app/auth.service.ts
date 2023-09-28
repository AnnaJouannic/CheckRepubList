import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

import { Utilisateur } from './model';
import { UtilisateurHttpService } from './utilisateur/utilisateur-http.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private utilisateurService: UtilisateurHttpService, private router: Router) { }

  authentification(login: string, password: string) {
  this.utilisateurService.connexion(login, password).subscribe(resp =>{
      sessionStorage.setItem("User", JSON.stringify( resp));
      this.router.navigate(["/voyage"]);
    });
    }
  

  deconnexion() {
    sessionStorage.removeItem("User");
    this.router.navigate([""]);
  }

  
  getUtilisateur(): Utilisateur {

    let struser = sessionStorage.getItem("User");
  
    if (struser !== null) { // Vérifiez si struser n'est pas null ou undefined.
      try {
        let utilisateur: Utilisateur = JSON.parse(struser);
  
        if (utilisateur && typeof utilisateur === 'object') {
          return utilisateur;
        }
      } catch (e) {
        console.error("Erreur lors de la conversion JSON : ", e);
      }
    }
  
    return null; // Retournez null si la valeur n'existe pas ou si la conversion JSON échoue.
  }

  isAuthenticated(): boolean {
    return this.getUtilisateur() != null ;
  }

  hasRole(roles: string): boolean {
    return this.getUtilisateur().roles.indexOf(roles) > -1;
  }
}


