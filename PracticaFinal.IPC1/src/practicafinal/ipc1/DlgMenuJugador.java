package practicafinal.ipc1;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author luisGonzalez
 */
public class DlgMenuJugador extends javax.swing.JDialog {
    
    private NuevoAvatar<NombreJugador> miLista;  
    private int numCelda;
    private ImageIcon menu = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/menu.jpg");
    
    //clase que muestra las opciones variadas al jugador
    public DlgMenuJugador(java.awt.Frame parent, boolean modal, DefaultTableModel dtm, int fila, int columna, NuevoAvatar<NombreJugador> miLista, int numCelda) {
        super(parent, modal);
        initComponents();
        this.numCelda = numCelda;
        this.miLista = miLista;
        setLocationRelativeTo(null);
        Icon fotos = new ImageIcon(menu.getImage().getScaledInstance(contornoMenu.getWidth(), contornoMenu.getHeight(), Image.SCALE_DEFAULT));
        contornoMenu.setIcon(fotos);
        nombreJugador.setText("bienvenido "+dtm.getValueAt(fila, columna));
        
    }
           
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tienda = new javax.swing.JButton();
        crearAutos = new javax.swing.JButton();
        verAutos = new javax.swing.JButton();
        juegoNuevo = new javax.swing.JButton();
        nombreJugador = new javax.swing.JLabel();
        contornoMenu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tienda.setBackground(new java.awt.Color(255, 255, 255));
        tienda.setForeground(new java.awt.Color(255, 255, 255));
        tienda.setText("Tienda");
        tienda.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tienda.setContentAreaFilled(false);
        tienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tiendaActionPerformed(evt);
            }
        });
        getContentPane().add(tienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 80, 30));

        crearAutos.setBackground(new java.awt.Color(255, 255, 255));
        crearAutos.setForeground(new java.awt.Color(255, 255, 255));
        crearAutos.setText("Crear Auto");
        crearAutos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        crearAutos.setContentAreaFilled(false);
        crearAutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearAutosActionPerformed(evt);
            }
        });
        getContentPane().add(crearAutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 100, 40));

        verAutos.setBackground(new java.awt.Color(255, 255, 255));
        verAutos.setForeground(new java.awt.Color(255, 255, 255));
        verAutos.setText("Estadisticas");
        verAutos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        verAutos.setContentAreaFilled(false);
        verAutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verAutosActionPerformed(evt);
            }
        });
        getContentPane().add(verAutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 100, 40));

        juegoNuevo.setBackground(new java.awt.Color(255, 255, 255));
        juegoNuevo.setForeground(new java.awt.Color(255, 255, 255));
        juegoNuevo.setText("Jugar");
        juegoNuevo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        juegoNuevo.setContentAreaFilled(false);
        juegoNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                juegoNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(juegoNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 70, 30));

        nombreJugador.setBackground(new java.awt.Color(255, 255, 255));
        nombreJugador.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(nombreJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 167, 29));
        getContentPane().add(contornoMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tiendaActionPerformed
        DlgTienda tienda = new DlgTienda(null, true, numCelda, miLista);
        tienda.setVisible(true);
    }//GEN-LAST:event_tiendaActionPerformed

    private void juegoNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_juegoNuevoActionPerformed
        try{
            Nodo<NombreJugador> elemento = miLista.obtenerElemento(numCelda);
            NombreJugador lista = elemento.obtenerContenido();
            if(lista.getMiLista().obtenerCantidadElementos()<3){
                JOptionPane.showMessageDialog(null, "Para empezar a jugar necesitas almenos 3 vehiculo iniciales");
            } else {
                DlgTipoEscenario jugar = new DlgTipoEscenario(null, true, miLista, numCelda);
                jugar.setVisible(true);
            }
        } catch(Exception e){         
        }
    }//GEN-LAST:event_juegoNuevoActionPerformed

    private void crearAutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearAutosActionPerformed
        DlgNuevoAuto nuevo = new DlgNuevoAuto(null, true, miLista, numCelda);
        nuevo.setVisible(true);

    }//GEN-LAST:event_crearAutosActionPerformed

    private void verAutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verAutosActionPerformed
        DlgListaAutos autos = new DlgListaAutos(null, true, miLista, numCelda);
        autos.setVisible(true);
    }//GEN-LAST:event_verAutosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel contornoMenu;
    private javax.swing.JButton crearAutos;
    private javax.swing.JButton juegoNuevo;
    private javax.swing.JLabel nombreJugador;
    private javax.swing.JButton tienda;
    private javax.swing.JButton verAutos;
    // End of variables declaration//GEN-END:variables
}
