import javax.swing.JOptionPane;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
 /**
  * Clase grafica con java fx
  */
public class App extends Application {
    @Override
    public void start(Stage primaryStage) { 
        Parent root;
        try {
            root= FXMLLoader.load(getClass().getResource("MainScene.fxml"));    
            Scene scene = new Scene(root);
            primaryStage.setTitle("Registrar personas");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar llamar la interfaz" + e.getMessage());
        }
    }
 
 public static void main(String[] args) {
        launch(args);
    }
}