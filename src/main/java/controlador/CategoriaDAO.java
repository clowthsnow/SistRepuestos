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
import modelo.Categoria;
import modelo.Cliente;
/**
 *
 * @author Liliana
 */
public class CategoriaDAO {
    Conexion conexion;
    
    public CategoriaDAO(){
        conexion = new Conexion();
    }
    
    public String agregarCategoria(Categoria categoria){
         String rptaRegistro = null;
        
        try{
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("INSERT INTO categoria(CategoriaId, CategoriaDescripcion, CategoriaEstReg) VALUES (?, ?, ?);");
            cs.setString(1, categoria.getCodigo());
            cs.setString(2, categoria.getDescripcion());
            cs.setString(3, "A");
                    
            int numFAfectadas = cs.executeUpdate();
            if(numFAfectadas > 0)
                rptaRegistro = "Modificación exitosa.";
            accesoDB.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rptaRegistro;
    }
    public String modificarCategoria(Categoria categoria){
        String rptaRegistro = null;
        
        try{
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("UPDATE categoria SET CategoriaDescripcion = ? WHERE CategoriaCodigo=?;");
            cs.setString(1, categoria.getDescripcion());
            cs.setString(2, "A");
            cs.setString(3, categoria.getCodigo());
            
            int numFAfectadas = cs.executeUpdate();
            if(numFAfectadas > 0)
                rptaRegistro = "Modificación exitosa.";
            accesoDB.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rptaRegistro;
    }
    public String eliminarCategoria(Categoria categoria){
        String rptaRegistro = null;
        try{
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("UPDATE  categoria SET  CategoriaEstReg =  'I' WHERE CategoriaCodigo =?");
            cs.setString(1, categoria.getCodigo());
            
            int numFAfectadas = cs.executeUpdate();
            if(numFAfectadas > 0)
                rptaRegistro = "Eliminación exitosa.";
            accesoDB.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rptaRegistro;
    }
    
    public ArrayList<Categoria> listarCategoria(){
        ArrayList listaCategoria = new ArrayList();
        Categoria categoria;
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement("Select * from CATEGORIA");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                categoria = new Categoria();
                categoria.setCodigo(rs.getString(1));
                categoria.setDescripcion(rs.getString(2));    
                
                listaCategoria.add(categoria);
            }
            accesoDB.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaCategoria;
    }   
    }
   
    

        
    


