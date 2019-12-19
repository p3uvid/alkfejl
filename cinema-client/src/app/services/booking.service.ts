import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { httpOptions } from "./auth.service";

import { Movie } from '../classes/movie';
import { Screening } from '../classes/screening';
import { Booking } from '../classes/booking';
import { Seat } from '../classes/seat';

@Injectable({
  providedIn: 'root'
})
export class BookingService {
  private bookingUrl = 'http://localhost:8080/booking';

  constructor(
    private http: HttpClient
  ) { }

  getBookings(): Promise<Booking[]> {
    return this.http.get<Booking[]>(
      this.bookingUrl,
      httpOptions
    ).toPromise();
  }

  getBookingById(id: number): Promise<Booking> {
    return this.http.get<Booking>(
      `${this.bookingUrl}/id/${id}`,
      httpOptions
    ).toPromise();
  }

  getBookingByName(name: string): Promise<Booking> {
    return this.http.get<Booking>(
      `${this.bookingUrl}/name/${name}`,
      httpOptions
    ).toPromise();
  }

  getSeatsOfBookingById(id: number): Promise<Seat[]> {
    return this.http.get<Seat[]>(
      `${this.bookingUrl}/id/${id}/seats`,
      httpOptions
    ).toPromise();
  }

  getSeatsOfBookingByName(name: string): Promise<Seat[]> {
    return this.http.get<Seat[]>(
      `${this.bookingUrl}/name/${name}/seats`,
      httpOptions
    ).toPromise();
  }

  addBooking(booking: Booking): Promise<Booking> {
    return this.http.post<Booking>(
      this.bookingUrl,
      booking,
      httpOptions
    ).toPromise();
  }

  deleteBooking(id: number): Promise<Booking> {
    return this.http.delete<Booking>(
      `${this.bookingUrl}/${id}`,
      httpOptions
    ).toPromise();
  }
}
