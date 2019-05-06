package practicafinal.ipc1;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luisGonzalez
 */
public class DlgTercerEscenario extends javax.swing.JDialog {
    
    private JLabel[][] mapa;
    private int x, y, numCelda, terreno1, terreno2, terreno3;
    private static final int filas = 8;
    private static final int columnas = 9;
    private final ImageIcon cumbre = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/cumbre4.jpg");
    private final ImageIcon agua = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/mar.jpg");
    private final ImageIcon campoAbierto = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/campoAbierto.jpg");    
    private final Border borde = LineBorder.createGrayLineBorder();
    private NuevoAvatar<NombreJugador> misAutos;
    public DefaultTableModel modelMapa3;
    
    public DlgTercerEscenario(java.awt.Frame parent, boolean modal, NuevoAvatar<NombreJugador> misAutos, int numCelda) {
        super(parent, modal);
        initComponents();
        Icon cumbres = new ImageIcon(cumbre.getImage().getScaledInstance(segunda.getWidth(), segunda.getHeight(), Image.SCALE_DEFAULT));
        Icon mar = new ImageIcon(agua.getImage().getScaledInstance(tercera.getWidth(), tercera.getHeight(), Image.SCALE_DEFAULT));
        Icon campo = new ImageIcon(campoAbierto.getImage().getScaledInstance(primera.getWidth(), primera.getHeight(), Image.SCALE_DEFAULT)); 
        this.misAutos = misAutos;
        this.numCelda = numCelda;
        primera.setIcon(campo);
        segunda.setIcon(cumbres);
        tercera.setIcon(mar);
        setLocationRelativeTo(null);
        cargarEscenario();
        cargarValores();
    }
    
    private void cargarEscenario(){
        this.mapa = new JLabel[filas][columnas];
        tableroJuego.setLayout(new GridLayout(filas, columnas));
        for(x = 0; x<filas; x++){
            for(y=0; y<columnas; y++){
                JLabel matriz = new JLabel();
                matriz.setOpaque(true);
                matriz.setBackground(Color.white);
                matriz.setBorder(borde);
                matriz.setBounds(75*x,75*y,75,75);
                terreno1=x;
                terreno2=y;
                mapa[x][y] = matriz;
                pintarMapa(x, y, mapa);
                tableroJuego.add(mapa[x][y]);
                tableroJuego.validate();
                tableroJuego.repaint();
            }
        }
    }
    
    private void pintarMapa(int x, int y, JLabel[][] mapa){
        Icon primerFoto = new ImageIcon(cumbre.getImage().getScaledInstance(mapa[x][y].getWidth(), mapa[x][y].getHeight(), Image.SCALE_DEFAULT));
        Icon segundaFoto = new ImageIcon(agua.getImage().getScaledInstance(mapa[x][y].getWidth(), mapa[x][y].getHeight(), Image.SCALE_DEFAULT));
        Icon tercerFoto = new ImageIcon(campoAbierto.getImage().getScaledInstance(mapa[x][y].getWidth(), mapa[x][y].getHeight(), Image.SCALE_DEFAULT));
                int numAleatorio =(int)(Math.random()*3)+1;
                switch(numAleatorio){
                    case 1:
                        mapa[x][y].setIcon(primerFoto);
                        break;
                    case 2:
                        mapa[x][y].setIcon(segundaFoto);
                        break;
                    case 3:
                        mapa[x][y].setIcon(tercerFoto);
                        break;
        }
    }
    
    private void cargarValores(){
        try {
            Nodo<NombreJugador> elemento = misAutos.obtenerElemento(numCelda);
            NombreJugador tabla = elemento.obtenerContenido();
            modelMapa3 = (DefaultTableModel) tablaVehiculos3.getModel();
            Object[] fila = new Object[modelMapa3.getColumnCount()];
            for(int i=0; i<tabla.getMiLista().obtenerCantidadElementos(); i++){
                try{
                    Nodo2<NombreAuto> elemento2 = tabla.getMiLista().obtenerElemento(i);
                    NombreAuto nombre = elemento2.obtenerContenido();
                    fila[0] = nombre.getNombre();
                    modelMapa3.addRow(fila);
                } catch (Exception ex){
                    Logger.getLogger(DlgListaAutos.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        } catch (Exception ex){
            Logger.getLogger(DlgListaAutos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tableroJuego = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVehiculos3 = new javax.swing.JTable();
        primera = new javax.swing.JLabel();
        segunda = new javax.swing.JLabel();
        tercera = new javax.swing.JLabel();
        txtTitulo1 = new javax.swing.JLabel();
        txtTitulo2 = new javax.swing.JLabel();
        txtTitulo3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout tableroJuegoLayout = new javax.swing.GroupLayout(tableroJuego);
        tableroJuego.setLayout(tableroJuegoLayout);
        tableroJuegoLayout.setHorizontalGroup(
            tableroJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        tableroJuegoLayout.setVerticalGroup(
            tableroJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        getContentPane().add(tableroJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 700, 480));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 690, 20, 20));

        tablaVehiculos3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vehiculos:"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaVehiculos3);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 150, 160));
        getContentPane().add(primera, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 40, 80, 60));
        getContentPane().add(segunda, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 140, 80, 60));
        getContentPane().add(tercera, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 230, 80, 60));

        txtTitulo1.setText("Campo de las mil batallas");
        getContentPane().add(txtTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 60, -1, -1));

        txtTitulo2.setText("Montañas de Idrazil");
        getContentPane().add(txtTitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 160, -1, -1));

        txtTitulo3.setText("Mar de Atlantis");
        getContentPane().add(txtTitulo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 250, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel primera;
    private javax.swing.JLabel segunda;
    public javax.swing.JTable tablaVehiculos3;
    private javax.swing.JPanel tableroJuego;
    private javax.swing.JLabel tercera;
    private javax.swing.JLabel txtTitulo1;
    private javax.swing.JLabel txtTitulo2;
    private javax.swing.JLabel txtTitulo3;
    // End of variables declaration//GEN-END:variables
}
