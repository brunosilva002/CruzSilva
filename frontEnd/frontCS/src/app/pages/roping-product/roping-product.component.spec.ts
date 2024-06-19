import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RopingProductComponent } from './roping-product.component';

describe('RopingProductComponent', () => {
  let component: RopingProductComponent;
  let fixture: ComponentFixture<RopingProductComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RopingProductComponent]
    });
    fixture = TestBed.createComponent(RopingProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
