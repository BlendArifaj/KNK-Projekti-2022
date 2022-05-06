package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class HomeViewController implements Initializable {

	@FXML 
	public void handleCreateStudentMenuClick(ActionEvent ae) {
		//Implement logic when you click on Menu
		System.out.println("Keni klikuar ne opsionin 'Create'");
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Metoda e cila ekzekutohet pasi qe te krijohen elementet ne pjesen e UI
	}
}	
