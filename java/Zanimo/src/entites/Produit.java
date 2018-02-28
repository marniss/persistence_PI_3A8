/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Ahmed
 */
public class Produit {

    //attributs
    protected int id;
    protected String nom;
    protected String description;
    protected float prix;
    protected int qteStock;
    protected String type;
    protected String photo;
    protected Date datePublication;
    protected int validitePublication;
    protected int etat;
    protected int IdMembre;
    //getters

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public float getPrix() {
        return prix;
    }

    public int getQteStock() {
        return qteStock;
    }

    public String getType() {
        return type;
    }

    public String getPhoto() {
        return photo;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public int getValiditePublication() {
        return validitePublication;
    }

    public int getEtat() {
        return etat;
    }

    public int getIdMembre() {
        return IdMembre;
    }
    //setters

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setQteStock(int qteStock) {
        this.qteStock = qteStock;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public void setValiditePublication(int validitePublication) {
        this.validitePublication = validitePublication;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public void setIdMembre(int IdMembre) {
        this.IdMembre = IdMembre;
    }

    //constructeurs
    /**
     * 1*
     */
    public Produit() {
    }

    /**
     * 2*
     */
    public Produit(int id, String nom, String description, float prix, int qteStock, String type, String photo, int validitePublication, int etat, int IdMembre) {

        this.id = id;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.qteStock = qteStock;
        this.type = type;
        this.photo = photo;
        this.datePublication = new Date();
        this.validitePublication = validitePublication;
        this.etat = etat;
        this.IdMembre = IdMembre;
    }

    public Produit(String nom, String description, float prix, int qteStock, String type, String photo, int validitePublication, int IdMembre) {

        this.id = id;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.qteStock = qteStock;
        this.type = type;
        this.photo = photo;
        this.datePublication = new Date();

        this.validitePublication = validitePublication;
        this.etat = etat;
        this.IdMembre = IdMembre;
    }

}
