/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iServices;

import entites.FicheDeDressage;
import java.util.List;

/**
 *
 * @author pc asus
 */
public interface FicheDeDressageInterface {

    public void ajouterFicheDeDressage(FicheDeDressage ficheDeDressage);

    public void modifierFicheDeDressage(FicheDeDressage ficheDeDressage);

    public boolean rechercheFicheDeDressage(int id_f_Dressage);

    public List<FicheDeDressage> displayFicheDeDressage();
}
