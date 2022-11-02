package com.mycompany.mavenproject1;

import com.mycompany.mavenproject1.Vista.vistaPrincipal;

/**
 *
 * @author infraver
 */
public class Ejecutar {

    public static void main(String[] args) {
      
        vistaPrincipal vp = new vistaPrincipal();
        
        vp.setExtendedState(vp.MAXIMIZED_BOTH);
        vp.setVisible(true);
    }
}
