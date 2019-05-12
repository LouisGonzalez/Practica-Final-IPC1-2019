package practicafinal.ipc1;
/**
 *
 * @author luisGonzalez
 */
public class Enemigo {
    
    private String nombre;
    private double vida;
    private int ataque, armadura;
    
    public Enemigo(String nombre, double vida, int ataque, int armadura){
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.armadura = armadura;
    }

    public String getNombre() {
        return nombre;
    }

    public double getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getArmadura() {
        return armadura;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }
    
    
    
}
