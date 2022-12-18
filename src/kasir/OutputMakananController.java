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

public class OutputMakananController implements Initializable {

    @FXML
    private Button btnBack;

    @FXML
    private TableColumn<Makanan, Double> viewDiskon;

    @FXML
    private TableColumn<Makanan, Integer> viewDaya;

    @FXML
    private TableColumn<Makanan, Double> viewHarga;

    @FXML
    private TableColumn<Makanan, Integer> viewId;

    @FXML
    private TableColumn<Makanan, Integer> viewJumlah;

    @FXML
    private TableView<Makanan> viewMakanan;

    @FXML
    private TableColumn<Makanan, String> viewNama;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        showMakanan();
    }

    @FXML
    void toMakanan(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Makanan.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    public ObservableList<Makanan> getListMakanan(){
        ObservableList<Makanan> listMakanan = FXCollections.observableArrayList();
        Connection CONN = getConnection();
        String query = "SELECT * FROM makanan;";
        Statement st;
        ResultSet rs;

        try{
            st = CONN.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                Makanan mkn = new Makanan(rs.getString("nama_produk"), rs.getDouble("harga"),
                rs.getDouble("diskon"), rs.getInt("jumlah"),
                rs.getInt("id"), rs.getInt("daya_tahan"));
                listMakanan.add(mkn);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return listMakanan;
    }

    public void showMakanan(){
        ObservableList<Makanan> list = getListMakanan();
        viewNama.setCellValueFactory(new PropertyValueFactory<Makanan, String>("nama_produk"));
        viewHarga.setCellValueFactory(new PropertyValueFactory<Makanan, Double>("harga"));
        viewDiskon.setCellValueFactory(new PropertyValueFactory<Makanan, Double>("diskon"));
        viewJumlah.setCellValueFactory(new PropertyValueFactory<Makanan, Integer>("jumlah"));
        viewId.setCellValueFactory(new PropertyValueFactory<Makanan, Integer>("id"));
        viewDaya.setCellValueFactory(new PropertyValueFactory<Makanan, Integer>("daya_tahan"));

        viewMakanan.setItems(list);
    }

}
