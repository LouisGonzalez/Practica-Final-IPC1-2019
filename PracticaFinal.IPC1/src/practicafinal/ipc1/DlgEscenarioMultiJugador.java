package practicafinal.ipc1;
/**
 *
 * @author luisGonzalez
 */
public class DlgEscenarioMultiJugador extends javax.swing.JDialog {
    
    private NuevoAvatar<NombreJugador> miLista;
    private int numCelda, numCelda2;
    
    public DlgEscenarioMultiJugador(java.awt.Frame parent, boolean modal, NuevoAvatar<NombreJugador> miLista, int numCelda, int numCelda2) {
        super(parent, modal);
        this.miLista = miLista;
        this.numCelda = numCelda;
        this.numCelda2 = numCelda2;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        escenario1 = new javax.swing.JButton();
        escenario2 = new javax.swing.JButton();
        escenario3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        escenario1.setText("4 * 4");
        escenario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escenario1ActionPerformed(evt);
            }
        });

        escenario2.setText("6 * 4");
        escenario2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escenario2ActionPerformed(evt);
            }
        });

        escenario3.setText("8 * 9");
        escenario3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escenario3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(escenario3)
                    .addComponent(escenario2)
                    .addComponent(escenario1))
                .addContainerGap(167, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(escenario1)
                .addGap(18, 18, 18)
                .addComponent(escenario2)
                .addGap(18, 18, 18)
                .addComponent(escenario3)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void escenario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escenario1ActionPerformed
        DlgPrimerEscenarioMult primero = new DlgPrimerEscenarioMult(null, true, miLista, numCelda, numCelda2, 4, 4);
        primero.setVisible(true);
    }//GEN-LAST:event_escenario1ActionPerformed

    private void escenario2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escenario2ActionPerformed
        DlgPrimerEscenarioMult segundo = new DlgPrimerEscenarioMult(null, true, miLista, numCelda, numCelda2, 4, 6);
        segundo.setVisible(true);
    }//GEN-LAST:event_escenario2ActionPerformed

    private void escenario3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escenario3ActionPerformed
        DlgPrimerEscenarioMult tercero = new DlgPrimerEscenarioMult(null, true, miLista, numCelda, numCelda2, 8, 9);
        tercero.setVisible(true);
    }//GEN-LAST:event_escenario3ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton escenario1;
    private javax.swing.JButton escenario2;
    private javax.swing.JButton escenario3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
