package com.esisa.engins.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Panne
 */
@Document
public class Panne {
    
    @Id
    private String id;
    @Field
    private String description;
    @Field
    private String audioLink;
    @Field
    private String statut; 
    @Field
    private String localisation; 
    @Field 
    private String datePanne;
    @Field
    private String dateArriveeTechnicien;
    @Field
    private String enginId; 
    @Field
    private String technicienId;



    public Panne(String description, String audioLink, String statut, String localisation, String datePanne,
            String dateArriveeTechnicien, String enginId, String technicienId) {
        this.description = description;
        this.audioLink = audioLink;
        this.statut = statut;
        this.localisation = localisation;
        this.datePanne = datePanne;
        this.dateArriveeTechnicien = dateArriveeTechnicien;
        this.enginId = enginId;
        this.technicienId = technicienId;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAudioLink() {
        return audioLink;
    }

    public void setAudioLink(String audioLink) {
        this.audioLink = audioLink;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getEnginId() {
        return enginId;
    }

    public void setEnginId(String enginId) {
        this.enginId = enginId;
    }

    public String getTechnicienId() {
        return technicienId;
    }

    public void setTechnicienId(String technicienId) {
        this.technicienId = technicienId;
    }

    public String getDatePanne() {
        return datePanne;
    }

    public void setDatePanne(String datePanne) {
        this.datePanne = datePanne;
    }

    public String getDateArriveeTechnicien() {
        return dateArriveeTechnicien;
    }

    public void setDateArriveeTechnicien(String dateArriveeTechnicien) {
        this.dateArriveeTechnicien = dateArriveeTechnicien;
    }

    @Override
    public String toString() {
        return "[audioLink:" + audioLink + ", dateArriveeTechnicien:" + dateArriveeTechnicien + ", datePanne:"
                + datePanne + ", description:" + description + ", enginId:" + enginId + ", id:" + id + ", localisation:"
                + localisation + ", statut:" + statut + ", technicienId:" + technicienId + "]";
    }

    

    
    
}
