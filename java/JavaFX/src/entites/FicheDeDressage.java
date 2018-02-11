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
public class FicheDeDressage {

    private int id_f_Dressage;
    private int id_membre;
    private String espece;
    private String nom;
    private float poids;
    private String proprietaire;
    private String specialite;
    private String photo;
    private float displine;
    private float obeissance;
    private float accompagnement;
    private float interception;
    private float noteTotal;
    private Date dateDebut;
    private Date dateFin;

    public FicheDeDressage() {
    }

    public FicheDeDressage(int id_f_Dressage, int id_membre, String espece, String nom, float poids, String proprietaire, String specialite, String photo, float displine, float obeissance, float accompagnement, float interception, float noteTotal, Date dateDebut, Date dateFin) {
        this.id_f_Dressage = id_f_Dressage;
        this.id_membre = id_membre;
        this.espece = espece;
        this.nom = nom;
        this.poids = poids;
        this.proprietaire = proprietaire;
        this.specialite = specialite;
        this.photo = photo;
        this.displine = displine;
        this.obeissance = obeissance;
        this.accompagnement = accompagnement;
        this.interception = interception;
        this.noteTotal = noteTotal;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public FicheDeDressage(int id_membre, String espece, String nom, float poids, String proprietaire, String specialite) {

        this.id_membre = id_membre;
        this.espece = espece;
        this.nom = nom;
        this.poids = poids;
        this.proprietaire = proprietaire;
        this.specialite = specialite;

    }

    public int getId_f_Dressage() {
        return id_f_Dressage;
    }

    public void setId_f_Dressage(int id_f_Dressage) {
        this.id_f_Dressage = id_f_Dressage;
    }

    public int getId_membre() {
        return id_membre;
    }

    public void setId_membre(int id_membre) {
        this.id_membre = id_membre;
    }

    public String getEspece() {
        return espece;
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public float getDispline() {
        return displine;
    }

    public void setDispline(float displine) {
        this.displine = displine;
    }

    public float getObeissance() {
        return obeissance;
    }

    public void setObeissance(float obeissance) {
        this.obeissance = obeissance;
    }

    public float getAccompagnement() {
        return accompagnement;
    }

    public void setAccompagnement(float accompagnement) {
        this.accompagnement = accompagnement;
    }

    public float getInterception() {
        return interception;
    }

    public void setInterception(float interception) {
        this.interception = interception;
    }

    public float getNoteTotal() {
        return noteTotal;
    }

    public void setNoteTotal(float noteTotal) {
        this.noteTotal = noteTotal;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public String toString() {
        return "FicheDeDressage{" + "id_f_Dressage=" + id_f_Dressage + ", id_membre=" + id_membre + ", espece=" + espece + ", nom=" + nom + ", poids=" + poids + ", proprietaire=" + proprietaire + ", specialite=" + specialite + ", photo=" + photo + ", displine=" + displine + ", obeissance=" + obeissance + ", accompagnement=" + accompagnement + ", interception=" + interception + ", noteTotal=" + noteTotal + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + '}';
    }

}
