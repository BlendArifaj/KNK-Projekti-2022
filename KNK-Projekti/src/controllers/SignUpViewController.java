package controllers;


import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.DTO.CreateUserDTO;
import processor.SignUpProcessor;

public class SignUpViewController {
	private SignUpProcessor signUpProcessor;
	
	public SignUpViewController() {
		signUpProcessor = new SignUpProcessor();
	}
	
	@FXML
	private TextField txtEmri;
	
	@FXML
	private TextField txtMbiemri;
	
	@FXML
	private PasswordField pwdPassword;
	
	@FXML
	private PasswordField pwdConfirmPassword;

	@FXML
	private TextField txtEmail;
	
	@FXML
	private void signUpEventHandler(ActionEvent ae) throws IOException, NoSuchAlgorithmException {
		String emri = txtEmri.getText();
		String mbiemri = txtMbiemri.getText();
		String password = pwdPassword.getText();
		String confirmPassword = pwdConfirmPassword.getText();
		String email = txtEmail.getText();
		
		//valido
		if(!password.equals(confirmPassword)) {
			// show an alert 
			return;
		}
		
		CreateUserDTO dtoObject = new CreateUserDTO(
				emri, mbiemri, password, confirmPassword, email);
		
		if(this.signUpProcessor.createNewUser(dtoObject)) {
			this.loadLoginPage((Node) ae.getSource());
		}else {
			// show an alert 
		}
		
	}
	
	@FXML
	private void cancelEventHandler(ActionEvent e) throws IOException {
		this.loadLoginPage((Node) e.getSource());
	}

	
	private void loadLoginPage(Node source) throws IOException {
		FXMLLoader loader = new FXMLLoader(
				getClass().getResource("/views/LoginView.fxml")
				);
		Parent pane = loader.load();
		Scene scene = new Scene(pane, 640, 400);
		Stage primaryStage = (Stage) source.getScene().getWindow();
		primaryStage.setScene(scene);
	}
}


