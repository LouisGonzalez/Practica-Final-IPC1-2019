package practicafinal.ipc1;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author luisGonzalez
 */
public class DlgMovimientos extends javax.swing.JDialog {
    
    private int posX, posY, filas, columnas, i, j, numCelda;
    private JLabel[][] mapa;
    private int[][] valores, tipoTerreno, enemigos, ocupado, cajasComodin;
    private Icon autoTanque, autoAvion, cumbres, mar, campo, torreta;
    private NuevoAvatar<NombreJugador> misAutos;
    private JLabel numAuto, vidaAuto;
    
    public DlgMovimientos(java.awt.Frame parent, boolean modal, int posX, int posY, JLabel[][] mapa, int filas, int columnas, int i, int j, Icon autoTanque, int[][] valores, Icon autoAvion, int[][] tipoTerreno, Icon cumbres, Icon mar, Icon campo, NuevoAvatar<NombreJugador> misAutos, JLabel numAuto, int numCelda, int[][] enemigos, Icon torreta, int[][] ocupado, int[][] cajasComodin, JLabel vidaAuto){
        super(parent, modal);
        initComponents();
        this.posX = posX;
        this.posY = posY;
        this.mapa = mapa;
        this.filas = filas;
        this.columnas = columnas;
        this.i = i;
        this.j = j;
        this.autoTanque = autoTanque;
        this.valores = valores;
        this.autoAvion = autoAvion;
        this.tipoTerreno = tipoTerreno;
        this.cumbres = cumbres;
        this.mar = mar; 
        this.campo = campo;
        this.misAutos = misAutos;
        this.numAuto = numAuto;
        this.numCelda = numCelda;
        this.enemigos = enemigos;
        this.torreta = torreta;
        this.ocupado = ocupado;
        this.vidaAuto = vidaAuto;
        this.cajasComodin = cajasComodin;
        setLocationRelativeTo(null);
                
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dadoMov = new javax.swing.JLabel();
        txt1 = new javax.swing.JLabel();
        dado = new javax.swing.JButton();
        mostrarValor = new javax.swing.JLabel();
        txt2 = new javax.swing.JLabel();
        txt3 = new javax.swing.JLabel();
        mostrarValor2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dadoMov.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practicafinal/ipc1/imagenes/dado-imagen-animada-0016.gif"))); // NOI18N
        dadoMov.setPreferredSize(new java.awt.Dimension(72, 72));
        getContentPane().add(dadoMov, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 120, 100));
        getContentPane().add(txt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, 40, 20));

        dado.setText("Girar Dados");
        dado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dadoActionPerformed(evt);
            }
        });
        getContentPane().add(dado, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, -1, -1));
        getContentPane().add(mostrarValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 40, 20));

        txt2.setText("Resultado dado Direccionales:");
        getContentPane().add(txt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 220, 20));

        txt3.setText("Resultado dado Movimientos:");
        getContentPane().add(txt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 220, 20));
        getContentPane().add(mostrarValor2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 50, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dadoActionPerformed
        int dadoRandom = (int)(Math.random()*6);
        int direccion = (int)(Math.random()*4)+1;
        int nuevaPosX = posX + dadoRandom;
        int nuevaPosY = posY + dadoRandom;
        int segundaPosX = posX - dadoRandom;
        int segundaPosY = posY - dadoRandom;                                        
            try {
                int valor = Integer.parseInt(numAuto.getText());        
                Nodo<NombreJugador> elemento = misAutos.obtenerElemento(numCelda);
                NombreJugador lista = elemento.obtenerContenido();
                Nodo2<NombreAuto> elemento2 = lista.getMiLista().obtenerElemento(valor);
                NombreAuto nombre = elemento2.obtenerContenido();               
                mostrarValor.setText(String.valueOf(dadoRandom));
                mostrarValor2.setText(String.valueOf(direccion));
                JOptionPane.showMessageDialog(null, "Su posicion actual es "+posX+" "+posY);
                this.dispose();
                if(nombre.getTipoAuto().equals("Tanque")){
                    cinematica(autoTanque, 2, dadoRandom, direccion, nuevaPosX, nuevaPosY, segundaPosX, segundaPosY, 1);
                } else if (nombre.getTipoAuto().equals("Avion")){
                    cinematica(autoAvion, 1, dadoRandom, direccion, nuevaPosX, nuevaPosY, segundaPosX, segundaPosY, 2);
                }
            } catch(Exception ex){
                Logger.getLogger(DlgListaAvatares.class.getName()).log(Level.SEVERE, null, ex);    
            }
            
            
            
            
            
            
                
    }//GEN-LAST:event_dadoActionPerformed
    
    private void cinematica(Icon tipoAuto, int tipoCampo, int dadoRandom, int direccion, int nuevaPosX, int nuevaPosY, int segundaPosX, int segundaPosY, int valorAuto){
        Timer timer = new Timer();
        MovAbajo abajo = new MovAbajo();
        MovAbajo2 abajo2 = new MovAbajo2();
        MovArriba arriba = new MovArriba();
        MovArriba2 arriba2 = new MovArriba2();
        MovDerecha derecha = new MovDerecha();
        MovDerecha2 derecha2 = new MovDerecha2();
        MovIzquierda izquierda = new MovIzquierda();
        MovIzquierda2 izquierda2 = new MovIzquierda2();
        DlgCajasComodin cajitas = new DlgCajasComodin(null, true, misAutos, numCelda, numAuto, vidaAuto, posX, posY, cajasComodin);
        switch (direccion) {
            case 1:
                //metodo para mover arriba
                if(segundaPosX>0){
                    if(tipoTerreno[segundaPosX][posY]==tipoCampo || enemigos[segundaPosX][posY]==1){
                        JOptionPane.showMessageDialog(null, "Tu vehiculo ha topado con terreno prohibido, porfavor lanza los dados de nuevo");
                        setVisible(true);
                    } else {
                        arriba.valores(i, j, segundaPosX+1, mapa, tipoAuto);
                        arriba2.valores(i, j, segundaPosX+1, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torreta, autoTanque, autoAvion, valores, torreta);
                        timer.schedule(arriba, 0, 1000);
                        timer.schedule(arriba2, 0, 1000);
                        //valores que se le ingresan a las matrices y de esta forma poder identificar en que posicion se encuentran
                        valores[posX][posY] = 0;
                        ocupado[posX][posY] = 0;
                        valores[segundaPosX][posY] = valorAuto;
                        ocupado[segundaPosX][posY] = 1;
                        if(cajasComodin[segundaPosX][posY]==1){
                            cajitas.setVisible(true);
                        }
                    }
                } else if (segundaPosX<=0){
                    if(tipoTerreno[0][posY]==tipoCampo || enemigos[0][posY]==1){
                        JOptionPane.showMessageDialog(null, "Tu vehiculo ha topado con terreno prohibido, porfavor lanza los dados de nuevo");
                        setVisible(true);
                    } else {
                        arriba.valores(i, j, 0+1, mapa, tipoAuto);
                        arriba2.valores(i, j, 0+1, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torreta, autoTanque, autoAvion, valores, torreta);
                        timer.schedule(arriba, 0, 1000);
                        timer.schedule(arriba2, 0, 1000);
                        valores[posX][posY] = 0;
                        ocupado[posX][posY] = 0;
                        valores[0][posY] = valorAuto;
                        ocupado[0][posY] = 1;
                        if(cajasComodin[0][posY]==1){
                            cajitas.setVisible(true);
                        }
                    }
                }
            break;
            case 2:
                //metodo para mover abajo
                if(nuevaPosX>=filas){
                    if(tipoTerreno[filas-1][posY]==tipoCampo || enemigos[filas-1][posY]==1){
                        JOptionPane.showMessageDialog(null, "Tu vehiculo ha topado con terreno prohibido, porfavor lanza los dados de nuevo");
                        setVisible(true);
                    } else {
                        abajo.valores(i, j, filas-1, mapa, tipoAuto);
                        abajo2.valores(i, j, filas-1, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torreta, autoTanque, autoAvion, valores, torreta);
                        timer.schedule(abajo, 0, 1000);
                        timer.schedule(abajo2, 0, 1000);
                        valores[posX][posY] = 0;
                        ocupado[posX][posY] = 0;
                        valores[filas-1][posY] = valorAuto;
                        ocupado[filas-1][posY] = 1;
                        if(cajasComodin[filas-1][posY]==1){
                            cajitas.setVisible(true);
                        }
                    }
                } else if (nuevaPosX<filas){
                    if(tipoTerreno[nuevaPosX][posY]==tipoCampo || enemigos[nuevaPosX][posY]==1){
                        JOptionPane.showMessageDialog(null, "Tu vehiculo ha topado con terreno prohibido, porfavor lanza los dados de nuevo");
                        setVisible(true);
                    } else {
                        abajo.valores(i, j, nuevaPosX, mapa, tipoAuto);
                        abajo2.valores(i, j, nuevaPosX, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torreta, autoTanque, autoAvion, valores, torreta);
                        timer.schedule(abajo, 0, 1000);
                        timer.schedule(abajo2, 0, 1000);
                        valores[posX][posY] = 0;
                        ocupado[posX][posY] = 0;
                        valores[nuevaPosX][posY] = valorAuto;
                        ocupado[nuevaPosX][posY] = 1;
                        if(cajasComodin[nuevaPosX][posY]==1){
                            cajitas.setVisible(true);
                        }
                    }
                } 
            break;
            case 3:
                //metodo para mover derecha
                if(nuevaPosY>=columnas){
                    if(tipoTerreno[posX][columnas-1]==tipoCampo || enemigos[posX][columnas-1]==1){
                        JOptionPane.showMessageDialog(null, "Tu vehiculo ha topado con terreno prohibido, porfavor lanza los dados de nuevo");
                        setVisible(true);
                    } else {
                        derecha.valores(i, j, columnas-1, mapa, tipoAuto);
                        derecha2.valores(i, j, columnas-1, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torreta, autoTanque, autoAvion, valores, torreta);
                        timer.schedule(derecha, 0, 1000);
                        timer.schedule(derecha2, 0, 1000);
                        valores[posX][posY] = 0;
                        ocupado[posX][posY] = 0;
                        valores[posX][columnas-1] = valorAuto;
                        ocupado[posX][columnas-1] = 1;
                        if(cajasComodin[posX][columnas-1]==1){
                            cajitas.setVisible(true);
                        }
                    }
                } else if (nuevaPosY<columnas){
                    if(tipoTerreno[posX][nuevaPosY]==tipoCampo || enemigos[posX][nuevaPosY]==1){
                        JOptionPane.showMessageDialog(null, "Tu vehiculo ha topado con terreno prohibido, porfavor lanza los dados de nuevo");
                        setVisible(true);
                    } else {
                        derecha.valores(i, j, nuevaPosY, mapa, tipoAuto);
                        derecha2.valores(i, j, nuevaPosY, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torreta, autoTanque, autoAvion, valores, torreta);
                        timer.schedule(derecha, 0, 1000);
                        timer.schedule(derecha2, 0, 1000);
                        valores[posX][posY] = 0;
                        ocupado[posX][posY] = 0;
                        valores[posX][nuevaPosY] = valorAuto;
                        ocupado[posX][nuevaPosY] = 1;
                        if(cajasComodin[posX][nuevaPosY]==1){
                            cajitas.setVisible(true);
                        }
                    }
                }   
            break;
            case 4:
                //metodo para mover izquierda
                if(segundaPosY>=0){
                    if(tipoTerreno[posX][segundaPosY]==tipoCampo || enemigos[posX][segundaPosY]==1){
                        JOptionPane.showMessageDialog(null, "Tu vehiculo ha topado con terreno prohibido, porfavor lanza los dados de nuevo");
                        setVisible(true);
                    } else {
                        izquierda.valores(i, j, segundaPosY+1, mapa, tipoAuto);
                        izquierda2.valores(i, j, segundaPosY+1, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torreta, autoTanque, autoAvion, valores, torreta);
                        timer.schedule(izquierda, 0, 1000);
                        timer.schedule(izquierda2, 0, 1000);
                        valores[posX][posY] = 0;
                        ocupado[posX][posY] = 0;
                        valores[posX][segundaPosY] = valorAuto;
                        ocupado[posX][segundaPosY] = 1;
                        if(cajasComodin[posX][segundaPosY]==1){
                            cajitas.setVisible(true);
                        }
                    }
                } else if (segundaPosY<0){
                    if(tipoTerreno[posX][0]==tipoCampo || enemigos[posX][0]==1){
                        JOptionPane.showMessageDialog(null, "Tu vehiculo ha topado con terreno prohibido, porfavor lanza los dados de nuevo");
                        setVisible(true);
                    } else {
                        izquierda.valores(i, j, 0+1, mapa, tipoAuto);
                        izquierda2.valores(i, j, 0+1, mapa, cumbres, mar, campo, tipoTerreno, enemigos, torreta, autoTanque, autoAvion, valores, torreta);
                        timer.schedule(izquierda, 0, 1000);
                        timer.schedule(izquierda2, 0, 1000);
                        valores[posX][posY] = 0;
                        ocupado[posX][posY] = 0;
                        valores[posX][0] = valorAuto;
                        ocupado[posX][0] = 1;
                        if(cajasComodin[posX][0]==1){
                            cajitas.setVisible(true);
                        }
                    }
                }  
            break;                
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dado;
    private javax.swing.JLabel dadoMov;
    private javax.swing.JLabel mostrarValor;
    private javax.swing.JLabel mostrarValor2;
    private javax.swing.JLabel txt1;
    private javax.swing.JLabel txt2;
    private javax.swing.JLabel txt3;
    // End of variables declaration//GEN-END:variables
}
