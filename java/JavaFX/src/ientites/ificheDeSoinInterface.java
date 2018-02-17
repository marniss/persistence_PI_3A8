/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ientites;

import entites.FicheDeSoin;
import java.util.List;

/**
 *
 * @author pc asus
 */
public interface ificheDeSoinInterface {

    public int ajouterFicheDeSoin();

    public int modifierFicheDeSoin();

    public int rechercheFicheDeSoin(int id_f_Soin);

    public List<FicheDeSoin> displayFicheDeSoin();

    public int supprimerFicheDeSoin();

}
