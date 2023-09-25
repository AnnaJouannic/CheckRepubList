import { Component, OnInit } from '@angular/core';
import { Utilisateur } from '../model';
import { UtilisateurService } from './utilisateur.service';
import { Observable } from 'rxjs';
import { UtilisateurHttpService } from './utilisateur-http.service';



@Component({
  selector: 'app-utilisateur',
  templateUrl: './utilisateur.component.html',
  styleUrls: ['./utilisateur.component.scss']
})
export class UtilisateurComponent implements OnInit{

 
 
  utilisateurs$: Observable<Utilisateur[]>;
  utilisateurForm: Utilisateur = null;

 


  constructor(private utilisateurService: UtilisateurHttpService) {

  }
  ngOnInit(): void {
    this.utilisateurs$ = this.utilisateurService.findAll();
  }

  // list(): Array<Utilisateur> {
  //   return this.utilisateurService.findAll();
  // }

  add() {
    this.utilisateurForm = new Utilisateur();
  }

  // add() {
    
  //   this.utilisateurForm = new Utilisateur( );
  // }

  // edit(id: number) {
  //   this.utilisateurForm = {...this.utilisateurService.findById(id)};
   
  // }
  edit(id: number) {
    this.utilisateurService.findById(id).subscribe(resp => {
      this.utilisateurForm = resp;
    });
  }

  // save() {
  //   this.utilisateurService.save(this.utilisateurForm)
  //   this.cancel();
  // }

  save() {
    this.utilisateurService.save(this.utilisateurForm).subscribe(resp => {
      this.utilisateurs$ = this.utilisateurService.findAll(); // Mettez à jour la liste des utilisateurs.
    });
  }

  // cancel() {
  //   this.utilisateurForm = null;
  // }

  cancel() {
    this.utilisateurForm = null; 
  }

  // remove(id: number) {
  //   this.utilisateurService.deleteById(id)
  // }

  remove(id: number) {
    this.utilisateurService.deleteById(id).subscribe(resp => {
      this.utilisateurs$ = this.utilisateurService.findAll(); 
    });
  }

}

