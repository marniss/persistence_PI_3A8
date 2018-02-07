/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.sql.Date;

/**
 *
 * @author houssem
 */
public class animal {
    
    private String nom;
private String type ;
private  String race;
private Date date_n;
private int id_m;
private int id_f_dressage;
private int id_f_soin ;

    public animal() {
    }

    public animal(String nom, String type, String race, Date date_n, int id_m, int id_f_dressage, int id_f_soin) {
        this.nom = nom;
        this.type = type;
        this.race = race;
        this.date_n = date_n;
        this.id_m = id_m;
        this.id_f_dressage = id_f_dressage;
        this.id_f_soin = id_f_soin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Date getDate_n() {
        return date_n;
    }

    public void setDate_n(Date date_n) {
        this.date_n = date_n;
    }

    public int getId_m() {
        return id_m;
    }

    public void setId_m(int id_m) {
        this.id_m = id_m;
    }

    public int getId_f_dressage() {
        return id_f_dressage;
    }

    public void setId_f_dressage(int id_f_dressage) {
        this.id_f_dressage = id_f_dressage;
    }

    public int getId_f_soin() {
        return id_f_soin;
    }

    public void setId_f_soin(int id_f_soin) {
        this.id_f_soin = id_f_soin;
    }


    
}
