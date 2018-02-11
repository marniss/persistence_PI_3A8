/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iServices;

import entites.FicheDeSoin;
import java.util.List;

/**
 *
 * @author pc asus
 */
public interface FicheDeSoinInterface {

    public void ajouterFicheDeSoin(FicheDeSoin ficheDeSoin);

    public void modifierFicheDeSoin(FicheDeSoin ficheDeSoin);

    public boolean rechercheFicheDeSoin(int id_f_Soin);

    public List<FicheDeSoin> displayFicheDeSoin();

}
