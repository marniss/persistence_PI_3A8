/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import entites.Accessoire;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import services.ServiceAccessoire;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class IHM_Modifier_AcessoireController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField quantite;
    @FXML
    private TextField prix;
    @FXML
    private TextField type;
    @FXML
    private TextField categorie;
    @FXML
    private TextArea description;
    @FXML
    private Button buttonValider;
    @FXML
    private ImageView imgproduit;
    @FXML
    private Label idmembre;
    @FXML
    private TextField madate;
    @FXML
    private Button buttonAnuler;
    @FXML
    private Button homebtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        ServiceAccessoire leservice = new ServiceAccessoire();
        Accessoire temp = leservice.getAccessoire(IHM_Afficher_AccessoireController.ida); 
        
        nom.setText(temp.getNom());
        idmembre.setText("Identifiant membre :         "+temp.getIdMembre()); 
        description.setText(temp.getDescription());
        quantite.setText(""+temp.getQteStock());
        prix.setText(""+temp.getPrix());
        type.setText(temp.getType());
        categorie.setText(""+temp.getCategorieAccessoire().getNom());
        categorie.setEditable(false);
        categorie.setMouseTransparent(true);
        categorie.setFocusTraversable(false);
        madate.setText(""+temp.getDatePublication());
        madate.setEditable(false);
        madate.setMouseTransparent(true);
        madate.setFocusTraversable(false);
        File file = new File(temp.getPhoto());
        Image image = new Image(file.toURI().toString());
        imgproduit.setImage(image);
        imgproduit.setVisible(true);
    }    

    @FXML
    private int buttonValider(ActionEvent event) {
        ServiceAccessoire leservice = new ServiceAccessoire();
        return leservice.modifierAccessoire(IHM_Afficher_AccessoireController.ida, nom.getText(), description.getText(), Float.parseFloat(prix.getText()), Integer.parseInt(quantite.getText()), type.getText(), 30);
    }

    @FXML
    private void btnAnnuler(ActionEvent event) {
        try {
            Stage stage = (Stage) homebtn.getScene().getWindow();
            stage.close();
            homebtn.getScene().setRoot(FXMLLoader.load(getClass().getResource("IHM_Listing_Accessoire.fxml")));
        } catch (Exception e) {
            System.out.println("backbutton error");
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void onclickback(ActionEvent event) {
        try {
            Stage stage = (Stage) homebtn.getScene().getWindow();
            stage.close();
            homebtn.getScene().setRoot(FXMLLoader.load(getClass().getResource("IHM_Listing_Accessoire.fxml")));
        } catch (Exception e) {
            System.out.println("backbutton error");
            System.out.println(e.getMessage());
        }
    }
    
}
