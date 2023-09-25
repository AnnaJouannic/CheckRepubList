import { Injectable } from '@angular/core';
import { MaterielRef } from '../model';
import { environment } from '../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MaterielRefHttpService {

  //materielsRef: Array<MaterielRef> = new Array<MaterielRef>();

  apiMaterielRefUrl: string = environment.apiUrl + "/materielRef";

  constructor(private http: HttpClient) {}

  //  load(): void{
  //   let obs: Observable<MaterielRef[]> = this.http.get<MaterielRef[]>(this.apiMaterielRefUrl);

  //   obs.subscribe(response => {
  //     this.materielsRef = response;
  //   });
  //  }

  //  findAll() : Observable<MaterielRef> {
  //   return this.materielsRef;
  // }
  findAll(): Observable<MaterielRef[]> {
    return this.http.get<MaterielRef[]>(this.apiMaterielRefUrl);
  } 

  findById(id: number): Observable<MaterielRef> {
   return this.http.get<MaterielRef>(this.apiMaterielRefUrl + "/"+id);

  }

  save(materielRef: MaterielRef): Observable<MaterielRef> {
    if(materielRef.id) { // mise à jour
      return this.http.put<MaterielRef>(this.apiMaterielRefUrl + "/"+materielRef.id, materielRef);
    } else { // création
      return this.http.post<MaterielRef>(this.apiMaterielRefUrl, materielRef);
    }
   }
   deleteById(id: number) {
    return this.http.delete<void>(this.apiMaterielRefUrl + "/"+id)
   }
}
