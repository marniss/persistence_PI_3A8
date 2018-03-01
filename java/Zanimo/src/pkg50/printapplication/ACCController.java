/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg50.printapplication;

import IHM.IHM_Notre_AccueilController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class ACCController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private VBox vboxMenu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void accueil(ActionEvent event) throws IOException {
        Parent root = null;
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void profil(ActionEvent event) {
        Parent root = null;
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void adoption(ActionEvent event) {

    }

    @FXML
    private void sos_dis(ActionEvent event) {
    }

    @FXML
    private void animal(ActionEvent event) {
    }

    @FXML
    private void produit(ActionEvent event) {
    }

    @FXML
    private void concour(ActionEvent event) {
    }

    @FXML
    private void veterinair(ActionEvent event) {
    }

    @FXML
    private void dresseur(ActionEvent event) {
    }

    @FXML
    private void centresoin(ActionEvent event) {
    }

    @FXML
    private void centredress(ActionEvent event) {
    }

    @FXML
    private void faq(ActionEvent event) {
    }

    @FXML
    private void gestionutilis(ActionEvent event) {
    }

}
