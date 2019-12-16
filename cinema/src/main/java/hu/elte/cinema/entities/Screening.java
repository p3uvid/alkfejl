/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.cinema.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
public class Screening extends BaseEntity {
    @JoinColumn()
    @ManyToOne(targetEntity = Movie.class) //egy filmhez tobb eloadas is tartozhat (eloadas a many, film a one?)
    private Movie movie;
    
    @Column(nullable = false)
    private LocalDateTime screening_time;
    
    @JoinColumn()
    @ManyToOne(targetEntity = Room.class) //több előadás lehet ugyanabban a teremben
    private Room room;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "screenings") //egy előadást több alkalmazott is módosíthat
    private List<Employee> employees; //ez az amit mi employee_id-nak irtunk
    
    @JsonIgnore
    @OneToMany(mappedBy = "screening") //egy előadásra több jegyet is lehet foglalni
    private List<Booking> bookings;
}
