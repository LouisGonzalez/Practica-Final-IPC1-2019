package practicafinal.ipc1;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author luisGonzalez
 */
public class DlgEscenarioMultiJugador extends javax.swing.JDialog {
    
    private NuevoAvatar<NombreJugador> miLista;
    private int numCelda, numCelda2;
    private ImageIcon fondos = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/cumbres.jpeg");
    
    //menu de opciones para el modo multijugador
    public DlgEscenarioMultiJugador(java.awt.Frame parent, boolean modal, NuevoAvatar<NombreJugador> miLista, int numCelda, int numCelda2) {
        super(parent, modal);
        this.miLista = miLista;
        this.numCelda = numCelda;
        this.numCelda2 = numCelda2;
        initComponents();
        setLocationRelativeTo(null);
        Icon fotos = new ImageIcon(fondos.getImage().getScaledInstance(fondo.getWidth(),fondo.getHeight(), Image.SCALE_DEFAULT));
        fondo.setIcon(fotos);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        escenario1 = new javax.swing.JButton();
        escenario2 = new javax.swing.JButton();
        escenario3 = new javax.swing.JButton();
        txt = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        escenario1.setText("4 * 4");
        escenario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escenario1ActionPerformed(evt);
            }
        });
        jPanel1.add(escenario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        escenario2.setText("6 * 4");
        escenario2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escenario2ActionPerformed(evt);
            }
        });
        jPanel1.add(escenario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        escenario3.setText("8 * 9");
        escenario3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escenario3ActionPerformed(evt);
            }
        });
        jPanel1.add(escenario3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        txt.setText("Elija el escenario a usar:");
        jPanel1.add(txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 230, 20));
        jPanel1.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 250));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 250));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //clase encargada para que el usuario detecte todos los tipos de paradas 
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
    private javax.swing.JLabel fondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel txt;
    // End of variables declaration//GEN-END:variables
}
