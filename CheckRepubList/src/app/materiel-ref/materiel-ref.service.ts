import { Injectable } from '@angular/core';
import { Categorie, MaterielRef } from '../model';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MaterielRefService {
  [x: string]: any;


  materielsref: Array<MaterielRef> = new Array<MaterielRef>
  //materielsRef$: Observable<MaterielRef[]>;
  constructor() { 
      this.materielsref.push(new MaterielRef(1, "Maillot de bain", Categorie.Vetement));
      this.materielsref.push(new MaterielRef(3, "T-shirt", Categorie.Vetement));
      this.materielsref.push(new MaterielRef(5, "Pull", Categorie.Vetement));
      this.materielsref.push(new MaterielRef(8, "pantalon", Categorie.Vetement));
      this.materielsref.push(new MaterielRef(9, "Short", Categorie.Vetement));
      this.materielsref.push(new MaterielRef(11, "Robe", Categorie.Vetement));
      this.materielsref.push(new MaterielRef(12, "Jupe", Categorie.Vetement));
      this.materielsref.push(new MaterielRef(13, "Pyjama", Categorie.Vetement));
      this.materielsref.push(new MaterielRef(15, "Sous-Vetement", Categorie.Vetement));
      this.materielsref.push(new MaterielRef(16, "Basket", Categorie.Vetement));
      this.materielsref.push(new MaterielRef(17, "Sandales", Categorie.Vetement));
    }
  
    materielsRef$: Observable<MaterielRef[]> = of(this.materielsref);
    // findAll(): Array<MaterielRef>{
    //   return this.materielsref;
    // }

    // findAll(): Observable<MaterielRef[]> {
    //   return this.materielsRef$;
    // }

    findById(id: number): Observable<MaterielRef> {
      let foundMaterielRef = this.materielsref.find(matRef => matRef.id === id);
      return foundMaterielRef ? of(foundMaterielRef) : of(null);
    }
  
    // findById(id: number): MaterielRef{
    //   return this.materielsref.find(matRef => matRef.id == id);
    // }
  
    // save(materielRef: MaterielRef): void{
    //   if(materielRef.id){
    //     let pos = this.materielsref.findIndex(matRef => matRef.id == materielRef.id);
    //     this.materielsref[pos]= materielRef;
    //   }else{
    //     let max = 0;
    //     this.materielsref.forEach(matRef =>{
    //       if(matRef.id > max){
    //         max = matRef.id;
    //       }
    //     });
    //     materielRef.id = ++max;
    //   this.materielsref.push(materielRef);
    //   }
    // }

    save(materielRef: MaterielRef): Observable<void> {
      if (materielRef.id) {
        const index = this.materielsref.findIndex(matRef => matRef.id === materielRef.id);
        if (index !== -1) {
          this.materielsref[index] = materielRef;
          return of(null);
        }
      } else {
        let maxId = 0;
        this.materielsref.forEach(matRef => {
          if (matRef.id > maxId) {
            maxId = matRef.id;
          }
        });
        materielRef.id = maxId + 1;
        this.materielsref.push(materielRef);
        return of(null);
      }
      return of(null);

    }
  
    // deleteById(id: number){
    //   let pos = this.materielsref.findIndex(matRef => matRef.id == id);

    //   this.materielsref.splice(pos, 1);
    // }

    deleteById(id: number): Observable<void> {
      const index = this.materielsref.findIndex(matRef => matRef.id === id);
      if (index !== -1) {
        this.materielsref.splice(index, 1);
      }
      return of(null);
    }
   
  }
  

