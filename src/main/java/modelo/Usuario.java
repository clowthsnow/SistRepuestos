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
public class Usuario {
    String id;
    String nombres;
    String contra;
    String dni;
    int cargo;
    String estadoRegistro;

    public Usuario(String id, String nombres, String contra, String dni, int cargo, String estadoRegistro) {
        this.id = id;
        this.nombres = nombres;
        this.contra = contra;
        this.dni = dni;
        this.cargo = cargo;
        this.estadoRegistro = estadoRegistro;
    }

    public Usuario() {
        super();
    }

    public String getId() {
        return id;
    }

    public String getNombres() {
        return nombres;
    }

    public String getContra() {
        return contra;
    }

    public String getDni() {
        return dni;
    }

    public int getCargo() {
        return cargo;
    }

    public String getEstadoRegistro() {
        return estadoRegistro;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    public void setEstadoRegistro(String estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }
    
}
