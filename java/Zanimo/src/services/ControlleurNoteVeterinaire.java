/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.NoteVetirinaire;

/**
 *
 * @author makni
 */
public class ControlleurNoteVeterinaire {

    public int ajouterNote(int id_membre, float note, String observation) {
        NoteVetirinaire nv = new NoteVetirinaire(id_membre, note, observation);
        System.out.println("Controlleur");
        return nv.ajouterNote();
    }

    public String moyenneNote() {
        System.out.println("Controlleur");
        NoteVetirinaire nv = new NoteVetirinaire();
        System.out.println("Controller " + nv.moyNotee());
        System.out.println(" Contolllll[" + nv.moyNotee().length() + "]");
        return nv.moyNotee();

    }

}
