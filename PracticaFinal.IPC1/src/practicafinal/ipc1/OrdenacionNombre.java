package practicafinal.ipc1;
/**
 *
 * @author luisGonzalez
 */
public class OrdenacionNombre {
    
    //METODOS DE ORDENAMIENTO POR ORDEN DEL NOMBRE
    public NombreAuto[] ordenarNombreAs(NuevoAuto<NombreAuto> misAutos) throws Exception{
        NombreAuto[] ordenada = copiarDatos(misAutos);
        for(int i =0; i<ordenada.length - 1; i++){
            for(int j=0; j<ordenada.length - 1; j++){
                if(ordenada[j].getNombre().compareTo(ordenada[j+1].getNombre()) > 0){
                    NombreAuto aux = ordenada[j];
                    ordenada[j] = ordenada[j+1];
                    ordenada[j+1] = aux;
                }
            }
        }
        return ordenada;
    }     
    
    public NombreAuto[] ordenarNombreDes(NuevoAuto<NombreAuto> misAutos) throws Exception{
        NombreAuto[] ordenada = copiarDatos(misAutos);
        for(int i=0; i<ordenada.length - 1; i++){
            for(int j=0; j<ordenada.length - 1; j++){
                if(ordenada[j].getNombre().compareTo(ordenada[j+1].getNombre()) < 0){
                    NombreAuto aux = ordenada[j];
                    ordenada[j] = ordenada[j+1];
                    ordenada[j+1] = aux;
                }
            }
        }
        return ordenada;
    }
    
    //METODOS DE ORDENAMIENTO POR ORDEN DE NIVEL
    public NombreAuto[] ordenarNivelAs(NuevoAuto<NombreAuto> misAutos) throws Exception{
        NombreAuto[] ordenada = copiarDatos(misAutos);
        double x, y;
        for(int i=0; i<ordenada.length - 1; i++){
            for(int j=0; j<ordenada.length - 1; j++){
                x = ordenada[j].getNivel();
                y = ordenada[j+1].getNivel();
                if(y>x){
                    NombreAuto aux = ordenada[j+1];
                    ordenada[j+1] = ordenada[j];
                    ordenada[j] = aux;
                }
            }
        }
        return ordenada;
    }
    
    public NombreAuto[] ordenarNivelDes(NuevoAuto<NombreAuto> misAutos) throws Exception{
        NombreAuto[] ordenada = copiarDatos(misAutos);
        double x, y;
        for(int i=0; i<ordenada.length - 1; i++){
            for(int j=0; j<ordenada.length - 1; j++){
                x = ordenada[j].getNivel();
                y = ordenada[j+1].getNivel();
                if(y<x){
                    NombreAuto aux = ordenada[j+1];
                    ordenada[j+1] = ordenada[j];
                    ordenada[j] = aux;
                }
            }
        }
        return ordenada;
    }
    
    //METODOS DE ORDENAMIENTO POR ORDEN DE VIDA 
    public NombreAuto[] ordenarVidaAs(NuevoAuto<NombreAuto> misAutos) throws Exception{
        NombreAuto[] ordenada = copiarDatos(misAutos);
        double x, y;
        for(int i=0; i<ordenada.length-1; i++){
            for(int j=0; j<ordenada.length-1; j++){
                x = ordenada[j].getVida();
                y = ordenada[j+1].getVida();
                if(y>x){
                    NombreAuto aux = ordenada[j+1];
                    ordenada[j+1] = ordenada[j];
                    ordenada[j] = aux;
                }
            }
        }
        return ordenada;
    }
    
    public NombreAuto[] ordenarVidaDes(NuevoAuto<NombreAuto> misAutos) throws Exception{
        NombreAuto[] ordenada = copiarDatos(misAutos);
        double x, y;
        for(int i=0; i<ordenada.length-1; i++){
            for(int j=0; j<ordenada.length-1; j++){
                x = ordenada[j].getVida();
                y = ordenada[j+1].getVida();
                if(y<x){
                    NombreAuto aux = ordenada[j+1];
                    ordenada[j+1] = ordenada[j];
                    ordenada[j] = aux;
                }
            }
        }
        return ordenada;
    }
    
    private NombreAuto[] copiarDatos(NuevoAuto<NombreAuto> misAutos) throws Exception{
        NombreAuto[] ordenada = new NombreAuto[misAutos.obtenerCantidadElementos()];
        for(int i=0; i<ordenada.length; i++){
            Nodo2<NombreAuto> elemento2 = misAutos.obtenerElemento(i);
            NombreAuto nombre = elemento2.obtenerContenido();
            ordenada[i] = nombre;
        }
        return ordenada;
    }
}
