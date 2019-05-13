package practicafinal.ipc1;

import java.io.Serializable;

/**
 *
 * @author luisGonzalez
 * @param <T>
 */
public class Nodo3<T> implements Serializable{
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
