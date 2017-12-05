/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Liliana
 */
public class Categoria {
    private String codigo;
    private String descripcion;
    //private String estadoRegistro;
    
    public Categoria(){
    }
    public Categoria(String codigo , String descripcion){
        this.codigo = codigo;
        this.descripcion = descripcion;
        //this.estadoRegistro = estado;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String nombre) {
        this.codigo= codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String dni) {
        this.descripcion = descripcion;
    }
    
    /*public String getEstadoRegistro() {
        return estadoRegistro;
    }

    public void setEstadoRegistro(String estado) {
        this.estadoRegistro = estado;*/
    
}
