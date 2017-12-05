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
import modelo.StockTienda;

/**
 *
 * @author Mario-Snow
 */
public class StockTiendaDAO {
    Conexion conexion;
    
    public StockTiendaDAO(){
        conexion = new Conexion();
    }
    
    public Boolean insertarStockTienda(StockTienda stockTienda) {
        Boolean q=false;
        try{
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("INSERT INTO `repuestos`.`STOCKTIENDA` (`StockTienda`, `StockTiendaProducto`, `StockTiendaStock`, `StockTiendaEstReg`) VALUES (?, ?, ?, ?);");
            cs.setString(1, stockTienda.getTienda());
            cs.setString(2, stockTienda.getProducto());
            cs.setString(3, stockTienda.getStock());
            cs.setString(4, stockTienda.getEstadoRegistro());
            
            int numFAfectadas = cs.executeUpdate();
            if(numFAfectadas > 0)
                q=true;
            accesoDB.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return q;
    }
    public Boolean modificarUsuario(StockTienda stockTienda){
        Boolean rptaRegistro = false;
        try{
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("UPDATE  `repuestos`.`STOCKTIENDA` SET  `StockTiendaStock` =  ?,`StockTiendaEstReg` =  ? WHERE  `STOCKTIENDA`.`StockTienda` =? AND `StockTiendaProducto` =  ?");
            cs.setString(1, stockTienda.getStock());
            cs.setString(2, stockTienda.getEstadoRegistro());
            cs.setString(3, stockTienda.getTienda());
            cs.setString(4, stockTienda.getProducto());
            
            int numFAfectadas = cs.executeUpdate();
            if(numFAfectadas > 0)
                rptaRegistro=true;
            accesoDB.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rptaRegistro;
    }
    
//    public boolean eliminarUsuario(Usuario usuario){
//        boolean rptaRegistro = false;
//        try{
//            Connection accesoDB = conexion.getConexion();
//            CallableStatement cs = accesoDB.prepareCall("UPDATE  `repuestos`.`USUARIO` SET  `UsuarioEstReg` =  'I' WHERE  `USUARIO`.`UsuarioId` =?");
//            cs.setString(1, usuario.getCodigo());
//            
//            int numFAfectadas = cs.executeUpdate();
//            if(numFAfectadas > 0)
//                rptaRegistro = true;
//            accesoDB.close();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return rptaRegistro;
//    }
    
    public ArrayList<StockTienda> listarStockTienda(){
        ArrayList listaStockTienda = new ArrayList();
        StockTienda stocktienda;
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement("Select * from stocktienda");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){

                stocktienda= new StockTienda();
                stocktienda.setTienda(rs.getString(1));
                stocktienda.setProducto(rs.getString(2));
                stocktienda.setProducto(rs.getString(3));
                stocktienda.setEstadoRegistro(rs.getString(4));
                
                listaStockTienda.add(stocktienda);
            }
            accesoDB.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaStockTienda;
    }

}
