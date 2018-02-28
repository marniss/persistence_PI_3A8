/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.NoteDresseur;

/**
 *
 * @author makni
 */
public class ControlleurNoteDresseur {

    public int ajouterNote(int id_membre, float note, String observation) {
        NoteDresseur nv = new NoteDresseur(id_membre, note, observation);
        System.out.println("Controlleur");
        return nv.ajouterNote();

    }

    public String moyenneNote() {
        System.out.println("Controlleur");
        NoteDresseur nv = new NoteDresseur();
        System.out.println("Controller " + nv.moyNotee());
        System.out.println(" Contolllll[" + nv.moyNotee().length() + "]");
        return nv.moyNotee();
    }
}
