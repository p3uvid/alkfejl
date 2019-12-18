import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Seat } from './seat';
import { httpOptions } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class SeatService {
  private seatUrl = 'http://localhost:8080/seat';

  constructor(
    private http: HttpClient
  ) { }

  getSeat(id: number): Promise<Seat> {
    return this.http.get<Seat>(
      `${this.seatUrl}/${id}`,
      httpOptions
    ).toPromise();
  }

  modifySeat(id: number, seat: Seat): Promise<Seat> {
    return this.http.put<Seat>(
      `${this.seatUrl}/${id}`,
      seat,
      httpOptions
    ).toPromise();
  }
}
