import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddnewcopyComponent } from './addnewcopy.component';

describe('AddnewcopyComponent', () => {
  let component: AddnewcopyComponent;
  let fixture: ComponentFixture<AddnewcopyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddnewcopyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddnewcopyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
