import { Injectable } from '@angular/core';
import { Utilisateur } from '../model';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UtilisateurHttpService {
  constructor(private http: HttpClient) { }

  findAll(): Observable<Utilisateur[]> {
    return this.http.get<Utilisateur[]>("http://localhost:8080/api/utilisateur");
  }

  findById(id: number): Observable<Utilisateur> {
    return this.http.get<Utilisateur>("http://localhost:8080/api/utilisateur/"+id);
  }

  save(utilisateur: Utilisateur): Observable<Utilisateur> {
    if(utilisateur.id) { // mise à jour
      return this.http.put<Utilisateur>("http://localhost:8080/api/utilisateur/"+utilisateur.id, utilisateur);
    } else { // création
      return this.http.post<Utilisateur>("http://localhost:8080/api/utilisateur", utilisateur);
    }
   }

   deleteById(id: number): Observable<void> {
    return this.http.delete<void>("http://localhost:8080/api/utilisateur/"+id);
   }

   inscription(nom:string, prenom: string, username: string, password: string, passwordVerif: string, mail: string, tel: number): Observable<any> {
    return this.http.post<any>("http://localhost:8080/api/utilisateur", {
       "nom":nom,
       "prenom":prenom,
        "username": username,
        "password": password,
        "passwordVerif": passwordVerif , 
        "mail": mail,
        "tel": tel, 
        
      });
   }

   connexion(username: string, password: string):Observable<Utilisateur> {
    return this.http.post<Utilisateur>("http://localhost:8080/api/utilisateur/connexion", {
        
        "username": username,
        "password": password
      });
   }
}
