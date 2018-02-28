package IHM;

import entites.sosDisparition;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import services.DataSource;
import services.ServiceEmail;



/**
 * FXML Controller class
 *
 * @author salah
 */

//    **************************************************************************************************************
//    *                                IHM_LIST_SosController                                                                         *
//    **************************************************************************************************************
public class IHM_List_SosController implements Initializable {
    sosDisparition s = new sosDisparition();
    ObservableList<sosDisparition> sos = FXCollections.observableArrayList(s.selectAll());
    
        @FXML private TableView<sosDisparition> tab;
        @FXML TableColumn<sosDisparition, String> idsos;
        TableColumn<sosDisparition, String> idmem;
        @FXML private Button modifier; 
        @FXML private Button supprimer;
     
        @FXML private TableColumn<sosDisparition, String> nom;
        @FXML private TextField new_name;
        @FXML private TableColumn<sosDisparition, String> num;
        @FXML private TextField new_num_tel;
        @FXML private TextField chercheField;
        @FXML private TableColumn<?, ?> description;
        @FXML private TextField new_description;
    @FXML
    private TableColumn<sosDisparition, String> email;
    @FXML
    private TextField new_email;
    @FXML
    private AnchorPane AnchorPane;
    public static String mm;
    @FXML
    private TableColumn<sosDisparition, String> adresse;
    @FXML
    private TextField new_adresse;
    @FXML
    private Button mapi;
public static  String mai;

    

//*************************************************************************************************************
//*                                          INITIALIZE                                                                                   *
//*************************************************************************************************************
   @Override
  public void initialize(URL url, ResourceBundle rb) {
      
    
      
           sosDisparition s = new sosDisparition();
      
    s.selectAll().stream().map((e) -> {
            idsos.setCellValueFactory(new PropertyValueFactory<>("idSosDisparition"));
            return e;
        
        }).map((e) -> {
            nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            return e;
        }).map((e) -> { 
            num.setCellValueFactory(new PropertyValueFactory<>("num_tel"));
            return e;
        }).map((e) ->{
            description.setCellValueFactory(new PropertyValueFactory<>("description"));
            return e;
        }).map((e) ->{
            email.setCellValueFactory(new PropertyValueFactory<>("email"));
            return e;
        }).map((e) -> {
            adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
            return e;
        }).forEachOrdered((e) -> {
            tab.getItems().addAll(e);
        });
    
    initial();   
}


private void initial (){
        FilteredList<sosDisparition> filteredData = new FilteredList<>(  sos, p -> true);
        chercheField.textProperty().addListener((observable, oldValue, newValue) -> {
        filteredData.setPredicate(ev -> {    
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                    try {
                        if (ev.getNom().toLowerCase().contains(lowerCaseFilter)) {
                            return true;
                         } else if (ev.getNom().contains(lowerCaseFilter)) {
                             return true; 
                            } 
                        if (ev.getDescription().toLowerCase().contains(lowerCaseFilter)) {
                            return true;
                         } else if (ev.getDescription().contains(lowerCaseFilter)) {
                             return true; 
                            }
                         if (Integer.toString(ev.getNum_tel()).contains(lowerCaseFilter)) {
                            return true;
                         } 
                         
                             
                            
                        
                        return false; 
                     } catch (NullPointerException ex) {
                    System.out.println(ex.toString());
                        }
                        return false;
                    });
            });
   
        SortedList<sosDisparition> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tab.comparatorProperty());
        tab.setItems(sortedData);
}
    
    
 
//    *************************************************************************************************************
//    *                                          ACTUALISER                                                                                       *
//    *************************************************************************************************************
  
    
private void ref(){
    sos.clear();
    sos.addAll(s.selectAll());
    tab.setItems(sos);
} 
                
                
                
///    *************************************************************************************************************
///    *                           MODIFIER                                                                                         *
///    *************************************************************************************************************
    @FXML
    private void modifier(ActionEvent event) {
       DataSource conn=DataSource.getInstance();
       sosDisparition s=new sosDisparition();
            
             
           String name = new_name.getText();
            String num_tel = new_num_tel.getText();
             String description = new_description.getText();
              String email = new_email.getText();
              String adresse =new_adresse.getText();
             
              int id =tab.getSelectionModel().getSelectedItem().getIdSosDisparition();
              
                String sql="UPDATE `sos_disparition` SET `nom`='"+new_name.getText()+"',`num_tel`="+new_num_tel.getText()+ ",`description`='"+new_description.getText()+"',`email`='"+new_email.getText()+"',`adresse`='"+new_adresse.getText()+"' where id_sos_disparition="+id;
               
            try {
                Statement prep = conn.getConnection().createStatement(); 
                prep.executeUpdate(sql);
                ref();
                System.out.println("update done");
                System.out.println(sql); 
              } catch (SQLException ex) {
                  System.out.println("update error   "+ex.getCause()+"/n"+sql);
                 }
 
    }
  
  
       
    

     
    
//    *************************************************************************************************************
//    *                                                 SUPPRIMER                                                                                        *
//    *************************************************************************************************************
    
    @FXML
    private void supprimer(ActionEvent event) {
           sosDisparition s = new sosDisparition();
           int id =tab.getSelectionModel().getSelectedItem().getIdSosDisparition();
           s.supprimer(id);
           tab.getSelectionModel().clearSelection();
           tab.getItems().remove(sos);
           Alert al =new Alert (Alert.AlertType.INFORMATION);
           al.setTitle("INFORMATION");
           al.setHeaderText(null);
           al.setContentText("Publication supprimée");
           al.showAndWait();
           ref();     
    }

//    *************************************************************************************************************
//    *                                         REMPLIRE LES CHAMPS
//    *************************************************************************************************************
    @FXML
    private void fill(MouseEvent event) {
        
      
        String n=String.valueOf(tab.getSelectionModel().getSelectedItem().getNom());
        String nu=String.valueOf( tab.getSelectionModel().getSelectedItem().getNum_tel());
        String d=String.valueOf( tab.getSelectionModel().getSelectedItem().getDescription());
        String e=String.valueOf(tab.getSelectionModel().getSelectedItem().getEmail());
        String a=String.valueOf(tab.getSelectionModel().getSelectedItem().getAdresse());
        new_adresse.setText(a);
        new_email.setText(e);
        
        new_description.setText(d);
     

        new_name.setText(n );
        new_num_tel.setText(nu);
    }

//    *************************************************************************************************************
//    *                                         ENVOYER UN MAIL
//    *************************************************************************************************************
    
    @FXML
    private void envoyerMail(ActionEvent event) throws IOException {
        sosDisparition sd =new sosDisparition();
        this.mm = tab.getSelectionModel().getSelectedItem().getEmail();
        System.out.println(mm+"kjhgkjhjk");
         Parent parent = FXMLLoader.load(getClass().getResource("IHM_sendMail_SOS.fxml"));
            Stage stage = new Stage();

            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();

    }

    @FXML
    private void mapp(ActionEvent event) throws IOException {
        mai=tab.getSelectionModel().getSelectedItem().getAdresse();
         Parent parent = FXMLLoader.load(getClass().getResource("Map.fxml"));
          Stage stage = new Stage();

            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
    }
    
    
    
    
}
