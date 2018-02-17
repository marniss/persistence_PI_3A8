/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import services.ControlleurFicheDeDressage;

/**
 * FXML Controller class
 *
 * @author pc asus
 */
public class FicheDeDressageIHMController implements Initializable {

    @FXML
    private Text id_membre;
    @FXML
    private TextField prop;
    @FXML
    private TextField nom;
    @FXML
    private TextField espece;
    @FXML
    private RadioButton male;
    @FXML
    private ToggleGroup genre;
    @FXML
    private RadioButton female;
    @FXML
    private Text id_f_Soin;
    @FXML
    private Button ajouter;
    @FXML
    private Button annuler;
    @FXML
    private TextField photo;
    @FXML
    private DatePicker dated;
    @FXML
    private DatePicker dateF;
    @FXML
    private Button brouse;
    @FXML
    private TextField id_dres;
    @FXML
    private TextField specialite;
    @FXML
    private TextField noteTotale;
    @FXML
    private TextField poids;
    @FXML
    private TextField despline;
    @FXML
    private TextField obeissance;
    @FXML
    private TextField accompagnement;
    @FXML
    private TextField interception;
    float note = 0;
    ControlleurFicheDeDressage cfdd = new ControlleurFicheDeDressage();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    private void ajouter(ActionEvent event) throws ParseException {
        String gen;
        if (female.isSelected()) {
            gen = "Female";
        } else {
            gen = "Male";
        }
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
        Date datedeb = format.parse(dated.getValue().toString());
        Date datFin = format.parse(dateF.getValue().toString());
        cfdd.ajouterFicheDeDressage(Integer.parseInt(id_dres.getText()), espece.getText(), nom.getText(), Float.parseFloat(poids.getText()), prop.getText(), specialite.getText(), photo.getText(), Float.parseFloat(despline.getText()), Float.parseFloat(obeissance.getText()), Float.parseFloat(accompagnement.getText()), Float.parseFloat(interception.getText()), note / 4, datedeb, datFin);
    }

    @FXML
    private void annuler(ActionEvent event) {
    }

    @FXML
    private float brouse(ActionEvent event) {
        noteTotale.setText(String.valueOf(note));
        return note += Float.parseFloat(noteTotale.getText());
    }

    @FXML
    private float adddes(ActionEvent event) {
        noteTotale.setText(String.valueOf(note));
        return note += Float.parseFloat(despline.getText());
    }

    @FXML
    private float addobei(ActionEvent event) {
        noteTotale.setText(String.valueOf(note));
        return note += Float.parseFloat(obeissance.getText());
    }

    @FXML
    private float addacom(ActionEvent event) {
        noteTotale.setText(String.valueOf(note));
        return note += Float.parseFloat(accompagnement.getText());
    }

    @FXML
    private float addinter(ActionEvent event) {
        noteTotale.setText(String.valueOf(note));
        return note += Float.parseFloat(interception.getText());
    }

}
