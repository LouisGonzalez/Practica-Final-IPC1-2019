package practicafinal.ipc1;
/**
 *
 * @author luisGonzalez
 */
public class NombreAuto {
    private String nombre;
    private String tipoAuto;
    private int armadura, experiencia, nivel, enemigosDestruidos, autoDestruido;
    private double ataque, vida;
    
    public NombreAuto(String nombre, String tipoAuto, double ataque, int armadura, int experiencia, int nivel, double vida, int enemigosDestruidos, int autoDestruido){
        this.nombre = nombre;
        this.tipoAuto = tipoAuto;
        this.ataque = ataque;
        this.armadura = armadura;
        this.experiencia = experiencia;
        this.nivel = nivel;
        this.vida = vida;
        this.enemigosDestruidos = enemigosDestruidos;
        this.autoDestruido = autoDestruido;
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

    public double getAtaque() {
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

    public double getVida() {
        return vida;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipoAuto(String tipoAuto) {
        this.tipoAuto = tipoAuto;
    }

    public void setAtaque(double ataque) {
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

    public void setVida(double vida) {
        this.vida = vida;
    }

    public int getEnemigosDestruidos() {
        return enemigosDestruidos;
    }

    public void setEnemigosDestruidos(int enemigosDestruidos) {
        this.enemigosDestruidos = enemigosDestruidos;
    }

    public int getAutoDestruido() {
        return autoDestruido;
    }

    public void setAutoDestruido(int autoDestruido) {
        this.autoDestruido = autoDestruido;
    }
    
    
    
    
}
