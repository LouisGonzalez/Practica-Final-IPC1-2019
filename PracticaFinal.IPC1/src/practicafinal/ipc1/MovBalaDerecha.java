package practicafinal.ipc1;
import java.util.TimerTask;
import javax.swing.Icon;
import javax.swing.JLabel;
/**
 *
 * @author luisGonzalez
 */
public class MovBalaDerecha extends TimerTask {
    
    private int i, j, casillas;
    private JLabel[][] mapa;
    private Icon bala;
    
    @Override
    public void run(){
        if(j<casillas){
            mapa[i][j].setIcon(bala);
        } j++;
    }
    
    public void valores(int i, int j, int casillas, JLabel[][] mapa, Icon bala){
        this.i = i;
        this.j = j;
        this.casillas = casillas;
        this.mapa = mapa;
        this.bala = bala;
    }
    
}
