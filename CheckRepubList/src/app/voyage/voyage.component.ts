import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

// import { VoyageService } from './voyage.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { VoyageHttpService } from './voyage-http.service';
import { Categorie, MaterielRef, TypeClimat, TypeDeplacement, TypeLogement, Voyage, Voyageur } from '../model';
import { VoyageurService } from '../voyageur/voyageur.service';
import { VoyageService } from './voyage.service';
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
  
  

  materielRef: Array<MaterielRef>;
  categorie = Object.values(Categorie);

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
modesLogement = Object.values(TypeLogement);
modesDeplacement = Object.values(TypeDeplacement);
modesClimat = Object.values(TypeClimat);
voyages$: Observable<Voyage[]>;
voyageurs$: Observable<Voyageur[]>;



constructor( private router: Router,private formBuilder: FormBuilder, private voyageService: VoyageHttpService, private voyageurService: VoyageurService) {
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
    voyageur:this.formBuilder.control('',[Validators.required]),
       
    });

    this.voyages$ = this.voyageService.findAll();
    this.voyageurs$ = this.voyageurService.findAllForAsync();
}

// list(): Array<Voyage>{
//  return this.voyageService.findAll();
 
//  }

//  listvoy(): Array<Voyageur> {
//       return this.voyageurService.findAll();
//     }
// listVoyage(): Array<Voyage> {
//   return this.voyageService.findAll();
// }

add() {

  this.voyageForm.patchValue(new Voyage());
  this.voyageForm.patchValue(new Voyageur());
  this.showForm = true;
}

edit(id: number) {
  this.voyageService.findById(id).subscribe(resp => {
    this.voyageForm.patchValue(resp);
    this.showForm = true;
    if(!this.voyageForm.get('voyageur')?.value) {
      this.voyageForm.patchValue(new Voyageur());
    }
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
  this.voyageService.save(this.voyageForm.value).subscribe(resp => {
    this.voyages$ = this.voyageService.findAll();
   
}); console.log(this.voyageForm.value);
}

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

show() {
this.showForm = true;
      
}
voyageur(){
  this.router.navigate(["/voyageur"]);
        
 }

}