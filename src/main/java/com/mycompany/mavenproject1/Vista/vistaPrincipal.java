package com.mycompany.mavenproject1.Vista;

public class vistaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form vistaPrincipal
     */
    public vistaPrincipal() {
        initComponents();
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPrincipal = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmPersonal = new javax.swing.JMenu();
        jmiDepartamento = new javax.swing.JMenuItem();
        jmiEmpleados = new javax.swing.JMenuItem();
        jmArticulos = new javax.swing.JMenu();
        jmiTipoArticulos = new javax.swing.JMenuItem();
        jmiverArticulos = new javax.swing.JMenuItem();
        jmGestion = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
        jpPrincipal.setLayout(jpPrincipalLayout);
        jpPrincipalLayout.setHorizontalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 753, Short.MAX_VALUE)
        );
        jpPrincipalLayout.setVerticalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 346, Short.MAX_VALUE)
        );

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

        jmiTipoArticulos.setText("Tipo Articulos");
        jmiTipoArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiTipoArticulosActionPerformed(evt);
            }
        });
        jmArticulos.add(jmiTipoArticulos);

        jmiverArticulos.setText("Ver Articulos");
        jmiverArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiverArticulosActionPerformed(evt);
            }
        });
        jmArticulos.add(jmiverArticulos);

        jMenuBar1.add(jmArticulos);

        jmGestion.setText("Administración");
        jmGestion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmGestionMouseClicked(evt);
            }
        });
        jmGestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmGestionActionPerformed(evt);
            }
        });
        jMenuBar1.add(jmGestion);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmPersonalActionPerformed
                                    }//GEN-LAST:event_jmPersonalActionPerformed

    private void jmPersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmPersonalMouseClicked
    }//GEN-LAST:event_jmPersonalMouseClicked

    private void jmiDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiDepartamentoActionPerformed
        System.out.println("Hola");
    }//GEN-LAST:event_jmiDepartamentoActionPerformed

    private void jmiEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEmpleadosActionPerformed
        System.out.println("Empleados");
    }//GEN-LAST:event_jmiEmpleadosActionPerformed

    private void jmiTipoArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiTipoArticulosActionPerformed
        System.out.println("Tipo Articulos");
    }//GEN-LAST:event_jmiTipoArticulosActionPerformed

    private void jmiverArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiverArticulosActionPerformed
        System.out.println("Ver Articulos");
    }//GEN-LAST:event_jmiverArticulosActionPerformed

    private void jmGestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmGestionActionPerformed
        
    }//GEN-LAST:event_jmGestionActionPerformed

    private void jmGestionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmGestionMouseClicked
        System.out.println("Administrar");
    }//GEN-LAST:event_jmGestionMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jmArticulos;
    private javax.swing.JMenu jmGestion;
    private javax.swing.JMenu jmPersonal;
    private javax.swing.JMenuItem jmiDepartamento;
    private javax.swing.JMenuItem jmiEmpleados;
    private javax.swing.JMenuItem jmiTipoArticulos;
    private javax.swing.JMenuItem jmiverArticulos;
    private javax.swing.JPanel jpPrincipal;
    // End of variables declaration//GEN-END:variables
}
