import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private utilisateurService: UtilisateurService, private router: Router) { }

  authentification(login: string, password: string) {
    this.utilisateurService.connexion(login, password).subscribe(r => {
      sessionStorage.setItem("user", JSON.stringify(r));
      this.router.navigate(["/"]);
    });
  }

  deconnexion() {
    sessionStorage.removeItem("user");
  }

  getUtilisateur(): Utilisateur {
    let struser = sessionStorage.getItem("user");

    if(struser) {
      let utilisateur: Utilisateur = JSON.parse(struser);

      return utilisateur
    }

    return null;
  }

  isAuthenticated(): boolean {
    return this.getUtilisateur() != null;
  }

  hasRole(role: string): boolean {
    return this.getUtilisateur().roles.indexOf(role) > -1;
  }

  
}
