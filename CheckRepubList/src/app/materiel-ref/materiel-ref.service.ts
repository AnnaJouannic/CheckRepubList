import { Injectable } from '@angular/core';
import { Categorie, MaterielRef } from '../model';

@Injectable({
  providedIn: 'root'
})
export class MaterielRefService {


  materielsref: Array<MaterielRef> = new Array<MaterielRef>
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
  
    findAll(): Array<MaterielRef>{
      return this.materielsref;
    }
  
    findById(id: number): MaterielRef{
      return this.materielsref.find(matRef => matRef.id == id);
    }
  
    save(materielRef: MaterielRef): void{
      if(materielRef.id){
        let pos = this.materielsref.findIndex(matRef => matRef.id == materielRef.id);
        this.materielsref[pos]= materielRef;
      }else{
        let max = 0;
        this.materielsref.forEach(matRef =>{
          if(matRef.id > max){
            max = matRef.id;
          }
        });
        materielRef.id = ++max;
      this.materielsref.push(materielRef);
      }
    }
  
    deleteById(id: number){
      let pos = this.materielsref.findIndex(matRef => matRef.id == id);

      this.materielsref.splice(pos, 1);
    }
   
  }
  

