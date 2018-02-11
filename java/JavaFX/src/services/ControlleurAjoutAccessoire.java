/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.*;
import java.util.Date;

/**
 *
 * @author Ahmed
 */
public class ControlleurAjoutAccessoire {
    // les attributs
    //les methodes
    //le controle de saisie
    //l'instanciation et l'interrogation de la base
    public int ajouterAccessoire (int idAccessoire, String nomAccessoire, String descriptionAccessoire, float prixAccessoire, int qteStockAccessoire, String typeAccessoire, String photoAccessoire, Date datePublicationAccessoire, int validitePublicationAccessoire, int etatAccessoire, int IdMembre){
        Categorie x = new Categorie();
        Accessoire a = new Accessoire( idAccessoire,  nomAccessoire,  descriptionAccessoire,  prixAccessoire,  qteStockAccessoire,  typeAccessoire,  photoAccessoire,  datePublicationAccessoire,  validitePublicationAccessoire,  etatAccessoire, x,  IdMembre);
        return a.ajouterAccessoire();
    }
    
}
