package practicafinal.ipc1;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author luisGonzalez
 */
public class DlgListaAutos extends javax.swing.JDialog {
    
    private NuevoAvatar<NombreJugador> misAutos;
    public DefaultTableModel dtmModel2;
    private int numCelda;

    public DlgListaAutos(java.awt.Frame parent, boolean modal, NuevoAvatar<NombreJugador> misAutos, int numCelda) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null); 
        this.numCelda = numCelda;
        this.misAutos = misAutos;
        cargarTabla();
        }
    
    protected void cargarTabla(){
        try {
            Nodo<NombreJugador> elemento = misAutos.obtenerElemento(numCelda);
            NombreJugador tabla = elemento.obtenerContenido();
            dtmModel2 = (DefaultTableModel) tablaAutos.getModel();
            Object[] fila = new Object[dtmModel2.getColumnCount()];
            for(int i=0; i<tabla.getMiLista().obtenerCantidadElementos(); i++){
                try{
                    Nodo2<NombreAuto> elemento2 = tabla.getMiLista().obtenerElemento(i);
                    NombreAuto nombre = elemento2.obtenerContenido();
                    fila[0] = nombre.getNombre();
                    fila[1] = nombre.getTipoAuto();
                    fila[2] = nombre.getAtaque();
                    fila[3] = nombre.getArmadura();
                    fila[4] = nombre.getExperiencia();
                    fila[5] = nombre.getNivel();
                    fila[6] = nombre.getVida();
                    dtmModel2.addRow(fila);
                } catch (Exception ex){
                    Logger.getLogger(DlgListaAvatares.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(DlgListaAutos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAutos = new javax.swing.JTable();
        txt = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        nombreAuto = new javax.swing.JButton();
        niveles = new javax.swing.JButton();
        botVida = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tablaAutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Autos:", "Tipo Auto:", "Ataque:", "Armadura:", "Experiencia:", "Nivel:", "Vida:"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaAutos);

        txt.setText("Ordenar por:");

        nombreAuto.setText("Nombre");
        nombreAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreAutoActionPerformed(evt);
            }
        });

        niveles.setText("Nivel");

        botVida.setText("Vida");
        botVida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botVidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nombreAuto)
                .addGap(145, 145, 145)
                .addComponent(niveles)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botVida)
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreAuto)
                    .addComponent(niveles)
                    .addComponent(botVida))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(247, 247, 247)
                .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botVidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botVidaActionPerformed

    }//GEN-LAST:event_botVidaActionPerformed

    private void nombreAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreAutoActionPerformed
        
    }//GEN-LAST:event_nombreAutoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botVida;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton niveles;
    private javax.swing.JButton nombreAuto;
    public javax.swing.JTable tablaAutos;
    private javax.swing.JLabel txt;
    // End of variables declaration//GEN-END:variables
}
