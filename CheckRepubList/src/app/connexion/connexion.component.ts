import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.scss']
})
export class ConnexionComponent implements OnInit{
  
 connexionForm!: FormGroup;

  constructor(private authService: AuthService, private formBuilder: FormBuilder) { 
  
  }

  ngOnInit(): void {
    this.connexionForm= this.formBuilder.group({
    login:  this.formBuilder.control("", Validators.required),
    password: this.formBuilder.control("", [Validators.required, Validators.minLength(5), Validators.pattern("[A-z0-9!#@$*?-]{5,10}")])
    })
  }
  auth() {
   this.authService.authentification(this.connexionForm.get('login')?.value, this.connexionForm.get('password')?.value);
 }
}
