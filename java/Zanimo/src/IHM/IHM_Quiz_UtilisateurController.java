/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import entites.QuestionQuiz;
import entites.ReponseQuiz;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import services.ServiceQuiz;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class IHM_Quiz_UtilisateurController implements Initializable {

    @FXML
    private VBox vbquiz;
    @FXML
    private Button btnQuitter;

    public static QuestionQuiz questionencours = null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        commencerquiz();
    }

    @FXML
    private void onClickQuitter(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Quiz Exit");
        alert.setHeaderText(null);
        alert.setContentText("Etes vous sur de quitter le quiz");
        alert.showAndWait();
        if (alert.getResult() == ButtonType.OK) {
            System.exit(0);
        }
    }

    private void commencerquiz() {
        ServiceQuiz service = new ServiceQuiz();
        ArrayList<QuestionQuiz> listeQuestion = service.listingQuestion();
        ArrayList<ReponseQuiz> listereponse = service.listingReponse();
        int i = 1;
        //listereponse.rev
        for (QuestionQuiz questionQuiz : listeQuestion) {
            //if (i < 4) {
            questionencours = questionQuiz;
            afficherUneQuestion(questionencours, listereponse, i);
            i++;
        }
    }

    private void afficherUneQuestion(QuestionQuiz question, ArrayList<ReponseQuiz> listereponse, int i) {
        /*final ToggleGroup group = new ToggleGroup();
        int idaleatoire = 0;
        int idalea2 = 0;
        //vbquiz.getChildren().clear();
        Label laquestion = new Label("Question n°  " + i + " : " + question.getQuestion());
        idalea2 = randomWithRange(0, question.getIdR() + 1);
        RadioButton rep1 = new RadioButton("" + listereponse.get(idalea2).getReponse());
        if (idalea2 == question.getIdR()) {
            idaleatoire = question.getIdR();
            while (idaleatoire == question.getIdR()) {
                idaleatoire = randomWithRange(0, listereponse.size());
            }
        } else {
            idaleatoire = randomWithRange(0, listereponse.size());
        }
        RadioButton rep2 = new RadioButton("" + listereponse.get(idaleatoire).getReponse());
        RadioButton rep3 = new RadioButton();
        if ((idaleatoire == question.getIdR()) || (idalea2 == question.getIdR())) {
            while (idaleatoire == question.getIdR()) {
                idaleatoire = randomWithRange(0, listereponse.size());
            }
            rep3.setText("" + listereponse.get(idaleatoire).getReponse());
        } else {
            ServiceQuiz sss = new ServiceQuiz();
            rep3.setText(sss.getBonneReponse(question.getIdR()).getReponse());
            rep3.setToggleGroup(group);
        }
        vbquiz.getChildren().add(laquestion);
        rep1.setToggleGroup(group);
        rep1.setSelected(true);
        rep2.setToggleGroup(group);
        rep3.setToggleGroup(group);
        vbquiz.getChildren().add(rep1);
        vbquiz.getChildren().add(rep2);
        vbquiz.getChildren().add(rep3);*/
        /**
         * ******************************
         */
        //vbquiz.getChildren().clear();
        Label laquestion = new Label("Question n°  " + i + " : " + question.getQuestion());
        vbquiz.getChildren().add(laquestion);
        //nos elements pour la question en cours
        ToggleGroup grouprep = new ToggleGroup();
        RadioButton rep1 = new RadioButton();
        RadioButton rep2 = new RadioButton();
        RadioButton rep3 = new RadioButton();
        Button suivant = new Button("suivant");
        //trois variables aleatoires
        int alea1 = randomWithRange(1, question.getIdR() + 2);
        int alea2 = 1;
        int alea3 = 1;

        if (alea1 == question.getIdR()) {
            alea2 = randomWithRange(1, listereponse.size());
            while (alea2 == question.getIdR()) {
                alea2 = randomWithRange(1, listereponse.size());
            }
            alea3 = randomWithRange(1, listereponse.size());
            while (alea3 == question.getIdR()) {
                alea3 = randomWithRange(1, listereponse.size());
            }
        } else {
            alea2 = randomWithRange(1, question.getIdR() + 2);
            if (alea2 == question.getIdR()) {
                alea3 = randomWithRange(1, listereponse.size());
                while (alea3 == question.getIdR()) {
                    alea3 = randomWithRange(1, listereponse.size());
                }
            } else {
                alea3 = question.getIdR();
            }
        }
        System.out.println("*alea1 = " + alea1 + " *alea2 = " + alea2 + " *alea3 = " + alea3 + " **bonne = " + question.getIdR());
        System.out.println("*alea1 = " + "" + listereponse.get(alea1).getReponse() + " *alea2 = " + "" + listereponse.get(alea2).getReponse() + " *alea3 = " + "" + listereponse.get(alea3).getReponse() + " **bonne = " + question.getIdR());
        rep1.setText("" + listereponse.get(alea1).getReponse());
        rep2.setText("" + listereponse.get(alea2).getReponse());
        rep3.setText("" + listereponse.get(alea3).getReponse());
        rep1.setToggleGroup(grouprep);
        rep1.setSelected(true);
        rep2.setToggleGroup(grouprep);
        rep3.setToggleGroup(grouprep);
        vbquiz.getChildren().add(rep1);
        vbquiz.getChildren().add(rep2);
        vbquiz.getChildren().add(rep3);
    }

    int randomWithRange(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }
}
