import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AutoCompleteTypeClassificationTimeComponent } from './auto-complete-type-classification-time.component';

describe('AutoCompleteTypeClassificationTimeComponent', () => {
  let component: AutoCompleteTypeClassificationTimeComponent;
  let fixture: ComponentFixture<AutoCompleteTypeClassificationTimeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AutoCompleteTypeClassificationTimeComponent]
    });
    fixture = TestBed.createComponent(AutoCompleteTypeClassificationTimeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
