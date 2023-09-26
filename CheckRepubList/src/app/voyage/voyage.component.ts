import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

// import { VoyageService } from './voyage.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { VoyageHttpService } from './voyage-http.service';
import { TypeClimat, TypeDeplacement, TypeLogement, Voyage, Voyageur } from '../model';
import { VoyageurService } from '../voyageur/voyageur.service';
import { VoyageService } from './voyage.service';

@Component({
  selector: 'app-voyage',
  templateUrl: './voyage.component.html',
  styleUrls: ['./voyage.component.scss']
})
export class VoyageComponent   implements OnInit{

  voyages$: Observable<Voyage[]>;
  voyageForm: FormGroup;
  showForm: boolean = false;
  modesLogement = Object.values(TypeLogement);
  modesDeplacement = Object.values(TypeDeplacement);
  modesClimat = Object.values(TypeClimat);
  // voyageurs$: Observable<Voyageur[]>;
  FormHidden: boolean = true;
  
  


  constructor( private router: Router, private formBuilder: FormBuilder, private voyageHttpService: VoyageHttpService ,private voyageurService : VoyageurService, private voyageService: VoyageService ) {}



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
  // this.voyageurs$ = this.voyageurService.findAllForAsync();
  
  //   //  this.voyageurs$ = this.voyageurService.findAllForAsync(); 
  }
  
  list(): Array<Voyageur> {
    return this.voyageurService.findAll();
  }

  listvoyage(): Array<Voyage>{
    return this.voyageService.findAll();
  }

add() {
  this.voyageForm.reset();
  this.showForm = true;
  


}

// edit(id: number) {
//   this.voyageHttpService.findById(id).subscribe(resp => {
//     this.voyageForm=resp;
//     if(!this.voyageForm.voyageur) {
//       this.voyageForm.voyageur= new Voyageur ();
//     }

//   }); 

// }

edit(id: number) {
  this.voyageHttpService.findById(id).subscribe(resp => {
    this.voyageForm.patchValue(resp);
    this.showForm = true;
   
  });
}

remove(id: number) {
  this.voyageHttpService.deleteById(id);
}

save() {
  this.voyageHttpService.save(this.voyageForm.value);
  this.cancel();
  this.showForm=true;
  
  
}

cancel() {
  this.showForm = false;
  this.voyageForm.reset();
}

show() {
  this.showForm = true;
  
}
voyageur(){
  this.router.navigate(["/voyageur"]);
  
}
 hidden(){
  this.FormHidden=! this.FormHidden
 }
}

