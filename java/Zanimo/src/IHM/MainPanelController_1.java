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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author salah
 */
public class MainPanelController_1 implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void animalview(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/IHM/IHM_AjouterAnimal.fxml"));
            Stage stage = new Stage();

            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainPanelController_1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void sosview(ActionEvent event) {
        
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/IHM/IHM_SosDisparition.fxml"));
            Stage stage = new Stage();

            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainPanelController_1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  

}
