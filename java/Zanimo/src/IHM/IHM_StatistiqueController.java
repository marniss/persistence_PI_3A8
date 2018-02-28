/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import entites.Concour;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author angham
 */
public class IHM_StatistiqueController implements Initializable {

    @FXML
    private Pane PaneView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadDataBarChart();
    }

    private void loadDataBarChart() {
        System.out.println("ooooooooooooooooooooooooooooooooooooooo");

        PaneView.getChildren().clear();
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Concours");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Pourcentage de participations (%) ");
        BarChart statsChart = new BarChart(xAxis, yAxis);
        statsChart.setTitle("Statitisques Concours");
        XYChart.Series series = new XYChart.Series();
        series.setName("stats concours");

        Concour concour = new Concour();

        List<Concour> statsConcours = concour.selectStatistiques();

        System.out.println(statsChart);

        for (Concour l : statsConcours) {
            series.getData().add(new XYChart.Data<>(l.getNomConcourStat(), l.getPourcentagestats()));
        }
        /*series.getData().add(new XYChart.Data<>("course", 14));
        series.getData().add(new XYChart.Data<>("beaute", 5));
        series.getData().add(new XYChart.Data<>("danse", 9));
        series.getData().add(new XYChart.Data<>("jeu", 20));*/

        statsChart.getData().add(series);
        PaneView.getChildren().add(statsChart);

    }

}
