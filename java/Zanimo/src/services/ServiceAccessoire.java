/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.Accessoire;
import entites.Categorie;
import java.util.ArrayList;

/**
 *
 * @author Ahmed
 */
public class ServiceAccessoire {

    //attributs
    //methodes
    public int ajouterAcessoire(String nomAccessoire, String descriptionAccessoire, String prix, String qte, String typeAccessoire, String photoAccessoire, String validite, int etatAccessoire, String categorieAccessoire, int IdMembre) {
        float prixAccessoire = 0;
        int qteStockAccessoire = 0;
        int test = 1;
        //nos tests 9345
        if (nomAccessoire.length() == 0) {
            test = test * 10 + 9;
        }
        try {
            prixAccessoire = Float.parseFloat(prix);
        } catch (Exception e) {
            test = test * 10 + 3;
        }
        try {
            qteStockAccessoire = Integer.parseInt(qte);
        } catch (Exception e) {
            test = test * 10 + 4;
        }
        if (validite == null) {
            test = test * 10 + 5;
        }
        if (categorieAccessoire == null) {
            test = test * 10 + 6;
        }
        if (typeAccessoire.length() == 0) {
            test = test * 10 + 8;
        }
        if (test < 10) {
            //l'ajout
            Categorie x = new Categorie(categorieAccessoire);
            x = x.getCategorieViaNom();
            int valval = getvalid(validite);
            Accessoire temp = new Accessoire(nomAccessoire, descriptionAccessoire, prixAccessoire, qteStockAccessoire, typeAccessoire, photoAccessoire, valval, x, IdMembre);
            return temp.ajouterAccessoire();
        } else {
            return test;
        }
    }

    public ArrayList<Accessoire> listingAccessoire() {
        Accessoire temp = new Accessoire();
        return temp.listingAccessoire();
    }

    public Accessoire getAccessoire(int id) {
        Accessoire temp = new Accessoire();
        return temp.getAccessoire(id);
    }

    public int modifierAccessoire(int id, String nom, String description, float prix, int quan, String type, int vali) {
        Accessoire temp = new Accessoire(id, nom, description, prix, quan, type, vali);
        return temp.modifierAccessoi();
    }

    public int supprimerAccessoire(int id) {
        Accessoire temp = new Accessoire(id);
        return temp.supprimerAccessoire();
    }

    public ArrayList<Categorie> getAllCategorie() {
        Categorie temp = new Categorie();
        return temp.getAllCategorie();
    }

    private int getvalid(String x) {
        if (x == "1 semaine") {
            return 1;
        }
        if (x == "1 mois") {
            return 4;
        }
        if (x == "2 mois") {
            return 8;
        }
        return 12;
    }
}
