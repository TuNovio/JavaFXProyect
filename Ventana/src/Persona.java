import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Persona{
    //---------------------Atributos------------------//
    /**
     * Nombre de la persona
     */
    private SimpleStringProperty nombre;
    /**
     * Apellido de la persona
     */
    private SimpleStringProperty apellido;
    /**
     * edad de la persona
     */
    private SimpleIntegerProperty edad;
    //-----------------------Constructor---------------//
    /**
     * Consturctor de la clase persona 
     * @param nNombre, nombre de la persona. nNombre != "" && nNombre != null
     * @param nApellido, apellido de la persona. nApellido != "" && nApellido != null
     * @param nEdad, edad de la persona. nEdad != "" && nEdad != null
     */
    public Persona(String nNombre, String nApellido, int nEdad){
        nombre = new SimpleStringProperty(nNombre);
        apellido = new SimpleStringProperty(nApellido);
        edad = new SimpleIntegerProperty(nEdad);
    }
    //---------------------Métodos----------------------//
    /**
     * Nombre de la persona
     * @return el nombre de la persona
     */
    public String getNombre(){
        return nombre.get();
    }
    /**
     * Apellido de la persona
     * @return el apellido de la persona
     */
    public String getApellido(){
        return apellido.get();
    }
    /**
     * Edad de la persona 
     * @return la edad de la persona
     */
    public int getEdad(){
        return edad.get();
    }
}