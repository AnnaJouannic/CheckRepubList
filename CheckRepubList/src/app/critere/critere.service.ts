import { Injectable } from '@angular/core';
import { Critere, MaterielRef, TypeClimat, TypeDeplacement, TypeLogement } from '../model';

@Injectable({
  providedIn: 'root'
})
export class CritereService {

  criteres: Array<Critere> = new Array<Critere>();
  materielsRef: MaterielRef;
  constructor() { 
    this.criteres.push(new Critere(1, this.materielsRef, TypeLogement.Hotel,TypeDeplacement.Voiture, TypeClimat.Froid));
    this.criteres.push(new Critere(2, this.materielsRef,TypeLogement.Gite ,TypeDeplacement.Van, TypeClimat.Chaud));
    this.criteres.push(new Critere(4, this.materielsRef,TypeLogement.ChambreDhote ,TypeDeplacement.Campingcar, TypeClimat.Tropical));
    this.criteres.push(new Critere(5, this.materielsRef,TypeLogement.Location ,TypeDeplacement.Bateau, TypeClimat.Tempere));
    this.criteres.push(new Critere(7, this.materielsRef,TypeLogement.AirBnB,TypeDeplacement.Train, TypeClimat.Desertique));
    this.criteres.push(new Critere(9, this.materielsRef,TypeLogement.AubergeDeJeunesse,TypeDeplacement.Avion, TypeClimat.Autre));
    this.criteres.push(new Critere(13, this.materielsRef,TypeLogement.MobilHome,TypeDeplacement.Moto, TypeClimat.Chaud));
  }

  findAll() : Array<Critere> {
    return this.criteres;
   }

   findById(id: number): Critere {
    return this.criteres.find(crit => crit.id == id);
   }

   save(critere: Critere): void {
    if(critere.id) {
      let pos = this.criteres.findIndex(crit => crit.id == critere.id);
      this.criteres[pos] = critere;
    } else {
      let max = 0;
      this.criteres.forEach(crit=> {
        if(crit.id > max) {
          max = crit.id;
        }
      });
      critere.id = ++max;

      this.criteres.push(critere);
  }
   }
   deleteById(id: number) {
    let pos = this.criteres.findIndex(crit => crit.id == id);

    this.criteres.splice(pos, 1);
   }
}
