package com.disney.demo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Data
@Entity
@Table( name = "characters")
@SQLDelete(sql = "UPDATE Characters SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class CharacterEntity implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    
    private String image;
    
    private String name;
    
    private int age;
    
    private double weigth;
    
    private String history;
    
    @ManyToMany(mappedBy = "characters", 
                cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<MovieEntity> movies = new ArrayList<>();
    
//    @Column(name = "pelicula_id")
//    private String peliculaId;
    
    private boolean deleted = Boolean.FALSE; 
        
}
