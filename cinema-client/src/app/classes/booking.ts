import { Screening } from './screening'
import { Seat } from './seat'

export class Booking {
    id: null
    email: ''
    name: ''
    phone: ''
    screening: Screening
    seats: Seat[]
}
