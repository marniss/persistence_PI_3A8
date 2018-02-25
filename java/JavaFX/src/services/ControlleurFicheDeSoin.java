/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.Animal;
import entites.FicheDeSoin;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author makni
 */
public class ControlleurFicheDeSoin {

    //Attributs
    //Controle de saisie
    //Instancier
    public int ajouterFicheDeSoin(int id_membre, String observation, String medicament, Date datcreation, Date prochainRDV, int id_animal, int etat) {
        FicheDeSoin fsSoin = new FicheDeSoin(id_membre, observation, medicament, datcreation, prochainRDV, id_animal, 1);
        return fsSoin.ajouterFicheDeSoin();
    }

    public int modifierFicheDeSoin(int id_f_Soin, int id_membre, String observation, String medicament, Date prochainRDV, int id_animal
    ) {
        FicheDeSoin fsSoin = new FicheDeSoin(id_f_Soin, id_membre, observation, medicament, prochainRDV, id_animal, 1);
        return fsSoin.modifierFicheDeSoin();
    }

    public ArrayList ConsulterFicheDeSoin() {
        FicheDeSoin fds = new FicheDeSoin();
        return fds.displayFicheDeSoin();
    }

    public int updateFicheDeSoin(FicheDeSoin fs) {
        FicheDeSoin fsSoin = new FicheDeSoin(fs.getId_f_Soin(), fs.getId_membre(), fs.getObservation(), fs.getMedicament(), fs.getProchainRDV(), fs.getId_animal(), 0);
        return fsSoin.supprimerFicheDeSoin();
    }

//    public int ajouterAhmed(int id, int id_membre, String nom, String espece, float poids, Date datePoids, Date neLe, String genre, String observation, String photo, String medicament, String proprietaire, Date prochainRDV, int etat) {
//        Animal x = new Animal();
//        Animal y = x.getAnimal(id);
//        FicheDeSoin fsSoin = new FicheDeSoin(id_membre, observation, medicament, prochainRDV, id, 1);
//
//        return fsSoin.ajouterFicheDeSoin();
//  }
}
