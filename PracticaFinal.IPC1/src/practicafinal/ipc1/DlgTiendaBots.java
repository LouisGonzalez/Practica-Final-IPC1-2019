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
    private ImageIcon nuevo = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/bot.jpg");
    private ImageIcon imagen = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/bott.jpg");
    
    public DlgTiendaBots(java.awt.Frame parent, boolean modal, int numCelda, NuevoAvatar<NombreJugador> miLista) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        Icon boto = new ImageIcon(imagen.getImage().getScaledInstance(fondoBot.getWidth(), fondoBot.getHeight(), Image.SCALE_DEFAULT));
        fondoBot.setIcon(boto);
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
        fondoBot = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt1.setBackground(new java.awt.Color(255, 255, 255));
        txt1.setForeground(new java.awt.Color(255, 255, 255));
        txt1.setText("Daño:");
        jPanel1.add(txt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 52, 10));

        txt2.setBackground(new java.awt.Color(255, 255, 255));
        txt2.setForeground(new java.awt.Color(255, 255, 255));
        txt2.setText("Costo:");
        jPanel1.add(txt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 52, -1));

        ataqueBot.setBackground(new java.awt.Color(255, 255, 255));
        ataqueBot.setForeground(new java.awt.Color(255, 255, 255));
        ataqueBot.setText("20");
        jPanel1.add(ataqueBot, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 40, 10));

        costoBot.setBackground(new java.awt.Color(255, 255, 255));
        costoBot.setForeground(new java.awt.Color(255, 255, 255));
        costoBot.setText("40");
        jPanel1.add(costoBot, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 40, 10));
        jPanel1.add(mostrarBot, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 93, 63));

        comprarBot.setBackground(new java.awt.Color(255, 255, 255));
        comprarBot.setForeground(new java.awt.Color(255, 255, 255));
        comprarBot.setText("Comprar");
        comprarBot.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        comprarBot.setContentAreaFilled(false);
        comprarBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comprarBotActionPerformed(evt);
            }
        });
        jPanel1.add(comprarBot, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 90, 40));

        nombreBot.setBackground(new java.awt.Color(255, 255, 255));
        nombreBot.setForeground(new java.awt.Color(255, 255, 255));
        nombreBot.setText("PATHFINDER 550");
        jPanel1.add(nombreBot, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 184, 28));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Dinero total:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, -1, -1));
        jPanel1.add(oroJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 38, 14));

        txt3.setText("(Los bots solo disparan hacia arriba)");
        jPanel1.add(txt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 220, 30));
        jPanel1.add(fondoBot, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 220));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 210));

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
    private javax.swing.JLabel fondoBot;
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
