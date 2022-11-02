/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.mavenproject1.Vista;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class vistaGestion extends javax.swing.JInternalFrame {

    vistaPrincipal padre;
    PreparedStatement ps;
    ResultSet rs;

    DefaultTableModel dtmCategoria;

    int idEmpleado;
    
    private String apellidoP,nombre;

    public vistaGestion(vistaPrincipal padre) {
        initComponents();
        setTitle("Gestion");
        this.padre = padre;
        Border borde = new TitledBorder("Nombre empleado");
        jtfEmpleado.setBorder(borde);
        jtfEmpleado.setColumns(13);
        Border bordeF = new TitledBorder("Fecha de entrega");
        jtfFecha.setBorder(bordeF);
        jtfFecha.setColumns(10);
        jtfFecha.setText(getFecha());

        this.dtmCategoria = (DefaultTableModel) this.jtGestion.getModel();
        loadDatos(idEmpleado);
        System.out.println("Empleado"+idEmpleado);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jcmboCategoria = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jtfEmpleado = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jtfFecha = new javax.swing.JTextField();
        jpCentro = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtGestion = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Ventana Gestion");

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.add(jcmboCategoria);

        jLabel1.setText("Nombre");
        jPanel3.add(jLabel1);
        jPanel3.add(jtfEmpleado);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel3.add(btnBuscar);

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel3.add(jSeparator1);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel3.add(jSeparator2);
        jPanel3.add(jtfFecha);

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jpCentro.setLayout(new java.awt.BorderLayout());

        jtGestion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Apellido P", "Apellido M", "Descripcion", "Modelo", "Marca", "NumSerie", "Fecha Entrega"
            }
        ));
        jScrollPane2.setViewportView(jtGestion);

        jpCentro.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel1.add(jpCentro, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        vistaCatalogoEmpleado vce = new vistaCatalogoEmpleado(this, closable);
        vce.setVisible(true);
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox<String> jcmboCategoria;
    private javax.swing.JPanel jpCentro;
    private javax.swing.JTable jtGestion;
    public static javax.swing.JTextField jtfEmpleado;
    private javax.swing.JTextField jtfFecha;
    // End of variables declaration//GEN-END:variables

    public void loadDatos(int idEmpleado) {
        System.out.println("Hola"+idEmpleado);
        String sQuery = "";

        if (idEmpleado <= 0) {
            sQuery = """
                        select Empleado.idEmpleado as idEmpleado, Empleado.nombre as nombre, Empleado.apellidoPaterno as apellidoPaterno,
                        Empleado.apellidoMaterno as apellidoMaterno, Articulos.descrip as descrip,
                        Articulos.marca as marca, Articulos.modelo as modelo, Articulos.numSerie as numserie,
                        Gestion.fechaEntrega from Gestion inner join Empleado on Empleado.idEmpleado = Gestion.idEmpleado 
                        inner join Articulos on Articulos.idArticulo = Gestion.idArticulo
                        """;
        } else {
            sQuery = String.format("""
                   select Empleado.idEmpleado as idEmpleado, Empleado.nombre as nombre, Empleado.apellidoPaterno as apellidoPaterno,
                   Empleado.apellidoMaterno as apellidoMaterno, Articulos.descrip as descrip,
                   Articulos.marca as marca, Articulos.modelo as modelo, Articulos.numSerie as numserie,
                   Gestion.fechaEntrega from Gestion inner join Empleado on Empleado.idEmpleado = Gestion.idEmpleado 
                   inner join Articulos on Articulos.idArticulo = Gestion.idArticulo where Empleado.idEmpleado = %d
                   """, idEmpleado);
        }

        if (this.padre.db.conn != null) {
            try {
                ps = this.padre.db.conn.prepareStatement(sQuery, ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                rs = ps.executeQuery();
                System.out.println("Consulta" + sQuery);
                this.dtmCategoria.setRowCount(0);
                while (rs.next()) {
                    this.dtmCategoria.addRow(new Object[]{
                        rs.getString("idEmpleado"),
                        rs.getString("nombre"),
                        rs.getString("apellidoPaterno"),
                        rs.getString("apellidoMaterno"),
                        rs.getString("descrip"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("numSerie"),
                        rs.getString("fechaEntrega")
                        
                    });
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    public static String getFecha() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String date = simpleDateFormat.format(new Date());
        return date;
    }
        
}
