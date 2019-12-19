import { Component, OnInit, Input, OnChanges, Output, EventEmitter } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

import { Booking } from '../../classes/booking';
import { BookingService } from '../../services/booking.service';
import { ScreeningService } from '../../services/screening.service';
import { Seat } from '../../classes/seat';
import { SeatService } from '../../services/seat.service';
import { RoomService } from '../../services/room.service';
import { Screening } from '../../classes/screening';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit, OnChanges {
  response: any
  seats: Seat[] = []
  availableSeats: Seat[] = []
  screening: Screening
  selectedSeats: Seat[] = []

  bookingForm = this.fb.group({
    name: ['', [Validators.required]],
    email: ['', [Validators.required, 
      Validators.pattern(/[A-Za-z0-9.aáeéiíoóöőuúüűAÁEÉIÍOÓÖŐUÚÜŰ]*[@][A-Za-z0-9.aáeéiíoóöőuúüűAÁEÉIÍOÓÖŐUÚÜŰ]*/)]],
    phone: ['', [Validators.required, Validators.pattern(/[+0-9]*/)]]
  });

  @Input() booking: Booking;
  @Input() showStatus = false;
  @Output() save = new EventEmitter<Booking>();

  get name() { return this.bookingForm.get('name'); }
  get email() { return this.bookingForm.get('email'); }
  get phone() { return this.bookingForm.get('phone'); }

  constructor(
    private fb: FormBuilder,
    private bookingService: BookingService,
    private screeningService: ScreeningService,
    private roomService: RoomService,
    private seatService: SeatService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  async ngOnInit() {
    this.screening = await this.screeningService.getScreening(+this.route.snapshot.paramMap.get('id'))
    this.getSeats()
  }

  ngOnChanges() {
    this.bookingForm.patchValue(this.booking);
  }

  async onSubmit() {
    let booking = new Booking()
    this.save.emit(
      Object.assign(booking, this.bookingForm.value)
    );
    booking.screening = this.screening
    let booked: any = "BOOKED"
    
    this.response = await this.bookingService.addBooking(booking)
    this.selectedSeats.forEach(async seat => {
      seat.status = booked
      let getBooking = await this.bookingService.getBookingByName(booking.name)
      seat.booking = getBooking[0]
      let seatResponse = await this.seatService.modifySeat(seat.id, seat)
    });
    if (this.response) {
      this.router.navigateByUrl('/success');
    } 
  }

  async getSeats() {
    this.seats = await this.roomService.getSeats(this.screening.room.id)
    let free = "FREE"
    this.seats.forEach(seat => {
      if (seat.status == free) {
        this.availableSeats.push(seat)
      }
    });
  }

  selectSeat(seat: Seat) {
    this.selectedSeats.push(seat)
    const index: number = this.availableSeats.indexOf(seat);
    if (index !== -1) {
        this.availableSeats.splice(index, 1);
    }       
  }

  deleteSeat(seat: Seat) {
    this.availableSeats.push(seat)
    this.availableSeats.sort((a: any, b: any) => a.id - b.id)
    const index: number = this.selectedSeats.indexOf(seat);
    if (index !== -1) {
        this.selectedSeats.splice(index, 1);
    }       
  }
}
