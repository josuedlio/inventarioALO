package com.mycompany.mavenproject1.Vista;

import com.mycompany.mavenproject1.ConexionSQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;


public class vistaCatalogoEmpleado extends javax.swing.JDialog {

    vistaGestion padre;
    
    DefaultTableModel dtmEmpleados;
    

    ResultSet rs;
    PreparedStatement ps;
    
    ConexionSQL db = new ConexionSQL();

    public vistaCatalogoEmpleado(vistaGestion padre, boolean modal) {
        super(padre.padre, modal);
        this.padre = padre;
       
        initComponents();
        this.dtmEmpleados = (DefaultTableModel) jTable1.getModel();
        loadDatos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Apellido Paterno", "Apellido Materno"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        try {
            this.rs.absolute(this.jTable1.getSelectedRow() + 1);
            this.padre.idEmpleado = this.rs.getInt("idEmpleado");
            this.padre.loadDatos(this.rs.getInt("idEmpleado"));
            dispose();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    void loadDatos() {
        String sQuery = "select idEmpleado,nombre, apellidoPaterno, apellidoMaterno from Empleado";
        
        if (this.padre.padre.db.conn != null) {
            try {
                ps = this.padre.padre.db.conn.prepareStatement(sQuery, ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                rs = ps.executeQuery();

                this.dtmEmpleados.setRowCount(0);
                while (rs.next()) {
                    this.dtmEmpleados.addRow(new Object[]{
                        rs.getInt("idEmpleado"),
                        rs.getString("nombre"),
                        rs.getString("apellidoPaterno"),
                        rs.getString("apellidoMaterno"),});
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
