/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iservice;

import entites.ficheDeSoin;
import java.util.List;

/**
 *
 * @author pc asus
 */
public interface IficheDeSoin {

    public void ajouterFicheDeSoin(ficheDeSoin fsDeSoin);

    public void supprimerFicheDeSoin(ficheDeSoin fsDeSoin);

    public boolean rechercherEnseignant(ficheDeSoin fsDeSoin);

    public boolean rechercherFicheDeSoin(int id);

    public List<ficheDeSoin> selectFicheDeSoin();

}
