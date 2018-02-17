/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import entites.ListeDesDresseurs;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import services.ControlleurListeDresseur;

/**
 * FXML Controller class
 *
 * @author pc asus
 */
public class ListeDresseurController implements Initializable {

    @FXML
    private TableView<ListeDesDresseurs> listedress;
    @FXML
    private TableColumn<ListeDesDresseurs, String> nom;
    @FXML
    private TableColumn<ListeDesDresseurs, String> prenom;
    @FXML
    private TableColumn<ListeDesDresseurs, String> tel;
    @FXML
    private TableColumn<ListeDesDresseurs, String> adresse;
    @FXML
    private TableColumn<ListeDesDresseurs, String> mail;
    @FXML
    private TableColumn<ListeDesDresseurs, String> photo;
    ControlleurListeDresseur cld = new ControlleurListeDresseur();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        ArrayList<ListeDesDresseurs> listedesdreArrayList = cld.displayList();
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        tel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
        photo.setCellValueFactory(new PropertyValueFactory<>("photo"));

        for (ListeDesDresseurs dre : listedesdreArrayList) {
            System.out.println(dre);
            listedress.getItems().addAll(dre);
        }
    }

}
