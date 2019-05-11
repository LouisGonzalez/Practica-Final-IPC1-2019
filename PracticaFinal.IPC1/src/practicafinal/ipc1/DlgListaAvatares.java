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

        tablaDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombres:"
            }
        ));
        jScrollPane1.setViewportView(tablaDatos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tablaDatos;
    // End of variables declaration//GEN-END:variables
}
