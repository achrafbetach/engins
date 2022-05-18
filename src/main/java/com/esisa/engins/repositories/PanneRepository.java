package com.esisa.engins.repositories;

import com.esisa.engins.models.Panne;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanneRepository extends MongoRepository<Panne, String> {
    
}
