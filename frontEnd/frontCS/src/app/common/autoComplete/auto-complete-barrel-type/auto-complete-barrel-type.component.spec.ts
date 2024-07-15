import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AutoCompleteBarrelTypeComponent } from './auto-complete-barrel-type.component';

describe('AutoCompleteBarrelTypeComponent', () => {
  let component: AutoCompleteBarrelTypeComponent;
  let fixture: ComponentFixture<AutoCompleteBarrelTypeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AutoCompleteBarrelTypeComponent]
    });
    fixture = TestBed.createComponent(AutoCompleteBarrelTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
