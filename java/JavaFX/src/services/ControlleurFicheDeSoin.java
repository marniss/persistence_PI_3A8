/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

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
    public int ajouterFicheDeSoin(int id_membre, String nom, String espece, float poids, Date datePoids, Date neLe, String genre, String observation, String photo, String medicament, String proprietaire, Date prochainRDV, int etat) {
        FicheDeSoin fsSoin = new FicheDeSoin(id_membre, nom, espece, poids, datePoids, neLe, genre, observation, photo, medicament, proprietaire, prochainRDV, etat);
        return fsSoin.ajouterFicheDeSoin();

    }

    public int modifierFicheDeSoin(int id_f_Soin, int id_membre, String nom, String espece, float poids, Date datePoids, Date neLe, String genre, String observation, String photo, String medicament, String proprietaire, Date prochainRDV, int etat
    ) {
        FicheDeSoin fsSoin = new FicheDeSoin(id_f_Soin, id_membre, nom, espece, poids, datePoids, neLe, genre, observation, photo, medicament, proprietaire, prochainRDV, etat);
        return fsSoin.modifierFicheDeSoin();
    }

    public ArrayList ConsulterFicheDeSoin() {
        FicheDeSoin fds = new FicheDeSoin();
        return fds.displayFicheDeSoin();
    }

    public int updateFicheDeSoin(FicheDeSoin fs) {
        FicheDeSoin fsSoin = new FicheDeSoin(fs.getId_f_Soin(), fs.getId_membre(), fs.getNom(), fs.getEspece(), fs.getPoids(), fs.getDatePoids(), fs.getNeLe(), fs.getGenre(), fs.getObservation(), fs.getPhoto(), fs.getMedicament(), fs.getProprietaire(), fs.getProchainRDV(), 0);
        return fsSoin.supprimerFicheDeSoin();
    }

}
