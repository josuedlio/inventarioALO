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
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;
import java.io.FileOutputStream;
import java.io.IOException;
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
        jtfEmpleado.setColumns(20);
        Border bordeF = new TitledBorder("Fecha de entrega");
        jtfFecha.setBorder(bordeF);
        jtfFecha.setColumns(10);
        jtfFecha.setText(getFecha());
        Border bordeM = new TitledBorder("Motivo");
        jtfMotivo.setBorder(bordeM);
        Border bordeCant = new TitledBorder("Cantidad");
        jtfCantidad.setBorder(bordeCant);
        jtfCantidad.setColumns(6);

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
        jtfCantidad = new javax.swing.JTextField();
        jtfFecha = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnPdf = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jpCentro = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtGestion = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtfMotivo = new javax.swing.JTextArea();

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

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/seo-social-web-network-internet_340_icon-icons.com_61497 (1).png"))); // NOI18N
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

        jtfCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfCantidadKeyTyped(evt);
            }
        });
        jPanel3.add(jtfCantidad);
        jPanel3.add(jtfFecha);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1904677-add-addition-calculate-charge-create-new-plus_122527.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);

        btnPdf.setIcon(new javax.swing.ImageIcon("C:\\Users\\infraver\\OneDrive - AUTOMOTIVE LOGISTICS S.C\\Desktop\\Nueva carpeta\\mavenproject1\\src\\main\\resources\\imagenes\\editdocument_105148.png")); // NOI18N
        btnPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPdfActionPerformed(evt);
            }
        });
        jPanel3.add(btnPdf);
        jPanel3.add(jSeparator3);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnreset.png"))); // NOI18N
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jpCentro.setLayout(new java.awt.BorderLayout());

        jtGestion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido P", "Apellido M", "Articulo", "Modelo", "Motivo", "Cantidad", "Fecha Entrega"
            }
        ));
        jScrollPane2.setViewportView(jtGestion);

        jpCentro.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel1.add(jpCentro, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jtfMotivo.setColumns(20);
        jtfMotivo.setRows(5);
        jScrollPane1.setViewportView(jtfMotivo);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.PAGE_START);

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
        if (jtfMotivo.getText().isEmpty() || jtfEmpleado.getText().isEmpty() || jtfCantidad.getText().isEmpty() || jtfFecha.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Campos vacios", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            agregar();
            limpiar();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPdfActionPerformed
        crearreporte(this.idEmpleado);
    }//GEN-LAST:event_btnPdfActionPerformed

    private void jtfCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCantidadKeyTyped
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;
        if (!numeros) {
            evt.consume();
        }

        if (jtfCantidad.getText().length() >= 10) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfCantidadKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int reset = 0;
        this.loadDatos(reset);

    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnPdf;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JComboBox<String> jcbArticulos;
    private javax.swing.JComboBox<String> jcmbCategoria;
    private javax.swing.JPanel jpCentro;
    private javax.swing.JTable jtGestion;
    private javax.swing.JTextField jtfCantidad;
    public static javax.swing.JTextField jtfEmpleado;
    private javax.swing.JTextField jtfFecha;
    private javax.swing.JTextArea jtfMotivo;
    // End of variables declaration//GEN-END:variables

    public void loadDatos(int idEmpleado) {
        System.out.println("Hola" + idEmpleado);
        String sQuery = "";

        if (idEmpleado <= 0) {
            sQuery = """
                       select Empleado.nombre as nombre,Empleado.apellidoPaterno as apellidoPaterno,Empleado.apellidoMaterno as apellidoM, Articulos.nombreA as nombreA,Articulos.descrip as descrip,
                                           Articulos.identificador as identificador, Gestion.motivo as motivo,Gestion.cantidad as cantidad ,Gestion.fechaEntrega as fechaEntrega 
                                           from Gestion 
                                           inner join Empleado on Empleado.idEmpleado = Gestion.idEmpleado inner join Articulos on Articulos.idArticulo = Gestion.idArticulo
                        """;
        } else {
            sQuery = String.format("""
                   select Empleado.nombre as nombre,Empleado.apellidoPaterno as apellidoPaterno,Empleado.apellidoMaterno as apellidoM, Articulos.nombreA as nombreA,Articulos.descrip as descrip,
                   Articulos.identificador as identificador, Gestion.motivo as motivo,Gestion.cantidad as cantidad ,Gestion.fechaEntrega as fechaEntrega 
                   from Gestion 
                   inner join Empleado on Empleado.idEmpleado = Gestion.idEmpleado inner join Articulos on Articulos.idArticulo = Gestion.idArticulo where Empleado.idEmpleado = %d
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
                        rs.getString("nombre"),
                        rs.getString("apellidoPaterno"),
                        rs.getString("apellidoM"),
                        rs.getString("nombreA"),
                        rs.getString("descrip"),
                        rs.getString("motivo"),
                        rs.getString("cantidad"),
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
        String sQuery = "insert into Gestion (idEmpleado,idArticulo,motivo,cantidad,fechaEntrega) values(?,?,?,?,?)";
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
                ps.setString(3, jtfMotivo.getText());
                ps.setString(4, jtfCantidad.getText());
                ps.setString(5, jtfFecha.getText());
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

    private void crearreporte(int idEmpleado) {
        Document doc = new Document();
        String sQuery = "";
        try {
            String ruta = System.getProperty("user.home"); //Toma la raiz
            PdfWriter.getInstance(doc, new FileOutputStream(ruta + "/Documents/ReporteALO.pdf"));
            

            
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Reporte ALO \n\n");
            parrafo.setFont(FontFactory.getFont("Arial", 18, Font.BOLD, BaseColor.BLACK));
            parrafo.add("Reporte de artículos entregados\n\n ");

            Paragraph parrafo2 = new Paragraph();
            parrafo2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
            parrafo2.setFont(FontFactory.getFont("Arial", 15, Font.BOLD, BaseColor.BLACK));
            parrafo2.add("Responsiva \n\n");
            parrafo2.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));

            parrafo2.add("Sirva la presente como comprobante oficial de entrega del activo fijo que pertenece a Automotive Logistics, S.C. para: "+jtfEmpleado.getText()+"\n"
                    + "\n\n Recibo de conformidad con esta fecha, lo mencionado en la presente y me comprometo a usarlo única y exclusivamente para asuntos relacionados con mi actividad laboral, mantener en buen estado y notificar cualquier anomalía a Servicios Generales. En caso de extravío, daño o uso inadecuado, asumiré completamente la responsabilidad de pagar el costo, reparación o reposición del mismo. \n"
                    + "\n\n ");

            Paragraph parrafo3 = new Paragraph();
            parrafo3.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo3.setFont(FontFactory.getFont("Arial", 8, Font.BOLD, BaseColor.BLACK));
            parrafo3.add("Nombre___________________________________________________Puesto___________________________________Firma____________Fecha___________________\n\n ");
            
            Image header = Image.getInstance("src/img/logo.png");
            header.scaleToFit(300,300);
            header.setAlignment(Chunk.ALIGN_CENTER);

            doc.open(); //Abrio el documento pdf
            doc.add(header);
            
            doc.add(parrafo);
            doc.add(parrafo2);

            PdfPTable tabla = new PdfPTable(4);
//            tabla.setWidthPercentage(110);
            tabla.addCell("Articulo");
            tabla.addCell("Identificador");
            tabla.addCell("Cantidad");
            tabla.addCell("FechaEntrega");

            tabla.isExtendLastRow(true);

            if (idEmpleado <= 0) {
                sQuery = """
                    select Articulos.nombreA AS articulo, Articulos.identificador AS identificador,
                                            Gestion.cantidad AS cantidad, Gestion.fechaEntrega AS fecha from Gestion inner join Empleado ON Empleado.idEmpleado = Gestion.idEmpleado inner join Departamento on Departamento.idDepartamento = Empleado.idDepartamento
                                            inner join Puesto on Puesto.idPuesto = Empleado.idPuesto inner join Articulos on Articulos.idArticulo = Gestion.idArticulo 
                                    """;
            } else {
                sQuery = String.format("""
                      select Articulos.nombreA AS articulo, Articulos.identificador AS identificador,
                      Gestion.cantidad AS cantidad, Gestion.fechaEntrega AS fecha from Gestion inner join Empleado ON Empleado.idEmpleado = Gestion.idEmpleado inner join Departamento on Departamento.idDepartamento = Empleado.idDepartamento
                      inner join Puesto on Puesto.idPuesto = Empleado.idPuesto inner join Articulos on Articulos.idArticulo = Gestion.idArticulo 
                                       where Empleado.idEmpleado = %d
                                    """, idEmpleado);
            }

            if (this.padre.db.conn != null) {
                try {

                    ps = this.padre.db.conn.prepareStatement(sQuery, ResultSet.TYPE_SCROLL_SENSITIVE,
                            ResultSet.CONCUR_READ_ONLY);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        do {
                            tabla.addCell(rs.getString(1));
                            tabla.addCell(rs.getString(2));
                            tabla.addCell(rs.getString(3));
                            tabla.addCell(rs.getString(4));

                        } while (rs.next());

                        doc.add(tabla);
                        doc.add(Chunk.NEWLINE);
                        doc.add(Chunk.NEWLINE);
                        doc.add(Chunk.NEWLINE);
                        doc.add(Chunk.NEWLINE);
                        doc.add(Chunk.NEWLINE);
                        doc.add(Chunk.NEWLINE);
                        doc.add(parrafo3);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            doc.close();
            JOptionPane.showMessageDialog(this, "Reporte Creado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al generar el reporte", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }

    }

    private void limpiar() {
        jtfCantidad.setText("");
        jtfEmpleado.setText("");
        jtfMotivo.setText("");
    }

}
