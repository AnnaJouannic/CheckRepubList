import { Injectable } from '@angular/core';
import { TypeClimat, TypeDeplacement, TypeLogement, Voyage } from '../model';

@Injectable({
  providedIn: 'root'
})
export class VoyageService {

  voyages: Array<Voyage> = new Array<Voyage>();

  constructor() {
    this.voyages.push(new Voyage(1,"09/10/2024","09/12/2024","Voyage Ski","Suisse",TypeLogement.Hotel, TypeDeplacement.Train, TypeClimat.Froid));
    this.voyages.push(new Voyage(2,"13/12/2025","13/01/2025","Voyage nature","Espagne",TypeLogement.Van, TypeDeplacement.Van, TypeClimat.Froid));
    this.voyages.push(new Voyage(3,"26/10/2023","09/11/2023","Voyage italie ","Italie",TypeLogement.AirBnB, TypeDeplacement.Avion, TypeClimat.Tempere));
   }


   findAll() : Array<Voyage> {
    return this.voyages;
   }

   findById(id: number): Voyage {
    return this.voyages.find(v => v.id == id);
   }

   save(voyage: Voyage): void {
    if(voyage.id) {
      let pos = this.voyages.findIndex(v => v.id == voyage.id);
      this.voyages[pos] = voyage;
    } else {
      let max = 0;
      this.voyages.forEach(v => {
        if(v.id > max) {
          max = v.id;
        }
      });

      voyage.id = ++max;

      this.voyages.push(voyage);
    }
   }

   deleteById(id: number) {
    let pos = this.voyages.findIndex(v =>v.id == id);

    this.voyages.splice(pos, 1);
   }

  

}

