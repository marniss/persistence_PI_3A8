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
public class IHM_Supprimer_AccessoireController implements Initializable {

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
        ServiceAccessoire leservice = new ServiceAccessoire();
        Accessoire temp = leservice.getAccessoire(IHM_Afficher_AccessoireController.ida); 
        
        nom.setText(temp.getNom());
        nom.setEditable(false);
        nom.setMouseTransparent(true);
        nom.setFocusTraversable(false);
        
        idmembre.setText("Identifiant membre :         "+temp.getIdMembre()); 
        iddd.setText(""+temp.getId());
        iddd.setVisible(false);
        
        description.setText(temp.getDescription());
        description.setEditable(false);
        description.setMouseTransparent(true);
        description.setFocusTraversable(false);

        quantite.setText(""+temp.getQteStock());
        quantite.setEditable(false);
        quantite.setMouseTransparent(true);
        quantite.setFocusTraversable(false);
        
        prix.setText(""+temp.getPrix()+"  DT");
        prix.setEditable(false);
        prix.setMouseTransparent(true);
        prix.setFocusTraversable(false);
        
        type.setText(temp.getType());
        type.setEditable(false);
        type.setMouseTransparent(true);
        type.setFocusTraversable(false);
        

        categorie.setText(""+temp.getCategorieAccessoire().getNom());
        categorie.setEditable(false);
        categorie.setMouseTransparent(true);
        categorie.setFocusTraversable(false);
        
        madate.setText(""+temp.getDatePublication());
        madate.setEditable(false);
        madate.setMouseTransparent(true);
        madate.setFocusTraversable(false);
        //imgproduit = new ImageView(new Image("aaa.jpg"));
        File file = new File(temp.getPhoto());
        Image image = new Image(file.toURI().toString());
        imgproduit.setImage(image);
        imgproduit.setVisible(true);
        
    }    

    @FXML
    private void buttonSupprimer(ActionEvent event) {
        ServiceAccessoire temp = new ServiceAccessoire();
        temp.supprimerAccessoire(Integer.parseInt(iddd.getText()));
        Stage stage = (Stage) btnAnnuler.getScene().getWindow();
        stage.close();
        
    }

    @FXML
    private void btnAnnuler(ActionEvent event) {
        Stage stage = (Stage) btnAnnuler.getScene().getWindow();
        stage.close();
    }
    
}
