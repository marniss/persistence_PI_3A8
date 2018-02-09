/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.util.Date;

/**
 *
 * @author makni
 */
public class FicheDeSoin {

    private int id_f_Soin;
    private int id_membre;
    private String nom;
    private String espece;
    private float poids;
    private Date datePoids;
    private Date neLe;
    private String genre;
    private String observation;
    private String photo;
    private String medicament;
    private String proprietaire;
    private String prochainRDV;

    public FicheDeSoin() {
    }

    public FicheDeSoin(int id_f_Soin, int id_membre, String nom, String espece, float poids, Date datePoids, Date neLe, String genre, String observation, String photo, String medicament, String proprietaire, String prochainRDV) {
        this.id_f_Soin = id_f_Soin;
        this.id_membre = id_membre;
        this.nom = nom;
        this.espece = espece;
        this.poids = poids;
        this.datePoids = datePoids;
        this.neLe = neLe;
        this.genre = genre;
        this.observation = observation;
        this.photo = photo;
        this.medicament = medicament;
        this.proprietaire = proprietaire;
        this.prochainRDV = prochainRDV;
    }

    public int getId_f_Soin() {
        return id_f_Soin;
    }

    public void setId_f_Soin(int id_f_Soin) {
        this.id_f_Soin = id_f_Soin;
    }

    public int getId_membre() {
        return id_membre;
    }

    public void setId_membre(int id_membre) {
        this.id_membre = id_membre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEspece() {
        return espece;
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }

    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public Date getDatePoids() {
        return datePoids;
    }

    public void setDatePoids(Date datePoids) {
        this.datePoids = datePoids;
    }

    public Date getNeLe() {
        return neLe;
    }

    public void setNeLe(Date neLe) {
        this.neLe = neLe;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getMedicament() {
        return medicament;
    }

    public void setMedicament(String medicament) {
        this.medicament = medicament;
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    public String getProchainRDV() {
        return prochainRDV;
    }

    public void setProchainRDV(String prochainRDV) {
        this.prochainRDV = prochainRDV;
    }

}
