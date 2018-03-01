/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.util.converter.LocalDateStringConverter;
import services.ControlleurConcour;

/**
 * FXML Controller class
 *
 * @author angham
 */
public class IHM_Modifier_ConcourController implements Initializable {

    @FXML
    private Button modifier;
    @FXML
    private TextField new_type;
    @FXML
    private TextField new_race;
    @FXML
    private TextField new_titre;
    @FXML
    private DatePicker dd;
    @FXML
    private DatePicker df;
    @FXML
    private TextField capacite;
    @FXML
    private TextField lieu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //IHM_Liste_ConcourController.
        System.out.println("*************" + IHM_Liste_ConcourController.concourSelectionner.getTypeConcour());
        new_type.setText(IHM_Liste_ConcourController.concourSelectionner.getTypeConcour());
        new_race.setText(IHM_Liste_ConcourController.concourSelectionner.getRace());
        new_titre.setText(IHM_Liste_ConcourController.concourSelectionner.getTitreConcour());
        capacite.setText("" + IHM_Liste_ConcourController.concourSelectionner.getCapacite());
        lieu.setText(IHM_Liste_ConcourController.concourSelectionner.getLieu());

        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
        Date dateDebut = IHM_Liste_ConcourController.concourSelectionner.getDateDebut();
        Date datefin = null;
        try {
            dateDebut = formater.parse(IHM_Liste_ConcourController.concourSelectionner.getDateDebut().toString());
            datefin = formater.parse(IHM_Liste_ConcourController.concourSelectionner.getDateFin().toString());
        } catch (ParseException ex) {
            Logger.getLogger(IHM_Modifier_ConcourController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //LocalDate test1 = LocalDate.of(Integer.parseInt(dateDebut.getYear()), Month.MARCH, 0)
        LocalDate dateDebut1 = dateDebut.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate datefinnn = datefin.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        /*dd.setValue(dateDebut1);
        df.setValue(datefinnn);*/
    }

    @FXML
    private void modifier(ActionEvent event) {
        ControlleurConcour temp = new ControlleurConcour();
        // temp.modifierConcour(IHM_Liste_ConcourController.concourSelectionner.getIdConcour(),new_type.getText(),new_race.getText(),new_titre.getText(),capacite.getText(),lieu.getText());
        temp.modifierConcour(IHM_Liste_ConcourController.concourSelectionner.getIdConcour(), new_type.getText(), new_race.getText(), new_titre.getText(), lieu.getText(), Integer.parseInt(capacite.getText()));
    }

}
