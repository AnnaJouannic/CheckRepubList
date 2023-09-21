import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Voyage, Voyageur } from '../model';
import { environment } from '../environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VoyageurService {
 
  apiVoyageurUrl: string = environment.apiUrl + "/voyageur";

  constructor(private http: HttpClient) { 
    
  }

  findAll(): Observable<Voyageur[]> {
    return this.http.get<Voyageur[]>(this.apiVoyageurUrl);
  }

  findById(id: number): Observable<Voyageur> {
    return this.http.get<Voyageur>(this.apiVoyageurUrl+"/"+id);
  }

  save(voyageur: Voyageur): Observable<Voyageur> {
    if(voyageur.id) { // mise à jour
      return this.http.put<Voyageur>(this.apiVoyageurUrl+"/"+voyageur.id, voyageur);
    } else { // création
      return this.http.post<Voyageur>(this.apiVoyageurUrl, voyageur);;
    }
   }

   deleteById(id: number): Observable<void> {
    return this.http.delete<void>(this.apiVoyageurUrl+"/"+id);
   }
}
  


