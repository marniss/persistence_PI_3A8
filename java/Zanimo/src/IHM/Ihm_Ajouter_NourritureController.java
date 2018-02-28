/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JFileChooser;
import services.ServiceNourriture;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class Ihm_Ajouter_NourritureController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField qte;
    @FXML
    private TextArea description;
    @FXML
    private TextField prix;
    @FXML
    private TextField type;
    @FXML
    private ChoiceBox<String> validite;
    @FXML
    private Button buttonValider;
    @FXML
    private Button buttonAnnulerAction;
    @FXML
    private TextField photo;

    @FXML
    private DatePicker datefavb;
    @FXML
    private AnchorPane datelim;
    @FXML
    private DatePicker datelimite;
    @FXML
    private Button homebtn;
    @FXML
    private Button btnparcourir;
    @FXML
    private Label erorqte;
    @FXML
    private Label erortitre;
    @FXML
    private Label erorvali;
    @FXML
    private Label erordf;
    @FXML
    private Label erorprix;
    @FXML
    private Label erortype;
    @FXML
    private Label erordl;
    @FXML
    private Label msgEror;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> options = FXCollections.observableArrayList("1 semaine", "1 mois", "2 mois", "3 mois");
        validite.setItems(options);

    }
    public static int iror = 0;

    @FXML
    private void buttonValiderAction(ActionEvent event) {
        /*controle de siasie*/

        ServiceNourriture temp = new ServiceNourriture();
        iror = temp.ajouterNourriture(0, nom.getText(), description.getText(), prix.getText(), qte.getText(), type.getText(), photo.getText(), validite.getValue(), "" + datefavb.getValue(), "" + datelimite.getValue(), 1);
        /**/
        if (iror < 10) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("votre annonce est ajoute");
            alert.showAndWait();
            Stage stage = (Stage) homebtn.getScene().getWindow();
            stage.close();
            if (alert.getResult().getButtonData() == ButtonBar.ButtonData.OK_DONE) {
                stage.close();
            }
        } else {
            String test = "" + iror;
            System.out.println("controle de saisie" + test);
            if (test.contains("6")) {
                msgEror.setVisible(true);
                erordf.setVisible(true);
            }
            if (test.contains("7")) {
                msgEror.setVisible(true);
                erordl.setVisible(true);
            }
            if (test.contains("5")) {
                msgEror.setVisible(true);
                erorvali.setVisible(true);
            }
            if (test.contains("4")) {
                msgEror.setVisible(true);
                erorqte.setVisible(true);
            }
            if (test.contains("3")) {
                msgEror.setVisible(true);
                erorprix.setVisible(true);
            }
            if (test.contains("9")) {
                msgEror.setVisible(true);
                erortitre.setVisible(true);
            }
            if (test.contains("8")) {
                msgEror.setVisible(true);
                erortype.setVisible(true);
            }

        }
        /**/

    }

    @FXML
    private void buttonAnnulerAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("etes vous sur de vouloire quitter");
        alert.showAndWait();
        if (alert.getResult().getButtonData() == ButtonBar.ButtonData.OK_DONE) {
            Stage stage = (Stage) buttonAnnulerAction.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    private void onclickback(ActionEvent event
    ) {
        Stage stage = (Stage) homebtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void onClickparcourir(ActionEvent event
    ) {
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            photo.setText(chooser.getSelectedFile().getAbsolutePath().toString());
            photo.setText(photo.getText().replace("\\", "/"));
        }
    }
}
