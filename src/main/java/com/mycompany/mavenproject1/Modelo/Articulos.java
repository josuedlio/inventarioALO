package com.mycompany.mavenproject1.Modelo;

public class Articulos {
    private int idArticulo;
    private String descrip;
    private String modelo;
    private String marca;
    private int idTipo;

    public Articulos() {
    }

    public Articulos(int idArticulo) {
        this.idArticulo = idArticulo;
    }
    

    public Articulos(int idArticulo, String descrip, String modelo, String marca, int idTipo) {
        this.idArticulo = idArticulo;
        this.descrip = descrip;
        this.modelo = modelo;
        this.marca = marca;
        this.idTipo = idTipo;
    }
    

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }
    
    
    
}
