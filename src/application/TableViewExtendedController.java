package application;

import java.net.URL;
import java.util.ResourceBundle;

import application.Entities.Registers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class TableViewExtendedController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Registers> tableView;

    @FXML
    private TableColumn<Registers, Integer> col_id;

    @FXML
    private TableColumn<Registers, String> col_usrName;

    @FXML
    private TableColumn<Registers, Double> col_avg;

    @FXML
    private TableColumn<Registers, String> col_comit;

    @FXML
    private TableColumn<Registers, String> col_select;

    @FXML
    private TableColumn<Registers, String> col_transaction;

    @FXML
    private TextField txt_usrName;

    @FXML
    private TextField txt_psw;

    @FXML
    private Button btn_add;

    @FXML
    private Button btn_delete;

    @FXML
    private Button btn_update;

    @FXML
    private Button btn_show;

    @FXML
    private Button btn_showCommit;

    @FXML
    private Button btn_selected;
    
    ObservableList<Registers> data;
    Button[] buttons=new Button[10];
    int btnIndex=0;

    @FXML
    void btn_add_click(ActionEvent event) {
    	data=FXCollections.observableArrayList();
    	data.add(new Registers(btnIndex,txt_usrName.getText(),Double.parseDouble("0.5"),"Example Content",buttons[btnIndex]));
    	btnIndex++;
    	
    	tableView.getItems().addAll(data);
    }

    @FXML
    void btn_delete_click(ActionEvent event) {
    	ObservableList<Registers> selectedRegister,allRegisters;
    	allRegisters=tableView.getItems();
    	selectedRegister=tableView.getSelectionModel().getSelectedItems();
    	
    	selectedRegister.forEach(allRegisters::remove);
    }

    @FXML
    void btn_selected_click(ActionEvent event) {
    	//CeheckBox'ý seçilmiþ satýrlarýn deðerlerini alma
    	for (Registers temp : data) {
			if (temp.getStatus().isSelected()) {
				System.out.println(temp.getUserName()+" yorumu : "+temp.getTextField().getText());
			}
		}
    }

    @FXML
    void btn_showCommit_click(ActionEvent event) {
    	//Yorum girilmiþ satýrlar belirlenerek yorum deðerlerini alma
    	for (Registers temp : data) {
			if (!temp.getTextField().getText().isEmpty()) {
				System.out.println(temp.getUserName()+" yorumu : "+temp.getTextField().getText());
			}
		}
    }

    @FXML
    void btn_show_click(ActionEvent event) {
    	Registers register=new Registers();
    	if(tableView.getSelectionModel().getSelectedIndex()!=-1) {
    		register=(Registers) tableView.getItems().get(tableView.getSelectionModel().getSelectedIndex());
    		System.out.println("Seçilen kullanýcý : "+register.getUserName());
    	}else {
    		System.out.println("Herhangi bir kayýt seçili deðil.");
    	}
    }

    @FXML
    void btn_update_click(ActionEvent event) {
    	Registers register=new Registers();
    	if(tableView.getSelectionModel().getSelectedIndex()!=-1) {
    		register=(Registers) tableView.getItems().get(tableView.getSelectionModel().getSelectedIndex());
    		int id=register.getId();
    		
    		Registers temp=new Registers(id,txt_usrName.getText(),Double.parseDouble("0.5"),"Ýçerik güncellendi",buttons[id]);
    		int tblIndex=tableView.getSelectionModel().getSelectedIndex();
    		tableView.getItems().set(tblIndex, temp);
    		
    		System.out.println("Güncellenen kullanýcý : "+register.getUserName());
    	}else {
    		System.out.println("Herhangi bir kayýt seçili deðil.");
    	}
    }

    @FXML
    void tableView_click(MouseEvent event) {
    	Registers temp=new Registers();
    	temp=tableView.getItems().get(tableView.getSelectionModel().getSelectedIndex());
    	
    	txt_usrName.setText(temp.getUserName());;
    	txt_psw.setText(String.valueOf(temp.getAverage()));
    }

    @FXML
    void initialize() {
    	
    	for (int i = 0; i < buttons.length; i++) {
			buttons[i]=new Button();
			buttons[i].setId("btn"+i);
			buttons[i].setOnAction(this::ButtonEvent);
		}
    	
    	//TableView örnek veri ekleme
    	data=FXCollections.observableArrayList();
    	data.add(new Registers(btnIndex,"admin",0.5,"Mesaj",buttons[btnIndex]));
    	btnIndex++;
    	
    	tableView.getItems().addAll(data);
    	
    	//TableView ile Registers sýnýfýmýzý modelBinding yapýyoruz
    	col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
    	col_usrName.setCellValueFactory(new PropertyValueFactory<>("userName"));
    	col_avg.setCellValueFactory(new PropertyValueFactory<>("average"));
    	col_select.setCellValueFactory(new PropertyValueFactory<>("status"));
    	col_comit.setCellValueFactory(new PropertyValueFactory<>("textField"));
    	col_transaction.setCellValueFactory(new PropertyValueFactory<>("button"));
    }
    
    //Üretilen butonlar için olay atama
    @FXML
    void ButtonEvent(ActionEvent event) {
    	for (int i = 0; i < buttons.length; i++) {
			//Tetiklenen butonu bulma
    		if (event.getSource()==buttons[i]) {
				System.out.println(i+" . butona týklandý.");
			}
		}
    }
}
