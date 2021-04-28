package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TableViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Kayitlar> kayitlar_table;

    @FXML
    private TableColumn<Kayitlar, Integer> col_id;

    @FXML
    private TableColumn<Kayitlar, String> col_kul_adi;

    @FXML
    private TableColumn<Kayitlar, String> col_sifre;

    @FXML
    private TextField txt_kul;

    @FXML
    private TextField txt_sifre;

    @FXML
    private Button btn_ekle;

    @FXML
    private Button btn_sil;

    @FXML
    private Button btn_guncelle;

    @FXML
    private Button btn_goster;

    @FXML
    private Label lbl_deger;
    
    ObservableList<Kayitlar> veriler;

    @FXML
    void btn_ekle_click(ActionEvent event) {
    	veriler=FXCollections.observableArrayList();
    	veriler.add(new Kayitlar(0,txt_kul.getText(),txt_sifre.getText()));
    	kayitlar_table.getItems().addAll(veriler);
    }

    @FXML
    void btn_goster_click(ActionEvent event) {
    	Kayitlar kayit=new Kayitlar();
    	if(kayitlar_table.getSelectionModel().getSelectedIndex()!=-1) {
    		kayit=(Kayitlar) kayitlar_table.getItems().get(kayitlar_table.getSelectionModel().getSelectedIndex());
    		
    		lbl_deger.setText("Deðer = "+kayit.getKul_adi());
    	}else {
    		lbl_deger.setText("Herhangi bir kayýt seçilemdi");
    	}
    }

    @FXML
    void btn_guncelle_click(ActionEvent event) {
    	Kayitlar kayit=new Kayitlar();
    	if(kayitlar_table.getSelectionModel().getSelectedIndex()!=-1) {
    		kayit=(Kayitlar) kayitlar_table.getItems().get(kayitlar_table.getSelectionModel().getSelectedIndex());
    		int id=kayit.getId();
    		//txt_kul.setText(kayit.getKul_adi());
    		//txt_sifre.setText(kayit.getSifre());
    		//lbl_deger.setText("Deðer = "+kayit.getKul_adi());
    		
    		//Yeni kayýtlar oluþturarak indise göre deðer atama
    		Kayitlar kk=new Kayitlar(id,txt_kul.getText(),txt_sifre.getText());
    		int index=kayitlar_table.getSelectionModel().getSelectedIndex();
    		kayitlar_table.getItems().set(index, kk);
    	}else {
    		lbl_deger.setText("Herhangi bir kayýt seçilemdi");
    	}
    }

    @FXML
    void btn_sil_click(ActionEvent event) {
    	ObservableList<Kayitlar> secilenKayit,tumKayitlar;
    	secilenKayit=kayitlar_table.getSelectionModel().getSelectedItems();
    	tumKayitlar=kayitlar_table.getItems();
    	
    	secilenKayit.forEach(tumKayitlar::remove);
    }

    @FXML
    void initialize() {
    	btn_ekle.setTooltip(new Tooltip("Kayýt Eklemeyi Saðlar"));
    	
    	//Custom ToolTip Ekleme
    	Tooltip tip=new Tooltip();
    	tip.setStyle("-fx-background-color:yellow");
    	tip.setText("Silme Ýþlemi Yapar");
    	Image img=new Image(getClass().getResourceAsStream("logo.png"));
    	tip.setGraphic(new ImageView(img));
    	btn_sil.setTooltip(tip);
    	
    	//TableView Veri Gömme
    	veriler=FXCollections.observableArrayList();
    	veriler.add(new Kayitlar(0,"semihshn","654321"));
    	veriler.add(new Kayitlar(1,"selcukgulyer","123456"));
    	veriler.add(new Kayitlar(2,"ap_sarikaya","789456"));
    	
    	//Ýlk id TableColumn ismi
    	//Ýkinci id Kayitlar Classýndan gelen id
    	col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
    	col_kul_adi.setCellValueFactory(new PropertyValueFactory<>("kul_adi"));
    	col_sifre.setCellValueFactory(new PropertyValueFactory<>("sifre"));
    	
    	kayitlar_table.setItems(veriler);
    	
    	//col_kul_adi.setVisible(false);
    	//TableView içerisindeki sütunun gizlenmesi
    }
    
    public static class Kayitlar{
    	private int id;
    	private String kul_adi;
    	private String sifre;
    	
    	Kayitlar(){
    		this.id=0;
    	}
    	
    	Kayitlar(int id,String kul_adi,String sifre){
    		this.id=id;
    		this.kul_adi=kul_adi;
    		this.sifre=sifre;
    	}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getKul_adi() {
			return kul_adi;
		}

		public void setKul_adi(String kul_adi) {
			this.kul_adi = kul_adi;
		}

		public String getSifre() {
			return sifre;
		}

		public void setSifre(String sifre) {
			this.sifre = sifre;
		}
    	
    	
    }
}
