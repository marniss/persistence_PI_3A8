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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import services.ControlleurMembre;

/**
 * FXML Controller class
 *
 * @author houssem
 */
public class IHM_ProfilController implements Initializable {

    @FXML
    private Label date;
    @FXML
    private Label type;
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
    private ImageView image;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ControlleurMembre x = new ControlleurMembre();

        Membre m = x.getMembre(IHM_loginController.membre.getIdMembre());

        nom.setText(m.getNom());
        adresse.setText(m.getAdresse());
        tel.setText("" + m.getNum());
        prenom.setText(m.getPrenom());
        email.setText(m.getEmail());
        type.setText(m.getType());
        date.setText("" + m.getDateInscription());
        System.out.println("ZZZZZZ" + m.getPhoto());

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
//URL imageURL = getClass().getResource("/image/maphoto.jpg");
// Image i = new Image(imageURL.toExternalForm());

//image.setImage(i);
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        Parent parent125 = FXMLLoader.load(getClass().getResource("IHM_Accueil.fxml"));
        Scene scene1116 = new Scene(parent125);
        Stage stage1116 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage1116.hide();
        stage1116.setScene(scene1116);
        stage1116.show();
    }

    @FXML
    private void Annuler(ActionEvent event) {
        Stage stage = new Stage();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
    }

    @FXML
    private void modifier(ActionEvent event) throws IOException {
        Parent parent125 = FXMLLoader.load(getClass().getResource("IHM_profil_modifier.fxml"));
        Scene scene1116 = new Scene(parent125);
        Stage stage1116 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage1116.hide();
        stage1116.setScene(scene1116);
        stage1116.show();
    }

    @FXML
    private void changepasword(ActionEvent event) throws IOException {
        Parent parent125 = FXMLLoader.load(getClass().getResource("IHM_Modifier_Pasword.fxml"));
        Scene scene1116 = new Scene(parent125);
        Stage stage1116 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage1116.hide();
        stage1116.setScene(scene1116);
        stage1116.show();
    }

}
