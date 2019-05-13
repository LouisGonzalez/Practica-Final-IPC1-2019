package practicafinal.ipc1;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author luisGonzalez
 */
public class DlgTipoEscenario extends javax.swing.JDialog {

    private int numCelda;
    private NuevoAvatar<NombreJugador> miLista;
    private ImageIcon fondos = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/cumbres.jpeg");
    private Archivos archivos;
    
    public DlgTipoEscenario(java.awt.Frame parent, boolean modal, NuevoAvatar<NombreJugador> miLista, int numCelda, Archivos archivos) {
        super(parent, modal);
        initComponents();
        this.numCelda = numCelda;
        this.miLista = miLista;
        this.archivos = archivos;
        this.miLista = archivos.leerArchivo();
        setLocationRelativeTo(null);
        Icon fotos = new ImageIcon(fondos.getImage().getScaledInstance(fondo.getWidth(),fondo.getHeight(), Image.SCALE_DEFAULT));
        fondo.setIcon(fotos);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        text1 = new javax.swing.JLabel();
        dimension1 = new javax.swing.JButton();
        dimension2 = new javax.swing.JButton();
        dimension3 = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        text1.setBackground(new java.awt.Color(255, 255, 255));
        text1.setForeground(new java.awt.Color(255, 255, 255));
        text1.setText("Elige las dimensiones de tu tablero:");
        getContentPane().add(text1, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 30, -1, 40));

        dimension1.setBackground(new java.awt.Color(255, 255, 255));
        dimension1.setForeground(new java.awt.Color(255, 255, 255));
        dimension1.setText("4 * 4");
        dimension1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        dimension1.setContentAreaFilled(false);
        dimension1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dimension1ActionPerformed(evt);
            }
        });
        getContentPane().add(dimension1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 91, 80, 30));

        dimension2.setBackground(new java.awt.Color(255, 255, 255));
        dimension2.setForeground(new java.awt.Color(255, 255, 255));
        dimension2.setText("6 * 4");
        dimension2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        dimension2.setContentAreaFilled(false);
        dimension2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dimension2ActionPerformed(evt);
            }
        });
        getContentPane().add(dimension2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 126, 80, 30));

        dimension3.setBackground(new java.awt.Color(255, 255, 255));
        dimension3.setForeground(new java.awt.Color(255, 255, 255));
        dimension3.setText("8 * 9");
        dimension3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        dimension3.setContentAreaFilled(false);
        dimension3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dimension3ActionPerformed(evt);
            }
        });
        getContentPane().add(dimension3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 161, 80, 30));
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 230));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dimension1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dimension1ActionPerformed
        DlgPrimerEscenario primero = new DlgPrimerEscenario(null, true, miLista, numCelda, 4, 4, archivos);
        primero.setVisible(true);
    }//GEN-LAST:event_dimension1ActionPerformed

    private void dimension2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dimension2ActionPerformed
        DlgPrimerEscenario primero = new DlgPrimerEscenario(null, true, miLista, numCelda, 4, 6, archivos);
        primero.setVisible(true);
    
    }//GEN-LAST:event_dimension2ActionPerformed

    private void dimension3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dimension3ActionPerformed
        DlgPrimerEscenario primero = new DlgPrimerEscenario(null, true, miLista, numCelda, 8, 9, archivos);
        primero.setVisible(true);
    }//GEN-LAST:event_dimension3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dimension1;
    private javax.swing.JButton dimension2;
    private javax.swing.JButton dimension3;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel text1;
    // End of variables declaration//GEN-END:variables
}
