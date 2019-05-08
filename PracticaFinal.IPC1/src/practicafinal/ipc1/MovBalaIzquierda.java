package practicafinal.ipc1;
import java.util.TimerTask;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author luisGonzalez
 */
public class MovBalaIzquierda extends TimerTask {
    
    private int i, j;
    private JLabel[][] mapa;
    private Icon bala, torreta;
    private int[][] ocupado, enemigos;
    private JLabel enemigo1, enemigo2, enemigo3, enemigo4;
    
    @Override
    public void run(){
        if(j>=0){
            mapa[i][j].setIcon(bala);
            if(ocupado[i][j] == 1){
                mapa[i][j].setIcon(torreta);
                switch(enemigos[i][j]){
                case 1:
                    JOptionPane.showMessageDialog(null, "le has disparado al enemigo 1");
                    enemigo1.setText(Integer.toString(Integer.parseInt(enemigo1.getText()) - 10));
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Le has disparado al enemigo 2");
                    enemigo2.setText(Integer.toString(Integer.parseInt(enemigo2.getText()) - 10));
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Le has disparado al enemigo 3");
                    enemigo3.setText(Integer.toString(Integer.parseInt(enemigo3.getText()) - 10));
                    break;
                case 4: 
                    JOptionPane.showMessageDialog(null, "Le has disparado al enemigo 4");
                    enemigo4.setText(Integer.toString(Integer.parseInt(enemigo4.getText()) - 10)); 
                    break;
                }this.cancel();
            }
        } j--;
    }
          
    public void valores(int i, int j, JLabel[][] mapa, Icon bala, int[][] ocupado, Icon torreta, int[][] enemigos, JLabel enemigo1, JLabel enemigo2, JLabel enemigo3, JLabel enemigo4){
        this.i = i;
        this.j = j;
        this.mapa = mapa;
        this.bala = bala;
        this.ocupado = ocupado;
        this.torreta = torreta;
        this.enemigos = enemigos;
        this.enemigo1 = enemigo1;
        this.enemigo2 = enemigo2;
        this.enemigo3 = enemigo3;
        this.enemigo4 = enemigo4;
    }
}
