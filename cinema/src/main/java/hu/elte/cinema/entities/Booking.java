/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.cinema.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
public class Booking extends BaseEntity {
    //előadás_id
    @JoinColumn(updatable = false)
    @ManyToOne(targetEntity = Screening.class) //egy előadásra több jegyet is lehet foglalni
    private Screening screening;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String phone;
    
    //szék_id melyik széket foglalta le -> ebből tudjuk, hogy az melyik teremben van (székhez tartozik terem_id)
    @JsonIgnore
    @OneToMany(mappedBy = "booking") //egy foglaláshoz több szék is tartozhat
    private List<Seat> seats;
}
