/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.FicheDeDressage;
import java.util.ArrayList;
import java.util.Date;

/*
 *
 * @author makni
 */
public class ControlleurFicheDeDressage {

    public int ajouterFicheDeDressage(int id_membre, String specialite, float displine, float obeissance, float accompagnement, float interception, float noteTotal, Date dateDebut, Date dateFin, int id_animal, int etat) {
        FicheDeDressage ficheDeDressage = new FicheDeDressage(id_membre, specialite, displine, obeissance, accompagnement, interception, noteTotal, dateDebut, dateFin, id_animal, 1);

        return ficheDeDressage.ajouterFicheDeDressage();
    }

    public int modifierFicheDeDressage(int id_f_Dressage, int id_membre, String specialite, float displine, float obeissance, float accompagnement, float interception, float noteTotal, Date dateDebut, Date dateFin, int id_animal, int etat) {
        FicheDeDressage ficheDeDressage = new FicheDeDressage(id_f_Dressage, id_membre, specialite, displine, obeissance, accompagnement, interception, noteTotal, dateDebut, dateFin, id_animal, etat);
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
