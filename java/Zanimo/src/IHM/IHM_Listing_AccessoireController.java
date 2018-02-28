/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import entites.*;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import services.ServiceAccessoire;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class IHM_Listing_AccessoireController implements Initializable {

    @FXML
    private TableView<Accessoire> tbv;
    @FXML
    private TableColumn<Accessoire, String> id;
    @FXML
    private TableColumn<Accessoire, String> titre;
    @FXML
    private TableColumn<Accessoire, String> cate;
    @FXML
    private TableColumn<Accessoire, String> prix;
    @FXML
    private TableColumn<Accessoire, String> quan;
    @FXML
    private TableColumn<Accessoire, String> datepub;
    @FXML
    private TableColumn<Accessoire, String> vali;
    @FXML
    private TableColumn<Accessoire, String> des;
    @FXML
    private Button homebtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        ServiceAccessoire services = new ServiceAccessoire();
        ArrayList<Accessoire> temp = services.listingAccessoire();

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        titre.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        cate.setCellValueFactory(new PropertyValueFactory<>("categorieAccessoire"));
        prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        quan.setCellValueFactory(new PropertyValueFactory<>("qteStock"));
        datepub.setCellValueFactory(new PropertyValueFactory<>("datePublication"));
        des.setCellValueFactory(new PropertyValueFactory<>("description"));
        vali.setCellValueFactory(new PropertyValueFactory<>("validitePublication"));
        for (Accessoire e : temp) {
            tbv.getItems().addAll(e);
        }
        tbv.setOnMouseClicked((event) -> {
            if (event.getClickCount() == 2) {
                IHM_Afficher_AccessoireController.ida = tbv.getItems().get(tbv.getSelectionModel().getSelectedIndex()).getId();
                try {
                    Stage stage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("IHM_Afficher_Accessoire.fxml"));
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
            homebtn.getScene().setRoot(FXMLLoader.load(getClass().getResource("IHM_Listing_Accessoire.fxml")));
        } catch (Exception e) {
            System.out.println("backbutton error");
            System.out.println(e.getMessage());
        }
    }

}
