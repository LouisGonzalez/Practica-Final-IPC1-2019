package practicafinal.ipc1;
import java.util.TimerTask;
import javax.swing.Icon;
import javax.swing.JLabel;
/**
 *
 * @author luisGonzalez
 */
public class MovArriba extends TimerTask {
    
    private int i, j, valor;
    private JLabel[][] mapa;
    Icon autoTanque;
    
    @Override
    public void run(){
        if(i>=valor){
            mapa[i-1][j].setIcon(autoTanque);
        } i--;
    }
    
    public void valores(int i, int j, int valor, JLabel[][] mapa, Icon autoTanque){
        this.i = i;
        this.j = j;
        this.valor = valor;
        this.mapa = mapa;
        this.autoTanque = autoTanque;
    }
}
