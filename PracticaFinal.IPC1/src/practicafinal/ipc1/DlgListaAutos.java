package practicafinal.ipc1;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author luisGonzalez
 */
public class DlgListaAutos extends javax.swing.JDialog {
    
    private NuevoAvatar<NombreJugador> misAutos;
    private int numCelda;
    private int contClicks = 0;
    private int contClicks2 = 0;
    private int contClicks3 = 0;
    private int contClicks4 = 0;
    private int contClicks5 = 0;
    private int contClicks6 = 0;
    private int contClicks7 = 0;
    private int contClicks8 = 0;
    
    
    public DlgListaAutos(java.awt.Frame parent, boolean modal, NuevoAvatar<NombreJugador> misAutos, int numCelda) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null); 
        this.numCelda = numCelda;
        this.misAutos = misAutos;
        cargarTabla();
        }
    
    protected void cargarTabla(){
        try {
            //metodo encargado de mostrar los datos que ya se crearon pero en un tabla
            Nodo<NombreJugador> elemento = misAutos.obtenerElemento(numCelda);
            NombreJugador tabla = elemento.obtenerContenido();
            DefaultTableModel dtmModel2 = (DefaultTableModel) tablaAutos.getModel();
            Object[] fila = new Object[dtmModel2.getColumnCount()];
            for(int i=0; i<tabla.getMiLista().obtenerCantidadElementos(); i++){
                try{
                    Nodo2<NombreAuto> elemento2 = tabla.getMiLista().obtenerElemento(i);
                    NombreAuto nombre = elemento2.obtenerContenido();
                    fila[0] = nombre.getNombre();
                    fila[1] = nombre.getTipoAuto();
                    fila[2] = nombre.getAtaque();
                    fila[3] = nombre.getArmadura();
                    fila[4] = nombre.getExperiencia();
                    fila[5] = nombre.getNivel();
                    fila[6] = nombre.getVida();
                    fila[7] = nombre.getEnemigosDestruidos();
                    fila[8] = nombre.getAutoDestruido();
                    dtmModel2.addRow(fila);
                } catch (Exception ex){
                    Logger.getLogger(DlgListaAvatares.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(DlgListaAutos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAutos = new javax.swing.JTable();
        txt = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        nombreAuto = new javax.swing.JButton();
        niveles = new javax.swing.JButton();
        botVida = new javax.swing.JButton();
        experiencia = new javax.swing.JButton();
        cantEnemigos = new javax.swing.JButton();
        destruido = new javax.swing.JButton();
        armadura = new javax.swing.JButton();
        ataque = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaAutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Autos:", "Tipo Auto:", "Ataque:", "Armadura:", "Experiencia:", "Nivel:", "Vida:", "Enemigos Destruidos:", "Veces Destruido:"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaAutos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 562, 178));

        txt.setText("Ordenar por:");
        getContentPane().add(txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 202, 170, -1));

        nombreAuto.setBackground(new java.awt.Color(255, 255, 255));
        nombreAuto.setForeground(new java.awt.Color(0, 204, 204));
        nombreAuto.setText("Nombre");
        nombreAuto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nombreAuto.setContentAreaFilled(false);
        nombreAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreAutoActionPerformed(evt);
            }
        });

        niveles.setBackground(new java.awt.Color(255, 255, 255));
        niveles.setForeground(new java.awt.Color(0, 204, 204));
        niveles.setText("Nivel");
        niveles.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        niveles.setContentAreaFilled(false);
        niveles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nivelesActionPerformed(evt);
            }
        });

        botVida.setBackground(new java.awt.Color(255, 255, 255));
        botVida.setForeground(new java.awt.Color(0, 204, 204));
        botVida.setText("Vida");
        botVida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botVida.setContentAreaFilled(false);
        botVida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botVidaActionPerformed(evt);
            }
        });

        experiencia.setBackground(new java.awt.Color(255, 255, 255));
        experiencia.setForeground(new java.awt.Color(0, 204, 204));
        experiencia.setText("Experiencia");
        experiencia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        experiencia.setContentAreaFilled(false);
        experiencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                experienciaActionPerformed(evt);
            }
        });

        cantEnemigos.setBackground(new java.awt.Color(255, 255, 255));
        cantEnemigos.setForeground(new java.awt.Color(0, 204, 204));
        cantEnemigos.setText("Enemigos Destruidos");
        cantEnemigos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cantEnemigos.setContentAreaFilled(false);
        cantEnemigos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantEnemigosActionPerformed(evt);
            }
        });

        destruido.setBackground(new java.awt.Color(255, 255, 255));
        destruido.setForeground(new java.awt.Color(0, 204, 204));
        destruido.setText("Veces destruido");
        destruido.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        destruido.setContentAreaFilled(false);
        destruido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destruidoActionPerformed(evt);
            }
        });

        armadura.setBackground(new java.awt.Color(255, 255, 255));
        armadura.setForeground(new java.awt.Color(0, 204, 204));
        armadura.setText("Armadura");
        armadura.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        armadura.setContentAreaFilled(false);
        armadura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                armaduraActionPerformed(evt);
            }
        });

        ataque.setBackground(new java.awt.Color(255, 255, 255));
        ataque.setForeground(new java.awt.Color(0, 204, 204));
        ataque.setText("Ataque");
        ataque.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ataque.setContentAreaFilled(false);
        ataque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ataqueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nombreAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(niveles, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(experiencia, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(destruido, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(armadura, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(ataque, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(botVida, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cantEnemigos, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cantEnemigos, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botVida, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(experiencia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(armadura, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ataque, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(destruido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(niveles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(44, 44, 44))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 562, 120));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botVidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botVidaActionPerformed
        OrdenacionNombre ordenar = new OrdenacionNombre();
        contClicks3++;
        try{
            Nodo<NombreJugador> elemento = misAutos.obtenerElemento(numCelda);
            NombreJugador lista = elemento.obtenerContenido();
            NombreAuto[] ordenado = ordenar.ordenarVidaAs(lista.getMiLista());
            NombreAuto[] ordenado2 = ordenar.ordenarVidaDes(lista.getMiLista());
            DefaultTableModel dtmModel2 = (DefaultTableModel) tablaAutos.getModel();
            dtmModel2.setRowCount(0);
            Object[] fila = new Object[dtmModel2.getColumnCount()];           
            if(contClicks3%2!=0){
                for (NombreAuto nombre : ordenado) {
                    mostrarDatos(fila, nombre);
                    dtmModel2.addRow(fila);
                }                
            } else if (contClicks3%2==0){
                for (NombreAuto nombre : ordenado2) {
                    mostrarDatos(fila, nombre);
                    dtmModel2.addRow(fila);
                }
            }
        }catch(Exception e){
        }
    }//GEN-LAST:event_botVidaActionPerformed

    private void nombreAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreAutoActionPerformed
        OrdenacionNombre ordenar = new OrdenacionNombre();
        contClicks++;
        try{
            Nodo<NombreJugador> elemento = misAutos.obtenerElemento(numCelda);
            NombreJugador lista = elemento.obtenerContenido();
            NombreAuto[] ordenado = ordenar.ordenarNombreAs(lista.getMiLista());
            NombreAuto[] ordenado2 = ordenar.ordenarNombreDes(lista.getMiLista());
            DefaultTableModel dtmModel2 = (DefaultTableModel) tablaAutos.getModel();
            dtmModel2.setRowCount(0);
            Object[] fila = new Object[dtmModel2.getColumnCount()];           
            if(contClicks%2!=0){
                for (NombreAuto nombre : ordenado) {
                    mostrarDatos(fila, nombre);
                    dtmModel2.addRow(fila);
                }                
            } else if (contClicks%2==0){
                for (NombreAuto nombre : ordenado2) {
                    mostrarDatos(fila, nombre);
                    dtmModel2.addRow(fila);
                }
            }
        }catch(Exception e){
        }
    }//GEN-LAST:event_nombreAutoActionPerformed

    private void nivelesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nivelesActionPerformed
        OrdenacionNombre ordenar = new OrdenacionNombre();
        contClicks2++;
        try{
            Nodo<NombreJugador> elemento = misAutos.obtenerElemento(numCelda);
            NombreJugador lista = elemento.obtenerContenido();
            NombreAuto[] ordenado = ordenar.ordenarNivelAs(lista.getMiLista());
            NombreAuto[] ordenado2 = ordenar.ordenarNivelDes(lista.getMiLista());
            DefaultTableModel dtmModel2 = (DefaultTableModel) tablaAutos.getModel();
            dtmModel2.setRowCount(0);
            Object[] fila = new Object[dtmModel2.getColumnCount()];           
            if(contClicks2%2!=0){
                for (NombreAuto nombre : ordenado) {
                    mostrarDatos(fila, nombre);
                    dtmModel2.addRow(fila);
                }                
            } else if (contClicks2%2==0){
                for (NombreAuto nombre : ordenado2) {
                    mostrarDatos(fila, nombre);
                    dtmModel2.addRow(fila);
                }
            }
        }catch(Exception e){
        }
    }//GEN-LAST:event_nivelesActionPerformed

    private void experienciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_experienciaActionPerformed
        OrdenacionNombre ordenar = new OrdenacionNombre();
        contClicks4++;
        try{
            Nodo<NombreJugador> elemento = misAutos.obtenerElemento(numCelda);
            NombreJugador lista = elemento.obtenerContenido();
            NombreAuto[] ordenado = ordenar.ordenarXpAs(lista.getMiLista());
            NombreAuto[] ordenado2 = ordenar.ordenarXpDes(lista.getMiLista());
            DefaultTableModel dtmModel2 = (DefaultTableModel) tablaAutos.getModel();
            dtmModel2.setRowCount(0);
            Object[] fila = new Object[dtmModel2.getColumnCount()];           
            if(contClicks4%2!=0){
                for (NombreAuto nombre : ordenado) {
                    mostrarDatos(fila, nombre);
                    dtmModel2.addRow(fila);
                }                
            } else if (contClicks4%2==0){
                for (NombreAuto nombre : ordenado2) {
                    mostrarDatos(fila, nombre);
                    dtmModel2.addRow(fila);
                }
            }
        }catch(Exception e){
        }
    }//GEN-LAST:event_experienciaActionPerformed

    private void cantEnemigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantEnemigosActionPerformed
        OrdenacionNombre ordenar = new OrdenacionNombre();
        contClicks5++;
        try{
            Nodo<NombreJugador> elemento = misAutos.obtenerElemento(numCelda);
            NombreJugador lista = elemento.obtenerContenido();
            NombreAuto[] ordenado = ordenar.ordenarEnemAs(lista.getMiLista());
            NombreAuto[] ordenado2 = ordenar.ordenarEnemDes(lista.getMiLista());
            DefaultTableModel dtmModel2 = (DefaultTableModel) tablaAutos.getModel();
            dtmModel2.setRowCount(0);
            Object[] fila = new Object[dtmModel2.getColumnCount()];           
            if(contClicks5%2!=0){
                for (NombreAuto nombre : ordenado) {
                    mostrarDatos(fila, nombre);
                    dtmModel2.addRow(fila);
                }                
            } else if (contClicks5%2==0){
                for (NombreAuto nombre : ordenado2) {
                    mostrarDatos(fila, nombre);
                    dtmModel2.addRow(fila);
                }
            }
        }catch(Exception e){
        }
    }//GEN-LAST:event_cantEnemigosActionPerformed

    private void destruidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destruidoActionPerformed
        OrdenacionNombre ordenar = new OrdenacionNombre();
        contClicks6++;
        try{
            Nodo<NombreJugador> elemento = misAutos.obtenerElemento(numCelda);
            NombreJugador lista = elemento.obtenerContenido();
            NombreAuto[] ordenado = ordenar.ordenarDestruidoAs(lista.getMiLista());
            NombreAuto[] ordenado2 = ordenar.ordenarDestruidoDes(lista.getMiLista());
            DefaultTableModel dtmModel2 = (DefaultTableModel) tablaAutos.getModel();
            dtmModel2.setRowCount(0);
            Object[] fila = new Object[dtmModel2.getColumnCount()];           
            if(contClicks6%2!=0){
                for (NombreAuto nombre : ordenado) {
                    mostrarDatos(fila, nombre);
                    dtmModel2.addRow(fila);
                }                
            } else if (contClicks6%2==0){
                for (NombreAuto nombre : ordenado2) {
                    mostrarDatos(fila, nombre);
                    dtmModel2.addRow(fila);
                }
            }
        }catch(Exception e){
        }
    }//GEN-LAST:event_destruidoActionPerformed

    private void armaduraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_armaduraActionPerformed
        OrdenacionNombre ordenar = new OrdenacionNombre();
        contClicks7++;
        try{
            Nodo<NombreJugador> elemento = misAutos.obtenerElemento(numCelda);
            NombreJugador lista = elemento.obtenerContenido();
            NombreAuto[] ordenado = ordenar.ordenarArmaduraAs(lista.getMiLista());
            NombreAuto[] ordenado2 = ordenar.ordenarArmaduraDes(lista.getMiLista());
            DefaultTableModel dtmModel2 = (DefaultTableModel) tablaAutos.getModel();
            dtmModel2.setRowCount(0);
            Object[] fila = new Object[dtmModel2.getColumnCount()];           
            if(contClicks7%2!=0){
                for (NombreAuto nombre : ordenado) {
                    mostrarDatos(fila, nombre);
                    dtmModel2.addRow(fila);
                }                
            } else if (contClicks7%2==0){
                for (NombreAuto nombre : ordenado2) {
                    mostrarDatos(fila, nombre);
                    dtmModel2.addRow(fila);
                }
            }
        }catch(Exception e){
        }
    }//GEN-LAST:event_armaduraActionPerformed

    private void ataqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ataqueActionPerformed
        OrdenacionNombre ordenar = new OrdenacionNombre();
        contClicks8++;
        try{
            Nodo<NombreJugador> elemento = misAutos.obtenerElemento(numCelda);
            NombreJugador lista = elemento.obtenerContenido();
            NombreAuto[] ordenado = ordenar.ordenarAtaqueAs(lista.getMiLista());
            NombreAuto[] ordenado2 = ordenar.ordenarAtaqueDes(lista.getMiLista());
            DefaultTableModel dtmModel2 = (DefaultTableModel) tablaAutos.getModel();
            dtmModel2.setRowCount(0);
            Object[] fila = new Object[dtmModel2.getColumnCount()];           
            if(contClicks8%2!=0){
                for (NombreAuto nombre : ordenado) {
                    mostrarDatos(fila, nombre);
                    dtmModel2.addRow(fila);
                }                
            } else if (contClicks8%2==0){
                for (NombreAuto nombre : ordenado2) {
                    mostrarDatos(fila, nombre);
                    dtmModel2.addRow(fila);
                }
            }
        }catch(Exception e){
        }
    }//GEN-LAST:event_ataqueActionPerformed

    
    
    private void mostrarDatos(Object[] fila, NombreAuto nombre){
        fila[0] = nombre.getNombre();
        fila[1] = nombre.getTipoAuto();
        fila[2] = nombre.getAtaque();
        fila[3] = nombre.getArmadura();
        fila[4] = nombre.getExperiencia();
        fila[5] = nombre.getNivel();
        fila[6] = nombre.getVida();
        fila[7] = nombre.getEnemigosDestruidos();
        fila[8] = nombre.getAutoDestruido();
                    
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton armadura;
    private javax.swing.JButton ataque;
    private javax.swing.JButton botVida;
    private javax.swing.JButton cantEnemigos;
    private javax.swing.JButton destruido;
    private javax.swing.JButton experiencia;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton niveles;
    private javax.swing.JButton nombreAuto;
    public javax.swing.JTable tablaAutos;
    private javax.swing.JLabel txt;
    // End of variables declaration//GEN-END:variables
}
