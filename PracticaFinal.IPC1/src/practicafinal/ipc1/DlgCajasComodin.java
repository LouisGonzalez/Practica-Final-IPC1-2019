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
    
    public DlgCajasComodin(java.awt.Frame parent, boolean modal, NuevoAvatar<NombreJugador> miLista, int numCelda, JLabel numAuto, JLabel vidaAuto, int posX, int posY, int[][] cajaComodin) {
        super(parent, modal);
        this.miLista = miLista;
        this.numCelda = numCelda;
        this.numAuto = numAuto;
        this.vidaAuto = vidaAuto;
        this.posX = posX;
        this.posY = posY;
        this.cajaComodin = cajaComodin;
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

        txt.setText("HAS CAIDO EN UNA CAJA DE LA BIENAVENTURANZA");

        txt2.setText("Lanza los dados para saber tu suerte: ");

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

        gifDado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practicafinal/ipc1/imagenes/dado-imagen-animada-0016.gif"))); // NOI18N
        gifDado.setPreferredSize(new java.awt.Dimension(72, 72));

        javax.swing.GroupLayout panelComodinLayout = new javax.swing.GroupLayout(panelComodin);
        panelComodin.setLayout(panelComodinLayout);
        panelComodinLayout.setHorizontalGroup(
            panelComodinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelComodinLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panelComodinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                    .addGroup(panelComodinLayout.createSequentialGroup()
                        .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelComodinLayout.createSequentialGroup()
                        .addComponent(resultadoCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(gifDado, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelComodinLayout.setVerticalGroup(
            panelComodinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelComodinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt2)
                .addGroup(panelComodinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelComodinLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(resultadoCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelComodinLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(gifDado, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(panelComodin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelComodin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void resultadoCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultadoCajaActionPerformed
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
                    resultado = vida + (vida*0.25);
                    if(resultado>=100){
                        vidaAuto.setText(Double.toString(100));
                        nombre.setVida(100);
                        cajaComodin[posX][posY] = 0;
                    } else if(resultado<100){
                        vidaAuto.setText(Double.toString(resultado));
                        nombre.setVida(resultado);
                        cajaComodin[posX][posY] = 0;
                    }
                    break;
                case 2:
                    armadura = armadura + 4;
                    JOptionPane.showMessageDialog(null, "Has ganado un aumento de armadura en 4");
                    nombre.setArmadura(armadura);
                    cajaComodin[posX][posY] = 0;
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Esta caja se encuentra vacia :(, suerte para la proxima");
                    cajaComodin[posX][posY] = 0;
                    break;
                
            }
        }catch(Exception e){            
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
