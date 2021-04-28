package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertDialogController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField txt_pass;

    @FXML
    private TextField txt_kul;

    @FXML
    private Button btn_giris;

    @FXML
    private Button btn_cikis;

    @FXML
    private Button btn_alertBilgi;

    @FXML
    private Button btn_hata;

    @FXML
    private Button btn_soru;

    @FXML
    private Button btn_input;

    @FXML
    private Button btn_combo;

    @FXML
    void btn_alertBilgi_click(ActionEvent event) {
    	Alert alert=new Alert(AlertType.INFORMATION);
    	alert.setTitle("ISTE automation");
    	alert.setHeaderText("Bilgilendirme metni..");
    	alert.setContentText("Bu bir bilgi mesajýdýr");
    	alert.showAndWait();
    }

    @FXML
    void btn_cikis_click(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void btn_combo_click(ActionEvent event) {
    	List<String> sec=new ArrayList<>();
    	sec.add("1. Seçenek");
    	sec.add("2. Seçenek");
    	sec.add("3. Seçenek");

    	ChoiceDialog<String> dialog=new ChoiceDialog<String>("2. Seçenek",sec);
    	Optional<String> sonuc= dialog.showAndWait();
    	
    	if(sonuc.isPresent()) {
    		System.out.print(sonuc.get());
    	}
    }

    @FXML
    void btn_giris_click(ActionEvent event) {

    }

    @FXML
    void btn_hata_click(ActionEvent event) {
    	Alert alert=new Alert(AlertType.ERROR);
    	alert.setTitle("ISTE automation");
    	alert.setHeaderText("Hata metni..");
    	alert.setContentText("Bu bir hata mesajýdýr");
    	alert.showAndWait();
    }

    @FXML
    void btn_input_click(ActionEvent event) {
    	TextInputDialog dialog=new TextInputDialog("ISTE");
    	dialog.setTitle("ISTE");
    	dialog.setHeaderText("Check it automation");
    	dialog.setContentText("Telefonunuza gönderilen onay kodunu giriniz");
    	
    	Optional<String> sonuc=dialog.showAndWait();
    	if(sonuc.isPresent()) {
    		System.out.println(sonuc.get());
    	}
    }

    @FXML
    void btn_soru_click(ActionEvent event) {
    	Alert alert=new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("ISTE automation");
    	alert.setHeaderText("Onay kutusu");
    	alert.setContentText("Silmek istediðiniz emin misiniz ?");

    	ButtonType btn1=new ButtonType("Evet");
    	ButtonType btn2=new ButtonType("Hayýr");
    	ButtonType btn3=new ButtonType("Ýptal",ButtonData.CANCEL_CLOSE);
    	ButtonType btn4=new ButtonType("Tamam",ButtonData.OK_DONE);
    	
    	alert.getButtonTypes().setAll(btn1,btn2,btn3,btn4);
    	
    	Optional<ButtonType> sonuc=alert.showAndWait();
    	
    	if(sonuc.isPresent()) {
    		System.out.print(sonuc.get());
    		
    	}
    	
    }

    @FXML
    void initialize() {

    }
}
