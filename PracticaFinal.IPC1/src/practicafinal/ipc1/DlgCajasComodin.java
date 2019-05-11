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
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelComodin = new javax.swing.JPanel();
        txt = new javax.swing.JLabel();
        txt2 = new javax.swing.JLabel();
        resultadoCaja = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txt.setText("HAS CAIDO EN UNA CAJA DE LA BIENAVENTURANZA");

        txt2.setText("Lanza los dados para saber tu suerte: ");

        resultadoCaja.setText("LANZAR DADOS");
        resultadoCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultadoCajaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelComodinLayout = new javax.swing.GroupLayout(panelComodin);
        panelComodin.setLayout(panelComodinLayout);
        panelComodinLayout.setHorizontalGroup(
            panelComodinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelComodinLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panelComodinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                    .addGroup(panelComodinLayout.createSequentialGroup()
                        .addGroup(panelComodinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(resultadoCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelComodinLayout.setVerticalGroup(
            panelComodinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelComodinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt2)
                .addGap(34, 34, 34)
                .addComponent(resultadoCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
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
            int valor = Integer.parseInt(numAuto.getText());
            Nodo<NombreJugador> elemento = miLista.obtenerElemento(numCelda);
            NombreJugador lista = elemento.obtenerContenido();
            Nodo2<NombreAuto> elemento2 = lista.getMiLista().obtenerElemento(valor);
            NombreAuto nombre = elemento2.obtenerContenido();
            vida = nombre.getVida();
            armadura = nombre.getArmadura();
            int aleatorio = (int)(Math.random()*1)+1;
            switch(aleatorio){
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
    private javax.swing.JPanel panelComodin;
    private javax.swing.JButton resultadoCaja;
    private javax.swing.JLabel txt;
    private javax.swing.JLabel txt2;
    // End of variables declaration//GEN-END:variables
}
