/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Rodrigo
 */
public class ClienteDAO {
     Conexion conexion;
    
    public ClienteDAO(){
        conexion = new Conexion();
    }
    public Cliente buscarCliente(String codigo){
        Cliente cliente = null;
        Connection acceso = conexion.getConexion();
        try{
            PreparedStatement ps = acceso.prepareStatement("select * from PROVEEDOR where ProveedorId=?");
            ps.setString(1, codigo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                cliente = new Cliente();
                cliente.setCodigo(rs.getString(1));
                cliente.setNombre(rs.getString(2));
                cliente.setDireccion(rs.getString(3));
                cliente.setCorreo(rs.getString(4));
                cliente.setTelefono(rs.getString(5));
                return cliente;
            }
            acceso.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return cliente;
    }
    public boolean insertCliente(ClienteDAO clienteDAO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean modificarCliente(Cliente usuario, String campo, String informacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean eliminarCliente(Cliente usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}