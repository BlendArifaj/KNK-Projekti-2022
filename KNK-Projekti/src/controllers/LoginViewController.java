package controllers;


import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import processor.LoginProcessor;

public class LoginViewController implements Initializable {
	private LoginProcessor loginProcessor;
	
	public LoginViewController() {
		loginProcessor = new LoginProcessor();
	}
	
	@FXML
	private TextField txtUsername;
	
	@FXML
	private PasswordField pwfPassword;
	
	@FXML
	private Button loginButton;

	@FXML
	private MenuItem menuItemFile;
	
	@FXML
	private void loginEventHandler(ActionEvent ae) throws IOException, NoSuchAlgorithmException {
		String username = this.txtUsername.getText();
		String password = this.pwfPassword.getText();
		if(this.loginProcessor.isUserValid(username, password)) {
			this.loadHomePage((Node) ae.getSource());
		}
		// alert user

	}
	
	@FXML
	private void cancelEventHandler(ActionEvent e) {
		System.out.println("Cancel Event!");
	}
	
	@FXML
	private void resetPasswordEventHandler(ActionEvent e) {
		System.out.println("Reset password event!");
	}
	
	private void loadHomePage(Node source) throws IOException {
		FXMLLoader loader = new FXMLLoader(
				getClass().getResource("/views/HomeView.fxml")
				);
		Parent pane = loader.load();
		Scene scene = new Scene(pane, 640, 400);
		Stage primaryStage = (Stage) source.getScene().getWindow();
		primaryStage.setScene(scene);
	}

    @FXML
    private ChoiceBox roomType;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //loadTypes();
    }
}


