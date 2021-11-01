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
    /**
     * Objeto de tipo empresa
     */
    Empresa miEmpresa;
    /**
     * objeto de tipo persona
     */
    Persona miPersona;
    /**
     * panel en el cual se encuentran los elementos de la interfaz
     */
    @FXML
    private AnchorPane PanelInterfaz;
    /**
     * boton que permite realizar la accion de eliminar registro
     */
    @FXML
    private Button btnEliminar;
    /**
     * boton que permite limpiar las casillas de texto
     */
    @FXML
    private Button btnLimpiar;
    /**
     * boton que permite ingresar a la siguiente pestaña
     */
    @FXML
    private Button btnLog;
    /**
     * boton para registrar datos en la tabla
     */
    @FXML
    private Button btnRegistrar;
    /**
     * Columna de la tabla que corresponde al apellido de la persona
     */
    @FXML
    private TableColumn<Persona, String> colApellido;
    /**
     * Columna de la tabla que corresponde a la edad de la persona
     */
    @FXML
    private TableColumn<Persona, Integer> colEdad;
    /**
     * Columna de la tabla que corresponde al nombre de la persona
     */
    @FXML
    private TableColumn<Persona, String> colNombre;
    /**
     * Etiqueta para identificar la casilla de texto para apellido
     */
    @FXML
    private Label lblApellido;
    /**
     * Etiqueta para identificar la casilla de texto para edad
     */
    @FXML
    private Label lblEdad;
    /**
     * Etiqueta para identificar la casilla de texto para nombre
     */
    @FXML
    private Label lblNombre;
    /**
     * Tabla para visualizar los datos que se registran
     */
    @FXML
    private TableView<Persona> tblLog;
    /**
     * Casilla de texto para ingresar el apellido de la persona
     */
    @FXML
    private TextField txtApellido;
    /**
     * Casilla de texto para ingresar la edad de la persona
     */
    @FXML
    private TextField txtEdad;
    /**
     * Casilla de texto para ingresar el nombre de la persona
     */
    @FXML
    private TextField txtNombre;

    /**
     * eliminar un registro de la tabla
     *<b> pre: </b> los elementos de la interfaz se encuentran inicializados 
     *<b> post: </b> se eliminan los registros
     * selecionados en la tabla validar que existan elementos en la tabla.
     * @param event evento de eliminar registro
     */
    @FXML
    void btnEliminarOnClicked(ActionEvent event) {
        int indice = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posición del dato a eliminar:_["));
        if (JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar sus datos", "Confirme",
                JOptionPane.YES_NO_OPTION) == 0) {
                    eliminarIndice(indice);
                }

    }

    /**
     * limpiar las casillas de texto y la informacion en la tabla <b> pre:</b> los
     * elementos de la interfaz se encuentran inicializados <b> post: </b> se
     * limpian las casillas de texto y tablla
     * @param event evento de limpiar casillas de texto y tabla
     */
    @FXML
    void btnLimpiarClicked(ActionEvent event) {
        if (JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar sus datos", "Confirme",
                JOptionPane.YES_NO_OPTION) == 0) {

            limpiarCasillas();
            tblLog.getItems().clear();
        } else {
            MainControl.this.getClass();
        }
    }

    /**
     * ingresar a la ventana siguiente ¿Aun no definida¡? <b> pre: </b> la interfaz
     * referida se encuentra inicializada <b> post: </b> se abre la interfaz validar
     * que por lo menos se tenga 1 registro en la tabla
     * @param event
     */
    @FXML
    void btnLogOnClicked(ActionEvent event) {

    }

    /**
     * accion de registrar los datos escritos en las casillas de texto <b> pre: </b>
     * los elementos de la interfaz se encuentran inicializados <b> post: </b> se
     * registran los datos en la tabla Se debe validar los datos y el tipo de dato
     * que se quiera registrar
     * @param event evento que sucede al presionar el boton
     */
    @FXML
    void btnRegistrarOnClicked(ActionEvent event) {
        try {
            if(validarDatos() == true){
                miPersona = new Persona(txtNombre.getText(), txtApellido.getText(), Integer.parseInt(txtEdad.getText()));
                tblLog.getItems().add(miPersona);
                limpiarCasillas();
            }
            else{
                System.out.print("An error ocurrer while triyig to do the register action");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de datos" + " | " + e.getMessage());
        }
    }

    /**
     * Inicializar la tabla para el ingreso de datos en las columnas <b> pre: </b>
     * los elementos de la interfaz se encuentran inicializados <b> post: </b> se
     * inicializan las columnas de la tabla nombre, corresponde a la primera columna
     * de la tabla. nombre != "" && nombre != null apellido, corresponde a la
     * segunda columna de la tabla. apellido != "" && apellido != null edad
     * corresponde a la tercera columna de la tabla. edad > 0 && edad != null
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
    }

    /**
     * Limpia las casillas de texto de la interfaz <b> pre: </b> los elementos de la
     * interfaz se encuentran inicializados <b> post: </b> se limpia la casilla de
     * texto de la interfaz limpia las casillas de texto para permitir su edicion
     */
    public void limpiarCasillas() {
        txtApellido.setText(null);
        txtEdad.setText(null);
        txtNombre.setText(null);
    }
    /**
     * validar los valores de los datos de entrada
     * <b> pre: </b> los datos de entrada, es decir, los elementos de la interfaz se encuentran inizializados
     * <b> post: </b> se validan los datos
     * No deben existir personas con el mismo nombre, la edad no debe superar los 100 años, las personas con mismo nombre se identifican por el apellido
     * @return true si la validación es correcta de lo contrario falfse
     */
    public boolean validarDatos() {
        boolean validar = false;
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        int edad = Integer.parseInt(txtEdad.getText());
        if(nombre != null && apellido != null && edad >0 && edad <= 100){
            
            validar = true;
        }
        else{
            JOptionPane.showMessageDialog(null, "Los datos no han sido validados correctamente porfavor intentalo de nuevo");
        }
        return validar;

    }
    /**
     * elimila los datos dada la posicion del dato en la tabla
     * <b> pre: </b> la tabla ya se encuentra inicializada
     * <b> post: </b> se elimina el dato dada la posición del mismo
     * @param indice es el valor de la posicion del dato en la tabla. indice > 0 && indice != null
     */
    public void eliminarIndice(int indice){
        tblLog.getItems().remove(indice);
    }
}