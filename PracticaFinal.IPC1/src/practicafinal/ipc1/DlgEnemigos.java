package practicafinal.ipc1;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
/**
 *
 * @author luisGonzalez
 */
public class DlgEnemigos extends javax.swing.JDialog {
    
    private NuevoEnemigo<Enemigo> enemigo;
    private int[] posEnemigoX, posEnemigoY;
    private int[] posEnemigoX2, posEnemigoY2;
    private int[][] enemigos, ocupado;
    private Icon torretaEnemigo;
    private JLabel[][] mapa;
    private int contador = 0;
    private int posX, posY;
    private int x, cantidad, j;
    private JLabel vidaEnemigo, enemigo1, enemigo2, enemigo3, enemigo4;
    private double[] vida;
    private int[] guardarX, guardarY;
    private final Border borde = LineBorder.createGrayLineBorder();
    private JPanel panelEnemigos;
    
    public DlgEnemigos(java.awt.Frame parent, boolean modal, NuevoEnemigo<Enemigo> enemigo, JLabel[][] mapa, Icon torretaEnemigo, int[][] enemigos, int posX, int posY, int[][] ocupado, double[] vida, JPanel panelEnemigos, JLabel enemigo1, JLabel enemigo2, JLabel enemigo3, JLabel enemigo4) {
        super(parent, modal);
        this.enemigo = enemigo;     
        this.torretaEnemigo = torretaEnemigo;
        this.mapa = mapa;
        this.enemigos = enemigos;
        this.posX = posX;
        this.posY = posY;
        this.ocupado = ocupado;
        this.vida = vida;
        this.panelEnemigos = panelEnemigos;
        this.enemigo1 = enemigo1;
        this.enemigo2 = enemigo2;
        this.enemigo3 = enemigo3;
        this.enemigo4 = enemigo4;
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
        this.cantidad = cantEnemigos.getSelectedIndex();
        this.vida = new double[4];
        this.guardarX = new int[4];
        this.guardarY = new int[4];
        if(contador==1){
            for(x=0; x<=cantidad; x++){        
                int y = x+1;
                Enemigo nuevo = new Enemigo("Bunker "+y, 100, 10, 10);
                enemigo.insertarContenido(nuevo);
                try{
                    Nodo3<Enemigo> elemento = enemigo.obtenerElemento(x);
                    Enemigo nombre = elemento.obtenerContenido();
                    vida[x] = nombre.getVida();
                } catch(Exception e) {
                }
                posEnemigoX = new int[cantidad+1];
                posEnemigoY = new int[cantidad+1];
                posEnemigoX2 = new int[cantidad+1];
                posEnemigoY2 = new int[cantidad+1];
                posEnemigoX[x] = (int)(Math.random()*3);
                posEnemigoY[x] = (int)(Math.random()*3);
                if(ocupado[posEnemigoX[x]][posEnemigoY[x]]==1){
                    posEnemigoX[x] = (int)(Math.random()*3);
                    posEnemigoY[x] = (int)(Math.random()*3);
                    mapa[posEnemigoX[x]][posEnemigoY[x]].setIcon(torretaEnemigo);
                    enemigos[posEnemigoX[x]][posEnemigoY[x]] = x+1;
                    ocupado[posEnemigoX[x]][posEnemigoY[x]] = 1;
                    guardarX[x] = posEnemigoX[x];
                    guardarY[x] = posEnemigoY[x];
                } else {
                    mapa[posEnemigoX[x]][posEnemigoY[x]].setIcon(torretaEnemigo); 
                    enemigos[posEnemigoX[x]][posEnemigoY[x]] = x+1;
                    ocupado[posEnemigoX[x]][posEnemigoY[x]] = 1;
                    guardarX[x] = posEnemigoX[x];
                    guardarY[x] = posEnemigoY[x];
                }
            }   
                      
            enemigo1.setText(Double.toString(vida[0]));
            enemigo2.setText(Double.toString(vida[1]));
            enemigo3.setText(Double.toString(vida[2]));
            enemigo4.setText(Double.toString(vida[3]));
            JOptionPane.showMessageDialog(null, "Sus enemigos han sido agregados con exito, A PELEAR!!");
        } else {
                JOptionPane.showMessageDialog(null, "Solo una vez se pueden instanciar vehiculos");
        }
    }//GEN-LAST:event_botonEnemigoActionPerformed

    public int[] getGuardarX() {
        return guardarX;
    }

    public int[] getGuardarY() {
        return guardarY;
    }

    public int getCantidad() {
        return cantidad;
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonEnemigo;
    private javax.swing.JComboBox<String> cantEnemigos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel txt;
    // End of variables declaration//GEN-END:variables
}
