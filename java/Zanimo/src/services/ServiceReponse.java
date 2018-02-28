/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import IHM.IHM_Gestion_FAQController;
import entites.*;
import java.util.ArrayList;

/**
 *
 * @author Ahmed
 */
public class ServiceReponse {
    //attributs
    //methodes
        public static ArrayList<Reponse> listingReponse(int id){
        // nos variables locales
        Reponse temp = new Reponse();
        ArrayList<Reponse> laliste= new ArrayList<>();
        //la question qu'on veux aficher avec ses reponses
        Question laquestion = new Question(id);
        laquestion = laquestion.getQuestion();
        if(laquestion.getLesreponse()==null){
            laquestion.setLesreponse("0");
        }
        //la recuperation de(s) Reponse(s)
        String [] lesIdDesReponse = laquestion.getLesreponse().split(",");
        for (int i = 0 ; i< lesIdDesReponse.length;i++){
            if(lesIdDesReponse[i]!="0"){
                temp = new Reponse(Integer.parseInt(lesIdDesReponse[i]));
                temp = temp.getReponse();
                laliste.add(temp);
            }
            
        }
        return laliste; 
        }
        public int ajouterReponse(String rep){
            Question unequestion = new Question(IHM_Gestion_FAQController.idQuestion);
            Reponse reponse = new Reponse(rep);
            if(reponse.ajouterReponse()==1){
                reponse=reponse.getReponseviaREP();
                unequestion.modifierQuestion(reponse.getId());
            }
            return 0 ;
        }
    
}
