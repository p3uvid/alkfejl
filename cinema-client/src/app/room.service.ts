import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Room } from './room';
import { Seat } from './seat';

@Injectable({
  providedIn: 'root'
})
export class RoomService {
  private roomUrl = 'http://localhost:8080/room';

  constructor(
    private http: HttpClient
  ) { }

  getRooms(): Promise<Room[]> {
    return this.http.get<Room[]>(
      this.roomUrl,
      //httpOptions
    ).toPromise();
  }

  getRoom(id: number): Promise<Room> {
    return this.http.get<Room>(
      `${this.roomUrl}/${id}`,
      //httpOptions
    ).toPromise();
  }

  getSeats(id: number): Promise<Seat[]> {
    return this.http.get<Seat[]>(
      `${this.roomUrl}/${id}/seats`
    ).toPromise();
  }
}
