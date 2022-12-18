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

public class KategoriController {

    KategoriModel ktg = new KategoriModel();

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnDelete;

    @FXML
    private TextField textFieldNama;

    @FXML
    void addKategori(ActionEvent event) throws IOException {
        Kategori ktg1 = new Kategori(textFieldNama.getText());
        ktg.addKategori(ktg1);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Homescreen.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnAdd.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void toHome(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Homescreen.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void deleteKategori(ActionEvent event) throws IOException {
        Kategori ktg1 = new Kategori(textFieldNama.getText());
        ktg.deleteKategori(ktg1);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Homescreen.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnDelete.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

}
