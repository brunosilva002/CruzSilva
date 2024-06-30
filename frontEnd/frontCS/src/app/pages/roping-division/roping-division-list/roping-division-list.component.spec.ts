import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RopingDivisionListComponent } from './roping-division-list.component';

describe('RopingDivisionListComponent', () => {
  let component: RopingDivisionListComponent;
  let fixture: ComponentFixture<RopingDivisionListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RopingDivisionListComponent]
    });
    fixture = TestBed.createComponent(RopingDivisionListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
