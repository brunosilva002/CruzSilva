import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AutoCompleteDivisionComponent } from './auto-complete-division.component';

describe('AutoCompleteDivisionComponent', () => {
  let component: AutoCompleteDivisionComponent;
  let fixture: ComponentFixture<AutoCompleteDivisionComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AutoCompleteDivisionComponent]
    });
    fixture = TestBed.createComponent(AutoCompleteDivisionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
