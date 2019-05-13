package practicafinal.ipc1;

import java.io.Serializable;

/**
 *
 * @author luisGonzalez
 * @param <T>
 */
public class Nodo2<T> implements Serializable {
    private T contenido;
    private Nodo2 siguiente;
    
    public Nodo2(T contenido){
        this.contenido = contenido;
    }
    
    public T obtenerContenido(){
        return contenido;
    }
    
    public Nodo2 obtenerSiguiente(){
        return siguiente;
    }
    
    public void especificarSiguiente(Nodo2<T> siguiente){
        this.siguiente = siguiente;
    }
}
