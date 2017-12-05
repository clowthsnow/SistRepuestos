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
import modelo.Origen;

/**
 *
 * @author Rodrigo
 */
public class OrigenDAO {
    Conexion conexion;
    
    public OrigenDAO(){
        conexion = new Conexion();
    }
    public Origen buscarOrigen(String codigo){
        Origen origen = null;
        Connection acceso = conexion.getConexion();
        try{
            PreparedStatement ps = acceso.prepareStatement("select * from ORIGEN where OrigenId=?");
            ps.setString(1, codigo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                origen = new Origen();
                origen.setCodigo(rs.getString(1));
                origen.setDescripcion(rs.getString(2));
                return origen;
            }
            acceso.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return origen; 
    }
    public  ArrayList<Origen> listarOrigen(){
        ArrayList<Origen> listaOrigen = new ArrayList();
        Origen origen;
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement("Select * from ORIGEN");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                origen = new Origen();
                origen.setCodigo(rs.getString(1));
                origen.setDescripcion(rs.getString(2));
                listaOrigen.add(origen);
            }
            accesoDB.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaOrigen;
    }

    public boolean insertOrigen(Origen origen) {
        Boolean q=false;
        try{
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("INSERT INTO `repuestos`.`ORIGEN` (`OrigenId`, `OrigenDescripcion`) VALUES (NULL, ?);");
            cs.setString(1, origen.getDescripcion());
            
            int numFAfectadas = cs.executeUpdate();
            if(numFAfectadas > 0)
                q=true;
            accesoDB.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return q;
    }
    public boolean modificarOrigen(Origen origen) {
        Boolean rptaRegistro = false;
        try{
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("UPDATE  `repuestos`.`ORIGEN` SET `OrigenDescripcion` =  ? WHERE  `ORIGEN`.`OrigenId` =?;");
            cs.setString(1, origen.getDescripcion());
            cs.setString(2, origen.getCodigo());
            int numFAfectadas = cs.executeUpdate();
            if(numFAfectadas > 0)
                rptaRegistro=true;
            accesoDB.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rptaRegistro;
    }
    
    public boolean eliminarOrigen(Origen origen) {
        Boolean rptaRegistro = false;
        try{
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("UPDATE  `repuestos`.`ORIGEN` SET  `OrigenEstReg` =  'I' WHERE  `ORIGEN`.`OrigenId` =?");
            cs.setString(1, origen.getCodigo());
            int numFAfectadas = cs.executeUpdate();
            if(numFAfectadas > 0)
                rptaRegistro = true;
            accesoDB.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rptaRegistro;
    }
    public boolean eliminarOrigen2(Origen origen) {
        Boolean rptaRegistro = false;
        try{
            Connection accesoDB = conexion.getConexion();
            //String eliminarSQL="DELETE FROM ORIGEN WHERE OrigenId = '"+origen.getCodigo()+"'";
            CallableStatement cs = accesoDB.prepareCall("DELETE FROM ORIGEN WHERE OrigenId = '"+origen.getCodigo()+"'");
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
