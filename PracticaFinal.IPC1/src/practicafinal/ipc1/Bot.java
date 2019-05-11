package practicafinal.ipc1;
/**
 *
 * @author luisGonzalez
 */
public class Bot {
    private String nombre;
    private double ataque;
    
    public Bot(String nombre, double ataque){
        this.nombre = nombre;
        this.ataque = ataque;
    }

    //metodos GET y SET
    public String getNombre() {
        return nombre;
    }

    public double getAtaque() {
        return ataque;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAtaque(double ataque) {
        this.ataque = ataque;
    }
    
    
}
