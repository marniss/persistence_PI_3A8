/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class VIEW_SoinController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void onClickListVete(ActionEvent event) {

        if (IHM_loginController.membre == null) {
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("ListeVeterinaire.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(VIEW_WIKIController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.hide();
            stage.setScene(scene);
            stage.show();
        } else {
            if (IHM_loginController.membre.getType().equals("Admin")) {
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("ListeDesVeterinaireAdmin.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(VIEW_WIKIController.class.getName()).log(Level.SEVERE, null, ex);
                }
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();

            } else {
                if (IHM_loginController.membre.getType().equals("Veterinaire")) {
                    Parent root = null;
                    try {
                        root = FXMLLoader.load(getClass().getResource("ConsulterFicheDeSoinIHM.fxml"));
                    } catch (IOException ex) {
                        Logger.getLogger(VIEW_WIKIController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.hide();
                    stage.setScene(scene);
                    stage.show();
                }

            }
        }
//        Stage stage = (Stage) btn.getScene().getWindow();
//        stage.close();
    }

    @FXML
    private void onClickListCentre(ActionEvent event
    ) {
    }

}
