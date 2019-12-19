/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.cinema.controllers;

import hu.elte.cinema.entities.Movie;
import hu.elte.cinema.entities.Screening;
import hu.elte.cinema.repositories.MovieRepository;
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
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Dóri
 */

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("movie")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;
    
    @GetMapping("")
    public ResponseEntity<Iterable<Movie>> getAll(){
        return new ResponseEntity(movieRepository.findAll(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Movie> get(@PathVariable Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (!movie.isPresent()) {
            return ResponseEntity.notFound().build();
        } 
        return ResponseEntity.ok(movie.get());        
    }
    
    @PostMapping("")
    public ResponseEntity<Movie> post(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieRepository.save(movie));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Movie> update(@PathVariable Long id, @RequestBody Movie movie) {
        Optional<Movie> oMovie = movieRepository.findById(id);
        if (oMovie.isPresent()) {
            movie.setId(id);
            return ResponseEntity.ok(movieRepository.save(movie));
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Movie> delete(@PathVariable Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (!movie.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        movieRepository.delete(movie.get());
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/{id}/screenings")
    public ResponseEntity<Iterable<Screening>> screenings(@PathVariable Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (!movie.isPresent()) {
            return ResponseEntity.notFound().build();
        } 
        return ResponseEntity.ok(movie.get().getScreenings());
    }
}
