package com.disney.demo.repository;

import com.disney.demo.entity.Character;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<Character, String>, JpaSpecificationExecutor<Character>{
    
//    public List<Personaje> findByNombre();
    @Override
    List<Character> findAll(Specification<Character> spec );

}