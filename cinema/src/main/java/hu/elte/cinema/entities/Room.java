/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.cinema.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Room extends BaseEntity {
    @Column(nullable = false)
    private String name;
    
    @JsonIgnore
    @OneToMany(mappedBy = "room")
    private List<Screening> screenings;
    
    @JsonIgnore
    @OneToMany(mappedBy = "room")
    private List<Seat> seats;
}
