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
public class StockTienda {
    String tienda;
    String producto;
    String Stock;
    String estadoRegistro;

    public StockTienda(String tienda, String producto, String Stock, String estadoRegistro) {
        this.tienda = tienda;
        this.producto = producto;
        this.Stock = Stock;
        this.estadoRegistro = estadoRegistro;
    }

    public StockTienda() {
    }

    public String getTienda() {
        return tienda;
    }

    public String getProducto() {
        return producto;
    }

    public String getStock() {
        return Stock;
    }

    public String getEstadoRegistro() {
        return estadoRegistro;
    }

    public void setTienda(String tienda) {
        this.tienda = tienda;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public void setStock(String Stock) {
        this.Stock = Stock;
    }

    public void setEstadoRegistro(String estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }
    
    
}
