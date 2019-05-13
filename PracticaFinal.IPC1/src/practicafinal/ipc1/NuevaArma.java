package practicafinal.ipc1;

import java.io.Serializable;

/**
 *
 * @author luisGonzalez
 * @param <T>
 */
public class NuevaArma<T> implements Serializable{
    private Nodo5<T> primerElemento;
   private Nodo5<T> ultimoElemento;
   private int cantidadElementos;
   
   //secuencia de la lista enlazada
   public Nodo5 obtenerElemento(int posicion) throws Exception {
       if(esVacia() || posicion >= cantidadElementos){
           throw new Exception("No se encuentra el indice "+posicion+" en la lista");
       }
       if(posicion == cantidadElementos - 1){
           return ultimoElemento;
       } else if (posicion ==0) {
           return primerElemento;
       } else {
           Nodo5<T> elementoEnCuestion = primerElemento;
           for(int i = 0; i < posicion; i++){
               elementoEnCuestion = elementoEnCuestion.obtenerSiguiente();
           }
           return elementoEnCuestion;
       }
   }
   
   //metodo encargado de insertar un nuevo elemento a la lista enlazada
   public void insertarContenido(T contenido){
       if(esVacia()){
           insertarPrimerElemento(contenido);
       } else {
           Nodo5<T> nuevoElemento = new Nodo5<T>(contenido);
           ultimoElemento.especificarSiguiente(nuevoElemento);
           ultimoElemento = nuevoElemento;
           cantidadElementos++;
       }
   }
   
   //metodo encargado de insertar todo el conteido a un lugar en especifico 
   public void insertarContenido(int posicion, T contenido) throws Exception{
       Nodo5<T> aReemplazar = obtenerElemento(posicion);
       Nodo5<T> anterior = obtenerElemento(posicion -1);
       Nodo5<T> nuevo = new Nodo5<>(contenido);
       anterior.especificarSiguiente(nuevo);
       nuevo.especificarSiguiente(aReemplazar);
       cantidadElementos++;
   }
   
   public Nodo5 obtenerPrimerElemento(){
       return primerElemento;
   }
   
   public Nodo5 obtenerUltimoElemento(){
       return ultimoElemento;
   }
   
   public int obtenerCantidadElementos(){
       return cantidadElementos;
   }
   
   public boolean esVacia(){
       return cantidadElementos == 0;
   }
   
   private void insertarPrimerElemento(T contenido){
        Nodo5<T> nuevo = new Nodo5<>(contenido);
        primerElemento = nuevo;
        ultimoElemento = nuevo;
        cantidadElementos++;
   }
}
