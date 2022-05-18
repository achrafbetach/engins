package com.esisa.tickets.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Engin {
    
    @Id
    private String id;
    @Field
    private String marque;
    @Field
    private String model;
    @Field
    private String matricule;
    @Field
    private String dateCirculation;
    @Field
    private String idChauffeur;
    
    public Engin(String marque, String model, String matricule, String dateCirculation, String idChauffeur) {
        this.marque = marque;
        this.model = model;
        this.matricule = matricule;
        this.dateCirculation = dateCirculation;
        this.idChauffeur = idChauffeur;
    }

    public String getId() {
        return id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getDateCirculation() {
        return dateCirculation;
    }

    public void setDateCirculation(String dateCirculation) {
        this.dateCirculation = dateCirculation;
    }

    public String getIdChauffeur() {
        return idChauffeur;
    }

    public void setIdChauffeur(String idChauffeur) {
        this.idChauffeur = idChauffeur;
    }


    public String toString() {
        return "[dateCirculation:" + dateCirculation + ", id:" + id + ", idChauffeur:" + idChauffeur + ", marque:"
                + marque + ", matricule:" + matricule + ", model:" + model + "]";
    }

    
    

}
