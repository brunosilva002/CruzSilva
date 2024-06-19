import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RopingDivisionComponent } from './roping-division.component';

describe('RopingDivisionComponent', () => {
  let component: RopingDivisionComponent;
  let fixture: ComponentFixture<RopingDivisionComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RopingDivisionComponent]
    });
    fixture = TestBed.createComponent(RopingDivisionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
