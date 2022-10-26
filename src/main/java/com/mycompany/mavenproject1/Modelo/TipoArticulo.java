
package com.mycompany.mavenproject1.Modelo;

public class TipoArticulo {
    private int idArticulo;
    private String nombreTipo;

    public TipoArticulo() {
    }

    public TipoArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }
    

    public TipoArticulo(int idArticulo, String nombreTipo) {
        this.idArticulo = idArticulo;
        this.nombreTipo = nombreTipo;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }
    
    
}
