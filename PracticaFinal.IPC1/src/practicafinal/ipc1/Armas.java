package practicafinal.ipc1;
/**
 *
 * @author luisGonzalez
 */
public class Armas {
    private String nombre;
    private double ataque;
    
    public Armas(String nombre, double ataque){
        this.nombre = nombre;
        this.ataque = ataque;
    }

    public String getNombre() {
        return nombre;
    }

    public double getAtaque() {
        return ataque;
    }
    
    
}
