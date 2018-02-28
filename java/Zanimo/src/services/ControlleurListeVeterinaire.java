/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.ListeDesVetirinaires;
import entites.NoteVetirinaire;
import java.util.ArrayList;

/**
 *
 * @author makni
 */
public class ControlleurListeVeterinaire {

    public static NoteVetirinaire tempo = new NoteVetirinaire();

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

    public Float getLaNote(int idvet) {
        ListeDesVetirinaires x = new ListeDesVetirinaires(idvet);
        x = x.getNote();
        tempo = new NoteVetirinaire(x.getId_note());
        NoteVetirinaire aaa = tempo.getlanote();
        return aaa.getNote();
    }

    public void affecternote(float f) {
        System.out.println("0.1");
        tempo.setLaNote(f);

    }

    public int ajouterNote(int id_membre, float note, String observation) {
        NoteVetirinaire nv = new NoteVetirinaire(id_membre, note, observation);
        System.out.println("Controlleur");
        return nv.ajouterNote();
    }

    public int getLastidNote() {
        NoteVetirinaire nv = new NoteVetirinaire();
        return nv.getLastidNote();

    }

    public int affecteridnote(int id, int numNote) {
        ListeDesVetirinaires ldv = new ListeDesVetirinaires(id, numNote);
        return ldv.setidnote();
    }

}
