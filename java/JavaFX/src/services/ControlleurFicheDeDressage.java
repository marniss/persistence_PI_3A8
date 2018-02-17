/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.FicheDeDressage;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author makni
 */
public class ControlleurFicheDeDressage {

    public int ajouterFicheDeDressage(int id_membre, String espece, String nom, float poids, String proprietaire, String specialite, String photo, float displine, float obeissance, float accompagnement, float interception, float noteTotal, Date dateDebut, Date dateFin) {
        FicheDeDressage ficheDeDressage = new FicheDeDressage(id_membre, espece, nom, poids, proprietaire, specialite, photo, displine, obeissance, accompagnement, interception, noteTotal, dateDebut, dateFin);
        System.out.println("Ajoouuu Controolleeur  :" + ficheDeDressage);
        return ficheDeDressage.ajouterFicheDeDressage();
    }

    public int modifierFicheDeDressage(int id_f_Dressage, int id_membre, String espece, String nom, float poids, String proprietaire, String specialite, String photo, float displine, float obeissance, float accompagnement, float interception, float noteTotal, Date dateDebut, Date dateFin) {
        FicheDeDressage ficheDeDressage = new FicheDeDressage(id_f_Dressage, id_membre, espece, nom, poids, proprietaire, specialite, photo, displine, obeissance, accompagnement, interception, noteTotal, dateDebut, dateFin);
        return ficheDeDressage.modifierFicheDeDressage();
    }

    public int supprimerFicheDeDressage(FicheDeDressage fdd) {
        return fdd.supprimerFicheDeDressage();
    }

    public ArrayList afficherFicheDeDressage() {
        FicheDeDressage fdd = new FicheDeDressage();
        return fdd.displayFicheDeDressage();
    }

}
