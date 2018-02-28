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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
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
public class IHM_Gestion_FAQController implements Initializable {

    @FXML
    private TableColumn<Question, String> question;
    @FXML
    private TableView<Question> tbv;
    @FXML
    private VBox vbQR;
    @FXML
    private Button btnretour;

    public static int idQuestion = 1;
    public static String la_rep = "";

    @FXML
    private Button btnAfficherform;
    @FXML
    private Button btnsupprimer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        hetlist();
        tbv.setOnMouseClicked((event) -> {
            if (event.getClickCount() == 1) {
                btnsupprimer.setVisible(true);
                vbQR.getChildren().clear();
                //recuperation de l'id de la question selectionnée
                IHM_Gestion_FAQController.idQuestion = tbv.getItems().get(tbv.getSelectionModel().getSelectedIndex()).getId();
                //System.out.println(IHM_Listing_QuestionController.idQuestion);
                //modification de notre vbox
                vbQR.setPadding(new Insets(30, 30, 30, 30));
                //recuperation de la question a partir de la table view
                Label labelquestion = new Label(tbv.getItems().get(tbv.getSelectionModel().getSelectedIndex()).getLaquestion());
                labelquestion.setFont(Font.font("Amble CN", FontWeight.BOLD, 20));
                labelquestion.setWrapText(true);
                vbQR.getChildren().add(labelquestion);
                // recuperation des reponse a partir du -> contoleur -> entité -> BD
                ArrayList<Reponse> lesreponses = ServiceReponse.listingReponse(IHM_Gestion_FAQController.idQuestion);
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

    @FXML
    private void onClickRetour(ActionEvent event) {
        Stage stage = (Stage) btnretour.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void afficherform(ActionEvent event) {
        /**
         *
         */
        tiHeteElList();
        tbv.setOnMouseClicked((events) -> {
            if (events.getClickCount() == 1) {
                vbQR.getChildren().clear();
                //recuperation de l'id de la question selectionnée
                IHM_Gestion_FAQController.idQuestion = tbv.getItems().get(tbv.getSelectionModel().getSelectedIndex()).getId();
                //System.out.println(IHM_Listing_QuestionController.idQuestion);
                //modification de notre vbox
                TextArea reprep = new TextArea();
                vbQR.setPadding(new Insets(30, 30, 30, 30));
                TextField question = new TextField(tbv.getItems().get(tbv.getSelectionModel().getSelectedIndex()).getLaquestion());
                question.setFont(Font.font("Amble CN", FontWeight.BOLD, 12));
                question.setEditable(false);
                Button valider = new Button("Valider");
                valider.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent events) {
                        ServiceReponse servicerep = new ServiceReponse();
                        servicerep.ajouterReponse(reprep.getText());
                        vbQR.getChildren().clear();
                        tiHeteElList();
                    }
                });

                vbQR.getChildren().add(new Label("Question : "));
                vbQR.getChildren().add(question);
                vbQR.getChildren().add(new Label("Votre reponse : "));
                vbQR.getChildren().add(reprep);
                vbQR.getChildren().add(valider);
                btnsupprimer.setVisible(true);

            }

        });

    }

    @FXML
    private void onClickSupp(ActionEvent event) {
        ServiceQuestion service = new ServiceQuestion();
        service.supprimerQuestion(idQuestion);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Foire aux questions");
        alert.setHeaderText(null);
        alert.setContentText("La question a etet supp de l'appli");
        alert.showAndWait();
        /**
         * il faut se decider si l'interface de user ou admin soit hetlist() ou
         * tihetellist()*
         */
    }

    public void hetlist() {
        vbQR.getChildren().clear();
        tbv.getItems().clear();
        ServiceQuestion services = new ServiceQuestion();
        ArrayList<Question> temp = services.listingQuestion();
        question.setCellValueFactory(new PropertyValueFactory<>("laquestion"));
        for (Question e : temp) {
            tbv.getItems().addAll(e);
        }
    }

    public void tiHeteElList() {
        btnAfficherform.setVisible(false);
        vbQR.getChildren().clear();
        ServiceQuestion services = new ServiceQuestion();
        ArrayList<Question> temp = services.listingQuestionPourAdmin();
        question.setCellValueFactory(new PropertyValueFactory<>("laquestion"));
        tbv.getItems().clear();
        btnsupprimer.setVisible(false);
        for (Question e : temp) {
            tbv.getItems().addAll(e);
        }
    }

}
