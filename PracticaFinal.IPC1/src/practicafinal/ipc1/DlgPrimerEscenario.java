package practicafinal.ipc1;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author luisGonzalez
 */
public class DlgPrimerEscenario extends javax.swing.JDialog {

    private JLabel[][] mapa;
    private int[][] tipoTerreno;
    private int[][] valores;
    private int[][] enemigos;
    private int x, y, numCelda;
    private int[][] ocupado;
    private static final int casillas = 4;
    private final ImageIcon cumbre = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/cumbre4.jpg");
    private final ImageIcon agua = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/mar.jpg");
    private final ImageIcon campoAbierto = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/campoAbierto.jpg");    
    private final ImageIcon tanque = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/Tanque.jpg");
    private final ImageIcon avion = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/Avion.jpg");
    private final ImageIcon bala1 = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/balaArriba.png");
    private final ImageIcon bala2 = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/balaAbajo.png");
    private final ImageIcon bala3 = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/balaDerecha.png");
    private final ImageIcon bala4 = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/balaIzquierda.png");
    private final ImageIcon torreta = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/torreta2.jpg");
    private final Border borde = LineBorder.createGrayLineBorder();
    private NuevoAvatar<NombreJugador> misAutos;
    public DefaultTableModel modelMapa1, modelMapa2;
    private NuevoEnemigo<Enemigo> enemigo = new NuevoEnemigo<>();
    private int contador = 0;
    
    public DlgPrimerEscenario(java.awt.Frame parent, boolean modal, NuevoAvatar<NombreJugador> misAutos, int numCelda) {
        super(parent, modal);
        initComponents();
        Icon cumbres = new ImageIcon(cumbre.getImage().getScaledInstance(segunda.getWidth(), segunda.getHeight(), Image.SCALE_DEFAULT));
        Icon mar = new ImageIcon(agua.getImage().getScaledInstance(tercera.getWidth(), tercera.getHeight(), Image.SCALE_DEFAULT));
        Icon campo = new ImageIcon(campoAbierto.getImage().getScaledInstance(primera.getWidth(), primera.getHeight(), Image.SCALE_DEFAULT)); 
        this.numCelda = numCelda;
        this.misAutos = misAutos;
        primera.setIcon(campo);
        segunda.setIcon(cumbres);
        tercera.setIcon(mar);
        setLocationRelativeTo(null);
        cargarEscenario(cumbres, mar, campo);
        cargarValores();
 
        
    }

    private void cargarEscenario(Icon cumbres, Icon mar, Icon campo){       
        this.mapa = new JLabel[casillas][casillas];
        this.tipoTerreno = new int[casillas][casillas];
        this.valores = new int[casillas][casillas];
        this.enemigos = new int[casillas][casillas];
        this.ocupado = new int[casillas][casillas];
        tableroJuego.setLayout(new GridLayout(casillas, casillas));
        for (x = 0; x < casillas; x++) {    //doble for para la creacion de la matriz de labels
            for (y = 0; y < casillas; y++) {
                valores[x][y] = 0;
                enemigos[x][y] = 0;
                ocupado[x][y] = 0;
                JLabel matriz = new JLabel();   //se inicializa el label unitario y se le dan caracteristicas iniciales
                matriz.setBounds(100*x,75*y,100,75);
                matriz.setOpaque(true);
                matriz.setBackground(Color.WHITE);
                matriz.setBorder(borde);
                mapa[x][y] = matriz;
                pintarMapa(x, y, mapa, tipoTerreno); 
                Icon autoTanque = new ImageIcon(tanque.getImage().getScaledInstance(mapa[x][y].getWidth(), mapa[x][y].getHeight(), Image.SCALE_DEFAULT));
                Icon autoAvion = new ImageIcon(avion.getImage().getScaledInstance(mapa[x][y].getWidth(), mapa[x][y].getHeight(), Image.SCALE_DEFAULT)); 
                Icon balaArriba = new ImageIcon(bala1.getImage().getScaledInstance(mapa[x][y].getWidth(), mapa[x][y].getHeight(), Image.SCALE_DEFAULT));
                Icon balaAbajo = new ImageIcon(bala2.getImage().getScaledInstance(mapa[x][y].getWidth(), mapa[x][y].getHeight(), Image.SCALE_DEFAULT));
                Icon balaIzquierda = new ImageIcon(bala3.getImage().getScaledInstance(mapa[x][y].getWidth(), mapa[x][y].getHeight(), Image.SCALE_DEFAULT));
                Icon balaDerecha = new ImageIcon(bala4.getImage().getScaledInstance(mapa[x][y].getWidth(), mapa[x][y].getHeight(), Image.SCALE_DEFAULT));                
                Icon torretaEnemigo = new ImageIcon(torreta.getImage().getScaledInstance(mapa[x][y].getWidth(), mapa[x][y].getHeight(), Image.SCALE_DEFAULT));
                //primerMovimiento(matriz, cumbres, mar, campo, autoTanque, autoAvion);
                mapa[x][y].addMouseListener(new java.awt.event.MouseAdapter(){
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent e){
                        contador++;
                        if(contador==1){
                            for(int posX=0; posX<x; posX++){
                                for(int posY=0; posY<y; posY++){
                                    if(matriz == mapa[posX][posY]){
                                        ocupado[posX][posY] = 1;
                                        DlgEnemigos enemigos2 = new DlgEnemigos(null, true, enemigo, mapa, torretaEnemigo, enemigos, posX, posY, ocupado);
                                        enemigos2.setVisible(true); 
                                        cargarEnemigos();           
                                        DlgCambioAuto auto = new DlgCambioAuto(null, true, misAutos, numCelda, mapa, posX, posY, autoTanque, autoAvion, cumbres, mar, campo, tipoTerreno, x, y, valores, numAuto);
                                        auto.setVisible(true);
                                    }
                                }
                            }
                        } else {
                            for(int posX=0; posX<x; posX++){
                                for(int posY=0; posY<y; posY++){
                                    if(matriz == mapa[posX][posY] && valores[posX][posY]==1){
                                        int i = posX;
                                        int j = posY;
                                        
                                        DlgOpcionesJugador camibo = new DlgOpcionesJugador(null, true, misAutos, numCelda, mapa, posX, posY, autoTanque, autoAvion, cumbres, mar, campo, tipoTerreno, x, y, valores, casillas, i, j, numAuto, balaArriba, balaAbajo, balaIzquierda, balaDerecha, enemigo, enemigos);
                                        camibo.setVisible(true);     
                                    } else if(matriz == mapa[posX][posY] && valores[posX][posY]==0 && enemigos[posX][posY]==0){
                                        JOptionPane.showMessageDialog(null, "No contiene un vehiculo en esta posicion");
                                    } else if(matriz==mapa[posX][posY] && valores[posX][posY]==0 && enemigos[posX][posY]!=0){
                                        JOptionPane.showMessageDialog(null, "has clickado a un enemigo"+enemigos[posX][posY]);          
                                    }                                   
                                }
                            }
                        }
                    }
                });                           
                tableroJuego.add(mapa[x][y]);    //por ultimo se dibuja el panel completo
                tableroJuego.validate();
                tableroJuego.repaint();                  
            }
        }     
    }
    
    private void pintarMapa(int x, int y, JLabel[][] mapa, int[][] respaldo){
        Icon primerFoto = new ImageIcon(cumbre.getImage().getScaledInstance(mapa[x][y].getWidth(), mapa[x][y].getHeight(), Image.SCALE_DEFAULT));
        Icon segundaFoto = new ImageIcon(agua.getImage().getScaledInstance(mapa[x][y].getWidth(), mapa[x][y].getHeight(), Image.SCALE_DEFAULT));
        Icon tercerFoto = new ImageIcon(campoAbierto.getImage().getScaledInstance(mapa[x][y].getWidth(), mapa[x][y].getHeight(), Image.SCALE_DEFAULT));
                int numAleatorio =(int)(Math.random()*3)+1;
                switch(numAleatorio){
                    case 1:
                        mapa[x][y].setIcon(primerFoto);
                        respaldo[x][y] = 1;
                        break;
                    case 2:
                        mapa[x][y].setIcon(segundaFoto);
                        respaldo[x][y] = 2;
                        break;
                    case 3:
                        mapa[x][y].setIcon(tercerFoto);
                        respaldo[x][y] = 3;
                        break;
        }
    }
    
    private void cargarValores(){
        try {
            Nodo<NombreJugador> elemento = misAutos.obtenerElemento(numCelda);
            NombreJugador tabla = elemento.obtenerContenido();
            modelMapa1 = (DefaultTableModel) tablaVehiculos.getModel();
            Object[] fila = new Object[modelMapa1.getColumnCount()];
            for(int i=0; i<tabla.getMiLista().obtenerCantidadElementos(); i++){
                try{
                    Nodo2<NombreAuto> elemento2 = tabla.getMiLista().obtenerElemento(i);
                    NombreAuto nombre = elemento2.obtenerContenido();
                    fila[0] = nombre.getNombre();
                    modelMapa1.addRow(fila);
                } catch (Exception ex){
                    Logger.getLogger(DlgListaAutos.class.getName()).log(Level.SEVERE, null, ex);    
                }}
        } catch (Exception ex){
            Logger.getLogger(DlgListaAutos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void cargarEnemigos(){
        modelMapa2 = (DefaultTableModel) tablaEnemigos.getModel();
        modelMapa2.fireTableDataChanged();
        Object[] fila = new Object[modelMapa2.getColumnCount()];
        for(int i=0; i<enemigo.obtenerCantidadElementos(); i++){
            try{
                Nodo3<Enemigo> elemento3 = enemigo.obtenerElemento(i);
                Enemigo nombre = elemento3.obtenerContenido();
                fila[0] = nombre.getNombre();
                modelMapa2.addRow(fila);
            } catch(Exception ex){
                Logger.getLogger(DlgListaAutos.class.getName()).log(Level.SEVERE, null, ex);    
            }
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tableroJuego = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVehiculos = new javax.swing.JTable();
        segunda = new javax.swing.JLabel();
        txtTitulo3 = new javax.swing.JLabel();
        txtTitulo2 = new javax.swing.JLabel();
        primera = new javax.swing.JLabel();
        txtTitulo1 = new javax.swing.JLabel();
        primerMov = new javax.swing.JPanel();
        numAuto = new javax.swing.JLabel();
        tercera = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaEnemigos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout tableroJuegoLayout = new javax.swing.GroupLayout(tableroJuego);
        tableroJuego.setLayout(tableroJuegoLayout);
        tableroJuegoLayout.setHorizontalGroup(
            tableroJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        tableroJuegoLayout.setVerticalGroup(
            tableroJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        getContentPane().add(tableroJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 340, 260));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 450, 30, 30));

        tablaVehiculos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaVehiculos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 130, 140));
        getContentPane().add(segunda, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 80, 60));

        txtTitulo3.setText("Mar de Atlantis");
        getContentPane().add(txtTitulo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 240, -1, -1));

        txtTitulo2.setText("Montañas de Idrazil");
        getContentPane().add(txtTitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 150, -1, -1));
        getContentPane().add(primera, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 80, 60));

        txtTitulo1.setText("Campo de las mil batallas");
        getContentPane().add(txtTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, -1, -1));

        javax.swing.GroupLayout primerMovLayout = new javax.swing.GroupLayout(primerMov);
        primerMov.setLayout(primerMovLayout);
        primerMovLayout.setHorizontalGroup(
            primerMovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(primerMovLayout.createSequentialGroup()
                .addGap(262, 262, 262)
                .addComponent(numAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        primerMovLayout.setVerticalGroup(
            primerMovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(primerMovLayout.createSequentialGroup()
                .addComponent(numAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(237, 237, 237))
        );

        getContentPane().add(primerMov, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, 120, 40));
        getContentPane().add(tercera, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, 80, 60));

        tablaEnemigos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Enemigos:"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaEnemigos);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, 140, 140));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cargarEnemigos();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel numAuto;
    private javax.swing.JPanel primerMov;
    private javax.swing.JLabel primera;
    private javax.swing.JLabel segunda;
    public javax.swing.JTable tablaEnemigos;
    public javax.swing.JTable tablaVehiculos;
    private javax.swing.JPanel tableroJuego;
    private javax.swing.JLabel tercera;
    private javax.swing.JLabel txtTitulo1;
    private javax.swing.JLabel txtTitulo2;
    private javax.swing.JLabel txtTitulo3;
    // End of variables declaration//GEN-END:variables
}
