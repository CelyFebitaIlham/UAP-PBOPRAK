package kasir;

import java.io.IOException;
// import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MakananController {

    MakananModel mkn = new MakananModel();
    // ArrayList<Makanan> listMakanan = mkn.getMakanan();

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnBarang; // -> to Barang

    @FXML
    private Button btnCek;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnBack;

    @FXML
    private TextField textFieldDaya;

    @FXML
    private TextField textFieldDiskon;

    @FXML
    private TextField textFieldHarga;

    @FXML
    private TextField textFieldID;

    @FXML
    private TextField textFieldJumlah;

    @FXML
    private TextField textFieldNama;

    @FXML
    void addMakanan(ActionEvent event) throws IOException {
        Makanan mkn1 = new Makanan(textFieldNama.getText(), Double.parseDouble(textFieldHarga.getText()),
                        Double.parseDouble(textFieldDiskon.getText()), Integer.parseInt(textFieldJumlah.getText()),
                        Integer.parseInt(textFieldID.getText()), Integer.parseInt(textFieldDaya.getText()));
        mkn.addMakanan(mkn1);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Homescreen.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnAdd.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void cekMakanan(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("OutputMakanan.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnCek.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void deleteMakanan(ActionEvent event) throws IOException {
        Makanan mkn1 = new Makanan(Integer.parseInt(textFieldID.getText()));
        mkn.deleteMakanan(mkn1);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Homescreen.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnDelete.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void toBarang(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Barang.fxml"));
        Parent root = (Parent) loader.load();

        Stage stage = (Stage) btnBarang.getScene().getWindow();
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
