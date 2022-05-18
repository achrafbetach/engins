package com.esisa.engins.repositories;

import com.esisa.engins.models.Engin;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnginRepository extends MongoRepository<Engin, String> {
    
}
