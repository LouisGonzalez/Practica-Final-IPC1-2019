package practicafinal.ipc1;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author luisGonzalez
 */
public class DlgListaAvatares extends javax.swing.JFrame {

    protected NuevoAvatar<NombreJugador> miLista;        
    public DefaultTableModel dtmModel;
    private int contClicks1 = 0;
    private int contClicks2 = 0;
    private int contClicks3 = 0;
    private int contClicks4 = 0;
    private int contClicks5 = 0;
    
    public DlgListaAvatares(NuevoAvatar<NombreJugador> lista) {
        initComponents();
        this.miLista = lista;   
        this.setLocationRelativeTo(null);
        cargarTabla();
         
      }
     // metodo encargado de mostrar los usuarios y personajes que se acaban de crear
    protected void cargarTabla() {
        dtmModel = (DefaultTableModel) tablaDatos.getModel();
        Object[] fila = new Object[dtmModel.getColumnCount()];  
        for(int i=0; i<miLista.obtenerCantidadElementos(); i++){
            try {
                Nodo<NombreJugador> elemento = miLista.obtenerElemento(i);
                NombreJugador jugador = elemento.obtenerContenido();
                cargarDatos(fila, jugador);
                dtmModel.addRow(fila);
            } catch (Exception ex) {
                Logger.getLogger(DlgListaAvatares.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void cargarDatos(Object[] fila, NombreJugador jugador){
        fila[0] = jugador.getNombre();
        fila[1] = jugador.getContPartidasGanadas();
        fila[2] = jugador.getContPartidasPerdidas();
        fila[3] = jugador.getTotalPartidas();
        fila[4] = jugador.getOro();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDatos = new javax.swing.JTable();
        ordenar = new javax.swing.JLabel();
        victorias = new javax.swing.JButton();
        derrotas = new javax.swing.JButton();
        totalPartidas = new javax.swing.JButton();
        nombres = new javax.swing.JButton();
        cantOro = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombres:", "Partidas Ganadas:", "Partidas Perdidas:", "Total de Partidas:", "Oro:"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaDatos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 580, 217));

        ordenar.setText("Ordenar por orden de :");
        getContentPane().add(ordenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 220, -1));

        victorias.setBackground(new java.awt.Color(255, 255, 255));
        victorias.setForeground(new java.awt.Color(0, 153, 153));
        victorias.setText("Victorias");
        victorias.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        victorias.setContentAreaFilled(false);
        victorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                victoriasActionPerformed(evt);
            }
        });
        getContentPane().add(victorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 80, 30));

        derrotas.setBackground(new java.awt.Color(255, 255, 255));
        derrotas.setForeground(new java.awt.Color(0, 153, 153));
        derrotas.setText("Derrotas");
        derrotas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        derrotas.setContentAreaFilled(false);
        derrotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                derrotasActionPerformed(evt);
            }
        });
        getContentPane().add(derrotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 80, 30));

        totalPartidas.setBackground(new java.awt.Color(255, 255, 255));
        totalPartidas.setForeground(new java.awt.Color(0, 204, 204));
        totalPartidas.setText("Total de Partidas");
        totalPartidas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        totalPartidas.setContentAreaFilled(false);
        totalPartidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalPartidasActionPerformed(evt);
            }
        });
        getContentPane().add(totalPartidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 130, 30));

        nombres.setBackground(new java.awt.Color(255, 255, 255));
        nombres.setForeground(new java.awt.Color(0, 153, 153));
        nombres.setText("Nombre");
        nombres.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nombres.setContentAreaFilled(false);
        nombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombresActionPerformed(evt);
            }
        });
        getContentPane().add(nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, 90, 30));

        cantOro.setBackground(new java.awt.Color(255, 255, 255));
        cantOro.setForeground(new java.awt.Color(0, 204, 204));
        cantOro.setText("Oro");
        cantOro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cantOro.setContentAreaFilled(false);
        cantOro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantOroActionPerformed(evt);
            }
        });
        getContentPane().add(cantOro, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, 90, 30));
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void victoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_victoriasActionPerformed
        OrdenacionNombre ordenar = new OrdenacionNombre();
        contClicks1++;
        try{
            NombreJugador[] ordenado = ordenar.ordenarVictoriaAs(miLista);
            NombreJugador[] ordenado2 = ordenar.ordenarVictoriaDes(miLista);
            dtmModel = (DefaultTableModel) tablaDatos.getModel();
            dtmModel.setRowCount(0);
            Object[] fila = new Object[dtmModel.getColumnCount()];           
            if(contClicks1%2!=0){
                for (NombreJugador nombre : ordenado) {
                    cargarDatos(fila, nombre);
                    dtmModel.addRow(fila);
                }                
            } else if (contClicks1%2==0){
                for (NombreJugador nombre : ordenado2) {
                    cargarDatos(fila, nombre);
                    dtmModel.addRow(fila);
                }
            }
        }catch(Exception e){
        }
    }//GEN-LAST:event_victoriasActionPerformed

    private void totalPartidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalPartidasActionPerformed
        OrdenacionNombre ordenar = new OrdenacionNombre();
        contClicks2++;
        try{
            NombreJugador[] ordenado = ordenar.ordenarPartidasAs(miLista);
            NombreJugador[] ordenado2 = ordenar.ordenarPartidasDes(miLista);
            dtmModel = (DefaultTableModel) tablaDatos.getModel();
            dtmModel.setRowCount(0);
            Object[] fila = new Object[dtmModel.getColumnCount()];           
            if(contClicks2%2!=0){
                for (NombreJugador nombre : ordenado) {
                    cargarDatos(fila, nombre);
                    dtmModel.addRow(fila);
                }                
            } else if (contClicks2%2==0){
                for (NombreJugador nombre : ordenado2) {
                    cargarDatos(fila, nombre);
                    dtmModel.addRow(fila);
                }
            }
        }catch(Exception e){
        }
    }//GEN-LAST:event_totalPartidasActionPerformed

    private void derrotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_derrotasActionPerformed
        OrdenacionNombre ordenar = new OrdenacionNombre();
        contClicks3++;
        try{
            NombreJugador[] ordenado = ordenar.ordenarDerrotasAs(miLista);
            NombreJugador[] ordenado2 = ordenar.ordenarDerrotasDes(miLista);
            dtmModel = (DefaultTableModel) tablaDatos.getModel();
            dtmModel.setRowCount(0);
            Object[] fila = new Object[dtmModel.getColumnCount()];           
            if(contClicks3%2!=0){
                for (NombreJugador nombre : ordenado) {
                    cargarDatos(fila, nombre);
                    dtmModel.addRow(fila);
                }                
            } else if (contClicks3%2==0){
                for (NombreJugador nombre : ordenado2) {
                    cargarDatos(fila, nombre);
                    dtmModel.addRow(fila);
                }
            }
        }catch(Exception e){
        }
    }//GEN-LAST:event_derrotasActionPerformed

    private void nombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombresActionPerformed
        OrdenacionNombre ordenar = new OrdenacionNombre();
        contClicks4++;
        try{
            NombreJugador[] ordenado = ordenar.ordenarNombresAs(miLista);
            NombreJugador[] ordenado2 = ordenar.ordenarNombresDes(miLista);
            dtmModel = (DefaultTableModel) tablaDatos.getModel();
            dtmModel.setRowCount(0);
            Object[] fila = new Object[dtmModel.getColumnCount()];           
            if(contClicks4%2!=0){
                for (NombreJugador nombre : ordenado) {
                    cargarDatos(fila, nombre);
                    dtmModel.addRow(fila);
                }                
            } else if (contClicks4%2==0){
                for (NombreJugador nombre : ordenado2) {
                    cargarDatos(fila, nombre);
                    dtmModel.addRow(fila);
                }
            }
        }catch(Exception e){
        }
    }//GEN-LAST:event_nombresActionPerformed

    private void cantOroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantOroActionPerformed
        OrdenacionNombre ordenar = new OrdenacionNombre();
        contClicks5++;
        try{
            NombreJugador[] ordenado = ordenar.ordenarOroAs(miLista);
            NombreJugador[] ordenado2 = ordenar.ordenarOroDes(miLista);
            dtmModel = (DefaultTableModel) tablaDatos.getModel();
            dtmModel.setRowCount(0);
            Object[] fila = new Object[dtmModel.getColumnCount()];           
            if(contClicks5%2!=0){
                for (NombreJugador nombre : ordenado) {
                    cargarDatos(fila, nombre);
                    dtmModel.addRow(fila);
                }                
            } else if (contClicks5%2==0){
                for (NombreJugador nombre : ordenado2) {
                    cargarDatos(fila, nombre);
                    dtmModel.addRow(fila);
                }
            }
        }catch(Exception e){
        }
    }//GEN-LAST:event_cantOroActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cantOro;
    private javax.swing.JButton derrotas;
    private javax.swing.JLabel fondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nombres;
    private javax.swing.JLabel ordenar;
    public javax.swing.JTable tablaDatos;
    private javax.swing.JButton totalPartidas;
    private javax.swing.JButton victorias;
    // End of variables declaration//GEN-END:variables
}
