package com.mycompany.mavenproject1.Vista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class vistaCategoria extends javax.swing.JDialog {

    DefaultTableModel dtmCategoria;
    vistaPrincipal padre;
    PreparedStatement ps;
    ResultSet rs;
    Connection cn;
    int id ;
    String nombre;

    public vistaCategoria(vistaPrincipal padre, boolean modal) {
        super(padre, modal);
        this.padre = padre;

        initComponents();
        setTitle("Categoria");
        Border borde = new TitledBorder("Categoria");
        jtfCategoria.setBorder(borde);
        jtfCategoria.setColumns(20);
        this.dtmCategoria = (DefaultTableModel) this.jtCategoria.getModel();

        loadDatos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jtfCategoria = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtCategoria = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.add(jtfCategoria);

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1904677-add-addition-calculate-charge-create-new-plus_122527.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregar);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pencil-striped-symbol-for-interface-edit-buttons_icon-icons.com_56782.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jtCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Categoria"
            }
        ));
        jtCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtCategoriaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtCategoria);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        agregarDatos();
        jtfCategoria.setText("");
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jtCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtCategoriaMouseClicked
         try {
             this.rs.absolute(this.jtCategoria.getSelectedRow() + 1);
            this.id = this.rs.getInt("idCategoria");
            this.nombre = this.rs.getString("nombreCategoria");
            jtfCategoria.setText(this.nombre);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jtCategoriaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        modificar(id);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtCategoria;
    private javax.swing.JTextField jtfCategoria;
    // End of variables declaration//GEN-END:variables

    private void loadDatos() {
        String sQuery = """
                       SELECT idCategoria, nombreCategoria FROM Categoria
                        """;
        if (this.padre.db.conn != null) {
            try {
                ps = this.padre.db.conn.prepareStatement(sQuery, ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                rs = ps.executeQuery();

                this.dtmCategoria.setRowCount(0);
                while (rs.next()) {
                    this.dtmCategoria.addRow(new Object[]{
                        rs.getString("idCategoria"),
                        rs.getString("nombreCategoria")
                    });
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private void agregarDatos() {
        String sQuery = """
                        insert into Categoria (nombreCategoria) values (?) 
                        
                        """;
        if (this.padre.db.conn != null) {
            try {
                ps = this.padre.db.conn.prepareStatement(sQuery, ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                ps.setString(1, jtfCategoria.getText().toUpperCase());
                ps.execute(); //no regresa un conjunto de resultados update Departamento set nombreDepartamento = ? where  idDepartamento = ?
                loadDatos();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Ya existe el departamento", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    void modificar(int id){
          String sQuery = "UPDATE Categoria set nombreCategoria = ? where idCategoria = ?";
        if (this.padre.db.conn != null) {
            try {
                ps = this.padre.db.conn.prepareStatement(sQuery, ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                ps.setString(1, jtfCategoria.getText().toUpperCase());
                ps.setInt(2, id);
                ps.executeUpdate();
                loadDatos();
                jtfCategoria.setText("");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
