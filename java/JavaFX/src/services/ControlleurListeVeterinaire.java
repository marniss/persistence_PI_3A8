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

    public int modifierVeterinaire(int id, String nom, String prenom, String tel, String adresse, String mail, String photo) {
        ListeDesVetirinaires ldv = new ListeDesVetirinaires(id, nom, prenom, tel, adresse, mail, photo);
        return ldv.modifierVetirinaire();
    }

    public int supprimerVeterinaire(ListeDesVetirinaires vet) {
        ListeDesVetirinaires ldv = new ListeDesVetirinaires(vet.getId(), vet.getNom(), vet.getPrenom(), vet.getTel(), vet.getAdresse(), vet.getMail(), vet.getPhoto());
        return ldv.supprimerVetirinaire();
    }

}
