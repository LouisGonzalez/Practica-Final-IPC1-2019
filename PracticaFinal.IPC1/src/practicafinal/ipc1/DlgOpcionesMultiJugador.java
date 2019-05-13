package practicafinal.ipc1;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
    private int[][] enemigos, ocupado, ocupado2;
    private Nodo<NombreJugador> elemento;
    private NombreJugador lista;
    private Nodo2<NombreAuto> elemento2;
    private NombreAuto nombre;
    private DefaultTableModel modelMapa2;
    private Archivos archivos;
    private ImageIcon fondo = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/menu.jpeg");
    
    public DlgOpcionesMultiJugador(java.awt.Frame parent, boolean modal, NuevoAvatar<NombreJugador> misAutos, int numCelda, JLabel[][] mapa, int posX, int posY, Icon autoTanque, Icon autoAvion, Icon cumbres, Icon mar, Icon campo, int[][] tipoTerreno, int x, int y, int[][] valores, int filas, int columnas, int i, int j, JLabel numAuto, Icon balaArriba, Icon balaAbajo, Icon balaIzquierda, Icon balaDerecha, int[][] enemigos, int[][] ocupado, JLabel vidaAuto, JLabel nivelAuto, JLabel ataqueAuto, Nodo<NombreJugador> elemento, NombreJugador lista, Nodo2<NombreAuto> elemento2, NombreAuto nombre, DefaultTableModel modelMapa2, int[][] valores2, int numCelda2, JLabel numAuto2, JLabel vidaAuto2, Archivos archivos, int[][] ocupado2) {
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
        this.numCelda2 = numCelda2;
        this.numAuto2 = numAuto2;
        this.vidaAuto2 = vidaAuto2;
        this.archivos = archivos; 
        this.ocupado2 = ocupado2;
        this.misAutos = archivos.leerArchivo();
        initComponents();
        txt.setFont(new java.awt.Font("Tahoma", 0, 16));
        txt2.setFont(new java.awt.Font(null,0,11));
        txt3.setFont(new java.awt.Font(null,0, 11));
        Icon menu = new ImageIcon(fondo.getImage().getScaledInstance(fondoMenu.getWidth(), fondoMenu.getHeight(), Image.SCALE_DEFAULT));                
        fondoMenu.setIcon(menu);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMultijugador = new javax.swing.JPanel();
        botonAtaque = new javax.swing.JButton();
        cambioAuto = new javax.swing.JButton();
        movimientos = new javax.swing.JButton();
        txt = new javax.swing.JLabel();
        txt2 = new javax.swing.JLabel();
        txt3 = new javax.swing.JLabel();
        fondoMenu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelMultijugador.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonAtaque.setBackground(new java.awt.Color(255, 255, 255));
        botonAtaque.setForeground(new java.awt.Color(255, 255, 255));
        botonAtaque.setText("Atacar");
        botonAtaque.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonAtaque.setContentAreaFilled(false);
        botonAtaque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtaqueActionPerformed(evt);
            }
        });
        panelMultijugador.add(botonAtaque, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 78, 80, 40));

        cambioAuto.setBackground(new java.awt.Color(255, 255, 255));
        cambioAuto.setForeground(new java.awt.Color(255, 255, 255));
        cambioAuto.setText("Cambiar Auto");
        cambioAuto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cambioAuto.setContentAreaFilled(false);
        cambioAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambioAutoActionPerformed(evt);
            }
        });
        panelMultijugador.add(cambioAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 128, 130, 40));

        movimientos.setBackground(new java.awt.Color(255, 255, 255));
        movimientos.setForeground(new java.awt.Color(255, 255, 255));
        movimientos.setText("Mover Auto");
        movimientos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        movimientos.setContentAreaFilled(false);
        movimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movimientosActionPerformed(evt);
            }
        });
        panelMultijugador.add(movimientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 150, 50));

        txt.setBackground(new java.awt.Color(255, 255, 255));
        txt.setForeground(new java.awt.Color(255, 255, 255));
        txt.setText("BIENVENIDO AL MENU DE OPCIONES");
        panelMultijugador.add(txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 310, 40));

        txt2.setBackground(new java.awt.Color(255, 255, 255));
        txt2.setForeground(new java.awt.Color(255, 255, 255));
        txt2.setText("Elige con sabiduria.");
        panelMultijugador.add(txt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 220, -1));

        txt3.setBackground(new java.awt.Color(255, 255, 255));
        txt3.setForeground(new java.awt.Color(255, 255, 255));
        txt3.setText("Si cierras el menu sin elegir alguna opcion el turno aun asi contara.");
        panelMultijugador.add(txt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 410, 10));
        panelMultijugador.add(fondoMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        getContentPane().add(panelMultijugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAtaqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtaqueActionPerformed
        this.dispose();
        DlgAtaqueMult ataque = new DlgAtaqueMult(null, true, i, j, filas, columnas, mapa, balaArriba, balaAbajo, balaIzquierda, balaDerecha, cumbres, mar, campo, tipoTerreno, ocupado, torreta, enemigos, modelMapa2, autoTanque, autoAvion, valores, valores2, numCelda, misAutos, ataqueAuto, numCelda2, numAuto2, vidaAuto2, archivos);
        ataque.setVisible(true);
    }//GEN-LAST:event_botonAtaqueActionPerformed

    private void cambioAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambioAutoActionPerformed
        this.dispose();
        DlgCambioAuto auto = new DlgCambioAuto(null, true, misAutos, numCelda, mapa, posX, posY, autoTanque, autoAvion, cumbres, mar, campo, tipoTerreno, x, y, valores, numAuto, vidaAuto, nivelAuto, ataqueAuto, elemento, lista, elemento2, nombre, ocupado2);
        auto.setVisible(true);

    }//GEN-LAST:event_cambioAutoActionPerformed

    private void movimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movimientosActionPerformed
        this.dispose();
        DlgMovimientos movimientos = new DlgMovimientos(null, true, posX, posY, mapa, filas, columnas, i, j, autoTanque, valores, autoAvion, tipoTerreno, cumbres, mar, campo, misAutos, numAuto, numCelda, enemigos, torreta, ocupado2, cajasComodin, vidaAuto, archivos);
        movimientos.setVisible(true);
    }//GEN-LAST:event_movimientosActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAtaque;
    private javax.swing.JButton cambioAuto;
    private javax.swing.JLabel fondoMenu;
    private javax.swing.JButton movimientos;
    private javax.swing.JPanel panelMultijugador;
    private javax.swing.JLabel txt;
    private javax.swing.JLabel txt2;
    private javax.swing.JLabel txt3;
    // End of variables declaration//GEN-END:variables
}
