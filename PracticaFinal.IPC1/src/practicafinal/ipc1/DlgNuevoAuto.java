package practicafinal.ipc1;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author luisGonzalez
 */
public class DlgNuevoAuto extends javax.swing.JDialog {

    private NuevoAvatar<NombreJugador> miLista;
    private int numCelda;
    private String auto;
    private int ataque, armadura, experiencia, nivel, vida;
    ImageIcon avion = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/Avion.jpg");
    ImageIcon tanque = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/Tanque.jpg");
    ImageIcon fondo = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/autito.jpg");
    
    public DlgNuevoAuto(java.awt.Frame parent, boolean modal, NuevoAvatar<NombreJugador> miLista, int numCelda) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.miLista = miLista;
        this.numCelda = numCelda;
        Icon primerFoto = new ImageIcon(tanque.getImage().getScaledInstance(modelo.getWidth(), modelo.getHeight(), Image.SCALE_DEFAULT));
        Icon segundaFoto = new ImageIcon(avion.getImage().getScaledInstance(modelo.getWidth(), modelo.getHeight(), Image.SCALE_DEFAULT));      
        Icon menu = new ImageIcon(fondo.getImage().getScaledInstance(fondoAuto.getWidth(), fondoAuto.getHeight(), Image.SCALE_DEFAULT));      
        modelo.setIcon(primerFoto);
        fondoAuto.setIcon(menu);
        tipoAuto.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent itemEvent){
                auto = tipoAuto.getSelectedItem().toString();
                if(auto.equals("Tanque")){
                    modelo.setIcon(primerFoto);
                } else if (auto.equals("Avion")){
                    modelo.setIcon(segundaFoto);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nuevoAuto = new javax.swing.JTextField();
        crear = new javax.swing.JButton();
        tipoAuto = new javax.swing.JComboBox<>();
        modelo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fondoAuto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ingrese el nombre de su nuevo auto:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 236, -1));
        getContentPane().add(nuevoAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 184, -1));

        crear.setBackground(new java.awt.Color(255, 255, 255));
        crear.setForeground(new java.awt.Color(255, 255, 255));
        crear.setText("crear");
        crear.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        crear.setContentAreaFilled(false);
        crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearActionPerformed(evt);
            }
        });
        getContentPane().add(crear, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 70, 40));

        tipoAuto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tanque", "Avion" }));
        tipoAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoAutoActionPerformed(evt);
            }
        });
        getContentPane().add(tipoAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 139, -1, -1));
        getContentPane().add(modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 143, 80, 50));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 30, 20));
        getContentPane().add(fondoAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 220));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearActionPerformed
        try {
            //valores iniciales que se le dan al auto segun el tipo que sea ya fuera tanque o avion
            auto = tipoAuto.getSelectedItem().toString();
            if(auto.equals("Tanque")){
                ataque = 10;
                armadura = 6;
                experiencia = 0;
                nivel = 1;
                vida = 100;
            } else if (auto.equals("Avion")){
                ataque = 7;
                armadura = 3;
                experiencia = 0;
                nivel = 1;
                vida = 100;
            }
            Nodo<NombreJugador> elemento = miLista.obtenerElemento(numCelda);
            NombreJugador agregar = elemento.obtenerContenido();
            NombreAuto nombre = new NombreAuto(nuevoAuto.getText(), auto, ataque, armadura, experiencia, nivel, vida, 0, 0);
            agregar.getMiLista().insertarContenido(nombre);
            nuevoAuto.setText("");
            JOptionPane.showMessageDialog(null, "Su auto ha sido guardado con exito");
        } catch (Exception ex){
            Logger.getLogger(DlgListaAvatares.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_crearActionPerformed

    private void tipoAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoAutoActionPerformed
    }//GEN-LAST:event_tipoAutoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton crear;
    private javax.swing.JLabel fondoAuto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel modelo;
    private javax.swing.JTextField nuevoAuto;
    private javax.swing.JComboBox<String> tipoAuto;
    // End of variables declaration//GEN-END:variables
}
