package practicafinal.ipc1;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.Timer;
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
public class DlgSegundoEscenario extends javax.swing.JDialog {

    private JLabel[][] mapa;
    private int[][] tipoTerreno, valores, enemigos, cajasComodin;
    private int x, y, numCelda;
    private int[][] ocupado, bots;
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
    private final ImageIcon botito = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/bot.jpg");
    private final Border borde = LineBorder.createGrayLineBorder();
    private NuevoAvatar<NombreJugador> misAutos;
    public DefaultTableModel modelMapa1, modelMapa2;
    private NuevoEnemigo<Enemigo> enemigo = new NuevoEnemigo<>();
    private int contador = 0;
    private double[] vida;
    private int[] posBotX = new int[10];
    private int[] posBotY = new int[10];
    DlgEnemigos enemigos2;
    private int contadorTurnos=0;
    private Nodo<NombreJugador> elemento;
    private NombreJugador lista;
    private Nodo2<NombreAuto> elemento2;
    private NombreAuto nombre;
    private static final int filas = 4;
    private static final int columnas = 6;
    
    public DlgSegundoEscenario(java.awt.Frame parent, boolean modal, NuevoAvatar<NombreJugador> misAutos, int numCelda) {
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
        cargarEscenario(cumbres, mar, campo);
        cargarValores();
    }
    
    private void cargarEscenario(Icon cumbres, Icon mar, Icon campo){       
        this.mapa = new JLabel[filas][columnas];
        this.tipoTerreno = new int[filas][columnas];
        this.valores = new int[filas][columnas];
        this.enemigos = new int[filas][columnas];
        this.ocupado = new int[filas][columnas];
        this.bots = new int[filas][columnas];
        tableroJuego.setLayout(new GridLayout(filas, columnas));
        for (x = 0; x < filas; x++) {    //doble for para la creacion de la matriz de labels
            for (y = 0; y < columnas; y++) {
                valores[x][y] = 0;
                enemigos[x][y] = 0;
                ocupado[x][y] = 0;   
                bots[x][y] = 0;
                JLabel matriz = new JLabel();   //se inicializa el label unitario y se le dan caracteristicas iniciales
                matriz.setBounds(100*x,75*y,100,75);
                matriz.setOpaque(true);
                matriz.setBackground(Color.WHITE);
                matriz.setBorder(borde);
                mapa[x][y] = matriz;
                pintarMapa(x, y, mapa, tipoTerreno); 
                modelMapa2 = (DefaultTableModel) tablaEnemigos.getModel();
                modelMapa2.fireTableDataChanged();
                Object[] fila = new Object[modelMapa2.getColumnCount()];
                Icon autoTanque = new ImageIcon(tanque.getImage().getScaledInstance(mapa[x][y].getWidth(), mapa[x][y].getHeight(), Image.SCALE_DEFAULT));
                Icon autoAvion = new ImageIcon(avion.getImage().getScaledInstance(mapa[x][y].getWidth(), mapa[x][y].getHeight(), Image.SCALE_DEFAULT)); 
                Icon balaArriba = new ImageIcon(bala1.getImage().getScaledInstance(mapa[x][y].getWidth(), mapa[x][y].getHeight(), Image.SCALE_DEFAULT));
                Icon balaAbajo = new ImageIcon(bala2.getImage().getScaledInstance(mapa[x][y].getWidth(), mapa[x][y].getHeight(), Image.SCALE_DEFAULT));
                Icon balaIzquierda = new ImageIcon(bala3.getImage().getScaledInstance(mapa[x][y].getWidth(), mapa[x][y].getHeight(), Image.SCALE_DEFAULT));
                Icon balaDerecha = new ImageIcon(bala4.getImage().getScaledInstance(mapa[x][y].getWidth(), mapa[x][y].getHeight(), Image.SCALE_DEFAULT));                
                Icon torretaEnemigo = new ImageIcon(torreta.getImage().getScaledInstance(mapa[x][y].getWidth(), mapa[x][y].getHeight(), Image.SCALE_DEFAULT));
                Icon bot = new ImageIcon(botito.getImage().getScaledInstance(mapa[x][y].getWidth(), mapa[x][y].getHeight(), Image.SCALE_DEFAULT));
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
                                        enemigos2 = new DlgEnemigos(null, true, enemigo, mapa, torretaEnemigo, enemigos, posX, posY, ocupado, vida, panelEnemigos, enemigo1, enemigo2, enemigo3, enemigo4);
                                        enemigos2.setVisible(true); 
                                        cargarEnemigos(fila);           
                                        DlgCambioAuto auto = new DlgCambioAuto(null, true, misAutos, numCelda, mapa, posX, posY, autoTanque, autoAvion, cumbres, mar, campo, tipoTerreno, x, y, valores, numAuto, vidaAuto, nivelAuto, ataqueAuto, elemento, lista, elemento2, nombre, ocupado);
                                        auto.setVisible(true);
                                        
                                    }
                                }
                            }
                        } else {
                            for(int posX=0; posX<x; posX++){
                                for(int posY=0; posY<y; posY++){
                                    if(matriz == mapa[posX][posY] && valores[posX][posY]==1 || valores[posX][posY]==2){
                                        int i = posX;
                                        int j = posY;
                                        contadorTurnos++;
                                        
                                        contTurnos.setText(Integer.toString(contadorTurnos));
                                  //      DlgOpcionesJugador camibo = new DlgOpcionesJugador(null, true, misAutos, numCelda, mapa, posX, posY, autoTanque, autoAvion, cumbres, mar, campo, tipoTerreno, x, y, valores, filas, columnas, i, j, numAuto, balaArriba, balaAbajo, balaIzquierda, balaDerecha, enemigo, enemigos, ocupado, torretaEnemigo, fila, modelMapa2, vida, panelEnemigos, enemigo1, enemigo2, enemigo3, enemigo4, vidaAuto, nivelAuto, ataqueAuto, elemento, lista, elemento2, nombre, cajasComodin);
                                    //    camibo.setVisible(true);
                                       // disparoEnemigos(balaAbajo, balaArriba, balaIzquierda, balaDerecha, autoTanque, autoAvion, cumbres, mar, campo, torretaEnemigo);
                                    } else if(matriz == mapa[posX][posY] && valores[posX][posY]==0 && enemigos[posX][posY]==0){
                                        contadorTurnos++;
                                        contTurnos.setText(Integer.toString(contadorTurnos));
                                        DlgPosBots qwe = new DlgPosBots(null, true, numCelda, misAutos, mapa, posX, posY, bots, bot, contadorTurnos, posBotX, posBotY);
                                        DlgPreguntaBot pregunta = new DlgPreguntaBot(null, true, numCelda, posX, posY, misAutos, mapa, bots, bot, contadorTurnos, posBotX, posBotY, qwe);
                                        pregunta.setVisible(true);
                                        JOptionPane.showMessageDialog(null, posBotX[0]+" "+posBotY[0]);
                                        //disparoEnemigos(balaAbajo, balaArriba, balaIzquierda, balaDerecha, autoTanque, autoAvion, cumbres, mar, campo, torretaEnemigo);
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
    
    private void cargarEnemigos(Object[] fila){
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
    
    private void cargarValores(){
        try {
            Nodo<NombreJugador> elemento = misAutos.obtenerElemento(numCelda);
            NombreJugador tabla = elemento.obtenerContenido();
            modelMapa2 = (DefaultTableModel) tablaVehiculos2.getModel();
            Object[] fila = new Object[modelMapa2.getColumnCount()];
            for(int i=0; i<tabla.getMiLista().obtenerCantidadElementos(); i++){
                try{
                    Nodo2<NombreAuto> elemento2 = tabla.getMiLista().obtenerElemento(i);
                    NombreAuto nombre = elemento2.obtenerContenido();
                    fila[0] = nombre.getNombre();
                    modelMapa2.addRow(fila);
                } catch (Exception ex){
                    Logger.getLogger(DlgListaAutos.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        } catch (Exception ex){
            Logger.getLogger(DlgListaAutos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*private void disparoEnemigos(Icon balaAbajo, Icon balaArriba, Icon balaIzquierda, Icon balaDerecha, Icon autoTanque, Icon autoAvion, Icon cumbres, Icon mar, Icon campo, Icon torretaEnemigo){
        Timer timer = new Timer();
        int aleatorio = (int)(Math.random()*2)+1;
        int aleatorio2 = (int)(Math.random()*2)+1;
        int aleatorio3 = (int)(Math.random()*2)+1;
        int aleatorio4 = (int)(Math.random()*2)+1;
        DisparoEnemAbajo abajo = new DisparoEnemAbajo();
        DisparoEnemAbajo abajo2 = new DisparoEnemAbajo();
        DisparoEnemAbajo abajo3 = new DisparoEnemAbajo();
        DisparoEnemAbajo abajo4 = new DisparoEnemAbajo();      
        DisparoEnemArriba arriba = new DisparoEnemArriba();
        DisparoEnemArriba arriba2 = new DisparoEnemArriba();
        DisparoEnemArriba arriba3 = new DisparoEnemArriba();
        DisparoEnemArriba arriba4 = new DisparoEnemArriba();
        DisparoEnemDerecha derecha = new DisparoEnemDerecha();
        DisparoEnemDerecha derecha2 = new DisparoEnemDerecha();
        DisparoEnemDerecha derecha3 = new DisparoEnemDerecha();
        DisparoEnemDerecha derecha4 = new DisparoEnemDerecha();
        DisparoEnemIzquierda izquierda = new DisparoEnemIzquierda();
        DisparoEnemIzquierda izquierda2 = new DisparoEnemIzquierda();
        DisparoEnemIzquierda izquierda3 = new DisparoEnemIzquierda();
        DisparoEnemIzquierda izquierda4 = new DisparoEnemIzquierda();
        MovArriba2 limpiarArriba = new MovArriba2();
        MovArriba2 limpiarArriba2 = new MovArriba2();
        MovArriba2 limpiarArriba3 = new MovArriba2();
        MovArriba2 limpiarArriba4 = new MovArriba2();     
        MovAbajo2 limpiarAbajo = new MovAbajo2();
        MovAbajo2 limpiarAbajo2 = new MovAbajo2();
        MovAbajo2 limpiarAbajo3 = new MovAbajo2();
        MovAbajo2 limpiarAbajo4 = new MovAbajo2();   
        MovDerecha2 limpiarDerecha = new MovDerecha2();
        MovDerecha2 limpiarDerecha2 = new MovDerecha2();
        MovDerecha2 limpiarDerecha3 = new MovDerecha2();
        MovDerecha2 limpiarDerecha4 = new MovDerecha2();    
        MovIzquierda2 limpiarIzquierda = new MovIzquierda2();
        MovIzquierda2 limpiarIzquierda2 = new MovIzquierda2();
        MovIzquierda2 limpiarIzquierda3 = new MovIzquierda2();
        MovIzquierda2 limpiarIzquierda4 = new MovIzquierda2();
        
        switch (enemigos2.getCantidad()) {
            case 0:
            
                if(aleatorio==1){
                    abajo.valores(enemigos2.getGuardarX()[0]+1, enemigos2.getGuardarY()[0], filas, balaAbajo, autoTanque, autoAvion, mapa, valores, vidaAuto, misAutos, numCelda, numAuto, elemento, lista, elemento2, nombre);
                    arriba.valores(enemigos2.getGuardarX()[0]-1, enemigos2.getGuardarY()[0], mapa, balaArriba, autoTanque, autoAvion, valores, vidaAuto, elemento, lista, elemento2, nombre, misAutos, numAuto, numCelda);
                    limpiarArriba.valores(enemigos2.getGuardarX()[0]-1, enemigos2.getGuardarY()[0], 0, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torretaEnemigo, autoTanque, autoAvion, valores, torreta);
                    limpiarAbajo.valores(enemigos2.getGuardarX()[0]+1, enemigos2.getGuardarY()[0], filas, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torretaEnemigo, autoTanque, autoAvion, valores, torreta);
                    timer.schedule(abajo, 0, 1000);
                    timer.schedule(arriba, 0, 1000);
                    timer.schedule(limpiarAbajo, 1000, 1000);
                    timer.schedule(limpiarArriba, 1000, 1000);                  
                } else if(aleatorio==2){
                    derecha.valores(enemigos2.getGuardarX()[0], enemigos2.getGuardarY()[0]+1, columnas, balaDerecha, autoTanque, autoAvion, mapa, valores, vidaAuto, elemento, lista, elemento2, nombre, misAutos, numAuto, numCelda);
                    izquierda.valores(enemigos2.getGuardarX()[0], enemigos2.getGuardarY()[0]-1, mapa, balaIzquierda, autoTanque, autoAvion, valores, vidaAuto, elemento, lista, elemento2, nombre, misAutos, numAuto, numCelda);
                    limpiarIzquierda.valores(enemigos2.getGuardarX()[0], enemigos2.getGuardarY()[0]-1, 0, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torretaEnemigo, autoTanque, autoAvion, valores, torreta);
                    limpiarDerecha.valores(enemigos2.getGuardarX()[0], enemigos2.getGuardarY()[0]+1, columnas, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torretaEnemigo, autoTanque, autoAvion, valores, torreta);
                    timer.schedule(izquierda, 0, 1000);
                    timer.schedule(derecha, 0, 1000);
                    timer.schedule(limpiarIzquierda, 1000, 1000);
                    timer.schedule(limpiarDerecha, 1000, 1000);                   
                }
                break;
            case 1:
                
                if(aleatorio==1){
                    abajo.valores(enemigos2.getGuardarX()[0]+1, enemigos2.getGuardarY()[0], filas, balaAbajo, autoTanque, autoAvion, mapa, valores, vidaAuto, misAutos, numCelda, numAuto, elemento, lista, elemento2, nombre);
                    arriba.valores(enemigos2.getGuardarX()[0]-1, enemigos2.getGuardarY()[0], mapa, balaArriba, autoTanque, autoAvion, valores, vidaAuto, elemento, lista, elemento2, nombre, misAutos, numAuto, numCelda);
                    limpiarArriba.valores(enemigos2.getGuardarX()[0]-1, enemigos2.getGuardarY()[0], 0, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torretaEnemigo, autoTanque, autoAvion, valores, torreta);
                    limpiarAbajo.valores(enemigos2.getGuardarX()[0]+1, enemigos2.getGuardarY()[0], filas, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torretaEnemigo, autoTanque, autoAvion, valores, torreta);
                    timer.schedule(abajo, 0, 1000);
                    timer.schedule(arriba, 0, 1000);
                    timer.schedule(limpiarAbajo, 1000, 1000);
                    timer.schedule(limpiarArriba, 1000, 1000);                  
                } else if(aleatorio==2){
                    derecha.valores(enemigos2.getGuardarX()[0], enemigos2.getGuardarY()[0]+1, columnas, balaDerecha, autoTanque, autoAvion, mapa, valores, vidaAuto, elemento, lista, elemento2, nombre, misAutos, numAuto, numCelda);
                    izquierda.valores(enemigos2.getGuardarX()[0], enemigos2.getGuardarY()[0]-1, mapa, balaIzquierda, autoTanque, autoAvion, valores, vidaAuto, elemento, lista, elemento2, nombre, misAutos, numAuto, numCelda);
                    limpiarIzquierda.valores(enemigos2.getGuardarX()[0], enemigos2.getGuardarY()[0]-1, 0, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torretaEnemigo, autoTanque, autoAvion, valores, torreta);
                    limpiarDerecha.valores(enemigos2.getGuardarX()[0], enemigos2.getGuardarY()[0]+1, columnas, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torretaEnemigo, autoTanque, autoAvion, valores, torreta);
                    timer.schedule(izquierda, 0, 1000);
                    timer.schedule(derecha, 0, 1000);
                    timer.schedule(limpiarIzquierda, 1000, 1000);
                    timer.schedule(limpiarDerecha, 1000, 1000);                   
                }
                if(aleatorio2==1){
                    abajo2.valores(enemigos2.getGuardarX()[1]+1, enemigos2.getGuardarY()[1], filas, balaAbajo, autoTanque, autoAvion, mapa, valores, vidaAuto, misAutos, numCelda, numAuto, elemento, lista, elemento2, nombre);
                    arriba2.valores(enemigos2.getGuardarX()[1]-1, enemigos2.getGuardarY()[1], mapa, balaArriba, autoTanque, autoAvion, valores, vidaAuto, elemento, lista, elemento2, nombre, misAutos, numAuto, numCelda);
                    limpiarArriba2.valores(enemigos2.getGuardarX()[1]-1, enemigos2.getGuardarY()[1], 0, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torretaEnemigo, autoTanque, autoAvion, valores, torreta);
                    limpiarAbajo2.valores(enemigos2.getGuardarX()[1]+1, enemigos2.getGuardarY()[1], filas, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torretaEnemigo, autoTanque, autoAvion, valores, torreta);
                    timer.schedule(abajo2, 0, 1000);
                    timer.schedule(arriba2, 0, 1000);
                    timer.schedule(limpiarAbajo2, 1000, 1000);
                    timer.schedule(limpiarArriba2, 1000, 1000);                  
                } else if(aleatorio2==2){
                    derecha2.valores(enemigos2.getGuardarX()[1], enemigos2.getGuardarY()[1]+1, columnas, balaDerecha, autoTanque, autoAvion, mapa, valores, vidaAuto, elemento, lista, elemento2, nombre, misAutos, numAuto, numCelda);
                    izquierda2.valores(enemigos2.getGuardarX()[1], enemigos2.getGuardarY()[1]-1, mapa, balaIzquierda, autoTanque, autoAvion, valores, vidaAuto, elemento, lista, elemento2, nombre, misAutos, numAuto, numCelda);
                    limpiarIzquierda2.valores(enemigos2.getGuardarX()[1], enemigos2.getGuardarY()[1]-1, 0, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torretaEnemigo, autoTanque, autoAvion, valores, torreta);
                    limpiarDerecha2.valores(enemigos2.getGuardarX()[1], enemigos2.getGuardarY()[1]+1, columnas, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torretaEnemigo, autoTanque, autoAvion, valores, torreta);
                    timer.schedule(izquierda2, 0, 1000);
                    timer.schedule(derecha2, 0, 1000);
                    timer.schedule(limpiarIzquierda2, 1000, 1000);
                    timer.schedule(limpiarDerecha2, 1000, 1000);                   
                }
                break;
            case 2:
               
                if(aleatorio==1){
                    abajo.valores(enemigos2.getGuardarX()[0]+1, enemigos2.getGuardarY()[0], filas, balaAbajo, autoTanque, autoAvion, mapa, valores, vidaAuto, misAutos, numCelda, numAuto, elemento, lista, elemento2, nombre);
                    arriba.valores(enemigos2.getGuardarX()[0]-1, enemigos2.getGuardarY()[0], mapa, balaArriba, autoTanque, autoAvion, valores, vidaAuto, elemento, lista, elemento2, nombre, misAutos, numAuto, numCelda);
                    limpiarArriba.valores(enemigos2.getGuardarX()[0]-1, enemigos2.getGuardarY()[0], 0, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torretaEnemigo, autoTanque, autoAvion, valores, torreta);
                    limpiarAbajo.valores(enemigos2.getGuardarX()[0]+1, enemigos2.getGuardarY()[0], filas, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torretaEnemigo, autoTanque, autoAvion, valores, torreta);
                    timer.schedule(abajo, 0, 1000);
                    timer.schedule(arriba, 0, 1000);
                    timer.schedule(limpiarAbajo, 1000, 1000);
                    timer.schedule(limpiarArriba, 1000, 1000);                  
                } else if(aleatorio==2){
                    derecha.valores(enemigos2.getGuardarX()[0], enemigos2.getGuardarY()[0]+1, columnas, balaDerecha, autoTanque, autoAvion, mapa, valores, vidaAuto, elemento, lista, elemento2, nombre, misAutos, numAuto, numCelda);
                    izquierda.valores(enemigos2.getGuardarX()[0], enemigos2.getGuardarY()[0]-1, mapa, balaIzquierda, autoTanque, autoAvion, valores, vidaAuto, elemento, lista, elemento2, nombre, misAutos, numAuto, numCelda);
                    limpiarIzquierda.valores(enemigos2.getGuardarX()[0], enemigos2.getGuardarY()[0]-1, 0, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torretaEnemigo, autoTanque, autoAvion, valores, torreta);
                    limpiarDerecha.valores(enemigos2.getGuardarX()[0], enemigos2.getGuardarY()[0]+1, columnas, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torretaEnemigo, autoTanque, autoAvion, valores, torreta);
                    timer.schedule(izquierda, 0, 1000);
                    timer.schedule(derecha, 0, 1000);
                    timer.schedule(limpiarIzquierda, 1000, 1000);
                    timer.schedule(limpiarDerecha, 1000, 1000);                   
                }
                if(aleatorio2==1){
                    abajo2.valores(enemigos2.getGuardarX()[1]+1, enemigos2.getGuardarY()[1], filas, balaAbajo, autoTanque, autoAvion, mapa, valores, vidaAuto, misAutos, numCelda, numAuto, elemento, lista, elemento2, nombre);
                    arriba2.valores(enemigos2.getGuardarX()[1]-1, enemigos2.getGuardarY()[1], mapa, balaArriba, autoTanque, autoAvion, valores, vidaAuto, elemento, lista, elemento2, nombre, misAutos, numAuto, numCelda);
                    limpiarArriba2.valores(enemigos2.getGuardarX()[1]-1, enemigos2.getGuardarY()[1], 0, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torretaEnemigo, autoTanque, autoAvion, valores, torreta);
                    limpiarAbajo2.valores(enemigos2.getGuardarX()[1]+1, enemigos2.getGuardarY()[1], filas, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torretaEnemigo, autoTanque, autoAvion, valores, torreta);
                    timer.schedule(abajo2, 0, 1000);
                    timer.schedule(arriba2, 0, 1000);
                    timer.schedule(limpiarAbajo2, 1000, 1000);
                    timer.schedule(limpiarArriba2, 1000, 1000);                  
                } else if(aleatorio2==2){
                    derecha2.valores(enemigos2.getGuardarX()[1], enemigos2.getGuardarY()[1]+1, columnas, balaDerecha, autoTanque, autoAvion, mapa, valores, vidaAuto, elemento, lista, elemento2, nombre, misAutos, numAuto, numCelda);
                    izquierda2.valores(enemigos2.getGuardarX()[1], enemigos2.getGuardarY()[1]-1, mapa, balaIzquierda, autoTanque, autoAvion, valores, vidaAuto, elemento, lista, elemento2, nombre, misAutos, numAuto, numCelda);
                    limpiarIzquierda2.valores(enemigos2.getGuardarX()[1], enemigos2.getGuardarY()[1]-1, 0, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torretaEnemigo, autoTanque, autoAvion, valores, torreta);
                    limpiarDerecha2.valores(enemigos2.getGuardarX()[1], enemigos2.getGuardarY()[1]+1, columnas, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torretaEnemigo, autoTanque, autoAvion, valores, torreta);
                    timer.schedule(izquierda2, 0, 1000);
                    timer.schedule(derecha2, 0, 1000);
                    timer.schedule(limpiarIzquierda2, 1000, 1000);
                    timer.schedule(limpiarDerecha2, 1000, 1000);                   
                }
                if(aleatorio3==1){
                    abajo3.valores(enemigos2.getGuardarX()[2]+1, enemigos2.getGuardarY()[2], filas, balaAbajo, autoTanque, autoAvion, mapa, valores, vidaAuto, misAutos, numCelda, numAuto, elemento, lista, elemento2, nombre);
                    arriba3.valores(enemigos2.getGuardarX()[2]-1, enemigos2.getGuardarY()[2], mapa, balaArriba, autoTanque, autoAvion, valores, vidaAuto, elemento, lista, elemento2, nombre, misAutos, numAuto, numCelda);
                    limpiarArriba3.valores(enemigos2.getGuardarX()[2]-1, enemigos2.getGuardarY()[2], 0, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torretaEnemigo, autoTanque, autoAvion, valores, torreta);
                    limpiarAbajo3.valores(enemigos2.getGuardarX()[2]+1, enemigos2.getGuardarY()[2], filas, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torretaEnemigo, autoTanque, autoAvion, valores, torreta);
                    timer.schedule(abajo3, 0, 1000);
                    timer.schedule(arriba3, 0, 1000);
                    timer.schedule(limpiarAbajo3, 1000, 1000);
                    timer.schedule(limpiarArriba3, 1000, 1000);                  
                } else if(aleatorio3==2){
                    derecha3.valores(enemigos2.getGuardarX()[2], enemigos2.getGuardarY()[2]+1, columnas, balaDerecha, autoTanque, autoAvion, mapa, valores, vidaAuto, elemento, lista, elemento2, nombre, misAutos, numAuto, numCelda);
                    izquierda3.valores(enemigos2.getGuardarX()[2], enemigos2.getGuardarY()[2]-1, mapa, balaIzquierda, autoTanque, autoAvion, valores, vidaAuto, elemento, lista, elemento2, nombre, misAutos, numAuto, numCelda);
                    limpiarIzquierda3.valores(enemigos2.getGuardarX()[2], enemigos2.getGuardarY()[2]-1, 0, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torretaEnemigo, autoTanque, autoAvion, valores, torreta);
                    limpiarDerecha3.valores(enemigos2.getGuardarX()[2], enemigos2.getGuardarY()[2]+1, columnas, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torretaEnemigo, autoTanque, autoAvion, valores, torreta);
                    timer.schedule(izquierda3, 0, 1000);
                    timer.schedule(derecha3, 0, 1000);
                    timer.schedule(limpiarIzquierda3, 1000, 1000);
                    timer.schedule(limpiarDerecha3, 1000, 1000);                   
                }
                break;
            case 3:  
                if(aleatorio==1){                
                    abajo.valores(enemigos2.getGuardarX()[0]+1, enemigos2.getGuardarY()[0], filas, balaAbajo, autoTanque, autoAvion, mapa, valores, vidaAuto, misAutos, numCelda, numAuto, elemento, lista, elemento2, nombre);
                    arriba.valores(enemigos2.getGuardarX()[0]-1, enemigos2.getGuardarY()[0], mapa, balaArriba, autoTanque, autoAvion, valores, vidaAuto, elemento, lista, elemento2, nombre, misAutos, numAuto, numCelda);
                    limpiarArriba.valores(enemigos2.getGuardarX()[0]-1, enemigos2.getGuardarY()[0], 0, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torretaEnemigo, autoTanque, autoAvion, valores, torreta);
                    limpiarAbajo.valores(enemigos2.getGuardarX()[0]+1, enemigos2.getGuardarY()[0], filas, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torretaEnemigo, autoTanque, autoAvion, valores, torreta);
                    timer.schedule(abajo, 0, 1000);
                    timer.schedule(arriba, 0, 1000);
                    timer.schedule(limpiarAbajo, 1000, 1000);
                    timer.schedule(limpiarArriba, 1000, 1000);                  
                } else if(aleatorio==2){                
                    derecha.valores(enemigos2.getGuardarX()[0], enemigos2.getGuardarY()[0]+1, columnas, balaDerecha, autoTanque, autoAvion, mapa, valores, vidaAuto, elemento, lista, elemento2, nombre, misAutos, numAuto, numCelda);
                    izquierda.valores(enemigos2.getGuardarX()[0], enemigos2.getGuardarY()[0]-1, mapa, balaIzquierda, autoTanque, autoAvion, valores, vidaAuto, elemento, lista, elemento2, nombre, misAutos, numAuto, numCelda);
                    limpiarIzquierda.valores(enemigos2.getGuardarX()[0], enemigos2.getGuardarY()[0]-1, 0, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torretaEnemigo, autoTanque, autoAvion, valores, torreta);
                    limpiarDerecha.valores(enemigos2.getGuardarX()[0], enemigos2.getGuardarY()[0]+1, columnas, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torretaEnemigo, autoTanque, autoAvion, valores, torreta);
                    timer.schedule(izquierda, 0, 1000);
                    timer.schedule(derecha, 0, 1000);
                    timer.schedule(limpiarIzquierda, 1000, 1000);
                    timer.schedule(limpiarDerecha, 1000, 1000);                   
                }
                if(aleatorio2==1){
                    abajo2.valores(enemigos2.getGuardarX()[1]+1, enemigos2.getGuardarY()[1], filas, balaAbajo, autoTanque, autoAvion, mapa, valores, vidaAuto, misAutos, numCelda, numAuto, elemento, lista, elemento2, nombre);
                    arriba2.valores(enemigos2.getGuardarX()[1]-1, enemigos2.getGuardarY()[1], mapa, balaArriba, autoTanque, autoAvion, valores, vidaAuto, elemento, lista, elemento2, nombre, misAutos, numAuto, numCelda);
                    limpiarArriba2.valores(enemigos2.getGuardarX()[1]-1, enemigos2.getGuardarY()[1], 0, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torretaEnemigo, autoTanque, autoAvion, valores, torreta);
                    limpiarAbajo2.valores(enemigos2.getGuardarX()[1]+1, enemigos2.getGuardarY()[1], filas, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torretaEnemigo, autoTanque, autoAvion, valores, torreta);
                    timer.schedule(abajo2, 0, 1000);
                    timer.schedule(arriba2, 0, 1000);
                    timer.schedule(limpiarAbajo2, 1000, 1000);
                    timer.schedule(limpiarArriba2, 1000, 1000);                  
                } else if(aleatorio2==2){
                    derecha2.valores(enemigos2.getGuardarX()[1], enemigos2.getGuardarY()[1]+1, columnas, balaDerecha, autoTanque, autoAvion, mapa, valores, vidaAuto, elemento, lista, elemento2, nombre, misAutos, numAuto, numCelda);
                    izquierda2.valores(enemigos2.getGuardarX()[1], enemigos2.getGuardarY()[1]-1, mapa, balaIzquierda, autoTanque, autoAvion, valores, vidaAuto, elemento, lista, elemento2, nombre, misAutos, numAuto, numCelda);
                    limpiarIzquierda2.valores(enemigos2.getGuardarX()[1], enemigos2.getGuardarY()[1]-1, 0, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torretaEnemigo, autoTanque, autoAvion, valores, torreta);
                    limpiarDerecha2.valores(enemigos2.getGuardarX()[1], enemigos2.getGuardarY()[1]+1, columnas, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torretaEnemigo, autoTanque, autoAvion, valores, torreta);
                    timer.schedule(izquierda2, 0, 1000);
                    timer.schedule(derecha2, 0, 1000);
                    timer.schedule(limpiarIzquierda2, 1000, 1000);
                    timer.schedule(limpiarDerecha2, 1000, 1000);                   
                }
                if(aleatorio3==1){
                    abajo3.valores(enemigos2.getGuardarX()[2]+1, enemigos2.getGuardarY()[2], filas, balaAbajo, autoTanque, autoAvion, mapa, valores, vidaAuto, misAutos, numCelda, numAuto, elemento, lista, elemento2, nombre);
                    arriba3.valores(enemigos2.getGuardarX()[2]-1, enemigos2.getGuardarY()[2], mapa, balaArriba, autoTanque, autoAvion, valores, vidaAuto, elemento, lista, elemento2, nombre, misAutos, numAuto, numCelda);
                    limpiarArriba3.valores(enemigos2.getGuardarX()[2]-1, enemigos2.getGuardarY()[2], 0, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torretaEnemigo, autoTanque, autoAvion, valores, torreta);
                    limpiarAbajo3.valores(enemigos2.getGuardarX()[2]+1, enemigos2.getGuardarY()[2], filas, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torretaEnemigo, autoTanque, autoAvion, valores, torreta);
                    timer.schedule(abajo3, 0, 1000);
                    timer.schedule(arriba3, 0, 1000);
                    timer.schedule(limpiarAbajo3, 1000, 1000);
                    timer.schedule(limpiarArriba3, 1000, 1000);                  
                } else if(aleatorio3==2){
                    derecha3.valores(enemigos2.getGuardarX()[2], enemigos2.getGuardarY()[2]+1, columnas, balaDerecha, autoTanque, autoAvion, mapa, valores, vidaAuto, elemento, lista, elemento2, nombre, misAutos, numAuto, numCelda);
                    izquierda3.valores(enemigos2.getGuardarX()[2], enemigos2.getGuardarY()[2]-1, mapa, balaIzquierda, autoTanque, autoAvion, valores, vidaAuto, elemento, lista, elemento2, nombre, misAutos, numAuto, numCelda);
                    limpiarIzquierda3.valores(enemigos2.getGuardarX()[2], enemigos2.getGuardarY()[2]-1, 0, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torretaEnemigo, autoTanque, autoAvion, valores, torreta);
                    limpiarDerecha3.valores(enemigos2.getGuardarX()[2], enemigos2.getGuardarY()[2]+1, columnas, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torretaEnemigo, autoTanque, autoAvion, valores, torreta);
                    timer.schedule(izquierda3, 0, 1000);
                    timer.schedule(derecha3, 0, 1000);
                    timer.schedule(limpiarIzquierda3, 1000, 1000);
                    timer.schedule(limpiarDerecha3, 1000, 1000);                   
                }
                if(aleatorio4==1){
                    abajo4.valores(enemigos2.getGuardarX()[3]+1, enemigos2.getGuardarY()[3], filas, balaAbajo, autoTanque, autoAvion, mapa, valores, vidaAuto, misAutos, numCelda, numAuto, elemento, lista, elemento2, nombre);
                    arriba4.valores(enemigos2.getGuardarX()[3]-1, enemigos2.getGuardarY()[3], mapa, balaArriba, autoTanque, autoAvion, valores, vidaAuto, elemento, lista, elemento2, nombre, misAutos, numAuto, numCelda);
                    limpiarArriba4.valores(enemigos2.getGuardarX()[3]-1, enemigos2.getGuardarY()[3], 0, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torretaEnemigo, autoTanque, autoAvion, valores, torreta);
                    limpiarAbajo4.valores(enemigos2.getGuardarX()[3]+1, enemigos2.getGuardarY()[3], filas, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torretaEnemigo, autoTanque, autoAvion, valores, torreta);
                    timer.schedule(abajo4, 0, 1000);
                    timer.schedule(arriba4, 0, 1000);
                    timer.schedule(limpiarAbajo4, 1000, 1000);
                    timer.schedule(limpiarArriba4, 1000, 1000);                  
                } else if(aleatorio4==2){
                    derecha4.valores(enemigos2.getGuardarX()[3], enemigos2.getGuardarY()[3]+1, columnas, balaDerecha, autoTanque, autoAvion, mapa, valores, vidaAuto, elemento, lista, elemento2, nombre, misAutos, numAuto, numCelda);
                    izquierda4.valores(enemigos2.getGuardarX()[3], enemigos2.getGuardarY()[3]-1, mapa, balaIzquierda, autoTanque, autoAvion, valores, vidaAuto, elemento, lista, elemento2, nombre, misAutos, numAuto, numCelda);
                    limpiarIzquierda4.valores(enemigos2.getGuardarX()[3], enemigos2.getGuardarY()[3]-1, 0, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torretaEnemigo, autoTanque, autoAvion, valores, torreta);
                    limpiarDerecha4.valores(enemigos2.getGuardarX()[3], enemigos2.getGuardarY()[3]+1, columnas, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torretaEnemigo, autoTanque, autoAvion, valores, torreta);
                    timer.schedule(izquierda4, 0, 1000);
                    timer.schedule(derecha4, 0, 1000);
                    timer.schedule(limpiarIzquierda4, 1000, 1000);
                    timer.schedule(limpiarDerecha4, 1000, 1000);                   
                }
        
        }
        
       
    }*/

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tableroJuego = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVehiculos2 = new javax.swing.JTable();
        primera = new javax.swing.JLabel();
        segunda = new javax.swing.JLabel();
        tercera = new javax.swing.JLabel();
        txtTitulo1 = new javax.swing.JLabel();
        txtTitulo2 = new javax.swing.JLabel();
        txtTitulo3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaEnemigos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txt5 = new javax.swing.JLabel();
        contTurnos = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        numAuto = new javax.swing.JLabel();
        vidaAuto = new javax.swing.JLabel();
        nivelAuto = new javax.swing.JLabel();
        ataqueAuto = new javax.swing.JLabel();
        panelEnemigos = new javax.swing.JPanel();
        enemigo1 = new javax.swing.JLabel();
        enemigo2 = new javax.swing.JLabel();
        enemigo3 = new javax.swing.JLabel();
        enemigo4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout tableroJuegoLayout = new javax.swing.GroupLayout(tableroJuego);
        tableroJuego.setLayout(tableroJuegoLayout);
        tableroJuegoLayout.setHorizontalGroup(
            tableroJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );
        tableroJuegoLayout.setVerticalGroup(
            tableroJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );

        getContentPane().add(tableroJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 550, 410));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 720, 30, 30));

        tablaVehiculos2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaVehiculos2);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, 140, 140));
        getContentPane().add(primera, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 60, 80, 60));
        getContentPane().add(segunda, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 160, 80, 60));
        getContentPane().add(tercera, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 250, 80, 60));

        txtTitulo1.setText("Campo de las mil batallas");
        getContentPane().add(txtTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 80, -1, -1));

        txtTitulo2.setText("Montañas de Idrazil");
        getContentPane().add(txtTitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 180, -1, -1));

        txtTitulo3.setText("Mar de Atlantis");
        getContentPane().add(txtTitulo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 270, -1, -1));

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

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 480, 150, 140));

        txt5.setText("Turnos:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(txt5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(contTurnos, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contTurnos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 650, 320, 40));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(ataqueAuto, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(nivelAuto, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(numAuto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vidaAuto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(206, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(numAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vidaAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nivelAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ataqueAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 480, 250, 180));

        javax.swing.GroupLayout panelEnemigosLayout = new javax.swing.GroupLayout(panelEnemigos);
        panelEnemigos.setLayout(panelEnemigosLayout);
        panelEnemigosLayout.setHorizontalGroup(
            panelEnemigosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEnemigosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEnemigosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(enemigo2, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(enemigo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(enemigo3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(enemigo4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(194, Short.MAX_VALUE))
        );
        panelEnemigosLayout.setVerticalGroup(
            panelEnemigosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEnemigosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(enemigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(enemigo2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(enemigo3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(enemigo4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        getContentPane().add(panelEnemigos, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 480, 240, 180));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ataqueAuto;
    private javax.swing.JLabel contTurnos;
    private javax.swing.JLabel enemigo1;
    private javax.swing.JLabel enemigo2;
    private javax.swing.JLabel enemigo3;
    private javax.swing.JLabel enemigo4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nivelAuto;
    private javax.swing.JLabel numAuto;
    private javax.swing.JPanel panelEnemigos;
    private javax.swing.JLabel primera;
    private javax.swing.JLabel segunda;
    public javax.swing.JTable tablaEnemigos;
    public javax.swing.JTable tablaVehiculos2;
    private javax.swing.JPanel tableroJuego;
    private javax.swing.JLabel tercera;
    private javax.swing.JLabel txt5;
    private javax.swing.JLabel txtTitulo1;
    private javax.swing.JLabel txtTitulo2;
    private javax.swing.JLabel txtTitulo3;
    private javax.swing.JLabel vidaAuto;
    // End of variables declaration//GEN-END:variables
}
