import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListofissuedbookComponent } from './listofissuedbook.component';

describe('ListofissuedbookComponent', () => {
  let component: ListofissuedbookComponent;
  let fixture: ComponentFixture<ListofissuedbookComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListofissuedbookComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListofissuedbookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
