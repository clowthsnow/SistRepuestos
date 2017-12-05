/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author carlos
 */
public class Tienda {
  private String tiendaId;
  private String tiendaDescripcion;
  private String tiendaEstReg;
  
  public Tienda(){
  }
  
  public Tienda(String tiendaId, String tiendaDescripcion, String tiendaEstReg  ){
      this.tiendaId = tiendaId;
      this.tiendaDescripcion = tiendaDescripcion;
      this.tiendaEstReg = tiendaEstReg;
  }

    public String getTiendaId() {
        return tiendaId;
    }

    public void setTiendaId(String tiendaId) {
        this.tiendaId = tiendaId;
    }

    public String getTiendaDescripcion() {
        return tiendaDescripcion;
    }

    public void setTiendaDescripcion(String tiendaDescripcion) {
        this.tiendaDescripcion = tiendaDescripcion;
    }

    public String getTiendaEstReg() {
        return tiendaEstReg;
    }

    public void setTiendaEstReg(String tiendaEstReg) {
        this.tiendaEstReg = tiendaEstReg;
    }
  
  
}
