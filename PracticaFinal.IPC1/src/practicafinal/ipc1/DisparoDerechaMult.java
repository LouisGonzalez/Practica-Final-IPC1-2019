package practicafinal.ipc1;

import java.util.TimerTask;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author luisGonzalez
 */
public class DisparoDerechaMult extends TimerTask {
    
    private int i, j, casillas, numCelda;
    private int[][] ocupado, valoresJugador;
    private JLabel resultado, numAuto, vidaAuto;
    private JLabel[][] mapa;
    private Icon bala, autoTanque, autoAvion;
    private NuevoAvatar<NombreJugador> miLista;
    private double vida;
    
    //HILO PARA EL RECORRIDO DEL DISPARO ENEMIGO
    @Override
    public void run(){
        try{
            Nodo<NombreJugador> elemento = miLista.obtenerElemento(numCelda);
            NombreJugador lista = elemento.obtenerContenido();
            Nodo2<NombreAuto> elemento2 = lista.getMiLista().obtenerElemento(Integer.parseInt(numAuto.getText()));
            NombreAuto nombre = elemento2.obtenerContenido();
            double valorFinal = Double.parseDouble(resultado.getText()); 
            vida = nombre.getVida();                  
            if(j<casillas){
                mapa[i][j].setIcon(bala);
                valorFinal = valorFinal-(valorFinal*0.04);
                if(ocupado[i][j]==1){
                switch(valoresJugador[i][j]){
                    case 1:
                        JOptionPane.showMessageDialog(null, "le has disparado al tanque de tu enemigo");
                        mapa[i][j].setIcon(autoTanque);
                        vida = vida - valorFinal;
                        vidaAuto.setText(Double.toString(vida));
                        nombre.setVida(vida);
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Le has disparado al avion de tu enemigo"); 
                        mapa[i][j].setIcon(autoAvion);
                        vida = vida - valorFinal;
                        vidaAuto.setText(Double.toString(vida));
                        nombre.setVida(vida);
                        break;
                    }
                this.cancel();    
                }
            } j++;
        } catch(Exception e){          
        }
    }
    
    public void valores(int i, int j, int casillas, int[][] ocupado, int[][] valoresJugador, JLabel resultado, JLabel[][] mapa, Icon bala, Icon autoTanque, Icon autoAvion, NuevoAvatar<NombreJugador> miLista, int numCelda, JLabel numAuto, JLabel vidaAuto){
        this.i = i;
        this.j = j;
        this.casillas = casillas;
        this.ocupado = ocupado;
        this.valoresJugador = valoresJugador;
        this.resultado = resultado;
        this.mapa = mapa;
        this.bala = bala; 
        this.autoAvion = autoAvion;
        this.autoTanque = autoTanque;
        this.miLista = miLista;
        this.numAuto = numAuto;
        this.vidaAuto = vidaAuto;
        this.numCelda = numCelda;
    }
}
