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
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author makni
 */
public class MenuIHMController implements Initializable {

    @FXML
    private Button ficheDesoinRedi;
    @FXML
    private Button ListeVétérinaireRedi;
    @FXML
    private Button FicheDeDressageRedi;
    @FXML
    private Button ListeDesDresseurRedi;
    @FXML
    private Button NoteVetiRedi;
    @FXML
    private Button NoteDresseurRedi;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    private void ficheDeSoin(ActionEvent event) throws IOException {
        /*  FXMLLoader loader = new FXMLLoader(getClass().getResource("/IHM/ConsulterFicheDeSoinIHM.fxml"));
        Parent root = (Parent) loader.load();
        Stage window;
        window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(new Scene(root));
        window.show();*/
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/IHM/ConsulterFicheDeSoinIHM.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void listeDesVétér(ActionEvent event) throws IOException {
        /*FXMLLoader loader = new FXMLLoader(getClass().getResource("/IHM/ListeDesVeterinaireAdmin.fxml"));
        Parent root = (Parent) loader.load();
        Stage window;
        window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(new Scene(root));
        window.show();*/
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/IHM/ListeDesVeterinaireAdmin.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void ficheDeDressage(ActionEvent event) throws IOException {
        /*
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/IHM/ConsulterFicheDeDressage.fxml"));
        Parent root = (Parent) loader.load();
        Stage window;
        window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(new Scene(root));
        window.show();*/
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/IHM/ConsulterFicheDeDressage.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void listeDesDresseur(ActionEvent event) throws IOException {
        /*FXMLLoader loader = new FXMLLoader(getClass().getResource("/IHM/ListeDresseurAdmin.fxml"));
        Parent root = (Parent) loader.load();
        Stage window;
        window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(new Scene(root));
        window.show();*/

        //Parent root = FXMLLoader.load(getClass().getResource("/IHM/ListeDresseur.fxml"));
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/IHM/ListeDresseurAdmin.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void noteVétéri(ActionEvent event) throws IOException {
        /* FXMLLoader loader = new FXMLLoader(getClass().getResource("/IHM/NoteVetIHM.fxml"));
        Parent root = (Parent) loader.load();
        Stage window;
        window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(new Scene(root));
        window.show();*/
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/IHM/ListeVeterinaire.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void noteDresseur(ActionEvent event) throws IOException {
        /* FXMLLoader loader = new FXMLLoader(getClass().getResource("/IHM/NoteDresseur.fxml"));
        Parent root = (Parent) loader.load();
        Stage window;
        window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(new Scene(root));
        window.show();*/
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/IHM/ListeDresseur.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
