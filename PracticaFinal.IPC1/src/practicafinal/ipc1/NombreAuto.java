package practicafinal.ipc1;
/**
 *
 * @author luisGonzalez
 */
public class NombreAuto {
    private String nombre;
    private String tipoAuto;
    private int ataque, armadura, experiencia, nivel, vida;
    
    public NombreAuto(String nombre, String tipoAuto, int ataque, int armadura, int experiencia, int nivel, int vida){
        this.nombre = nombre;
        this.tipoAuto = tipoAuto;
        this.ataque = ataque;
        this.armadura = armadura;
        this.experiencia = experiencia;
        this.nivel = nivel;
        this.vida = vida;
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

    public int getVida() {
        return vida;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipoAuto(String tipoAuto) {
        this.tipoAuto = tipoAuto;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
    
    
    
}
