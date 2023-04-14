import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Reservation } from '../model/Reservation';
import { ReservationService } from '../service/reservation.service';



@Component({
  selector: 'app-reservation-table',
  templateUrl: './reservation-table.component.html',
  styleUrls: ['./reservation-table.component.css']
})
export class ReservationsTableComponent implements OnInit {

  reservations: Reservation[] = [];

  constructor(
    private reservationService: ReservationService,
    private route: ActivatedRoute
  ) {}


  ngOnInit(): void {
    this.getUserReservations()
  }

  dataSource: Reservation[] = [];

  getUserReservations() {
    this.reservationService.getReservationsOfUser().subscribe({
      next: (reservationsResponse) => {
        this.reservations = reservationsResponse;
        console.log(this.reservations);
        this.dataSource = this.reservations;  
      }, 
      error: (error) => {
        console.log("error");
        console.error(error);
      }
    })
  }


  displayedColumns: string[] = ['Departure', 'Destination', 'Airline', 'Aircraft'];
}
