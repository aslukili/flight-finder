import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {ReservationsTableComponent} from './reservation-table.component';

describe('TicketTableComponent', () => {
  let component: ReservationsTableComponent;
  let fixture: ComponentFixture<ReservationsTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ReservationsTableComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReservationsTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
