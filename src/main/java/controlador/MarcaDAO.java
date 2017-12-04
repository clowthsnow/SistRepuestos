/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
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
}
