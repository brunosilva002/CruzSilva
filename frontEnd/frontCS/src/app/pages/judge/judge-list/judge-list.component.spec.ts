import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JudgeListComponent } from './judge-list.component';

describe('JudgeListComponent', () => {
  let component: JudgeListComponent;
  let fixture: ComponentFixture<JudgeListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [JudgeListComponent]
    });
    fixture = TestBed.createComponent(JudgeListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
