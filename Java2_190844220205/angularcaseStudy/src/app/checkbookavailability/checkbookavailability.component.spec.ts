import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckbookavailabilityComponent } from './checkbookavailability.component';

describe('CheckbookavailabilityComponent', () => {
  let component: CheckbookavailabilityComponent;
  let fixture: ComponentFixture<CheckbookavailabilityComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CheckbookavailabilityComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CheckbookavailabilityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
