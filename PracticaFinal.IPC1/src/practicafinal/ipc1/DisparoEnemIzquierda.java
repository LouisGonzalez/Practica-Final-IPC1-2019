package practicafinal.ipc1;

import java.util.TimerTask;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author luisGonzalez
 */
public class DisparoEnemIzquierda extends TimerTask {
    
    private int i, j, numCelda;
    private JLabel[][] mapa;
    private Icon bala, autoTanque, autoAvion;
    private int[][] valores;
    private JLabel vidaAuto, numAuto;
    private NuevoAvatar<NombreJugador> miLista;
    private Nodo<NombreJugador> elemento;
    private NombreJugador lista;
    private Nodo2<NombreAuto> elemento2;
    private NombreAuto nombre;
    private double valor;
    
    
    //HILO PARA EL RECORRIDO DEL DISPARO ENEMIGO
    @Override
    public void run(){
        try{
            elemento = miLista.obtenerElemento(numCelda);
            lista = elemento.obtenerContenido();       
            elemento2 = lista.getMiLista().obtenerElemento(Integer.parseInt(numAuto.getText()));
            nombre = elemento2.obtenerContenido(); 
            valor = nombre.getVida();                         
            if(j>=0){
                mapa[i][j].setIcon(bala);
                if(valores[i][j]==1){
                    mapa[i][j].setIcon(autoTanque);
                    JOptionPane.showMessageDialog(null, "Un enemigo ha acertado un golpe contra ti :/");
                    valor = valor - 10;
                    vidaAuto.setText(Double.toString(valor));
                    nombre.setVida(valor);
                    this.cancel();
                } else if (valores[i][j]==2){
                    mapa[i][j].setIcon(autoAvion);
                    JOptionPane.showMessageDialog(null, "Un enemigo ha acertado un golpe contra ti :/");
                    valor = valor - 10;
                    vidaAuto.setText(Double.toString(valor));
                    nombre.setVida(valor);
                    this.cancel();
                }
            }j--;
        } catch(Exception e){            
        }
    }
    
    public void valores(int i, int j, JLabel[][] mapa, Icon bala, Icon autoTanque, Icon autoAvion, int[][] valores, JLabel vidaAuto, Nodo<NombreJugador> elemento, NombreJugador lista, Nodo2<NombreAuto> elemento2, NombreAuto nombre, NuevoAvatar<NombreJugador> miLista, JLabel numAuto, int numCelda){
        this.i = i;
        this.j = j;
        this.mapa = mapa;
        this.bala = bala;
        this.autoTanque = autoTanque;
        this.autoAvion = autoAvion;
        this.valores = valores;
        this.vidaAuto = vidaAuto;
        this.elemento = elemento;
        this.lista = lista;
        this.elemento2 = elemento2;
        this.nombre = nombre;
        this.miLista = miLista;
        this.numAuto = numAuto;
        this.numCelda = numCelda;
    }
}
