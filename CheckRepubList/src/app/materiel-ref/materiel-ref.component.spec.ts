import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MaterielRefComponent } from './materiel-ref.component';

describe('MaterielRefComponent', () => {
  let component: MaterielRefComponent;
  let fixture: ComponentFixture<MaterielRefComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MaterielRefComponent]
    });
    fixture = TestBed.createComponent(MaterielRefComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
