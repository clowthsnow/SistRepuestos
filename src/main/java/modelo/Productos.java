/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Mario-Snow
 */
public class Productos {
    String id;
    int categoria;
    int origen;
    String descripcion;
    double precio;
    String estadoRegistro;

    public Productos(String id, int categoria, int origen, String descripcion, double precio, String estadoRegistro) {
        this.id = id;
        this.categoria = categoria;
        this.origen = origen;
        this.descripcion = descripcion;
        this.precio = precio;
        this.estadoRegistro = estadoRegistro;
    }

    public String getId() {
        return id;
    }

    public int getCategoria() {
        return categoria;
    }

    public int getOrigen() {
        return origen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public String getEstadoRegistro() {
        return estadoRegistro;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public void setOrigen(int origen) {
        this.origen = origen;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setEstadoRegistro(String estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }
        
}
