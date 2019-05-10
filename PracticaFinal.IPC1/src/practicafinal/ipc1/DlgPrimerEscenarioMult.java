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
public class DlgPrimerEscenarioMult extends javax.swing.JDialog {
    
    private JLabel[][] mapa;
    private NuevoAvatar<NombreJugador> miLista;
    private int[][] tipoTerreno, valoresJugador1, valoresJugador2, ocupado1, ocupado2, enemigos;
    private DefaultTableModel modelMapa1, modelMapa2;
    private int numCelda, numCelda2, filas, columnas, x, y;
    private int contTurnos = 0;
    private final ImageIcon cumbre = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/cumbre4.jpg");
    private final ImageIcon agua = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/mar.jpg");
    private final ImageIcon campoAbierto = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/campoAbierto.jpg");    
    private final ImageIcon tanque = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/Tanque.jpg");
    private final ImageIcon avion = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/Avion.jpg");
    private final ImageIcon bala1 = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/balaArriba.png");
    private final ImageIcon bala2 = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/balaAbajo.png");
    private final ImageIcon bala3 = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/balaDerecha.png");
    private final Border borde = LineBorder.createGrayLineBorder();
    private final ImageIcon bala4 = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/balaIzquierda.png");
    private Nodo<NombreJugador> elemento;
    private NombreJugador lista;
    private Nodo2<NombreAuto> elemento2;
    private NombreAuto nombre;
    private String nombre1, nombre2;
    
    public DlgPrimerEscenarioMult(java.awt.Frame parent, boolean modal, NuevoAvatar<NombreJugador> miLista, int numCelda, int numCelda2, int filas, int columnas) {
        super(parent, modal);
        this.miLista = miLista;
        this.numCelda = numCelda;
        this.numCelda2 = numCelda2;
        this.filas = filas;
        this.columnas = columnas;
        initComponents();
        Icon cumbres = new ImageIcon(cumbre.getImage().getScaledInstance(segunda.getWidth(), segunda.getHeight(), Image.SCALE_DEFAULT));
        Icon mar = new ImageIcon(agua.getImage().getScaledInstance(tercera.getWidth(), tercera.getHeight(), Image.SCALE_DEFAULT));
        Icon campo = new ImageIcon(campoAbierto.getImage().getScaledInstance(primera.getWidth(), primera.getHeight(), Image.SCALE_DEFAULT)); 
        primera.setIcon(campo);
        segunda.setIcon(cumbres);
        tercera.setIcon(mar);
        setLocationRelativeTo(null);
        cargarEscenario(cumbres, mar, campo);
        cargarJugador1();
        cargarJugador2();
                
    }

    private void cargarEscenario(Icon cumbres, Icon mar, Icon campo){
        this.mapa = new JLabel[filas][columnas];
        this.tipoTerreno = new int[filas][columnas];
        this.valoresJugador1 = new int[filas][columnas];
        this.valoresJugador2 = new int[filas][columnas];
        this.ocupado1 = new int[filas][columnas];
        this.ocupado2 = new int[filas][columnas];
        this.enemigos = new int[filas][columnas];
        tableroJuego.setLayout(new GridLayout(filas, columnas));
        for (x = 0; x < filas; x++) {    //doble for para la creacion de la matriz de labels
            for (y = 0; y < columnas; y++) {
                valoresJugador1[x][y] = 0;
                valoresJugador2[x][y] = 0;
                enemigos[x][y] = 0;
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
                mapa[x][y].addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent e){
                        contTurnos++;
                        if(contTurnos==1){
                            turnoJugador.setText(nombre1);
                            for(int posX=0; posX<x; posX++){
                                for(int posY=0; posY<y; posY++){
                                    if(matriz==mapa[posX][posY]){
                                        DlgCambioAuto auto = new DlgCambioAuto(null, true, miLista, numCelda, mapa, posX, posY, autoTanque, autoAvion, cumbres, mar, campo, tipoTerreno, x, y, valoresJugador1, numAuto1, vidaAuto1, nivelAuto1, ataqueAuto1, elemento, lista, elemento2, nombre, ocupado1);
                                        auto.setVisible(true);
                                        
                                    }
                                }
                            }    
                        } else if(contTurnos==2){
                            turnoJugador.setText(nombre2);
                            for(int posX=0; posX<x; posX++){
                                for(int posY=0; posY<y; posY++){
                                    if(matriz==mapa[posX][posY]){
                                        DlgCambioAuto auto = new DlgCambioAuto(null, true, miLista, numCelda2, mapa, posX, posY, autoTanque, autoAvion, cumbres, mar, campo, tipoTerreno, x, y, valoresJugador2, numAuto2, vidaAuto2, nivelAuto2, ataqueAuto2, elemento, lista, elemento2, nombre, ocupado2);
                                        auto.setVisible(true);
                                        
                                    }
                                }
                            }
                        }
                        else if(contTurnos>2){    
                            if(contTurnos%2 != 0 && contTurnos != 1){
                                turnoJugador.setText(nombre1);
                                for(int posX=0; posX<x; posX++){
                                    for(int posY=0; posY<y; posY++){
                                        if(matriz==mapa[posX][posY] && valoresJugador1[posX][posY]==1 || valoresJugador1[posX][posY]==2){
                                            int i = posX;
                                            int j = posY;
                                            DlgOpcionesMultiJugador jugador1 = new DlgOpcionesMultiJugador(null, true, miLista, numCelda, mapa, posX, posY, autoTanque, autoAvion, cumbres, mar, campo, tipoTerreno, x, y, valoresJugador1, filas, columnas, i, j, numAuto1, balaArriba, balaAbajo, balaIzquierda, balaDerecha, enemigos, ocupado2, vidaAuto1, nivelAuto1, ataqueAuto1, elemento, lista, elemento2, nombre, modelMapa2, valoresJugador2, numCelda2, numAuto2, vidaAuto2);
                                            jugador1.setVisible(true);
                                        } else if (matriz==mapa[posX][posY] && ocupado1[posX][posY]==0 && ocupado2[posX][posY]==0){
                                            contTurnos = contTurnos-1; 
                                            JOptionPane.showMessageDialog(null, "no contiene un auto en esta posicion");                                    
                                        }else if (matriz==mapa[posX][posY] && ocupado1[posX][posY]==0 && ocupado2[posX][posY]!=0){
                                            contTurnos = contTurnos-1; 
                                            JOptionPane.showMessageDialog(null, "no contiene un auto en esta posicion pero te has topado con el auto del jugador 2");                                    
                                        }
                                    }
                                }
                            } else if (contTurnos%2 == 0 && contTurnos !=2){
                                turnoJugador.setText(nombre2);
                                for(int posX=0; posX<x; posX++){
                                    for(int posY=0; posY<y; posY++){
                                        if(matriz==mapa[posX][posY] && valoresJugador2[posX][posY]==1 || valoresJugador2[posX][posY]==2){
                                            int i = posX;
                                            int j = posY;
                                            DlgOpcionesMultiJugador jugador2 = new DlgOpcionesMultiJugador(null, true, miLista, numCelda2, mapa, posX, posY, autoTanque, autoAvion, cumbres, mar, campo, tipoTerreno, x, y, valoresJugador2, filas, columnas, i, j, numAuto2, balaArriba, balaAbajo, balaIzquierda, balaDerecha, enemigos, ocupado1, vidaAuto2, nivelAuto2, ataqueAuto2, elemento, lista, elemento2, nombre, modelMapa2, valoresJugador1, numCelda, numAuto1, vidaAuto1);
                                            jugador2.setVisible(true);
                                        } else if (matriz==mapa[posX][posY] && ocupado2[posX][posY]==0 && ocupado1[posX][posY]==0){
                                            contTurnos = contTurnos-1;
                                            JOptionPane.showMessageDialog(null, "no contiene un auto en esta posicion");
                                        } else if (matriz==mapa[posX][posY] && ocupado2[posX][posY]==0 && ocupado1[posX][posY]!=0){
                                            contTurnos = contTurnos-1; 
                                            JOptionPane.showMessageDialog(null, "no contiene un auto en esta posicion pero te has topado con el auto del jugador 1");                                    
                                        }
                                    }
                            
                                }      
                        
                            } if(Double.parseDouble(vidaAuto1.getText())<=0 ){
                                JOptionPane.showMessageDialog(null, "Jugador 1 ha sido derrotado");
                                dispose();
                            }else if(Double.parseDouble(vidaAuto2.getText())<=0 ){
                                JOptionPane.showMessageDialog(null, "Jugador 2 ha sido derrotado");
                                dispose();
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
    
    private void cargarJugador1(){
        try {
            Nodo<NombreJugador> elemento = miLista.obtenerElemento(numCelda);
            NombreJugador tabla = elemento.obtenerContenido();
            nombre1 = tabla.getNombre();
            modelMapa1 = (DefaultTableModel) tablaJugador1.getModel();
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
    
    private void cargarJugador2(){
        try {
            Nodo<NombreJugador> elemento = miLista.obtenerElemento(numCelda2);
            NombreJugador tabla = elemento.obtenerContenido();
            nombre2 = tabla.getNombre();
            modelMapa2 = (DefaultTableModel) tablaJugador2.getModel();
            Object[] fila = new Object[modelMapa2.getColumnCount()];
            for(int i=0; i<tabla.getMiLista().obtenerCantidadElementos(); i++){
                try{
                    Nodo2<NombreAuto> elemento2 = tabla.getMiLista().obtenerElemento(i);
                    NombreAuto nombre = elemento2.obtenerContenido();
                    fila[0] = nombre.getNombre();
                    modelMapa2.addRow(fila);
                } catch (Exception ex){
                    Logger.getLogger(DlgListaAutos.class.getName()).log(Level.SEVERE, null, ex);    
                }}
        } catch (Exception ex){
            Logger.getLogger(DlgListaAutos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tableroJuego = new javax.swing.JPanel();
        primera = new javax.swing.JLabel();
        segunda = new javax.swing.JLabel();
        tercera = new javax.swing.JLabel();
        txtTitulo1 = new javax.swing.JLabel();
        txtTitulo2 = new javax.swing.JLabel();
        txtTitulo3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaJugador1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaJugador2 = new javax.swing.JTable();
        panelJugador1 = new javax.swing.JPanel();
        numAuto1 = new javax.swing.JLabel();
        vidaAuto1 = new javax.swing.JLabel();
        nivelAuto1 = new javax.swing.JLabel();
        ataqueAuto1 = new javax.swing.JLabel();
        panelJugador2 = new javax.swing.JPanel();
        numAuto2 = new javax.swing.JLabel();
        vidaAuto2 = new javax.swing.JLabel();
        nivelAuto2 = new javax.swing.JLabel();
        ataqueAuto2 = new javax.swing.JLabel();
        txt = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txt3 = new javax.swing.JLabel();
        turnoJugador = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout tableroJuegoLayout = new javax.swing.GroupLayout(tableroJuego);
        tableroJuego.setLayout(tableroJuegoLayout);
        tableroJuegoLayout.setHorizontalGroup(
            tableroJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );
        tableroJuegoLayout.setVerticalGroup(
            tableroJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );

        getContentPane().add(tableroJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 470, 320));
        getContentPane().add(primera, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, 80, 60));
        getContentPane().add(segunda, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 140, 80, 60));
        getContentPane().add(tercera, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, 80, 60));

        txtTitulo1.setText("Campo de las mil batallas");
        getContentPane().add(txtTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, -1, -1));

        txtTitulo2.setText("Montañas de Idrazil");
        getContentPane().add(txtTitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 160, -1, -1));

        txtTitulo3.setText("Mar de Atlantis");
        getContentPane().add(txtTitulo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 250, -1, -1));

        tablaJugador1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Autos Jugador 1:"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaJugador1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 150, 160));

        tablaJugador2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Autos Jugador 2:"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaJugador2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, 150, 160));

        javax.swing.GroupLayout panelJugador1Layout = new javax.swing.GroupLayout(panelJugador1);
        panelJugador1.setLayout(panelJugador1Layout);
        panelJugador1Layout.setHorizontalGroup(
            panelJugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJugador1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelJugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(numAuto1, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(vidaAuto1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nivelAuto1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ataqueAuto1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(119, Short.MAX_VALUE))
        );
        panelJugador1Layout.setVerticalGroup(
            panelJugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJugador1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(numAuto1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vidaAuto1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nivelAuto1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ataqueAuto1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        getContentPane().add(panelJugador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 360, 170, 160));

        javax.swing.GroupLayout panelJugador2Layout = new javax.swing.GroupLayout(panelJugador2);
        panelJugador2.setLayout(panelJugador2Layout);
        panelJugador2Layout.setHorizontalGroup(
            panelJugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJugador2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelJugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nivelAuto2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(numAuto2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vidaAuto2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ataqueAuto2, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        panelJugador2Layout.setVerticalGroup(
            panelJugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJugador2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(numAuto2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vidaAuto2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nivelAuto2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ataqueAuto2, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(panelJugador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 360, 180, 160));
        getContentPane().add(txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 580, 40, 10));

        txt3.setText("Es el turno de :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(turnoJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt3)
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addComponent(turnoJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 530, 350, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ataqueAuto1;
    private javax.swing.JLabel ataqueAuto2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nivelAuto1;
    private javax.swing.JLabel nivelAuto2;
    private javax.swing.JLabel numAuto1;
    private javax.swing.JLabel numAuto2;
    private javax.swing.JPanel panelJugador1;
    private javax.swing.JPanel panelJugador2;
    private javax.swing.JLabel primera;
    private javax.swing.JLabel segunda;
    public javax.swing.JTable tablaJugador1;
    public javax.swing.JTable tablaJugador2;
    private javax.swing.JPanel tableroJuego;
    private javax.swing.JLabel tercera;
    private javax.swing.JLabel turnoJugador;
    private javax.swing.JLabel txt;
    private javax.swing.JLabel txt3;
    private javax.swing.JLabel txtTitulo1;
    private javax.swing.JLabel txtTitulo2;
    private javax.swing.JLabel txtTitulo3;
    private javax.swing.JLabel vidaAuto1;
    private javax.swing.JLabel vidaAuto2;
    // End of variables declaration//GEN-END:variables
}
