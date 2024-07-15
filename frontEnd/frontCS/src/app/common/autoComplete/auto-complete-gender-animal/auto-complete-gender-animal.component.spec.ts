import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AutoCompleteGenderAnimalComponent } from './auto-complete-gender-animal.component';

describe('AutoCompleteGenderAnimalComponent', () => {
  let component: AutoCompleteGenderAnimalComponent;
  let fixture: ComponentFixture<AutoCompleteGenderAnimalComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AutoCompleteGenderAnimalComponent]
    });
    fixture = TestBed.createComponent(AutoCompleteGenderAnimalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
