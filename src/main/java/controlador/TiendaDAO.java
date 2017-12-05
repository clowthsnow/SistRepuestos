/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Conexion;
import modelo.Tienda;

/**
 *
 * @author carlos
 */
public class TiendaDAO {
    Conexion conexion;
    final String BUSCAR = "select * from TIENDA where TiendaId=?";
    final String INSERTAR = "INSERT INTO `repuestos`.`tienda`(`TiendaId`, `TiendaDescripcion`, `TiendaEstReg`) VALUES (?,?,?)";
    final String UPDATE = "UPDATE  `repuestos`.`TIENDA` SET `TiendaDescripcion` =  ? WHERE  `TIENDA`.`TiendaId` =?;";
    final String ELIMINAR = "UPDATE  `repuestos`.`TIENDA` SET  `TiendaEstReg` =  'I' WHERE  `TIENDA`.`TiendaId` =?";
    final String LISTAR = "SELECT * FROM `tienda`";
    
    public TiendaDAO(){
        conexion = new Conexion();
    }
    public Tienda buscarTienda(String codigo){
        Tienda tienda = null;
        Connection acceso = conexion.getConexion();
        try{
            PreparedStatement ps = acceso.prepareStatement(BUSCAR);
            ps.setString(1, codigo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                tienda = new Tienda();
                tienda.setTiendaId(rs.getString(1));
                tienda.setTiendaDescripcion(rs.getString(2));
                return tienda;
            }
            acceso.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return tienda; 
    }
    public  ArrayList<Tienda> listarTienda(){
        ArrayList<Tienda> listaTienda = new ArrayList();
        Tienda tienda;
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(LISTAR);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                tienda = new Tienda();
                tienda.setTiendaId(rs.getString(1));
                tienda.setTiendaDescripcion(rs.getString(2));
                listaTienda.add(tienda);
            }
            accesoDB.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaTienda;
    }

    public boolean insertarTienda(Tienda tienda) {
        Boolean q=false;
        try{
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(INSERTAR);
            cs.setString(1, tienda.getTiendaId());
            cs.setString(2, tienda.getTiendaDescripcion());
            cs.setString(3, tienda.getTiendaEstReg());
            
            int numFAfectadas = cs.executeUpdate();
            if(numFAfectadas > 0)
                q=true;
            accesoDB.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return q;
    }
    public boolean modificarTienda(Tienda tienda) {
        Boolean rptaRegistro = false;
        try{
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(UPDATE);
            cs.setString(1, tienda.getTiendaDescripcion());
            cs.setString(2, tienda.getTiendaId());
            int numFAfectadas = cs.executeUpdate();
            if(numFAfectadas > 0)
                rptaRegistro=true;
            accesoDB.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rptaRegistro;
    }
    
    public boolean eliminarTienda(Tienda tienda) {
        Boolean rptaRegistro = false;
        try{
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(ELIMINAR);
            cs.setString(1, tienda.getTiendaId());
            int numFAfectadas = cs.executeUpdate();
            if(numFAfectadas > 0)
                rptaRegistro = true;
            accesoDB.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rptaRegistro;
    }
    public boolean eliminarTienda2(Tienda tienda) {
        Boolean rptaRegistro = false;
        try{
            Connection accesoDB = conexion.getConexion();
            //String eliminarSQL="DELETE FROM ORIGEN WHERE OrigenId = '"+origen.getCodigo()+"'";
            CallableStatement cs = accesoDB.prepareCall("DELETE FROM `tienda` WHERE TiendaId = `"+tienda.getTiendaId() + "`");
            //cs.setString(1, origen.getCodigo());
            int numFAfectadas = cs.executeUpdate();
            if(numFAfectadas > 0)
                rptaRegistro = true;
            accesoDB.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rptaRegistro;
    }
}
