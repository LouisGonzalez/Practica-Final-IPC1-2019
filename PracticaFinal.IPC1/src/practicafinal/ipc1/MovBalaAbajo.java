package practicafinal.ipc1;
import java.util.TimerTask;
import javax.swing.Icon;
import javax.swing.JLabel;

/**
 *
 * @author luisGonzalez
 */
public class MovBalaAbajo extends TimerTask {
    
    private int i, j, casillas;
    private JLabel[][] mapa;
    private Icon dado;
    
    @Override 
    public void run(){
        if(i<casillas){
            mapa[i][j].setIcon(dado);
        } i++;
    }
    
    public void valores(int i, int j, int casillas, JLabel[][] mapa, Icon dado){
        this.i = i;
        this.j = j;
        this.casillas = casillas;
        this.mapa = mapa;
        this.dado = dado;
    }
}
