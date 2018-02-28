/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.CentreDressage;
import java.util.ArrayList;

/**
 *
 * @author mossa
 */
public class CDController {
        private int id;  
    private  String nom;
    private  String type;
    private  String adresse;
    private  int numero;
    private  double note;
    static double SommeNote;
    static int nbreNote=0;
    CentreDressage cd;
    //constructeur non parametré
    public CDController() {
    }
    //constructeur parametré sans id
    public CDController(String nom, String type, String adresse, int numero, double note) {
        this.nom = nom;
        this.type = type;
        this.adresse = adresse;
        this.numero = numero;
        this.note = note;
    }
    //constructeur parametré avec id
    public CDController(int id, String nom, String type, String adresse, int numero, double note) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.adresse = adresse;
        this.numero = numero;
        this.note = note;
    }
    //ajouter dans la base
    public void ajouter(){
     cd = new CentreDressage(this.nom, this.type, this.adresse, this.numero, this.note);
     cd.ajouter();
    }
    //modifier dans la base
    public void modifier()
    {
    cd = new CentreDressage(this.id,this.nom, this.type, this.adresse, this.numero, this.note);
     cd.modifier();
    }
    //maj note
    public void majNote()
    { SommeNote=SommeNote+this.note;
        nbreNote++;
        this.note=SommeNote/nbreNote;
     cd = new CentreDressage(this.id,this.nom, this.type, this.adresse, this.numero, this.note);
     cd.modifier();
        System.out.println(nbreNote);
    }
    //supprimer dans la base
    public void supprimer(int id)
    {
    cd=new CentreDressage();
    cd.supprimer(id);
    }
    //selectall
    public ArrayList<CentreDressage> selectAll() 
    {    cd=new CentreDressage();
        return cd.selectAll();
    }
     //selectall pour la recherche
    public ArrayList<CentreDressage> selectAll(String word)
    {cd=new CentreDressage();
        return cd.selectAll(word);
    }
    
    //getters
    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getNumero() {
        return numero;
    }

    public double getNote() {
        return note;
    }

    public CentreDressage getCs() {
        return cd;
    }
    //setters

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public void setCs(CentreDressage cd) {
        this.cd = cd;
    }

    
}
