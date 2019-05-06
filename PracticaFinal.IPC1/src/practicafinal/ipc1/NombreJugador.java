package practicafinal.ipc1;
/**
 *
 * @author luisGonzalez
 */
public class NombreJugador {
    private String nombre;
    private NuevoAuto<NombreAuto> miLista = new NuevoAuto<>();
    
    public NombreJugador(String nombre, NuevoAuto<NombreAuto> miLista){
        this.nombre = nombre;
        this.miLista = miLista;
    }
    
    public String mostrarDatos(){
        return "Nombre: "+nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public NuevoAuto<NombreAuto> getMiLista() {
        return miLista;
    }
    
    
    
}
