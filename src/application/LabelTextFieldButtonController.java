package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LabelTextFieldButtonController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane achor1;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private Label lbl22;

    @FXML
    private Label lbl23;

    @FXML
    private TextField txtHiz1;

    @FXML
    private TextField txtHiz2;

    @FXML
    private TextField txtZaman;

    @FXML
    private Button btn_Temizle;

    @FXML
    private Label lbl231;

    @FXML
    private Label lbl_Sonuc;

    @FXML
    private Button btn_Hesapla;

    @FXML
    void btn_Hesapla_click(ActionEvent event) {
	double hiz1,hiz2,time;
	hiz1=Double.parseDouble(txtHiz1.getText());
	hiz2=Double.parseDouble(txtHiz2.getText());
	time=Double.parseDouble(txtZaman.getText());
	
	double sonuc=(hiz1-hiz2)*time;
	sonuc=Math.abs(sonuc);
	lbl_Sonuc.setText(String.valueOf(sonuc)+" KM");
    }

    @FXML
    void btn_Temizle_click(ActionEvent event) {
    	txtHiz1.clear();
    	txtHiz2.clear();
    	txtZaman.clear();
    	lbl_Sonuc.setText("KM");
    }

    @FXML
    void initialize() {
        //assert achor1 != null : "fx:id=\"achor1\" was not injected: check your FXML file 'Sample.fxml'.";
        //assert lbl1 != null : "fx:id=\"lbl1\" was not injected: check your FXML file 'Sample.fxml'.";
        //assert lbl2 != null : "fx:id=\"lbl2\" was not injected: check your FXML file 'Sample.fxml'.";
        //assert lbl22 != null : "fx:id=\"lbl22\" was not injected: check your FXML file 'Sample.fxml'.";
        //assert lbl23 != null : "fx:id=\"lbl23\" was not injected: check your FXML file 'Sample.fxml'.";
        //assert txtHiz1 != null : "fx:id=\"txtHiz1\" was not injected: check your FXML file 'Sample.fxml'.";
        //assert txtHiz2 != null : "fx:id=\"txtHiz2\" was not injected: check your FXML file 'Sample.fxml'.";
        //assert txtZaman != null : "fx:id=\"txtZaman\" was not injected: check your FXML file 'Sample.fxml'.";
        //assert btn_Temizle != null : "fx:id=\"btn_Temizle\" was not injected: check your FXML file 'Sample.fxml'.";
        //assert lbl231 != null : "fx:id=\"lbl231\" was not injected: check your FXML file 'Sample.fxml'.";
        //assert lbl_Sonuc != null : "fx:id=\"lbl_Sonuc\" was not injected: check your FXML file 'Sample.fxml'.";
        //assert btn_Hesapla != null : "fx:id=\"btn_Hesapla\" was not injected: check your FXML file 'Sample.fxml'.";

    }
}
