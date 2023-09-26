import { Injectable } from '@angular/core';
import { Critere } from '../model';
import { environment } from '../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CritereHttpService {
  
  criteres: Array<Critere> = new Array<Critere>();

  apiCritereUrl: string = environment.apiUrl + "/critere";

  constructor(private http: HttpClient) {
    this.load();
  }

   load(): void{
    let obs: Observable<Critere[]> = this.http.get<Critere[]>(this.apiCritereUrl);

    obs.subscribe(response => {
      this.criteres= response;
    });
  }

    findAll(): Array<Critere>{
      return this.criteres;
    }
  // findAll(): Observable<Critere[]> {
  //   return this.http.get<Critere[]>(this.apiCritereUrl);
  // } 

  findAllForAsync(): Observable<Critere[]>{
    return this.http.get<Critere[]>(this.apiCritereUrl);
  }

  findById(id: number): Observable<Critere> {
   let obs: Observable<Critere> = this.http.get<Critere>(this.apiCritereUrl + "/"+id);
   return obs;
  }

  save(critere: Critere): void {
    if(critere.id) { // mise à jour

      this.http.put<Critere>(this.apiCritereUrl + "/"+critere.id, critere).subscribe(response => {
        this.load();
      });
    } else { // création
      this.http.post<Critere>(this.apiCritereUrl, critere).subscribe(response => {
        this.load();
      });

    }
   }
   deleteById(id: number) {
    this.http.delete<void>(this.apiCritereUrl + "/"+id).subscribe(response => {
      this.load();
    });
   }
}


