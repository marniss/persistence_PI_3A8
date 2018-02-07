/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iservice;

import entites.FicheDeSoin;
import java.util.List;

/**
 *
 * @author pc asus
 */
public interface IficheDeSoin {

    public void ajouterFicheDeSoin(FicheDeSoin fsDeSoin);

    public void supprimerFicheDeSoin(FicheDeSoin fsDeSoin);

    public boolean rechercherEnseignant(FicheDeSoin fsDeSoin);

    public boolean rechercherFicheDeSoin(int id);

    public List<FicheDeSoin> selectFicheDeSoin();

}
