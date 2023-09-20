import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { VoyageComponent } from './voyage/voyage.component';
import { VoyageurComponent } from './voyageur/voyageur.component';

@NgModule({
  declarations: [
    AppComponent,
    VoyageComponent,
    VoyageurComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
