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

    public int ajouterNote(int id_membre, float idnote, String observation) {
        NoteDresseur nd = new NoteDresseur(id_membre, idnote, observation);
        System.out.println("Controlleur");
        System.out.println("Ajouter Note Controlleur");
        return nd.ajouterNote();

    }

    public int getLastidNote() {
        NoteDresseur nd = new NoteDresseur();
        return nd.getLastidNote();

    }

    public int affecteridnote(int id, int numNote) {
        ListeDesDresseurs ldd = new ListeDesDresseurs(id, numNote);
        return ldd.setidnote();
    }
}
