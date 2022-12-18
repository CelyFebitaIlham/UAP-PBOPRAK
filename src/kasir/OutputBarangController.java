package kasir;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import static db.DBHelper.getConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class OutputBarangController implements Initializable {

    @FXML
    private Button btnBack;

    @FXML
    private TableView<Barang> viewBarang;

    @FXML
    private TableColumn<Barang, String> viewBarcode;

    @FXML
    private TableColumn<Barang, Double> viewDiskon;

    @FXML
    private TableColumn<Barang, String> viewExpired;

    @FXML
    private TableColumn<Barang, Double> viewHarga;

    @FXML
    private TableColumn<Barang, Integer> viewJumlah;

    @FXML
    private TableColumn<Barang, String> viewKategori;

    @FXML
    private TableColumn<Barang, String> viewNama;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        showBarang();
    }

    @FXML
    void toBarang(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Barang.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    public ObservableList<Barang> getListBarang(){
        ObservableList<Barang> listBarang = FXCollections.observableArrayList();
        Connection CONN = getConnection();
        String query = "SELECT * FROM barang;";
        Statement st;
        ResultSet rs;

        try{
            st = CONN.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                Barang brg = new Barang(rs.getString("nama_produk"), rs.getDouble("harga"), 
                                        rs.getDouble("diskon"), rs.getInt("jumlah"), 
                                        rs.getString("barcode"), rs.getString("expired"),
                                        rs.getString("kategori"));
                listBarang.add(brg);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return listBarang;
    }

    public void showBarang(){
        ObservableList<Barang> list = getListBarang();
        viewNama.setCellValueFactory(new PropertyValueFactory<Barang, String>("nama_produk"));
        viewHarga.setCellValueFactory(new PropertyValueFactory<Barang, Double>("harga"));
        viewDiskon.setCellValueFactory(new PropertyValueFactory<Barang, Double>("diskon"));
        viewJumlah.setCellValueFactory(new PropertyValueFactory<Barang, Integer>("jumlah"));
        viewBarcode.setCellValueFactory(new PropertyValueFactory<Barang, String>("barcode"));
        viewExpired.setCellValueFactory(new PropertyValueFactory<Barang, String>("expired"));
        viewKategori.setCellValueFactory(new PropertyValueFactory<Barang, String>("category"));

        viewBarang.setItems(list);
    }

}
