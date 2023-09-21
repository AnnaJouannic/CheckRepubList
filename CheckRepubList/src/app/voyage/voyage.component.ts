import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Voyage } from '../model';
import { VoyageService } from './voyage.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-voyage',
  templateUrl: './voyage.component.html',
  styleUrls: ['./voyage.component.scss']
})
export class VoyageComponent   implements OnInit{

  voyageForm!: FormGroup;
  showForm: boolean = false;
  constructor( private router: Router, private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.voyageForm = this.formBuilder.group({
      dateDebutVoyage: this.formBuilder.control('', [Validators.required ,Validators.pattern(/^\d{2}-\d{2}-\d{4}$/)]),
      dateFinVoyage: this.formBuilder.control('', [Validators.required ,Validators.pattern(/^\d{2}-\d{2}-\d{4}$/)]),
      libelle: this.formBuilder.control('', [Validators.required, Validators.maxLength(25)]),
      pays: this.formBuilder.control('', [Validators.required, Validators.maxLength(25)]),
      logement:this.formBuilder.control('', [Validators.required]),
      deplacement:this.formBuilder.control('', [Validators.required]),
      climat:this.formBuilder.control('', [Validators.required]),
  });
  
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
  //this.voyageHttpService.save(this.voyageForm.value);
  this.cancel();
}

cancel() {
  this.showForm = false;
  this.voyageForm.reset();
}


}
