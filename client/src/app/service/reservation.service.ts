import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {environment} from '../../environments/environment';
import { Observable } from 'rxjs';
import { Reservation } from '../model/Reservation';

@Injectable()
export class ReservationService {
  constructor(private http: HttpClient) {
  }

  reserveFlight(flightId: number) {
    return this.http.post(`${environment.apiUrl}/reservations`, {
      flightId: flightId
    });
  }

  getReservationsOfUser(): Observable<Reservation[]> {
    return this.http.get<Reservation[]>(`${environment.apiUrl}/reservations/user`);
  }
}