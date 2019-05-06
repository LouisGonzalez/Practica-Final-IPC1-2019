package practicafinal.ipc1;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author luisGonzalez
 */
public class MostrarAvatares extends javax.swing.JDialog {
                    
    private NuevoAvatar<NombreJugador> miLista;
    
    public MostrarAvatares(java.awt.Frame parent, boolean modal, DefaultTableModel dtm, NuevoAvatar<NombreJugador> miLista){
        super(parent, modal);
        initComponents();
        this.miLista = miLista;
        setLocationRelativeTo(null);        
        mostrarLista.setModel(dtm);
        mostrarLista.addMouseListener(new java.awt.event.MouseAdapter(){
            @Override                                                                                                                   
            public void mouseClicked(java.awt.event.MouseEvent e){                      
                if(e.getClickCount()==1){                  
                    int fila = mostrarLista.rowAtPoint(e.getPoint());
                    int columna = mostrarLista.columnAtPoint(e.getPoint()); 
                    int numCelda = mostrarLista.rowAtPoint(e.getPoint());
                    DlgMenuJugador menu = new DlgMenuJugador(null, true, dtm, fila, columna, miLista, numCelda);
                    menu.setVisible(true);                     
                }
            }
        });
    }

   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        mostrarLista = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        mostrarLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Jugadores"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(mostrarLista);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable mostrarLista;
    // End of variables declaration//GEN-END:variables
}
