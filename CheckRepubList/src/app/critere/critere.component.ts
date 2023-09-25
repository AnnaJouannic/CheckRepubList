import { Component, OnInit } from '@angular/core';
import { Critere, TypeClimat, TypeDeplacement, TypeLogement } from '../model';
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

  constructor(private critereHttpService: CritereHttpService, private formBuilder: FormBuilder, private router: Router){}

  ngOnInit(): void {
    this.  critereForm = this.formBuilder.group({
      id: this.formBuilder.control(0),
      materielRef: this.formBuilder.control(Validators.required),
      logement: this.formBuilder.control(''),
      deplacement: this.formBuilder.control(''),
      climat: this.formBuilder.control(''),
    });
    this.criteres$ = this.critereHttpService.findAll();
    
  }

//  list(): Array<Critere>{

//   return this.critereHttpService.findAll();

//  }

 add() {
  this.critereForm.reset();
  //this.showForm = true;
}
edit(id: number) {
  this.critereHttpService.findById(id).subscribe(response => {
    this.critereForm.patchValue(response);
    //this.showForm = true;
  });
}

remove(id: number) {
  this.critereHttpService.deleteById(id);
}
save() {
  this.critereHttpService.save(this.critereForm.value);
}

cancel() {
  this.critereForm.reset();
  //this.showForm = false;
}
}
