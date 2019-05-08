package practicafinal.ipc1;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luisGonzalez
 */
public class DlgOpcionesJugador extends javax.swing.JDialog {
    
    private NuevoAvatar<NombreJugador> misAutos;
    private NuevoEnemigo<Enemigo> enemigo;
    private int[][] tipoTerreno, valores;
    JLabel[][] mapa;
    private int posX, posY, x, y, i, j, casillas, numCelda;
    private Icon autoTanque, autoAvion, cumbres, mar, campo, balaArriba, balaAbajo, balaIzquierda, balaDerecha, torreta;
    private JLabel numAuto, enemigo1, enemigo2, enemigo3, enemigo4, vidaAuto, nivelAuto, ataqueAuto;
    private int[][] enemigos, ocupado;
    Object [] fila;
    private DefaultTableModel modelMapa2;
    private double[] vida;
    private JPanel panelEnemigos;
    
    public DlgOpcionesJugador(java.awt.Frame parent, boolean modal, NuevoAvatar<NombreJugador> misAutos, int numCelda, JLabel[][] mapa, int posX, int posY, Icon autoTanque, Icon autoAvion, Icon cumbres, Icon mar, Icon campo, int[][] tipoTerreno, int x, int y, int[][] valores, int casillas, int i, int j, JLabel numAuto, Icon balaArriba, Icon balaAbajo, Icon balaIzquierda, Icon balaDerecha, NuevoEnemigo<Enemigo> enemigo, int[][] enemigos, int[][] ocupado, Icon torreta, Object[] fila, DefaultTableModel modelMapa2, double[] vida, JPanel panelEnemigos, JLabel enemigo1, JLabel enemigo2, JLabel enemigo3, JLabel enemigo4, JLabel vidaAuto, JLabel nivelAuto, JLabel ataqueAuto) {
        super(parent, modal);
        this.misAutos = misAutos;
        this.numCelda = numCelda;
        this.mapa = mapa;
        this.posX = posX;
        this.posY = posY;
        this.autoAvion = autoAvion;
        this.autoTanque = autoTanque;
        this.cumbres = cumbres;
        this.mar = mar;
        this.campo = campo;
        this.tipoTerreno = tipoTerreno;
        this.x = x;
        this.y = y;
        this.valores = valores;
        this.casillas = casillas;
        this.i = i;
        this.j = j;
        this.numAuto = numAuto;
        this.balaArriba = balaArriba;
        this.balaAbajo = balaAbajo;
        this.balaIzquierda = balaIzquierda;
        this.balaDerecha = balaDerecha;
        this.enemigo = enemigo;
        this.enemigos = enemigos;
        this.ocupado = ocupado;
        this.torreta = torreta;
        this.fila = fila;
        this.modelMapa2 = modelMapa2;
        this.vida = vida;
        this.panelEnemigos = panelEnemigos;
        this.enemigo1 = enemigo1;
        this.enemigo2 = enemigo2;
        this.enemigo3 = enemigo3;
        this.enemigo4 = enemigo4; 
        this.vidaAuto = vidaAuto;
        this.nivelAuto = nivelAuto;
        this.ataqueAuto = ataqueAuto;
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ataque = new javax.swing.JButton();
        cambioAuto = new javax.swing.JButton();
        dadoMov = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        ataque.setText("Atacar");
        ataque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ataqueActionPerformed(evt);
            }
        });

        cambioAuto.setText("Cambiar de Auto");
        cambioAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambioAutoActionPerformed(evt);
            }
        });

        dadoMov.setText("Girar dado de movimiento");
        dadoMov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dadoMovActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cambioAuto)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ataque)
                        .addGap(27, 27, 27)))
                .addContainerGap(135, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dadoMov)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(ataque)
                .addGap(35, 35, 35)
                .addComponent(cambioAuto)
                .addGap(37, 37, 37)
                .addComponent(dadoMov, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cambioAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambioAutoActionPerformed
        this.dispose();
        DlgCambioAuto auto = new DlgCambioAuto(null, true, misAutos, numCelda, mapa, posX, posY, autoTanque, autoAvion, cumbres, mar, campo, tipoTerreno, x, y, valores, numAuto, vidaAuto, nivelAuto, ataqueAuto);
        auto.setVisible(true);
        
    }//GEN-LAST:event_cambioAutoActionPerformed

    private void dadoMovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dadoMovActionPerformed
        this.dispose();
        DlgMovimientos movimientos = new DlgMovimientos(null, true, posX, posY, mapa, casillas, i, j, autoTanque, valores, autoAvion, tipoTerreno, cumbres, mar, campo, misAutos, numAuto, numCelda, enemigos, torreta, ocupado);
        movimientos.setVisible(true);
    }//GEN-LAST:event_dadoMovActionPerformed

    private void ataqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ataqueActionPerformed
        DlgAtaque ataque = new DlgAtaque(null, true, i, j, casillas, mapa, balaArriba, balaAbajo, balaIzquierda, balaDerecha, cumbres, mar, campo, tipoTerreno, ocupado, torreta, enemigos, fila, enemigo, modelMapa2, vida, panelEnemigos, enemigo1, enemigo2, enemigo3, enemigo4, autoTanque, autoAvion, valores, numCelda, misAutos, ataqueAuto);
        ataque.setVisible(true);
    }//GEN-LAST:event_ataqueActionPerformed
                        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ataque;
    private javax.swing.JButton cambioAuto;
    private javax.swing.JButton dadoMov;
    // End of variables declaration//GEN-END:variables
}
