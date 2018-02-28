/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author angham
 */
public class ParticipationAffectation {

    private String idparticipation;
    private String typeConcour;
    private String nbPlaceDispo;
    private String typeAnimal;
    private String idAnimal;
    private String adresseMembre;

    public ParticipationAffectation(String id, String typeconcours, String nombredispo, String typeAnimal, String idAnimal, String mail) {
        this.idparticipation = id;
        this.typeConcour = typeconcours;
        this.nbPlaceDispo = nombredispo;
        this.typeAnimal = typeAnimal;
        this.idAnimal = idAnimal;
        this.adresseMembre = mail;
    }

    public ParticipationAffectation() {
    }

    public String getIdparticipation() {
        return idparticipation;
    }

    public void setIdparticipation(String idparticipation) {
        this.idparticipation = idparticipation;
    }

    public String getTypeConcour() {
        return typeConcour;
    }

    public void setTypeConcour(String typeConcour) {
        this.typeConcour = typeConcour;
    }

    public String getNbPlaceDispo() {
        return nbPlaceDispo;
    }

    public void setNbPlaceDispo(String nbPlaceDispo) {
        this.nbPlaceDispo = nbPlaceDispo;
    }

    public String getTypeAnimal() {
        return typeAnimal;
    }

    public void setTypeAnimal(String typeAnimal) {
        this.typeAnimal = typeAnimal;
    }

    public String getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(String idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getAdresseMembre() {
        return adresseMembre;
    }

    public void setAdresseMembre(String adresseMembre) {
        this.adresseMembre = adresseMembre;
    }

}
