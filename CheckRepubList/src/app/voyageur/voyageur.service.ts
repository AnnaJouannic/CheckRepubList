import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Voyage, Voyageur } from '../model';
import { environment } from '../environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VoyageurService {
   voyageurs: Array<Voyageur> = new Array<Voyageur>();
  apiVoyageurUrl: string = environment.apiUrl + "/voyageur";


  constructor(private http: HttpClient) { 
    this.load();
  }

  load(): void {
    let obs: Observable<Voyageur[]> = this.http.get<Voyageur[]>(this.apiVoyageurUrl);
    obs.subscribe(resp => { this.voyageurs = resp;});
  }

  findAll(): Array<Voyageur> {
    return this.voyageurs;
  }

  findById(id: number): Observable<Voyageur> {
    let obs: Observable<Voyageur> = this.http.get<Voyageur>(this.apiVoyageurUrl+"/"+id);
  return obs;
  }

  save(voyageur: Voyageur): void {
    if(voyageur.id) { // mise à jour
      this.http.put<Voyageur>(this.apiVoyageurUrl+"/"+voyageur.id, voyageur).subscribe(resp => {
        this.load();
    }); 
  }else { // création
     this.http.post<Voyageur>(this.apiVoyageurUrl, voyageur).subscribe(resp => {
      this.load();
    });
   }}

   deleteById(id: number) {
   this.http.delete<void>(this.apiVoyageurUrl+"/"+id).subscribe(resp => {
    this.load();
   });
  }

}


