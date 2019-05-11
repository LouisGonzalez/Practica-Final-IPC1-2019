package practicafinal.ipc1;

import java.awt.Image;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
    private ImageIcon bala = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/hit.jpg");
    private ImageIcon mini = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/qw.jpg");
    
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
        Icon balita = new ImageIcon(bala.getImage().getScaledInstance(fondoPantalla.getWidth(), fondoPantalla.getHeight(), Image.SCALE_DEFAULT));        
        Icon mini2 = new ImageIcon(mini.getImage().getScaledInstance(fondo1.getWidth(), fondo1.getHeight(), Image.SCALE_DEFAULT));
        Icon mini3 = new ImageIcon(mini.getImage().getScaledInstance(fondo2.getWidth(), fondo2.getHeight(), Image.SCALE_DEFAULT));
        Icon mini4 = new ImageIcon(mini.getImage().getScaledInstance(fondo3.getWidth(), fondo3.getHeight(), Image.SCALE_DEFAULT));
        Icon mini5 = new ImageIcon(mini.getImage().getScaledInstance(fondo4.getWidth(), fondo4.getHeight(), Image.SCALE_DEFAULT));
        fondoPantalla.setIcon(balita);
        fondo1.setIcon(mini2);
        fondo2.setIcon(mini3);
        fondo3.setIcon(mini4);
        fondo4.setIcon(mini5);
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
        txt = new javax.swing.JLabel();
        ataqueArma = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaArmas = new javax.swing.JTable();
        fondo1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txt2 = new javax.swing.JLabel();
        ataqueTotal = new javax.swing.JLabel();
        fondo4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        dadoAtaque = new javax.swing.JButton();
        txt3 = new javax.swing.JLabel();
        mostrarDado = new javax.swing.JLabel();
        fondo2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        resultado = new javax.swing.JLabel();
        disparo = new javax.swing.JButton();
        fondo3 = new javax.swing.JLabel();
        fondoPantalla = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        direccionAtaque.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Arriba", "Abajo", "Izquierda", "Derecha" }));
        getContentPane().add(direccionAtaque, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 130, 30));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt.setBackground(new java.awt.Color(255, 255, 255));
        txt.setForeground(new java.awt.Color(255, 255, 255));
        txt.setText("Daño Arma:");
        jPanel1.add(txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 33, -1, -1));

        ataqueArma.setBackground(new java.awt.Color(255, 255, 255));
        ataqueArma.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ataqueArma, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 73, 38, 18));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 122, 136));
        jPanel1.add(fondo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 170));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 250, 170));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt2.setBackground(new java.awt.Color(255, 255, 255));
        txt2.setForeground(new java.awt.Color(255, 255, 255));
        txt2.setText("Daño Inicial:");
        jPanel2.add(txt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 12, -1, -1));

        ataqueTotal.setBackground(new java.awt.Color(255, 255, 255));
        ataqueTotal.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(ataqueTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 12, 75, 16));
        jPanel2.add(fondo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 290, 40));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dadoAtaque.setBackground(new java.awt.Color(255, 255, 255));
        dadoAtaque.setForeground(new java.awt.Color(255, 255, 255));
        dadoAtaque.setText("Girar dado:");
        dadoAtaque.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        dadoAtaque.setContentAreaFilled(false);
        dadoAtaque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dadoAtaqueActionPerformed(evt);
            }
        });
        jPanel3.add(dadoAtaque, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 15, 120, 30));

        txt3.setBackground(new java.awt.Color(255, 255, 255));
        txt3.setForeground(new java.awt.Color(255, 255, 255));
        txt3.setText("Resultado:");
        jPanel3.add(txt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 62, -1, -1));

        mostrarDado.setBackground(new java.awt.Color(255, 255, 255));
        mostrarDado.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(mostrarDado, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 94, 36, 17));
        jPanel3.add(fondo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 170));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 230, 170));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Calcular Daño");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 19, 120, 30));

        resultado.setBackground(new java.awt.Color(255, 255, 255));
        resultado.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(resultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 21, 56, 24));

        disparo.setBackground(new java.awt.Color(255, 255, 255));
        disparo.setForeground(new java.awt.Color(255, 255, 255));
        disparo.setText("DISPARA!");
        disparo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        disparo.setContentAreaFilled(false);
        disparo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disparoActionPerformed(evt);
            }
        });
        jPanel4.add(disparo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 100, 30));
        jPanel4.add(fondo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 70));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 470, 70));
        getContentPane().add(fondoPantalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 350));

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
        //INVOCACION A LOS METODOS PARA ATAQUE EN MODO MULTIJUGADOR
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
        //METODO QUE GENERA QUE UNA TABLA SEA USADA MEDIANTE CLICKS
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
    private javax.swing.JLabel fondo1;
    private javax.swing.JLabel fondo2;
    private javax.swing.JLabel fondo3;
    private javax.swing.JLabel fondo4;
    private javax.swing.JLabel fondoPantalla;
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
