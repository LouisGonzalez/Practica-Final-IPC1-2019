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
public class DlgPosBots extends javax.swing.JDialog {
    
    private NuevoAvatar<NombreJugador> miLista;
    private int numCelda, numCelda2;
    private DefaultTableModel modelBot;
    private int[] posBotX;
    private int[] posBotY;
            
    public DlgPosBots(java.awt.Frame parent, boolean modal, int numCelda, NuevoAvatar<NombreJugador> miLista, JLabel[][] mapa, int posX, int posY, int[][] bots, Icon bot, int contador, int[] posBotX, int[] posBotY) {
        super(parent, modal);
        this.numCelda = numCelda;
        this.miLista = miLista;
        this.posBotX = posBotX;
        this.posBotY = posBotY;
        initComponents();
        setLocationRelativeTo(null);
        cargarValores(mapa, posX, posY, bots, bot, contador);
        int contador2 = contador+3;
        
                        
    }
    
    private void cargarValores(JLabel[][] mapa, int posX, int posY, int[][] botsa, Icon bot, int contador){
        try{
            Nodo<NombreJugador> elemento = miLista.obtenerElemento(numCelda);
            NombreJugador tabla = elemento.obtenerContenido();
            modelBot = (DefaultTableModel) tablaBots.getModel();
            Object[] fila = new Object[modelBot.getColumnCount()];
            for(int i=0; i<tabla.getMisBots().obtenerCantidadElementos(); i++){
                try{
                    Nodo6<Bot> elemento2 = tabla.getMisBots().obtenerElemento(i);
                    Bot bots = elemento2.obtenerContenido();
                    fila[0] = bots.getNombre();
                    fila[1] = bots.getAtaque();
                    modelBot.addRow(fila);
                    posicionarBot(mapa, posX, posY, botsa, bot, contador);
                    tablaBots.setModel(modelBot);
                } catch (Exception ex){
                    Logger.getLogger(DlgListaAutos.class.getName()).log(Level.SEVERE, null, ex);    
                }
            }
        }catch(Exception e){          
            Logger.getLogger(DlgListaAutos.class.getName()).log(Level.SEVERE, null, e);                   
        }
    }
    
    private void posicionarBot(JLabel[][] mapa, int posX, int posY, int[][] bots, Icon bot, int contador){
        tablaBots.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){
                    numCelda2 = tablaBots.rowAtPoint(e.getPoint());
                    mapa[posX][posY].setIcon(bot);
                    bots[posX][posY] = 1;  
                    posBotX[numCelda2] = posX;
                    posBotY[numCelda2] = posY;
                    
                    
                modelBot.removeRow(numCelda);
            }
        });
       
    }

    public int[] getPosBotX() {
        return posBotX;
    }

    public int[] getPosBotY() {
        return posBotY;
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaBots = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaBots.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bots:", "Daño:"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaBots);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 291, 275));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tablaBots;
    // End of variables declaration//GEN-END:variables
}
