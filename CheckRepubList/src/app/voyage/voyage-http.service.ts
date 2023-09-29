import { HttpClient } from "@angular/common/http";
import { environment } from "../environments/environment";
import { Observable } from "rxjs";
import { Voyage } from "../model";
import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root'
  })
  export class VoyageHttpService {
    voyages: Array<Voyage> = new Array<Voyage>();
    apiVoyageUrl: string = environment.apiUrl + "/voyage";
  
    constructor(private http: HttpClient) { 
      
    }
  
    findAll(): Observable<Voyage[]> {
      return this.http.get<Voyage[]>(this.apiVoyageUrl);
    }
    
    findById(id: number): Observable<Voyage> {
      return this.http.get<Voyage>(this.apiVoyageUrl+"/"+id);
    }
  
    save(voyage: Voyage): Observable<Voyage> {
      if(voyage.id) { // mise à jour
        return this.http.put<Voyage>(this.apiVoyageUrl+"/"+voyage.id, voyage);
      } else { // création
        return this.http.post<Voyage>(this.apiVoyageUrl, voyage);
      }
     }
  
     deleteById(id: number): Observable<void> {
      return this.http.delete<void>(this.apiVoyageUrl+"/"+id);
     }
  }