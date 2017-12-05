/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.sql.*;
import java.util.ArrayList;
import modelo.Conexion;
import modelo.Usuario;

public class UsuarioDAO {

    Conexion conexion;
    
    public UsuarioDAO(){
        conexion = new Conexion();
    }
    
    public Usuario verificarUsuario(String codigo, String password){
        Usuario usuario = null;
        Connection acceso = conexion.getConexion();
        try{
            PreparedStatement ps = acceso.prepareStatement("select * from USUARIO where UsuarioId=? and UsuarioContra=?");
            ps.setString(1, codigo);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                usuario = new Usuario();
                usuario.setCodigo(rs.getString(1));
                usuario.setNombre(rs.getString(2));
                usuario.setContraseña(rs.getString(3));
                usuario.setDNI(rs.getString(4));
                usuario.setCargo(rs.getString(5));
                usuario.setEstRegistro(rs.getString(6));
                return usuario;
            }
            acceso.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return usuario;
    }
    public Boolean insertUsuario(Usuario usuario) {
        Boolean q=false;
        try{
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("INSERT INTO `repuestos`.`USUARIO` (`UsuarioId`, `UsuarioNombre`, `UsuarioContra`, `UsuarioDNI`, `UsuarioCargo`,`UsuarioEstReg`) VALUES (?, ?, ?, ?, ?, ?);");
            cs.setString(1, usuario.getCodigo());
            cs.setString(2, usuario.getNombre());
            cs.setString(3, usuario.getContraseña());
            cs.setString(4, usuario.getDNI());
            cs.setString(5, usuario.getCargo());
            cs.setString(6, usuario.getEstRegistro());
            
            int numFAfectadas = cs.executeUpdate();
            if(numFAfectadas > 0)
                q=true;
            accesoDB.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return q;
    }
    public Boolean modificarUsuario(Usuario usuario){
        Boolean rptaRegistro = false;
        try{
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("UPDATE  `repuestos`.`USUARIO` SET  `UsuarioId` = ?,`UsuarioNombre` =  ?,`UsuarioContra` =  ?,`UsuarioDNI` =  ?,'UsuarioCargo' =?,'UsuarioEstReg' =? WHERE  `USUARIO`.`UsuarioId` =?");
            cs.setString(1, usuario.getCodigo());
            cs.setString(2, usuario.getNombre());
            cs.setString(3, usuario.getContraseña());
            cs.setString(4, usuario.getDNI());
            cs.setString(5, usuario.getCargo());
            cs.setString(6, usuario.getEstRegistro());
            cs.setString(7, usuario.getCodigo());
            
            int numFAfectadas = cs.executeUpdate();
            if(numFAfectadas > 0)
                rptaRegistro=true;
            accesoDB.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rptaRegistro;
    }
    
    public boolean eliminarUsuario(Usuario usuario){
        boolean rptaRegistro = false;
        try{
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("UPDATE  `repuestos`.`USUARIO` SET  `UsuarioEstReg` =  'I' WHERE  `USUARIO`.`UsuarioId` =?");
            cs.setString(1, usuario.getCodigo());
            
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
            PreparedStatement ps = accesoDB.prepareStatement("Select * from USUARIO");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                usuario = new Usuario();
                usuario.setCodigo(rs.getString(1));
                usuario.setNombre(rs.getString(2));
                usuario.setContraseña(rs.getString(3));
                usuario.setDNI(rs.getString(4));
                usuario.setCargo(rs.getString(5));
                usuario.setEstRegistro(rs.getString(6));
                listaUsuario.add(usuario);
            }
            accesoDB.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaUsuario;
    }
}
