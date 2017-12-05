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
import modelo.Producto;

/**
 *
 * @author Mario-Snow
 */
public class ProductoDAO {
    Conexion conexion;
    
    public ProductoDAO(){
        conexion = new Conexion();
    }
    
    
    public boolean insertarProducto(Producto producto){
        boolean rptaRegistro = false;
        try{
            Connection acceso = conexion.getConexion();
            CallableStatement cs = acceso.prepareCall("INSERT INTO `producto` (`ProductoId`, `ProductoCategoria`, `ProductoOrigen`, `ProductoDescripcion`, `ProductoMarca`, `ProductoRutaImagen`, `ProductoPrecio` ) VALUES (?, ?, ?, ?, ?, ?, ?);");
            cs.setString(1, producto.getId());
            cs.setInt(2, producto.getCategoria());
            cs.setInt(3, producto.getOrigen());
            cs.setString(4, producto.getDescripcion());
            cs.setString(5, producto.getMarca());
            cs.setString(6, producto.getRutaImagen());
            cs.setDouble(7, producto.getPrecio());
            
            int numFAfectadas = cs.executeUpdate();
            if(numFAfectadas > 0)
                rptaRegistro = true;
            acceso.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rptaRegistro;
    }
    
    public boolean modificarProducto(Producto producto){
        boolean rptaRegistro = false;
        try{
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("UPDATE  `producto` SET  `ProductoCategoria` =  ?,`ProductoOrigen` =  ?,`ProductoDescripcion` =  ?,`ProductoMarca` =  ?,`ProductoRutaImagen` =  ?,`ProductoPrecio` =  ? WHERE  `USUARIO`.`ProductoId` =?");
            cs.setInt(1, producto.getCategoria());
            cs.setInt(2, producto.getOrigen());
            cs.setString(3, producto.getDescripcion());
            cs.setString(4, producto.getMarca());
            cs.setString(5, producto.getRutaImagen());
            cs.setDouble(6, producto.getPrecio());
            cs.setString(7, producto.getId());
            
            int numFAfectadas = cs.executeUpdate();
            if(numFAfectadas > 0)
                rptaRegistro = true;
            accesoDB.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rptaRegistro;
    }
    
    public boolean eliminarProducto(Producto producto){
        Boolean rptaRegistro = false;
        try{
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("UPDATE  `producto` SET  `ProductoEstReg` =  '*' WHERE  `ProductoId` =?");
            cs.setString(1,producto.getId());
            int numFAfectadas = cs.executeUpdate();
            if(numFAfectadas > 0)
                rptaRegistro = true;
            accesoDB.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rptaRegistro;
    }
    
    public ArrayList<Producto> listarProducto(){
       
        ArrayList listaProducto = new ArrayList();
        Producto producto;
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement("Select * from producto");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                producto = new Producto();
                producto.setId(rs.getString(1));
                producto.setCategoria(rs.getInt(2));
                producto.setOrigen(rs.getInt(3));
                producto.setDescripcion(rs.getString(4));
                producto.setMarca(rs.getString(5));
                producto.setRutaImagen(rs.getString(6));
                producto.setPrecio(rs.getDouble(7));
                producto.setEstadoRegistro(rs.getString(8));
                
                listaProducto.add(producto);
            }
            accesoDB.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaProducto;
    }
}
