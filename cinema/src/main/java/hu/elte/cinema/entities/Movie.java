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
public class Movie extends BaseEntity {    
    @Column(nullable = false)
    private String title;
    
    @Column(nullable = false)
    private String premier;
    
    @Column(nullable = false)
    private Integer playtime;
    
    @Column(nullable = false)
    private String description;
    
    @Column(nullable = false)
    private String genre;
    
    @Column(nullable = false)
    private String actors;
    
    @Column(nullable = false)
    private String director;
    
    @Column(nullable = false)
    private Integer age_limit;
    
    @JsonIgnore
    @OneToMany(mappedBy = "movie")
    private List<Screening> screenings;
}
