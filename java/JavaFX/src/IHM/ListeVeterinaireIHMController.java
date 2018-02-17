/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import entites.ListeDesVetirinaires;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import services.ControlleurListeVeterinaire;

/**
 * FXML Controller class
 *
 * @author pc asus
 */
public class ListeVeterinaireIHMController implements Initializable {

    @FXML
    private TableView<ListeDesVetirinaires> listeVeterinaires;
    @FXML
    private TableColumn<ListeDesVetirinaires, String> colNom;
    @FXML
    private TableColumn<ListeDesVetirinaires, String> colPrenom;
    @FXML
    private TableColumn<ListeDesVetirinaires, String> colTel;
    @FXML
    private TableColumn<ListeDesVetirinaires, String> colAdress;
    @FXML
    private TableColumn<ListeDesVetirinaires, String> colMail;
    @FXML
    private TableColumn<ListeDesVetirinaires, String> colPhoto;


    /*
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        ControlleurListeVeterinaire clv = new ControlleurListeVeterinaire();
        ArrayList<ListeDesVetirinaires> listeDesVetirinaires = clv.displayList();

        colNom.setCellValueFactory(new PropertyValueFactory("nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory("prenom"));
        colTel.setCellValueFactory(new PropertyValueFactory("tel"));
        colAdress.setCellValueFactory(new PropertyValueFactory("adresse"));
        colMail.setCellValueFactory(new PropertyValueFactory("mail"));
        colPhoto.setCellValueFactory(new PropertyValueFactory("photo"));
        for (ListeDesVetirinaires l : listeDesVetirinaires) {
            System.out.println(l);
            listeVeterinaires.getItems().addAll(l);
        }
    }

}
