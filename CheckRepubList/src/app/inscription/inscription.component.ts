import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.scss']
})
export class InscriptionComponent  implements OnInit {

  inscriptionForm!: FormGroup;
  showForm: boolean = false;
  constructor(private utilisateurHttpService: UtilisateurHttpService, private router: Router, private formBuilder: FormBuilder) {
  }

  /*valider() {
    this.utilisateurHttpService.inscription(this.nom,this.prenom,this.login, this.password, this.passwordVerif, this.mail,this.tel).subscribe(resp => {
      this.router.navigate(["/connexion"]);
    });
  }*/
  
  ngOnInit(): void {
    this.inscriptionForm = this.formBuilder.group({
      nom: this.formBuilder.control('', Validators.required),
      prenom: this.formBuilder.control('', Validators.required),
      password: this.formBuilder.control('', [Validators.required, Validators.minLength(4), Validators.maxLength(130)]),
      mail: this.formBuilder.control('', [Validators.required, Validators.email]),
      tel: this.formBuilder.control('', Validators.required),
     

    });
  }
  save() {
    this.utilisateurHttpService.save(this.inscriptionForm.value);
    this.cancel();
  }

  cancel() {
    this.showForm = false;
    this.inscriptionForm.reset();
  }
}
