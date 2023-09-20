import { Component, OnInit } from '@angular/core';
import { Utilisateur } from '../model';
import { UtilisateurService } from './utilisateur.service';
import { Observable } from 'rxjs';



@Component({
  selector: 'app-utilisateur',
  templateUrl: './utilisateur.component.html',
  styleUrls: ['./utilisateur.component.scss']
})
export class UtilisateurComponent {

 // utilisateurs$: Observable<Utilisateur[]>;
  utilisateurForm: Utilisateur = null;

  // utilisateurs$!: Observable<Utilisateur[]>;
  // utilisateurForm: Utilisateur = new Utilisateur();

  constructor(private utilisateurService: UtilisateurService) {

  }
  // ngOnInit(): void {
  //   this.utilisateurs$ = this.utilisateurService.findAll();
  // }

  list(): Array<Utilisateur> {
    return this.utilisateurService.findAll();
  }

  // add() {
  //   this.utilisateurForm = new Utilisateur(null, nom, prenom, login, password, mail, tel, false);
  // }

  add() {
    
    this.utilisateurForm = new Utilisateur( );
  }

  edit(id: number) {
    this.utilisateurForm = {...this.utilisateurService.findById(id)};
   
  }
  // edit(id: number) {
  //   this.utilisateurService.findById(id).subscribe((utilisateur: Utilisateur) => {
  //     this.utilisateurForm = utilisateur;
  //   });
  // }

  save() {
    this.utilisateurService.save(this.utilisateurForm)
    this.cancel();
  }

  // save() {
  //   this.utilisateurService.save(this.utilisateurForm).subscribe(() => {
  //     this.cancel(); // Réinitialisez le formulaire après la sauvegarde.
  //     this.utilisateurs$ = this.utilisateurService.findAll(); // Mettez à jour la liste des utilisateurs.
  //   });
  // }

  cancel() {
    this.utilisateurForm = null;
  }

  // cancel() {
  //   this.utilisateurForm = new Utilisateur(); // Réinitialisez le formulaire.
  // }

  remove(id: number) {
    this.utilisateurService.deleteById(id)
  }

  // remove(id: number) {
  //   this.utilisateurService.deleteById(id).subscribe(() => {
  //     this.utilisateurs$ = this.utilisateurService.findAll(); // Mettez à jour la liste des utilisateurs après la suppression.
  //   });
  // }

}

