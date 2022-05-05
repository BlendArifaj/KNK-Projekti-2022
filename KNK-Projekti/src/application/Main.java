package application;
	
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import processor.GenerateHash;
import utilities.I18N;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) throws IOException {
	

	    
		FXMLLoader loader = new FXMLLoader(
				getClass().getResource("/views/LoginView.fxml")
				);
		
		Parent pane = loader.load();
		
		Scene scene = new Scene(pane, 640, 400);

		primaryStage.titleProperty().bind(I18N.createStringBinding("window.title"));
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
