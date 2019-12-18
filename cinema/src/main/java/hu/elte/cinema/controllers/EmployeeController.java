/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.cinema.controllers;

import hu.elte.cinema.entities.Booking;
import hu.elte.cinema.repositories.EmployeeRepository;
import hu.elte.cinema.security.AuthenticatedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author p3uvid
 */

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    
    
    @Autowired 
    private AuthenticatedUser authenticatedUser;
    
    @GetMapping("")
    public ResponseEntity<Iterable<Booking>> getAll(){
        return new ResponseEntity(employeeRepository.findAll(), HttpStatus.OK);
    }
    
    @GetMapping("logout")
    public ResponseEntity logout() {
        authenticatedUser.setEmployee(null);
        return ResponseEntity.ok(0);
    }
}
