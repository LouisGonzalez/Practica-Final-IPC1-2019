package practicafinal.ipc1;
/**
 *
 * @author luisGonzalez
 */
public class DlgTipoEscenario extends javax.swing.JDialog {

    private int numCelda;
    private NuevoAvatar<NombreJugador> miLista;
    
    public DlgTipoEscenario(java.awt.Frame parent, boolean modal, NuevoAvatar<NombreJugador> miLista, int numCelda) {
        super(parent, modal);
        initComponents();
        this.numCelda = numCelda;
        this.miLista = miLista;
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        text1 = new javax.swing.JLabel();
        dimension1 = new javax.swing.JButton();
        dimension2 = new javax.swing.JButton();
        dimension3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        text1.setText("Elige las dimensiones de tu tablero:");

        dimension1.setText("4 * 4");
        dimension1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dimension1ActionPerformed(evt);
            }
        });

        dimension2.setText("6 * 4");
        dimension2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dimension2ActionPerformed(evt);
            }
        });

        dimension3.setText("8 * 9");
        dimension3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dimension3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dimension3)
                    .addComponent(dimension2)
                    .addComponent(dimension1)
                    .addComponent(text1))
                .addContainerGap(154, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(text1)
                .addGap(18, 18, 18)
                .addComponent(dimension1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dimension2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dimension3)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dimension1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dimension1ActionPerformed
        DlgPrimerEscenario primero = new DlgPrimerEscenario(null, true, miLista, numCelda, 4, 4);
        primero.setVisible(true);
    }//GEN-LAST:event_dimension1ActionPerformed

    private void dimension2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dimension2ActionPerformed
        DlgPrimerEscenario primero = new DlgPrimerEscenario(null, true, miLista, numCelda, 4, 6);
        primero.setVisible(true);
    
    }//GEN-LAST:event_dimension2ActionPerformed

    private void dimension3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dimension3ActionPerformed
        DlgPrimerEscenario primero = new DlgPrimerEscenario(null, true, miLista, numCelda, 8, 9);
        primero.setVisible(true);
    }//GEN-LAST:event_dimension3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dimension1;
    private javax.swing.JButton dimension2;
    private javax.swing.JButton dimension3;
    private javax.swing.JLabel text1;
    // End of variables declaration//GEN-END:variables
}
