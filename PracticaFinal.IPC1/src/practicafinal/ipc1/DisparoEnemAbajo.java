package practicafinal.ipc1;

import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author luisGonzalez
 */
public class DisparoEnemAbajo extends TimerTask{
    
    private int i, j, casillas;
    private Icon bala, autoTanque, autoAvion;
    private JLabel[][] mapa;
    private int[][] valores;
    private JLabel vidaAuto, numAuto;
    private NuevoAvatar<NombreJugador> miLista;
    private int numCelda;
    private int vida;
    private Nodo<NombreJugador> elemento;
    private NombreJugador lista;
    private Nodo2<NombreAuto> elemento2;
    private NombreAuto nombre;
    private double valor;
    
    //HILO PARA EL RECORRIDO DEL DISPARO ENEMIGO
    @Override
    public void run(){
        try {
            elemento = miLista.obtenerElemento(numCelda);
            lista = elemento.obtenerContenido();       
            elemento2 = lista.getMiLista().obtenerElemento(Integer.parseInt(numAuto.getText()));
            nombre = elemento2.obtenerContenido(); 
            valor = nombre.getVida();
            if(i<casillas){
                mapa[i][j].setIcon(bala);
                if(valores[i][j]==1){
                    mapa[i][j].setIcon(autoTanque);
                    JOptionPane.showMessageDialog(null, "Un enemigo a acertado un golpe contra ti :/");
                    valor = valor - 10;
                    vidaAuto.setText(Double.toString(valor));
                    nombre.setVida(valor);
                    this.cancel();
                } else if(valores[i][j]==2){
                    mapa[i][j].setIcon(autoAvion);
                    JOptionPane.showMessageDialog(null, "Un enemigo a acertado un golpe contra ti :/");
                    valor = valor - 10;
                    vidaAuto.setText(Double.toString(valor));
                    nombre.setVida(valor);
                    this.cancel();               
                }            
            }
            i++; 
        } catch(Exception e){         
        } 
    }
    
    public void valores(int i, int j, int casillas, Icon bala, Icon autoTanque, Icon autoAvion, JLabel[][] mapa, int[][] valores, JLabel vidaAuto, NuevoAvatar<NombreJugador> miLista, int numCelda, JLabel numAuto, Nodo<NombreJugador> elemento, NombreJugador lista, Nodo2<NombreAuto> elemento2, NombreAuto nombre){
        this.i = i;
        this.j = j;
        this.casillas = casillas;
        this.bala = bala; 
        this.autoTanque = autoTanque;
        this.autoAvion = autoAvion;
        this.mapa = mapa;
        this.valores = valores;
        this.vidaAuto = vidaAuto;
        this.miLista = miLista;
        this.numCelda = numCelda;
        this.numAuto = numAuto;
        this.elemento = elemento;
        this.lista = lista;
        this.elemento2 = elemento2;
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }
    
    
}
