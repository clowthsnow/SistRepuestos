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
public class KardexDetalle {
    int id;
    String producto;
    int stock;
    String estadoRegistro;

    public KardexDetalle() {
    }

    public KardexDetalle(int id, String producto, int stock, String estadoRegistro) {
        this.id = id;
        this.producto = producto;
        this.stock = stock;
        this.estadoRegistro = estadoRegistro;
    }

    public int getId() {
        return id;
    }

    public String getProducto() {
        return producto;
    }

    public int getStock() {
        return stock;
    }

    public String getEstadoRegistro() {
        return estadoRegistro;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setEstadoRegistro(String estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }
    
}
