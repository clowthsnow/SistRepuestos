/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;
/**
 *
 * @author Mario-Snow
 */
public class KardexDiarioCabecera {
    int id;
    Date fecha;
    String usuario;
    String estadoRegistro;

    public KardexDiarioCabecera() {
    }

    public KardexDiarioCabecera(int id, Date fecha, String usuario, String estadoRegistro) {
        this.id = id;
        this.fecha = fecha;
        this.usuario = usuario;
        this.estadoRegistro = estadoRegistro;
    }

    public int getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getEstadoRegistro() {
        return estadoRegistro;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setEstadoRegistro(String estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }
    
    
}
