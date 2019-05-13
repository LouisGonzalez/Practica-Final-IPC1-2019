package practicafinal.ipc1;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author luisGonzalez
 */
public class DlgCajasComodin extends javax.swing.JDialog {
    
    private NuevoAvatar<NombreJugador> miLista;
    private int numCelda;
    private double vida, resultado;
    private JLabel numAuto, vidaAuto;
    private int armadura, posX, posY;
    private int[][] cajaComodin;
    private int contClicks = 0;
    private Archivos archivos;
    
    public DlgCajasComodin(java.awt.Frame parent, boolean modal, NuevoAvatar<NombreJugador> miLista, int numCelda, JLabel numAuto, JLabel vidaAuto, int posX, int posY, int[][] cajaComodin, Archivos archivos) {
        super(parent, modal);
        this.miLista = miLista;
        this.numCelda = numCelda;
        this.numAuto = numAuto;
        this.vidaAuto = vidaAuto;
        this.posX = posX;
        this.posY = posY;
        this.cajaComodin = cajaComodin;
        this.archivos = archivos;
        this.miLista = archivos.leerArchivo();
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelComodin = new javax.swing.JPanel();
        txt = new javax.swing.JLabel();
        txt2 = new javax.swing.JLabel();
        resultadoCaja = new javax.swing.JButton();
        gifDado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelComodin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt.setText("HAS CAIDO EN UNA CAJA DE LA BIENAVENTURANZA");
        panelComodin.add(txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 12, 332, 27));

        txt2.setText("Lanza los dados para saber tu suerte: ");
        panelComodin.add(txt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 57, 232, -1));

        resultadoCaja.setBackground(new java.awt.Color(255, 255, 255));
        resultadoCaja.setForeground(new java.awt.Color(255, 255, 255));
        resultadoCaja.setText("LANZAR DADOS");
        resultadoCaja.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        resultadoCaja.setContentAreaFilled(false);
        resultadoCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultadoCajaActionPerformed(evt);
            }
        });
        panelComodin.add(resultadoCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 117, 135, 34));

        gifDado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practicafinal/ipc1/imagenes/dado-imagen-animada-0016.gif"))); // NOI18N
        gifDado.setPreferredSize(new java.awt.Dimension(72, 72));
        panelComodin.add(gifDado, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 89, 97, 77));

        getContentPane().add(panelComodin, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 2, 400, 230));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void resultadoCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultadoCajaActionPerformed
        contClicks++;
        if(contClicks==1){
            try{   
                //CAJAS COMODIN SEGUN LO QUE PIDE LA IMPLEMENTACION DEL JUEGO
                int valor = Integer.parseInt(numAuto.getText());
                Nodo<NombreJugador> elemento = miLista.obtenerElemento(numCelda);
                NombreJugador lista = elemento.obtenerContenido();
                Nodo2<NombreAuto> elemento2 = lista.getMiLista().obtenerElemento(valor);
                NombreAuto nombre = elemento2.obtenerContenido();
                vida = nombre.getVida();
                armadura = nombre.getArmadura();
                int aleatorio = (int)(Math.random()*3)+1;
                switch(aleatorio){
                    // SEGUN EL VALOR DE ALETORIO LA CAJA LE BRINDA UNA SORPRESA AL JUGADOR
                    case 1:
                        JOptionPane.showMessageDialog(null, "FELICIDADES! Has ganado regeneracion de vida en un 25%");
                        resultado = vida + (vida*0.25);
                        if(resultado>=100){
                            vidaAuto.setText(Double.toString(100));
                            nombre.setVida(100);
                            archivos.guardarArchivos(miLista);
                            cajaComodin[posX][posY] = 0;
                        } else if(resultado<100){
                            vidaAuto.setText(Double.toString(resultado));
                            nombre.setVida(resultado);
                            archivos.guardarArchivos(miLista);
                            cajaComodin[posX][posY] = 0;
                        }
                        break;
                    case 2:
                        armadura = armadura + 4;
                        JOptionPane.showMessageDialog(null, "Has ganado un aumento de armadura en 4");
                        nombre.setArmadura(armadura);
                        archivos.guardarArchivos(miLista);
                        cajaComodin[posX][posY] = 0;
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "Esta caja se encuentra vacia :(, suerte para la proxima");
                        cajaComodin[posX][posY] = 0;
                        archivos.guardarArchivos(miLista);
                        break;              
                }
            }catch(Exception e){            
            }
        } else { 
            JOptionPane.showMessageDialog(null, "Ya has abierto la caja, porfavor cierra y sigue jugando");
        }
    }//GEN-LAST:event_resultadoCajaActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel gifDado;
    private javax.swing.JPanel panelComodin;
    private javax.swing.JButton resultadoCaja;
    private javax.swing.JLabel txt;
    private javax.swing.JLabel txt2;
    // End of variables declaration//GEN-END:variables
}
