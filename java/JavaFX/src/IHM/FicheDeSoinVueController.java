/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import entites.FicheDeSoin;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.sound.midi.Soundbank;
import services.ControlleurFicheDeSoin;

/**
 * FXML Controller class
 *
 * @author pc asus
 */
public class FicheDeSoinVueController implements Initializable {

    @FXML
    private TextField id_vet;
    @FXML
    private TextField nom;
    @FXML
    private TextField espece;
    @FXML
    private TextField poids;
    @FXML
    private TextField datep;
    @FXML
    private TextField neLe;
    @FXML
    private TextField genre;
    @FXML
    private TextField observation;
    @FXML
    private TextField photo;
    @FXML
    private TextField medi;
    @FXML
    private TextField prop;
    @FXML
    private TextField revoireLe;
    @FXML
    private Button ajouter;
    @FXML
    private Button modi;
    @FXML
    private Button update;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void ajouter(ActionEvent event) {
        ControlleurFicheDeSoin cfds = new ControlleurFicheDeSoin();
        //cfds.ajouterFicheDeSoin(1, "nom", "espece", 12, "datePoids", "neLe", "genre", "observation", "photo", "medicament", "proprietaire", "prochainRD", 1);
        //cfds.ajouterFicheDeSoin(Integer.parseInt(id_vet.getText()), nom.getText(), espece.getText(), Float.parseFloat(poids.getText()), datep.getText(), neLe.getText(), genre.getText(), observation.getText(), photo.getText(), medi.getText(), prop.getText(), revoireLe.getText(), 1);
        System.out.println("Ajouuuut OOOOK");
    }

    @FXML
    private void modi(ActionEvent event) throws IOException {

        ControlleurFicheDeSoin cfds = new ControlleurFicheDeSoin();
        //cfds.modifierFicheDeSoin(ConsulterFicheDeSoinIHMController.id_f_soin_modifier, Integer.parseInt(id_vet.getText()), nom.getText(), espece.getText(), Float.parseFloat(poids.getText()), datep.getText(), neLe.getText(), genre.getText(), observation.getText(), photo.getText(), medi.getText(), prop.getText(), revoireLe.getText(), 1);
        System.out.println("Modifiiication Vue");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/IHM/ConsulterFicheDeSoinIHM.fxml"));
        Parent root = (Parent) loader.load();
        Stage window;
        window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(new Scene(root));
        window.show();
    }

    public int initFields(FicheDeSoin f) throws IOException {

        int i = f.getId_f_Soin();
        id_vet.setText(String.valueOf(f.getId_f_Soin()));
        espece.setText(f.getNom());
        poids.setText(String.valueOf(f.getPoids()));
        //  datep.setText(f.getDatePoids());
        //neLe.setText(f.getNeLe());
        genre.setText(f.getGenre());
        observation.setText(f.getObservation());
        photo.setText(f.getPhoto());
        medi.setText(f.getMedicament());
        prop.setText(f.getProprietaire());
        // revoireLe.setText(f.getProchainRDV());
        System.out.println(i);
        return f.getId_f_Soin();
    }

    @FXML
    private void update(ActionEvent event) throws IOException {
        ControlleurFicheDeSoin cfds = new ControlleurFicheDeSoin();

        System.out.println("Updaaaaaaaaaaate");
        //cfds.updateFicheDeSoin(i, Integer.parseInt(id_vet.getText()), nom.getText(), espece.getText(), Float.parseFloat(poids.getText()), datep.getText(), neLe.getText(), genre.getText(), observation.getText(), photo.getText(), medi.getText(), prop.getText(), revoireLe.getText(), 1);
        System.out.println("Modifiiication Vue");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/IHM/ConsulterFicheDeSoinIHM.fxml"));
        Parent root = (Parent) loader.load();
        Stage window;
        window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(new Scene(root));
        window.show();
    }

}
