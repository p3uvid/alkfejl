/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.cinema.repositories;

import hu.elte.cinema.entities.Movie;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author p3uvid
 */
public interface MovieRepository extends CrudRepository<Movie, Long> {
    
}
