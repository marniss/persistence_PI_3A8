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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import javax.management.Notification;
import org.controlsfx.control.Notifications;
import services.ControlleurChamps;
import services.ControlleurConcour;

/**
 * FXML Controller class
 *
 * @author angham
 */
public class IHM_Ajouter_ConcourController implements Initializable {

    @FXML
    private TextField type;
    @FXML
    private TextField race;

    @FXML
    private DatePicker df;
    @FXML
    private Button Ajouter;
    @FXML
    private TextField titre;
    @FXML
    private DatePicker dd;
    @FXML
    private Label errorDateDebut;
    @FXML
    private Label errorDateFin;
    @FXML
    private Label error;
    @FXML
    private TextField capacite;
    @FXML
    private TextField lieu;
    @FXML
    private Label error1;
    @FXML
    private Label errordatedeb;
    @FXML
    private Label errordatefin;
    @FXML
    private Label error2;
    @FXML
    private Label error3;
    @FXML
    private Label capaeror;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void Ajouter(ActionEvent event) throws ParseException {
        int x = 0;
        int a = 1;

        ControlleurChamps cc = new ControlleurChamps();

        if (type.getText().isEmpty() || race.getText().isEmpty() || titre.getText().isEmpty() || dd.getValue() == null || df.getValue() == null || capacite.getText().isEmpty() || lieu.getText().isEmpty() || dd.getValue() == null) {
            error1.setText("le remplissage des champs est obligatoire");
            error1.setVisible(true);
            a = 0;
        }

        if (dd.getValue() != null && df.getValue() != null) {
            ControlleurConcour test = new ControlleurConcour();
            SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
            Date dateDebut = formater.parse(dd.getValue().toString());
            Date dateFin = formater.parse(df.getValue().toString());
            Date d = new Date();

            if (dateDebut.before(d)) {
                error2.setText("il faut une date supperieur a date d'ajourdhui");
                error2.setVisible(true);
                a = 0;

            }
            if (dateFin.before(dateDebut)) {
                error3.setText("il faut une date superieure à la date Début");
                error3.setVisible(true);
                a = 0;

            }

            if (!cc.isNumber(capacite.getText())) {
                capaeror.setVisible(true);
                capaeror.setText("il faut saisir un nombre et non pas un String");
                a = 0;
            }

            if ((dateDebut.after(d)) && (dateFin.after(dateDebut) && a == 1)) {
                notifications();
                int i = test.ajouterConcour(titre.getText(), type.getText(), race.getText(), dateDebut, dateFin, 1, lieu.getText(), Integer.valueOf(capacite.getText()), 0);
            }

        }

    }

    ////***** API NOTIFICATION****///
    public void notifications() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(IHM_Ajouter_ConcourController.class.getName()).log(Level.SEVERE, null, ex);

        }

        Notifications notif = Notifications.create()
                .title("Notification : ")
                .text("l'ajout est effectué avec succés :) ")
                .hideAfter(Duration.seconds(5))
                .position(Pos.BOTTOM_RIGHT)
                .onAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println("Cliked on Notifications");
                    }
                });
        notif.darkStyle();

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                notif.show();
            }
        });
    }
}
