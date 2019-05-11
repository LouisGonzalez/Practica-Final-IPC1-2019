package practicafinal.ipc1;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author luisGonzalez
 */
public class DlgEleccionMultiJugador extends javax.swing.JDialog {
    
    private NuevoAvatar<NombreJugador> miLista;
    private int contadorClicks = 0;
    private int numCelda, numCelda2;
    //clase encargada de la inovacion de los jueces 
    public DlgEleccionMultiJugador(java.awt.Frame parent, boolean modal, DefaultTableModel dtm, NuevoAvatar<NombreJugador> miLista) {
        super(parent, modal);
        initComponents();
        this.miLista = miLista;
        setLocationRelativeTo(null);
        tablaJugadores.setModel(dtm);
        tablaJugadores.addMouseListener(new java.awt.event.MouseAdapter(){
            @Override                                                                                                                   
            public void mouseClicked(java.awt.event.MouseEvent e){  
                contadorClicks++;
                if(contadorClicks==1){                  
                    numCelda = tablaJugadores.rowAtPoint(e.getPoint());
                    dtm.removeRow(numCelda);
                } else if(contadorClicks>1){
                    numCelda2 = tablaJugadores.rowAtPoint(e.getPoint());
                    if(numCelda<=numCelda2){
                        numCelda2 = numCelda2 + 1;
                    }
                    DlgEscenarioMultiJugador escena = new DlgEscenarioMultiJugador(null, true, miLista, numCelda, numCelda2);
                    escena.setVisible(true);
                }
            }
        });
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaJugadores = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tablaJugadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Jugadores:"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaJugadores);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tablaJugadores;
    // End of variables declaration//GEN-END:variables
}
