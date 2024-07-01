import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalEditRopingDivisionRankComponent } from './modal-edit-roping-division-rank.component';

describe('ModalEditRopingDivisionRankComponent', () => {
  let component: ModalEditRopingDivisionRankComponent;
  let fixture: ComponentFixture<ModalEditRopingDivisionRankComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ModalEditRopingDivisionRankComponent]
    });
    fixture = TestBed.createComponent(ModalEditRopingDivisionRankComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
