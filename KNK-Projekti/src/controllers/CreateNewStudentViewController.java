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
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.Student;
import repository.StudentRepository;
import utilities.I18N;

public class CreateNewStudentViewController implements Initializable{
	private StudentRepository repository;
	
	public CreateNewStudentViewController() {
		this.repository = new StudentRepository();
	}
	
	@FXML
	private TextField txtEmri;
	
	@FXML
	private TextField txtMbiemri;

	@FXML
	private TextField txtVitiRegjitrimit;
	
	@FXML
	private TextField txtQyteti;
	
	@FXML
	private Button btnClick;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//I18N
		this.btnClick.textProperty().bind(I18N.createStringBinding("button.click_button"));
		
	}
	
	@FXML
	private void handleEnterAction(KeyEvent ke) throws IOException, NoSuchAlgorithmException {
		if(ke.getCode().equals(KeyCode.ENTER)) {
			createNewStudent((Node) ke.getSource());
		}

	}
	
	@FXML
	private void handleCreateEvent(ActionEvent e) throws IOException {
		createNewStudent((Node) e.getSource());
	}
	
	@FXML
	private void handleCancelEvent(ActionEvent e) throws IOException {
		//mbyll formen 
		loadHomePage((Node) e.getSource());
		
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
	
	private void createNewStudent(Node source) throws IOException {
		String emri = this.txtEmri.getText();
		String mbiemri = this.txtMbiemri.getText();
		int mosha = 20;
		Student newStudent = Student.getInstance(emri, mbiemri, mosha);
		
		boolean inserted = this.repository.create(newStudent);
		
		if(inserted) {
			loadHomePage(source);
		}else {
			// Alert: insert failed!
		}
		
	}


}


