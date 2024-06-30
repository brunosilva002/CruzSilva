import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RopingProductListComponent } from './roping-product-list.component';

describe('RopingProductListComponent', () => {
  let component: RopingProductListComponent;
  let fixture: ComponentFixture<RopingProductListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RopingProductListComponent]
    });
    fixture = TestBed.createComponent(RopingProductListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
