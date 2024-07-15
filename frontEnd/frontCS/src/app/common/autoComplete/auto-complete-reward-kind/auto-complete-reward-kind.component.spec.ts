import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AutoCompleteRewardKindComponent } from './auto-complete-reward-kind.component';

describe('AutoCompleteRewardKindComponent', () => {
  let component: AutoCompleteRewardKindComponent;
  let fixture: ComponentFixture<AutoCompleteRewardKindComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AutoCompleteRewardKindComponent]
    });
    fixture = TestBed.createComponent(AutoCompleteRewardKindComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
