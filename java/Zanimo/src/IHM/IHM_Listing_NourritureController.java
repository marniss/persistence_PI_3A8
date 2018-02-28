/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import entites.Accessoire;
import entites.Nourriture;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import services.ServiceAccessoire;
import services.ServiceNourriture;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class IHM_Listing_NourritureController implements Initializable {

    @FXML
    private TableView<Nourriture> tbv;
    @FXML
    private TableColumn<Nourriture, String> id;
    @FXML
    private TableColumn<Nourriture, String> titre;
    @FXML
    private TableColumn<Nourriture, String> cate;
    @FXML
    private TableColumn<Nourriture, String> prix;
    @FXML
    private TableColumn<Nourriture, String> quan;
    @FXML
    private TableColumn<Nourriture, String> datepub;
    @FXML
    private TableColumn<Nourriture, String> vali;
    @FXML
    private TableColumn<Nourriture, String> des;
    @FXML
    private Button homebtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ServiceNourriture services = new ServiceNourriture();
        ArrayList<Nourriture> temp = services.listingNourriture();

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        titre.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        cate.setCellValueFactory(new PropertyValueFactory<>("dateFabricationNourriture"));
        prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        quan.setCellValueFactory(new PropertyValueFactory<>("qteStock"));
        datepub.setCellValueFactory(new PropertyValueFactory<>("datePublication"));
        des.setCellValueFactory(new PropertyValueFactory<>("description"));
        vali.setCellValueFactory(new PropertyValueFactory<>("validitePublication"));

        for (Nourriture e : temp) {
            tbv.getItems().addAll(e);
        }
        tbv.setOnMouseClicked((event) -> {
            if (event.getClickCount() == 2) {
                IHM_Afficher_NourritureController.idn = tbv.getItems().get(tbv.getSelectionModel().getSelectedIndex()).getId();
                try {
                    Stage stage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("IHM_Afficher_Nourriture.fxml"));
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException o) {
                    o.getMessage();
                }
            }

        });

    }

    @FXML
    private void onclickback(ActionEvent event) {
        try {
            Stage stage = (Stage) homebtn.getScene().getWindow();
            stage.close();
        } catch (Exception e) {
            System.out.println("backbutton error");
            System.out.println(e.getMessage());
        }
    }

}
