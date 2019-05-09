package practicafinal.ipc1;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luisGonzalez
 */
public class DlgAtaque extends javax.swing.JDialog {

    private String movDisparo;
    private int i, j, filas, columnas, numCelda, numCelda2;
    private JLabel[][] mapa;
    private Icon balaArriba, balaAbajo, balaIzquierda, balaDerecha, cumbres, mar, campo, torreta, autoTanque, autoAvion;
    private int[][] tipoTerreno, ocupado, enemigos, valores;
    private NuevoEnemigo<Enemigo> ataque;
    Object[] fila;
    private DefaultTableModel modelMapa2;
    private double[] vida;
    private JPanel panelEnemigos;
    private JLabel enemigo1, enemigo2, enemigo3, enemigo4, ataqueAuto;
    private NuevoAvatar<NombreJugador> miLista;
    private int aleatorio = (int)(Math.random()*100)+1; 
    private int contador=0;
    
    
    public DlgAtaque(java.awt.Frame parent, boolean modal, int i, int j, int filas, int columnas, JLabel[][]mapa, Icon balaArriba, Icon balaAbajo, Icon balaIzquierda, Icon balaDerecha, Icon cumbres, Icon mar, Icon campo, int[][] tipoTerreno, int[][] ocupado, Icon torreta, int[][] enemigos, Object[] fila, NuevoEnemigo<Enemigo> ataque, DefaultTableModel modelMapa2, double[] vida, JPanel panelEnemigos, JLabel enemigo1, JLabel enemigo2, JLabel enemigo3, JLabel enemigo4, Icon autoTanque, Icon autoAvion, int[][] valores, int numCelda, NuevoAvatar<NombreJugador> miLista, JLabel ataqueAuto) {
        super(parent, modal);
        this.i = i;
        this.j = j;
        this.filas = filas;
        this.columnas = columnas;
        this.mapa = mapa;
        this.balaArriba = balaArriba;
        this.balaAbajo = balaAbajo;
        this.balaIzquierda = balaIzquierda;
        this.balaDerecha = balaDerecha;
        this.cumbres = cumbres;
        this.mar = mar;
        this.campo = campo;
        this.tipoTerreno = tipoTerreno;
        this.ocupado = ocupado;
        this.torreta = torreta;
        this.enemigos = enemigos;
        this.fila = fila;
        this.ataque = ataque;
        this.modelMapa2 = modelMapa2;
        this.vida = vida;
        this.panelEnemigos = panelEnemigos;
        this.enemigo1 = enemigo1;
        this.enemigo2 = enemigo2;
        this.enemigo3 = enemigo3;
        this.enemigo4 = enemigo4;
        this.autoTanque = autoTanque;
        this.autoAvion = autoAvion;
        this.valores = valores;
        this.numCelda = numCelda;
        this.miLista = miLista;
        this.ataqueAuto = ataqueAuto;
        initComponents();
        setLocationRelativeTo(null);
        ataqueTotal.setText(ataqueAuto.getText());
        ataqueArma.setText(Integer.toString(0));
        mostrarDado.setText(Integer.toString(0));
        cargarValores(ataqueAuto);
        mostrarDatos();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        direccionAtaque = new javax.swing.JComboBox<>();
        panel1 = new javax.swing.JPanel();
        txt1 = new javax.swing.JLabel();
        ataqueTotal = new javax.swing.JLabel();
        panel2 = new javax.swing.JPanel();
        dadoAtaque = new javax.swing.JButton();
        txt2 = new javax.swing.JLabel();
        mostrarDado = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        disparo = new javax.swing.JButton();
        resultado = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaArmas = new javax.swing.JTable();
        txt3 = new javax.swing.JLabel();
        ataqueArma = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        direccionAtaque.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Arriba", "Abajo", "Izquierda", "Derecha" }));
        getContentPane().add(direccionAtaque, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 100, -1));

        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt1.setText("Daño Inicial:");
        panel1.add(txt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 20));
        panel1.add(ataqueTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 60, 20));

        getContentPane().add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 180, 60));

        panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dadoAtaque.setText("Girar dado:");
        dadoAtaque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dadoAtaqueActionPerformed(evt);
            }
        });
        panel2.add(dadoAtaque, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        txt2.setText("Resultado:");
        panel2.add(txt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 70, -1));
        panel2.add(mostrarDado, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 40, 20));

        getContentPane().add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 180, 150));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        disparo.setText("Disparar");
        disparo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disparoActionPerformed(evt);
            }
        });
        jPanel1.add(disparo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, -1, -1));
        jPanel1.add(resultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 50, 20));

        jButton1.setText("Calcular Daño");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 490, 70));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaArmas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Armas:"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaArmas);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 140));

        txt3.setText("Daño Arma:");
        jPanel2.add(txt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));
        jPanel2.add(ataqueArma, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 60, 60));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 280, 170));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void disparoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disparoActionPerformed
        Timer timer = new Timer();
        MovBalaAbajo abajo = new MovBalaAbajo();
        MovAbajo2 abajo2 = new MovAbajo2();
        MovBalaArriba arriba = new MovBalaArriba();
        MovArriba2 arriba2 = new MovArriba2();
        MovBalaIzquierda izquierda = new MovBalaIzquierda();
        MovIzquierda2 izquierda2 = new MovIzquierda2();
        MovBalaDerecha derecha = new MovBalaDerecha();
        MovDerecha2 derecha2 = new MovDerecha2();
        movDisparo = direccionAtaque.getSelectedItem().toString();
        switch(movDisparo){
            case "Arriba":
                arriba.valores(i-1, j, mapa, balaArriba, ocupado, torreta, enemigos, enemigo1, enemigo2, enemigo3, enemigo4, resultado);
                arriba2.valores(i-1, j, 0, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torreta, autoTanque, autoAvion, valores);
                timer.schedule(arriba, 0, 1000);
                timer.schedule(arriba2, 1000, 1000);
                break;
            case "Abajo":
                abajo.valores(i+1, j, filas, mapa, balaAbajo, ocupado, torreta, enemigos, enemigo1, enemigo2, enemigo3, enemigo4, resultado);
                abajo2.valores(i+1, j, filas, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torreta, autoTanque, autoAvion, valores);
                timer.schedule(abajo, 0, 1000);
                timer.schedule(abajo2, 1000, 1000);
                break;
            case "Izquierda":
                izquierda.valores(i, j-1, mapa, balaIzquierda, ocupado, torreta, enemigos, enemigo1, enemigo2, enemigo3, enemigo4, resultado);
                izquierda2.valores(i, j-1, 0, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torreta, autoTanque, autoAvion, valores);
                timer.schedule(izquierda, 0, 1000);
                timer.schedule(izquierda2, 1000, 1000);
                break;
            case "Derecha":
                derecha.valores(i, j+1, columnas, mapa, balaDerecha, ocupado, torreta, enemigos, enemigo1, enemigo2, enemigo3, enemigo4, resultado);
                derecha2.valores(i, j+1, columnas, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torreta, autoTanque, autoAvion, valores);
                timer.schedule(derecha, 0, 1000);
                timer.schedule(derecha2, 1000, 1000);
                break;
        }
    }//GEN-LAST:event_disparoActionPerformed

    private void dadoAtaqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dadoAtaqueActionPerformed
        if(contador==0){
            mostrarDado.setText(Integer.toString(aleatorio));
        } else{
            JOptionPane.showMessageDialog(null, "Ya se ha calculado el daño anteriormente, solo te queda disparar");
        }
    }//GEN-LAST:event_dadoAtaqueActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        contador++;
        resultado.setText(Double.toString((Double.parseDouble(ataqueTotal.getText()) + Double.parseDouble(ataqueArma.getText()))+((Double.parseDouble(ataqueTotal.getText()) + Double.parseDouble(ataqueArma.getText()))*(Double.parseDouble(mostrarDado.getText())/100))/2));
               
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void cargarValores(JLabel ataqueAuto){
         try {
            Nodo<NombreJugador> elemento = miLista.obtenerElemento(numCelda);
            NombreJugador tabla = elemento.obtenerContenido();
            modelMapa2 = (DefaultTableModel) tablaArmas.getModel();
            Object[] fila = new Object[modelMapa2.getColumnCount()];
            for(int i=0; i<tabla.getMisArmas().obtenerCantidadElementos(); i++){
                try{
                    Nodo5<Armas> elemento2 = tabla.getMisArmas().obtenerElemento(i);
                    Armas nombre = elemento2.obtenerContenido();
                    fila[0] = nombre.getNombre();
                    modelMapa2.addRow(fila);
                } catch (Exception ex){
                    Logger.getLogger(DlgListaAutos.class.getName()).log(Level.SEVERE, null, ex);    
                }}
        } catch (Exception ex){
            Logger.getLogger(DlgListaAutos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void mostrarDatos(){
        tablaArmas.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){
                if (contador==0){
                    try{
                        numCelda2 = tablaArmas.rowAtPoint(e.getPoint());
                        Nodo<NombreJugador> elemento = miLista.obtenerElemento(numCelda);
                        NombreJugador lista = elemento.obtenerContenido();
                        Nodo5<Armas> elemento2 = lista.getMisArmas().obtenerElemento(numCelda2);
                        Armas nombre = elemento2.obtenerContenido();
                        ataqueArma.setText(Double.toString(nombre.getAtaque()));
                    } catch(Exception ex){
                        Logger.getLogger(DlgListaAvatares.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ya se ha calculado el daño anteriormente, solo te queda disparar :/");
                }
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ataqueArma;
    private javax.swing.JLabel ataqueTotal;
    private javax.swing.JButton dadoAtaque;
    private javax.swing.JComboBox<String> direccionAtaque;
    private javax.swing.JButton disparo;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mostrarDado;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JLabel resultado;
    public javax.swing.JTable tablaArmas;
    private javax.swing.JLabel txt1;
    private javax.swing.JLabel txt2;
    private javax.swing.JLabel txt3;
    // End of variables declaration//GEN-END:variables
}
