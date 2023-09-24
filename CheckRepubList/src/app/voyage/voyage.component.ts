import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { VoyageService } from './voyage.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { VoyageHttpService } from './voyage-http.service';
import { TypeClimat, TypeDeplacement, TypeLogement, Voyage } from '../model';

@Component({
  selector: 'app-voyage',
  templateUrl: './voyage.component.html',
  styleUrls: ['./voyage.component.scss']
})
export class VoyageComponent   implements OnInit{

  voyages$: Observable<Voyage[]>;
  voyageForm!: FormGroup;
  showForm: boolean = false;
  modesLogement = Object.values(TypeLogement);
  modesDeplacement = Object.values(TypeDeplacement);
  modesClimat = Object.values(TypeClimat);


  constructor( private router: Router, private formBuilder: FormBuilder, private voyageService: VoyageHttpService ) {}



  ngOnInit(): void {
    this.voyageForm = this.formBuilder.group({
      dateDebutVoyage: this.formBuilder.control('', [Validators.required ]),
      dateFinVoyage: this.formBuilder.control('', [Validators.required ]),
      libelle: this.formBuilder.control('', [Validators.required, Validators.maxLength(25)]),
      pays: this.formBuilder.control('', [Validators.required, Validators.maxLength(25)]),
      logement:this.formBuilder.control('', [Validators.required]),
      deplacement:this.formBuilder.control('', [Validators.required]),
      climat:this.formBuilder.control('', [Validators.required]),
  });
  
  this.voyages$ = this.voyageService.findAll();
  
  }


add() {
  this.voyageForm.reset();
  this.showForm = true;
}

/*edit(id: number) {
  this.voyageService.findById(id).subscribe(response => {
    this.voyageForm.patchValue(response);
    this.showForm = true;
  }); 

}*/

/*remove(id: number) {
  this.voyageHttpService.deleteById(id);
}
*/
save() {
  this.voyageService.save(this.voyageForm.value);
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

}

