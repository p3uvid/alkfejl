/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.cinema.repositories;

import hu.elte.cinema.entities.Booking;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author p3uvid
 */

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long>{
    List<Booking> findAllByName(String name);
    Optional<Booking> findByName(String name);
}
