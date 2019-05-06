package practicafinal.ipc1;
import java.util.TimerTask;
import javax.swing.Icon;
import javax.swing.JLabel;

/**
 *
 * @author luisGonzalez
 */
public class MovBalaIzquierda extends TimerTask {
    
    private int i, j;
    private JLabel[][] mapa;
    private Icon bala;
    
    @Override
    public void run(){
        if(j>=0){
            mapa[i][j].setIcon(bala);
        } j--;
    }
          
    public void valores(int i, int j, JLabel[][] mapa, Icon bala){
        this.i = i;
        this.j = j;
        this.mapa = mapa;
        this.bala = bala;
    }
}
