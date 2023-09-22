import { Component, OnInit } from '@angular/core';
import { VoyageurService } from './voyageur.service';
import { Voyage, Voyageur } from '../model';
import { Observable } from 'rxjs';
import { FormBuilder, FormGroup } from '@angular/forms';
import { VoyageHttpService } from '../voyage/voyage-http.service';

@Component({
  selector: 'app-voyageur',
  templateUrl: './voyageur.component.html',
  styleUrls: ['./voyageur.component.scss']
})
export class VoyageurComponent implements OnInit{

  voyageurs$: Observable<Voyageur[]>;
  voyages$: Observable<Voyage[]>;
  voyageurForm: FormGroup;
  showForm: boolean = false


  constructor(private formBuilder: FormBuilder, private voyageurService: VoyageurService, private voyageService: VoyageHttpService) {
  }
  
  ngOnInit(): void {
   this.voyageurs$ = this.voyageurService.findAll();
  this.voyages$ = this.voyageService.findAll();

    this.voyageurForm = this.formBuilder.group({
      id: this.formBuilder.control('0'),
      nom: this.formBuilder.control(''),
      prenom: this.formBuilder.control(''),
      naissance: this.formBuilder.control(''),
      accessibilite:this.formBuilder.control(''),
      voyage: this.formBuilder.control(''),
    });
  }

  // list(){
  //    return this.voyageurService.findAll();
  // }
  // listVoyage(): Array<Voyage> {
  //   return this.voyageService.findAll();
  // }

  add() {
    this.voyageurForm.reset();
    this.showForm = true;
  }

  edit(id: number) {
    this.voyageurService.findById(id).subscribe(resp => {
      this.voyageurForm.patchValue(resp);

     if(!this.voyageurForm.get('voyage')?.value) {
       this.voyageurForm.setValue(new Voyage());
      }
      this.showForm = true;
    });
  }

  // majVoyage(event: any) {
  //   if(!this.voyageurForm.voyage) {
  //     this.voyageurForm.voyage = new Voyage(event);
  //   }
  // }

  save() {  
    this.voyageurService.save(this.voyageurForm.value).subscribe(resp => {
      this.voyageurs$ = this.voyageurService.findAll();
    });
  }

  cancel() {
    this.voyageurForm.reset();
  }

  remove(id: number) {
    this.voyageurService.deleteById(id).subscribe(resp => {
      this.voyageurs$ = this.voyageurService.findAll();
    });
  }

}



