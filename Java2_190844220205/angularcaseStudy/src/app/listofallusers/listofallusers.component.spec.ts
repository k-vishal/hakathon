import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListofallusersComponent } from './listofallusers.component';

describe('ListofallusersComponent', () => {
  let component: ListofallusersComponent;
  let fixture: ComponentFixture<ListofallusersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListofallusersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListofallusersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
