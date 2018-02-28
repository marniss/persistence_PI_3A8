/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import entites.Nourriture;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import services.ServiceNourriture;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class IHM_Supprimer_NourritureController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField prix;
    @FXML
    private TextArea description;
    @FXML
    private Button buttonSupprimer;
    @FXML
    private ImageView imgproduit;
    @FXML
    private Label idmembre;
    @FXML
    private TextField madate;
    @FXML
    private Button btnAnnuler;
    @FXML
    private Label iddd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // TODO
        ServiceNourriture service = new ServiceNourriture();
        Nourriture temp = service.getNourriture(IHM_Afficher_NourritureController.idn);

        nom.setText(temp.getNom());
        nom.setEditable(false);
        nom.setMouseTransparent(true);
        nom.setFocusTraversable(false);

        idmembre.setText("Identifiant membre :         " + temp.getIdMembre());

        description.setText(temp.getDescription());
        description.setEditable(false);
        description.setMouseTransparent(true);
        description.setFocusTraversable(false);

        prix.setText("" + temp.getPrix() + "  DT");
        prix.setEditable(false);
        prix.setMouseTransparent(true);
        prix.setFocusTraversable(false);

        madate.setText("" + temp.getDatePublication());
        madate.setEditable(false);
        madate.setMouseTransparent(true);
        madate.setFocusTraversable(false);

        File file;
        if (temp.getPhoto().length() == 0) {
            file = new File("src/data/0.jpg");
        } else {
            file = new File(temp.getPhoto());
        }

        Image image = new Image(file.toURI().toString());
        imgproduit.setImage(image);
        imgproduit.setVisible(true);
        System.out.println(image);
    }

    @FXML
    private void buttonSupprimer(ActionEvent event) {
        ServiceNourriture service = new ServiceNourriture();
        service.supprimerNourriture(IHM_Afficher_NourritureController.idn);
        Stage stage = (Stage) btnAnnuler.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void btnAnnuler(ActionEvent event) {
        Stage stage = (Stage) btnAnnuler.getScene().getWindow();
        stage.close();
    }

}
