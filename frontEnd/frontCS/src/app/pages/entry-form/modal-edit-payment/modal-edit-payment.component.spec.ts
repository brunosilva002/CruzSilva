import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalEditPaymentComponent } from './modal-edit-payment.component';

describe('ModalEditPaymentComponent', () => {
  let component: ModalEditPaymentComponent;
  let fixture: ComponentFixture<ModalEditPaymentComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ModalEditPaymentComponent]
    });
    fixture = TestBed.createComponent(ModalEditPaymentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
