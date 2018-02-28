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
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class IHM_Home_Wiki_CommercialController implements Initializable {

    @FXML
    private Button btncommercial;
    @FXML
    private Button btnwiki;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void affichermenucommercial(ActionEvent event){
        try {
            Stage stage = (Stage) btncommercial.getScene().getWindow();
            stage.close();

            Parent root = FXMLLoader.load(getClass().getResource("ModuleCommercial.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    @FXML
    private void affichermenuwiki(ActionEvent event) {
        try {
            Stage stage = (Stage) btnwiki.getScene().getWindow();
            stage.close();

            Parent root = FXMLLoader.load(getClass().getResource("IHM_ModuleWiki.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
