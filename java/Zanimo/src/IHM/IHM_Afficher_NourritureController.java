/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import entites.Nourriture;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
public class IHM_Afficher_NourritureController implements Initializable {

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
    public static int idn=0;
    @FXML
    private Button btnmodifier;
    @FXML
    private Button homebtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ServiceNourriture service = new ServiceNourriture();
        Nourriture temp = service.getNourriture(idn);
        
        nom.setText(temp.getNom());
        nom.setEditable(false);
        nom.setMouseTransparent(true);
        nom.setFocusTraversable(false);
        
        idmembre.setText("Identifiant membre :         "+temp.getIdMembre()); 
        
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
        
        datefab.setText(""+temp.getDateFabricationNourriture());
        datefab.setEditable(false);
        datefab.setMouseTransparent(true);
        datefab.setFocusTraversable(false);

        datelim.setText(""+temp.getDateLimiteNourriture());
        datelim.setEditable(false);
        datelim.setMouseTransparent(true);
        datelim.setFocusTraversable(false);
        
        madate.setText(""+temp.getDatePublication());
        madate.setEditable(false);
        madate.setMouseTransparent(true);
        madate.setFocusTraversable(false);
        
        
        File file ;
        if(temp.getPhoto().length()==0){
            file = new File("src/data/0.jpg");
        }
        else{
            file = new File(temp.getPhoto());
        }
        
        Image image = new Image(file.toURI().toString());
        imgproduit.setImage(image);
        imgproduit.setVisible(true);
        System.out.println(image);
    }    

    @FXML
    private void onclickmodifier(ActionEvent event) {
        try{
                Stage stage = (Stage) btnmodifier.getScene().getWindow();
                stage.close();
  
                Parent root = FXMLLoader.load(getClass().getResource("IHM_Modifier_Nourriture.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }catch(IOException o){
                o.getMessage();
            }
    }

    @FXML
    private void onclicksupprimer(ActionEvent event) {
        try{
                Stage stage = (Stage) btnmodifier.getScene().getWindow();
                stage.close();
                
                Parent root = FXMLLoader.load(getClass().getResource("IHM_Supprimer_Nourriture.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }catch(IOException o){
                o.getMessage();
            }
    }

    @FXML
    private void onclickback(ActionEvent event) {
        try {
            Stage stage = (Stage) homebtn.getScene().getWindow();
            stage.close();
            
            homebtn.getScene().setRoot(FXMLLoader.load(getClass().getResource("IHM_Listing_Nourriture.fxml")));
        } catch (Exception e) {
            System.out.println("backbutton error");
            System.out.println(e.getMessage());
        }        
    }
    
}
