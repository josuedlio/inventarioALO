/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.mavenproject1.Vista;

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
public class vistaMarca extends javax.swing.JDialog {

    vistaPrincipal padre;
    DefaultTableModel dtmMarca;
    PreparedStatement ps;
    ResultSet rs;

    public vistaMarca(vistaPrincipal padre, boolean modal) {
        super(padre, modal);
        this.padre = padre;
        initComponents();
        setTitle("Marcas");
        Border borde = new TitledBorder("Nombre Marca");
        jtfMarca.setBorder(borde);
        jtfMarca.setColumns(10);

        this.dtmMarca = (DefaultTableModel) this.TablaMarca.getModel();

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

        jPanel2 = new javax.swing.JPanel();
        jtfMarca = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaMarca = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jtfMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfMarcaActionPerformed(evt);
            }
        });
        jPanel2.add(jtfMarca);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1904677-add-addition-calculate-charge-create-new-plus_122527.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.BorderLayout());

        TablaMarca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre"
            }
        ));
        jScrollPane1.setViewportView(TablaMarca);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfMarcaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jtfMarca.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Campo vacio", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            agregar();
            jtfMarca.setText("");
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaMarca;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtfMarca;
    // End of variables declaration//GEN-END:variables

    private void loadDatos() {
        String sQuery = "select idMarca, nombreMarca from Marca";
        if (this.padre.db.conn != null) {
            try {
                ps = this.padre.db.conn.prepareStatement(sQuery, ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                rs = ps.executeQuery();

                this.dtmMarca.setRowCount(0);
                while (rs.next()) {
                    this.dtmMarca.addRow(new Object[]{
                        rs.getString("idMarca"),
                        rs.getString("nombreMarca")
                    });
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    private void agregar() {
        String sQuery = "insert into Marca (nombreMarca) values (?)";
        if (this.padre.db.conn != null) {
            try {
                ps = this.padre.db.conn.prepareStatement(sQuery, ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                ps.setString(1, jtfMarca.getText().toUpperCase());
                ps.execute(); //no regresa un conjunto de resultados update Departamento set nombreDepartamento = ? where  idDepartamento = ?
                loadDatos();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Tienes un error", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
