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
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author infraver
 */
public class vistaEmpleadoB extends javax.swing.JInternalFrame {

    vistaPrincipal padre;
    PreparedStatement ps;
    ResultSet rs;

    DefaultTableModel dtmTablaBuscar;
    DefaultComboBoxModel dcbmBuscarDepa;
    DefaultComboBoxModel dcbmBuscarZona;

    DefaultTableModel dtmTablaAgregar;
    DefaultComboBoxModel dcbmAgregarDepa;
    DefaultComboBoxModel dcbmAgregarZona;
    DefaultComboBoxModel dcbmPuesto;

    int id;
    String nombre, apellidop, apellidom, estatus, matricula;

    public vistaEmpleadoB(vistaPrincipal padre) {
        this.padre = padre;
        initComponents();
        Border bordeD = new TitledBorder("Departamento");
        cbBuscarDepartamento.setBorder(bordeD);
        cbAgregarDepa.setBorder(bordeD);
        Border bordeZ = new TitledBorder("Zonas");
        cbBuscarZona.setBorder(bordeZ);
        cbAgregarZona.setBorder(bordeZ);
        Border BordeN = new TitledBorder("Nombre(s)");
        jtfNombre.setBorder(BordeN);
        jtfBuscarN.setBorder(BordeN);
        jtfBuscarN.setColumns(10);
        Border Bordeap = new TitledBorder("Apellido Paterno");
        jtfApellidoP.setBorder(Bordeap);
        Border Bordeam = new TitledBorder("Apellido Materno");
        jtfApellidoM.setBorder(Bordeam);
        Border BordeFA = new TitledBorder("Fecha Alta");
        jtfFechaAlta.setBorder(BordeFA);
        Border BordeFB = new TitledBorder("Fecha Baja");
        jtfFechaBaja.setBorder(BordeFB);
        Border BorderS = new TitledBorder("Estatus");
        jtfEstatus.setBorder(BorderS);
        Border BorderP = new TitledBorder("Puesto");
        cbPuesto.setBorder(BorderP);
        Border BorderM = new TitledBorder("Matricula");
        jtfMatricula.setBorder(BorderM);
        jtfBuscarMatricula.setBorder(BorderM);
        jtfBuscarMatricula.setColumns(6);

        this.dtmTablaBuscar = (DefaultTableModel) this.jTablaBuscarE.getModel();
        this.dcbmBuscarDepa = (DefaultComboBoxModel) this.cbBuscarDepartamento.getModel();
        this.dcbmBuscarZona = (DefaultComboBoxModel) this.cbBuscarZona.getModel();

        this.dtmTablaAgregar = (DefaultTableModel) this.jTablaAgregar.getModel();
        this.dcbmAgregarDepa = (DefaultComboBoxModel) this.cbAgregarDepa.getModel();
        this.dcbmAgregarZona = (DefaultComboBoxModel) this.cbAgregarZona.getModel();
        this.dcbmPuesto = (DefaultComboBoxModel) this.cbPuesto.getModel();

        cbBuscarDepartamento.setEnabled(false);
        cbBuscarZona.setEnabled(false);
        jtfBuscarN.setEnabled(false);
        jtfBuscarMatricula.setEnabled(false);
        //////////////////////////////Buscar/////////////////////////////////////////////////
        loadZonas();
        loadDepas();
        loadBuscarDepa(id);
        loadBuscarZona(id);

        ////////////////////////////////Agregar////////////////////////////////////////////////
        loadEmpleados();
        jtfFechaAlta.setText(getFecha());
        jtfFechaBaja.setText(getFecha());
        jtfEstatus.setEnabled(false);
        jtfEstatus.setText("ACTIVO");
        loadPuesto();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBoton1 = new javax.swing.ButtonGroup();
        Principal = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        vistaGeneralEmpleados = new javax.swing.JPanel();
        generalNorte = new javax.swing.JPanel();
        jRadioButton4 = new javax.swing.JRadioButton();
        jtfBuscarMatricula = new javax.swing.JTextField();
        jRadioButton3 = new javax.swing.JRadioButton();
        jtfBuscarN = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        cbBuscarZona = new javax.swing.JComboBox<>();
        jRadioButton2 = new javax.swing.JRadioButton();
        cbBuscarDepartamento = new javax.swing.JComboBox<>();
        btnReiniciar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaBuscarE = new javax.swing.JTable();
        vistaAgregarEmpleados = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablaAgregar = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jtfNombre = new javax.swing.JTextField();
        jtfApellidoP = new javax.swing.JTextField();
        jtfApellidoM = new javax.swing.JTextField();
        jtfFechaAlta = new javax.swing.JTextField();
        jtfFechaBaja = new javax.swing.JTextField();
        jtfEstatus = new javax.swing.JTextField();
        cbAgregarZona = new javax.swing.JComboBox<>();
        cbAgregarDepa = new javax.swing.JComboBox<>();
        btnModificar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        cbPuesto = new javax.swing.JComboBox<>();
        jtfMatricula = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Empleados");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameIconified(evt);
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        Principal.setLayout(new java.awt.BorderLayout());

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        vistaGeneralEmpleados.setLayout(new java.awt.BorderLayout());

        grupoBoton1.add(jRadioButton4);
        jRadioButton4.setText("Buscar por Matricula");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });
        generalNorte.add(jRadioButton4);

        jtfBuscarMatricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfBuscarMatriculaKeyTyped(evt);
            }
        });
        generalNorte.add(jtfBuscarMatricula);

        grupoBoton1.add(jRadioButton3);
        jRadioButton3.setText("Buscar por Nombre");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
        generalNorte.add(jRadioButton3);

        jtfBuscarN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfBuscarNKeyTyped(evt);
            }
        });
        generalNorte.add(jtfBuscarN);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/seo-social-web-network-internet_340_icon-icons.com_61497 (1).png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        generalNorte.add(jButton2);

        grupoBoton1.add(jRadioButton1);
        jRadioButton1.setText("Buscar por Zona");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        generalNorte.add(jRadioButton1);

        cbBuscarZona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBuscarZonaActionPerformed(evt);
            }
        });
        generalNorte.add(cbBuscarZona);

        grupoBoton1.add(jRadioButton2);
        jRadioButton2.setText("Buscar por Departamento");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        generalNorte.add(jRadioButton2);

        cbBuscarDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBuscarDepartamentoActionPerformed(evt);
            }
        });
        generalNorte.add(cbBuscarDepartamento);

        btnReiniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnreset.png"))); // NOI18N
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });
        generalNorte.add(btnReiniciar);

        vistaGeneralEmpleados.add(generalNorte, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jTablaBuscarE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido P", "Apellido M", "Puesto", "No. Empleado", "Departamento", "Área", "Zona", "Estatus"
            }
        ));
        jScrollPane1.setViewportView(jTablaBuscarE);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        vistaGeneralEmpleados.add(jPanel1, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Empelados", vistaGeneralEmpleados);

        vistaAgregarEmpleados.setLayout(new java.awt.GridLayout(0, 2));

        jTablaAgregar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Apellido", "Apellido M", "Estatus", "Fecha Ingreso", "Fecha Baja", "Matricula", "Departamento", "Puesto", "Zona"
            }
        ));
        jTablaAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaAgregarMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTablaAgregar);

        vistaAgregarEmpleados.add(jScrollPane2);

        jtfApellidoP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfApellidoPActionPerformed(evt);
            }
        });

        jtfFechaBaja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtfFechaBajaMouseClicked(evt);
            }
        });
        jtfFechaBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfFechaBajaActionPerformed(evt);
            }
        });

        jtfEstatus.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pencil-striped-symbol-for-interface-edit-buttons_icon-icons.com_56782.png"))); // NOI18N
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1904677-add-addition-calculate-charge-create-new-plus_122527.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jToggleButton1.setText("Activo o Inactivo");
        jToggleButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleButton1MouseClicked(evt);
            }
        });
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jtfMatricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfMatriculaKeyTyped(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/trash_bin_icon-icons.com_67981.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfNombre)
                    .addComponent(jtfApellidoP, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtfApellidoM)
                    .addComponent(jtfFechaAlta)
                    .addComponent(jtfFechaBaja)
                    .addComponent(jtfEstatus)
                    .addComponent(jtfMatricula)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(323, 323, 323)
                        .addComponent(jToggleButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cbAgregarZona, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbPuesto, 0, 242, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbAgregarDepa, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jtfApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jtfFechaAlta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtfFechaBaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtfEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtfMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(jToggleButton1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnModificar)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbAgregarZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbAgregarDepa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cbPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(211, Short.MAX_VALUE))
        );

        vistaAgregarEmpleados.add(jPanel3);

        jTabbedPane1.addTab("Nuevo", vistaAgregarEmpleados);

        Principal.add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(Principal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbBuscarZonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBuscarZonaActionPerformed
        ComboItems oZona = (ComboItems) this.cbBuscarZona.getSelectedItem();
        if (this.cbBuscarZona.getSelectedItem() != null) {
            this.loadBuscarZona(Integer.parseInt(oZona.getKey()));
        }
    }//GEN-LAST:event_cbBuscarZonaActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        if (jRadioButton1.isSelected()) {
            this.cbBuscarZona.setEnabled(true);
            this.cbBuscarDepartamento.setEnabled(false);
            this.jtfBuscarN.setEnabled(false);
            jtfBuscarMatricula.setEnabled(false);
        } else {
            this.cbBuscarZona.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void cbBuscarDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBuscarDepartamentoActionPerformed
        ComboItems oDeptos = (ComboItems) this.cbBuscarDepartamento.getSelectedItem();
        int idDepartamentos = 0;

        if (this.cbBuscarDepartamento.getSelectedItem() != null) {
            this.loadBuscarDepa(Integer.parseInt(oDeptos.getKey()));
        }

    }//GEN-LAST:event_cbBuscarDepartamentoActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        if (jRadioButton2.isSelected()) {
            this.cbBuscarZona.setEnabled(false);
            this.cbBuscarDepartamento.setEnabled(true);
            this.jtfBuscarN.setEnabled(false);
        } else {
            this.cbBuscarDepartamento.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        int reset = 0;
        loadBuscarZona(reset);
        this.cbBuscarZona.setEnabled(false);
        this.cbBuscarDepartamento.setEnabled(false);

    }//GEN-LAST:event_btnReiniciarActionPerformed

    private void jtfApellidoPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfApellidoPActionPerformed


    }//GEN-LAST:event_jtfApellidoPActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (jtfNombre.getText().isEmpty() || jtfApellidoP.getText().isEmpty() || jtfApellidoM.getText().isEmpty()
                || jtfEstatus.getText().isEmpty() || jtfFechaAlta.getText().isEmpty() || jtfFechaBaja.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Campos vacios", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            agregar();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jtfFechaBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfFechaBajaActionPerformed

    }//GEN-LAST:event_jtfFechaBajaActionPerformed

    private void jtfFechaBajaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfFechaBajaMouseClicked
        jtfFechaBaja.setText(getFecha());
    }//GEN-LAST:event_jtfFechaBajaMouseClicked

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        if (jToggleButton1.isSelected()) {
            jtfEstatus.setText("ACTIVO");
        } else {
            jtfEstatus.setText("INACTIVO");
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton1MouseClicked

    private void jTablaAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaAgregarMouseClicked
        System.out.println("Aqui");
        try {
            this.rs.absolute(this.jTablaAgregar.getSelectedRow() + 1);
            this.id = this.rs.getInt("id");
            this.nombre = this.rs.getString("nombre");
            this.apellidop = this.rs.getString("apellidoPaterno");
            this.apellidom = this.rs.getString("apellidoMaterno");
            this.estatus = this.rs.getString("estatus");
            this.matricula = this.rs.getString("matricula");

            jtfNombre.setText(this.nombre);
            jtfApellidoP.setText(this.apellidop);
            jtfApellidoM.setText(this.apellidom);
            jtfEstatus.setText(this.estatus);
            jtfMatricula.setText(this.matricula);
            System.out.println("ID ROW--->" + id);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jTablaAgregarMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        modificar(id);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void formInternalFrameIconified(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameIconified
        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameIconified

    private void jtfMatriculaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfMatriculaKeyTyped
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;
        if (!numeros) {
            evt.consume();
        }

        if (jtfMatricula.getText().length() >= 10) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfMatriculaKeyTyped

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        int id = 0;
        loadBuscarZona(id);
        loadEmpleados();
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        borrar(this.id);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        if (jRadioButton3.isSelected()) {
            this.cbBuscarZona.setEnabled(false);
            this.cbBuscarDepartamento.setEnabled(false);
            this.jtfBuscarN.setEnabled(true);
            this.jtfBuscarMatricula.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.out.println("Hola");
        if (jRadioButton3.isSelected()) {
            buscarNombre(jtfBuscarN.getText().toUpperCase());
        }else if (jRadioButton4.isSelected()){
            buscarMatricula(jtfBuscarMatricula.getText());
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        if (jRadioButton4.isSelected()) {
            this.cbBuscarZona.setEnabled(false);
            this.cbBuscarDepartamento.setEnabled(false);
            this.jtfBuscarN.setEnabled(false);
            this.jtfBuscarMatricula.setEnabled(true);
        }
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jtfBuscarMatriculaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfBuscarMatriculaKeyTyped
        // TODO add your handling code here:
         int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;
        if (!numeros) {
            evt.consume();
        }

        if (jtfBuscarMatricula.getText().length() >= 10) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfBuscarMatriculaKeyTyped

    private void jtfBuscarNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfBuscarNKeyTyped
        char caracter = evt.getKeyChar();
        if (Character.isLowerCase(caracter)) {
            evt.setKeyChar(Character.toUpperCase(caracter));
        }
        
        if( Character.isLowerCase(caracter) ){
            evt.setKeyChar(Character.toUpperCase(caracter));
            String filtro = this.jtfBuscarN.getText().toUpperCase();
            
            if( filtro.isBlank() ){
                this.buscarNombre(" ");
            }else{
                this.buscarNombre(filtro);
            }
        }
        
        
    }//GEN-LAST:event_jtfBuscarNKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Principal;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JComboBox<String> cbAgregarDepa;
    private javax.swing.JComboBox<String> cbAgregarZona;
    private javax.swing.JComboBox<String> cbBuscarDepartamento;
    private javax.swing.JComboBox<String> cbBuscarZona;
    private javax.swing.JComboBox<String> cbPuesto;
    private javax.swing.JPanel generalNorte;
    private javax.swing.ButtonGroup grupoBoton1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTablaAgregar;
    private javax.swing.JTable jTablaBuscarE;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField jtfApellidoM;
    private javax.swing.JTextField jtfApellidoP;
    private javax.swing.JTextField jtfBuscarMatricula;
    private javax.swing.JTextField jtfBuscarN;
    private javax.swing.JTextField jtfEstatus;
    private javax.swing.JTextField jtfFechaAlta;
    private javax.swing.JTextField jtfFechaBaja;
    private javax.swing.JTextField jtfMatricula;
    private javax.swing.JTextField jtfNombre;
    private javax.swing.JPanel vistaAgregarEmpleados;
    private javax.swing.JPanel vistaGeneralEmpleados;
    // End of variables declaration//GEN-END:variables

    private void loadBuscarZona(int id) {
        System.out.println("Zona id->" + id);
        String sQuery = "";
        if (id <= 0) {
            sQuery = """
                   select Empleado.nombre AS nombre, Empleado.apellidoPaterno AS apellidoPaterno, Empleado.apellidoMaterno AS apellidoMaterno, Puesto.nombrePuesto AS nombrePuesto, 
                   Empleado.matricula as matricula,Departamento.nombreDepartamento AS nombreDepartamento,Area.nombreArea AS nombreArea,Zona.nombreZona AS nombreZona, Empleado.estatus AS estatus from Empleado inner join Puesto ON Puesto.idPuesto = Empleado.idPuesto
                   inner join Departamento ON Departamento.idDepartamento = Empleado.idDepartamento inner join Area on Area.idArea = Departamento.idDepartamento inner join Zona ON Zona.idZona = Empleado.idZona
                   """;
        } else {
            sQuery = String.format("""
                                  select Empleado.nombre AS nombre, Empleado.apellidoPaterno AS apellidoPaterno, Empleado.apellidoMaterno AS apellidoMaterno, Puesto.nombrePuesto AS nombrePuesto, 
                                   Empleado.matricula as matricula,Departamento.nombreDepartamento AS nombreDepartamento,Area.nombreArea AS nombreArea,Zona.nombreZona AS nombreZona, Empleado.estatus AS estatus from Empleado inner join Puesto ON Puesto.idPuesto = Empleado.idPuesto
                                   inner join Departamento ON Departamento.idDepartamento = Empleado.idDepartamento inner join Area on Area.idArea = Departamento.idDepartamento inner join Zona ON Zona.idZona = Empleado.idZona where Empleado.idZona = %d
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
                        rs.getString("nombre"),
                        rs.getString("apellidoPaterno"),
                        rs.getString("apellidoMaterno"),
                        rs.getString("nombrePuesto"),
                        rs.getString("matricula"),
                        rs.getString("nombreDepartamento"),
                        rs.getString("nombreArea"),
                        rs.getString("nombreZona"),
                        rs.getString("estatus")
                    });

                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    private void loadBuscarDepa(int id) {
        System.out.println("Depa id->" + id);
        String sQuery = "";

        sQuery = String.format("""
                                 select Empleado.nombre AS nombre, Empleado.apellidoPaterno AS apellidoPaterno, Empleado.apellidoMaterno AS apellidoMaterno, Puesto.nombrePuesto AS nombrePuesto, 
                                   Empleado.matricula as matricula,Departamento.nombreDepartamento AS nombreDepartamento,Area.nombreArea AS nombreArea,Zona.nombreZona AS nombreZona, Empleado.estatus AS estatus from Empleado inner join Puesto ON Puesto.idPuesto = Empleado.idPuesto
                                   inner join Departamento ON Departamento.idDepartamento = Empleado.idDepartamento inner join Area on Area.idArea = Departamento.idDepartamento inner join Zona ON Zona.idZona = Empleado.idZona 
                               where Empleado.idDepartamento = %d
                                   """, id);
        if (this.padre.db.conn != null) {
            try {
                ps = this.padre.db.conn.prepareStatement(sQuery, ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                rs = ps.executeQuery();
                this.dtmTablaBuscar.setRowCount(0);
                while (rs.next()) {
                    this.dtmTablaBuscar.addRow(new Object[]{
                        rs.getString("nombre"),
                        rs.getString("apellidoPaterno"),
                        rs.getString("apellidoMaterno"),
                        rs.getString("nombrePuesto"),
                        rs.getString("matricula"),
                        rs.getString("nombreDepartamento"),
                        rs.getString("nombreArea"),
                        rs.getString("nombreZona"),
                        rs.getString("estatus")
                    });

                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private void loadZonas() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sQuery = "Select idZona, nombreZona from Zona";
        if (this.padre.db.conn != null) {
            try {
                ps = this.padre.db.conn.prepareStatement(sQuery, ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                rs = ps.executeQuery();
                while (rs.next()) {
                    this.dcbmBuscarZona.addElement(
                            new ComboItems(Integer.toString(
                                    rs.getInt("idZona")), rs.getString("nombreZona")));
                    this.dcbmAgregarZona.addElement(
                            new ComboItems(Integer.toString(
                                    rs.getInt("idZona")), rs.getString("nombreZona")));
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private void loadDepas() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sQuery = "Select idDepartamento, nombreDepartamento from Departamento";
        if (this.padre.db.conn != null) {
            try {
                ps = this.padre.db.conn.prepareStatement(sQuery, ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                rs = ps.executeQuery();
                while (rs.next()) {
                    this.dcbmBuscarDepa.addElement(
                            new ComboItems(Integer.toString(
                                    rs.getInt("idDepartamento")), rs.getString("nombreDepartamento")));
                    this.dcbmAgregarDepa.addElement(
                            new ComboItems(Integer.toString(
                                    rs.getInt("idDepartamento")), rs.getString("nombreDepartamento")));
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private void loadEmpleados() {
        String sQuery = """
                       select Empleado.idEmpleado as id,Empleado.nombre as nombre, Empleado.apellidoPaterno as apellidoPaterno, Empleado.apellidoMaterno as apellidoMaterno,
                        Empleado.estatus as estatus, Empleado.fechaAlta as fechaAlta, Empleado.fechaBaja as fechaBaja,Empleado.matricula as matricula,Departamento.nombreDepartamento as nombreDepartamento,Puesto.nombrePuesto as nombrePuesto ,Zona.nombreZona as nombreZona
                        from Empleado inner join Departamento on Departamento.idDepartamento = Empleado.idDepartamento inner join Zona on Zona.idZona = Empleado.idZona inner join Puesto on Puesto.idPuesto = Empleado.idPuesto
                        """;
        if (this.padre.db.conn != null) {
            try {
                ps = this.padre.db.conn.prepareStatement(sQuery, ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                rs = ps.executeQuery();

                this.dtmTablaAgregar.setRowCount(0);
                while (rs.next()) {
                    this.dtmTablaAgregar.addRow(new Object[]{
                        rs.getString("id"),
                        rs.getString("nombre"),
                        rs.getString("apellidoPaterno"),
                        rs.getString("apellidoMaterno"),
                        rs.getString("estatus"),
                        rs.getString("fechaAlta"),
                        rs.getString("fechaBaja"),
                        rs.getString("matricula"),
                        rs.getString("nombreDepartamento"),
                        rs.getString("nombrePuesto"),
                        rs.getString("nombreZona")
                    });
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private void agregar() {
        String sQuery = "insert into Empleado (nombre,apellidoPaterno,apellidoMaterno,matricula,estatus,fechaAlta,fechaBaja,idDepartamento,idPuesto,idZona)\n"
                + "			values (?,?,?,?,?,?,?,?,?,?)";
        ComboItems oDeptos = (ComboItems) this.cbAgregarDepa.getSelectedItem();
        int idDepartamentos = 0;

        if (this.cbAgregarDepa.getSelectedItem() != null) {
            idDepartamentos = Integer.parseInt(oDeptos.getKey());
        }
        ComboItems oZonas = (ComboItems) this.cbAgregarZona.getSelectedItem();
        int idZonas = 0;

        if (this.cbAgregarZona.getSelectedItem() != null) {
            idZonas = Integer.parseInt(oDeptos.getKey());
        }

        ComboItems oPuesto = (ComboItems) this.cbPuesto.getSelectedItem();
        int idPuesto = 0;
        if (this.cbPuesto.getSelectedItem() != null) {
            idPuesto = Integer.parseInt(oPuesto.getKey());
        }

        if (this.padre.db.conn != null) {
            try {
                ps = this.padre.db.conn.prepareStatement(sQuery, ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                ps.setString(1, jtfNombre.getText().toUpperCase());
                ps.setString(2, jtfApellidoP.getText().toUpperCase());
                ps.setString(3, jtfApellidoM.getText().toUpperCase());
                ps.setString(4, jtfMatricula.getText().toUpperCase());
                ps.setString(5, jtfEstatus.getText().toUpperCase());
                ps.setString(6, jtfFechaAlta.getText());
                ps.setString(7, jtfFechaAlta.getText());
                ps.setInt(8, idDepartamentos);
                ps.setInt(9, idPuesto);
                ps.setInt(10, idZonas);
                ps.execute();
                loadEmpleados();
                limpiar();
            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(this, "Se ha detectado un error", "¡Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    void modificar(int id) {
        String sQuery = "update Empleado set nombre = ?,apellidoPaterno=?, apellidoMaterno =?,estatus = ?,fechaBaja = ?, matricula = ? where idEmpleado = ?";
        if (this.padre.db.conn != null) {
            try {
                ps = this.padre.db.conn.prepareStatement(sQuery, ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                ps.setString(1, jtfNombre.getText().toUpperCase());
                ps.setString(2, jtfApellidoP.getText().toUpperCase());
                ps.setString(3, jtfApellidoM.getText().toUpperCase());
                ps.setString(4, jtfEstatus.getText());
                ps.setString(5, jtfFechaBaja.getText());
                ps.setString(6, jtfMatricula.getText());
                ps.setInt(7, id);
                ps.executeUpdate();
                loadEmpleados();
                limpiar();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    void limpiar() {
        jtfNombre.setText("");
        jtfApellidoP.setText("");
        jtfApellidoM.setText("");
        jtfEstatus.setText("");
        jtfFechaAlta.setText("");
        jtfFechaBaja.setText("");
        jtfEstatus.setText("");
        jtfMatricula.setText("");
    }

    public static String getFecha() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String date = simpleDateFormat.format(new Date());
        return date;
    }

    private void loadPuesto() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sQuery = "Select idPuesto, nombrePuesto from Puesto";
        if (this.padre.db.conn != null) {
            try {
                ps = this.padre.db.conn.prepareStatement(sQuery, ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                rs = ps.executeQuery();
                while (rs.next()) {
                    this.dcbmPuesto.addElement(
                            new ComboItems(Integer.toString(
                                    rs.getInt("idPuesto")), rs.getString("nombrePuesto")));
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
                loadEmpleados();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "No puedes borrar este empleado", "Error", JOptionPane.ERROR_MESSAGE);

            }
        }
    }

    void buscarNombre(String nombre) {
        String sQuery = """
                                 select Empleado.nombre AS nombre, Empleado.apellidoPaterno AS apellidoPaterno, Empleado.apellidoMaterno AS apellidoMaterno, Puesto.nombrePuesto AS nombrePuesto, 
                                   Empleado.matricula as matricula,Departamento.nombreDepartamento AS nombreDepartamento,Area.nombreArea AS nombreArea,Zona.nombreZona AS nombreZona, Empleado.estatus AS estatus from Empleado inner join Puesto ON Puesto.idPuesto = Empleado.idPuesto
                                   inner join Departamento ON Departamento.idDepartamento = Empleado.idDepartamento inner join Area on Area.idArea = Departamento.idDepartamento inner join Zona ON Zona.idZona = Empleado.idZona 
                               where Empleado.nombre like ?
                                   """;

        if (this.padre.db.conn != null) {
            try {
                ps = this.padre.db.conn.prepareStatement(sQuery, ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                ps.setString(1, "%"+nombre+"%");
                rs = ps.executeQuery();
                this.dtmTablaBuscar.setRowCount(0);
                while (rs.next()) {
                    this.dtmTablaBuscar.addRow(new Object[]{
                        rs.getString("nombre"),
                        rs.getString("apellidoPaterno"),
                        rs.getString("apellidoMaterno"),
                        rs.getString("nombrePuesto"),
                        rs.getString("matricula"),
                        rs.getString("nombreDepartamento"),
                        rs.getString("nombreArea"),
                        rs.getString("nombreZona"),
                        rs.getString("estatus")
                    });

                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    private void buscarMatricula(String text) {
       String sQuery = """
                                 select Empleado.nombre AS nombre, Empleado.apellidoPaterno AS apellidoPaterno, Empleado.apellidoMaterno AS apellidoMaterno, Puesto.nombrePuesto AS nombrePuesto, 
                                   Empleado.matricula as matricula,Departamento.nombreDepartamento AS nombreDepartamento,Area.nombreArea AS nombreArea,Zona.nombreZona AS nombreZona, Empleado.estatus AS estatus from Empleado inner join Puesto ON Puesto.idPuesto = Empleado.idPuesto
                                   inner join Departamento ON Departamento.idDepartamento = Empleado.idDepartamento inner join Area on Area.idArea = Departamento.idDepartamento inner join Zona ON Zona.idZona = Empleado.idZona 
                               where Empleado.matricula = ?
                                   """;

        if (this.padre.db.conn != null) {
            try {
                ps = this.padre.db.conn.prepareStatement(sQuery, ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                ps.setString(1, text);
                rs = ps.executeQuery();
                this.dtmTablaBuscar.setRowCount(0);
                while (rs.next()) {
                    this.dtmTablaBuscar.addRow(new Object[]{
                        rs.getString("nombre"),
                        rs.getString("apellidoPaterno"),
                        rs.getString("apellidoMaterno"),
                        rs.getString("nombrePuesto"),
                        rs.getString("matricula"),
                        rs.getString("nombreDepartamento"),
                        rs.getString("nombreArea"),
                        rs.getString("nombreZona"),
                        rs.getString("estatus")
                    });

                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

}
