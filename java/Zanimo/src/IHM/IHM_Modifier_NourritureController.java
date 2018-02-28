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
public class IHM_Modifier_NourritureController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField quantite;
    @FXML
    private TextField prix;
    @FXML
    private TextField type;
    @FXML
    private TextField datelim;
    @FXML
    private TextArea description;
    @FXML
    private ImageView imgproduit;
    @FXML
    private Label idmembre;
    @FXML
    private TextField madate;
    @FXML
    private TextField datefab;
    @FXML
    private Button btnValider;
    @FXML
    private Button btnAnnuler;
    @FXML
    private Label idddd;
    @FXML
    private Button homebtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ServiceNourriture service = new ServiceNourriture();
        Nourriture temp = service.getNourriture(IHM_Afficher_NourritureController.idn);

        nom.setText(temp.getNom());

        idmembre.setText("Identifiant membre :         " + temp.getIdMembre());

        description.setText(temp.getDescription());

        quantite.setText("" + temp.getQteStock());

        prix.setText("" + temp.getPrix());

        type.setText(temp.getType());

        datefab.setText("" + temp.getDateFabricationNourriture());
        datefab.setEditable(false);
        datefab.setMouseTransparent(true);
        datefab.setFocusTraversable(false);

        datelim.setText("" + temp.getDateLimiteNourriture());
        datelim.setEditable(false);
        datelim.setMouseTransparent(true);
        datelim.setFocusTraversable(false);

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
    }

    @FXML
    private void btnValider(ActionEvent event) {
        ServiceNourriture monservice = new ServiceNourriture();
        monservice.modifierNourriture(IHM_Afficher_NourritureController.idn, "" + nom.getText(), "" + description.getText(), Float.parseFloat(prix.getText()), Integer.parseInt(quantite.getText()), "" + type.getText());
    }

    @FXML
    private void btnAnnuler(ActionEvent event) {
        Stage stage = (Stage) homebtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void onclickback(ActionEvent event) {
        Stage stage = (Stage) homebtn.getScene().getWindow();
        stage.close();
    }

}
