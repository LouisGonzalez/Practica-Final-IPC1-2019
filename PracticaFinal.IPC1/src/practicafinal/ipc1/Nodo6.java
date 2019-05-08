package practicafinal.ipc1;
/**
 *
 * @author luisGonzalez
 * @param <T>
 */
public class Nodo6<T> {
    private T contenido;
    private Nodo6 siguiente;
    
    public Nodo6(T contenido){
        this.contenido = contenido;
    }
    
    public T obtenerContenido(){
        return contenido;
    }
    
    public Nodo6 obtenerSiguiente(){
        return siguiente;
    }
    
    public void especificarSiguiente(Nodo6<T> siguiente){
        this.siguiente = siguiente;
    }
}
