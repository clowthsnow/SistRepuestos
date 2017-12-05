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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;
import modelo.Proveedor;

/**
 *
 * @author Rodrigo
 */
public class ProveedorDAO {
    Conexion conexion;
    public ProveedorDAO(){
        conexion = new Conexion();
    }
    public Proveedor buscarProveedor(String codigo){
        Proveedor proveedor = null;
        Connection acceso = conexion.getConexion();
        try{
            PreparedStatement ps = acceso.prepareStatement("select * from PROVEEDOR where ProveedorId=?");
            ps.setString(1, codigo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                proveedor = new Proveedor();
                proveedor.setRUC(rs.getString(1));
                proveedor.setRazonSocial(rs.getString(2));
                proveedor.setDireccion(rs.getString(3));
                proveedor.setCorreo(rs.getString(4));
                proveedor.setTelefono(rs.getString(5));
                return proveedor;
            }
            acceso.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return proveedor;
    }
    public void insertarProveedor2(Proveedor proveedor){
        try{
            Connection cn = conexion.getConexion();
            String sql="INSERT INTO `repuestos`.`PROVEEDOR` (`ProveedorId`, `ProveedorRazonSocial`, `ProveedorDireccion`, `ProveedorCorreo`, `ProveedorTelefono`) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement pst = cn.prepareCall(sql);
            pst.setString(1, proveedor.getRUC());
            pst.setString(2, proveedor.getRazonSocial());
            pst.setString(3, proveedor.getDireccion());
            pst.setString(4, proveedor.getCorreo());
            pst.setString(5, proveedor.getTelefono());
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"SE HA REGISTRADO UN NUEVO PROVEEDOR");
            
            pst.close();
            cn.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public void modificarProveedor2(Proveedor proveedor,String codigo){
        try{
            Connection cn = conexion.getConexion();
            
            String sql="UPDATE `proveedor` SET `ProveedorId` = ?, `ProveedorRazonSocial` = ?, `ProveedorDireccion` = ?, `ProveedorCorreo` = ?, `ProveedorTelefono` = ? WHERE `proveedor`.`ProveedorId` = "+codigo+";";
            PreparedStatement pst = cn.prepareCall(sql);
            pst.setString(1, proveedor.getRUC());
            pst.setString(2, proveedor.getRazonSocial());
            pst.setString(3, proveedor.getDireccion());
            pst.setString(4, proveedor.getCorreo());
            pst.setString(5, proveedor.getTelefono());
            //pst.setString(6, codigo);
            System.out.print(pst);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"SE HA MODIFICADO CORRECTAMENTE");
            
            pst.close();
            cn.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public boolean insertarProveedor(Proveedor proveedor) {
         Boolean q=false;
        try{
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("INSERT INTO `repuestos`.`PROVEEDOR` (`ProveedorId`, `ProveedorRazonSocial`, `ProveedorDireccion`, `ProveedorCorreo`, `ProveedorTelefono`) VALUES (?, ?, ?, ?, ?);");
            cs.setString(1, proveedor.getRUC());
            cs.setString(2, proveedor.getRazonSocial());
            cs.setString(3, proveedor.getDireccion());
            cs.setString(4, proveedor.getCorreo());
            cs.setString(5, proveedor.getTelefono());
            
            int numFAfectadas = cs.executeUpdate();
            if(numFAfectadas > 0)
                q=true;
            accesoDB.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return q;
    }

    public boolean modificarProveedor(Proveedor proveedor) {
        Boolean rptaRegistro = false;
        try{
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("UPDATE  `repuestos`.`PROVEEDOR` SET  `ProveedorId` = ?,`ProveedorRazonSocial` =  ?,`ProveedorDireccion` =  ?,`ProveedorCorreo` =  ?,'ProveedorTelefono' = ? WHERE  `PROVEEDOR`.`ProveedorId` =?");
            cs.setString(1, proveedor.getRUC());
            cs.setString(2, proveedor.getRazonSocial());
            cs.setString(3, proveedor.getDireccion());
            cs.setString(4, proveedor.getCorreo());
            cs.setString(5, proveedor.getTelefono());
            
            int numFAfectadas = cs.executeUpdate();
            if(numFAfectadas > 0)
                rptaRegistro=true;
            accesoDB.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rptaRegistro;
    }

    public boolean eliminarProveedor(Proveedor proveedor) {
        Boolean rptaRegistro = false;
        try{
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("UPDATE  `repuestos`.`PROVEEDOR` SET  `ProveedorEstReg` =  'I' WHERE  `PROVEEDOR`.`ProveedorId` =?");
            cs.setString(1, proveedor.getRUC());
            int numFAfectadas = cs.executeUpdate();
            if(numFAfectadas > 0)
                rptaRegistro = true;
            accesoDB.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rptaRegistro;
    }
    public ArrayList<Proveedor> listarProveeedor(){
        ArrayList listaProveedor = new ArrayList();
        Proveedor proveedor;
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement("Select * from PROVEEDOR");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                proveedor = new Proveedor();
                proveedor.setRUC(rs.getString(1));
                proveedor.setRazonSocial(rs.getString(2));
                proveedor.setDireccion(rs.getString(3));
                proveedor.setCorreo(rs.getString(4));
                proveedor.setTelefono(rs.getString(5));
                listaProveedor.add(proveedor);
            }
            accesoDB.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaProveedor;
    }   

    public boolean modificarProveedor(String ruc, String razonSocial, String direccion, String correo, String telefono) {
        Boolean rptaRegistro = false;
        try{
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("UPDATE  `repuestos`.`PROVEEDOR` SET  `ProveedorId` = ?,`ProveedorRazonSocial` =  ?,`ProveedorRazonSocial` =  ?,`ProveedorCorreo` =  ?,'ProveedorTelefono'=? WHERE  `PROVEEDOR`.`ProveedorId` =?");
            cs.setString(1, ruc);
            cs.setString(2, razonSocial);
            cs.setString(3, direccion);
            cs.setString(4, correo);
            cs.setString(5, telefono);
            
            int numFAfectadas = cs.executeUpdate();
            if(numFAfectadas > 0)
                rptaRegistro=true;
            accesoDB.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rptaRegistro;
    }
}
