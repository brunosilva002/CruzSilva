import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RopingListComponent } from './roping-list.component';

describe('RopingListComponent', () => {
  let component: RopingListComponent;
  let fixture: ComponentFixture<RopingListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RopingListComponent]
    });
    fixture = TestBed.createComponent(RopingListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
