/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import entites.CentreDressage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import services.ListCDControler;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.Rating;
import services.CDController;
import com.lynden.gmapsfx.*;
import com.lynden.gmapsfx.javascript.object.*;
import com.lynden.gmapsfx.javascript.event.EventHandlers;
import com.lynden.gmapsfx.javascript.event.MapStateEventType;
import com.lynden.gmapsfx.service.directions.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.PerspectiveCamera;
import javafx.scene.shape.Circle;


/**
 * FXML Controller class
 *
 * @author mossa
 */
public class IHM_ListCD implements Initializable, MapComponentInitializedListener, DirectionsServiceCallback {
 protected DirectionsService directionsService;
    protected DirectionsPane directionsPane;

    @FXML
    private TableView<CentreDressage> listCD;
    @FXML
    private TableColumn<CentreDressage, String> listnom;
    @FXML
    private TableColumn<CentreDressage, String> listtype;
    @FXML
    private TableColumn<CentreDressage, String> listeadr;
    @FXML
    private TableColumn<CentreDressage, Integer> listetel;
    @FXML
    private TableColumn<CentreDressage, Double> listenote;
    @FXML
    private TableColumn<CentreDressage, Integer> listid;
    @FXML
    private TextField word;
    @FXML
    private Rating evalCD;
    @FXML
    private GoogleMapView m;
    GoogleMap g;
    @FXML
    private Circle pointeur;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        affiche();
        m.addMapInializedListener(this);
    }    
    
  @Override
    public void mapInitialized() {
    MapOptions options = new MapOptions();

        options.center(new LatLong(36.8189700, 10.1657900))
                .mapType(MapTypeIdEnum.ROADMAP)
                .overviewMapControl(true)
                .panControl(false)
                .rotateControl(false)
                .scaleControl(true)
                .streetViewControl(false)
                .zoomControl(true)
                .mapMaker(true)
                .zoom(5);
        
         g= m.createMap(options);
    }
    
    @FXML
    private void recherche(KeyEvent event) {
       String keyword ;
       keyword=word.getText();
         ListCDControler cd= new ListCDControler();
        listCD.getItems().clear();
        for (CentreDressage ce : cd.selectAll(keyword)){
            Rating r=new Rating(5);
            
                listnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                listtype.setCellValueFactory(new PropertyValueFactory<>("type"));
                listeadr.setCellValueFactory(new PropertyValueFactory<>("adresse"));
                listetel.setCellValueFactory(new PropertyValueFactory<>("numero"));
                listenote.setCellValueFactory(new PropertyValueFactory<>("note"));
                
                listCD.getItems().add(ce);
            }
    }


    @FXML
    private void selection(MouseEvent event) {
        evalCD.setDisable(false);
        evalCD.setRating(listCD.getSelectionModel().getSelectedItem().getNote());
        LatLong cord = null;
        cord=new LatLong(0,0);
        MarkerOptions Options = new MarkerOptions();
        Options.position(cord)
                        .visible(Boolean.TRUE)
                        .title("My Marker")
                .animation(Animation.BOUNCE);
                Marker marker = new Marker(Options);
          
         g.setCenter(cord);   
         
         g.setZoom(15); 
         g.addMarker(marker);
         
//           LatLong ll= marker.getClass().get
 pointeur.setVisible(false);
    }

    @FXML
    private void evaluer(MouseEvent event) {
        double eval= evalCD.getRating();
//        eval=Math.(eval);
//        String format=String.format("%.2f",eval);
//         eval = Double.parseDouble(format);
//            System.out.println(eval);
        CDController cdc=new CDController(listCD.getSelectionModel().getSelectedItem().getId(), 
                listCD.getSelectionModel().getSelectedItem().getNom(), 
                listCD.getSelectionModel().getSelectedItem().getType(), 
                listCD.getSelectionModel().getSelectedItem().getAdresse(), 
                listCD.getSelectionModel().getSelectedItem().getNumero(), 
                eval);
        cdc.majNote();
        affiche();
        evalCD.setDisable(true);
        
    }
    
    
    
    
    
    public void affiche()
    {  
        ListCDControler cd= new ListCDControler();
        listCD.getItems().clear();
        for (CentreDressage ce : cd.selectAll()){
               Rating r= new Rating();
               r.setRating(ce.getNote());
                listnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                listtype.setCellValueFactory(new PropertyValueFactory<>("type"));
                listeadr.setCellValueFactory(new PropertyValueFactory<>("adresse"));
                listetel.setCellValueFactory(new PropertyValueFactory<>("numero"));
                listenote.setCellValueFactory(new PropertyValueFactory<>("note"));
                listid.setCellValueFactory(new PropertyValueFactory<>("id"));
                
                listCD.getItems().add(ce);
            }
        evalCD.setRating(0);
      }

    @FXML
    private void exportPDF(MouseEvent event) {
    }

    

    @Override
    public void directionsReceived(DirectionsResult results, DirectionStatus status) {
    }

    @FXML
    private void localiser(MouseEvent event) {
     
    }

    @FXML
    private void cachep(MouseEvent event) {
       
    }
    public void centermark()
    {
    }
}
