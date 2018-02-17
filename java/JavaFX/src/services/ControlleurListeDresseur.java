/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.ListeDesDresseurs;
import java.util.ArrayList;

/**
 *
 * @author makni
 */
public class ControlleurListeDresseur {

    public int ajouterDresseur(String nom, String prenom, String tel, String adresse, String mail, String photo) {
        ListeDesDresseurs ldd = new ListeDesDresseurs(nom, prenom, tel, adresse, mail, photo);
        return ldd.ajouterDresseur();
    }

    public ArrayList displayList() {
        ListeDesDresseurs ldd = new ListeDesDresseurs();
        return ldd.afficherDresseur();
    }

    public int modifierDresseur(String nom, String prenom, String tel, String adresse, String mail, String photo) {
        ListeDesDresseurs ldd = new ListeDesDresseurs(nom, prenom, tel, adresse, mail, photo);
        return ldd.modifierDresseur();

    }

    public int supprimerDresseur(String nom, String prenom, String tel, String adresse, String mail, String photo) {
        ListeDesDresseurs ldd = new ListeDesDresseurs(nom, prenom, tel, adresse, mail, photo);
        return ldd.supprimerDresseur();
    }
}
