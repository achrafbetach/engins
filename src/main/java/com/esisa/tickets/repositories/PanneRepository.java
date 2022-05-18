package com.esisa.tickets.repositories;

import com.esisa.tickets.models.Panne;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanneRepository extends MongoRepository<Panne, String> {
    
}
