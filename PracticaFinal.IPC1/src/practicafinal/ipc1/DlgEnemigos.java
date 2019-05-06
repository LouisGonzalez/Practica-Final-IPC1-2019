package practicafinal.ipc1;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 *
 * @author luisGonzalez
 */
public class DlgEnemigos extends javax.swing.JDialog {
    
    private NuevoEnemigo<Enemigo> enemigo;
    private int[] posEnemigoX, posEnemigoY;
    private int[][] enemigos, ocupado;
    private Icon torretaEnemigo;
    private JLabel[][] mapa;
    private int contador = 0;
    private int posX, posY;
    private int x, cantidad;
    
    public DlgEnemigos(java.awt.Frame parent, boolean modal, NuevoEnemigo<Enemigo> enemigo, JLabel[][] mapa, Icon torretaEnemigo, int[][] enemigos, int posX, int posY, int[][] ocupado) {
        super(parent, modal);
        this.enemigo = enemigo;     
        this.torretaEnemigo = torretaEnemigo;
        this.mapa = mapa;
        this.enemigos = enemigos;
        this.posX = posX;
        this.posY = posY;
        this.ocupado = ocupado;
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cantEnemigos = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txt = new javax.swing.JLabel();
        botonEnemigo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cantEnemigos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        getContentPane().add(cantEnemigos, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 77, -1));

        jLabel1.setText("Defina la cantidad de enemigos que desea:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 271, 23));
        getContentPane().add(txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 90, 40));

        botonEnemigo.setText("Aceptar");
        botonEnemigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEnemigoActionPerformed(evt);
            }
        });
        getContentPane().add(botonEnemigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 130, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonEnemigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEnemigoActionPerformed
        contador++;
        cantidad = cantEnemigos.getSelectedIndex();
        if(contador==1){
            for(x=0; x<=cantidad; x++){
                int y = x+1;
                Enemigo nuevo = new Enemigo("Bunker "+y, 100, 10, 10);
                enemigo.insertarContenido(nuevo); 
                posEnemigoX = new int[cantidad+1];
                posEnemigoY = new int[cantidad+1];
                posEnemigoX[x] = (int)(Math.random()*3);
                posEnemigoY[x] = (int)(Math.random()*3);
                if(ocupado[posEnemigoX[x]][posEnemigoY[x]]==1){
                    posEnemigoX[x] = (int)(Math.random()*3);
                    posEnemigoY[x] = (int)(Math.random()*3);
                    mapa[posEnemigoX[x]][posEnemigoY[x]].setIcon(torretaEnemigo);
                    enemigos[posEnemigoX[x]][posEnemigoY[x]] = x+1;
                    ocupado[posEnemigoX[x]][posEnemigoY[x]] = 1;
                } else {
                    mapa[posEnemigoX[x]][posEnemigoY[x]].setIcon(torretaEnemigo); 
                    enemigos[posEnemigoX[x]][posEnemigoY[x]] = x+1;
                    ocupado[posEnemigoX[x]][posEnemigoY[x]] = 1;
                }
            }                                             
            JOptionPane.showMessageDialog(null, "Sus enemigos han sido agregados con exito, A PELEAR!!");
        } else {
                JOptionPane.showMessageDialog(null, "Solo una vez se pueden instanciar vehiculos");
        }
    }//GEN-LAST:event_botonEnemigoActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonEnemigo;
    private javax.swing.JComboBox<String> cantEnemigos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel txt;
    // End of variables declaration//GEN-END:variables
}
