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

    private int id_f_soin;
    private String description;
    private String etat;
    private Date dateVisite;
    private String medicament;
    private int id_animal;
    private int id_membre;

    public int getId_f_soin() {
        return id_f_soin;
    }

    public void setId_f_soin(int id_f_soin) {
        this.id_f_soin = id_f_soin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Date getDateVisite() {
        return dateVisite;
    }

    public void setDateVisite(Date dateVisite) {
        this.dateVisite = dateVisite;
    }

    public String getMedicament() {
        return medicament;
    }

    public void setMedicament(String medicament) {
        this.medicament = medicament;
    }

    public int getId_animal() {
        return id_animal;
    }

    public void setId_animal(int id_animal) {
        this.id_animal = id_animal;
    }

    public int getId_membre() {
        return id_membre;
    }

    public void setId_membre(int id_membre) {
        this.id_membre = id_membre;
    }

    public FicheDeSoin() {
    }

    public FicheDeSoin(int id_f_soin, String description, String etat, Date dateVisite, String medicament, int id_animal, int id_membre) {
        this.id_f_soin = id_f_soin;
        this.description = description;
        this.etat = etat;
        this.dateVisite = dateVisite;
        this.medicament = medicament;
        this.id_animal = id_animal;
        this.id_membre = id_membre;
    }

    public FicheDeSoin(String description, String etat, String medicament, int id_animal, int id_membre) {

        this.description = description;
        this.etat = etat;

        this.medicament = medicament;
        this.id_animal = id_animal;
        this.id_membre = id_membre;
    }

    @Override
    public String toString() {
        return "FicheDeSoin{" + "description=" + description + ", etat=" + etat + ", dateVisite=" + dateVisite + ", medicament=" + medicament + ", id_animal=" + id_animal + ", id_membre=" + id_membre + '}';
    }

}
