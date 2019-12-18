/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.cinema.controllers;

import hu.elte.cinema.entities.Seat;
import hu.elte.cinema.repositories.SeatRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author p3uvid
 */

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("seat")
public class SeatController {
    @Autowired
    private SeatRepository seatRepository;
    
    @GetMapping("/{id}") //szék lekérése id alapján
    public ResponseEntity<Seat> get(@PathVariable Long id){
       Optional<Seat> seat = seatRepository.findById(id);
        if (!seat.isPresent()) {
            return ResponseEntity.notFound().build();
        } 
        return ResponseEntity.ok(seat.get());
    }
    
    @PutMapping("/{id}") //status módosítására oké + null-ra állítható a booking
    public ResponseEntity<Seat> update(@PathVariable Long id, @RequestBody Seat seat) {
        Optional<Seat> oseat = seatRepository.findById(id);
        if (oseat.isPresent()) {
            seat.setId(id);
            return ResponseEntity.ok(seatRepository.save(seat));
        }
        return ResponseEntity.notFound().build();
    }
}
