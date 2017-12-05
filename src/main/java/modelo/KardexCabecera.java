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
public class KardexCabecera {
    int id;
    int estado;
    String estadoRegistro;

    public KardexCabecera() {
    }

    public KardexCabecera(int id, int estado, String estadoRegistro ) {
        this.id = id;
        this.estado = estado;
        this.estadoRegistro = estadoRegistro;
    }

    public int getId() {
        return id;
    }

    public int getEstado() {
        return estado;
    }

    public String getEstadoRegistro() {
        return estadoRegistro;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setEstadoRegistro(String estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }
    
}
