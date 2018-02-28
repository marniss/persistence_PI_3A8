/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.Question;
import java.util.ArrayList;

/**
 *
 * @author Ahmed
 */
public class ServiceQuestion {
    //attributs
    //methodes
    public int ajouterQuestion(String questionPosee){
        Question temp = new Question(questionPosee);
        return temp.ajouterQuestion();
    }
    public ArrayList<Question> listingQuestion(){
        Question temp = new Question();
        return temp.listingQuestion();        
    }
    public Question getQuestion(int id){
        Question temp = new Question();
        return temp.getQuestion();
    }
    public int supprimerQuestion(int id){
        Question temp = new Question(id);
        return temp.supprimerQuestion();
    }
    public ArrayList<Question> listingQuestionPourAdmin(){
        Question temp = new Question();
        return temp.listingQuestionPourAdmin();        
    }
    
}
