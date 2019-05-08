package practicafinal.ipc1;

import java.util.TimerTask;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author luisGonzalez
 */
public class DisparoEnemDerecha extends TimerTask {
    
    private int i, j, casillas;
    private Icon bala, autoTanque, autoAvion;
    private JLabel[][] mapa;
    private int[][] valores;
    
    @Override
    public void run(){
        if(j<casillas){
            mapa[i][j].setIcon(bala);
            if(valores[i][j]==1){
                mapa[i][j].setIcon(autoTanque);
                JOptionPane.showMessageDialog(null, "Un enemigo a acertado un golpe contra ti :/");
                this.cancel();
            } else if(valores[i][j]==2){
                mapa[i][j].setIcon(autoAvion);
                JOptionPane.showMessageDialog(null, "Un enemigo a acertado un golpe contra ti :/");
                this.cancel();
            }
        }j++;
    }
    
    public void valores(int i, int j, int casillas, Icon bala, Icon autoTanque, Icon autoAvion, JLabel[][] mapa, int[][] valores){
        this.i = i;
        this.j = j;
        this.casillas = casillas;
        this.bala = bala;
        this.autoTanque = autoTanque;
        this.autoAvion = autoAvion;
        this.mapa = mapa;
        this.valores = valores;
    }
}
