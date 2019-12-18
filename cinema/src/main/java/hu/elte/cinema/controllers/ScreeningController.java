/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.cinema.controllers;

import hu.elte.cinema.entities.Movie;
import hu.elte.cinema.entities.Room;
import hu.elte.cinema.entities.Screening;
import hu.elte.cinema.repositories.MovieRepository;
import hu.elte.cinema.repositories.RoomRepository;
import hu.elte.cinema.repositories.ScreeningRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Dóri
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("screening")
public class ScreeningController {
    
    @Autowired
    private ScreeningRepository screeningRepository;
    
    @Autowired
    private MovieRepository movieRepository;
    
    @Autowired
    private RoomRepository roomRepository;
    
    @GetMapping("") //összes előadás listázása
    public ResponseEntity<Iterable<Screening>> getAll(){
        return new ResponseEntity(screeningRepository.findAll(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Screening> get(@PathVariable Long id){
       Optional<Screening> screening = screeningRepository.findById(id);
        if (!screening.isPresent()) {
            return ResponseEntity.notFound().build();
        } 
        return ResponseEntity.ok(screening.get());
    }
    
    @PostMapping("")
    @ResponseBody
    public ResponseEntity post(@RequestBody Screening screening) {
        Screening newScreening = new Screening();
        Optional<Movie> movie = movieRepository.findById(screening.getMovie().getId());
        Optional<Room> room = roomRepository.findById(screening.getRoom().getId());
        
        newScreening.setScreening_time(screening.getScreening_time());
        newScreening.setMovie(movie.get());
        newScreening.setRoom(room.get());

        return ResponseEntity.ok(screeningRepository.save(newScreening));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Screening> update(@PathVariable Long id, @RequestBody Screening screening) {
        Optional<Screening> oScreening = screeningRepository.findById(id);
        if (oScreening.isPresent()) {
            screening.setId(id);
            return ResponseEntity.ok(screeningRepository.save(screening));
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Screening> delete(@PathVariable Long id) {
        Optional<Screening> screening = screeningRepository.findById(id);
        if (!screening.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        screeningRepository.delete(screening.get());
        return ResponseEntity.ok().build();
    }
}
