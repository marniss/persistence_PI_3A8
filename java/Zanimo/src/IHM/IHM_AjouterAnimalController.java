package IHM;

import entites.Animal;
import java.io.File;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JFileChooser;
import java.sql.Date;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import services.ControlleurChamp;

/**
 * FXML Controller class
 *
 * @author salah
 */
public class IHM_AjouterAnimalController implements Initializable {

    private TextField animal;
    private TextField adoption;
    @FXML
    private Button ajout;
    @FXML
    private TextField type;
    @FXML
    private Button afficher;
    @FXML
    private TextField nom;
    @FXML
    private TextField race;
    @FXML
    private DatePicker date;
    @FXML
    private TextField photo;
    @FXML
    private TextArea description;
    @FXML
    private Button brows;
    @FXML
    private Label errorNom;
    @FXML
    private Label erroeidadoption;
    @FXML
    private TextField poid;
    @FXML
    private RadioButton femelle;
    @FXML
    private RadioButton male;
    @FXML
    private ToggleGroup genre;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    //***************************************************************************************************************
    //                                         AJOUTER Animal
    //***************************************************************************************************************

    @FXML
    private void ajouteranimal(ActionEvent event) {
        String gen;
        ControlleurChamp cc = new ControlleurChamp();

        if (!cc.isRace(race.getText())) {
            erroeidadoption.setText("il faut un race valide");
        } else if (!cc.isName(nom.getText())) {
            errorNom.setText("il faut un nom valide");

        } else {
            if (femelle.isSelected()) {
                gen = "femelle";
            } else {
                gen = "male";
            }
            System.out.println(gen);
            String s = date.getValue().toString();
            Date ddd = java.sql.Date.valueOf(date.getValue());

            Animal a = new Animal(gen, nom.getText(), race.getText(), ddd, description.getText(), Double.parseDouble(poid.getText()), 1, IHM_loginController.membre.getIdMembre());
            a.ajouterAnimal();

            Alert al = new Alert(Alert.AlertType.INFORMATION);
            al.setTitle("INFORMATION");
            al.setHeaderText(null);
            al.setContentText("Animal Ajouter");
            al.showAndWait();
        }

    }
    //*************************************
    //AFFICHER List Animal
    //*************************************

    @FXML
    private void afficherlist(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/IHM/IHM_List_Animal.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainPanelController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Ajouter_Photo(ActionEvent event) {

        JFileChooser file = new JFileChooser();
        file.showOpenDialog(null);
        File f = file.getSelectedFile();
        photo.setText(f.getAbsolutePath());

    }

}
