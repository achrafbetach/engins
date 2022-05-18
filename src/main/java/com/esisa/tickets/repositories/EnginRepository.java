package com.esisa.tickets.repositories;

import com.esisa.tickets.models.Engin;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnginRepository extends MongoRepository<Engin, String> {
    
}
