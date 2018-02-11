/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx;

import entites.FicheDeSoin;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import services.FicheDeSoinService;

/**
 *
 * @author houssem
 */
public class JavaFX extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/IHM/FicheDeSoinIHM.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        /*
        FicheDeSoin fs = new FicheDeSoin(1, "STYLESHEET_MODENA", "STYLESHEET_MODENA", 4, "2017-08-01", "2015-02-06", "STYLESHEET_MODENA", "STYLESHEET_CASPIAN", "STYLESHEET_MODENA", "STYLESHEET_MODENA", "STYLESHEET_CASPIAN", "2018-02-22");
        FicheDeSoinService fsService = new FicheDeSoinService();
        fsService.ajouterFicheDeSoin(fs);
        fs.setId_f_Soin(5);
        fs.setNom("Liza");
        fsService.modifierFicheDeSoin(fs);
         */
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

}
