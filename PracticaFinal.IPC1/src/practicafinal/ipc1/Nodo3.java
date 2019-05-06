package practicafinal.ipc1;
/**
 *
 * @author luisGonzalez
 * @param <T>
 */
public class Nodo3<T> {
    private T contenido;
    private Nodo3 siguiente;
    
    public Nodo3(T contenido){
        this.contenido = contenido;
    }
    
    public T obtenerContenido(){
        return contenido;
    }
    
    public Nodo3 obtenerSiguiente(){
        return siguiente;
    }
    
    public void especificarSiguiente(Nodo3<T> siguiente){
        this.siguiente = siguiente;
    }
}
