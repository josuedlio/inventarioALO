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
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtCategoria = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.add(jtfCategoria);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregar);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jtCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Categoria"
            }
        ));
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
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
}
