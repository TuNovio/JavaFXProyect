import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Empresa {
    //-----------------------Atributos-------------------//
    /**
     * lista de personas
     */    
    private ArrayList<Persona> personas;
    //---------------------constructor------------------//
    /**
     * contructor de la clase empresa 
     * <b> pre: </b> la lista de usuarios se encuentra inicializada
     * <b> post: </b> se construye la clase empresa
     * se inicia el arreglo de personas como nueva lista
     */
    public Empresa(){
        personas = new ArrayList<Persona>();
    }
    //----------------------Metodos---------------------//
    /**
     * lista de las personas en el sistema
     * <b> pre: </b> la clase persona ya se encuentra inicializada
     * <b> post: </b> se crea una lista con las personas
     * @return las personas del sistema
     */
    public ArrayList<Persona> listaPersonas(){
        return personas;
    }
    /**
     * Agregar una persona a la emprsa 
     * <b> pre: </b> la lista de personas se encuentra inicializada
     * <b> post: </b> se añade a la persona 
     * miPersona, es la persona con los datos a almacenar. miPersona != "" && miPersona != null 
     * @param miPersona la persona con los datos 
     */
    public Persona agregarPersona(Persona miPersona){
        Persona mia = null; 
        if (miPersona != null){
                listaPersonas().add(miPersona);
                mia = miPersona;
        }
        else{
            JOptionPane.showMessageDialog(null, "Objeto persona nulo");
        }
        return mia;
    }
    /**
     * buscar una persona mediante el uso del nombre de la persona 
     * <b> pre: </b> la lista de personas ya se encuentra inicializada
     * <b> post: </b> se busca la persona por el nombre
     * @param nNombre, es el nombre de la persona a buscar. nNombre != null &6 nNombre != ""
     * @return La persona con los datos
     */
    public Persona buscarPersona(String nNombre){
        boolean stop = false;
        Persona encontrada = null;
        if (nNombre != null && !stop){
            for (int i = 0; i < listaPersonas().size(); i++){
                Persona buscar = personas.get(i);
                if(buscar.getNombre().equals(nNombre)){
                    encontrada = buscar;
                    stop = true;
                }
                else{
                    JOptionPane.showMessageDialog(null, "La persona con nombre: " + " [ " + buscar.getNombre() + " ] " + "no existe en la lista");
                }
            }
        }
        return encontrada;
    }
    /**
     * Eliminar una persona buscada por el nomrbre 
     * <b> pre: </b> la lista de personas se encuentra inicializada
     * <b> post: </b> se elimina a la persona buscada por el nombre 
     * @param nombre, es el nombre de la persona a eliminar. nomnbre != null && nombre != ""
     * @return la persona eliminada del sistema
     */
    public Persona eliminarPersona(String nombre){
        boolean stop = false;
        Persona eliminar = null;
        if (nombre != null && !stop){
            for (int i = 0; i < listaPersonas().size(); i++){
                Persona buscar = personas.get(i);
                if(buscar.getNombre().equals(nombre)){
                    eliminar = buscar;
                    personas.remove(i);
                    stop = true;
                }
                else{
                    JOptionPane.showMessageDialog(null, "La persona con nombre: " + " [] "+ eliminar.getNombre() + " ] " + "no existe en la lista");
                }
            }
        }
        return eliminar;
    }
}