package practicafinal.ipc1;

import java.util.TimerTask;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author luisGonzalez
 */
public class DisparoArribaMult extends TimerTask{
    
    private int i, j;
    private int[][] ocupado, valoresJugador;
    private JLabel resultado;
    private JLabel[][] mapa;
    private Icon bala, autoTanque, autoAvion;
    
    @Override
    public void run(){
    double valorFinal = Double.parseDouble(resultado.getText());
        if(i>=0){
            mapa[i][j].setIcon(bala);  
            valorFinal = valorFinal-(valorFinal*0.04);
            if(ocupado[i][j]==1){
                switch(valoresJugador[i][j]){
                case 1:
                    JOptionPane.showMessageDialog(null, "le has disparado al tanque de tu enemigo");
                    mapa[i][j].setIcon(autoTanque);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Le has disparado al avion de tu enemigo");
                    mapa[i][j].setIcon(autoAvion);
                    break;
                }
                this.cancel();
            }
        } i--;
    }
    
    public void valores(int i, int j, int[][] ocupado, int[][] valoresJugador, JLabel resultado, JLabel[][] mapa, Icon bala, Icon autoTanque, Icon autoAvion){
        this.i = i; 
        this.j = j;
        this.ocupado = ocupado;
        this.valoresJugador = valoresJugador;
        this.resultado = resultado;
        this.mapa = mapa;
        this.bala = bala;
        this.autoTanque = autoTanque;
        this.autoAvion = autoAvion;
        
    }
}
