package application;

import java.util.ArrayList;

import javafx.scene.chart.Axis;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class Main1 {
	public static void main(String[] args) {
		CustomBarChartProcessor processor = new CustomBarChartProcessor();
		ArrayList<XYChart.Series> series = processor.getSeries();
		
		Axis x = new CategoryAxis();
		x.setLabel("Fakulteti");
		
		Axis y = new NumberAxis();
		y.setLabel("Value");
		
		BarChart chart = new BarChart(x, y);
		chart.getData().addAll(series);
		
	}
}


class Stats {
	public String fakulteti;
	public int value;
	public int viti;
}


class StatsRepository {
	public ArrayList<Stats> findAll() {
		return null;
	}
}

class CustomBarChartProcessor {
	private StatsRepository statsRepository;
	
	
	public CustomBarChartProcessor() {
		this.statsRepository = new StatsRepository();
	}
	
	public ArrayList<XYChart.Series> getSeries(){
		ArrayList<XYChart.Series> series = new ArrayList<XYChart.Series>();
		ArrayList<Stats> allRecordsFromDB = this.statsRepository.findAll();
		XYChart.Series dataSeries1 = new XYChart.Series();
		XYChart.Series dataSeries2 = new XYChart.Series();

	    dataSeries1.setName("Viti pas 2000");
	    dataSeries2.setName("Viti para 2000");


		for(Stats s: allRecordsFromDB) {
			if(s.viti > 2000) {
				dataSeries1.getData().add(new XYChart.Data(s.fakulteti, s.value));
			}else {
				dataSeries2.getData().add(new XYChart.Data(s.fakulteti, s.value));
			}
		}
		
		series.add(dataSeries1);
		series.add(dataSeries2);

		return series;
	}
}






