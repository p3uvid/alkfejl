/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.cinema.controllers;

import hu.elte.cinema.entities.Screening;
import hu.elte.cinema.repositories.ScreeningRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Dóri
 */
public class ScreeningController {
    
    @Autowired
    private ScreeningRepository screeningRepository;
    
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
    public ResponseEntity<Screening> post(@RequestBody Screening screening) {
        return ResponseEntity.ok(screeningRepository.save(screening));
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
