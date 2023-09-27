import { Injectable } from '@angular/core';
import { MaterielRef } from '../model';
import { environment } from '../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MaterielRefHttpService {

  materielsRef: Array<MaterielRef> = new Array<MaterielRef>();

  apiMaterielRefUrl: string = environment.apiUrl + "/materielref";

  constructor(private http: HttpClient) {
   this.load();
  }

   load(): void{
    let obs: Observable<MaterielRef[]> = this.http.get<MaterielRef[]>(this.apiMaterielRefUrl);

    obs.subscribe(response => {
      this.materielsRef = response;
    });
   }

  //  findAll(): Observable<MaterielRef[]> {
  //   return this.http.get<MaterielRef[]>(this.apiMaterielRefUrl);
  // } 

   findAll(): Array<MaterielRef>{
    return this.materielsRef;
  }
   findAllforAsync() : Observable<MaterielRef[]> {
    return this.http.get<MaterielRef[]>(this.apiMaterielRefUrl);
  }
  

  findById(id: number): Observable<MaterielRef>{

   let obs: Observable<MaterielRef> = this.http.get<MaterielRef>(this.apiMaterielRefUrl + "/"+id);
    return obs;
  }

  save(materielRef: MaterielRef): void {
    if(materielRef.id) { // mise à jour
      this.http.put<MaterielRef>(this.apiMaterielRefUrl + "/"+materielRef.id, materielRef).subscribe(response =>{
        this.load();
      });
      
    } else { // création
       this.http.post<MaterielRef>(this.apiMaterielRefUrl, materielRef).subscribe(response => {
        this.load();
       });
      
    }
   }
   deleteById(id: number){
    this.http.delete<void>(this.apiMaterielRefUrl + "/"+id).subscribe(response => {
      this.load();
    });
   }
}
