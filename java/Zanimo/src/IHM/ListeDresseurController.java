/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import com.lynden.gmapsfx.service.geocoding.GeocoderStatus;
import com.lynden.gmapsfx.service.geocoding.GeocodingResult;
import com.lynden.gmapsfx.service.geocoding.GeocodingService;
import entites.ListeDesDresseurs;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.controlsfx.control.Rating;
import services.ControlleurListeDresseur;

/**
 * FXML Controller class
 *
 * @author pc asus
 */
public class ListeDresseurController implements Initializable, MapComponentInitializedListener {

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
    @FXML
    private Label nomvet;
    @FXML
    private Label note;
    @FXML
    private Button valide;
    public static int iddd = 1;
    @FXML
    private Rating rateDress;
    Float not;
    private int idnote;
    @FXML
    private AnchorPane mapGoogle;
    @FXML
    private Button mapi;
    private GoogleMap map;
    @FXML
    private GoogleMapView gmap;
    private GeocodingService G;
    ArrayList<ListeDesDresseurs> listedesdreArrayList = cld.displayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        rateDress.setDisable(true);

        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        tel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
        photo.setCellValueFactory(new PropertyValueFactory<>("photo"));

        listedress.getItems().addAll(listedesdreArrayList);

        listedress.setOnMouseClicked(
        (event) -> {
            if (event.getClickCount() == 2) {
                ListeDresseurController.iddd = listedress.getItems().get(listedress.getSelectionModel().getSelectedIndex()).getId();
                nomvet.setText(listedress.getItems().get(listedress.getSelectionModel().getSelectedIndex()).getNom());
                idnote = listedress.getItems().get(listedress.getSelectionModel().getSelectedIndex()).getId_note();
                note.setText("" + cld.getLaNote(iddd));
                rateDress.setDisable(false);
                rateDress.setRating(cld.getLaNote(iddd));
                mapGoogle.setVisible(true);
                mapInitialized();
            }
        }
        );
    }

    public void createMap() {
        map = new GoogleMap();
        G = new GeocodingService();
        MapOptions mapOptions = new MapOptions();
        mapOptions.center(new LatLong(33.8869, 9.5375))
        .mapType(MapTypeIdEnum.ROADMAP)
        .overviewMapControl(true)
        .panControl(true)
        .rotateControl(true)
        .scaleControl(true)
        .streetViewControl(true)
        .zoomControl(true)
        .zoom(15);

        map = gmap.createMap(mapOptions);
    }

    @FXML
    private void valider(ActionEvent event) {
        Float x = (cld.getLaNote(iddd) + not) / 2;
        System.out.println(x);
        cld.affecternote(x);
        rateDress.setDisable(true);
        ref();

    }

    @FXML
    private void evaldress(MouseEvent event
    ) {
        not = (float) rateDress.getRating();
    }

    @Override
    public void mapInitialized() {
        try {

            createMap();
            ListeDesDresseurs e = listedress.getSelectionModel().getSelectedItem();
            String L = e.getAdresse();
            System.out.println(L);

            G.geocode(L, (GeocodingResult[] results, GeocoderStatus status) -> {
                LatLong latLong = null;

                if (status == GeocoderStatus.ZERO_RESULTS) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "No matching address found");
                    alert.show();
                    return;
                } else if (results.length > 1) {
                    Alert alert = new Alert(Alert.AlertType.WARNING, "Multiple results found, showing the first one.");
                    alert.show();
                    latLong = new LatLong(results[0].getGeometry().getLocation().getLatitude(), results[0].getGeometry().getLocation().getLongitude());
                } else {
                    latLong = new LatLong(results[0].getGeometry().getLocation().getLatitude(), results[0].getGeometry().getLocation().getLongitude());
                    MarkerOptions markerOptions = new MarkerOptions();
                    System.out.println("result LG " + latLong.getLongitude() + "   " + latLong.getLatitude());
                    markerOptions.position(latLong)
                    .visible(Boolean.TRUE)
                    .title("My Marker");

                    Marker marker = new Marker(markerOptions);
                    map.addMarker(marker);

                }

                map.setCenter(latLong);
            }
            );
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @FXML
    private void mapi(ActionEvent event) {
        mapGoogle.setVisible(true);
        mapInitialized();
    }

    public void ref() {
        listedress.getItems().clear();
        listedress.getItems().addAll(cld.displayList());
    }
}
