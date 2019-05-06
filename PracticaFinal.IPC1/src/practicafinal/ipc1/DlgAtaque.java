package practicafinal.ipc1;
import java.util.Timer;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author luisGonzalez
 */
public class DlgAtaque extends javax.swing.JDialog {

    private String movDisparo;
    private int i, j, casillas;
    private JLabel[][] mapa;
    private Icon balaArriba, balaAbajo, balaIzquierda, balaDerecha, cumbres, mar, campo;
    private int[][] tipoTerreno;
    
    public DlgAtaque(java.awt.Frame parent, boolean modal, int i, int j, int casillas, JLabel[][]mapa, Icon balaArriba, Icon balaAbajo, Icon balaIzquierda, Icon balaDerecha, Icon cumbres, Icon mar, Icon campo, int[][] tipoTerreno) {
        super(parent, modal);
        this.i = i;
        this.j = j;
        this.casillas = casillas;
        this.mapa = mapa;
        this.balaArriba = balaArriba;
        this.balaAbajo = balaAbajo;
        this.balaIzquierda = balaIzquierda;
        this.balaDerecha = balaDerecha;
        this.cumbres = cumbres;
        this.mar = mar;
        this.campo = campo;
        this.tipoTerreno = tipoTerreno;
        initComponents();
        setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        direccionAtaque = new javax.swing.JComboBox<>();
        disparo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        direccionAtaque.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Arriba", "Abajo", "Izquierda", "Derecha" }));
        getContentPane().add(direccionAtaque, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 93, 100, -1));

        disparo.setText("Aceptar");
        disparo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disparoActionPerformed(evt);
            }
        });
        getContentPane().add(disparo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void disparoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disparoActionPerformed
        Timer timer = new Timer();
        MovBalaAbajo abajo = new MovBalaAbajo();
        MovAbajo2 abajo2 = new MovAbajo2();
        MovBalaArriba arriba = new MovBalaArriba();
        MovArriba2 arriba2 = new MovArriba2();
        MovBalaIzquierda izquierda = new MovBalaIzquierda();
        MovIzquierda2 izquierda2 = new MovIzquierda2();
        MovBalaDerecha derecha = new MovBalaDerecha();
        MovDerecha2 derecha2 = new MovDerecha2();
        movDisparo = direccionAtaque.getSelectedItem().toString();
        switch(movDisparo){
            case "Arriba":
                arriba.valores(i-1, j, mapa, balaArriba);
                arriba2.valores(i-1, j, 0, mapa, cumbres, mar, campo, tipoTerreno);
                timer.schedule(arriba, 0, 1000);
                timer.schedule(arriba2, 1000, 1000);
                break;
            case "Abajo":
                abajo.valores(i+1, j, casillas, mapa, balaAbajo);
                abajo2.valores(i+1, j, casillas, mapa, cumbres, mar, campo, tipoTerreno);
                timer.schedule(abajo, 0, 1000);
                timer.schedule(abajo2, 1000, 1000);
                break;
            case "Izquierda":
                izquierda.valores(i, j-1, mapa, balaIzquierda);
                izquierda2.valores(i, j-1, 0, mapa, cumbres, mar, campo, tipoTerreno);
                timer.schedule(izquierda, 0, 1000);
                timer.schedule(izquierda2, 1000, 1000);
                break;
            case "Derecha":
                derecha.valores(i, j+1, casillas, mapa, balaDerecha);
                derecha2.valores(i, j+1, casillas, mapa, cumbres, mar, campo, tipoTerreno);
                timer.schedule(derecha, 0, 1000);
                timer.schedule(derecha2, 1000, 1000);
                break;
        }
    }//GEN-LAST:event_disparoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> direccionAtaque;
    private javax.swing.JButton disparo;
    // End of variables declaration//GEN-END:variables
}
