/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import modelo.Origen;
import controlador.OrigenDAO;
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
public class OrigenTest {
    
    public OrigenTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    /*public void insertarOrigen(){
        Origen origen = new Origen("codigo","descripcion");
	OrigenDAO origenDAO = new OrigenDAO();
        Assert.assertTrue(origenDAO.insertOrigen(origen));
    }
    @Test
    public void modificarOrigen(){
        Origen origen = new Origen("codigo","descripcion");
	OrigenDAO origenDAO = new OrigenDAO();
        if(origenDAO.buscarOrigen(origen.getCodigo())!=null){
           String nuevoValor="12345678";
           Assert.assertTrue(origenDAO.modificarOrigen(origen));
        }else{
           System.out.println("No existe el usuario");
        }
    }
    @Test
    public void eliminarOrigen(){
        Origen origen = new Origen("123456830","expa");
	OrigenDAO origenDAO = new OrigenDAO();
        origenDAO.insertOrigen(origen);
        Assert.assertTrue(origenDAO.eliminarOrigen2(origen));
    }
    @Test
    /*public void listarOrigenes(){
        Origen origen = new Origen("codigo","descripcion");
	OrigenDAO origenDAO = new OrigenDAO();
        ProveedorDAO proveedorDAO = new ProveedorDAO();
        try{    
            ArrayList<Proveedor> proveedores=proveedorDAO.listarProveeedor();
            assertTrue(proveedores.size()>0);
        }catch(Exception e){
            Assert.fail("Falló el listado: " + e.getMessage());
        }
    }*/
    public void estavacio(){
        ArrayList<Proveedor> proveedores=new ArrayList<Proveedor>();
        Assert.assertNotNull(proveedores);
    }
}
