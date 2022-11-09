/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.mavenproject1.Vista;

import com.mycompany.mavenproject1.ConexionSQL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author infraver
 */
public class vistaDepartamento extends javax.swing.JDialog {

    public DefaultTableModel dtmDepartamento;
    vistaPrincipal padre;
    PreparedStatement ps;
    ResultSet rs;
    Connection cn;
    CallableStatement cts;

    int id;
    private String nombreDepto;

    public vistaDepartamento(vistaPrincipal padre, boolean modal) {
        super(padre, modal);
        this.padre = padre;
        initComponents();
        setTitle("Departamentos");
        Border borde = new TitledBorder("Departamento");

        jtfDepartamento.setBorder(borde);
        jtfDepartamento.setColumns(15);

        this.dtmDepartamento = (DefaultTableModel) this.jTablaDepartamento.getModel();
        loadDatos();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jpPrincipal = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jtfDepartamento = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaDepartamento = new javax.swing.JTable();

        jButton1.setText("jButton1");

        jpPrincipal.setLayout(new java.awt.BorderLayout());

        jPanel2.add(jtfDepartamento);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregar);

        btnActualizar.setText("Actualizar");
        btnActualizar.setEnabled(false);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel2.add(btnActualizar);

        btnBorrar.setText("Borrar");
        btnBorrar.setEnabled(false);
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnBorrar);

        jpPrincipal.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jTablaDepartamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Departamento"
            }
        ));
        jTablaDepartamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaDepartamentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablaDepartamento);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jpPrincipal.add(jPanel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jpPrincipal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (jtfDepartamento.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Campo vacio", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            agregarDatos();
            jtfDepartamento.setText("");
            loadDatos();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jTablaDepartamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaDepartamentoMouseClicked
        try {
            this.rs.absolute(this.jTablaDepartamento.getSelectedRow() + 1);
            this.id = this.rs.getInt("idDepartamento");
            this.nombreDepto = this.rs.getString("nombreDepartamento");

            this.jtfDepartamento.setText(this.nombreDepto);

            System.out.println("idDepartamento---->" + id);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jTablaDepartamentoMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (jtfDepartamento.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Campo vacio", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            actualizarDatos(this.id);
            loadDatos();
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        borrar(this.id);
        loadDatos();
    }//GEN-LAST:event_btnBorrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTablaDepartamento;
    private javax.swing.JPanel jpPrincipal;
    public javax.swing.JTextField jtfDepartamento;
    // End of variables declaration//GEN-END:variables

    private void agregarDatos() {
        String sQuery = """
                        insert into Departamento (nombreDepartamento) values (?) 
                        
                        """;
        if (this.padre.db.conn != null) {
            try {
                ps = this.padre.db.conn.prepareStatement(sQuery, ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                ps.setString(1, jtfDepartamento.getText().toUpperCase());
                ps.execute(); //no regresa un conjunto de resultados update Departamento set nombreDepartamento = ? where  idDepartamento = ?
                loadDatos();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Ya existe el departamento", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void actualizarDatos(Integer id) {
        String sQuery = "update Departamento set nombreDepartamento = ? where  idDepartamento = ?";
        if (this.padre.db.conn != null) {
            try {
                ps = this.padre.db.conn.prepareStatement(sQuery, ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                ps.setString(1, jtfDepartamento.getText().toUpperCase());
                ps.setInt(2, id);
                ps.executeUpdate(); //no regresa un conjunto de resultados update Departamento set nombreDepartamento = ? where  idDepartamento = ?
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "No puedes actualizar ya existe un departamento con ese nombre", "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println(e);
            }
        }
    }

    private void borrar(Integer id) {
        String sQuery = "delete from Departamento where idDepartamento = ?";
        if (this.padre.db.conn != null) {
            try {
                ps = this.padre.db.conn.prepareStatement(sQuery, ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                ps.setInt(1, id);
                ps.executeUpdate(); //no regresa un conjunto de resultados update Departamento set nombreDepartamento = ? where  idDepartamento = ?
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "No puedes borrar este departamento", "Error", JOptionPane.ERROR_MESSAGE);

            }
        }
    }

    private void loadDatos() {
        String sQuery = """
                       SELECT idDepartamento, nombreDepartamento FROM Departamento
                        """;
        if (this.padre.db.conn != null) {
            try {
                ps = this.padre.db.conn.prepareStatement(sQuery, ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                rs = ps.executeQuery();

                this.dtmDepartamento.setRowCount(0);
                while (rs.next()) {
                    this.dtmDepartamento.addRow(new Object[]{
                        rs.getString("idDepartamento"),
                        rs.getString("nombreDepartamento")
                    });
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
