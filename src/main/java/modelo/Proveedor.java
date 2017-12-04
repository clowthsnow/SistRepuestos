/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Rodrigo
 */
public class Proveedor {
    
    private String RUC;
    private String razonSocial;
    private String direccion;
    private String correo;
    private String telefono;
    
    public Proveedor(String RUC, String razonSocial, String direccion, String correo, String telefono) {
        this.RUC = RUC;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Proveedor() {
       
    }
    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
}
