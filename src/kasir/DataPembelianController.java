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

public class DataPembelianController {

    DataPembelianModel pjl = new DataPembelianModel();

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnDelete;

    @FXML
    private TextField textFieldID;

    @FXML
    private TextField textFieldJumlah;

    @FXML
    void addData(ActionEvent event) throws IOException {
        Penjualan pjl1 = new Penjualan(Integer.parseInt(textFieldJumlah.getText()), textFieldID.getText());

        pjl.addDataPembelian(pjl1);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Homescreen.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnAdd.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void deleteData(ActionEvent event) throws IOException {
        Penjualan pjl1 = new Penjualan(textFieldID.getText());

        pjl.deleteDataPembelian(pjl1);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Homescreen.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnDelete.getScene().getWindow();
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
