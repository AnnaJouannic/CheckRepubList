import { Component, OnInit } from '@angular/core';
import { Critere, MaterielRef, TypeClimat, TypeDeplacement, TypeLogement } from '../model';
import { CritereService } from './critere.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CritereHttpService } from './critere-http.service';
import { Observable } from 'rxjs';
import { Router, Routes } from '@angular/router';

@Component({
  selector: 'app-critere',
  templateUrl: './critere.component.html',
  styleUrls: ['./critere.component.scss']
})
export class CritereComponent implements OnInit {

  //critereForm: Critere = null;
  critereForm: FormGroup;
  showForm: boolean  =false;
  criteres$: Observable<Critere[]>;
  modesLogement = Object.values(TypeLogement);
  modesDeplacement = Object.values(TypeDeplacement);
  modesClimat = Object.values(TypeClimat);
  materielsRef$: Observable<MaterielRef[]>;

  constructor(private critereHttpService: CritereHttpService,private critereService: CritereService, private formBuilder: FormBuilder, private router: Router){}

  ngOnInit(): void {
    this.  critereForm = this.formBuilder.group({
      id: this.formBuilder.control(0),
      materielRef: this.formBuilder.control('',[Validators.required]),
      logement: this.formBuilder.control(''),
      deplacement: this.formBuilder.control(''),
      climat: this.formBuilder.control(''),
    });
    this.criteres$ = this.critereHttpService.findAll();
    
  }

//  list(): Array<Critere>{

//   return this.critereHttpService.findAll();

//  }

//   return this.critereHttpService.findAll();

//  }

 add() {
  this.critereForm.reset();
  this.showForm = true; //afficher le formulaire
}

edit(id: number) {
  this.critereHttpService.findById(id).subscribe(response => {
    this.critereForm.patchValue(response);
    this.showForm = true;
  });
}

// save() {
//   this.critereHttpService.save(this.critereForm).subscribe(response => {
//     this.criteres$ = this.critereHttpService.findAll();
//   });
// }

// save() {
//   let critere = this.critereForm.value; // Récupérer les données du formulaire sous forme d'objet
//   this.critereHttpService.save(critere).subscribe(response => {
//     this.criteres$ = this.critereHttpService.findAll();
//     this.showForm = false; // Masquer le formulaire après l'enregistrement
//   });
// }

save() {
  this.critereHttpService.save(this.critereForm.value);
  this.cancel();
  this.showForm=true;
}

cancel() {
  this.critereForm.reset();
  this.showForm = false;
}

remove(id: number) {
  this.critereHttpService.deleteById(id).subscribe(response => {
    this.criteres$ = this.critereHttpService.findAll();
  });
}

show() {
  this.showForm = true;
}
voyageur(){
  this.router.navigate(["/materielRef"]);
}

}
