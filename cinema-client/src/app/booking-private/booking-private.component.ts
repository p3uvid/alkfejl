import { Component, OnInit, Input, OnChanges, Output, EventEmitter } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { BookingService } from '../booking.service';
import { Booking } from '../booking';
import { Seat } from '../seat';

@Component({
  selector: 'app-booking-private',
  templateUrl: './booking-private.component.html',
  styleUrls: ['./booking-private.component.css']
})
export class BookingPrivateComponent implements OnInit, OnChanges {
  booking: Booking = null
  seats: Seat[] = []

  bookingForm = this.fb.group({
    name: [''],
    id: ['']
  });

  @Input() data: any = {}
  @Output() save = new EventEmitter();

  get name() { return this.bookingForm.get('name'); }
  get id() { return this.bookingForm.get('id'); }

  constructor(
    private fb: FormBuilder,
    private bookingService: BookingService
  ) { }

  async ngOnInit() {
    this.bookingForm.patchValue(this.data);
  }

  ngOnChanges() {
  }

  async onSubmit() {
    this.save.emit(
      this.data = this.bookingForm.value
    );
    console.log(this.data)
    if (this.data.id != "") {
      this.booking =  await this.bookingService.getBookingById(this.id.value)
      this.seats = await this.bookingService.getSeatsOfBookingById(this.booking.id)
      console.log(this.seats)
    } else if (this.data.name != "") {
      this.booking = await this.bookingService.getBookingByName(this.name.value)
      this.booking = this.booking[0]
      if (this.booking) {
        this.seats = await this.bookingService.getSeatsOfBookingByName(this.booking.name)
      }
    }
  }
}
