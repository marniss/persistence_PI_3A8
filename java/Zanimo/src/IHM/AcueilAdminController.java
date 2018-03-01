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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class AcueilAdminController implements Initializable {

    @FXML
    private Label Nom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Nom.setText(IHM_loginController.membre.getNom() + " " + IHM_loginController.membre.getPrenom());

        Notifications.create().title("vous etes conecter ").show();

    }

    @FXML
    private void gestionUtilisateur(ActionEvent event) throws IOException {
        Parent parent125 = FXMLLoader.load(getClass().getResource("IHM_liste_membre.fxml"));
        Scene scene1116 = new Scene(parent125);
        Stage stage1116 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage1116.hide();
        stage1116.setScene(scene1116);
        stage1116.show();
    }

    @FXML
    private void Adoption(ActionEvent event) throws IOException {
        Parent parent125 = FXMLLoader.load(getClass().getResource("IHM_Adoption.fxml"));
        Scene scene1116 = new Scene(parent125);
        Stage stage1116 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage1116.hide();
        stage1116.setScene(scene1116);
        stage1116.show();
    }

    private void Animal(ActionEvent event) throws IOException {
        Parent parent125 = FXMLLoader.load(getClass().getResource("IHM_login.fxml"));
        /*   Scene scene1116 = new Scene(parent125 );
       Stage stage1116  = (Stage)((Node)event.getSource()).getScene().getWindow();
       stage1116 .hide();
       stage1116 .setScene(scene1116 );
       stage1116.show(); */
    }

    @FXML
    private void logout(ActionEvent event) {
    }

    @FXML
    private void profil(ActionEvent event) throws IOException {
        Parent parent125 = FXMLLoader.load(getClass().getResource("IHM_Profil.fxml"));
        Scene scene1116 = new Scene(parent125);
        Stage stage1116 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage1116.hide();
        stage1116.setScene(scene1116);
        stage1116.show();
    }

}
