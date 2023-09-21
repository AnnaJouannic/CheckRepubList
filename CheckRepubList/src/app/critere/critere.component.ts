import { Component } from '@angular/core';
import { Critere } from '../model';
import { CritereService } from './critere.service';

@Component({
  selector: 'app-critere',
  templateUrl: './critere.component.html',
  styleUrls: ['./critere.component.scss']
})
export class CritereComponent {

  critereForm: Critere = null;
 

  constructor(private critereService: CritereService){}

 list(): Array<Critere>{

  return this.critereService.findAll();

 }

 add() {
  this.critereForm = new Critere();
}
edit(id: number) {
  this.critereForm = {...this.critereService.findById(id)};
}
remove(id: number) {
  this.critereService.deleteById(id);
}
save() {
  this.critereService.save(this.critereForm);
}
cancel() {
  this.critereForm = null;
}
}
