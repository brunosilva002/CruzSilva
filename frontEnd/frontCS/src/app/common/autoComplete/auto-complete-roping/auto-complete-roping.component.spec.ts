import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AutoCompleteRopingComponent } from './auto-complete-roping.component';

describe('AutoCompleteRopingComponent', () => {
  let component: AutoCompleteRopingComponent;
  let fixture: ComponentFixture<AutoCompleteRopingComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AutoCompleteRopingComponent]
    });
    fixture = TestBed.createComponent(AutoCompleteRopingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
