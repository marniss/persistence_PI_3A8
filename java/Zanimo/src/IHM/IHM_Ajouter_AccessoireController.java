/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import entites.Categorie;
import java.awt.Component;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import services.ServiceAccessoire;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class IHM_Ajouter_AccessoireController implements Initializable {

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
    private ChoiceBox<String> categorie;
    @FXML
    private Button buttonValider;
    @FXML
    private Button buttonAnnulerAction;
    @FXML
    private TextField photo;
    @FXML
    private Button homebtn;
    @FXML
    private Label titreEror;
    @FXML
    private Label qteEror;
    @FXML
    private Label prixEror;
    @FXML
    private Label typeEror;
    @FXML
    private Label validiteEror;
    @FXML
    private Label cateEror;
    @FXML
    private Label msgEror;
    @FXML
    private Button btnparcourir;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> options = FXCollections.observableArrayList("1 semaine", "1 mois", "2 mois", "3 mois");
        validite.setItems(options);
        //ajout des differantes categorie via la base de données
        ServiceAccessoire temp = new ServiceAccessoire();
        for (Categorie categorie1 : temp.getAllCategorie()) {
            categorie.getItems().add(categorie1.getNom());
        }
    }
    public static int eror = 0;

    @FXML
    private void buttonValiderAction(ActionEvent event) {
        ServiceAccessoire temp = new ServiceAccessoire();
        IHM_Ajouter_AccessoireController.eror = temp.ajouterAcessoire(nom.getText(), description.getText(), prix.getText(), qte.getText(), type.getText(), photo.getText(), validite.getValue(), 1, categorie.getValue(), 1);
        if (eror < 10) {
            Stage stage = (Stage) homebtn.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("tout est ok :*");
            alert.setHeaderText(null);
            alert.setContentText("felicitation votre annonce est effectué");
            alert.showAndWait();
            if (alert.getResult().getButtonData() == ButtonBar.ButtonData.OK_DONE) {
                stage.close();
            }
        } else {
            String test = "" + eror;
            if (test.contains("6")) {
                msgEror.setVisible(true);
                cateEror.setVisible(true);
            }
            if (test.contains("5")) {
                msgEror.setVisible(true);
                validiteEror.setVisible(true);
            }
            if (test.contains("4")) {
                msgEror.setVisible(true);
                qteEror.setVisible(true);
            }
            if (test.contains("3")) {
                msgEror.setVisible(true);
                prixEror.setVisible(true);
            }
            if (test.contains("9")) {
                msgEror.setVisible(true);
                titreEror.setVisible(true);
            }
            if (test.contains("8")) {
                msgEror.setVisible(true);
                typeEror.setVisible(true);
            }

        }

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
    private void onclickback(ActionEvent event) {
        try {
            Stage stage = (Stage) homebtn.getScene().getWindow();
            stage.close();
            homebtn.getScene().setRoot(FXMLLoader.load(getClass().getResource("IHM_Listing_Accessoire.fxml")));
        } catch (Exception e) {
            System.out.println("backbutton error");
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void onClickparcourir(ActionEvent event) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif"));
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            photo.setText(chooser.getSelectedFile().getAbsolutePath().toString());
            photo.setText(photo.getText().replace("\\", "/"));
        }
    }

}
