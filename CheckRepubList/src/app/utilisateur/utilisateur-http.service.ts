// import { Injectable } from '@angular/core';
// import { Utilisateur } from '../model';
// import { Observable } from 'rxjs';

// @Injectable({
//   providedIn: 'root'
// })
// export class UtilisateurHttpService {
//   constructor(private http: HttpClient) { }

//   findAll(): Observable<Utilisateur[]> {
//     return this.http.get<Utilisateur[]>("http://localhost:8080/api/utilisateur");
//   }

//   findById(id: number): Observable<Utilisateur> {
//     return this.http.get<Utilisateur>("http://localhost:8080/api/utilisateur/"+id);
//   }

//   save(utilisateur: Utilisateur): Observable<Utilisateur> {
//     if(utilisateur.id) { // mise à jour
//       return this.http.put<Utilisateur>("http://localhost:8080/api/utilisateur/"+utilisateur.id, utilisateur);
//     } else { // création
//       return this.http.post<Utilisateur>("http://localhost:8080/api/utilisateur", utilisateur);
//     }
//    }

//    deleteById(id: number): Observable<void> {
//     return this.http.delete<void>("http://localhost:8080/api/utilisateur/"+id);
//    }

//    inscription(email: string, username: string, tel: number, password: string, passwordVerif: string): Observable<any> {
//     return this.http.post<any>("http://localhost:8080/api/utilisateur", {
//         "email": email,
//         "username": username,
//         "tel": tel,
//         "password": password, 
//         "passwordVerif": passwordVerif
//       });
//    }

//    connexion(email: string, username: string, password: string):Observable<Utilisateur> {
//     return this.http.post<Utilisateur>("http://localhost:8080/api/utilisateur/authentification", {
//         "email": email,
//         "username": username,
//         "password": password
//       });
//    }
// }
