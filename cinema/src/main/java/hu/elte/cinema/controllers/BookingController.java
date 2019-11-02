/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.cinema.controllers;

import hu.elte.cinema.entities.Booking;
import hu.elte.cinema.entities.Seat;
import hu.elte.cinema.repositories.BookingRepository;
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
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author p3uvid
 */

@CrossOrigin
@RestController
@RequestMapping("booking")
public class BookingController {
    @Autowired
    private BookingRepository bookingRepository;
    
    @GetMapping("") //összes foglalás listázás
    public ResponseEntity<Iterable<Booking>> getAll(){
        return new ResponseEntity(bookingRepository.findAll(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}") //foglalás lekérése id alapján
    public ResponseEntity<Booking> get(@PathVariable Long id){
       Optional<Booking> booking = bookingRepository.findById(id);
        if (!booking.isPresent()) {
            return ResponseEntity.notFound().build();
        } 
        return ResponseEntity.ok(booking.get());
    }
    
    @GetMapping("/{name}") //foglalás lekérése név alapján - ez itt nem biztos, hogy így jó
    public ResponseEntity<Booking> getAllBookingByName(@PathVariable String name){
        return new ResponseEntity(bookingRepository.findAllByName(name), HttpStatus.OK);
    }
    
    @GetMapping("/{id}/seats") //jegyfoglaláshoz tartozó székek id alapján
    public ResponseEntity<Iterable<Seat>> seats(@PathVariable Long id) {
        Optional<Booking> booking = bookingRepository.findById(id);
        if (!booking.isPresent()) {
            return ResponseEntity.notFound().build();
        } 
        return ResponseEntity.ok(booking.get().getSeats());
    }
    
    @GetMapping("/{name}/seats") //jegyfoglaláshoz tartozó székek név alapján
    public ResponseEntity<Iterable<Seat>> seats(@PathVariable String name) {
        Optional<Booking> booking = bookingRepository.findByName(name);
        if (!booking.isPresent()) {
            return ResponseEntity.notFound().build();
        } 
        return ResponseEntity.ok(booking.get().getSeats());
    }
    
    @PostMapping("") //új jegyfoglalás hozzáadása
    public ResponseEntity<Booking> post(@RequestBody Booking booking) {
        return ResponseEntity.ok(bookingRepository.save(booking));
    }
    
    @DeleteMapping("/{id}") //jegyfoglalás törlése id alapján
    public ResponseEntity<Booking> delete(@PathVariable Long id) {
        Optional<Booking> issue = bookingRepository.findById(id);
        if (!issue.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        bookingRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
