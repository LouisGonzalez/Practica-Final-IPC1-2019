package practicafinal.ipc1;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author luisGonzalez
 */
public class DlgMenuJugador extends javax.swing.JDialog {
    
    private NuevoAvatar<NombreJugador> miLista;  
    private NuevoAuto<NombreAuto> miLista2;
    private int numCelda;
    
    public DlgMenuJugador(java.awt.Frame parent, boolean modal, DefaultTableModel dtm, int fila, int columna, NuevoAvatar<NombreJugador> miLista, int numCelda) {
        super(parent, modal);
        initComponents();
        this.numCelda = numCelda;
        this.miLista = miLista;
        setLocationRelativeTo(null);
        nombreJugador.setText("bienvenido "+dtm.getValueAt(fila, columna));
        
    }
           
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombreJugador = new javax.swing.JLabel();
        verAutos = new javax.swing.JButton();
        crearAutos = new javax.swing.JButton();
        juegoNuevo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        verAutos.setText("Ver Autos");
        verAutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verAutosActionPerformed(evt);
            }
        });

        crearAutos.setText("Crear Auto");
        crearAutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearAutosActionPerformed(evt);
            }
        });

        juegoNuevo.setText("Jugar");
        juegoNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                juegoNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(juegoNuevo)
                    .addComponent(crearAutos)
                    .addComponent(verAutos)
                    .addComponent(nombreJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(208, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(nombreJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(juegoNuevo)
                .addGap(23, 23, 23)
                .addComponent(verAutos)
                .addGap(18, 18, 18)
                .addComponent(crearAutos)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void verAutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verAutosActionPerformed
        DlgListaAutos autos = new DlgListaAutos(null, true, miLista, numCelda);
        autos.setVisible(true);
    }//GEN-LAST:event_verAutosActionPerformed

    private void crearAutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearAutosActionPerformed
        DlgNuevoAuto nuevo = new DlgNuevoAuto(null, true, miLista, numCelda);
        nuevo.setVisible(true);
        
    }//GEN-LAST:event_crearAutosActionPerformed

    private void juegoNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_juegoNuevoActionPerformed
        DlgTipoEscenario jugar = new DlgTipoEscenario(null, true, miLista, numCelda);
        jugar.setVisible(true);
    }//GEN-LAST:event_juegoNuevoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton crearAutos;
    private javax.swing.JButton juegoNuevo;
    private javax.swing.JLabel nombreJugador;
    private javax.swing.JButton verAutos;
    // End of variables declaration//GEN-END:variables
}
