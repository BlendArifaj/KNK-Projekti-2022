package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BarChartExperiments extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("BarChart FIEK");

        CategoryAxis xAxis    = new CategoryAxis();
        xAxis.setLabel("Fakulteti");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Numri i studenteve");

        BarChart barChart = new BarChart(xAxis, yAxis);
        //PieChart pieChart = new PieChart()

        // shtimi i nje serie
        XYChart.Series dataSeries1 = new XYChart.Series();
        dataSeries1.setName("2014");

        dataSeries1.getData().add(new XYChart.Data("FIEK", 567));
        dataSeries1.getData().add(new XYChart.Data("FNA"  , 65));
        dataSeries1.getData().add(new XYChart.Data("FIM"  , 23));

        barChart.getData().add(dataSeries1);
        
        
        XYChart.Series dataSeries2 = new XYChart.Series();
        dataSeries2.setName("2015");

        dataSeries2.getData().add(new XYChart.Data("FIEK", 57));
        dataSeries2.getData().add(new XYChart.Data("FNA"  , 651));
        dataSeries2.getData().add(new XYChart.Data("FIM"  , 25));
        
        barChart.getData().add(dataSeries2);

        VBox vbox = new VBox(barChart);

        Scene scene = new Scene(vbox, 400, 200);

        primaryStage.setScene(scene);
        primaryStage.setHeight(300);
        primaryStage.setWidth(1200);

        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}