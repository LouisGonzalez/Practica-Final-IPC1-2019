package practicafinal.ipc1;

import java.io.Serializable;

/**
 *
 * @author luisGonzalez
 */
public class Armas implements Serializable{
    private String nombre;
    private double ataque;
    
    public Armas(String nombre, double ataque){
        this.nombre = nombre;
        this.ataque = ataque;
    }
    
    //metodos GET Y SET 
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
