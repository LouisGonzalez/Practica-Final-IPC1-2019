package practicafinal.ipc1;
import java.util.TimerTask;
import javax.swing.Icon;
import javax.swing.JLabel;

/**
 *
 * @author luisGonzalez
 */
public class MovDerecha extends TimerTask{
    
    private int i, j, valor;
    private JLabel[][] mapa;
    private Icon autoTanque;
    
    @Override
    public void run(){
        if(j<valor){
            mapa[i][j+1].setIcon(autoTanque);
        } j++;
    }
    
    public void valores(int i, int j, int valor, JLabel[][] mapa, Icon autoTanque){
        this.i = i;
        this.j = j;
        this.valor = valor;
        this.mapa = mapa;
        this.autoTanque = autoTanque;
    }
}
