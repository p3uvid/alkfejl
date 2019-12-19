import { Component, OnInit, Input, OnChanges, Output, EventEmitter } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { BookingService } from '../../services/booking.service';
import { Booking } from '../../classes/booking';
import { Seat } from '../../classes/seat';

@Component({
  selector: 'app-components-booking-private',
  templateUrl: './booking-private.component.html',
  styleUrls: ['./booking-private.component.css']
})
export class BookingPrivateComponent implements OnInit, OnChanges {
  booking: Booking = null
  seats: Seat[] = []
  errorMessage = ' '

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
    this.booking = null
    if (this.data.id != "") {
      try {
        this.booking =  await this.bookingService.getBookingById(this.id.value)
        this.seats = await this.bookingService.getSeatsOfBookingById(this.booking.id)
        this.errorMessage = ' '
      } catch (e) {
        //id not exists
        this.errorMessage = 'Nem létezik foglalás ilyen névvel vagy id-val'
      }
    } else if (this.data.name != "") {
      try {
        this.booking = await this.bookingService.getBookingByName(this.name.value)
        this.booking = this.booking[0]
        if (this.booking) {
          this.seats = await this.bookingService.getSeatsOfBookingByName(this.booking.name)
          this.errorMessage = ' '
        } else {
          this.errorMessage = 'Nem létezik foglalás ilyen névvel vagy id-val'
        }
      } catch (e) {
      }
    }
  }

  async deleteBooking() {
    await this.bookingService.deleteBooking(this.booking.id)
    this.booking = null
  }
}
