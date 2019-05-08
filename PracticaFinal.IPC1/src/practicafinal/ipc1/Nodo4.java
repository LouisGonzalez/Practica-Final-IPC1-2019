package practicafinal.ipc1;
/**
 *
 * @author luisGonzalez
 * @param <T>
 */
public class Nodo4<T> {
    private T contenido;
    private Nodo4 siguiente;
    
    public Nodo4(T contenido){
        this.contenido = contenido;
    }
    
    public T obtenerContenido(){
        return contenido;
    }
    
    public Nodo4 obtenerSiguiente(){
        return siguiente;
    }
    
    public void especificarSiguiente(Nodo4<T> siguiente){
        this.siguiente = siguiente;
    }
}
