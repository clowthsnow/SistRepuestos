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
public class Marca {
    String id;
    String descripcion;
    String estadoRegistro;

    public Marca(String id, String descripcion, String estadoRegistro) {
        this.id = id;
        this.descripcion = descripcion;
        this.estadoRegistro = estadoRegistro;
    }

    public String getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstadoRegistro() {
        return estadoRegistro;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstadoRegistro(String estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }
}
