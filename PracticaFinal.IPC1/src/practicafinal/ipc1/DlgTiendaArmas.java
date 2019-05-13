package practicafinal.ipc1;

import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author luisGonzalez
 */
public class DlgTiendaArmas extends javax.swing.JDialog {
    
    private ImageIcon arma1 = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/mp40.jpg");
    private ImageIcon arma2 = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/AWM.jpg");
    private ImageIcon arma3 = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/grooza.jpg");
    private ImageIcon arma4 = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/escopeta.jpg");
    private ImageIcon armas = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/armas.jpg");
    private String arma;
    private int numCelda;
    private double costo, ataque, vida;
    private NuevoAvatar<NombreJugador> miLista;
    private Archivos archivos;
    
    public DlgTiendaArmas(java.awt.Frame parent, boolean modal, int numCelda, NuevoAvatar<NombreJugador> miLista, Archivos archivos) {
        super(parent, modal);
        setLocationRelativeTo(null);
        initComponents();
        this.numCelda = numCelda;
        this.miLista = miLista;
        this.archivos = archivos;
        this.miLista = this.archivos.leerArchivo();
        Icon mp40 = new ImageIcon(arma1.getImage().getScaledInstance(imagenArma.getWidth(), imagenArma.getHeight(), Image.SCALE_DEFAULT));
        Icon awm = new ImageIcon(arma2.getImage().getScaledInstance(imagenArma.getWidth(), imagenArma.getHeight(), Image.SCALE_DEFAULT));
        Icon grooza = new ImageIcon(arma3.getImage().getScaledInstance(imagenArma.getWidth(), imagenArma.getHeight(), Image.SCALE_DEFAULT));
        Icon mp1040 = new ImageIcon(arma4.getImage().getScaledInstance(imagenArma.getWidth(), imagenArma.getHeight(), Image.SCALE_DEFAULT));
        Icon fondo = new ImageIcon(armas.getImage().getScaledInstance(fondoArmas.getWidth(), fondoArmas.getHeight(), Image.SCALE_DEFAULT));
        fondoArmas.setIcon(fondo);
        imagenArma.setIcon(awm);
        mostrarAtaque.setText(Integer.toString(15));
        mostrarCosto.setText(Integer.toString(30));
        listadoArmas.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent itemEvent){
                arma = listadoArmas.getSelectedItem().toString();
                switch(arma){
                    case "Rifle AWM":
                        imagenArma.setIcon(awm);
                        costo = 30;
                        ataque = 15;
                        mostrarAtaque.setText(Double.toString(ataque));
                        mostrarCosto.setText(Double.toString(costo));
                        break;
                    case "GROZA":
                        imagenArma.setIcon(grooza);
                        costo = 25;
                        mostrarAtaque.setText(Double.toString(ataque));
                        mostrarCosto.setText(Double.toString(costo));
                        ataque = 10;
                        break;
                    case "MP40":
                        imagenArma.setIcon(mp40);
                        costo = 5;
                        ataque = 3;
                        mostrarAtaque.setText(Double.toString(ataque));
                        mostrarCosto.setText(Double.toString(costo));
                        break;
                    case "Escopeta M1014":
                        imagenArma.setIcon(mp1040);
                        costo = 10;
                        ataque = 5;
                        mostrarAtaque.setText(Double.toString(ataque));
                        mostrarCosto.setText(Double.toString(costo));
                        break;
                }
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelArmas = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        listadoArmas = new javax.swing.JComboBox<>();
        imagenArma = new javax.swing.JLabel();
        txt2 = new javax.swing.JLabel();
        mostrarAtaque = new javax.swing.JLabel();
        txt3 = new javax.swing.JLabel();
        mostrarCosto = new javax.swing.JLabel();
        comprarArma = new javax.swing.JButton();
        fondoArmas = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelArmas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Elige tipo de arma:");
        panelArmas.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 29, 177, -1));

        listadoArmas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rifle AWM", "GROZA", "MP40", "Escopeta M1014" }));
        panelArmas.add(listadoArmas, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 93, 157, -1));
        panelArmas.add(imagenArma, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 72, 50));

        txt2.setBackground(new java.awt.Color(255, 255, 255));
        txt2.setForeground(new java.awt.Color(255, 255, 255));
        txt2.setText("Daño:");
        panelArmas.add(txt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, -1, -1));

        mostrarAtaque.setBackground(new java.awt.Color(255, 255, 255));
        mostrarAtaque.setForeground(new java.awt.Color(255, 255, 255));
        panelArmas.add(mostrarAtaque, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 48, 20));

        txt3.setBackground(new java.awt.Color(255, 255, 255));
        txt3.setForeground(new java.awt.Color(255, 255, 255));
        txt3.setText("Costo:");
        panelArmas.add(txt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, -1, 22));

        mostrarCosto.setBackground(new java.awt.Color(255, 255, 255));
        mostrarCosto.setForeground(new java.awt.Color(255, 255, 255));
        panelArmas.add(mostrarCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 50, 20));

        comprarArma.setBackground(new java.awt.Color(255, 255, 255));
        comprarArma.setForeground(new java.awt.Color(255, 255, 255));
        comprarArma.setText("Comprar");
        comprarArma.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        comprarArma.setContentAreaFilled(false);
        comprarArma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comprarArmaActionPerformed(evt);
            }
        });
        panelArmas.add(comprarArma, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 130, 30));
        panelArmas.add(fondoArmas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 440, 210));

        getContentPane().add(panelArmas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 440, 200));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(438, 178, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comprarArmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comprarArmaActionPerformed
        try { 
            Nodo<NombreJugador> elemento = miLista.obtenerElemento(numCelda);
            NombreJugador agregar = elemento.obtenerContenido();
            if(agregar.getOro()>Double.parseDouble(mostrarCosto.getText())){
            Armas nueva = new Armas(listadoArmas.getSelectedItem().toString(), Double.parseDouble(mostrarAtaque.getText()));
            agregar.getMisArmas().insertarContenido(nueva);
            archivos.guardarArchivos(miLista);
            JOptionPane.showMessageDialog(null, "Felicidades, su arma ha sido agregada con exito");
            vida = agregar.getOro() - Double.parseDouble(mostrarCosto.getText());
            agregar.setOro(vida);
            archivos.guardarArchivos(miLista);
            } else{
                JOptionPane.showMessageDialog(null, "Lo sentimos, no tienes el suficiente dinero como para hacer esta compra");
            }
        } catch(Exception e){            
        }
    }//GEN-LAST:event_comprarArmaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton comprarArma;
    private javax.swing.JLabel fondoArmas;
    private javax.swing.JLabel imagenArma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox<String> listadoArmas;
    private javax.swing.JLabel mostrarAtaque;
    private javax.swing.JLabel mostrarCosto;
    private javax.swing.JPanel panelArmas;
    private javax.swing.JLabel txt2;
    private javax.swing.JLabel txt3;
    // End of variables declaration//GEN-END:variables
}
