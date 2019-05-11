package practicafinal.ipc1;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luisGonzalez
 */
public class DlgOpcionesMultiJugador extends javax.swing.JDialog {

    private NuevoAvatar<NombreJugador> misAutos;
    private int[][] tipoTerreno, valores, valores2, cajasComodin;
    JLabel[][] mapa;
    private int posX, posY, x, y, i, j, filas, columnas, numCelda, numCelda2;
    private Icon autoTanque, autoAvion, cumbres, mar, campo, balaArriba, balaAbajo, balaIzquierda, balaDerecha, torreta;
    private JLabel numAuto, vidaAuto, nivelAuto, ataqueAuto, vidaAuto2, numAuto2;
    private int[][] enemigos, ocupado;
    private Nodo<NombreJugador> elemento;
    private NombreJugador lista;
    private Nodo2<NombreAuto> elemento2;
    private NombreAuto nombre;
    private DefaultTableModel modelMapa2;
    
    public DlgOpcionesMultiJugador(java.awt.Frame parent, boolean modal, NuevoAvatar<NombreJugador> misAutos, int numCelda, JLabel[][] mapa, int posX, int posY, Icon autoTanque, Icon autoAvion, Icon cumbres, Icon mar, Icon campo, int[][] tipoTerreno, int x, int y, int[][] valores, int filas, int columnas, int i, int j, JLabel numAuto, Icon balaArriba, Icon balaAbajo, Icon balaIzquierda, Icon balaDerecha, int[][] enemigos, int[][] ocupado, JLabel vidaAuto, JLabel nivelAuto, JLabel ataqueAuto, Nodo<NombreJugador> elemento, NombreJugador lista, Nodo2<NombreAuto> elemento2, NombreAuto nombre, DefaultTableModel modelMapa2, int[][] valores2, int numCelda2, JLabel numAuto2, JLabel vidaAuto2) {
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
        this.filas = filas;
        this.columnas = columnas;
        this.i = i;
        this.j = j;
        this.numAuto = numAuto;
        this.balaArriba = balaArriba;
        this.balaAbajo = balaAbajo;
        this.balaIzquierda = balaIzquierda;
        this.balaDerecha = balaDerecha;
        this.enemigos = enemigos;
        this.ocupado = ocupado;
        this.vidaAuto = vidaAuto;
        this.nivelAuto = nivelAuto;
        this.ataqueAuto = ataqueAuto;
        this.elemento = elemento;
        this.elemento2 = elemento2;
        this.lista = lista;
        this.nombre = nombre;
        this.modelMapa2 = modelMapa2;
        this.valores2 = valores2;
        this.numCelda2 = numCelda;
        this.numAuto2 = numAuto2;
        this.vidaAuto2 = vidaAuto2;
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        botonAtaque = new javax.swing.JButton();
        cambioAuto = new javax.swing.JButton();
        movimientos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonAtaque.setText("Atacar");
        botonAtaque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtaqueActionPerformed(evt);
            }
        });

        cambioAuto.setText("Cambiar Auto");
        cambioAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambioAutoActionPerformed(evt);
            }
        });

        movimientos.setText("Mover Auto");
        movimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movimientosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(movimientos)
                    .addComponent(cambioAuto)
                    .addComponent(botonAtaque))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(botonAtaque)
                .addGap(18, 18, 18)
                .addComponent(cambioAuto)
                .addGap(18, 18, 18)
                .addComponent(movimientos)
                .addContainerGap(101, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 12, 380, 280));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAtaqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtaqueActionPerformed
        DlgAtaqueMult ataque = new DlgAtaqueMult(null, true, i, j, filas, columnas, mapa, balaArriba, balaAbajo, balaIzquierda, balaDerecha, cumbres, mar, campo, tipoTerreno, ocupado, torreta, enemigos, modelMapa2, autoTanque, autoAvion, valores, valores2, numCelda, misAutos, ataqueAuto, numCelda2, numAuto2, vidaAuto2);
        ataque.setVisible(true);
    }//GEN-LAST:event_botonAtaqueActionPerformed

    private void cambioAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambioAutoActionPerformed
        this.dispose();
        DlgCambioAuto auto = new DlgCambioAuto(null, true, misAutos, numCelda, mapa, posX, posY, autoTanque, autoAvion, cumbres, mar, campo, tipoTerreno, x, y, valores, numAuto, vidaAuto, nivelAuto, ataqueAuto, elemento, lista, elemento2, nombre, ocupado);
        auto.setVisible(true);

    }//GEN-LAST:event_cambioAutoActionPerformed

    private void movimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movimientosActionPerformed
        this.dispose();
        DlgMovimientos movimientos = new DlgMovimientos(null, true, posX, posY, mapa, filas, columnas, i, j, autoTanque, valores, autoAvion, tipoTerreno, cumbres, mar, campo, misAutos, numAuto, numCelda, enemigos, torreta, ocupado, cajasComodin, vidaAuto);
        movimientos.setVisible(true);
    }//GEN-LAST:event_movimientosActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAtaque;
    private javax.swing.JButton cambioAuto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton movimientos;
    // End of variables declaration//GEN-END:variables
}
