/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class IHM_acccccccccController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void ahmed(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("IHM_Home_Wiki_Commercial.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void mossab(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LesCentres.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void angham(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("IHM_Acceuil.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void gateau(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainPanel_1.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void makni(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MenuIHM.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void houssem(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("IHM_login.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void acccc(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("IHM_Notre_Accueil.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

}
