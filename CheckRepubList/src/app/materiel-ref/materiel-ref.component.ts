import { Component, OnInit } from '@angular/core';
import { Categorie, MaterielRef } from '../model';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { MaterielRefHttpService } from './materiel-ref-http.service';

@Component({
  selector: 'app-materiel-ref',
  templateUrl: './materiel-ref.component.html',
  styleUrls: ['./materiel-ref.component.scss']
})
export class MaterielRefComponent implements OnInit { 
materielsRef$: Observable<MaterielRef>;
 materielRefForm: FormGroup;
 showForm: boolean = false;
 categorie = Object.values(Categorie);
 
  constructor(private materielRefHttpService: MaterielRefHttpService, private formBuilder: FormBuilder, private router: Router){}
  
  
  

  ngOnInit(): void {
    
    this.materielRefForm = this.formBuilder.group({
      id: this.formBuilder.control(''),
      libelleMateriel: this.formBuilder.control('', [Validators.required]),
      categorie: this.formBuilder.control(''),
      critere: this.formBuilder.control(''),
      
    });
    
    //this.materielsRef$ = this.materielRefService.findAll();
  }

  // ngOnInit(): void {
  //   this.materielsRef$ = this.materielRefHttpService.findAll();
  // }

   list(): Array<MaterielRef> {

    return this.materielRefHttpService.findAll();
  }

  // list(): Observable<MaterielRef[]> {
  //   return this.materielRefHttpService['findAll']();
  // }
   
  // listCritere(): Array<Critere>{
  //   return this.critereService.findAll();
  // }

  // add(){
  //   this.materielRefForm.reset();
  //   //this.materielRefForm.critere = new Critere();
  //   this.showForm = true;
  // }

  add() {
    this.materielRefForm.reset();
    this.showForm = true;
  }
  // edit(id: number) {
  //   this.materielRefHttpService.findById(id).subscribe(response => {
  //     this.materielRefForm.patchValue(response);
  //     this.showForm = true;

  //     // if(!this.materielRefForm.critere){
  //     //   this.materielRefForm.critere = new Critere();
  //     // }
  //     if(!this.materielRefForm.get('critere')?.value) {
  //        this.materielRefForm = new Critere();
  //      }
  //   });
  // }

  // edit(id: number){
  //   this.materielRefHttpService.findById(id).subscribe(response => {
  //     this.materielRefForm.patchValue(response);
  //     this.showForm = true;
  //   });
  // }
  edit(id: number){
    this.materielRefHttpService.findById(id).subscribe(response => {
      this.materielRefForm.patchValue(response);
      this.showForm = true;
    });
  }

  // save() {
  //   this.materielRefHttpService.save(this.materielRefForm.value).subscribe(response => {
  //     this.materielsRef$ = this.materielRefHttpService.findAll();
  //   });
  // }

  save() {
    this.materielRefHttpService.save(this.materielRefForm.value)
      this.cancel(); // Réinitialisez le formulaire après la sauvegarde.
    
  }

  // save() {
  //   this.materielRefService.save(this.materielRefForm.value).subscribe(response => {
  //     // Réactivez le formulaire après avoir sauvegardé
  //     this.materielRefForm.reset();
  //     this.showForm = false;
  //   });
  // }
  // cancel() {
  //   this.materielRefForm.reset();
  //   this.showForm = false;
  // }

  cancel() {
    this.materielRefForm.reset() // Réinitialisez avec une instance vide.
    this.showForm = false;
  }

  // save() {
  //   this.materielRefHttpService.save(this.materielRefForm.value);
  // }
  // remove(id: number) {
  //   this.materielRefHttpService.deleteById(id).subscribe(() => {
  //     this.materielsRef$ = this.materielRefHttpService.findAll();
  //   });
  // }

  remove(id: number) {
    this.materielRefHttpService.deleteById(id);
  
  }

  // remove(id: number) {
  //   this.materielRefHttpService.deleteById(id);
  //     // Mettez à jour la liste après la suppression
  // }

  show() {
    this.showForm = true;
  }
  critere(){
    this.router.navigate(["/critere"]);
  }

}




