package practicafinal.ipc1;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 *
 * @author luisGonzalez
 */
public class FrmNuevoAvatar extends javax.swing.JDialog {
    
    protected NuevoAvatar<NombreJugador> miLista;
    MenuPrincipal ver = new MenuPrincipal();
    
    
    ImageIcon foto = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/robot-inteligencia-artificial3.jpg");    
    
    public FrmNuevoAvatar(java.awt.Frame parent, boolean modal, NuevoAvatar<NombreJugador> miLista){
        super(parent, modal);
        initComponents();
        this.miLista = miLista;
        setLocationRelativeTo(null);
        Icon fotos = new ImageIcon(foto.getImage().getScaledInstance(contornoGenesis.getWidth(), contornoGenesis.getHeight(), Image.SCALE_DEFAULT));
        contornoGenesis.setIcon(fotos);
        this.repaint();   
    }
                                                                                
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt1 = new javax.swing.JLabel();
        txt2 = new javax.swing.JLabel();
        txt3 = new javax.swing.JLabel();
        ingreseAvatar = new javax.swing.JTextField();
        crearAvatar = new javax.swing.JButton();
        contornoGenesis = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt1.setForeground(new java.awt.Color(255, 255, 255));
        txt1.setText("Bienvenido al taller \"GENESIS\"");
        getContentPane().add(txt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 12, 215, 24));

        txt2.setForeground(new java.awt.Color(255, 255, 255));
        txt2.setText("Especializacion: Creacion de vida inteligente apta para combate");
        getContentPane().add(txt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 54, -1, 27));

        txt3.setForeground(new java.awt.Color(255, 255, 255));
        txt3.setText("Ingresa el nombre de tu nuevo avatar:");
        getContentPane().add(txt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 89, 275, 30));

        ingreseAvatar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingreseAvatarActionPerformed(evt);
            }
        });
        getContentPane().add(ingreseAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 131, 221, 30));

        crearAvatar.setForeground(new java.awt.Color(0, 102, 102));
        crearAvatar.setText("Crear");
        crearAvatar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearAvatarActionPerformed(evt);
            }
        });
        getContentPane().add(crearAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 131, 82, 31));
        getContentPane().add(contornoGenesis, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 190));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void crearAvatarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearAvatarActionPerformed
        NuevoAuto<NombreAuto> miLista2 = new NuevoAuto<>();
        NuevaArma<Armas> misArmas = new NuevaArma<>();
        NuevoBot<Bot> misBots = new NuevoBot<>();
        NombreJugador nombre = new NombreJugador(ingreseAvatar.getText(), miLista2, misArmas, misBots, 50);       
        miLista.insertarContenido(nombre);
        ingreseAvatar.setText("");
        JOptionPane.showMessageDialog(null, "Su nuevo avatar ha sido guardado exitosamente");
    }//GEN-LAST:event_crearAvatarActionPerformed
    
    
    private void ingreseAvatarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingreseAvatarActionPerformed
    }//GEN-LAST:event_ingreseAvatarActionPerformed
     
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel contornoGenesis;
    private javax.swing.JButton crearAvatar;
    public static javax.swing.JTextField ingreseAvatar;
    private javax.swing.JLabel txt1;
    private javax.swing.JLabel txt2;
    private javax.swing.JLabel txt3;
    // End of variables declaration//GEN-END:variables
}
