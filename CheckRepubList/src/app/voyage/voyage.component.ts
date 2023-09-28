import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

// import { VoyageService } from './voyage.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { VoyageHttpService } from './voyage-http.service';
import {  MaterielRef, Type, Voyage, Voyageur } from '../model';
import { VoyageurService } from '../voyageur/voyageur.service';
import { VoyageService } from './voyage.service';
import { MaterielRefHttpService } from '../materiel-ref/materiel-ref-http.service';
//import { VoyageService } from './voyage.service';

@Component({
  selector: 'app-voyage',
  templateUrl: './voyage.component.html',
  styleUrls: ['./voyage.component.scss']
})
export class VoyageComponent   implements OnInit{

//   voyages$: Observable<Voyage[]>;
//   voyageForm: FormGroup;
//   showForm: boolean = false;
//   modesLogement = Object.values(TypeLogement);
//   modesDeplacement = Object.values(TypeDeplacement);
//   modesClimat = Object.values(TypeClimat);
//   // voyageurs$: Observable<Voyageur[]>;
//   FormHidden: boolean = true;
  
  

  // materielRef: Array<MaterielRef>;
  

//   constructor( private router: Router, private formBuilder: FormBuilder, private voyageHttpService: VoyageHttpService ,private voyageurService : VoyageurService, private voyageService: VoyageService ) {}



//   ngOnInit(): void {
//     this.voyageForm = this.formBuilder.group({
//       dateDebutVoyage: this.formBuilder.control('', [Validators.required ]),
//       dateFinVoyage: this.formBuilder.control('', [Validators.required ]),
//       libelle: this.formBuilder.control('', [Validators.required, Validators.maxLength(25)]),
//       pays: this.formBuilder.control('', [Validators.required, Validators.maxLength(25)]),
//       logement:this.formBuilder.control('', [Validators.required]),
//       deplacement:this.formBuilder.control('', [Validators.required]),
//       climat:this.formBuilder.control('', [Validators.required]),
//       voyageur:this.formBuilder.control('',[Validators.required]),
     
//   });
//   // this.voyageurs$ = this.voyageurService.findAllForAsync();
  
//   //   //  this.voyageurs$ = this.voyageurService.findAllForAsync(); 
//   }
  
//   list(): Array<Voyageur> {
//     return this.voyageurService.findAll();
//   }

//   listvoyage(): Array<Voyage>{
//     return this.voyageService.findAll();
//   }

// add() {
//   this.voyageForm.reset();
//   this.showForm = true;
  


// }

// // edit(id: number) {
// //   this.voyageHttpService.findById(id).subscribe(resp => {
// //     this.voyageForm=resp;
// //     if(!this.voyageForm.voyageur) {
// //       this.voyageForm.voyageur= new Voyageur ();
// //     }

// //   }); 

// // }

// edit(id: number) {
//   this.voyageHttpService.findById(id).subscribe(resp => {
//     this.voyageForm.patchValue(resp);
//     this.showForm = true;
   
//   });
// }

// remove(id: number) {
//   this.voyageHttpService.deleteById(id);
// }

// save() {
//   this.voyageHttpService.save(this.voyageForm.value);
//   this.cancel();
//   this.showForm=true;
//   this.voyages$ = this.voyageHttpService.findAll();
  
  
// }

// cancel() {
//   this.showForm = false;
//   this.voyageForm.reset();
// }

// show() {
//   this.showForm = true;
  
// }
// voyageur(){
//   this.router.navigate(["/voyageur"]);
  
// }
//  hidden(){
// this.FormHidden=! this.FormHidden
//  }
// }


voyageForm: FormGroup;
showForm: boolean = false;
FormHidden: boolean = true;
MatHidden: boolean = true;
modeslogement=  Type.typeLogements;
modesDeplacement = Type.typeDeplacements;
modesClimat = Type.typeClimats;
voyages$: Observable<Voyage[]>;
voyageurs$: Observable<Voyageur[]>;
materielRef$: Observable<MaterielRef[]>;
monvoyage: Observable<Voyage>;


constructor( private router: Router,private formBuilder: FormBuilder, private voyageService: VoyageHttpService, private voyageurService: VoyageurService, private materielRefService: MaterielRefHttpService) {
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
hidden(){
  this.FormHidden=! this.FormHidden
   }

   hiddenMat(){
    this.MatHidden=! this.MatHidden
    this.showForm = false;
     }
     

show() {
this.showForm = true;
      
}
voyageur(){
  this.router.navigate(["/voyageur"]);
        
 }

 getvoyage(id: number) {

    // let strvoyage = this.voyageService.findById(id);
    // console.log(strvoyage);
    //   return strvoyage;
      this.voyageService.findById(id).subscribe(resp => {
        this.voyageForm.patchValue(resp);
        console.log(this.voyageForm)
  
    //  this.voyageService.findById(id).subscribe(resp => {
    // this.monvoyage==resp;
    
   
  });
  // return this.monvoyage;
 

} }