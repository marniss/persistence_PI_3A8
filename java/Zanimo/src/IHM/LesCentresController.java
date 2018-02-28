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
 * @author mossa
 */
public class LesCentresController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void showGestionCS(ActionEvent event) {
         try {
            Parent parent = FXMLLoader.load(getClass().getResource("/IHM/IHM_GestionCS.fxml"));
            Stage stage = new Stage();

            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            
        }
    }
     @FXML
    private void showGestionCD(ActionEvent event) {
         try {
            Parent parent = FXMLLoader.load(getClass().getResource("/IHM/IHM_GestionCD.fxml"));
            Stage stage = new Stage();

            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            
        }
    }
     @FXML
    private void showListCS(ActionEvent event) {
         try {
            Parent parent = FXMLLoader.load(getClass().getResource("/IHM/IHM_ListCS.fxml"));
            Stage stage = new Stage();

            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            
        }
    }
   

    @FXML
    private void showListCD(ActionEvent event) {
     try {
            Parent parent = FXMLLoader.load(getClass().getResource("/IHM/IHM_ListCD.fxml"));
            Stage stage = new Stage();
            
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            
        }
    }
    
}
