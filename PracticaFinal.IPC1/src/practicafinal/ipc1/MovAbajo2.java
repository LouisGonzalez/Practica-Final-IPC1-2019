package practicafinal.ipc1;
import java.util.TimerTask;
import javax.swing.Icon;
import javax.swing.JLabel;

/**
 *
 * @author luisGonzalez
 */
public class MovAbajo2 extends TimerTask {
    
    private int i, j, valor;
    private JLabel[][] mapa;
    private int[][] tipoTerreno;
    Icon cumbres, mar, campo;
    
    @Override
    public void run(){
        if(i<valor){
            switch(tipoTerreno[i][j]){
                case 1:
                    mapa[i][j].setIcon(cumbres);
                    break;
                case 2:
                    mapa[i][j].setIcon(mar);
                    break;
                case 3: 
                    mapa[i][j].setIcon(campo);
            }
        } i++;
    }
    
    public void valores(int i, int j, int valor, JLabel[][] mapa, Icon cumbres, Icon mar, Icon campo, int[][] tipoTerreno){
        this.i = i;
        this.j = j;
        this.valor = valor;
        this.mapa = mapa;
        this.cumbres = cumbres;
        this.mar = mar;
        this.campo = campo;
        this.tipoTerreno = tipoTerreno;
    }
    
}
