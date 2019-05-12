package practicafinal.ipc1;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luisGonzalez
 */
public class DlgOpcionesJugador extends javax.swing.JDialog {
    
    private NuevoAvatar<NombreJugador> misAutos;
    private NuevoEnemigo<Enemigo> enemigo;
    private int[][] tipoTerreno, valores, cajasComodin;
    JLabel[][] mapa;
    private int posX, posY, x, y, i, j, filas, columnas, numCelda;
    private Icon autoTanque, autoAvion, cumbres, mar, campo, balaArriba, balaAbajo, balaIzquierda, balaDerecha, torreta;
    private JLabel numAuto, enemigo1, enemigo2, enemigo3, enemigo4, vidaAuto, nivelAuto, ataqueAuto;
    private int[][] enemigos, ocupado;
    Object [] fila;
    private DefaultTableModel modelMapa2;
    private double[] vida;
    private JPanel panelEnemigos;
    Nodo<NombreJugador> elemento;
    NombreJugador lista;
    Nodo2<NombreAuto> elemento2;
    NombreAuto nombre;
    
    
    public DlgOpcionesJugador(java.awt.Frame parent, boolean modal, NuevoAvatar<NombreJugador> misAutos, int numCelda, JLabel[][] mapa, int posX, int posY, Icon autoTanque, Icon autoAvion, Icon cumbres, Icon mar, Icon campo, int[][] tipoTerreno, int x, int y, int[][] valores, int filas, int columnas, int i, int j, JLabel numAuto, Icon balaArriba, Icon balaAbajo, Icon balaIzquierda, Icon balaDerecha, NuevoEnemigo<Enemigo> enemigo, int[][] enemigos, int[][] ocupado, Icon torreta, Object[] fila, DefaultTableModel modelMapa2, double[] vida, JPanel panelEnemigos, JLabel enemigo1, JLabel enemigo2, JLabel enemigo3, JLabel enemigo4, JLabel vidaAuto, JLabel nivelAuto, JLabel ataqueAuto, Nodo<NombreJugador> elemento, NombreJugador lista, Nodo2<NombreAuto> elemento2, NombreAuto nombre, int[][] cajasComodin) {
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
        this.elemento = elemento;
        this.elemento2 = elemento2;
        this.lista = lista;
        this.nombre = nombre;
        this.cajasComodin = cajasComodin;
        initComponents();
        setLocationRelativeTo(null);
        txt.setFont(new java.awt.Font("Tahoma", 0, 16));
        txt2.setFont(new java.awt.Font(null,0,11));
        txt3.setFont(new java.awt.Font(null,0, 11));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelOpciones = new javax.swing.JPanel();
        txt = new javax.swing.JLabel();
        txt3 = new javax.swing.JLabel();
        txt2 = new javax.swing.JLabel();
        dadoMov = new javax.swing.JButton();
        cambioAuto = new javax.swing.JButton();
        ataque = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelOpciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt.setText("BIENVENIDO AL MENU DE OPCIONES");
        panelOpciones.add(txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 360, 40));

        txt3.setText("Si cierras el menu sin elegir alguna opcion el turno aun asi contara.");
        panelOpciones.add(txt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 410, 10));

        txt2.setText("Elige con sabiduria.");
        panelOpciones.add(txt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 220, -1));

        dadoMov.setBackground(new java.awt.Color(255, 255, 255));
        dadoMov.setForeground(new java.awt.Color(255, 255, 255));
        dadoMov.setText("Girar dado de movimiento");
        dadoMov.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        dadoMov.setContentAreaFilled(false);
        dadoMov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dadoMovActionPerformed(evt);
            }
        });
        panelOpciones.add(dadoMov, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 171, 44));

        cambioAuto.setBackground(new java.awt.Color(255, 255, 255));
        cambioAuto.setForeground(new java.awt.Color(255, 255, 255));
        cambioAuto.setText("Cambiar de Auto");
        cambioAuto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cambioAuto.setContentAreaFilled(false);
        cambioAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambioAutoActionPerformed(evt);
            }
        });
        panelOpciones.add(cambioAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 141, 46));

        ataque.setBackground(new java.awt.Color(255, 255, 255));
        ataque.setForeground(new java.awt.Color(255, 255, 255));
        ataque.setText("Atacar");
        ataque.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ataque.setContentAreaFilled(false);
        ataque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ataqueActionPerformed(evt);
            }
        });
        panelOpciones.add(ataque, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 75, 34));

        getContentPane().add(panelOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //una vez en el juego, se le presentan al jugador la lista de lo que puede hacer ya en combate
    private void cambioAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambioAutoActionPerformed
        this.dispose();
        DlgCambioAuto auto = new DlgCambioAuto(null, true, misAutos, numCelda, mapa, posX, posY, autoTanque, autoAvion, cumbres, mar, campo, tipoTerreno, x, y, valores, numAuto, vidaAuto, nivelAuto, ataqueAuto, elemento, lista, elemento2, nombre, ocupado);
        auto.setVisible(true);
        
    }//GEN-LAST:event_cambioAutoActionPerformed

    private void dadoMovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dadoMovActionPerformed
        this.dispose();
        DlgMovimientos movimientos = new DlgMovimientos(null, true, posX, posY, mapa, filas, columnas, i, j, autoTanque, valores, autoAvion, tipoTerreno, cumbres, mar, campo, misAutos, numAuto, numCelda, enemigos, torreta, ocupado, cajasComodin, vidaAuto);
        movimientos.setVisible(true);
    }//GEN-LAST:event_dadoMovActionPerformed

    private void ataqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ataqueActionPerformed
        this.dispose();
        DlgAtaque ataque = new DlgAtaque(null, true, i, j, filas, columnas, mapa, balaArriba, balaAbajo, balaIzquierda, balaDerecha, cumbres, mar, campo, tipoTerreno, ocupado, torreta, enemigos, fila, enemigo, modelMapa2, vida, panelEnemigos, enemigo1, enemigo2, enemigo3, enemigo4, autoTanque, autoAvion, valores, numCelda, misAutos, ataqueAuto);
        ataque.setVisible(true);
    }//GEN-LAST:event_ataqueActionPerformed
                        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ataque;
    private javax.swing.JButton cambioAuto;
    private javax.swing.JButton dadoMov;
    private javax.swing.JPanel panelOpciones;
    private javax.swing.JLabel txt;
    private javax.swing.JLabel txt2;
    private javax.swing.JLabel txt3;
    // End of variables declaration//GEN-END:variables
}
