/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//import com.mysql.jdbc.Connection;
import java.util.ArrayList;
import modelo.Cliente;
import modelo.Conexion;
import modelo.Proveedor;
import controlador.ProveedorDAO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rodrigo
 */
public class ProveedorTest {
    
    public ProveedorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    //@Test
    public void prospecto() {
        String ruc="0";
	String razonSocial="jose";
        String direccion="SMP";
	String correo="libra5100@hotmail.com";
	String telefono="5342031";

		
	Proveedor proveedor= new Proveedor(ruc,razonSocial,direccion,correo,telefono);
		
	assertTrue(proveedor.getRUC().equals(ruc));
	assertTrue(proveedor.getRazonSocial().equals(razonSocial));
	assertTrue(proveedor.getDireccion().equals(direccion));
	assertTrue(proveedor.getCorreo().equals(correo));
	assertTrue(proveedor.getTelefono().equals(telefono));;
	}

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void insertarProveedor(){
        Proveedor proveedor = new Proveedor("88888","aqp","direccion","aqp@gmail.com","123456");
	ProveedorDAO proveedorDAO = new ProveedorDAO();
        Assert.assertTrue(proveedorDAO.insertarProveedor(proveedor));
    }
    @Test
    public void modificarProveedor(){
        Proveedor proveedor = new Proveedor("88888","aqp","direccion","aqp@gmail.com","123456");
	ProveedorDAO proveedorDAO = new ProveedorDAO();
        if(proveedorDAO.buscarProveedor(proveedor.getRUC())!=null){
           String nuevoValor="12345678";
           Assert.assertTrue(proveedorDAO.modificarProveedor("88888","aqp123","direccion","aqp@gmail.com","123456"));
        }else{
           System.out.println("No existe el usuario");
        }
    }
    @Test
    public void eliminarProveedor(){
        Proveedor proveedor = new Proveedor("88888","aqp","direccion","aqp@gmail.com","123456");
	ProveedorDAO proveedorDAO = new ProveedorDAO();
        Assert.assertTrue(proveedorDAO.eliminarProveedor(proveedor));
    }
    @Test
    public void listarProveedores(){
        ProveedorDAO proveedorDAO = new ProveedorDAO();
        try{
            ArrayList<Proveedor> proveedores=proveedorDAO.listarProveeedor();
            assertTrue(proveedores.size()>0);
        }catch(Exception e){
            Assert.fail("Falló el listado: " + e.getMessage());
        }
    }
    public void estavacio(){
        ArrayList<Proveedor> proveedores=new ArrayList<Proveedor>();
        Assert.assertNotNull(proveedores);
    }
}
