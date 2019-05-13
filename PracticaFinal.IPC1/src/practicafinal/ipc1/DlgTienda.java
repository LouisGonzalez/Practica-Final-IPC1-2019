package practicafinal.ipc1;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author luisGonzalez
 */
public class DlgTienda extends javax.swing.JDialog {
    
    private int numCelda;
    private NuevoAvatar<NombreJugador> miLista;
    private Archivos archivos;
    private ImageIcon tienda = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/tiendero.jpg");
    
    public DlgTienda(java.awt.Frame parent, boolean modal, int numCelda, NuevoAvatar<NombreJugador> miLista, Archivos archivos) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.numCelda = numCelda;
        this.miLista = miLista;
        this.archivos = archivos;
        this.miLista = archivos.leerArchivo();
        Icon fotos = new ImageIcon(tienda.getImage().getScaledInstance(fondoTienda.getWidth(), fondoTienda.getHeight(), Image.SCALE_DEFAULT));
        fondoTienda.setIcon(fotos);
        try{
            Nodo<NombreJugador> elemento = miLista.obtenerElemento(numCelda);
            NombreJugador lista = elemento.obtenerContenido();
            oro.setText(Double.toString(lista.getOro()));
        } catch(Exception e){            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTienda = new javax.swing.JPanel();
        txtTienda = new javax.swing.JLabel();
        botonArma = new javax.swing.JButton();
        botonBot = new javax.swing.JButton();
        oro = new javax.swing.JLabel();
        fondoTienda = new javax.swing.JLabel();
        cantOro = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelTienda.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTienda.setBackground(new java.awt.Color(255, 255, 255));
        txtTienda.setForeground(new java.awt.Color(255, 255, 255));
        txtTienda.setText("BIENVENIDO A LA TIENDA DE JUEGO");
        panelTienda.add(txtTienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 320, 26));

        botonArma.setBackground(new java.awt.Color(255, 255, 255));
        botonArma.setForeground(new java.awt.Color(255, 255, 255));
        botonArma.setText("Armas");
        botonArma.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonArma.setContentAreaFilled(false);
        botonArma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonArmaActionPerformed(evt);
            }
        });
        panelTienda.add(botonArma, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 135, 94, 41));

        botonBot.setBackground(new java.awt.Color(255, 255, 255));
        botonBot.setForeground(new java.awt.Color(255, 255, 255));
        botonBot.setText("BOTS");
        botonBot.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonBot.setContentAreaFilled(false);
        botonBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBotActionPerformed(evt);
            }
        });
        panelTienda.add(botonBot, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 135, 94, 43));

        oro.setBackground(new java.awt.Color(255, 255, 255));
        oro.setForeground(new java.awt.Color(255, 255, 255));
        panelTienda.add(oro, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 48, 29));
        panelTienda.add(fondoTienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        cantOro.setBackground(new java.awt.Color(255, 255, 255));
        cantOro.setForeground(new java.awt.Color(255, 255, 255));
        cantOro.setText("Oro acumulado");
        panelTienda.add(cantOro, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 230, 20));

        getContentPane().add(panelTienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 400, 300));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, 40, 10));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonArmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonArmaActionPerformed
        this.dispose();
        miLista = archivos.leerArchivo();
        DlgTiendaArmas armas = new DlgTiendaArmas(null, true, numCelda, miLista, archivos);
        armas.setVisible(true);
    }//GEN-LAST:event_botonArmaActionPerformed

    private void botonBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBotActionPerformed
        this.dispose();
        miLista = archivos.leerArchivo();
        DlgTiendaBots bot = new DlgTiendaBots(null, true, numCelda, miLista, archivos);
        bot.setVisible(true);
    }//GEN-LAST:event_botonBotActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonArma;
    private javax.swing.JButton botonBot;
    private javax.swing.JLabel cantOro;
    private javax.swing.JLabel fondoTienda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel oro;
    private javax.swing.JPanel panelTienda;
    private javax.swing.JLabel txtTienda;
    // End of variables declaration//GEN-END:variables
}
