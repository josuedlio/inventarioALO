package com.mycompany.mavenproject1.Vista;

import com.mycompany.mavenproject1.Controlador.ComboItems;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


public class vistaEmpleados extends javax.swing.JDialog {

    vistaPrincipal padre;
    PreparedStatement ps;
    ResultSet rs;

    int id;
    private String nombreEmpleado, apellidoP, apellidoM, estatus;

    DefaultComboBoxModel dcbmDepartamento;
    DefaultTableModel dtmEmpleados;

    public vistaEmpleados(vistaPrincipal padre, boolean modal) {

        super(padre, modal);
        this.padre = padre;

        initComponents();
        jtfEstatus.setEnabled(false);
        jtfFechaAlta.setEnabled(false);

        setTitle("Empleados");
        this.dcbmDepartamento = (DefaultComboBoxModel) this.cbDepartamentos.getModel();

        jtfFechaAlta.setText(getFecha());
        Border bordeN = new TitledBorder("Nombre");
        jtfNombre.setBorder(bordeN);
        Border bordeaP = new TitledBorder("Apellido parterno");
        jtfApellidoP.setBorder(bordeaP);
        Border bordeM = new TitledBorder("Apellido Materno");
        jtfapellidoMaterno.setBorder(bordeM);
        Border bordeEs = new TitledBorder("Estatus");
        jtfEstatus.setBorder(bordeEs);
        Border borderF = new TitledBorder("Fecha");
        jtfFechaAlta.setBorder(borderF);
        this.loadDepartamentos();

        this.dtmEmpleados = (DefaultTableModel) this.jTable1.getModel();
        loadDatos();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jpIzquierda = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jpDerecha = new javax.swing.JPanel();
        jpDerechoArriba = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jrbEditar = new javax.swing.JRadioButton();
        jpDerechoAbajo = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        cbDepartamentos = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jtfNombre = new javax.swing.JTextField();
        jtfApellidoP = new javax.swing.JTextField();
        jtfapellidoMaterno = new javax.swing.JTextField();
        jtfFechaAlta = new javax.swing.JTextField();
        jtfEstatus = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.GridLayout(1, 2));

        jpIzquierda.setLayout(new java.awt.BorderLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido Paterno", "Apellido Materno", "Fecha Ingreso", "Estatus", "Departamento"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jpIzquierda.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel2.add(jpIzquierda);

        jpDerecha.setLayout(new java.awt.BorderLayout());

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jpDerechoArriba.add(btnAgregar);

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jpDerechoArriba.add(btnModificar);

        btnEliminar.setText("Borrar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jpDerechoArriba.add(btnEliminar);

        jrbEditar.setText("Editar");
        jrbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbEditarActionPerformed(evt);
            }
        });
        jpDerechoArriba.add(jrbEditar);

        jpDerecha.add(jpDerechoArriba, java.awt.BorderLayout.PAGE_START);

        jpDerechoAbajo.setLayout(new java.awt.BorderLayout());

        cbDepartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDepartamentosActionPerformed(evt);
            }
        });
        jPanel3.add(cbDepartamentos);

        jpDerechoAbajo.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel5.setLayout(new java.awt.GridLayout(5, 5, 0, 45));
        jPanel5.add(jtfNombre);
        jPanel5.add(jtfApellidoP);
        jPanel5.add(jtfapellidoMaterno);

        jtfFechaAlta.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel5.add(jtfFechaAlta);

        jtfEstatus.setText("Activo");
        jtfEstatus.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel5.add(jtfEstatus);

        jpDerechoAbajo.add(jPanel5, java.awt.BorderLayout.CENTER);

        jpDerecha.add(jpDerechoAbajo, java.awt.BorderLayout.CENTER);

        jPanel2.add(jpDerecha);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbDepartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDepartamentosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbDepartamentosActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        if (jtfNombre.getText().isBlank() || jtfApellidoP.getText().isBlank()
                || jtfapellidoMaterno.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Error", "Campos vacios", JOptionPane.ERROR_MESSAGE);
        } else {
            agregarDatos();
        }

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        modificar(id);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        try {
            this.rs.absolute(this.jTable1.getSelectedRow() + 1);
            this.id = this.rs.getInt("id");
            this.nombreEmpleado = this.rs.getString("nombreEmpleado");
            this.apellidoP = this.rs.getString("apellidoPaterno");
            this.apellidoM = this.rs.getString("apellidoMaterno");
            this.estatus = this.rs.getString("estatus");

            jtfNombre.setText(this.nombreEmpleado);
            jtfApellidoP.setText(this.apellidoP);
            jtfapellidoMaterno.setText(this.apellidoM);
            
            System.out.println(id);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        borrar(this.id);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jrbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbEditarActionPerformed
        if (jrbEditar.isSelected()) {
            jtfFechaAlta.setEnabled(true);
            jtfEstatus.setEnabled(true);
        } else {
            jtfFechaAlta.setEnabled(false);
            jtfEstatus.setEnabled(false);
        }
    }//GEN-LAST:event_jrbEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbDepartamentos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel jpDerecha;
    private javax.swing.JPanel jpDerechoAbajo;
    private javax.swing.JPanel jpDerechoArriba;
    private javax.swing.JPanel jpIzquierda;
    private javax.swing.JRadioButton jrbEditar;
    private javax.swing.JTextField jtfApellidoP;
    private javax.swing.JTextField jtfEstatus;
    private javax.swing.JTextField jtfFechaAlta;
    private javax.swing.JTextField jtfNombre;
    private javax.swing.JTextField jtfapellidoMaterno;
    // End of variables declaration//GEN-END:variables

    public static String getFecha() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String date = simpleDateFormat.format(new Date());
        return date;
    }

    private void loadDatos() {
        String sQuery = """
                       select Empleado.idEmpleado as id,Empleado.nombre AS nombre, Empleado.apellidoPaterno AS apellidoPaterno, Empleado.apellidoMaterno AS apellidoMaterno, 
                       Empleado.estatus AS estatus,Empleado.fechaAlta as fechaAlta ,Departamento.nombreDepartamento AS nombreDepartamento from Empleado
                       inner join Departamento on Departamento.idDepartamento = Empleado.idDepartamento
                        """;
        if (this.padre.db.conn != null) {
            try {
                ps = this.padre.db.conn.prepareStatement(sQuery, ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                rs = ps.executeQuery();

                this.dtmEmpleados.setRowCount(0);
                while (rs.next()) {
                    this.dtmEmpleados.addRow(new Object[]{
                        rs.getString("nombre"),
                        rs.getString("apellidoPaterno"),
                        rs.getString("apellidoMaterno"),
                        rs.getString("estatus"),
                        rs.getString("fechaAlta"),
                        rs.getString("nombreDepartamento")
                    });
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private void agregarDatos() {
        String sQuery = """
                    insert into Empleado(nombre,apellidoPaterno,apellidoMaterno,
                        estatus,fechaAlta,fechaBaja,idDepartamento) values (?,?,?,?,?,?,?)                        
                        """;
        ComboItems oDeptos = (ComboItems) this.cbDepartamentos.getSelectedItem();
        int idDepartamentos = 0;

        if (this.cbDepartamentos.getSelectedItem() != null) {
            idDepartamentos = Integer.parseInt(oDeptos.getKey());
        }

        if (this.padre.db.conn != null) {
            try {
                ps = this.padre.db.conn.prepareStatement(sQuery, ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                ps.setString(1, jtfNombre.getText().toUpperCase());
                ps.setString(2, jtfApellidoP.getText().toUpperCase());
                ps.setString(3, jtfapellidoMaterno.getText().toUpperCase());
                ps.setString(4, jtfEstatus.getText().toUpperCase());
                ps.setString(5, jtfFechaAlta.getText());
                ps.setString(6, jtfFechaAlta.getText());
                ps.setInt(7, idDepartamentos);
                ps.execute();
                loadDatos();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Ya existe el departamento", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void modificar(int id) {
        String sQuery = "update Empleado set estatus = ?, fechaBaja = ?, idDepartamento = ? where idEmpleado = ? ";
        ComboItems oDeptos = (ComboItems) this.cbDepartamentos.getSelectedItem();
        int idDepartamentos = 0;

        if (this.cbDepartamentos.getSelectedItem() != null) {
            idDepartamentos = Integer.parseInt(oDeptos.getKey());
        }
        if (this.padre.db.conn != null) {
            try {
                ps = this.padre.db.conn.prepareStatement(sQuery, ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                ps.setString(1, jtfEstatus.getText().toUpperCase());
                ps.setString(2, jtfFechaAlta.getText());
                ps.setInt(3, idDepartamentos);
                ps.setInt(4, id);
                ps.executeUpdate();
                loadDatos();
                limpiar();
            } catch (Exception e) {
            }
        }
    }

    private void loadDepartamentos() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sQuery = "SELECT idDepartamento, nombreDepartamento FROM Departamento";

        if (this.padre.db.conn != null) {
            try {
                ps = this.padre.db.conn.prepareStatement(sQuery, ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                rs = ps.executeQuery();
                while (rs.next()) {
                    this.dcbmDepartamento.addElement(new ComboItems(Integer.toString(rs.getInt("idDepartamento")), rs.getString("nombreDepartamento")));
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private void borrar(int id) {
        String sQuery = "delete from Empleado where idEmpleado = ?";
        if (this.padre.db.conn != null) {
            try {
                ps = this.padre.db.conn.prepareStatement(sQuery, ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                ps.setInt(1, id);
                ps.executeUpdate(); //no regresa un conjunto de resultados update Departamento set nombreDepartamento = ? where  idDepartamento = ?
                loadDatos();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "No puedes borrar este departamento", "Error", JOptionPane.ERROR_MESSAGE);

            }
        }
    }
    
    private void limpiar(){
        jtfNombre.setText("");
        jtfApellidoP.setText("");
        jtfapellidoMaterno.setText("");
    }
}
