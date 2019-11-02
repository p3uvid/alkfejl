/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.cinema.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author p3uvid
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Seat extends BaseEntity {
    @Column(nullable = false)
    private Integer number;
    
    @JoinColumn(updatable = false)
    @ManyToOne(targetEntity = Room.class) //több szék lehet ugyanabban a teremben
    private Room room;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;
    
    @JoinColumn(updatable = true, nullable = true)
    @ManyToOne(targetEntity = Booking.class) //egy foglaláshoz több szék is tartozhat
    private Booking booking;
}
