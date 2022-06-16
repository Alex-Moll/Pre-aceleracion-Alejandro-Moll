package com.disney.demo.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class PersonajeDto {
    
    private String id;
    private String imagen;
    private String nombre;
    private String fechaNac;
    private double peso;
    private String historia;
    private List<PeliculaDto> peliculas = new ArrayList<>();
    private String peliculaId;

}
