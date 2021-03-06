package com.disney.demo.repository;

import com.disney.demo.entity.MovieEntity;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Long>{
    
    public List<MovieEntity> findAll(Specification<MovieEntity> spec);
    
}
