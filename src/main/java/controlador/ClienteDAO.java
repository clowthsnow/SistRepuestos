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
import modelo.Cliente;
/**
 *
 * @author Liliana
 */
public class ClienteDAO {
    Conexion conexion;
    final String INSERT = "INSERT INTO cliente(ClienteId, ClienteNombre, ClienteDireccion, ClienteCorreo, ClienteTelefono, ClienteEstReg) VALUES (?, ?, ?, ?, ?,?)";
    final String UPDATE = "UPDATE cliente SET ClienteNombre = ?, ClienteDireccion = ?, ClienteCorreo = ?, ClienteTelefono = ? , ClienteEstReg = ? WHERE ClienteId=?";
    final String DELETE = "UPDATE  cliente SET  ClienteEstReg =  'I' WHERE ClienteId =?";
    final String GETALL = "";
    
    
    public ClienteDAO(){
        conexion = new Conexion();
    }
    
    public boolean agregarCliente(Cliente cliente){
        Boolean q=false;
        
        try{
            
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(INSERT);
            cs.setString(1, cliente.getDni());
            cs.setString(2, cliente.getNombre());
            cs.setString(3, cliente.getDireccion());
            cs.setString(4, cliente.getCorreo());
            cs.setString(5, cliente.getTelefono());
            cs.setString(6, "A");
                    
            int numFAfectadas = cs.executeUpdate();
            if(numFAfectadas > 0)
                q=true;
            accesoDB.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return q;
    }
    public boolean modificarCliente(Cliente cliente){
        Boolean q=false;
        
        try{
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("UPDATE cliente SET ClienteNombre = ?, ClienteDireccion = ?, ClienteCorreo = ?, ClienteTelefono = ? , ClienteEstReg = ? WHERE ClienteId=?;");
            cs.setString(1, cliente.getNombre());
            cs.setString(2, cliente.getDireccion());
            cs.setString(3, cliente.getCorreo());
            cs.setString(4, cliente.getTelefono());
            cs.setString(5, "A");
            cs.setString(6, cliente.getDni());
            
            int numFAfectadas = cs.executeUpdate();
            if(numFAfectadas > 0)
                q=true;
            accesoDB.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return q;
    }
    public boolean eliminarCliente(Cliente cliente){
        Boolean q=false;
        try{
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("UPDATE  cliente SET  ClienteEstReg =  'I' WHERE ClienteId =?");
            cs.setString(1, cliente.getDni());
            
            int numFAfectadas = cs.executeUpdate();
            if(numFAfectadas > 0)
                q = true;
            accesoDB.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return q;
    }
    
    public ArrayList<Cliente> listarCliente(){
        ArrayList listaCliente = new ArrayList();
        Cliente cliente;
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement("Select * from CLIENTE");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                cliente = new Cliente();
                cliente.setDni(rs.getString(1));
                cliente.setNombre(rs.getString(2));
                cliente.setDireccion(rs.getString(3));
                cliente.setCorreo(rs.getString(4));
                cliente.setTelefono(rs.getString(5));
                
                
                listaCliente.add(cliente);
            }
            accesoDB.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaCliente;
    }   

    }
   
    
