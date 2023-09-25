import { Component, OnInit } from '@angular/core';
import { Categorie, Critere, MaterielRef } from '../model';
import { MaterielRefService } from './materiel-ref.service';
import { CritereService } from '../critere/critere.service';
import { MaterielRefHttpService } from './materiel-ref-http.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-materiel-ref',
  templateUrl: './materiel-ref.component.html',
  styleUrls: ['./materiel-ref.component.scss']
})
export class MaterielRefComponent implements OnInit {

  //materielRefForm: MaterielRef = null;
 materielRefForm: FormGroup;
 showForm: boolean = false;
 materielsRef$: Observable<MaterielRef[]>;
 criteres$: Observable<Critere[]>;
 categorie = Object.values(Categorie);


  constructor(private materielRefHttpService: MaterielRefHttpService, private critereService: CritereService, private formBuilder: FormBuilder){}

  ngOnInit(): void {
    this.materielRefForm = this.formBuilder.group({
      id: this.formBuilder.control(0),
      libelleMateriel: this.formBuilder.control('', [Validators.required]),
      categorie: this.formBuilder.control(''),
      critere: this.formBuilder.control('')
    });

    this.materielsRef$ = this.materielRefHttpService.findAll();
  }

  //  list(): Array<MaterielRef>{
  //   return this.materielRefHttpService.findAll();
  // }
   
  // listCritere(): Array<Critere>{
  //   return this.critereService.findAll();
  // }

  add(){
    this.materielRefForm.reset();
    //this.materielRefForm.critere = new Critere();
    this.showForm = true;
  }

  edit(id: number) {
    this.materielRefHttpService.findById(id).subscribe(response => {
      this.materielRefForm.patchValue(response);
      this.showForm = true;
    });
  }

  save() {
    this.materielRefHttpService.save(this.materielRefForm.value).subscribe(response => {
      this.materielsRef$ = this.materielRefHttpService.findAll();
    });
  }
  cancel() {
    this.materielRefForm.reset();
    this.showForm = false;
  }

  remove(id: number) {
    this.materielRefHttpService.deleteById(id).subscribe(response => {
      this.materielsRef$ = this.materielRefHttpService.findAll();
    });
  } 

}



