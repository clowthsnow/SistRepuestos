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
import modelo.Marca;

/**
 *
 * @author Mario-Snow
 */
public class MarcaDAO {
    Conexion conexion;
    
    public MarcaDAO(){
        conexion= new Conexion();
    }
    
    public boolean insertarMarca(Marca marca){
        boolean respuesta=false;
        try{
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("INSERT INTO `marca` (`MarcaId`, `MarcaDescripcion`, `MarcaEstReg`) VALUES ( ?, ?, ?);");
            cs.setString(1, marca.getId());
            cs.setString(2, marca.getDescripcion());
            cs.setString(3, marca.getEstadoRegistro());
            
            int numFAfectadas = cs.executeUpdate();
            if(numFAfectadas > 0)
//                rptaRegistro = "Registro exitoso.";
                respuesta=true;            
            accesoDB.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return respuesta;
    }
   
    public boolean modificarUsuario(Marca marca){
        boolean rptaRegistro = false;
        try{
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("UPDATE  `marca` SET  `MarcaDescripcion` = ? WHERE `MarcaId` =?");
            cs.setString(1, marca.getDescripcion());
            cs.setString(2, marca.getId());
            
            int numFAfectadas = cs.executeUpdate();
            if(numFAfectadas > 0)
                rptaRegistro = true;
            accesoDB.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rptaRegistro;
    }
    
    public boolean eliminarUsuario(Marca marca){
        Boolean rptaRegistro = false;
        try{
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("UPDATE  `marca` SET  `MarcaEstReg` =  '*' WHERE  `MarcaId` =?");
            cs.setString(1, marca.getId());
            int numFAfectadas = cs.executeUpdate();
            if(numFAfectadas > 0)
                rptaRegistro = true;
            accesoDB.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rptaRegistro;
    }
    
    public ArrayList<Marca> listarUsuario(){
       
        ArrayList listaMarca = new ArrayList();
        Marca marca;
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement("Select * from marca");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                marca = new Marca();
                marca.setId(rs.getString(1));
                marca.setDescripcion(rs.getString(2));
                marca.setEstadoRegistro(rs.getString(3));
                listaMarca.add(marca);
            }
            accesoDB.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaMarca;
    }
}
