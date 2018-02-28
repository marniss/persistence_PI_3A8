/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;



import entites.CentreSoins;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.Rating;
import services.CSController;
import services.ListCSControler;

/**
 * FXML Controller class
 *
 * @author mossa
 */
public class IHM_ListCS implements Initializable {
  @FXML
    private TableView<CentreSoins> listCS;
  @FXML
    private TableColumn<CentreSoins, String> listnom;
  @FXML  
   private TableColumn<CentreSoins, String> listtype;
  @FXML
    private TableColumn<CentreSoins, String> listeadr;
  @FXML
    private TableColumn<CentreSoins, Integer> listetel;
  @FXML
    private TableColumn<CentreSoins, Double> listenote;
  @FXML
    private TableColumn<CentreSoins, Integer> listid;
    @FXML
    private TextField word;
  ListCSControler cs;
  @FXML
    private Rating evalCS;
   
   
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        affiche();
        // TODO
    }    

  @FXML
    private void recherche(KeyEvent event) {
         String keyword ;
       keyword=word.getText();
        cs= new ListCSControler();
        listCS.getItems().clear();
        for (CentreSoins ce : cs.selectAll(keyword)){
                listnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                listtype.setCellValueFactory(new PropertyValueFactory<>("type"));
                listeadr.setCellValueFactory(new PropertyValueFactory<>("adresse"));
                listetel.setCellValueFactory(new PropertyValueFactory<>("numero"));
                listenote.setCellValueFactory(new PropertyValueFactory<>("note"));
                listid.setCellValueFactory(new PropertyValueFactory<>("id"));
                listCS.getItems().add(ce);
            }
    }

    @FXML
    private void recherche(InputMethodEvent event) {
//         String keyword ;
//       keyword=word.getText();
//        cs= new ListCSControler();
//        listCS.getItems().clear();
//        for (CentreSoins ce : cs.selectAll(keyword)){
//                listnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
//                listtype.setCellValueFactory(new PropertyValueFactory<>("type"));
//                listeadr.setCellValueFactory(new PropertyValueFactory<>("adresse"));
//                listetel.setCellValueFactory(new PropertyValueFactory<>("numero"));
//                listenote.setCellValueFactory(new PropertyValueFactory<>("note"));
//                listCS.getItems().add(ce);
//            }
    }

    @FXML
    private void evaluer(MouseEvent event) {
        double eval= evalCS.getRating();
//        eval=Math.(eval);
////        String format=String.format("%.2f",eval);
////         eval = Double.parseDouble(format);
////            System.out.println(eval);
        CSController cdc=new CSController(listCS.getSelectionModel().getSelectedItem().getId(), 
                listCS.getSelectionModel().getSelectedItem().getNom(), 
                listCS.getSelectionModel().getSelectedItem().getType(), 
                listCS.getSelectionModel().getSelectedItem().getAdresse(), 
                listCS.getSelectionModel().getSelectedItem().getNumero(), 
                eval);
        cdc.majNote();
        affiche();
        evalCS.setDisable(true);
    }
    public void affiche()
    {
     cs= new ListCSControler();
        listCS.getItems().clear();
        for (CentreSoins ce : cs.selectAll()){
                listnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                listtype.setCellValueFactory(new PropertyValueFactory<>("type"));
                listeadr.setCellValueFactory(new PropertyValueFactory<>("adresse"));
                listetel.setCellValueFactory(new PropertyValueFactory<>("numero"));
                listenote.setCellValueFactory(new PropertyValueFactory<>("note"));
                listCS.getItems().add(ce);
            }
    }

    @FXML
    private void selection(MouseEvent event) {
        evalCS.setDisable(false);
        evalCS.setRating(listCS.getSelectionModel().getSelectedItem().getNote());
    }

    @FXML
    private void exportPDF(MouseEvent event) {
    }
    
}
