package kasir;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BarangController {

    BarangModel brg = new BarangModel();

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnCek;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnMakanan; // -> To Makanan

    @FXML
    private TextField textFieldBarcode;

    @FXML
    private TextField textFieldDiskon;

    @FXML
    private TextField textFieldExpired;

    @FXML
    private TextField textFieldHarga;

    @FXML
    private TextField textFieldJumlah;

    @FXML
    private TextField textFieldKategori;

    @FXML
    private TextField textFieldNama;

    @FXML
    void addBarang(ActionEvent event) throws IOException {
        Barang brg1 = new Barang(textFieldNama.getText(), Double.parseDouble(textFieldHarga.getText()),
                                Double.parseDouble(textFieldDiskon.getText()), Integer.parseInt(textFieldJumlah.getText()),
                                textFieldBarcode.getText(), textFieldExpired.getText(), textFieldKategori.getText());
        brg.addBarang(brg1);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Homescreen.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnAdd.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void cekBarang(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("OutputBarang.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnCek.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void deleteBarang(ActionEvent event) throws IOException {
        Barang brg1 = new Barang(textFieldBarcode.getText());
        brg.deleteBarang(brg1);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Homescreen.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnDelete.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void toMakanan(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Makanan.fxml"));
        Parent root = (Parent) loader.load();

        Stage stage = (Stage) btnMakanan.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void toHome(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Homescreen.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

}
