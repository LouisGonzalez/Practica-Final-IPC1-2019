package practicafinal.ipc1;

import java.io.Serializable;

/**
 *
 * @author luisGonzalez
 * @param <T>
 */
public class Nodo<T> implements Serializable{
    private T contenido;
    private Nodo siguiente;
    
    public Nodo(T contenido){
        this.contenido = contenido;
    }
    
    public T obtenerContenido(){
        return contenido;
    }
    
    public Nodo obtenerSiguiennte(){
        return siguiente;
    }
    
    public void especificarSiguiente(Nodo<T> siguiente){
        this.siguiente = siguiente;
    }
}
