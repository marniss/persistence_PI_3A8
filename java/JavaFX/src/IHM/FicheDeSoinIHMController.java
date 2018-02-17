/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import services.ControlleurFicheDeSoin;

/**
 * FXML Controller class
 *
 * @author pc makni
 */
public class FicheDeSoinIHMController implements Initializable {

    @FXML
    private Text id_membre;
    @FXML
    private TextField prop;
    @FXML
    private TextField nom;
    @FXML
    private TextField espece;
    @FXML
    private TextArea observation;
    @FXML
    private TextField poids;
    @FXML
    private RadioButton male;
    @FXML
    private RadioButton female;
    @FXML
    private Text id_f_Soin;
    @FXML
    private TextField medi;
    @FXML
    private Button ajouter;
    @FXML
    private Button annuler;
    @FXML
    private TextField photo;

    @FXML
    private DatePicker nele;
    @FXML
    private DatePicker datep;
    @FXML
    private DatePicker revoirerdv;

    @FXML
    private Button brouse;

    @FXML
    ToggleGroup genre;
    @FXML
    private TextField id_vete;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private void medi(MouseEvent event) {
    }

    @FXML
    private void ajouter(ActionEvent event) throws ParseException {
        ControlleurFicheDeSoin cfds = new ControlleurFicheDeSoin();
        String gen;
        if (female.isSelected()) {
            gen = "Female";
        } else {
            gen = "Male";
        }
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
        Date datepoid = format.parse(datep.getValue().toString());
        Date datNai = format.parse(nele.getValue().toString());
        Date dateRDV = format.parse(revoirerdv.getValue().toString());
        cfds.ajouterFicheDeSoin(Integer.parseInt(id_vete.getText()), nom.getText(), espece.getText(), Float.parseFloat(poids.getText()), datepoid, datNai, gen, observation.getText(), photo.getText(), medi.getText(), prop.getText(), dateRDV, 1);

    }

    @FXML
    private void annuler(ActionEvent event) {
    }

    @FXML
    private void brouse(ActionEvent event) {
    }

}
