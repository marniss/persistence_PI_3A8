/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import entites.Membre;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import services.ControlleurMembre;

/**
 * FXML Controller class
 *
 * @author houssem
 */
public class IHM_profil_modifierController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField tel;
    @FXML
    private Button modifier;
    @FXML
    private TextField adresse;
    @FXML
    private TextField email;
    @FXML
    private Button brows;
    @FXML
    private TextField doc;
    @FXML
    private ImageView photo;

    private static Path destination1;
    private static File selectedfile1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        ControlleurMembre m = new ControlleurMembre();

        Membre x = new Membre();
        Membre m = x.getMembre(IHM_loginController.membre.getIdMembre());

        adresse.setText("" + m.getAdresse());
        nom.setText("" + m.getNom());
        prenom.setText("" + m.getPrenom());
        // motdepasse.setText(""+m.getPasword());
        email.setText("" + m.getEmail());
        tel.setText("" + m.getNum());
        doc.setText("" + m.getPhoto());
        /*motdepasse.setText(m.getPasword());
      confirmerMDP.setText(m.getPasword()); */
        if (!m.getPhoto().equals("")) {
            File file = new File("C:\\wamp64\\www\\PIZanimo\\photo_membre\\" + m.getPhoto());
            Image i = new Image(file.toURI().toString());
            photo.setImage(i);
            System.out.println(file.toURI().toString());
        } else {
            File file2 = new File("C:\\wamp64\\www\\PIZanimo\\photo_membre\\download.jpg");
            Image i2 = new Image(file2.toURI().toString());

            photo.setImage(i2);
        }
        // TODO
    }

    @FXML
    private void brows(ActionEvent event) throws MalformedURLException {
        FileChooser fc = new FileChooser();
        selectedfile1 = fc.showOpenDialog(null);
        destination1 = Paths.get("C:\\wamp64\\www\\PIZanimo\\photo_membre", selectedfile1.getName());
        doc.setText(selectedfile1.getName());

    }

    @FXML
    private void modifier(ActionEvent event) {
        Membre x = new Membre();
        Membre m = x.getMembre(IHM_loginController.membre.getIdMembre());

        Membre x2 = new Membre(nom.getText(), prenom.getText(), adresse.getText(), email.getText(), Integer.parseInt(tel.getText()), doc.getText(), m.getPasword());
        ;

        ControlleurMembre cm = new ControlleurMembre();

        cm.modifierMembre(x2, IHM_loginController.membre.getIdMembre());

        System.exit(0);

    }

    @FXML
    private void Annuler(ActionEvent event) {

        Stage stage = new Stage();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();

    }

    @FXML
    private void Retour(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("IHM_Profil.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(new Scene(root1));
        stage.show();
    }

}
