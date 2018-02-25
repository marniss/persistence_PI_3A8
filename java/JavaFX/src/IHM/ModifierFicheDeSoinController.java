/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import entites.FicheDeSoin;
import java.io.IOException;
import java.net.URL;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import services.ControlleurFicheDeSoin;

/**
 * FXML Controller class
 *
 * @author makni
 */
public class ModifierFicheDeSoinController implements Initializable {

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
    private ToggleGroup genre;
    @FXML
    private RadioButton female;
    @FXML
    private Text id_f_Soin;
    @FXML
    private TextField photo;
    @FXML
    private DatePicker nele;
    @FXML
    private DatePicker datep;
    @FXML
    private DatePicker revoirerdv;
    @FXML
    private Label id_vete;
    @FXML
    private Button parcourir;
    @FXML
    private Button annuler;
    @FXML
    private Button modifier;
    @FXML
    private TextField medi;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    public int initFields(FicheDeSoin f) throws IOException {
        return 0;
        /*
        int i = f.getId_f_Soin();
        id_f_Soin.setText("fiche Soin N°: " + String.valueOf(f.getId_f_Soin()));
        espece.setText(f.getNom());
        poids.setText(String.valueOf(f.getPoids()));
        nom.setText(f.getNom());
        if (f.getGenre() == "Male") {
            male.selectedProperty();
        } else {
            female.selectedProperty();
        }
        //LocalDate x = new LocalDate(new Time());
        revoirerdv.setValue(LocalDate.now());
        medi.setText(f.getMedicament());
        observation.setText(f.getObservation());
        photo.setText(f.getPhoto());
        prop.setText(f.getProprietaire());
        id_vete.setText("id Veterinaire : " + String.valueOf(f.getId_membre()));
        System.out.println(i);
        return f.getId_f_Soin();*/
    }

    @FXML
    private void parcourir(ActionEvent event) {
    }

    @FXML
    private void annuler(ActionEvent event) {
    }

    @FXML
    private void modifier(ActionEvent event) throws ParseException {
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
        // cfds.modifierFicheDeSoin(Integer.parseInt(id_f_Soin.getText()), Integer.parseInt(id_vete.getText()), nom.getText(), espece.getText(), Float.parseFloat(poids.getText()), datepoid, datNai, gen, observation.getText(), photo.getText(), medi.getText(), prop.getText(), dateRDV, 1);
    }

}
