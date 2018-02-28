/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import entites.Question;
import entites.Reponse;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import services.ServiceQuestion;
import services.ServiceReponse;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class IHM_Listing_QuestionController implements Initializable {

    @FXML
    private TableColumn<Question, String> question;
    @FXML
    private TableView<Question> tbv;
    @FXML
    private VBox vbQR;
    @FXML
    private Button btnretour;

    public static int idQuestion = 1;
    @FXML
    private TextField tfQuestionPropose;
    @FXML
    private Button btnPoster;
    @FXML
    private Button btnAfficherform;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        affichage();
    }

    @FXML
    private void onClickRetour(ActionEvent event) {
        Stage stage = (Stage) btnretour.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void afficherform(ActionEvent event) {
        btnAfficherform.setVisible(false);
        btnPoster.setVisible(true);
        tfQuestionPropose.setVisible(true);
    }

    @FXML
    private void posterquestion(ActionEvent event) {
        //appl du service
        ServiceQuestion temp = new ServiceQuestion();
        temp.ajouterQuestion(tfQuestionPropose.getText());
        //alert que l'ajour et effectué
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Foire aux questions");
        alert.setHeaderText(null);
        alert.setContentText("votre question a étes transmise a notre commité, nous vous remercions pour votre aide");
        alert.showAndWait();
        Stage stage = (Stage) btnPoster.getScene().getWindow();
        stage.close();
    }

    private void affichage() {
        tfQuestionPropose.setVisible(false);
        btnPoster.setVisible(false);
        ServiceQuestion services = new ServiceQuestion();
        ArrayList<Question> temp = services.listingQuestion();
        question.setCellValueFactory(new PropertyValueFactory<>("laquestion"));
        for (Question e : temp) {
            tbv.getItems().addAll(e);
        }
        tbv.setOnMouseClicked((event) -> {
            if (event.getClickCount() == 1) {
                vbQR.getChildren().clear();
                //recuperation de l'id de la question selectionnée
                IHM_Listing_QuestionController.idQuestion = tbv.getItems().get(tbv.getSelectionModel().getSelectedIndex()).getId();
                //System.out.println(IHM_Listing_QuestionController.idQuestion);
                //modification de notre vbox
                vbQR.setPadding(new Insets(30, 30, 30, 30));
                //recuperation de la question a partir de la table view
                Label labelquestion = new Label(tbv.getItems().get(tbv.getSelectionModel().getSelectedIndex()).getLaquestion());
                labelquestion.setFont(Font.font("Amble CN", FontWeight.BOLD, 24));
                labelquestion.setWrapText(true);
                vbQR.getChildren().add(labelquestion);
                // recuperation des reponse a partir du -> contoleur -> entité -> BD
                ArrayList<Reponse> lesreponses = ServiceReponse.listingReponse(IHM_Listing_QuestionController.idQuestion);
                for (Reponse xxx : lesreponses) {
                    if (xxx.getLareponse().length() == 0) {
                        xxx.setLareponse("on s'excuse on n'a pas de reponce pour cette question");
                    }
                    Label labelreponse = new Label("*" + xxx.getLareponse());
                    labelreponse.setWrapText(true);
                    vbQR.getChildren().add(labelreponse);
                }
            }

        });
    }

}
