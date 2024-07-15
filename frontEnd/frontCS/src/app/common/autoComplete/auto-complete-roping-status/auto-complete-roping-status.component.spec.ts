import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AutoCompleteRopingStatusComponent } from './auto-complete-roping-status.component';

describe('AutoCompleteRopingStatusComponent', () => {
  let component: AutoCompleteRopingStatusComponent;
  let fixture: ComponentFixture<AutoCompleteRopingStatusComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AutoCompleteRopingStatusComponent]
    });
    fixture = TestBed.createComponent(AutoCompleteRopingStatusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
