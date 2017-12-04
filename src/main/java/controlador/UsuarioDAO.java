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
import java.util.HashSet;
import modelo.Conexion;
import modelo.Usuario;

/**
 *
 * @author Mario-Snow
 */
public class UsuarioDAO {
    Conexion conexion;
    
    public UsuarioDAO(){
        conexion = new Conexion();
    }
    
    public Usuario verificarUsuario(String codigo, String password){
        Usuario usuario = null;
        Connection acceso = conexion.getConexion();
        try{
            PreparedStatement ps = acceso.prepareStatement("select * from usuario where UsuarioId=? and UsuarioContra=?");
            ps.setString(1, codigo);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                usuario = new Usuario();
                usuario.setId(rs.getString(1));
                usuario.setNombres(rs.getString(2));
                usuario.setContra(rs.getString(3));
                usuario.setCargo(rs.getInt(4));
                usuario.setEstadoRegistro(rs.getString(5));
                return usuario;
            }
            acceso.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return usuario;
    }
    public boolean insertUsuario(Usuario usuario){
        boolean rptaRegistro = false;
        try{
            Connection acceso = conexion.getConexion();
            CallableStatement cs = acceso.prepareCall("INSERT INTO `usuario` (`UsuarioId`, `UsuarioNombre`, `UsuuarioContra`, `UsuarioDNI`, `UsuarioCargo` ) VALUES (?, ?, ?, ?, ?);");
            cs.setString(1, usuario.getId());
            cs.setString(2, usuario.getNombres());
            cs.setString(3, usuario.getContra());
            cs.setString(4, usuario.getDni());
            cs.setInt(5, usuario.getCargo());
            
            int numFAfectadas = cs.executeUpdate();
            if(numFAfectadas > 0)
                rptaRegistro = true;
            acceso.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rptaRegistro;
    }
    
    public boolean modificarUsuario(Usuario usuario){
        boolean rptaRegistro = false;
        try{
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("UPDATE  `usuario` SET  `UsuarioNombre` = ?,`UsuarioContra` =  ?,`UsuarioDNI` =  ?,`UsuarioCargo` =  ? WHERE  `USUARIO`.`UsuarioId` =?");
            cs.setString(1, usuario.getNombres());
            cs.setString(2, usuario.getContra());
            cs.setString(3, usuario.getDni());
            cs.setInt(4, usuario.getCargo());
            cs.setString(5, usuario.getId());
            
            int numFAfectadas = cs.executeUpdate();
            if(numFAfectadas > 0)
                rptaRegistro = true;
            accesoDB.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rptaRegistro;
    }
    
    public boolean eliminarUsuario(Usuario usuario){
        Boolean rptaRegistro = false;
        try{
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("UPDATE  `usuario` SET  `UsuarioEstReg` =  '*' WHERE  `USUARIO`.`UsuarioId` =?");
            cs.setString(1,usuario.getId());
            int numFAfectadas = cs.executeUpdate();
            if(numFAfectadas > 0)
                rptaRegistro = true;
            accesoDB.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rptaRegistro;
    }
    
    public ArrayList<Usuario> listarUsuario(){
       
        ArrayList listaUsuario = new ArrayList();
        Usuario usuario;
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement("Select * from usuario");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                usuario = new Usuario();
                usuario.setId(rs.getString(1));
                usuario.setNombres(rs.getString(2));
                usuario.setContra(rs.getString(3));
                usuario.setDni(rs.getString(4));
                usuario.setCargo(rs.getInt(5));
                usuario.setEstadoRegistro(rs.getString(6));
                listaUsuario.add(usuario);
            }
            accesoDB.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaUsuario;
    }
}
