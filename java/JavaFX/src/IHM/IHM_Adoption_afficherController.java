/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import entites.Adoption;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author houssem
 */         
public class IHM_Adoption_afficherController implements Initializable {


    /**
     * Initializes the controller class.
     */
    
   
    @FXML
    private TextField search;
    @FXML
    private TableView<Adoption> adoption;
    @FXML
    private TableColumn<Adoption, String> description;
 
    @FXML
    TableColumn<Adoption, String> type ;
    @FXML
    TableColumn<Adoption, String> lieu ;
    @FXML
    
    
    private Stage dialoge;
                
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
Adoption ad =new Adoption();


        for (Adoption adp : ad.selectAll()) {
            
      adoption.getItems().add(adp);
      		type.setCellValueFactory(new PropertyValueFactory<>("type"));
                lieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
      		description.setCellValueFactory(new PropertyValueFactory<>("description"));
      		

           
        }

         
    }    

    @FXML
    private void retour(ActionEvent event) throws IOException {
        
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("IHM_Adoption.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(new Scene(root1));  
                stage.show();
        
    }
    
}
