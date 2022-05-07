package application;
	
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.ResourceBundle;

import database.DBConnect;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.DTO.CreateUserDTO;
import processor.GenerateHash;
import processor.SignUpProcessor;
import utilities.I18N;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) throws IOException, NoSuchAlgorithmException, SQLException {
	
		FXMLLoader loader = new FXMLLoader(
				getClass().getResource("/views/LoginView.fxml")
				);
		
		Parent pane = loader.load();
		
		Scene scene = new Scene(pane, 640, 400);

		primaryStage.titleProperty().bind(I18N.createStringBinding("window.title"));
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//Ndryshime i gjuhes gjate ekzekutimit te programi behet permes funksionet setLocale ne klasen I18N
		I18N.setLocale(Locale.GERMAN);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
