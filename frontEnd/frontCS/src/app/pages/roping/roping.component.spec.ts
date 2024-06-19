import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RopingComponent } from './roping.component';

describe('RopingComponent', () => {
  let component: RopingComponent;
  let fixture: ComponentFixture<RopingComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RopingComponent]
    });
    fixture = TestBed.createComponent(RopingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
