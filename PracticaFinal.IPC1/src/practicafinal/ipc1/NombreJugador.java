package practicafinal.ipc1;
/**
 *
 * @author luisGonzalez
 */
public class NombreJugador {
    private String nombre;
    private double oro;
    private NuevoAuto<NombreAuto> miLista = new NuevoAuto<>();
    private NuevaArma<Armas> misArmas = new NuevaArma<>();
    private NuevoBot<Bot> misBots = new NuevoBot<>();
    
    public NombreJugador(String nombre, NuevoAuto<NombreAuto> miLista, NuevaArma<Armas> misArmas, NuevoBot<Bot> misBots, double oro){
        this.nombre = nombre;
        this.miLista = miLista;
        this.misArmas = misArmas;
        this.misBots = misBots;
        this.oro = oro;
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
   
    public double getOro() {
        return oro;
    }

    public NuevaArma<Armas> getMisArmas() {
        return misArmas;
    }

    public NuevoBot<Bot> getMisBots() {
        return misBots;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setOro(double oro) {
        this.oro = oro;
    }

    public void setMiLista(NuevoAuto<NombreAuto> miLista) {
        this.miLista = miLista;
    }

    public void setMisArmas(NuevaArma<Armas> misArmas) {
        this.misArmas = misArmas;
    }

    public void setMisBots(NuevoBot<Bot> misBots) {
        this.misBots = misBots;
    }
    
    
    
    
    
}
