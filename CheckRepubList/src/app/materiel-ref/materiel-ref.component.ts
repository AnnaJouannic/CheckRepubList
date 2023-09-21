import { Component } from '@angular/core';
import { Critere, MaterielRef } from '../model';
import { MaterielRefService } from './materiel-ref.service';
import { CritereService } from '../critere/critere.service';

@Component({
  selector: 'app-materiel-ref',
  templateUrl: './materiel-ref.component.html',
  styleUrls: ['./materiel-ref.component.scss']
})
export class MaterielRefComponent {

  materielRefForm: MaterielRef = null;
 

  constructor(private materielRefService: MaterielRefService, private critereService: CritereService){}

  list(): Array<MaterielRef>{
    return this.materielRefService.findAll();
  }

  listCritere(): Array<Critere>{
    return this.critereService.findAll();
  }

  add(){
    this.materielRefForm = new MaterielRef();
    this.materielRefForm.critere = new Critere();
  }

  edit(id: number) {
    this.materielRefForm = {...this.materielRefService.findById(id)};

    if(!this.materielRefForm.critere) {
      this.materielRefForm.critere = new Critere();
    }
  }

  save() {  
    if(this.materielRefForm.critere.id) {
      this.materielRefForm.critere = {...this.critereService.findById(this.materielRefForm.critere.id)};
    }

    this.materielRefService.save(this.materielRefForm);
  }

  cancel() {
    this.materielRefForm = null;
  }

  remove(id: number) {
    this.materielRefService.deleteById(id);
  }

}



