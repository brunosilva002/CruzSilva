import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AutoCompleteGenderComponent } from './auto-complete-gender.component';

describe('AutoCompleteGenderComponent', () => {
  let component: AutoCompleteGenderComponent;
  let fixture: ComponentFixture<AutoCompleteGenderComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AutoCompleteGenderComponent]
    });
    fixture = TestBed.createComponent(AutoCompleteGenderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
