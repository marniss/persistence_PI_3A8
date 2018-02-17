/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.ListeDesVetirinaires;
import java.util.ArrayList;

/**
 *
 * @author makni
 */
public class ControlleurListeVeterinaire {

    public int ajouterVeteriniare(String nom, String prenom, String tel, String adresse, String mail, String photo) {
        ListeDesVetirinaires ldv = new ListeDesVetirinaires(nom, prenom, tel, adresse, mail, photo);
        return ldv.ajouterVetirinaire();
    }

    public ArrayList displayList() {
        ListeDesVetirinaires ldv = new ListeDesVetirinaires();
        return ldv.ListVetirinaire();
    }

    public int modifierVeterinaire(String nom, String prenom, String tel, String adresse, String mail, String photo) {
        ListeDesVetirinaires ldv = new ListeDesVetirinaires(nom, prenom, tel, adresse, mail, photo);
        return ldv.modifierVetirinaire();
    }

    public int supprimerVeterinaire(String nom, String prenom, String tel, String adresse, String mail, String photo) {
        ListeDesVetirinaires ldv = new ListeDesVetirinaires(nom, prenom, tel, adresse, mail, photo);
        return ldv.supprimerVetirinaire();
    }

}
