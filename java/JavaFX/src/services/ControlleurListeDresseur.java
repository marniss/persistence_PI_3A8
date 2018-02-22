/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.ListeDesDresseurs;
import entites.NoteDresseur;
import java.util.ArrayList;

/**
 *
 * @author makni
 */
public class ControlleurListeDresseur {

    public static NoteDresseur tempo = new NoteDresseur();

    public int ajouterDresseur(String nom, String prenom, String tel, String adresse, String mail, String photo) {
        ListeDesDresseurs ldd = new ListeDesDresseurs(nom, prenom, tel, adresse, mail, photo);
        return ldd.ajouterDresseur();
    }

    public ArrayList displayList() {
        ListeDesDresseurs ldd = new ListeDesDresseurs();
        return ldd.afficherDresseur();
    }

    public int modifierDresseur(int id, String nom, String prenom, String tel, String adresse, String mail, String photo) {
        ListeDesDresseurs ldd = new ListeDesDresseurs(id, nom, prenom, tel, adresse, mail, photo);
        System.out.println("Controolleeeur  " + ldd);
        return ldd.modifierDresseur();

    }

    public int supprimerDresseur(ListeDesDresseurs d) {
        return d.supprimerDresseur();
    }

    public Float getLaNote(int idvet) {
        ListeDesDresseurs x = new ListeDesDresseurs(idvet);
        x = x.getNote();
        tempo = new NoteDresseur(x.getId_note());
        NoteDresseur aaa = tempo.getlanote();
        return aaa.getNote();
    }

    public void affecternote(float f) {
        System.out.println("0.1");
        tempo.setLaNote(f);
    }
}
