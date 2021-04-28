package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FormUygulama_Ana_Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchor_tum;

    @FXML
    private AnchorPane anchor_sol;

    @FXML
    private AnchorPane anchor_sag;

    @FXML
    private Button btn_trans_dis;

    @FXML
    private Button btn_ic;

    @FXML
    private Button btn_dis;

    @FXML
    private Button btn_menu;

    @FXML
    void btn_dis_click(ActionEvent event) {
    	//Dýþ form butonuna týklandýðýnda FormUygulama2'nin çalýþmasýný saðlýyoruz
		try {
			Stage stage1=new Stage();
			AnchorPane pane1 = (AnchorPane)FXMLLoader.load(getClass().getResource("FormUygulama2.fxml"));
			Scene scene = new Scene(pane1);
			stage1.setScene(scene);
			stage1.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		//Formlar arasý veri aktarýmý
		try {
			FXMLLoader loader=new FXMLLoader(getClass().getResource("FormUygulama2.fxml"));
			AnchorPane pane2=(AnchorPane) loader.load();
			FormUygulama2Controller nesne=loader.getController();
			
			Scene scene2=new Scene(pane2);
			nesne.VeriAl("Selamun Aleykum , Ramazan Geldi Hoþgeldi");
			
			Stage stage2=new Stage();
			stage2.setScene(scene2);
			stage2.getIcons().add(new Image(getClass().getResourceAsStream("logo.png")));
			stage2.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btn_ic_click(ActionEvent event) {
    	try {
    		AnchorPane panel1=(AnchorPane) FXMLLoader.load(getClass().getResource(("FormUygulama2.fxml")));
    		anchor_sag.getChildren().setAll(panel1);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }

    @FXML
    void btn_menu_click(ActionEvent event) {
    	try {
    		AnchorPane panel2=(AnchorPane) FXMLLoader.load(getClass().getResource(("FormUygulama1.fxml")));
    		anchor_sol.getChildren().setAll(panel2);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }

    @FXML
    void btn_trans_dis_click(ActionEvent event) {
    	try {
        	Stage stage=new Stage();
        	AnchorPane panel1=(AnchorPane) FXMLLoader.load(getClass().getResource(("FormUygulama2.fxml")));
        	Scene scene=new Scene(panel1);
        	stage.setScene(scene);
        	//Formun transparanlýðýný ayarlama
        	stage.setOpacity(0.8);
        	//Forma baþlýk atma
        	stage.setTitle("Hi ISTE");
        	//Formun ekranýn merkezinde baþlatýlmasý
        	stage.centerOnScreen();
        	
        	//Form gösterim biçimleri
        	stage.initStyle(StageStyle.DECORATED);//Varsayýlan
        	stage.initStyle(StageStyle.UNIFIED);//Varsayýlan
        	stage.initStyle(StageStyle.UNDECORATED);//Menü tuþlarý olmadan
        	stage.initStyle(StageStyle.TRANSPARENT);//Menü tuþlarý yok ve transparan
        	stage.initStyle(StageStyle.UTILITY);//Sadece kapama butonu görünür
        	
        	//stage.getIcons().add(new Image("file:logo.png"));
        	stage.getIcons().add(new Image(getClass().getResourceAsStream("logo.png")));
        	stage.show();
        	
        	//Tam ekran görüntülenmesi saðlanýr
        	//stage.setFullScreen(true);
        	
    	}catch(Exception e) {
    		e.printStackTrace();
    	}

    }

    @FXML
    void initialize() {
        assert anchor_tum != null : "fx:id=\"anchor_tum\" was not injected: check your FXML file 'FormUygulama_Ana.fxml'.";
        assert anchor_sol != null : "fx:id=\"anchor_sol\" was not injected: check your FXML file 'FormUygulama_Ana.fxml'.";
        assert anchor_sag != null : "fx:id=\"anchor_sag\" was not injected: check your FXML file 'FormUygulama_Ana.fxml'.";
        assert btn_trans_dis != null : "fx:id=\"btn_trans_dis\" was not injected: check your FXML file 'FormUygulama_Ana.fxml'.";
        assert btn_ic != null : "fx:id=\"btn_ic\" was not injected: check your FXML file 'FormUygulama_Ana.fxml'.";
        assert btn_dis != null : "fx:id=\"btn_dis\" was not injected: check your FXML file 'FormUygulama_Ana.fxml'.";
        assert btn_menu != null : "fx:id=\"btn_menu\" was not injected: check your FXML file 'FormUygulama_Ana.fxml'.";

    }
}
