/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.mavenproject1.Vista;

import com.mycompany.mavenproject1.Controlador.ComboItems;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;

public class vistaGestion extends javax.swing.JInternalFrame {

    vistaPrincipal padre;
    PreparedStatement ps;
    ResultSet rs;

    DefaultTableModel dtmCategoria;
    DefaultComboBoxModel dcbmCategoria;
    DefaultComboBoxModel dcbmArticulos;
    int idEmpleado;

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

        Border bordeC = new TitledBorder("Categoria");
        jcmbCategoria.setBorder(bordeC);
        Border bordeA = new TitledBorder("Articulos");
        jcbArticulos.setBorder(bordeA);

        this.dtmCategoria = (DefaultTableModel) this.jtGestion.getModel();
        this.dcbmCategoria = (DefaultComboBoxModel) this.jcmbCategoria.getModel();
        this.dcbmArticulos = (DefaultComboBoxModel) this.jcbArticulos.getModel();
        this.loadCategorias();
        this.loadArticulos(0);
        loadDatos(idEmpleado);
        System.out.println("Empleado" + idEmpleado);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jcbArticulos = new javax.swing.JComboBox<>();
        jcmbCategoria = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jtfEmpleado = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jtfFecha = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnPdf = new javax.swing.JButton();
        jpCentro = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtGestion = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Ventana Gestion");

        jPanel1.setLayout(new java.awt.BorderLayout());

        jcbArticulos.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                jcbArticulosCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        jPanel3.add(jcbArticulos);

        jcmbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmbCategoriaActionPerformed(evt);
            }
        });
        jPanel3.add(jcmbCategoria);

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

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);

        btnPdf.setText("Generar reporte");
        btnPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPdfActionPerformed(evt);
            }
        });
        jPanel3.add(btnPdf);

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jpCentro.setLayout(new java.awt.BorderLayout());

        jtGestion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Apellido P", "Apellido M", "Articulo", "Descripcion", "Modelo", "Marca", "NumSerie", "Fecha Entrega"
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

    private void jcbArticulosCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jcbArticulosCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbArticulosCaretPositionChanged

    private void jcmbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmbCategoriaActionPerformed

        ComboItems oCategoria = (ComboItems) this.jcmbCategoria.getSelectedItem();

        if (this.jcmbCategoria.getSelectedItem() != null) {
            this.loadArticulos(Integer.parseInt(oCategoria.getKey()));
        }

    }//GEN-LAST:event_jcmbCategoriaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        agregar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPdfActionPerformed
     crearreporte();
    }//GEN-LAST:event_btnPdfActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnPdf;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox<String> jcbArticulos;
    private javax.swing.JComboBox<String> jcmbCategoria;
    private javax.swing.JPanel jpCentro;
    private javax.swing.JTable jtGestion;
    public static javax.swing.JTextField jtfEmpleado;
    private javax.swing.JTextField jtfFecha;
    // End of variables declaration//GEN-END:variables

    public void loadDatos(int idEmpleado) {
        System.out.println("Hola" + idEmpleado);
        String sQuery = "";

        if (idEmpleado <= 0) {
            sQuery = """
                        select Empleado.idEmpleado as idEmpleado, Empleado.nombre as nombre, Empleado.apellidoPaterno as apellidoPaterno,
                        Empleado.apellidoMaterno as apellidoMaterno,  Articulos.nombreA as nombreA,Articulos.descrip as descrip,
                        Articulos.marca as marca, Articulos.modelo as modelo, Articulos.numSerie as numserie,
                        Gestion.fechaEntrega from Gestion inner join Empleado on Empleado.idEmpleado = Gestion.idEmpleado 
                        inner join Articulos on Articulos.idArticulo = Gestion.idArticulo
                        """;
        } else {
            sQuery = String.format("""
                   select Empleado.idEmpleado as idEmpleado, Empleado.nombre as nombre, Empleado.apellidoPaterno as apellidoPaterno,
                   Empleado.apellidoMaterno as apellidoMaterno, Articulos.nombreA as nombreA,Articulos.descrip as descrip,
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
//                System.out.println("Consulta" + sQuery);
                this.dtmCategoria.setRowCount(0);
                while (rs.next()) {
                    this.dtmCategoria.addRow(new Object[]{
                        rs.getString("idEmpleado"),
                        rs.getString("nombre"),
                        rs.getString("apellidoPaterno"),
                        rs.getString("apellidoMaterno"),
                        rs.getString("nombreA"),
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

    private void loadCategorias() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sQuery = "SELECT idCategoria,nombreCategoria FROM Categoria";
        if (this.padre.db.conn != null) {
            try {
                ps = this.padre.db.conn.prepareStatement(sQuery, ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                rs = ps.executeQuery();
                while (rs.next()) {
                    this.dcbmCategoria.addElement(
                            new ComboItems(Integer.toString(
                                    rs.getInt("idCategoria")), rs.getString("nombreCategoria")));
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private void loadArticulos(int id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sQuery = "";
        System.out.println("recibo " + id);
        if (id <= 0) {
            sQuery = "select idArticulo, nombreA  from Articulos";
        } else {
            sQuery = String.format("select idArticulo, nombreA  from Articulos where idCategoria = %d", id);
        }
        if (this.padre.db.conn != null) {
            try {
                ps = this.padre.db.conn.prepareStatement(sQuery, ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                rs = ps.executeQuery();

                this.dcbmArticulos.removeAllElements();

                while (rs.next()) {
                    this.dcbmArticulos.addElement(new ComboItems(Integer.toString(rs.getInt("idArticulo")), rs.getString("nombreA")));
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    void agregar() {
        String sQuery = "insert into Gestion (idEmpleado,idArticulo,fechaEntrega) values(?,?,?)";
        ComboItems oArt = (ComboItems) this.jcbArticulos.getSelectedItem();
        int idArticulos = 0;

        if (this.jcbArticulos.getSelectedItem() != null) {
            idArticulos = Integer.parseInt(oArt.getKey());
        }

        if (this.padre.db.conn != null) {
            try {
                ps = this.padre.db.conn.prepareStatement(sQuery,
                        ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                ps.setInt(1, this.idEmpleado);
                ps.setInt(2, idArticulos);
                ps.setString(3, jtfFecha.getText());
                ps.execute();
                loadDatos(this.idEmpleado);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static String getFecha() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String date = simpleDateFormat.format(new Date());
        return date;
    }

    private void crearreporte() {
           Document doc = new Document();
        try {
            String ruta = System.getProperty("user.home"); //Toma la raiz
            PdfWriter.getInstance(doc, new FileOutputStream(ruta + "/Documents/ReporteALO.pdf"));
            doc.open(); //Abrio el documento pdf
            PdfPTable tabla = new PdfPTable(10);
            
            tabla.addCell("ID");
            tabla.addCell("Nombre");
            tabla.addCell("apellidoPaterno");
            tabla.addCell("apellidoMaterno");
            tabla.addCell("nombreA");
            tabla.addCell("descrip");
            tabla.addCell("marca");
            tabla.addCell("modelo");
            tabla.addCell("numSerie");
            tabla.addCell("fechaEntrega");
            tabla.isExtendLastRow(true);
            if (this.padre.db.conn != null) {
                try {
                    String sQuery = """
                        select Empleado.idEmpleado as idEmpleado, Empleado.nombre as nombre, Empleado.apellidoPaterno as apellidoPaterno,
                        Empleado.apellidoMaterno as apellidoMaterno,  Articulos.nombreA as nombreA,Articulos.descrip as descrip,
                        Articulos.marca as marca, Articulos.modelo as modelo, Articulos.numSerie as numserie,
                        Gestion.fechaEntrega from Gestion inner join Empleado on Empleado.idEmpleado = Gestion.idEmpleado 
                        inner join Articulos on Articulos.idArticulo = Gestion.idArticulo
                        """;
                    ps = this.padre.db.conn.prepareStatement(sQuery, ResultSet.TYPE_SCROLL_SENSITIVE,
                            ResultSet.CONCUR_READ_ONLY);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        do {                            
                            tabla.addCell(rs.getString(1));
                            tabla.addCell(rs.getString(2));
                            tabla.addCell(rs.getString(3));
                            tabla.addCell(rs.getString(4));
                            tabla.addCell(rs.getString(5));
                            tabla.addCell(rs.getString(6));
                            tabla.addCell(rs.getString(7));
                            tabla.addCell(rs.getString(8));
                            tabla.addCell(rs.getString(9));
                            tabla.addCell(rs.getString(10));
                        } while (rs.next());
                        
                        doc.add(tabla);
                    }
                        
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            doc.close();
            JOptionPane.showMessageDialog(this, "Reporte Creado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Reporte en uso", "Error",JOptionPane.ERROR_MESSAGE);
        }
    }

}
