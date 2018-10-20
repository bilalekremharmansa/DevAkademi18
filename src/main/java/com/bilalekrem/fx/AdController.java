package com.bilalekrem.fx;

import com.bilalekrem.endpoints.Ad;
import com.bilalekrem.analyzer.AdAnalyzer;
import com.bilalekrem.analyzer.GeneralAnalyzer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.util.Map;

public class AdController {

    @FXML
    private Label lbTitle;
    @FXML
    private Label lbDescription;
    @FXML
    private Label lbCallToAct;
    @FXML
    private Label lbKurus;
    @FXML
    private Label lbShowMax;
    @FXML
    private Label lbEventTypeInfo;

    @FXML
    private Pane tbCity;
    @FXML
    private Pane tbJob;
    @FXML
    private Pane tbAge;


    private Ad ad;

    public AdController(Ad ad) {
        this.ad = ad;
    }

    @FXML
    private void initialize() {
        lbTitle.setText(ad.getTitle());
        lbDescription.setText(ad.getDescription());
        lbCallToAct.setText(ad.getCallToAction());
        lbKurus.setText(ad.getBidPriceKurus() + "/" + ad.getDailyBidgetKurus());
        lbShowMax.setText("*This ad will be showed maximum " + AdAnalyzer.howManyAdCanBeListPerDay(ad.getId()) + " times per day.");

        AdAnalyzer adAnalyzer = new AdAnalyzer(GeneralAnalyzer.getAllDataByAdId(ad.getId())); // needs to be refreshed

        int clickedSize = adAnalyzer.getUsersClicked().size();
        int impressionSize = adAnalyzer.getUsersDidNotClick().size();
        String info = impressionSize + " people is impressed with this ad. However, only " + clickedSize + " of them clicked for the ad.";
        lbEventTypeInfo.setText(info.toString());

        /* Frequency of job chart */
        Map<String, Integer> jobs = adAnalyzer.getJobFreq();
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        for (Map.Entry<String, Integer> entry : jobs.entrySet()) {
            pieChartData.add(new PieChart.Data(entry.getKey(), entry.getValue()));
        }
        final PieChart chartJobs = new PieChart(pieChartData);
        chartJobs.setTitle("Jobs");

        tbJob.getChildren().add(chartJobs);

        /* Frequency of city chart */
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);
        Map<String, Integer>  cities = adAnalyzer.getCityFreq();

        XYChart.Series series = new XYChart.Series();
        series.setName("City chart");
        for (Map.Entry<String, Integer> entry : cities.entrySet()) {
            series.getData().add(new XYChart.Data(entry.getKey(), entry.getValue()));
        }
        lineChart.getData().add(series);
        tbCity.getChildren().add(lineChart);


        /* Frequency of age chart */
        Map<Integer, Integer> ages = adAnalyzer.getAgeFreq();
        ObservableList<PieChart.Data> pieChartAgeData = FXCollections.observableArrayList();
        for (Map.Entry<Integer, Integer> entry : ages.entrySet()) {
            pieChartAgeData.add(new PieChart.Data(entry.getKey()+"", entry.getValue()));
        }
        final PieChart chartAges = new PieChart(pieChartAgeData);
        chartAges.setTitle("Jobs");
        tbAge.getChildren().add(chartAges);


    }

}
