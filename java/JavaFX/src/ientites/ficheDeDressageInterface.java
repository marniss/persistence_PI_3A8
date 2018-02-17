/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ientites;

import entites.FicheDeDressage;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pc asus
 */
public interface ficheDeDressageInterface {

    public int ajouterFicheDeDressage();

    public int modifierFicheDeDressage();

    public int rechercheFicheDeDressage(int id_f_Dressage);

    public ArrayList displayFicheDeDressage();

    public int supprimerFicheDeDressage();
}
