package practicafinal.ipc1;

import java.util.TimerTask;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author luisGonzalez
 */
public class DisparoEnemArriba extends TimerTask {
    
    private int i, j;
    private JLabel[][] mapa;
    private Icon bala, autoTanque, autoAvion;
    private int[][] valores;
    
    @Override
    public void run(){
        if(i>=0){
            mapa[i][j].setIcon(bala);
            if(valores[i][j]==1){
                mapa[i][j].setIcon(autoTanque);
                JOptionPane.showMessageDialog(null, "Un enemigo te ha acertado un disparo :/");
                this.cancel();
            } else if(valores[i][j]==2){
                mapa[i][j].setIcon(autoAvion);
                JOptionPane.showMessageDialog(null, "Un enemigo te ha acertado un disparo :/");
                this.cancel();
            }
        } i--;
    }
    
    public void valores(int i, int j, JLabel[][] mapa, Icon bala, Icon autoTanque, Icon autoAvion, int[][] valores){
        this.i = i;
        this.j = j;
        this.mapa = mapa;
        this.bala = bala;
        this.autoTanque = autoTanque;
        this.autoAvion = autoAvion;
        this.valores = valores;
    }
}
