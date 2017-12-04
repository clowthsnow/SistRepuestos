/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class Origen {
    private String codigo;
    private String descripcion;

    public Origen(String text, String text0) {
         if(text.equalsIgnoreCase("") || text0.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null,"Datos incompletos.");
            return;
        }
        this.codigo=text;
        this.descripcion=text0;
    }

    public Origen() {
        this.codigo=null;
        this.descripcion=null;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
