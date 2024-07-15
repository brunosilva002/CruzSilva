import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AutoCompleteTypeClassificationComponent } from './auto-complete-type-classification.component';

describe('AutoCompleteTypeClassificationComponent', () => {
  let component: AutoCompleteTypeClassificationComponent;
  let fixture: ComponentFixture<AutoCompleteTypeClassificationComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AutoCompleteTypeClassificationComponent]
    });
    fixture = TestBed.createComponent(AutoCompleteTypeClassificationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
