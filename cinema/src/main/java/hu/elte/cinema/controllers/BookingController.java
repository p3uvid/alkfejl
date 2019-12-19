/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.cinema.controllers;

import hu.elte.cinema.entities.Booking;
import hu.elte.cinema.entities.Movie;
import hu.elte.cinema.entities.Room;
import hu.elte.cinema.entities.Screening;
import hu.elte.cinema.entities.Seat;
import hu.elte.cinema.entities.Status;
import hu.elte.cinema.repositories.BookingRepository;
import hu.elte.cinema.repositories.MovieRepository;
import hu.elte.cinema.repositories.RoomRepository;
import hu.elte.cinema.repositories.ScreeningRepository;
import hu.elte.cinema.repositories.SeatRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author p3uvid
 */

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("booking")
public class BookingController {
    @Autowired
    private BookingRepository bookingRepository;
    
    @Autowired
    private ScreeningRepository screeningRepository;
    
    @Autowired
    private MovieRepository movieRepository;
    
    @Autowired
    private RoomRepository roomRepository;
    
    @GetMapping("") //összes foglalás listázás
    public ResponseEntity<Iterable<Booking>> getAll(){
        return new ResponseEntity(bookingRepository.findAll(), HttpStatus.OK);
    }
    
    @GetMapping("/id/{id}") //foglalás lekérése id alapján
    public ResponseEntity<Booking> get(@PathVariable Long id){
       Optional<Booking> booking = bookingRepository.findById(id);
        if (!booking.isPresent()) {
            return ResponseEntity.notFound().build();
        } 
        return ResponseEntity.ok(booking.get());
    }
    
    @GetMapping("/name/{name}") //foglalás lekérése név alapján - ez itt nem biztos, hogy így jó
    public ResponseEntity<Booking> getAllBookingByName(@PathVariable String name){
        return new ResponseEntity(bookingRepository.findAllByName(name), HttpStatus.OK);
    }
    
    @GetMapping("/id/{id}/seats") //jegyfoglaláshoz tartozó székek id alapján
    public ResponseEntity<Iterable<Seat>> seats(@PathVariable Long id) {
        Optional<Booking> booking = bookingRepository.findById(id);
        if (!booking.isPresent()) {
            return ResponseEntity.notFound().build();
        } 
        return ResponseEntity.ok(booking.get().getSeats());
    }
    
    @GetMapping("/name/{name}/seats") //jegyfoglaláshoz tartozó székek név alapján
    public ResponseEntity<Iterable<Seat>> seats(@PathVariable String name) {
        Optional<Booking> booking = bookingRepository.findByName(name);
        if (!booking.isPresent()) {
            return ResponseEntity.notFound().build();
        } 
        return ResponseEntity.ok(booking.get().getSeats());
    }
    
    @PostMapping("") //új jegyfoglalás hozzáadása -> ezzel már nem hozza létre mindig újra a filmet és a termet
    @ResponseBody
    public ResponseEntity post(@RequestBody Booking booking) {
        Booking newBooking = new Booking();
        Optional<Screening> screening = screeningRepository.findById(booking.getScreening().getId());
        Optional<Movie> movie = movieRepository.findById(booking.getScreening().getMovie().getId());
        Optional<Room> room = roomRepository.findById(booking.getScreening().getRoom().getId());
        
        screening.get().setMovie(movie.get());
        screening.get().setRoom(room.get());
        
        newBooking.setName(booking.getName());
        newBooking.setEmail(booking.getEmail());
        newBooking.setPhone(booking.getPhone());
        newBooking.setScreening(screening.get());

        return ResponseEntity.ok(bookingRepository.save(newBooking));
    }
    
    @DeleteMapping("/{id}") //jegyfoglalás törlése id alapján
    public ResponseEntity<Booking> delete(@PathVariable Long id) {
        Optional<Booking> booking = bookingRepository.findById(id);
        if (!booking.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        List<Seat> seats = booking.get().getSeats();
        seats.forEach((i) -> {
            i.setBooking(null); //székeknél a booking_id-t nullra állítjuk
            i.setStatus(Status.FREE);
        });
        bookingRepository.delete(booking.get());
        return ResponseEntity.ok().build();
    }
}
