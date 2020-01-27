import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TakepaymentComponent } from './takepayment.component';

describe('TakepaymentComponent', () => {
  let component: TakepaymentComponent;
  let fixture: ComponentFixture<TakepaymentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TakepaymentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TakepaymentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
