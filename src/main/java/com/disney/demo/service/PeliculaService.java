package com.disney.demo.service;

import com.disney.demo.dto.PeliculaDto;
import java.util.List;

public interface PeliculaService {
    
    PeliculaDto saveDto(PeliculaDto dto);
    
    PeliculaDto find(String id);
    
    List<PeliculaDto> findAll();
    
    void delete(String id);
    
}
