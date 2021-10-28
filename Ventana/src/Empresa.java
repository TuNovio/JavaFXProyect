import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Empresa {
    //-----------------------Atributos-------------------//
    /**
     * lista de personas
     */    
    private ArrayList<Persona> personas;
    //---------------------constructor------------------//
    public Empresa(){
        personas = new ArrayList<Persona>();
    }
    //----------------------Metodos---------------------//
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
            for(int i = 0; i < personas.size(); i++){
                if(personas.get(i).getNombre() != miPersona.getNombre()){
                    personas.add(miPersona);
                    mia = miPersona;
                }
                else{
                    JOptionPane.showMessageDialog(null, "La persona ya se encuentra registrada en el sistema");
                }
            }
        }
        return mia;
    }
    /**
     * buscar una persona mediante el uso del nombre de la persona 
     * <b> pre: </b> la lista de personas ya se encuentra inicializada
     * <b> post: </b> se busca la persona por el nombre
     * @param miPersona es la persona con los datos a buscar. miPersona != null 
     * @return La persona con los datos
     */
    public Persona buscarPersona(Persona miPersona){
        boolean stop = false;
        Persona encontrada = null;
        if (miPersona != null && !stop){
            for (int i = 0; i < personas.size(); i++){
                Persona buscar = personas.get(i);
                if(buscar.getNombre().equals(miPersona.getNombre())){
                    encontrada = miPersona;
                    stop = true;
                }
                else{
                    JOptionPane.showMessageDialog(null, "La persona con nombre: " + " | "+ miPersona.getNombre() + " " + "no existe en la lista");
                }
            }
        }
        return encontrada;
    }
    public Persona eliminarPersona(Persona miPersona){
        boolean stop = false;
        Persona eliminar = null;
        if (miPersona != null && !stop){
            for (int i = 0; i < personas.size(); i++){
                Persona buscar = personas.get(i);
                if(buscar.getNombre().equals(miPersona.getNombre())){
                    eliminar = miPersona;
                    personas.remove(miPersona);
                    stop = true;
                }
                else{
                    JOptionPane.showMessageDialog(null, "La persona con nombre: " + " | "+ miPersona.getNombre() + " " + "no existe en la lista");
                }
            }
        }
        return eliminar;
    }
}