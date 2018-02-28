/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entites.CentreSoins;
import java.util.ArrayList;
/**
 *
 * @author mossa
 */
public class CSController {
    private int id;  
    private  String nom;
    private  String type;
    private  String adresse;
    private  int numero;
    private  double note;
    static double SommeNote;
    static int nbreNote=0;
    CentreSoins cs;
    //constructeur non parametré
    public CSController() {
    }
    //constructeur parametré sans id
    public CSController(String nom, String type, String adresse, int numero, double note) {
        this.nom = nom;
        this.type = type;
        this.adresse = adresse;
        this.numero = numero;
        this.note = note;
    }
    //constructeur parametré avec id
    public CSController(int id, String nom, String type, String adresse, int numero, double note) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.adresse = adresse;
        this.numero = numero;
        this.note = note;
    }
    //ajouter dans la base
    public void ajouter(){
     cs = new CentreSoins(this.nom, this.type, this.adresse, this.numero, this.note);
     cs.ajouter();
    }
    //modifier dans la base
    public void modifier()
    {
    cs = new CentreSoins(this.id,this.nom, this.type, this.adresse, this.numero, this.note);
     cs.modifier();
    }
    //maj note
    public void majNote()
    { SommeNote=SommeNote+this.note;
        nbreNote++;
        this.note=SommeNote/nbreNote;
     cs = new CentreSoins(this.id,this.nom, this.type, this.adresse, this.numero, this.note);
     cs.modifier();
        System.out.println(nbreNote);
    }
    //supprimer dans la base
    public void supprimer(int id)
    {
    cs=new CentreSoins();
    cs.supprimer(id);
    }
       //selectall
    public ArrayList<CentreSoins> selectAll()
    {cs=new CentreSoins();
        return cs.selectAll();
    }
      //selectall pour la recherche
    public ArrayList<CentreSoins> selectAll(String word)
    {cs=new CentreSoins();
        return cs.selectAll(word);
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

    public CentreSoins getCs() {
        return cs;
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

    public void setCs(CentreSoins cs) {
        this.cs = cs;
    }

    
}
