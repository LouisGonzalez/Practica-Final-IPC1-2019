package practicafinal.ipc1;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author luisGonzalez
 */
public class DlgCambioAuto extends javax.swing.JDialog {

    private NuevoAvatar<NombreJugador> misAutos;
    private int numCelda, numCelda2;
    private DefaultTableModel modelo;
    Nodo<NombreJugador> elemento;
    NombreJugador lista;
    Nodo2<NombreAuto> elemento2;
    NombreAuto nombre;
    
    public DlgCambioAuto(java.awt.Frame parent, boolean modal, NuevoAvatar<NombreJugador> misAutos, int numCelda, JLabel[][] mapa, int posX, int posY, Icon autoTanque, Icon autoAvion, Icon cumbres, Icon mar, Icon campo, int[][] tipoTerreno, int x, int y, int[][] valores, JLabel numAuto, JLabel vidaAuto, JLabel nivelAuto, JLabel ataqueAuto, Nodo<NombreJugador> elemento, NombreJugador lista, Nodo2<NombreAuto> elemento2, NombreAuto nombre, int[][] ocupado) {
        super(parent, modal);
        initComponents();
        this.numCelda = numCelda;
        this.misAutos = misAutos;
        this.elemento = elemento;
        this.lista = lista;
        this.elemento2 = elemento2;
        this.nombre = nombre;
        setLocationRelativeTo(null);
        cargarValores();
        cambiarAuto(mapa, posX, posY, autoTanque, autoAvion, cumbres, mar, campo, tipoTerreno, x, y, valores, numAuto, vidaAuto, nivelAuto, ataqueAuto, ocupado);
        this.dispose();
    }
    
    private void cargarValores(){
        try {
            elemento = misAutos.obtenerElemento(numCelda);
            lista = elemento.obtenerContenido();
            modelo = (DefaultTableModel) cambioAuto.getModel();
            Object[] fila = new Object[modelo.getColumnCount()];
            for(int i=0; i<lista.getMiLista().obtenerCantidadElementos(); i++){
                try{
                    elemento2 = lista.getMiLista().obtenerElemento(i);
                    nombre = elemento2.obtenerContenido();
                    fila[0] = nombre.getNombre();
                    fila[1] = nombre.getTipoAuto();
                    modelo.addRow(fila);
                } catch (Exception ex){
                    Logger.getLogger(DlgListaAutos.class.getName()).log(Level.SEVERE, null, ex);    
                }}
        } catch (Exception ex){
            Logger.getLogger(DlgListaAutos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void cambiarAuto(JLabel[][] mapa, int posX, int posY, Icon autoTanque, Icon autoAvion, Icon cumbres, Icon mar, Icon campo, int[][] respaldo, int x, int y, int[][] valores, JLabel numAuto, JLabel vidaAuto, JLabel nivelAuto, JLabel ataqueAuto, int[][] ocupado){
        cambioAuto.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){
                try{
                    numCelda2 = cambioAuto.rowAtPoint(e.getPoint());
                    elemento = misAutos.obtenerElemento(numCelda);
                    lista = elemento.obtenerContenido();
                    elemento2 = lista.getMiLista().obtenerElemento(numCelda2);
                    nombre = elemento2.obtenerContenido();
                    if(nombre.getTipoAuto().equals("Tanque") && (respaldo[posX][posY] ==1 || respaldo[posX][posY] ==3)){
                        mapa[posX][posY].setIcon(autoTanque);
                        valores[posX][posY] = 1;
                        ocupado[posX][posY] = 1;
                        numAuto.setText(String.valueOf(numCelda2));
                        vidaAuto.setText(Double.toString(nombre.getVida()));
                        ataqueAuto.setText(Double.toString(nombre.getAtaque()));
                        nivelAuto.setText(Integer.toString(nombre.getNivel()));
                    } else if(nombre.getTipoAuto().equals("Avion") && (respaldo[posX][posY] == 2 || respaldo[posX][posY] ==3)){
                        mapa[posX][posY].setIcon(autoAvion);
                        valores[posX][posY] = 2;
                        ocupado[posX][posY] = 1;
                        numAuto.setText(String.valueOf(numCelda2));
                        vidaAuto.setText(Double.toString(nombre.getVida()));
                        ataqueAuto.setText(Double.toString(nombre.getAtaque()));
                        nivelAuto.setText(Integer.toString(nombre.getNivel()));
                    } else {
                            JOptionPane.showMessageDialog(null, "Este auto no puede pasar en este tipo de terreno");
                    
                    }
                
                    
                } catch(Exception ex){
                    Logger.getLogger(DlgListaAvatares.class.getName()).log(Level.SEVERE, null, ex);
                }            
                
            }
        });
    }

    public int getNumCelda2() {
        return numCelda2;
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        cambioAuto = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cambioAuto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vehiculo:", "Tipo:"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(cambioAuto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable cambioAuto;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
