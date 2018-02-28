/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.QuestionQuiz;
import entites.ReponseQuiz;
import java.util.ArrayList;

/**
 *
 * @author Ahmed
 */
public class ServiceQuiz {

    public ArrayList<QuestionQuiz> listingQuestion() {
        QuestionQuiz temp = new QuestionQuiz();
        return temp.listingQuestion();
    }

    public ArrayList<ReponseQuiz> listingReponse() {
        ReponseQuiz temp = new ReponseQuiz();
        return temp.listingReponse();
    }

    public ReponseQuiz getBonneReponse(int id) {
        ReponseQuiz temp = new ReponseQuiz(id);
        return temp.getBonneReponse();
    }

}
