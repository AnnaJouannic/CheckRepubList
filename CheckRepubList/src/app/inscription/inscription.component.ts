import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UtilisateurService } from '../utilisateur/utilisateur.service';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.scss']
})
export class InscriptionComponent  implements OnInit {

  inscriptionForm: FormGroup;
  showForm: boolean = false;
  constructor(private utilisateurService: UtilisateurService, private router: Router, private formBuilder: FormBuilder) {
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
      login: this.formBuilder.control('', Validators.required),
      password: this.formBuilder.control('', [Validators.required, Validators.minLength(5), Validators.pattern("[A-z0-9!#@$*?-]{5,10}")]),
      passwordVerif: this.formBuilder.control('', Validators.required),
      mail: this.formBuilder.control('', [Validators.required, Validators.email]),
      tel: this.formBuilder.control('', Validators.required),
     

    });
  }
  save() {
    this.utilisateurService.save(this.inscriptionForm.value);
    this.cancel();

    if (this.inscriptionForm.valid) {
      const password = this.inscriptionForm.value.password;
      const passwordVerif = this.inscriptionForm.value.passwordVerif;
  
      if (password === passwordVerif) {
        
        console.log('Mot de passe confirmé : ', password);
      } else {
        
        console.error('Les mots de passe ne correspondent pas.');
      }
    }
  }

  cancel() {
    this.showForm = false;
    this.inscriptionForm.reset();
  }
}
