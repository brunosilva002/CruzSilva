import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalEditChampionshipStagesComponent } from './modal-edit-championship-stages.component';

describe('ModalEditChampionshipStagesComponent', () => {
  let component: ModalEditChampionshipStagesComponent;
  let fixture: ComponentFixture<ModalEditChampionshipStagesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ModalEditChampionshipStagesComponent]
    });
    fixture = TestBed.createComponent(ModalEditChampionshipStagesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
