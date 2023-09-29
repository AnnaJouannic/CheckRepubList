import { Component, HostListener, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

// import { VoyageService } from './voyage.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { VoyageHttpService } from './voyage-http.service';
import {  MaterielRef, Type, Voyage, Voyageur } from '../model';
import { VoyageurService } from '../voyageur/voyageur.service';
import { VoyageService } from './voyage.service';
import { MaterielRefHttpService } from '../materiel-ref/materiel-ref-http.service';
import { waitForAsync } from '@angular/core/testing';
import { DatePipe } from '@angular/common';
//import { VoyageService } from './voyage.service';


@Component({
  selector: 'app-voyage',
  templateUrl: './voyage.component.html',
  styleUrls: ['./voyage.component.scss']
})
export class VoyageComponent   implements OnInit{

  // togg1.addEventListener("click", () => {
  //   if(getComputedStyle(d1).display != "none"){
  //     d1.style.display = "none";
  //   } else {
  //     d1.style.display = "block";
  //   }
  // })


 
checklist: boolean = false;
voyageForm: FormGroup;
showForm: boolean = false;
action: string = null;
MatHidden: boolean = true;
modeslogement=  Type.typeLogements;
modesDeplacement = Type.typeDeplacements;
modesClimat = Type.typeClimats;
voyages$: Observable<Voyage[]>;
voyageurs$: Observable<Voyageur[]>;
materielRef$: Observable<MaterielRef[]>;
strvoyage$:Observable<Voyage>;
monvoyage: Voyage = null;
categoriesDistinctes: string[] = ['Vetement', 'Numerique', 'Outils', 'Toilette', 'Pharmacie', 'Administratif']; // 'Animaux',


constructor( private router: Router,private formBuilder: FormBuilder, private voyageService: VoyageHttpService, private voyageurService: VoyageurService, private materielRefService: MaterielRefHttpService, private datePipe :DatePipe) {
}



ngOnInit(): void {
    this.voyageForm = this.formBuilder.group({
    dateDebutVoyage: this.formBuilder.control('', [Validators.required ]),
    dateFinVoyage: this.formBuilder.control('', [Validators.required ]),
    libelle: this.formBuilder.control('', [Validators.required, Validators.maxLength(25)]),
    pays: this.formBuilder.control('', [Validators.required, Validators.maxLength(25)]),
    logement:this.formBuilder.control('', [Validators.required]),
    deplacement:this.formBuilder.control('', [Validators.required]),
    climat:this.formBuilder.control('', [Validators.required]),
    idVoyageur:this.formBuilder.control('',[Validators.required]),
       
    });

    this.voyages$ = this.voyageService.findAll();
    this.voyageurs$ = this.voyageurService.findAllForAsync();
    this.materielRef$ = this.materielRefService.findAllforAsync();
}


list(id: number){
  this.voyageService.findById(id).subscribe(resp => {
    this.voyageForm.value;
    this.showForm = true;
  });
  }

//  listvoy(): Array<Voyageur> {
//       return this.voyageurService.findAll();
//     }
// listVoyage(): Array<Voyage> {
//   return this.voyageService.findAll();
// }

add() {

  this.voyageForm.patchValue(new Voyage());

  this.showForm = true;
}

edit(id: number) {
  this.voyageService.findById(id).subscribe(resp => {
    this.voyageForm.patchValue(resp);
    this.showForm = true;
    // if(!this.voyageForm.value.voyageur) {
    //   this.voyageForm.patchValue(new Voyageur());
    // }
  });
}

// majVoyage(event: any) {
//   if(!this.voyageurForm.voyage) {
//     this.voyageurForm.voyage = new Voyage(event);
//   }
// }

save() {  
  // this.voyageService.save(this.voyageForm.value);
  // 
  // this.cancel();
  
   console.log(this.voyageForm.value);
  this.voyageService.save(this.voyageForm.value).subscribe(resp => {
    this.voyages$ = this.voyageService.findAll();

});  
 
}

//  recap(id:number){

//    this.voyageService.findById(id).subscribe(resp => {
//     this.voyageForm.patchValue(this.voyageForm.value);
//   });
//   this.showForm = true;
// }

cancel() {
  this.showForm = false;
  this.voyageForm.reset();
  
}

remove(id: number) {
  // this.voyageService.deleteById(id);
  this.voyageService.deleteById(id).subscribe(resp => {
    this.voyages$ = this.voyageService.findAll();
  });
}


historique(){
  this.action = "ancien";
  this.monvoyage = null;
 
   }
show() {
this.action = "nouveau";
this.monvoyage = null;

}
voyageur(){
  this.router.navigate(["/voyageur"]);
        
 }

generate(){
  this.checklist = true;
}

getvoyage(id?:number) {

this.action="checklist";

 this.voyageService.findById(id)
 .subscribe((data) => {
    this.monvoyage = data;
    // this.monvoyageurs = data.voyageurs;
    // this.monmateriels = data.materiels; 
});

  console.log(this.monvoyage);

 }


}