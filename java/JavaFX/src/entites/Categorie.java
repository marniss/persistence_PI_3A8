/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author Ahmed
 */
public class Categorie {
    // nos attributs 
    private int idCategorie;
    private int idCategorieId;
    private String nom;
    
    // getters

    public int getIdCategorie() {
        return idCategorie;
    }

    public int getIdCategorieId() {
        return idCategorieId;
    }

    public String getNom() {
        return nom;
    }
    
    // setters

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public void setIdCategorieId(int idCategorieId) {
        this.idCategorieId = idCategorieId;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    //constructeur
    
    /**1**/
    public Categorie() {}
    
    /**2**/
    public Categorie(int idCategorie, int idCategorieId, String nom) {
        this.idCategorie = idCategorie;
        this.idCategorieId = idCategorieId;
        this.nom = nom;
    }
    
    
    
    
    
}
