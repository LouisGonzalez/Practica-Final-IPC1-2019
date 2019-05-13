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
    
    //METODO DE ORDENAMIENTO POR ORDEN DE EXPERIENCIA
    public NombreAuto[] ordenarXpAs(NuevoAuto<NombreAuto> misAutos) throws Exception{
        NombreAuto[] ordenada = copiarDatos(misAutos);
        double x, y;
        for(int i=0; i<ordenada.length-1; i++){
            for(int j=0; j<ordenada.length-1; j++){
                x = ordenada[j].getExperiencia();
                y = ordenada[j+1].getExperiencia();
                if(y>x){
                    NombreAuto aux = ordenada[j+1];
                    ordenada[j+1] = ordenada[j];
                    ordenada[j] = aux;
                }
            }
        }
        return ordenada;
    }
    
    public NombreAuto[] ordenarXpDes(NuevoAuto<NombreAuto> misAutos) throws Exception{
        NombreAuto[] ordenada = copiarDatos(misAutos);
        double x, y;
        for(int i=0; i<ordenada.length-1; i++){
            for(int j=0; j<ordenada.length-1; j++){
                x = ordenada[j].getExperiencia();
                y = ordenada[j+1].getExperiencia();
                if(y<x){
                    NombreAuto aux = ordenada[j+1];
                    ordenada[j+1] = ordenada[j];
                    ordenada[j] = aux;
                }
            }
        }
        return ordenada;
    }
    
    //METODO DE ORDENAMIENTO POR ORDEN DE ENEMIGOS DESTRUIDOS
    public NombreAuto[] ordenarEnemAs(NuevoAuto<NombreAuto> misAutos) throws Exception{
        NombreAuto[] ordenada = copiarDatos(misAutos);
        double x, y;
        for(int i=0; i<ordenada.length-1; i++){
            for(int j=0; j<ordenada.length-1; j++){
                x = ordenada[j].getEnemigosDestruidos();
                y = ordenada[j+1].getEnemigosDestruidos();
                if(y>x){
                    NombreAuto aux = ordenada[j+1];
                    ordenada[j+1] = ordenada[j];
                    ordenada[j] = aux;
                }
            }
        }
        return ordenada;
    }
    
    public NombreAuto[] ordenarEnemDes(NuevoAuto<NombreAuto> misAutos) throws Exception{
        NombreAuto[] ordenada = copiarDatos(misAutos);
        double x, y;
        for(int i=0; i<ordenada.length-1; i++){
            for(int j=0; j<ordenada.length-1; j++){
                x = ordenada[j].getEnemigosDestruidos();
                y = ordenada[j+1].getEnemigosDestruidos();
                if(y<x){
                    NombreAuto aux = ordenada[j+1];
                    ordenada[j+1] = ordenada[j];
                    ordenada[j] = aux;
                }
            }
        }
        return ordenada;
    }
    
    //METODO DE ORDENAMIENTO POR ORDE DE ATAQUE
    public NombreAuto[] ordenarAtaqueAs(NuevoAuto<NombreAuto> misAutos) throws Exception{
        NombreAuto[] ordenada = copiarDatos(misAutos);
        double x, y;
        for(int i=0; i<ordenada.length-1; i++){
            for(int j=0; j<ordenada.length-1; j++){
                x = ordenada[j].getAtaque();
                y = ordenada[j+1].getAtaque();
                if(y>x){
                    NombreAuto aux = ordenada[j+1];
                    ordenada[j+1] = ordenada[j];
                    ordenada[j] = aux;
                }
            }
        }
        return ordenada;
    }
    
    public NombreAuto[] ordenarAtaqueDes(NuevoAuto<NombreAuto> misAutos) throws Exception{
        NombreAuto[] ordenada = copiarDatos(misAutos);
        double x, y;
        for(int i=0; i<ordenada.length-1; i++){
            for(int j=0; j<ordenada.length-1; j++){
                x = ordenada[j].getAtaque();
                y = ordenada[j+1].getAtaque();
                if(y<x){
                    NombreAuto aux = ordenada[j+1];
                    ordenada[j+1] = ordenada[j];
                    ordenada[j] = aux;
                }
            }
        }
        return ordenada;
    }
    
    //METODO DE ORDENAMIENTO POR ORDEN DE ARMADURA
    public NombreAuto[] ordenarArmaduraAs(NuevoAuto<NombreAuto> misAutos) throws Exception{
        NombreAuto[] ordenada = copiarDatos(misAutos);
        double x, y;
        for(int i=0; i<ordenada.length-1; i++){
            for(int j=0; j<ordenada.length-1; j++){
                x = ordenada[j].getArmadura();
                y = ordenada[j+1].getArmadura();
                if(y>x){
                    NombreAuto aux = ordenada[j+1];
                    ordenada[j+1] = ordenada[j];
                    ordenada[j] = aux;
                }
            }
        }
        return ordenada;
    }
    
    public NombreAuto[] ordenarArmaduraDes(NuevoAuto<NombreAuto> misAutos) throws Exception{
        NombreAuto[] ordenada = copiarDatos(misAutos);
        double x, y;
        for(int i=0; i<ordenada.length-1; i++){
            for(int j=0; j<ordenada.length-1; j++){
                x = ordenada[j].getArmadura();
                y = ordenada[j+1].getArmadura();
                if(y<x){
                    NombreAuto aux = ordenada[j+1];
                    ordenada[j+1] = ordenada[j];
                    ordenada[j] = aux;
                }
            }
        }
        return ordenada;
    }
    
    //METODO DE ORDENAMIENTO POR CANTIDAD DE VECES QUE EL AUTO HA SIDO DESTRUIDO
    public NombreAuto[] ordenarDestruidoAs(NuevoAuto<NombreAuto> misAutos) throws Exception{
        NombreAuto[] ordenada = copiarDatos(misAutos);
        double x, y;
        for(int i=0; i<ordenada.length-1; i++){
            for(int j=0; j<ordenada.length-1; j++){
                x = ordenada[j].getAutoDestruido();
                y = ordenada[j+1].getAutoDestruido();
                if(y>x){
                    NombreAuto aux = ordenada[j+1];
                    ordenada[j+1] = ordenada[j];
                    ordenada[j] = aux;
                }
            }
        }
        return ordenada;
    }
    
    public NombreAuto[] ordenarDestruidoDes(NuevoAuto<NombreAuto> misAutos) throws Exception{
        NombreAuto[] ordenada = copiarDatos(misAutos);
        double x, y;
        for(int i=0; i<ordenada.length-1; i++){
            for(int j=0; j<ordenada.length-1; j++){
                x = ordenada[j].getAutoDestruido();
                y = ordenada[j+1].getAutoDestruido();
                if(y<x){
                    NombreAuto aux = ordenada[j+1];
                    ordenada[j+1] = ordenada[j];
                    ordenada[j] = aux;
                }
            }
        }
        return ordenada;
    }
    
    //METODO DE ORDENAMIENTO POR ORDEN DE PARTIDAS GANADAS
     public NombreJugador[] ordenarVictoriaAs(NuevoAvatar<NombreJugador> miLista) throws Exception{
        NombreJugador[] ordenada = copiarDatos2(miLista);
        double x, y;
        for(int i=0; i<ordenada.length-1; i++){
            for(int j=0; j<ordenada.length-1; j++){
                x = ordenada[j].getContPartidasGanadas();
                y = ordenada[j+1].getContPartidasGanadas();
                if(y>x){
                    NombreJugador aux = ordenada[j+1];
                    ordenada[j+1] = ordenada[j];
                    ordenada[j] = aux;
                }
            }
        }
        return ordenada;
    }
    
    public NombreJugador[] ordenarVictoriaDes(NuevoAvatar<NombreJugador> miLista) throws Exception{
        NombreJugador[] ordenada = copiarDatos2(miLista);
        double x, y;
        for(int i=0; i<ordenada.length-1; i++){
            for(int j=0; j<ordenada.length-1; j++){
                x = ordenada[j].getContPartidasGanadas();
                y = ordenada[j+1].getContPartidasGanadas();
                if(y<x){
                    NombreJugador aux = ordenada[j+1];
                    ordenada[j+1] = ordenada[j];
                    ordenada[j] = aux;
                }
            }
        }
        return ordenada;
    }
    
    //METODO DE ORDENAMIENTO POR ORDEN DE PARTIDAS PERDIDAS
     public NombreJugador[] ordenarDerrotasAs(NuevoAvatar<NombreJugador> miLista) throws Exception{
        NombreJugador[] ordenada = copiarDatos2(miLista);
        double x, y;
        for(int i=0; i<ordenada.length-1; i++){
            for(int j=0; j<ordenada.length-1; j++){
                x = ordenada[j].getContPartidasPerdidas();
                y = ordenada[j+1].getContPartidasPerdidas();
                if(y>x){
                    NombreJugador aux = ordenada[j+1];
                    ordenada[j+1] = ordenada[j];
                    ordenada[j] = aux;
                }
            }
        }
        return ordenada;
    }
    
    public NombreJugador[] ordenarDerrotasDes(NuevoAvatar<NombreJugador> miLista) throws Exception{
        NombreJugador[] ordenada = copiarDatos2(miLista);
        double x, y;
        for(int i=0; i<ordenada.length-1; i++){
            for(int j=0; j<ordenada.length-1; j++){
                x = ordenada[j].getContPartidasPerdidas();
                y = ordenada[j+1].getContPartidasPerdidas();
                if(y<x){
                    NombreJugador aux = ordenada[j+1];
                    ordenada[j+1] = ordenada[j];
                    ordenada[j] = aux;
                }
            }
        }
        return ordenada;
    }
    
    //METODO DE ORDENAMIENTO POR ORDEN DE TOTAL DE PARTIDAS
    public NombreJugador[] ordenarPartidasAs(NuevoAvatar<NombreJugador> miLista) throws Exception{
        NombreJugador[] ordenada = copiarDatos2(miLista);
        double x, y;
        for(int i=0; i<ordenada.length-1; i++){
            for(int j=0; j<ordenada.length-1; j++){
                x = ordenada[j].getTotalPartidas();
                y = ordenada[j+1].getTotalPartidas();
                if(y>x){
                    NombreJugador aux = ordenada[j+1];
                    ordenada[j+1] = ordenada[j];
                    ordenada[j] = aux;
                }
            }
        }
        return ordenada;
    }
    
    public NombreJugador[] ordenarPartidasDes(NuevoAvatar<NombreJugador> miLista) throws Exception{
        NombreJugador[] ordenada = copiarDatos2(miLista);
        double x, y;
        for(int i=0; i<ordenada.length-1; i++){
            for(int j=0; j<ordenada.length-1; j++){
                x = ordenada[j].getTotalPartidas();
                y = ordenada[j+1].getTotalPartidas();
                if(y<x){
                    NombreJugador aux = ordenada[j+1];
                    ordenada[j+1] = ordenada[j];
                    ordenada[j] = aux;
                }
            }
        }
        return ordenada;
    }
    
    //METODOS DE ORDENAMIENTO POR ORDEN DEL NOMBRE
    public NombreJugador[] ordenarNombresAs(NuevoAvatar<NombreJugador> miLista) throws Exception{
        NombreJugador[] ordenada = copiarDatos2(miLista);
        for(int i =0; i<ordenada.length - 1; i++){
            for(int j=0; j<ordenada.length - 1; j++){
                if(ordenada[j].getNombre().compareTo(ordenada[j+1].getNombre()) > 0){
                    NombreJugador aux = ordenada[j];
                    ordenada[j] = ordenada[j+1];
                    ordenada[j+1] = aux;
                }
            }
        }
        return ordenada;
    }     
    
    public NombreJugador[] ordenarNombresDes(NuevoAvatar<NombreJugador> miLista) throws Exception{
        NombreJugador[] ordenada = copiarDatos2(miLista);
        for(int i=0; i<ordenada.length - 1; i++){
            for(int j=0; j<ordenada.length - 1; j++){
                if(ordenada[j].getNombre().compareTo(ordenada[j+1].getNombre()) < 0){
                    NombreJugador aux = ordenada[j];
                    ordenada[j] = ordenada[j+1];
                    ordenada[j+1] = aux;
                }
            }
        }
        return ordenada;
    }
    
    //METODOS DE ORDENAMIENTO POR CANTIDAD DE ORO
    public NombreJugador[] ordenarOroAs(NuevoAvatar<NombreJugador> miLista) throws Exception{
        NombreJugador[] ordenada = copiarDatos2(miLista);
        double x, y;
        for(int i=0; i<ordenada.length-1; i++){
            for(int j=0; j<ordenada.length-1; j++){
                x = ordenada[j].getOro();
                y = ordenada[j+1].getOro();
                if(y>x){
                    NombreJugador aux = ordenada[j+1];
                    ordenada[j+1] = ordenada[j];
                    ordenada[j] = aux;
                }
            }
        }
        return ordenada;
    }
    
    public NombreJugador[] ordenarOroDes(NuevoAvatar<NombreJugador> miLista) throws Exception{
        NombreJugador[] ordenada = copiarDatos2(miLista);
        double x, y;
        for(int i=0; i<ordenada.length-1; i++){
            for(int j=0; j<ordenada.length-1; j++){
                x = ordenada[j].getOro();
                y = ordenada[j+1].getOro();
                if(y<x){
                    NombreJugador aux = ordenada[j+1];
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
    
    private NombreJugador[] copiarDatos2(NuevoAvatar<NombreJugador> miLista) throws Exception{
        NombreJugador[] ordenada = new NombreJugador[miLista.obtenerCantidadElementos()];
        for(int i=0; i<ordenada.length; i++){
            Nodo<NombreJugador> elemento = miLista.obtenerElemento(i);
            NombreJugador nombre = elemento.obtenerContenido();
            ordenada[i] = nombre;
        }
        return ordenada;
    }
}
