
package clientes;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Formulario_clientes extends javax.swing.JFrame {
   
    DefaultTableModel model;
    
    Conex cc = new Conex(); // Llamamos la conexion global
    Connection cn = cc.getConexion(); // invocamos su metodo 
    
    public Formulario_clientes() {
        initComponents();
        limpiar();
        llenarCombo();
        cargar("");
        this.setLocationRelativeTo(null); // muestra la tabla en el centro de la pantalla
        
        setResizable(false);
    }
      
    
    void cargar(String valor){
        
        String [] titulos = {"Codigo","Nombre","Apellido","Ciudad","Telefono","Rol"};
        String [] registros = new String [5];
        model = new DefaultTableModel(null,titulos);
       
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM clientes where nom_cli LIKE '%"+valor+"%'");
            
            while(rs.next()){
                registros [0] = rs.getString("cod_cli");
                registros [1] = rs.getString("nom_cli");
                registros [2] = rs.getString("ape_cli");
                registros [3] = rs.getString("ciu_cli");
                registros [4] = rs.getString("tel_cli");
                model.addRow(registros);
            }
            
            t_datos.setModel(model);
            
        }catch (Exception e){
            //JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
        }        
    }
    
    
    
    void limpiar(){
        t_nom.setText("");
        t_ape.setText("");
        t_ciu.setText("");
        t_tel.setText("");
        t_nom.requestFocus();
    }
    
    private void llenarCombo() {
        combo1.removeAllItems(); // borrar contenido original de combo
        try {
            String sqlSelect = "SELECT * FROM rol";
            PreparedStatement pstm = cn.prepareStatement(sqlSelect);
            ResultSet datos = pstm.executeQuery();
            
            while (datos.next()) {
                combo1.addItem(datos.getString("id")+" - "+datos.getString("nom_rol"));
            }
        } catch (SQLException e) {
          JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Informacion Error", 0);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_guardar = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();
        t_nom = new javax.swing.JTextField();
        t_ape = new javax.swing.JTextField();
        t_ciu = new javax.swing.JTextField();
        t_tel = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_datos = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        aux = new javax.swing.JTextField();
        btn_eliminar = new javax.swing.JButton();
        btn_Actualizar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        combo1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("INGRESO DE CLIENTES");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("NOMBRE:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("APELLIDO:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("CIUDAD:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("TELEFONO:");

        btn_guardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        btn_salir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_salir.setText("Salir");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });

        t_nom.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        t_nom.setText("jTextField1");
        t_nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_nomActionPerformed(evt);
            }
        });

        t_ape.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        t_ape.setText("jTextField1");
        t_ape.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_apeActionPerformed(evt);
            }
        });

        t_ciu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        t_ciu.setText("jTextField1");
        t_ciu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_ciuActionPerformed(evt);
            }
        });

        t_tel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        t_tel.setText("jTextField1");
        t_tel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_telActionPerformed(evt);
            }
        });

        t_datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        t_datos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_datosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(t_datos);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("BUSCAR POR NOMBRE:");

        aux.setBackground(new java.awt.Color(204, 255, 255));
        aux.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        aux.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                auxActionPerformed(evt);
            }
        });
        aux.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                auxKeyReleased(evt);
            }
        });

        btn_eliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        btn_Actualizar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_Actualizar.setText("Actualizar");
        btn_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ActualizarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("ROL:");

        combo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(120, 120, 120))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t_nom, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(t_ape)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(t_ciu, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(combo1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(t_tel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Actualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aux)))
                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(t_nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(t_ape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(t_ciu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(t_tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(combo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_guardar)
                    .addComponent(btn_salir)
                    .addComponent(btn_eliminar)
                    .addComponent(btn_Actualizar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btn_salirActionPerformed

    private void t_nomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_nomActionPerformed
        // TODO add your handling code here:
        t_nom.transferFocus();
    }//GEN-LAST:event_t_nomActionPerformed

    private void t_apeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_apeActionPerformed
        // TODO add your handling code here:
        t_ape.transferFocus();
    }//GEN-LAST:event_t_apeActionPerformed

    private void t_ciuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_ciuActionPerformed
        // TODO add your handling code here:
        t_ciu.transferFocus();
    }//GEN-LAST:event_t_ciuActionPerformed

    private void t_telActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_telActionPerformed
        // TODO add your handling code here:
        t_tel.transferFocus();
    }//GEN-LAST:event_t_telActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
         
         String nom,ape,cui,tel,com; // creacion de variables para guardar informacion
         
         nom = t_nom.getText();
         ape = t_ape.getText();
         cui = t_ciu.getText();
         tel = t_tel.getText();
         //com = combo1.getSelectedItem().toString();
         
         // codigo para obligar a llena las cajas de texto
         if (   this.t_nom.getText().isEmpty()
             || this.t_ape.getText().isEmpty()
             || this.t_ciu.getText().isEmpty()
             || this.t_tel.getText().isEmpty())
         {
             JOptionPane.showMessageDialog(this, "Todos los campos son obligatirio");
             return;
         }
         
         
         try{
             PreparedStatement pstm = cn.prepareStatement("INSERT INTO clientes (nom_cli,ape_cli,ciu_cli,tel_cli) VALUES (?,?,?,?)");
             //PreparedStatement pstm2 = cn.prepareStatement("INSERT INTO rol (non_rol) VALUES (?)");
             pstm.setString(1, nom);
             pstm.setString(2, ape);
             pstm.setString(3, cui);
             pstm.setString(4, tel);
             //pstm2.setString(5, com);
             pstm.executeUpdate();
             
             JOptionPane.showMessageDialog(null, "Registro Guardado");
             limpiar();
             cargar("");
             
         }catch (Exception e){
             System.out.println(e);
         }
         
         limpiar();
             
        
         
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void auxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_auxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_auxActionPerformed

    private void auxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_auxKeyReleased
        // TODO add your handling code here:
        cargar(aux.getText());
    }//GEN-LAST:event_auxKeyReleased

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        // TODO add your handling code here:
        
        
         
        boolean hayResultado = false;
        int resulCliente = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese Codigo del Usuario", "Informacion Unica", 3));
        String sqlSelect = "SELECT * FROM clientes WHERE cod_cli = ?";
        String sqlDelete = "DELETE FROM clientes WHERE cod_cli = ?";
        try {
            PreparedStatement pstm = cn.prepareStatement(sqlSelect);
            PreparedStatement pstmDelete = cn.prepareStatement(sqlDelete);
            pstm.setInt(1, resulCliente);
            ResultSet datos = pstm.executeQuery();

            while (datos.next()) {
                hayResultado = true;
                break;
            }

            if (hayResultado) {
                int confirmacion = JOptionPane.showConfirmDialog(null,
                    "Desea Eliminarlo?", "Seleccione", JOptionPane.YES_NO_OPTION);

                if (confirmacion == 0) {
                    pstmDelete.setInt(1, resulCliente);
                    pstmDelete.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Registro Eliminado satisfactoriamente","Informe",1);
                    cargar("");
                }

            } else {
                JOptionPane.showMessageDialog(null, "No se encontro registro", "Informe", 0);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ActualizarActionPerformed
         // TODO add your handling code here:
         
         if (   this.t_nom.getText().isEmpty()
             || this.t_ape.getText().isEmpty()
             || this.t_ciu.getText().isEmpty()
             || this.t_tel.getText().isEmpty())
         {
             JOptionPane.showMessageDialog(this, "Debe selecionar un Usuario de la lista");
             return;
         }
       
        
        String sqlUpdate = "UPDATE clientes set nom_cli=?, ape_cli=?, ciu_cli=?, tel_cli=? WHERE cod_cli = ?";
        
        int filaSelecionada=t_datos.getSelectedRow();
        String dao =(String)t_datos.getValueAt(filaSelecionada, 0);
        
        try {
            PreparedStatement pstmUpdate = cn.prepareStatement(sqlUpdate);
            pstmUpdate.setString(1, t_nom.getText());
            pstmUpdate.setString(2, t_ape.getText());
            pstmUpdate.setString(3, t_ciu.getText());
            pstmUpdate.setString(4, t_tel.getText());
            
            pstmUpdate.setString(5,dao);
        
            pstmUpdate.executeUpdate();
            JOptionPane.showMessageDialog(this, "Registro Actualizado Correctamente","Informacion",1);
            cargar("");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
    }//GEN-LAST:event_btn_ActualizarActionPerformed

    private void t_datosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_datosMouseClicked
        // TODO add your handling code here:
        int selecionar = t_datos.rowAtPoint(evt.getPoint());
        t_nom.setText(String.valueOf(t_datos.getValueAt(selecionar, 1)));
        t_ape.setText(String.valueOf(t_datos.getValueAt(selecionar, 2)));
        t_ciu.setText(String.valueOf(t_datos.getValueAt(selecionar, 3)));
        t_tel.setText(String.valueOf(t_datos.getValueAt(selecionar, 4)));
        
    }//GEN-LAST:event_t_datosMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Formulario_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formulario_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formulario_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulario_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Formulario_clientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aux;
    private javax.swing.JButton btn_Actualizar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_salir;
    private javax.swing.JComboBox<String> combo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField t_ape;
    private javax.swing.JTextField t_ciu;
    private javax.swing.JTable t_datos;
    private javax.swing.JTextField t_nom;
    private javax.swing.JTextField t_tel;
    // End of variables declaration//GEN-END:variables

    

    
}
