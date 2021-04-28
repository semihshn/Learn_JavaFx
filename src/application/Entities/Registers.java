package application.Entities;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class Registers {
	private int id;
	private String userName;
	private double average;
	
	private CheckBox status;
	private TextField textField;
	private Button button;
	
	public Registers() {
		// TODO Auto-generated constructor stub
	}
	
	public Registers(int id,String userName,double average,String content,Button button) {
		// TODO Auto-generated constructor stub
		
		this.id=id;
		this.userName=userName;
		this.average=average;
		
		this.status=new CheckBox();
		this.textField=new TextField();
		this.textField.setText(content);
		
		this.button=button;
		this.button.setText("Mesaj Yolla");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public CheckBox getStatus() {
		return status;
	}

	public void setStatus(CheckBox status) {
		this.status = status;
	}

	public TextField getTextField() {
		return textField;
	}

	public void setTextField(TextField textField) {
		this.textField = textField;
	}

	public Button getButton() {
		return button;
	}

	public void setButton(Button button) {
		this.button = button;
	}
	
	

}
