package practicafinal.ipc1;
/**
 *
 * @author luisGonzalez
 */
public class Enemigo {
    
    private String nombre;
    private int vida, ataque, armadura;
    
    public Enemigo(String nombre, int vida, int ataque, int armadura){
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.armadura = armadura;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getArmadura() {
        return armadura;
    }
    
    
}
