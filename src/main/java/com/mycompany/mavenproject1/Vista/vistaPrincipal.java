package com.mycompany.mavenproject1.Vista;

import com.mycompany.mavenproject1.ConexionSQL;
import java.awt.Dimension;

public class vistaPrincipal extends javax.swing.JFrame {

    public ConexionSQL db;

    public vistaPrincipal() {
        initComponents();
        this.conectar();
    }

    private void conectar() {
        this.db = new ConexionSQL();
        this.db.connectDB();
    }

    vistaGestion vg;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jpPrincipal = new javax.swing.JPanel();
        jpCentro = new javax.swing.JPanel();
        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmPersonal = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jmiDepartamento = new javax.swing.JMenuItem();
        jmiEmpleados = new javax.swing.JMenuItem();
        jmArticulos = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpPrincipal.setLayout(new java.awt.BorderLayout());

        jpCentro.setLayout(new java.awt.BorderLayout());
        jpCentro.add(escritorio, java.awt.BorderLayout.CENTER);

        jpPrincipal.add(jpCentro, java.awt.BorderLayout.CENTER);

        getContentPane().add(jpPrincipal, java.awt.BorderLayout.CENTER);

        jmPersonal.setText("Personal ALO");
        jmPersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmPersonalMouseClicked(evt);
            }
        });
        jmPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmPersonalActionPerformed(evt);
            }
        });

        jMenuItem5.setText("Zonas");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jmPersonal.add(jMenuItem5);

        jmiDepartamento.setText("Departamento");
        jmiDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiDepartamentoActionPerformed(evt);
            }
        });
        jmPersonal.add(jmiDepartamento);

        jmiEmpleados.setText("Empleados");
        jmiEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEmpleadosActionPerformed(evt);
            }
        });
        jmPersonal.add(jmiEmpleados);

        jMenuBar1.add(jmPersonal);

        jmArticulos.setText("Articulos");

        jMenuItem6.setText("Marcas");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jmArticulos.add(jMenuItem6);

        jMenuItem1.setText("Categorias");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jmArticulos.add(jMenuItem1);

        jMenuItem4.setText("Ver Articulos");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jmArticulos.add(jMenuItem4);

        jMenuBar1.add(jmArticulos);

        jMenu1.setText("Gestion");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem3.setText("Ver Gestión");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmPersonalActionPerformed
                                    }//GEN-LAST:event_jmPersonalActionPerformed

    private void jmPersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmPersonalMouseClicked
    }//GEN-LAST:event_jmPersonalMouseClicked

    private void jmiDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiDepartamentoActionPerformed
        vistaDepartamento v = new vistaDepartamento(this, true);
        v.setVisible(true);
    }//GEN-LAST:event_jmiDepartamentoActionPerformed

    private void jmiEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEmpleadosActionPerformed
        System.out.println("Empleados");
//        vistaEmpleados ve = new vistaEmpleados(this, true);
//        ve.setVisible(true);
    vistaEmpleadoB ve = new vistaEmpleadoB(this);
    escritorio.add(ve);
    ve.show();
    }//GEN-LAST:event_jmiEmpleadosActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        vistaCategoria vc = new vistaCategoria(this, true);
        vc.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        vistaGestion vg = new vistaGestion(this);
        escritorio.add(vg);
        vg.show();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        vistaArticulosB p = new vistaArticulosB(this);
        escritorio.add(p);
        p.show();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        System.out.println("Zonas");
        vistaZona vz = new vistaZona(this, true);
        vz.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        vistaMarca vma = new vistaMarca(this, true);
        vma.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenu jmArticulos;
    private javax.swing.JMenu jmPersonal;
    private javax.swing.JMenuItem jmiDepartamento;
    private javax.swing.JMenuItem jmiEmpleados;
    private javax.swing.JPanel jpCentro;
    private javax.swing.JPanel jpPrincipal;
    // End of variables declaration//GEN-END:variables
}
