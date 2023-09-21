/*import { Component } from '@angular/core';
import { VoyageurService } from './voyageur.service';
import { Voyageur } from '../model';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-voyageur',
  templateUrl: './voyageur.component.html',
  styleUrls: ['./voyageur.component.scss']
})
export class VoyageurComponent {

  voyageurs$: Observable<Voyageur[]>;

  voyageurForm: Voyageur = null;

  constructor(private voyageurService: VoyageurService) {

  }
  ngOnInit(): void {
    this.voyageurs$ = this.voyageurService.findAll();
  }

  list(): Array<Voyageur> {
    return this.voyageurService.findAll();
  }

  add() {
    this.voyageurForm = new Voyageur();
  }

  edit(id: number) {
    this.voyageurService.findById(id).subscribe(resp => {
      this.voyageurForm = resp;
    });
  }

  save() {
    this.voyageurService.save(this.voyageurForm).subscribe(resp => {
      this.voyageurs$ = this.voyageurService.findAll();
    });
  }

  cancel() {
    this.voyageurForm = null;
  }

  remove(id: number) {
    this.voyageurService.deleteById(id).subscribe(resp => {
      this.voyageurs$ = this.voyageurService.findAll();
    });
  }
}


}
*/