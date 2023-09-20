import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConnexionComponent } from './connexion/connexion.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { UtilisateurComponent } from './utilisateur/utilisateur.component';


const routes: Routes = [
  {path: "utilisateur", component: UtilisateurComponent },
  {path: "inscription", component: InscriptionComponent},
  // {path: "voyage", component: VoyageComponent},
  // {path: "voyageur", component: VoyageurComponent},
  // {path: "materielRef", component: MaterielRefComponent},
   // {path: "critere", component: CritereComponent},
  {path: "connexion", component: ConnexionComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
