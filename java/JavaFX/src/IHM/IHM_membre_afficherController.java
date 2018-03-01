/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import entites.Membre;
import java.io.File;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.ImageIcon;
import services.ControlleurMembre;

/**
 * FXML Controller class
 *
 * @author houssem
 */
public class IHM_membre_afficherController implements Initializable {

    @FXML
    private Label nom;
    @FXML
    private Label prenom;
    @FXML
    private Label tel;
    @FXML
    private Label adresse;
    @FXML
    private Label email;
    @FXML
    private Label date;
    @FXML
    private Label type;
    @FXML
    private ImageView image;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ControlleurMembre x = new ControlleurMembre();

        Membre m = x.getMembre(IHM_liste_membreController.idZbotrech);

        nom.setText(m.getNom());
        adresse.setText(m.getAdresse());
        tel.setText("" + m.getNum());
        prenom.setText(m.getPrenom());
        email.setText(m.getEmail());
        type.setText(m.getType());
        date.setText("" + m.getDateInscription());
        System.out.println("ZZZZZZ" + m.getPhoto() + "zzzz");
        System.out.println("111222555");

        if (!m.getPhoto().equals("")) {
            File file = new File("C:\\wamp64\\www\\PIZanimo\\photo_membre\\" + m.getPhoto());
            Image i = new Image(file.toURI().toString());
            image.setImage(i);
            System.out.println(file.toURI().toString());
        } else {
            File file2 = new File("C:\\wamp64\\www\\PIZanimo\\photo_membre\\download.jpg");
            Image i2 = new Image(file2.toURI().toString());

            image.setImage(i2);
        }

    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();

    }

    @FXML
    private void Annuler(ActionEvent event) {
        Stage stage = new Stage();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();

    }

}
