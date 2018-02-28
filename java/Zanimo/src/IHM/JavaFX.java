/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Ahmed
 */
public class JavaFX extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        /*Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();*/

        //Parent root = FXMLLoader.load(getClass().getResource("IHM_Ajouter_Accessoire.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("IHM_Listing_Accessoire.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("IHM_Afficher_Accessoire.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("IHM_Modifier_Acessoire.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("IHM_Supprimer_Accessoire.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("Ihm_Ajouter_Nourriture.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("IHM_Listing_Nourriture.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("IHM_Afficher_Nourriture.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("IHM_Modifier_Nourriture.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("IHM_Supprimer_Nourriture.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("ModuleCommercial.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("IHM_accccccccc.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
