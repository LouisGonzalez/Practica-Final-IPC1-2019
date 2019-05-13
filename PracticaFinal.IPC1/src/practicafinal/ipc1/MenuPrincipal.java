package practicafinal.ipc1;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author luisGonzalez
 */
public class MenuPrincipal extends javax.swing.JFrame {
    
    private NuevoAvatar<NombreJugador> miLista = new NuevoAvatar<>();
    
    
    ImageIcon foto = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/world-of-warcraft-computer-games-wallpaper-2029.jpg");           
    DefaultTableModel tabla;
    Archivos archivos = new Archivos();
    
    public MenuPrincipal() {      
        initComponents();   
        setLocationRelativeTo(null);
        Icon fotos = new ImageIcon(foto.getImage().getScaledInstance(contornoMenu.getWidth(), contornoMenu.getHeight(), Image.SCALE_DEFAULT));
        contornoMenu.setIcon(fotos);
        this.repaint();
    }

    public Archivos getArchivos() {
        return archivos;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        solitario = new javax.swing.JButton();
        multijugador = new javax.swing.JButton();
        verAvatar = new javax.swing.JButton();
        nuevoAvatar = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        contornoMenu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        solitario.setBackground(new java.awt.Color(102, 102, 102));
        solitario.setForeground(new java.awt.Color(255, 255, 255));
        solitario.setText("Jugar (1 jugador)");
        solitario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        solitario.setContentAreaFilled(false);
        solitario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solitarioActionPerformed(evt);
            }
        });
        getContentPane().add(solitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 160, 30));

        multijugador.setForeground(new java.awt.Color(255, 255, 255));
        multijugador.setText("Jugar (2 jugadores)");
        multijugador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        multijugador.setContentAreaFilled(false);
        multijugador.setFocusPainted(false);
        multijugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multijugadorActionPerformed(evt);
            }
        });
        getContentPane().add(multijugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 170, 30));

        verAvatar.setForeground(new java.awt.Color(255, 255, 255));
        verAvatar.setText("Estadisticas generales");
        verAvatar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        verAvatar.setContentAreaFilled(false);
        verAvatar.setFocusPainted(false);
        verAvatar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verAvatarActionPerformed(evt);
            }
        });
        getContentPane().add(verAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 180, 30));

        nuevoAvatar.setForeground(new java.awt.Color(255, 255, 255));
        nuevoAvatar.setText("Crear un nuevo avatar");
        nuevoAvatar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nuevoAvatar.setContentAreaFilled(false);
        nuevoAvatar.setFocusPainted(false);
        nuevoAvatar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoAvatarActionPerformed(evt);
            }
        });
        getContentPane().add(nuevoAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 180, 30));

        salir.setForeground(new java.awt.Color(255, 255, 255));
        salir.setText("Salir");
        salir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        salir.setContentAreaFilled(false);
        salir.setFocusPainted(false);
        getContentPane().add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 50, 30));

        contornoMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practicafinal/ipc1/imagenes/world-of-warcraft-computer-games-wallpaper-2029.jpg"))); // NOI18N
        getContentPane().add(contornoMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void solitarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solitarioActionPerformed
        miLista = archivos.leerArchivo();
        DlgListaAvatares listas = new DlgListaAvatares(miLista);      
        tabla = (DefaultTableModel) listas.tablaDatos.getModel();
        MostrarAvatares nuevo = new MostrarAvatares(this, true, tabla, miLista, archivos);
        nuevo.setVisible(true);
         
      
    }//GEN-LAST:event_solitarioActionPerformed

    private void multijugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multijugadorActionPerformed
       miLista = archivos.leerArchivo();
       DlgListaAvatares listas = new DlgListaAvatares(miLista);
       tabla = (DefaultTableModel) listas.tablaDatos.getModel();
       DlgEleccionMultiJugador multiJugador = new DlgEleccionMultiJugador(this, true, tabla, miLista, archivos);
       multiJugador.setVisible(true);
    }//GEN-LAST:event_multijugadorActionPerformed

    private void nuevoAvatarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoAvatarActionPerformed
        FrmNuevoAvatar avatar = new FrmNuevoAvatar(this, true, miLista, archivos);
        avatar.setVisible(true);
        
    }//GEN-LAST:event_nuevoAvatarActionPerformed
    
    protected void mostrarTabla(NuevoAvatar<NombreJugador> miLista){
        try{          
            DlgListaAvatares listas = new DlgListaAvatares(miLista);      
            listas.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(FrmNuevoAvatar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void verAvatarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verAvatarActionPerformed
        miLista = archivos.leerArchivo();
        mostrarTabla(miLista);
            

        
    }//GEN-LAST:event_verAvatarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel contornoMenu;
    private javax.swing.JButton multijugador;
    private javax.swing.JButton nuevoAvatar;
    private javax.swing.JButton salir;
    private javax.swing.JButton solitario;
    private javax.swing.JButton verAvatar;
    // End of variables declaration//GEN-END:variables
}
