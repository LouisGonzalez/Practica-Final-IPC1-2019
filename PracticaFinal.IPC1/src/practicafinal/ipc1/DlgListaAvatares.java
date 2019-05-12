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
                fila[0] = jugador.getNombre();
                fila[1] = jugador.getContPartidasGanadas();
                fila[2] = jugador.getContPartidasPerdidas();
                fila[3] = jugador.getTotalPartidas();
                dtmModel.addRow(fila);
            } catch (Exception ex) {
                Logger.getLogger(DlgListaAvatares.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDatos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombres:", "Partidas Ganadas:", "Partidas Perdidas:", "Total de Partidas:"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaDatos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 580, 217));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tablaDatos;
    // End of variables declaration//GEN-END:variables
}
