package com.esisa.engins.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.esisa.engins.models.Engin;
import com.esisa.engins.repositories.EnginRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/engin")
class resourceNameController {

    @Autowired
    EnginRepository enginRepository;

    @GetMapping
    public ResponseEntity<List<Engin>> getAll() {
        try {
            List<Engin> items = new ArrayList<Engin>();

            enginRepository.findAll().forEach(items::add);

            if (items.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Engin> getById(@PathVariable("id") String id) {
        Optional<Engin> existingItemOptional = enginRepository.findById(id);
        if (existingItemOptional.isPresent()) {
            return new ResponseEntity<>(existingItemOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Engin> create(@RequestBody Engin item) {
        try {
            Engin savedItem = enginRepository.save(item);
            return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Engin> update(@PathVariable("id") String id, @RequestBody Engin item) {
        Optional<Engin> existingItemOptional = enginRepository.findById(id);
        if (existingItemOptional.isPresent()) {
            Engin existingItem = existingItemOptional.get();
           
            if (item.getMarque() != null) existingItem.setMarque(item.getMarque());
            if (item.getMarque() != null) existingItem.setModel(item.getModel());
            if (item.getDateCirculation() != null) existingItem.setDateCirculation(item.getDateCirculation());
            if (item.getIdChauffeur() != null) existingItem.setIdChauffeur(item.getIdChauffeur());
            
            return new ResponseEntity<>(enginRepository.save(existingItem), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") String id) {
        try {
            enginRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}