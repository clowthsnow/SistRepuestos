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
public class Producto {
    String id;
    int categoria;
    int origen;
    String descripcion;
    String marca;
    String rutaImagen;
    double precio;
    String estadoRegistro;

    public Producto(String id, int categoria, int origen, String descripcion, String marca, String rutaImagen, double precio, String estadoRegistro) {
        this.id = id;
        this.categoria = categoria;
        this.origen = origen;
        this.descripcion = descripcion;
        this.marca = marca;
        this.rutaImagen = rutaImagen;
        this.precio = precio;
        this.estadoRegistro = estadoRegistro;
    }

    public Producto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getMarca() {
        return marca;
    }

    public String getRutaImagen() {
        return rutaImagen;
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

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
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
