package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ComboListViewChoiceController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtDeger;

    @FXML
    private ComboBox<String> combo1;

    @FXML
    private ChoiceBox<String> choice;

    @FXML
    private ListView<String> lstView;

    @FXML
    private Button btn;

    @FXML
    private Button btn_getir;

    @FXML
    private Label lbl_getir;

    @FXML
    void btn_click(ActionEvent event) {

    	}

    @FXML
    void btn_getir_click(ActionEvent event) {
    	combo1.getItems().add(txtDeger.getText());
    	
    	ObservableList<String> icerig;
    	icerig=lstView.getSelectionModel().getSelectedItems();
    	for(String i : icerig) {
    		System.out.println(i);
    	}
    	
    	ObservableList<Integer> indisler;
    	indisler=lstView.getSelectionModel().getSelectedIndices();
    	for(int i : indisler) {
    		System.out.println(i);
    		}
    }

    @FXML
    void choice_click(MouseEvent event) {

    }

    @FXML
    void combo1_click(ActionEvent event) {

    }

    @FXML
    void initialize() {
    	combo1.setPromptText("Deðer seçiniz");
    	String[] dizi= {"deneme1","deneme2","deneme3"};
    	
    	combo1.getItems().addAll(dizi);
    	
    	ObservableList<String> dizi2=FXCollections.observableArrayList("deger 1","deger 2","deger 3");
    	combo1.getItems().addAll(dizi2);
    	
    	lstView.getItems().addAll(dizi2);
    	
    	lstView.getSelectionModel().getSelectedItem();
    	//Seçili olan deðer bu þekilde alýnabilir
    	
    	lstView.getSelectionModel().getSelectedIndex();
    	//Seçili olan index bu þekilde alýnabilir
    	
    	lstView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    	//ListView üzerinde birden çok deðeri ctrl tuþunu kullanarak seçebilmemiz saðlýyor
    	
    	lstView.getSelectionModel().getSelectedIndices();
    	//ListView üzerinde birden çok index seçiliyse seçili olan indexlerin index deðerini verir
    	
    	lstView.getSelectionModel().select(2);
    	//2 nolu indisi seçer
    	
        //assert txtDeger != null : "fx:id=\"txtDeger\" was not injected: check your FXML file 'Form2.fxml'.";
        //assert combo1 != null : "fx:id=\"combo1\" was not injected: check your FXML file 'Form2.fxml'.";
        //assert choice != null : "fx:id=\"choice\" was not injected: check your FXML file 'Form2.fxml'.";
        //assert lstView != null : "fx:id=\"lstView\" was not injected: check your FXML file 'Form2.fxml'.";
        //assert btn != null : "fx:id=\"btn\" was not injected: check your FXML file 'Form2.fxml'.";
        //assert btn_getir != null : "fx:id=\"btn_getir\" was not injected: check your FXML file 'Form2.fxml'.";
        //assert lbl_getir != null : "fx:id=\"lbl_getir\" was not injected: check your FXML file 'Form2.fxml'.";

    }
}
