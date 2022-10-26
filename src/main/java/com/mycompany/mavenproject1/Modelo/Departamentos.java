package com.mycompany.mavenproject1.Modelo;

/**
 *
 * @author infraver
 */
public class Departamentos {
    
    private int idDepartamento;
    private String nombreDepartamento;

    public Departamentos() {
    }

    public Departamentos(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
    

    public Departamentos(int idDepartamento, String nombreDepartamento) {
        this.idDepartamento = idDepartamento;
        this.nombreDepartamento = nombreDepartamento;
    }
    

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }
    
    
}
