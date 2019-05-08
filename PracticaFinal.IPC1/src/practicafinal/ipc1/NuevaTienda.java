package practicafinal.ipc1;
/**
 *
 * @author luisGonzalez
 * @param <T>
 */
public class NuevaTienda<T> {
    private Nodo4<T> primerElemento;
   private Nodo4<T> ultimoElemento;
   private int cantidadElementos;
   
   //secuencia de la lista enlazada
   public Nodo4 obtenerElemento(int posicion) throws Exception {
       if(esVacia() || posicion >= cantidadElementos){
           throw new Exception("No se encuentra el indice "+posicion+" en la lista");
       }
       if(posicion == cantidadElementos - 1){
           return ultimoElemento;
       } else if (posicion ==0) {
           return primerElemento;
       } else {
           Nodo4<T> elementoEnCuestion = primerElemento;
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
           Nodo4<T> nuevoElemento = new Nodo4<T>(contenido);
           ultimoElemento.especificarSiguiente(nuevoElemento);
           ultimoElemento = nuevoElemento;
           cantidadElementos++;
       }
   }
   
   //metodo encargado de insertar todo el conteido a un lugar en especifico 
   public void insertarContenido(int posicion, T contenido) throws Exception{
       Nodo4<T> aReemplazar = obtenerElemento(posicion);
       Nodo4<T> anterior = obtenerElemento(posicion -1);
       Nodo4<T> nuevo = new Nodo4<>(contenido);
       anterior.especificarSiguiente(nuevo);
       nuevo.especificarSiguiente(aReemplazar);
       cantidadElementos++;
   }
   
   public Nodo4 obtenerPrimerElemento(){
       return primerElemento;
   }
   
   public Nodo4 obtenerUltimoElemento(){
       return ultimoElemento;
   }
   
   public int obtenerCantidadElementos(){
       return cantidadElementos;
   }
   
   public boolean esVacia(){
       return cantidadElementos == 0;
   }
   
   private void insertarPrimerElemento(T contenido){
        Nodo4<T> nuevo = new Nodo4<>(contenido);
        primerElemento = nuevo;
        ultimoElemento = nuevo;
        cantidadElementos++;
   }
}
