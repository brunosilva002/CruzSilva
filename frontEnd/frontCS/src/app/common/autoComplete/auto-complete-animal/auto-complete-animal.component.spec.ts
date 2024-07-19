import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AutoCompleteAnimalComponent } from './auto-complete-animal.component';

describe('AutoCompleteAnimalComponent', () => {
  let component: AutoCompleteAnimalComponent;
  let fixture: ComponentFixture<AutoCompleteAnimalComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AutoCompleteAnimalComponent]
    });
    fixture = TestBed.createComponent(AutoCompleteAnimalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
