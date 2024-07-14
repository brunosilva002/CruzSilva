import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EntryFormListComponent } from './entry-form-list.component';

describe('EntryFormListComponent', () => {
  let component: EntryFormListComponent;
  let fixture: ComponentFixture<EntryFormListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EntryFormListComponent]
    });
    fixture = TestBed.createComponent(EntryFormListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
