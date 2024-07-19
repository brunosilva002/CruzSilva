import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AutoCompleteRopingTypeComponent } from './auto-complete-roping-type.component';

describe('AutoCompleteRopingTypeComponent', () => {
  let component: AutoCompleteRopingTypeComponent;
  let fixture: ComponentFixture<AutoCompleteRopingTypeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AutoCompleteRopingTypeComponent]
    });
    fixture = TestBed.createComponent(AutoCompleteRopingTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
