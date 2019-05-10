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
public class DlgAtaqueMult extends javax.swing.JDialog {
    
    private String movDisparo;
    private int i, j, filas, columnas, numCelda, numCelda2, numCelda3;
    private JLabel[][] mapa;
    private Icon balaArriba, balaAbajo, balaIzquierda, balaDerecha, cumbres, mar, campo, torreta, autoTanque, autoAvion;
    private int[][] tipoTerreno, ocupado, enemigos, valores, valores2;
    private DefaultTableModel modelMapa2;
    private NuevoAvatar<NombreJugador> miLista;
    private int aleatorio = (int)(Math.random()*100)+1; 
    private int contador=0;
    private JLabel numAuto2, vidaAuto2;
    
    public DlgAtaqueMult(java.awt.Frame parent, boolean modal, int i, int j, int filas, int columnas, JLabel[][]mapa, Icon balaArriba, Icon balaAbajo, Icon balaIzquierda, Icon balaDerecha, Icon cumbres, Icon mar, Icon campo, int[][] tipoTerreno, int[][] ocupado, Icon torreta, int[][] enemigos, DefaultTableModel modelMapa2, Icon autoTanque, Icon autoAvion, int[][] valores, int[][] valores2, int numCelda, NuevoAvatar<NombreJugador> miLista, JLabel ataqueAuto, int numCelda3, JLabel numAuto2, JLabel vidaAuto2) {
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
        this.modelMapa2 = modelMapa2;
        this.autoTanque = autoTanque;
        this.autoAvion = autoAvion;
        this.valores = valores;
        this.valores2 = valores2;
        this.numCelda = numCelda;
        this.numAuto2 = numAuto2;
        this.miLista = miLista;
        this.numCelda3 = numCelda3;
        this.vidaAuto2 = vidaAuto2;
        initComponents();
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
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaArmas = new javax.swing.JTable();
        txt = new javax.swing.JLabel();
        ataqueArma = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txt2 = new javax.swing.JLabel();
        ataqueTotal = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        dadoAtaque = new javax.swing.JButton();
        txt3 = new javax.swing.JLabel();
        mostrarDado = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        resultado = new javax.swing.JLabel();
        disparo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        direccionAtaque.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Arriba", "Abajo", "Izquierda", "Derecha" }));
        getContentPane().add(direccionAtaque, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 130, 30));

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

        txt.setText("Daño Arma:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(ataqueArma, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(txt)
                .addGap(26, 26, 26)
                .addComponent(ataqueArma, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 240, 160));

        txt2.setText("Daño Inicial:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(txt2)
                .addGap(41, 41, 41)
                .addComponent(ataqueTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ataqueTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt2)
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 290, 40));

        dadoAtaque.setText("Girar dado:");
        dadoAtaque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dadoAtaqueActionPerformed(evt);
            }
        });

        txt3.setText("Resultado:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(txt3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(dadoAtaque)
                        .addGap(67, 67, 67))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(mostrarDado, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(dadoAtaque)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt3)
                .addGap(18, 18, 18)
                .addComponent(mostrarDado, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 230, 160));

        jButton1.setText("Calcular Daño");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        disparo.setText("DISPARA!");
        disparo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disparoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jButton1)
                .addGap(43, 43, 43)
                .addComponent(resultado, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(disparo)
                .addGap(55, 55, 55))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(resultado, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(disparo)
                .addGap(22, 22, 22))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 470, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dadoAtaqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dadoAtaqueActionPerformed
        if(contador==0){
            mostrarDado.setText(Integer.toString(aleatorio));
        } else{
            JOptionPane.showMessageDialog(null, "Ya se ha calculado el daño anteriormente, solo te queda disparar");
        }
    }//GEN-LAST:event_dadoAtaqueActionPerformed

    private void disparoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disparoActionPerformed
        Timer timer = new Timer();
        DisparoAbajoMult abajo = new DisparoAbajoMult();
        MovAbajo2 abajo2 = new MovAbajo2();
        DisparoArribaMult arriba = new DisparoArribaMult();
        MovArriba2 arriba2 = new MovArriba2();
        DisparoIzquierdaMult izquierda = new DisparoIzquierdaMult();
        MovIzquierda2 izquierda2 = new MovIzquierda2();
        DisparoDerechaMult derecha = new DisparoDerechaMult();
        MovDerecha2 derecha2 = new MovDerecha2();
        movDisparo = direccionAtaque.getSelectedItem().toString();
        switch(movDisparo){
            case "Arriba":
                arriba.valores(i-1, j, ocupado, valores2, resultado, mapa, balaArriba, autoTanque, autoAvion, miLista, numCelda3, numAuto2, vidaAuto2);
                arriba2.valores(i-1, j, 0, mapa, cumbres, mar, campo, tipoTerreno, valores2, autoTanque, autoTanque, autoAvion, valores, autoAvion);
                timer.schedule(arriba, 0, 1000);
                timer.schedule(arriba2, 1000, 1000);
                break;
            case "Abajo":
                abajo.valores(i+1, j, filas, ocupado, valores2, resultado, mapa, balaAbajo, autoTanque, autoAvion, miLista, numCelda3, numAuto2, vidaAuto2);
                abajo2.valores(i+1, j, filas, mapa, cumbres, mar, campo, tipoTerreno, valores2, autoTanque, autoTanque, autoAvion, valores, autoAvion);
                timer.schedule(abajo, 0, 1000);
                timer.schedule(abajo2, 1000, 1000);
                break;
            case "Izquierda":
                izquierda.valores(i, j-1, ocupado, valores2, resultado, mapa, balaIzquierda, autoTanque, autoAvion, miLista, numCelda3, numAuto2, vidaAuto2);
                izquierda2.valores(i, j-1, 0, mapa, cumbres, mar, campo, tipoTerreno, valores2, autoTanque, autoTanque, autoAvion, valores, autoAvion);
                timer.schedule(izquierda, 0, 1000);
                timer.schedule(izquierda2, 1000, 1000);
                break;
            case "Derecha":
                derecha.valores(i, j+1, columnas, ocupado, valores2, resultado, mapa, balaDerecha, autoTanque, autoAvion, miLista, numCelda3, numAuto2, vidaAuto2);
                derecha2.valores(i, j+1, columnas, mapa, cumbres, mar, campo, tipoTerreno, valores2, autoTanque, autoTanque, autoAvion, valores, autoAvion);
                timer.schedule(derecha, 0, 1000);
                timer.schedule(derecha2, 1000, 1000);
                break;
        }

    }//GEN-LAST:event_disparoActionPerformed

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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mostrarDado;
    private javax.swing.JLabel resultado;
    public javax.swing.JTable tablaArmas;
    private javax.swing.JLabel txt;
    private javax.swing.JLabel txt2;
    private javax.swing.JLabel txt3;
    // End of variables declaration//GEN-END:variables
}
