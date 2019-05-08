package practicafinal.ipc1;
import java.util.TimerTask;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 *
 * @author luisGonzalez
 */
public class MovBalaDerecha extends TimerTask {
    
    private int i, j, casillas;
    private JLabel[][] mapa;
    private Icon bala, torreta;
    private int[][] ocupado, enemigos;
    private JLabel enemigo1, enemigo2, enemigo3, enemigo4, resultado;  
    
    @Override
    public void run(){
        double valorFinal = Double.parseDouble(resultado.getText());
        if(j<casillas){
            mapa[i][j].setIcon(bala);
            valorFinal = valorFinal-(valorFinal*0.04);
            if(ocupado[i][j] == 1){
                mapa[i][j].setIcon(torreta);
                switch(enemigos[i][j]){
                case 1:
                    JOptionPane.showMessageDialog(null, "le has disparado al enemigo 1");
                    enemigo1.setText(Double.toString(Double.parseDouble(enemigo1.getText()) - valorFinal));                    
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Le has disparado al enemigo 2");
                    enemigo2.setText(Double.toString(Double.parseDouble(enemigo2.getText()) - valorFinal));                    
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Le has disparado al enemigo 3");
                    enemigo3.setText(Double.toString(Double.parseDouble(enemigo3.getText()) - valorFinal));                    
                    break;
                case 4: 
                    JOptionPane.showMessageDialog(null, "Le has disparado al enemigo 4");
                    enemigo4.setText(Double.toString(Double.parseDouble(enemigo4.getText()) - valorFinal));                    
                    break;
                }
                this.cancel();
            }
                
            
        } j++;
    }
    
    public void valores(int i, int j, int casillas, JLabel[][] mapa, Icon bala, int[][] ocupado, Icon torreta, int[][] enemigos, JLabel enemigo1, JLabel enemigo2, JLabel enemigo3, JLabel enemigo4, JLabel resultado){
        this.i = i;
        this.j = j;
        this.casillas = casillas;
        this.mapa = mapa;
        this.bala = bala;
        this.ocupado = ocupado;
        this.torreta = torreta;
        this.enemigos = enemigos;
        this.enemigo1 = enemigo1;
        this.enemigo2 = enemigo2;
        this.enemigo3 = enemigo3;
        this.enemigo4 = enemigo4;
        this.resultado = resultado;
    }
    
}
