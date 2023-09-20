import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UtilisateurComponent } from './utilisateur/utilisateur.component';

@NgModule({
  declarations: [
    AppComponent,
    //NavBarComponent,
    //ConnexionComponent
    UtilisateurComponent
  ],
  
  imports: [
    BrowserModule,
    //AppRoutingModule,
    FormsModule,
   // HttpClientModule,
    //ReactiveFormsModule,
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { 

}
