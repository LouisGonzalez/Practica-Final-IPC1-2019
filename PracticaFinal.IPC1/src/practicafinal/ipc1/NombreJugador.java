package practicafinal.ipc1;
/**
 *
 * @author luisGonzalez
 */
public class NombreJugador {
    private String nombre;
    private double oro;
    private int contPartidasGanadas;
    private int contPartidasPerdidas;
    private int totalPartidas;
    private NuevoAuto<NombreAuto> miLista = new NuevoAuto<>();
    private NuevaArma<Armas> misArmas = new NuevaArma<>();
    private NuevoBot<Bot> misBots = new NuevoBot<>();
    
    public NombreJugador(String nombre, NuevoAuto<NombreAuto> miLista, NuevaArma<Armas> misArmas, NuevoBot<Bot> misBots, double oro, int contPartidasGanadas, int contPartidasPerdidas, int totalPartidas){
        this.nombre = nombre;
        this.miLista = miLista;
        this.misArmas = misArmas;
        this.misBots = misBots;
        this.oro = oro;
        this.contPartidasGanadas = contPartidasGanadas;
        this.contPartidasPerdidas = contPartidasPerdidas;
        this.totalPartidas = totalPartidas;
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

    public int getContPartidasGanadas() {
        return contPartidasGanadas;
    }

    public void setContPartidasGanadas(int contPartidasGanadas) {
        this.contPartidasGanadas = contPartidasGanadas;
    }

    public int getContPartidasPerdidas() {
        return contPartidasPerdidas;
    }

    public void setContPartidasPerdidas(int contPartidasPerdidas) {
        this.contPartidasPerdidas = contPartidasPerdidas;
    }

    public int getTotalPartidas() {
        return totalPartidas;
    }

    public void setTotalPartidas(int totalPartidas) {
        this.totalPartidas = totalPartidas;
    }
    
    
    
    
    
    
    
    
    
}
