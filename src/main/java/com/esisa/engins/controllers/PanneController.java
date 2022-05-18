package com.esisa.engins.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.esisa.engins.models.Panne;
import com.esisa.engins.repositories.PanneRepository;

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
@RequestMapping("/panne")
public class PanneController {

    @Autowired
    PanneRepository panneRepository;

    @GetMapping
    public ResponseEntity<List<Panne>> getAll() {
        try {
            List<Panne> items = new ArrayList<Panne>();

            panneRepository.findAll().forEach(items::add);

            if (items.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Panne> getById(@PathVariable("id") String id) {
        Optional<Panne> existingItemOptional = panneRepository.findById(id);

        if (existingItemOptional.isPresent()) {
            return new ResponseEntity<>(existingItemOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Panne> create(@RequestBody Panne item) {
        try {
            Panne savedItem = panneRepository.save(item);
            return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Panne> update(@PathVariable("id") String id, @RequestBody Panne item) {
        Optional<Panne> existingItemOptional = panneRepository.findById(id);
        if (existingItemOptional.isPresent()) {
            Panne existingItem = existingItemOptional.get();
            if (item.getDescription() != null) existingItem.setDescription(item.getDescription());
            if (item.getAudioLink() != null) existingItem.setAudioLink(item.getAudioLink());
            if (item.getLocalisation() != null) existingItem.setLocalisation(item.getLocalisation());
            if (item.getStatut() != null) existingItem.setStatut(item.getStatut());
            if (item.getEnginId() != null) existingItem.setEnginId(item.getEnginId());
            if (item.getTechnicienId() != null) existingItem.setTechnicienId(item.getTechnicienId());
            if (item.getDatePanne() != null) existingItem.setDatePanne(item.getDatePanne());
            if (item.getDateArriveeTechnicien() != null) existingItem.setDateArriveeTechnicien(item.getDateArriveeTechnicien());
            
            
            return new ResponseEntity<>(panneRepository.save(existingItem), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") String id) {
        try {
            panneRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
