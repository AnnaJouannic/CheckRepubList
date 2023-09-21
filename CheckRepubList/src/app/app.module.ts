import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MaterielRefComponent } from './materiel-ref/materiel-ref.component';
import { ConnexionComponent } from './connexion/connexion.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { UtilisateurComponent } from './utilisateur/utilisateur.component';
import { AccueilComponent } from './accueil/accueil.component';
import { VoyageurComponent } from './voyageur/voyageur.component';



@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    ConnexionComponent,
    MaterielRefComponent,
    InscriptionComponent,
    UtilisateurComponent,
    AccueilComponent,
    VoyageurComponent,


  ],

  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,

    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { 

}
