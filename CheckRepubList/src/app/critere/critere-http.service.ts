import { Injectable } from '@angular/core';
import { Critere } from '../model';
import { environment } from '../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CritereHttpService {
  //criteres: Array<Critere> = new Array<Critere>();

  apiCritereUrl: string = environment.apiUrl + "/critere";

  constructor(private http: HttpClient) {
    
   }

  //  load(): void{
  //   let obs: Observable<Critere[]> = this.http.get<Critere[]>(this.apiCritereUrl);

  //   obs.subscribe(response => {
  //     this.criteres = response;
  //   });
  //  }

  findAll(): Observable<Critere[]>  {
    return this.http.get<Critere[]>(this.apiCritereUrl)
  }
  
  findById(id: number): Observable<Critere> {
    return this.http.get<Critere>(this.apiCritereUrl + "/"+id);
  }

  save(critere: Critere): Observable<Critere> {
    if(critere.id) { // mise à jour
      return this.http.put<Critere>(this.apiCritereUrl + "/"+critere.id, critere);
    } else { // création
      return this.http.post<Critere>(this.apiCritereUrl, critere);
    }
   }
   deleteById(id: number): Observable<void> {

    return this.http.delete<void>(this.apiCritereUrl + "/"+id);
   }
}


