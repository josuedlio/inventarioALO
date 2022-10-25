/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.mavenproject1;

import com.mycompany.mavenproject1.Vista.vistaPrincipal;

/**
 *
 * @author infraver
 */
public class Ejecutar {

    public static void main(String[] args) {
        vistaPrincipal vp = new vistaPrincipal();
        ConexionSQL c = new ConexionSQL();
        c.connectDB();
        vp.setExtendedState(vp.MAXIMIZED_BOTH);
        vp.setVisible(true);
    }
}
