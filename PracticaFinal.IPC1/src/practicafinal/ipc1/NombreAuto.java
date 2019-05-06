package practicafinal.ipc1;
/**
 *
 * @author luisGonzalez
 */
public class NombreAuto {
    private String nombre;
    private String tipoAuto;
    private int ataque, armadura, experiencia, nivel;
    
    public NombreAuto(String nombre, String tipoAuto, int ataque, int armadura, int experiencia, int nivel){
        this.nombre = nombre;
        this.tipoAuto = tipoAuto;
        this.ataque = ataque;
        this.armadura = armadura;
        this.experiencia = experiencia;
        this.nivel = nivel;
    }
    
    public String mostrarDatos(){
        return "Nombre: "+nombre;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getTipoAuto(){
        return tipoAuto;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getArmadura() {
        return armadura;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public int getNivel() {
        return nivel;
    }
    
    
}
