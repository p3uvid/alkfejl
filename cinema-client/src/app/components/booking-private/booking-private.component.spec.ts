import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BookingPrivateComponent } from './booking-private.component';

describe('BookingPrivateComponent', () => {
  let component: BookingPrivateComponent;
  let fixture: ComponentFixture<BookingPrivateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BookingPrivateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BookingPrivateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
