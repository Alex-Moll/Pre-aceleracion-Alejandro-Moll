package com.disney.demo.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table( name = "characters")
@SQLDelete(sql = "UPDATE Personaje SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class Character implements Serializable{
    
    @Id
    @GeneratedValue(generator = "uuid")
//    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    private String imagen;
    
    private String nombre;
    
//    @Column(name = "fecha_nacimeinto")
//    @DateTimeFormat(pattern = "yyyy/MM/dd") // formato y patron de la fecha
    private int edad;
    
    private double peso;
    
    private String historia;
    
    @ManyToMany(mappedBy = "personajes", cascade = CascadeType.PERSIST)
    private List<Movie> peliculas = new ArrayList<>();
    
//    @Column(name = "pelicula_id")
//    private String peliculaId;
    
    private boolean deleted = Boolean.FALSE; 
        
}