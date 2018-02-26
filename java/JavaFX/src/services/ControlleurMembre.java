/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.Administrateur;
import entites.Dresseur;
import entites.Membre;
import entites.Veterinaire;
import java.util.ArrayList;

/**
 *
 * @author houssem
 */
public class ControlleurMembre {
    
    public int ajoutMembre(String nom, String prenom, String adresse, String email, int num, String photo, String pasword){
        
        Membre m = new Membre(nom, prenom, adresse, email, num, photo, pasword);
        return m.ajouterMembre();
    }
    public int ajoutadministrateur(String nom, String prenom, String adresse, String email, int num, String photo, String pasword){
        
        Administrateur m = new Administrateur(nom, prenom, adresse, email, num, photo, pasword);
        return m.ajouterAdministrateur();
    }
    public int ajoutVeterinaire(String nom, String prenom, String adresse, String email, int num, String photo, String pasword){
        
        Veterinaire m = new Veterinaire(0,nom, prenom, adresse, email, num, photo, pasword);
        return m.ajouterVeterinaire();
    }
    public int ajoutDresseur(String nom, String prenom, String adresse, String email, int num, String photo, String pasword){
        
        Dresseur m = new Dresseur(0,nom, prenom, adresse, email, num, photo, pasword);
        return m.ajouterDresseur();
    }
    
    public int supprimerMembre(Membre a){
        return a.supprimerMembre();
        
    }
    public int modifierMembre(Membre m1,int x)
    {
      return  m1.modifierMembre(x);
    }
    public int modifierPasword(Membre m1,int x)
    {
      return  m1.modifierasword(x);
    }
    
    
    public Membre getMembre(int m)
    {
        Membre x=new Membre();
        return x.getMembre(m);
    
    }  public Membre getMembreByEmail(String m)
    {
        Membre x=new Membre();
        return x.getMembreByEmail(  m);
    }
    
    public int emailExiste(String email)
    { Membre m = new Membre();
        return m.emailExiste(email);
    }
        
    public int login (String email , String pasword)
    {Membre m = new Membre();
        return m.login(email, pasword);
    }
    public String encrypt(String pasword)
    {
        Membre m = new Membre();
        return  m.encrypt(pasword);
        
    }
    public String decrypt(String pasword)
    {
        Membre m = new Membre();
        return  m.decrypt(pasword);
        
    }
    public void setConnected(Membre m){
        m.setConnected();

    }
    public void setDeconnected(Membre m){
        m.setDeconnected();
    }
    
    public ArrayList<Membre> selectAll(int i){
        Membre m = new Membre();
        return m.selectAll(i);
    }
}
