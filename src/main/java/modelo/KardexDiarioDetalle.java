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
public class KardexDiarioDetalle {
    int id;
    String producto;
    int inicio;
    int aumento;
    int venta;
    int finales;
    String estadoRegistro;

    public KardexDiarioDetalle() {
    }

    public KardexDiarioDetalle(int id, String producto, int inicio, int aumento, int venta, int finales, String estadoRegistro) {
        this.id = id;
        this.producto = producto;
        this.inicio = inicio;
        this.aumento = aumento;
        this.venta = venta;
        this.finales = finales;
        this.estadoRegistro = estadoRegistro;
    }

    public int getId() {
        return id;
    }

    public String getProducto() {
        return producto;
    }

    public int getInicio() {
        return inicio;
    }

    public int getAumento() {
        return aumento;
    }

    public int getVenta() {
        return venta;
    }

    public int getFinales() {
        return finales;
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

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public void setAumento(int aumento) {
        this.aumento = aumento;
    }

    public void setVenta(int venta) {
        this.venta = venta;
    }

    public void setFinales(int finales) {
        this.finales = finales;
    }

    public void setEstadoRegistro(String estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }
    
    
}
