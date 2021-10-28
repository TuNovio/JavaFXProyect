import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class MainControl implements Initializable {
    Persona miPersona;
    @FXML
    private AnchorPane PanelInterfaz;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnLimpiar;

    @FXML
    private Button btnLog;

    @FXML
    private Button btnRegistrar;

    @FXML
    private TableColumn<Persona, String> colApellido;

    @FXML
    private TableColumn<Persona, Integer> colEdad;

    @FXML
    private TableColumn<Persona, String> colNombre;

    @FXML
    private Label lblApellido;

    @FXML
    private Label lblEdad;

    @FXML
    private Label lblNombre;

    @FXML
    private TableView<Persona> tblLog;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtNombre;

    @FXML
    void btnEliminarOnClicked(ActionEvent event) {

    }

    @FXML
    void btnLimpiarClicked(ActionEvent event) {
        txtApellido.setText(null);
        txtEdad.setText(null);
        txtNombre.setText(null);
    }

    @FXML
    void btnLogOnClicked(ActionEvent event) {

    }

    @FXML
    void btnRegistrarOnClicked(ActionEvent event) {
        try {
            if (txtNombre.getText() != null && txtApellido.getText() != null && txtEdad.getText() != null) {

                miPersona = new Persona(txtNombre.getText(), txtApellido.getText(),
                        Integer.parseInt(txtEdad.getText()));
                tblLog.getItems().add(miPersona);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de datos" + " | " + e.getMessage());
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
    }

}
