package kasir;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomescreenController {

    @FXML
    private Button btnData; // -> to Data

    @FXML
    private Button btnKategori; // -> to Kategori

    @FXML
    private Button btnProduk; // to Produk

    @FXML
    void toData(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DataPembelian.fxml"));
        Parent root = (Parent) loader.load();

        Stage stage = (Stage) btnData.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void toKategori(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Kategori.fxml"));
        Parent root = (Parent) loader.load();

        Stage stage = (Stage) btnKategori.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void toProduk(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Barang.fxml"));
        Parent root = (Parent) loader.load();


        Stage stage = (Stage) btnProduk.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

}
