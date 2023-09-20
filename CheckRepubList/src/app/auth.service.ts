import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private utilisateurHttpService: UtilisateurHttpService, private router: Router) { }

  authentification(login: string, password: string) {
    this.utilisateurHttpService.connexion(login, password).subscribe(resp => {
      sessionStorage.setItem("user", JSON.stringify(resp));
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
