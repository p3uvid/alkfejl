/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.cinema.controllers;

import hu.elte.cinema.entities.Room;
import hu.elte.cinema.entities.Screening;
import hu.elte.cinema.entities.Seat;
import hu.elte.cinema.repositories.RoomRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author p3uvid
 */

@CrossOrigin
@RestController
@RequestMapping("room")
public class RoomController {
    @Autowired
    private RoomRepository roomRepository;
    
    @GetMapping("") //összes terem listázása
    public ResponseEntity<Iterable<Room>> getAll(){
        return new ResponseEntity(roomRepository.findAll(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}") //terem lekérése id alapján
    public ResponseEntity<Room> get(@PathVariable Long id){
       Optional<Room> room = roomRepository.findById(id);
        if (!room.isPresent()) {
            return ResponseEntity.notFound().build();
        } 
        return ResponseEntity.ok(room.get());
    }
    
    @GetMapping("/{id}/seats") //teremhez tartozó székek id alapján
    public ResponseEntity<Iterable<Seat>> seats(@PathVariable Long id) {
        Optional<Room> room = roomRepository.findById(id);
        if (!room.isPresent()) {
            return ResponseEntity.notFound().build();
        } 
        return ResponseEntity.ok(room.get().getSeats());
    }
    
    @GetMapping("/{id}/screenings") //teremhez tartozó előadások id alapján
    public ResponseEntity<Iterable<Screening>> screenings(@PathVariable Long id) {
        Optional<Room> room = roomRepository.findById(id);
        if (!room.isPresent()) {
            return ResponseEntity.notFound().build();
        } 
        return ResponseEntity.ok(room.get().getScreenings());
    }
}
