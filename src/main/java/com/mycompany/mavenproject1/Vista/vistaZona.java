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

public class vistaZona extends javax.swing.JDialog {

    vistaPrincipal padre;
    DefaultTableModel dtmZona;
    PreparedStatement ps;
    ResultSet rs;

    public vistaZona(vistaPrincipal padre, boolean modal) {
        super(padre, modal);
        this.padre = padre;
        initComponents();
        setTitle("Zona");
        Border zona = new TitledBorder("Nombre Zona");
        jtfnombreZona.setBorder(zona);
        jtfnombreZona.setColumns(8);
        Border zonaS = new TitledBorder("Sigla");
       
        
        

        this.dtmZona = (DefaultTableModel) this.jtZona.getModel();
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

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jtfnombreZona = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtZona = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.add(jtfnombreZona);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel3.add(btnAgregar);

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jtZona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Zona", "Acronimo"
            }
        ));
        jScrollPane1.setViewportView(jtZona);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (jtfnombreZona.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tienes el campo vacio", "Campo vacio", JOptionPane.ERROR_MESSAGE);
        }else{
        agregar();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtZona;
    private javax.swing.JTextField jtfnombreZona;
    // End of variables declaration//GEN-END:variables

    private void loadDatos() {
        String sQuery = """
                        Select idZona, nombreZona, sigla from Zona order by idZona
                        """;

        if (this.padre.db.conn != null) {
            try {
                ps = this.padre.db.conn.prepareStatement(sQuery, ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                rs = ps.executeQuery();

                this.dtmZona.setRowCount(0);
                while (rs.next()) {
                    this.dtmZona.addRow(new Object[]{
                        rs.getString("idZona"),
                        rs.getString("nombreZona"),
                        rs.getString("sigla")
                    });
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Hubo un error", "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println(e);
            }
        }
    }

    private void agregar() {
        String sQuery = """
                        insert into Zona (nombreZona, sigla) values(?,?)
                        """;
        if (this.padre.db.conn != null) {
            try {
                ps = this.padre.db.conn.prepareStatement(sQuery, ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                ps.setString(1, jtfnombreZona.getText().toUpperCase());
                ps.setString(2, jtfnombreZona.getText().substring(0,3).toUpperCase());
                ps.execute(); //no regresa un conjunto de resultados update Departamento set nombreDepartamento = ? where  idDepartamento = ?
                loadDatos();
                jtfnombreZona.setText("");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Tienes un error", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }

}
