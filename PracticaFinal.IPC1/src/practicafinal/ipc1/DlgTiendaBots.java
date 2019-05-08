package practicafinal.ipc1;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author luisGonzalez
 */
public class DlgTiendaBots extends javax.swing.JDialog {

    private NuevoAvatar<NombreJugador> miLista;
    private int numCelda;
    private double costo, ataque;
    ImageIcon nuevo = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/bot.jpg");
    
    public DlgTiendaBots(java.awt.Frame parent, boolean modal, int numCelda, NuevoAvatar<NombreJugador> miLista) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        try{
        Nodo<NombreJugador> elemento = miLista.obtenerElemento(numCelda);
        NombreJugador agregar = elemento.obtenerContenido();
        oroJugador.setText(Double.toString(agregar.getOro()));
        } catch(Exception e){            
        }    
        this.miLista = miLista;
        this.numCelda = numCelda;
        Icon bot = new ImageIcon(nuevo.getImage().getScaledInstance(mostrarBot.getWidth(), mostrarBot.getHeight(), Image.SCALE_DEFAULT));
        mostrarBot.setIcon(bot);
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt1 = new javax.swing.JLabel();
        txt2 = new javax.swing.JLabel();
        ataqueBot = new javax.swing.JLabel();
        costoBot = new javax.swing.JLabel();
        mostrarBot = new javax.swing.JLabel();
        comprarBot = new javax.swing.JButton();
        nombreBot = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        oroJugador = new javax.swing.JLabel();
        txt3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt1.setText("Daño:");
        jPanel1.add(txt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 52, 25));

        txt2.setText("Costo:");
        jPanel1.add(txt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 52, 26));

        ataqueBot.setText("20");
        jPanel1.add(ataqueBot, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 40, 20));

        costoBot.setText("40");
        jPanel1.add(costoBot, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 40, 20));
        jPanel1.add(mostrarBot, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 93, 63));

        comprarBot.setText("Comprar");
        comprarBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comprarBotActionPerformed(evt);
            }
        });
        jPanel1.add(comprarBot, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 140, 90, 40));

        nombreBot.setText("PATHFINDER 550");
        jPanel1.add(nombreBot, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 12, 184, 28));

        jLabel1.setText("Dinero total:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 12, -1, -1));
        jPanel1.add(oroJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 12, 38, 14));

        txt3.setText("(Los bots solo disparan hacia arriba)");
        jPanel1.add(txt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 220, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 410, 210));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comprarBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comprarBotActionPerformed
        try{    
            Nodo<NombreJugador> elemento = miLista.obtenerElemento(numCelda);
            NombreJugador agregar = elemento.obtenerContenido();
            Bot nuevoBot = new Bot(mostrarBot.getText(), Double.parseDouble(ataqueBot.getText()));
            agregar.getMisBots().insertarContenido(nuevoBot);
            JOptionPane.showMessageDialog(null, "Pathfinder a sido añadido a su lista de Pathfinders disponibles");
        } catch(Exception e){
        }
    }//GEN-LAST:event_comprarBotActionPerformed
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ataqueBot;
    private javax.swing.JButton comprarBot;
    private javax.swing.JLabel costoBot;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel mostrarBot;
    private javax.swing.JLabel nombreBot;
    private javax.swing.JLabel oroJugador;
    private javax.swing.JLabel txt1;
    private javax.swing.JLabel txt2;
    private javax.swing.JLabel txt3;
    // End of variables declaration//GEN-END:variables
}
