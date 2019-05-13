package practicafinal.ipc1;

import java.io.Serializable;

/**
 *
 * @author luisGonzalez
 * @param <T>
 */
public class Nodo5<T> implements Serializable{
    private T contenido;
    private Nodo5 siguiente;
    
    public Nodo5(T contenido){
        this.contenido = contenido;
    }
    
    public T obtenerContenido(){
        return contenido;
    }
    
    public Nodo5 obtenerSiguiente(){
        return siguiente;
    }
    
    public void especificarSiguiente(Nodo5<T> siguiente){
        this.siguiente = siguiente;
    }
}
