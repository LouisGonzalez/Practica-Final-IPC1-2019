package practicafinal.ipc1;
import java.util.TimerTask;
import javax.swing.Icon;
import javax.swing.JLabel;

/**
 *
 * @author luisGonzalez
 */
public class MovIzquierda2 extends TimerTask {
    
    private int i, j, valor;
    private JLabel[][] mapa;
    private int[][] tipoTerreno, enemigos, valores;
    private Icon cumbres, mar, campo, torreta, autoTanque, autoAvion;
    
    @Override
    public void run(){
        if(j>=valor){
            switch(tipoTerreno[i][j]){
                case 1:
                    mapa[i][j].setIcon(cumbres);
                    break;
                case 2:
                    mapa[i][j].setIcon(mar);
                    break;
                case 3:
                    mapa[i][j].setIcon(campo);
                    break;
            }
            if(enemigos[i][j] != 0){
                mapa[i][j].setIcon(torreta);
            } else if(valores[i][j]==1){
                mapa[i][j].setIcon(autoTanque);
            } else if(valores[i][j]==2){
                mapa[i][j].setIcon(autoAvion);
            }
        } j--;
    }
    
    public void valores(int i, int j, int valor, JLabel[][] mapa, Icon cumbres, Icon mar, Icon campo, int[][] tipoTerreno, int[][] enemigos, Icon torreta, Icon autoTanque, Icon autoAvion, int[][] valores){
        this.i = i;
        this.j = j;
        this.valor = valor;
        this.mapa = mapa;
        this.cumbres = cumbres;
        this.mar = mar;
        this.campo = campo;
        this.tipoTerreno = tipoTerreno;
        this.enemigos = enemigos;
        this.torreta = torreta;
        this.autoTanque = autoTanque;
        this.autoAvion = autoAvion;
        this.valores = valores;
    }
}
