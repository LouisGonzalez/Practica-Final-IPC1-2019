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
    
    ImageIcon arma1 = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/mp40.jpg");
    ImageIcon arma2 = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/AWM.jpg");
    ImageIcon arma3 = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/grooza.jpg");
    ImageIcon arma4 = new ImageIcon("/home/luisitopapurey/Escritorio/PRACTICA FINAL 201731766 2019/PracticaFinal.IPC1/src/practicafinal/ipc1/imagenes/escopeta.jpg");
    private String arma;
    private int numCelda;
    private double costo, ataque;
    private NuevoAvatar<NombreJugador> miLista;
    
    public DlgTiendaArmas(java.awt.Frame parent, boolean modal, int numCelda, NuevoAvatar<NombreJugador> miLista) {
        super(parent, modal);
        setLocationRelativeTo(null);
        initComponents();
        this.numCelda = numCelda;
        this.miLista = miLista;
        Icon mp40 = new ImageIcon(arma1.getImage().getScaledInstance(imagenArma.getWidth(), imagenArma.getHeight(), Image.SCALE_DEFAULT));
        Icon awm = new ImageIcon(arma2.getImage().getScaledInstance(imagenArma.getWidth(), imagenArma.getHeight(), Image.SCALE_DEFAULT));
        Icon grooza = new ImageIcon(arma3.getImage().getScaledInstance(imagenArma.getWidth(), imagenArma.getHeight(), Image.SCALE_DEFAULT));
        Icon mp1040 = new ImageIcon(arma4.getImage().getScaledInstance(imagenArma.getWidth(), imagenArma.getHeight(), Image.SCALE_DEFAULT));
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
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Elige tipo de arma:");

        listadoArmas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rifle AWM", "GROZA", "MP40", "Escopeta M1014" }));

        txt2.setText("Daño:");

        txt3.setText("Costo:");

        comprarArma.setText("Comprar");
        comprarArma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comprarArmaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelArmasLayout = new javax.swing.GroupLayout(panelArmas);
        panelArmas.setLayout(panelArmasLayout);
        panelArmasLayout.setHorizontalGroup(
            panelArmasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelArmasLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelArmasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelArmasLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(listadoArmas, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imagenArma, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelArmasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelArmasLayout.createSequentialGroup()
                        .addComponent(txt3)
                        .addGap(18, 18, 18)
                        .addComponent(mostrarCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelArmasLayout.createSequentialGroup()
                        .addComponent(txt2)
                        .addGap(18, 18, 18)
                        .addComponent(mostrarAtaque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(comprarArma, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );
        panelArmasLayout.setVerticalGroup(
            panelArmasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelArmasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelArmasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelArmasLayout.createSequentialGroup()
                        .addGroup(panelArmasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelArmasLayout.createSequentialGroup()
                                .addComponent(txt2)
                                .addGap(23, 23, 23))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelArmasLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(panelArmasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelArmasLayout.createSequentialGroup()
                                .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(panelArmasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(comprarArma, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(listadoArmas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(imagenArma, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelArmasLayout.createSequentialGroup()
                        .addComponent(mostrarAtaque, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(mostrarCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelArmas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(panelArmas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comprarArmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comprarArmaActionPerformed
        try {    
            Nodo<NombreJugador> elemento = miLista.obtenerElemento(numCelda);
            NombreJugador agregar = elemento.obtenerContenido();
            Armas nueva = new Armas(listadoArmas.getSelectedItem().toString(), Double.parseDouble(mostrarAtaque.getText()));
            agregar.getMisArmas().insertarContenido(nueva);
            JOptionPane.showMessageDialog(null, "Felicidades, su arma ha sido agregada con exito");
        } catch(Exception e){            
        }
    }//GEN-LAST:event_comprarArmaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton comprarArma;
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
