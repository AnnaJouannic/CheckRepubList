import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-voyage',
  templateUrl: './voyage.component.html',
  styleUrls: ['./voyage.component.scss']
})
export class VoyageComponent   implements OnInit{

  voyageForm!: FormGroup;
  showForm: boolean = false;
  constructor(private voyageService: VoyageService, private router: Router, private formBuilder: FormBuilder) {
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
   
     
    
  }

}
