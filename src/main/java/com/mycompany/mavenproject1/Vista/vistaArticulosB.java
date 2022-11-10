/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.mavenproject1.Vista;

import com.mycompany.mavenproject1.Controlador.ComboItems;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author infraver
 */
public class vistaArticulosB extends javax.swing.JInternalFrame {

    vistaPrincipal padre;
    PreparedStatement ps;
    ResultSet rs;

    DefaultComboBoxModel dcbmBuscarCategoria;
    DefaultTableModel dtmTablaBuscar;

    DefaultTableModel dtmTablaArticulos;
    DefaultComboBoxModel dcbmAgregarCategoria;
    DefaultComboBoxModel dcbmMarca;
    int id;

    public vistaArticulosB(vistaPrincipal padre) {
        initComponents();
        this.padre = padre;
        setTitle("Catalogo Articulos");

        Border bordeC = new TitledBorder("Categoria");
        jcbBuscarCategoria.setBorder(bordeC);
        jcbAgregarCategoria.setBorder(bordeC);

        this.dcbmBuscarCategoria = (DefaultComboBoxModel) this.jcbBuscarCategoria.getModel();
        this.dtmTablaBuscar = (DefaultTableModel) this.jtBuscarArticulos.getModel();

        this.dtmTablaArticulos = (DefaultTableModel) this.jtArticulos.getModel();
        this.dcbmAgregarCategoria = (DefaultComboBoxModel) this.jcbAgregarCategoria.getModel();
        this.dcbmMarca = (DefaultComboBoxModel) this.jcbAgregarMarca.getModel();

        Border bordeN = new TitledBorder("Nombre Articulo");
        jtfNombreA.setBorder(bordeN);
        Border borderD = new TitledBorder("Descripción");
        jtfDescripcion.setBorder(borderD);
        Border borderMa = new TitledBorder("Marca");
        jcbAgregarMarca.setBorder(borderMa);
        Border borderMo = new TitledBorder("Modelo");
        jtfModelo.setBorder(borderMo);
        Border borderAl = new TitledBorder("Almacenamiento");
        jtfAlmacenamiento.setBorder(borderAl);
        Border borderFo = new TitledBorder("Folio");
        jtfFolio.setBorder(borderFo);
        Border borderNu = new TitledBorder("No.Serie");
        jtfNumSerie.setBorder(borderNu);

        loadCategorias();
        loadCategoriasA();
        loadArticulos(id);
        loadDatos();
        loadMarca();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Central = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        verArticulos = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        pVerArticulosNoorte = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jcbBuscarCategoria = new javax.swing.JComboBox<>();
        btnReset = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtBuscarArticulos = new javax.swing.JTable();
        jpAgregar = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtArticulos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jtfNombreA = new javax.swing.JTextField();
        jtfDescripcion = new javax.swing.JTextField();
        jtfModelo = new javax.swing.JTextField();
        jtfNumSerie = new javax.swing.JTextField();
        jtfAlmacenamiento = new javax.swing.JTextField();
        jtfFolio = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jcbAgregarCategoria = new javax.swing.JComboBox<>();
        jcbAgregarMarca = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Prueba");

        Central.setLayout(new java.awt.BorderLayout());

        verArticulos.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel2.setText("Buscar:");
        pVerArticulosNoorte.add(jLabel2);

        jcbBuscarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbBuscarCategoriaActionPerformed(evt);
            }
        });
        pVerArticulosNoorte.add(jcbBuscarCategoria);

        btnReset.setIcon(new javax.swing.ImageIcon("C:\\Users\\infraver\\Downloads\\update_sync_reload_reset_icon_229478 (1).png")); // NOI18N
        btnReset.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        pVerArticulosNoorte.add(btnReset);

        jPanel1.add(pVerArticulosNoorte, java.awt.BorderLayout.PAGE_START);

        jtBuscarArticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Descripcion", "Modelo", "Capacidad", "Identificador", "Folio", "Categoria", "Marca"
            }
        ));
        jScrollPane2.setViewportView(jtBuscarArticulos);

        jPanel1.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        verArticulos.add(jPanel1, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Ver Articulos", verArticulos);

        jpAgregar.setLayout(new java.awt.GridLayout(0, 2));

        jtArticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Descripcion", "Modelo", "Identificador", "Folio"
            }
        ));
        jScrollPane1.setViewportView(jtArticulos);

        jpAgregar.add(jScrollPane1);

        btnAgregar.setIcon(new javax.swing.ImageIcon("C:\\Users\\infraver\\Downloads\\plus-black-symbol_icon-icons.com_73453.png")); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfNombreA)
                    .addComponent(jtfDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
                    .addComponent(jtfModelo, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
                    .addComponent(jtfNumSerie, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
                    .addComponent(jcbAgregarCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfAlmacenamiento, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
                    .addComponent(jtfFolio)
                    .addComponent(jcbAgregarMarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jtfNombreA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jtfDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jtfModelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jtfFolio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jtfNumSerie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jtfAlmacenamiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jcbAgregarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jcbAgregarMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        jpAgregar.add(jPanel2);

        jTabbedPane1.addTab("Agregar", jpAgregar);

        Central.add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(Central, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbBuscarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbBuscarCategoriaActionPerformed
        ComboItems oCategoria = (ComboItems) this.jcbBuscarCategoria.getSelectedItem();
        if (this.jcbBuscarCategoria.getSelectedItem() != null) {
            this.loadArticulos(Integer.parseInt(oCategoria.getKey()));
        }
    }//GEN-LAST:event_jcbBuscarCategoriaActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        int reset = 0;
        this.loadArticulos(reset);
        this.loadCategorias();
        this.loadCategoriasA();
        this.loadMarca();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (jtfNombreA.getText().isBlank() || jtfDescripcion.getText().isEmpty() || jtfModelo.getText().isEmpty()
                || jtfAlmacenamiento.getText().isEmpty() || jtfFolio.getText().isEmpty() || jtfNumSerie.getText().isEmpty()) {
JOptionPane.showMessageDialog(this, "Campos vacios", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            agregarDatos();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Central;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnReset;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> jcbAgregarCategoria;
    private javax.swing.JComboBox<String> jcbAgregarMarca;
    private javax.swing.JComboBox<String> jcbBuscarCategoria;
    private javax.swing.JPanel jpAgregar;
    private javax.swing.JTable jtArticulos;
    private javax.swing.JTable jtBuscarArticulos;
    private javax.swing.JTextField jtfAlmacenamiento;
    private javax.swing.JTextField jtfDescripcion;
    private javax.swing.JTextField jtfFolio;
    private javax.swing.JTextField jtfModelo;
    private javax.swing.JTextField jtfNombreA;
    private javax.swing.JTextField jtfNumSerie;
    private javax.swing.JPanel pVerArticulosNoorte;
    private javax.swing.JPanel verArticulos;
    // End of variables declaration//GEN-END:variables

    void loadArticulos(int id) {
        System.out.println("Hola: " + id);
        String sQuery = "";

        if (id <= 0) {
            sQuery = """
               select Articulos.idArticulo as id,Articulos.nombreA as nombreA,Articulos.descrip AS descripcion, Articulos.modelo AS modelo,
               Articulos.capacidad as capacidad,
               Articulos.identificador AS identificador, Articulos.folio AS folio,Categoria.nombreCategoria AS nombreCategoria, Marca.nombreMarca as marca
               from Articulos inner join
               Categoria on Categoria.idCategoria = Articulos.idCategoria inner join Marca on Marca.idMarca = Articulos.idMarca
               """;
        } else {
            sQuery = String.format("""
                select Articulos.idArticulo as id,Articulos.nombreA as nombreA,Articulos.descrip AS descripcion, Articulos.modelo AS modelo,
                               Articulos.capacidad as capacidad,
                               Articulos.identificador AS identificador, Articulos.folio AS folio,Categoria.nombreCategoria AS nombreCategoria, Marca.nombreMarca as marca
                               from Articulos inner join
                               Categoria on Categoria.idCategoria = Articulos.idCategoria inner join Marca on Marca.idMarca = Articulos.idMarca where Articulos.idCategoria = %d
                              """, id);
        }

        if (this.padre.db.conn != null) {
            try {
                ps = this.padre.db.conn.prepareStatement(sQuery, ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                rs = ps.executeQuery();
                this.dtmTablaBuscar.setRowCount(0);
                while (rs.next()) {
                    this.dtmTablaBuscar.addRow(new Object[]{
                        rs.getString("id"),
                        rs.getString("nombreA"),
                        rs.getString("descripcion"),
                        rs.getString("modelo"),
                        rs.getString("capacidad"),
                        rs.getString("identificador"),
                        rs.getString("folio"),
                        rs.getString("nombreCategoria"),
                        rs.getString("marca")
                    });
                }
            } catch (Exception e) {
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
                    this.dcbmBuscarCategoria.addElement(
                            new ComboItems(Integer.toString(
                                    rs.getInt("idCategoria")), rs.getString("nombreCategoria")));
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private void loadDatos() {
        String sQuery = "select idArticulo,nombreA,descrip,modelo,identificador,folio from Articulos ";
        if (this.padre.db.conn != null) {
            try {
                ps = this.padre.db.conn.prepareStatement(sQuery, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                rs = ps.executeQuery();
                this.dtmTablaArticulos.setRowCount(0);
                while (rs.next()) {
                    this.dtmTablaArticulos.addRow(new Object[]{
                        rs.getString("idArticulo"),
                        rs.getString("nombreA"),
                        rs.getString("descrip"),
                        rs.getString("modelo"),
                        rs.getString("identificador"),
                        rs.getString("folio")
                    });
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private void loadCategoriasA() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sQuery = "SELECT idCategoria,nombreCategoria FROM Categoria";
        if (this.padre.db.conn != null) {
            try {
                ps = this.padre.db.conn.prepareStatement(sQuery, ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                rs = ps.executeQuery();
                while (rs.next()) {
                    this.dcbmAgregarCategoria.addElement(
                            new ComboItems(Integer.toString(
                                    rs.getInt("idCategoria")), rs.getString("nombreCategoria")));
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    void loadMarca() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sQuery = "SELECT idMarca,nombreMarca FROM Marca";
        if (this.padre.db.conn != null) {
            try {
                ps = this.padre.db.conn.prepareStatement(sQuery, ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                rs = ps.executeQuery();
                while (rs.next()) {
                    this.dcbmMarca.addElement(
                            new ComboItems(Integer.toString(
                                    rs.getInt("idMarca")), rs.getString("nombreMarca")));
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private void agregarDatos() {
        String sQuery = " insert into Articulos (nombreA,descrip,modelo,capacidad,identificador,folio,idCategoria,idMarca)  "
                + "VALUES(?,?,?,?,?,?,?,?)";
        ComboItems oTipoAs = (ComboItems) this.jcbAgregarCategoria.getSelectedItem();
        int idTipo = 0;

        if (this.jcbAgregarCategoria.getSelectedItem() != null) {
            idTipo = Integer.parseInt(oTipoAs.getKey());
        }

        ComboItems oMarca = (ComboItems) this.jcbAgregarMarca.getSelectedItem();
        int idMarca = 0;
        if (this.jcbAgregarMarca.getSelectedItem() != null) {
            idMarca = Integer.parseInt(oMarca.getKey());
        }

        if (this.padre.db.conn != null) {
            try {
                ps = this.padre.db.conn.prepareStatement(sQuery, ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                ps.setString(1, jtfNombreA.getText().toUpperCase());
                ps.setString(2, jtfDescripcion.getText().toUpperCase());
                ps.setString(3, jtfModelo.getText().toUpperCase());
                ps.setString(4, jtfAlmacenamiento.getText().toUpperCase());
                ps.setString(5, jtfNumSerie.getText().toUpperCase());
                ps.setString(6, jtfFolio.getText().toUpperCase());
                ps.setInt(7, idTipo);
                ps.setInt(8, idMarca);
                ps.execute();
                loadDatos();
                limpiarcampos();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void limpiarcampos() {
        jtfDescripcion.setText("");
        jtfModelo.setText("");
        jtfAlmacenamiento.setText("");
        jtfNumSerie.setText("");
        jtfNombreA.setText("");
        jtfFolio.setText("");
    }

}
