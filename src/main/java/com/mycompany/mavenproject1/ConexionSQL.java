/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author infraver
 */
public class ConexionSQL {

    public Connection conn = null;

    String dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=inventarioALO;encrypt=true;trustServerCertificate=true;";
    String sUsuario = "sa";
    String sPassword = "Josue*10";

    public void connectDB() {

        try {
            this.conn = DriverManager.getConnection(this.dbUrl + "user=" + this.sUsuario + ";password=" + this.sPassword);
            System.out.println("conectado.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void checkConnection() {
        if (this.conn == null) {
            this.connectDB();
        }
    }

    public Connection getConnection() {
        return this.conn;
    }

}
