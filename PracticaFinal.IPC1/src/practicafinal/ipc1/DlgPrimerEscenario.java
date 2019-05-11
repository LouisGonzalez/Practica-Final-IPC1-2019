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
public class DlgPrimerEscenario extends javax.swing.JDialog {

    private JLabel[][] mapa;
    private int[][] tipoTerreno;
    private int[][] valores;
    private int[][] enemigos;
    private int x, y, numCelda;
    private int[][] ocupado, bots, cajasComodin;
    private int filas;
    private int columnas;
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
    private final ImageIcon fondos = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/f.jpg");
    private final ImageIcon imagen = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/qw.jpg");
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
    
    public DlgPrimerEscenario(java.awt.Frame parent, boolean modal, NuevoAvatar<NombreJugador> misAutos, int numCelda, int filas, int columnas) {
        super(parent, modal);
        initComponents();
        Icon cumbres = new ImageIcon(cumbre.getImage().getScaledInstance(segunda.getWidth(), segunda.getHeight(), Image.SCALE_DEFAULT));
        Icon mar = new ImageIcon(agua.getImage().getScaledInstance(tercera.getWidth(), tercera.getHeight(), Image.SCALE_DEFAULT));
        Icon campo = new ImageIcon(campoAbierto.getImage().getScaledInstance(primera.getWidth(), primera.getHeight(), Image.SCALE_DEFAULT)); 
        Icon pantalla = new ImageIcon(fondos.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT)); 
        Icon imagen1 = new ImageIcon(imagen.getImage().getScaledInstance(fondoAliado.getWidth(), fondoAliado.getHeight(), Image.SCALE_DEFAULT)); 
        Icon imagen2 = new ImageIcon(imagen.getImage().getScaledInstance(fondoEnemigo.getWidth(), fondoEnemigo.getHeight(), Image.SCALE_DEFAULT)); 
        fondoAliado.setIcon(imagen1);
        fondoEnemigo.setIcon(imagen2);
        this.numCelda = numCelda;
        this.misAutos = misAutos;
        this.filas = filas;
        this.columnas = columnas;
        fondo.setIcon(pantalla);
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
        this.cajasComodin = new int[filas][columnas];
        tableroJuego.setLayout(new GridLayout(filas, columnas));
        for (x = 0; x < filas; x++) {    //doble for para la creacion de la matriz de labels
            for (y = 0; y < columnas; y++) {
                valores[x][y] = 0;
                enemigos[x][y] = 0;
                ocupado[x][y] = 0;   
                bots[x][y] = 0;
                cajasComodin[x][y] = 0;
                JLabel matriz = new JLabel();   //se inicializa el label unitario y se le dan caracteristicas iniciales
                matriz.setBounds(100*x,75*y,100,75);
                matriz.setOpaque(true);
                matriz.setBackground(Color.WHITE);
                matriz.setBorder(borde);
                mapa[x][y] = matriz;
                pintarMapa(x, y, mapa, tipoTerreno); 
                cajitasComodin(mapa, filas, columnas);
                modelMapa2 = (DefaultTableModel) tablaEnemigos.getModel();
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
                        } else if(contador>1){
                            for(int posX=0; posX<x; posX++){
                                for(int posY=0; posY<y; posY++){
                                    if(matriz == mapa[posX][posY] && valores[posX][posY]==1 || valores[posX][posY]==2){
                                        int i = posX;
                                        int j = posY;
                                        contadorTurnos++;
                                        
                                        contTurnos.setText(Integer.toString(contadorTurnos));
                                        DlgOpcionesJugador camibo = new DlgOpcionesJugador(null, true, misAutos, numCelda, mapa, posX, posY, autoTanque, autoAvion, cumbres, mar, campo, tipoTerreno, x, y, valores, filas, columnas, i, j, numAuto, balaArriba, balaAbajo, balaIzquierda, balaDerecha, enemigo, enemigos, ocupado, torretaEnemigo, fila, modelMapa2, vida, panelEnemigos, enemigo1, enemigo2, enemigo3, enemigo4, vidaAuto, nivelAuto, ataqueAuto, elemento, lista, elemento2, nombre, cajasComodin);
                                        camibo.setVisible(true);
                                        disparoEnemigos(balaAbajo, balaArriba, balaIzquierda, balaDerecha, autoTanque, autoAvion, cumbres, mar, campo, torretaEnemigo);
                                    } else if(matriz == mapa[posX][posY] && valores[posX][posY]==0 && enemigos[posX][posY]==0){
                                        contadorTurnos++;
                                        contTurnos.setText(Integer.toString(contadorTurnos));
                                        JOptionPane.showMessageDialog(null, "has clickado una caja comodin");
                                        DlgPosBots qwe = new DlgPosBots(null, true, numCelda, misAutos, mapa, posX, posY, bots, bot, contadorTurnos, posBotX, posBotY);
                                        DlgPreguntaBot pregunta = new DlgPreguntaBot(null, true, numCelda, posX, posY, misAutos, mapa, bots, bot, contadorTurnos, posBotX, posBotY, qwe);
                                        pregunta.setVisible(true);
                                        JOptionPane.showMessageDialog(null, posBotX[0]+" "+posBotY[0]);
                                        disparoEnemigos(balaAbajo, balaArriba, balaIzquierda, balaDerecha, autoTanque, autoAvion, cumbres, mar, campo, torretaEnemigo);
                                    } else if(matriz==mapa[posX][posY] && valores[posX][posY]==0 && enemigos[posX][posY]!=0){
                                        JOptionPane.showMessageDialog(null, "has clickado a un enemigo"+enemigos[posX][posY]);          
                                    }                                   
                                }
                            }
                        } if(Double.parseDouble(enemigo1.getText())<=0 && Double.parseDouble(enemigo2.getText())<=0 && Double.parseDouble(enemigo3.getText())<=0 && Double.parseDouble(enemigo4.getText())<=0){
                            try{
                                int sumaxp = (int)(Math.random()*100)+1;
                                int valor = Integer.parseInt(numAuto.getText());
                                Nodo<NombreJugador> elemento = misAutos.obtenerElemento(numCelda);
                                NombreJugador lista = elemento.obtenerContenido();
                                Nodo2<NombreAuto> elemento2 = lista.getMiLista().obtenerElemento(valor);
                                NombreAuto nombre = elemento2.obtenerContenido();  
                                int nivel = nombre.getNivel();
                                double ataque = nombre.getAtaque();
                                int defensa = nombre.getArmadura();
                                int experiencia = nombre.getExperiencia();
                                JOptionPane.showMessageDialog(null, "FELICIDADES! Has ganado el juego");
                                experiencia = experiencia + sumaxp;
                                nombre.setExperiencia(experiencia);
                                if(experiencia>=100*nivel){
                                    nivel = nivel + 1;
                                    ataque = ataque + 3;
                                    defensa = defensa + 3;
                                    nombre.setNivel(nivel);
                                    nombre.setArmadura(defensa);
                                    nombre.setAtaque(ataque);
                                    JOptionPane.showMessageDialog(null, "Tus estadisticas han sido actualizadas");
                                    JOptionPane.showConfirmDialog(null, "Tu vehiculo ahora es de nivel "+nivel);
                                    JOptionPane.showMessageDialog(null, "Tu ataque ha aumentado a "+ataque);
                                    JOptionPane.showMessageDialog(null, "Ahora a tus enemigos les costara aun mas matarte, aumentas en defensa a "+defensa);
                                    
                                }
                                dispose();
                            }catch(Exception ex){                                
                            }
                        }else if(Double.parseDouble(vidaAuto.getText())<=0){
                            try{
                                int valor = Integer.parseInt(numAuto.getText());
                                Nodo<NombreJugador> elemento = misAutos.obtenerElemento(numCelda);
                                NombreJugador lista = elemento.obtenerContenido();
                                Nodo2<NombreAuto> elemento2 = lista.getMiLista().obtenerElemento(valor);
                                NombreAuto nombre = elemento2.obtenerContenido();                                  
                                JOptionPane.showMessageDialog(null, "Los enemigos han podido contra ti, has perdido el juego :/");
                                nombre.setVida(0);
                                vidaAuto.setText(Integer.toString(0));
                                dispose();
                            } catch(Exception ex){
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
    
    private void disparoEnemigos(Icon balaAbajo, Icon balaArriba, Icon balaIzquierda, Icon balaDerecha, Icon autoTanque, Icon autoAvion, Icon cumbres, Icon mar, Icon campo, Icon torretaEnemigo){
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
    }
    
    private void cajitasComodin(JLabel[][] mapa, int filas, int columnas){
        int[] posXComodin = new int[filas + 2];
        int[] posYComodin = new int[columnas + 2];
        int[] guardarX = new int[filas +2];
        int[] guardarY = new int[columnas + 2];
        for(int i=0; i<=filas+1; i++){
            posXComodin[i] = (int)(Math.random()*filas);
            posYComodin[i] = (int)(Math.random()*columnas);
            guardarX[i] = posXComodin[i];
            guardarY[i] = posYComodin[i];
            cajasComodin[guardarX[i]][guardarX[i]] = 1;
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
        tercera = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaEnemigos = new javax.swing.JTable();
        panelEnemigos = new javax.swing.JPanel();
        enemigo1 = new javax.swing.JLabel();
        enemigo2 = new javax.swing.JLabel();
        enemigo3 = new javax.swing.JLabel();
        enemigo4 = new javax.swing.JLabel();
        txt11 = new javax.swing.JLabel();
        txt12 = new javax.swing.JLabel();
        txt13 = new javax.swing.JLabel();
        txt14 = new javax.swing.JLabel();
        fondoEnemigo = new javax.swing.JLabel();
        panelAliado = new javax.swing.JPanel();
        numAuto = new javax.swing.JLabel();
        vidaAuto = new javax.swing.JLabel();
        nivelAuto = new javax.swing.JLabel();
        ataqueAuto = new javax.swing.JLabel();
        txt7 = new javax.swing.JLabel();
        txt8 = new javax.swing.JLabel();
        txt9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fondoAliado = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txt6 = new javax.swing.JLabel();
        contTurnos = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout tableroJuegoLayout = new javax.swing.GroupLayout(tableroJuego);
        tableroJuego.setLayout(tableroJuegoLayout);
        tableroJuegoLayout.setHorizontalGroup(
            tableroJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );
        tableroJuegoLayout.setVerticalGroup(
            tableroJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        getContentPane().add(tableroJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 430, 300));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 540, 30, 30));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 130, 140));
        getContentPane().add(segunda, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, 80, 60));

        txtTitulo3.setBackground(new java.awt.Color(255, 255, 255));
        txtTitulo3.setForeground(new java.awt.Color(255, 255, 255));
        txtTitulo3.setText("Mar de Atlantis");
        getContentPane().add(txtTitulo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 250, -1, -1));

        txtTitulo2.setBackground(new java.awt.Color(255, 255, 255));
        txtTitulo2.setForeground(new java.awt.Color(255, 255, 255));
        txtTitulo2.setText("Montañas de Idrazil");
        getContentPane().add(txtTitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, -1, -1));
        getContentPane().add(primera, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 80, 60));

        txtTitulo1.setBackground(new java.awt.Color(255, 255, 255));
        txtTitulo1.setForeground(new java.awt.Color(255, 255, 255));
        txtTitulo1.setText("Campo de las mil batallas");
        getContentPane().add(txtTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 60, -1, -1));
        getContentPane().add(tercera, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 230, 80, 60));

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

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 140, 140));

        panelEnemigos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        enemigo1.setBackground(new java.awt.Color(255, 255, 255));
        enemigo1.setForeground(new java.awt.Color(255, 255, 255));
        panelEnemigos.add(enemigo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 42, 29));

        enemigo2.setBackground(new java.awt.Color(255, 255, 255));
        enemigo2.setForeground(new java.awt.Color(255, 255, 255));
        panelEnemigos.add(enemigo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 53, 42, 30));

        enemigo3.setBackground(new java.awt.Color(255, 255, 255));
        enemigo3.setForeground(new java.awt.Color(255, 255, 255));
        panelEnemigos.add(enemigo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 95, 42, 27));

        enemigo4.setBackground(new java.awt.Color(255, 255, 255));
        enemigo4.setForeground(new java.awt.Color(255, 255, 255));
        panelEnemigos.add(enemigo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 128, 42, 26));

        txt11.setBackground(new java.awt.Color(255, 255, 255));
        txt11.setForeground(new java.awt.Color(255, 255, 255));
        txt11.setText("Vida Enemigo 1:");
        panelEnemigos.add(txt11, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 27, 134, -1));

        txt12.setBackground(new java.awt.Color(255, 255, 255));
        txt12.setForeground(new java.awt.Color(255, 255, 255));
        txt12.setText("Vida Enemigo 2:");
        panelEnemigos.add(txt12, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 69, -1, -1));

        txt13.setBackground(new java.awt.Color(255, 255, 255));
        txt13.setForeground(new java.awt.Color(255, 255, 255));
        txt13.setText("Vida Enemigo 3:");
        panelEnemigos.add(txt13, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 108, -1, -1));

        txt14.setBackground(new java.awt.Color(255, 255, 255));
        txt14.setForeground(new java.awt.Color(255, 255, 255));
        txt14.setText("Vida Enemigo 4:");
        panelEnemigos.add(txt14, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 140, -1, -1));
        panelEnemigos.add(fondoEnemigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 190));

        getContentPane().add(panelEnemigos, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 340, 330, 190));

        panelAliado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        numAuto.setBackground(new java.awt.Color(255, 255, 255));
        numAuto.setForeground(new java.awt.Color(255, 255, 255));
        panelAliado.add(numAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 20, 46, 14));

        vidaAuto.setBackground(new java.awt.Color(255, 255, 255));
        vidaAuto.setForeground(new java.awt.Color(255, 255, 255));
        panelAliado.add(vidaAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, 46, 14));

        nivelAuto.setBackground(new java.awt.Color(255, 255, 255));
        nivelAuto.setForeground(new java.awt.Color(255, 255, 255));
        panelAliado.add(nivelAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 111, 46, 14));

        ataqueAuto.setBackground(new java.awt.Color(255, 255, 255));
        ataqueAuto.setForeground(new java.awt.Color(255, 255, 255));
        panelAliado.add(ataqueAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 153, 46, 16));

        txt7.setBackground(new java.awt.Color(255, 255, 255));
        txt7.setForeground(new java.awt.Color(255, 255, 255));
        txt7.setText("Num. Auto");
        panelAliado.add(txt7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        txt8.setBackground(new java.awt.Color(255, 255, 255));
        txt8.setForeground(new java.awt.Color(255, 255, 255));
        txt8.setText("Vida total");
        panelAliado.add(txt8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 66, 100, -1));

        txt9.setBackground(new java.awt.Color(255, 255, 255));
        txt9.setForeground(new java.awt.Color(255, 255, 255));
        txt9.setText("Nivel Actual");
        panelAliado.add(txt9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 111, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Daño Actual");
        panelAliado.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 155, -1, -1));
        panelAliado.add(fondoAliado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 190));

        getContentPane().add(panelAliado, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, 200, 190));

        txt6.setText("Turnos: ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt6)
                .addGap(57, 57, 57)
                .addComponent(contTurnos, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt6)
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addComponent(contTurnos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 260, 40));
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ataqueAuto;
    private javax.swing.JLabel contTurnos;
    private javax.swing.JLabel enemigo1;
    private javax.swing.JLabel enemigo2;
    private javax.swing.JLabel enemigo3;
    private javax.swing.JLabel enemigo4;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel fondoAliado;
    private javax.swing.JLabel fondoEnemigo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nivelAuto;
    private javax.swing.JLabel numAuto;
    private javax.swing.JPanel panelAliado;
    private javax.swing.JPanel panelEnemigos;
    private javax.swing.JLabel primera;
    private javax.swing.JLabel segunda;
    public javax.swing.JTable tablaEnemigos;
    public javax.swing.JTable tablaVehiculos;
    private javax.swing.JPanel tableroJuego;
    private javax.swing.JLabel tercera;
    private javax.swing.JLabel txt11;
    private javax.swing.JLabel txt12;
    private javax.swing.JLabel txt13;
    private javax.swing.JLabel txt14;
    private javax.swing.JLabel txt6;
    private javax.swing.JLabel txt7;
    private javax.swing.JLabel txt8;
    private javax.swing.JLabel txt9;
    private javax.swing.JLabel txtTitulo1;
    private javax.swing.JLabel txtTitulo2;
    private javax.swing.JLabel txtTitulo3;
    private javax.swing.JLabel vidaAuto;
    // End of variables declaration//GEN-END:variables
}
