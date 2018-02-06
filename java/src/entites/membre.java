/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author houssem
 */
public class membre 
{private String nom;
private String prenom ;
private  int age;
private String adresse;
private String sexe;
private int tel;
private int type ;

    public membre(String nom, String prenom, int age, String adresse, String sexe, int tel, int type) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.adresse = adresse;
        this.sexe = sexe;
        this.tel = tel;
        this.type = type;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public membre() {
    }

    @Override
    public String toString() {
        return "membre{" + "nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", adresse=" + adresse + ", sexe=" + sexe + ", tel=" + tel + ", type=" + type + '}';
    }
    
    

  



    
}
