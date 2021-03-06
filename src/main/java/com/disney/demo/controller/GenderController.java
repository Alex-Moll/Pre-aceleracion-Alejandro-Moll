package com.disney.demo.controller;

import com.disney.demo.dto.GenderDto;
import com.disney.demo.mapper.GenderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import com.disney.demo.service.GenderService;

@RestController
@RequestMapping("genders")
public class GenderController {
    
    @Autowired
    private GenderService generoService;
    
    @Autowired
    private GenderMapper generoMapper;
    
    @PostMapping()
    public ResponseEntity<GenderDto> save(@Valid @RequestBody GenderDto dto){
        System.out.println("\nentro a generos/save");
        GenderDto dtoGuardado = generoService.saveDto(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dtoGuardado);      
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<GenderDto> find(@Valid @PathVariable Long id){
        System.out.println("\nentro a generos/find/id");
        GenderDto dto = generoService.find(id);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    
    @GetMapping()
    public ResponseEntity<List<GenderDto>> findAll(){
        System.out.println("\nentro a generos/findAll");
        List<GenderDto> listDto = generoService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listDto);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id){
        System.out.println("\nentro a generos/delete/id");
        this.generoService.delete(id);
        System.out.println("llego a borrar");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<GenderDto> update(@PathVariable long id){
        System.out.println("\nentro a generos/update/id");
        GenderDto dto = generoService.find(id);
        GenderDto generoGuardado = generoService.saveDto(dto);
        return ResponseEntity.status(HttpStatus.OK).body(generoGuardado); 
    }
   
}
