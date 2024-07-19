import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AutoCompleteRopingDivisionComponent } from './auto-complete-roping-division.component';

describe('AutoCompleteRopingDivisionComponent', () => {
  let component: AutoCompleteRopingDivisionComponent;
  let fixture: ComponentFixture<AutoCompleteRopingDivisionComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AutoCompleteRopingDivisionComponent]
    });
    fixture = TestBed.createComponent(AutoCompleteRopingDivisionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
